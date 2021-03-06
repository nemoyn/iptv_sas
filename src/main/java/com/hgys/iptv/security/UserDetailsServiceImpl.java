package com.hgys.iptv.security;

import com.hgys.iptv.model.Authority;
import com.hgys.iptv.model.Role;
import com.hgys.iptv.model.User;
import com.hgys.iptv.repository.RoleRepository;
import com.hgys.iptv.service.SysRoleService;
import com.hgys.iptv.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * 根据 username 获取数据库 user 信息
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private RoleRepository roleRepository;
//    @Autowired
//    private PermissionRepository permissionRepository;

//    public UserDetailsServiceImpl(UserRepository applicationUserRepository) {
//        this.userRepository = applicationUserRepository;
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = (User)sysUserService.findByUserName(username).getData();
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username: %s", username));
        }
        Set<GrantedAuthority> authorities = new HashSet<>();
        getAuthorities(user,authorities);
                //返回包括权限角色的User给security
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.isEnabled(), user.isAccountNonExpired(), user.isCredentialsNonExpired(), user.isAccountNonLocked(), authorities);
    }

    /**
     * 装配角色权限
     * @param user
     * @param authorities
     */
    public void getAuthorities(User user, Set<GrantedAuthority> authorities) {
        List<Role> roles = sysUserService.findAllRoleByUserId(user.getId());
        roles.forEach(role->{
            Role role_ = roleRepository.findById(role.getId()).orElse(null);
            //角色存在且该角色时启用状态
            if(role_!=null && role_.getStatus()==0){
                List<Authority> auths = sysRoleService.findAllAuthorityByRoleId(role_.getId());
                auths.forEach(auth->{
                    if(auth.getStatus()==0)//权限被启用的才被加入授权上下文
                        authorities.add(new SimpleGrantedAuthority(auth.getName()));
                });
            }
        });
    }
}


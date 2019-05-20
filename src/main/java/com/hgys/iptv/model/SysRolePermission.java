package com.hgys.iptv.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @ClassName SysRolePermission
 * @Auther: wangz
 * @Date: 2019/5/16 19:05
 * @Description: TODO
 */
@Entity
@Table(name="sys_role_permission")
public class SysRolePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    private Integer id;
    @Column(name = "role_id", nullable = false, length = 11)
    private Integer roleId;
    @Column(name = "permission_id",nullable = false, length = 11)
    private Integer permissionId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }
}
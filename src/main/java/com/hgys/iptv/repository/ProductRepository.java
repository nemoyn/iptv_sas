package com.hgys.iptv.repository;

import com.hgys.iptv.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>, JpaSpecificationExecutor<Product> {
    /**
     * 通过code查询
     * @param code
     * @return
     */
    Product findByCode(String code);

    /**
     * 通过名称查询
     * @param name
     * @return
     */
    Product findByName(String name);

    /**
     * 通过ID逻辑删除
     * @param id
     * @return
     */
    @Modifying
    @Query(value = "update Product set isdelete = 1 WHERE id = ?1")
    void logicDelete(int id);



    /**
     * 通过code查询名字
     * @param Code
     * @return
     */
    @Query(value = "select o.name from Product o where o.code = ?1")
    String findByMasterCodes(String Code);



    /**
     * 通过code查产品的ID
     * @param Code
     * @return
     */
    @Query(value = "select o.id from Product o where o.code = ?1")
    Integer findByMasterCodesid(String Code);


    /**
     * 只查询未删除的产品
     * @param
     * @return
     */
    @Query(value = "select o from Product o where o.isdelete = 0")
    List<Product> findplist();

}
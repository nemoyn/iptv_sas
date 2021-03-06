package com.hgys.iptv.model.bean;

import com.xuxueli.poi.excel.annotation.ExcelField;
import com.xuxueli.poi.excel.annotation.ExcelSheet;
import lombok.Data;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import java.math.BigDecimal;

@ExcelSheet(name = "产品级单维度结算", headColor = HSSFColor.HSSFColorPredefined.LIGHT_GREEN)
public class OrderProductDimensionDTO {
    /**
     * CP编码
     */
    @ExcelField(name = "CP编码",align = HorizontalAlignment.CENTER)
    private String cpcode;

    /**
     * CP名称
     */
    @ExcelField(name = "CP名称",align = HorizontalAlignment.CENTER)
    private String cpname;

    /** 产品名称 */
    @ExcelField(name = "产品名称",align = HorizontalAlignment.CENTER)
    private String pname;

    /** 产品编码 */
    @ExcelField(name = "产品编码",align = HorizontalAlignment.CENTER)
    private String pcode;

    /**
     * 维度编码
     */
    @ExcelField(name = "维度编码",align = HorizontalAlignment.CENTER)
    private String dimensionCode;

    /**
     * 数量
     */
    @ExcelField(name = "数量",align = HorizontalAlignment.CENTER)
    private String number;

    /**
     * 产品结算金额
     */
    @ExcelField(name = "结算金额（单位：元）",align = HorizontalAlignment.CENTER)
    private String money;

    public String getCpcode() {
        return cpcode;
    }

    public void setCpcode(String cpcode) {
        this.cpcode = cpcode;
    }

    public String getCpname() {
        return cpname;
    }

    public void setCpname(String cpname) {
        this.cpname = cpname;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getDimensionCode() {
        return dimensionCode;
    }

    public void setDimensionCode(String dimensionCode) {
        this.dimensionCode = dimensionCode;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

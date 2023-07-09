package com.ruoyi.Logistics.clean.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * company对象 TEMP_物流公司
 * 
 * @author lyw
 * @date 2023-07-07
 */
public class Company extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer companyNum;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String companyName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String customerNum;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String personName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String phone;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String place;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer error;

    public void setCompanyNum(Integer companyNum) 
    {
        this.companyNum = companyNum;
    }

    public Integer getCompanyNum() 
    {
        return companyNum;
    }
    public void setCompanyName(String companyName) 
    {
        this.companyName = companyName;
    }

    public String getCompanyName() 
    {
        return companyName;
    }
    public void setCustomerNum(String customerNum) 
    {
        this.customerNum = customerNum;
    }

    public String getCustomerNum() 
    {
        return customerNum;
    }
    public void setPersonName(String personName) 
    {
        this.personName = personName;
    }

    public String getPersonName() 
    {
        return personName;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setPlace(String place) 
    {
        this.place = place;
    }

    public String getPlace() 
    {
        return place;
    }
    public void setError(Integer error) 
    {
        this.error = error;
    }

    public Integer getError() 
    {
        return error;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("companyNum", getCompanyNum())
            .append("companyName", getCompanyName())
            .append("customerNum", getCustomerNum())
            .append("personName", getPersonName())
            .append("phone", getPhone())
            .append("place", getPlace())
            .append("error", getError())
            .toString();
    }
}

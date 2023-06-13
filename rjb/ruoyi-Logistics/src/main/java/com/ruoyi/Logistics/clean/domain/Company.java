package com.ruoyi.Logistics.clean.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * company对象 TEMP_物流公司
 * 
 * @author lyw
 * @date 2023-06-13
 */
public class Company extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    @Excel(name = "")
    private Integer num;

    /**  */
    @Excel(name = "")
    private String companyName;

    /**  */
    @Excel(name = "")
    private String customerName;

    /**  */
    @Excel(name = "")
    private String personName;

    /**  */
    @Excel(name = "")
    private String phone;

    /**  */
    @Excel(name = "")
    private String place;

    /**  */
    @Excel(name = "")
    private Integer error;

    public void setNum(Integer num) 
    {
        this.num = num;
    }

    public Integer getNum() 
    {
        return num;
    }
    public void setCompanyName(String companyName) 
    {
        this.companyName = companyName;
    }

    public String getCompanyName() 
    {
        return companyName;
    }
    public void setCustomerName(String customerName) 
    {
        this.customerName = customerName;
    }

    public String getCustomerName() 
    {
        return customerName;
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
            .append("num", getNum())
            .append("companyName", getCompanyName())
            .append("customerName", getCustomerName())
            .append("personName", getPersonName())
            .append("phone", getPhone())
            .append("place", getPlace())
            .append("error", getError())
            .toString();
    }
}

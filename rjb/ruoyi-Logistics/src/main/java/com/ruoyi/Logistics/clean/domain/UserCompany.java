package com.ruoyi.Logistics.clean.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * userCompany对象 USER_物流公司
 * 
 * @author lyw
 * @date 2023-06-17
 */
public class UserCompany extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    @Excel(name = "")
    private Integer companyNum;

    /**  */
    @Excel(name = "")
    private String companyName;

    /**  */
    @Excel(name = "")
    private String customerNum;

    /**  */
    @Excel(name = "")
    private String personName;

    /**  */
    @Excel(name = "")
    private String phone;

    /**  */
    @Excel(name = "")
    private String place;

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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("companyNum", getCompanyNum())
            .append("companyName", getCompanyName())
            .append("customerNum", getCustomerNum())
            .append("personName", getPersonName())
            .append("phone", getPhone())
            .append("place", getPlace())
            .toString();
    }
}

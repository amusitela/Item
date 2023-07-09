package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 公司表对象 tran_company
 * 
 * @author 111
 * @date 2023-07-06
 */
public class TranCompany extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 客户编号 */
    @Excel(name = "客户编号")
    private String kuhuId;

    /** 公司名称 */
    @Excel(name = "公司名称")
    private String name;

    /** 联系人 */
    @Excel(name = "联系人")
    private String contact;

    /** 电话 */
    @Excel(name = "电话")
    private String phone;

    /** 省市区 */
    @Excel(name = "省市区")
    private String address;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setKuhuId(String kuhuId) 
    {
        this.kuhuId = kuhuId;
    }

    public String getKuhuId() 
    {
        return kuhuId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setContact(String contact) 
    {
        this.contact = contact;
    }

    public String getContact() 
    {
        return contact;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("kuhuId", getKuhuId())
            .append("name", getName())
            .append("contact", getContact())
            .append("phone", getPhone())
            .append("address", getAddress())
            .toString();
    }
}

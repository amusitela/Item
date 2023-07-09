package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 111对象 kehu
 * 
 * @author ruoyi
 * @date 2023-06-13
 */
public class Kehu extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    @Excel(name = "")
    private String id;

    /**  */
    @Excel(name = "")
    private String name;

    /**  */
    @Excel(name = "")
    private String phone;

    /**  */
    @Excel(name = "")
    private String address;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
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
            .append("name", getName())
            .append("phone", getPhone())
            .append("address", getAddress())
            .toString();
    }
}

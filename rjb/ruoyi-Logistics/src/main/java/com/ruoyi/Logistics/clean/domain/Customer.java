package com.ruoyi.Logistics.clean.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * Customer对象 TEMP_客户信息
 * 
 * @author lyw
 * @date 2023-06-12
 */
public class Customer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private String num;

    /**  */
    @Excel(name = "")
    private String name;

    /**  */
    @Excel(name = "")
    private String phone;

    /**  */
    @Excel(name = "")
    private String place;

    /**  */
    @Excel(name = "")
    private Integer error;

    public void setNum(String num) 
    {
        this.num = num;
    }

    public String getNum() 
    {
        return num;
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
            .append("name", getName())
            .append("phone", getPhone())
            .append("place", getPlace())
            .append("error", getError())
            .toString();
    }
}

package com.ruoyi.Logistics.clean.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * userLogistics对象 USER_物流信息
 * 
 * @author lyw
 * @date 2023-06-14
 */
public class UserLogistics extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    @Excel(name = "")
    private String tNum;

    /**  */
    @Excel(name = "")
    private String name;

    /**  */
    @Excel(name = "")
    private String num;

    /**  */
    @Excel(name = "")
    private String company;

    /**  */
    @Excel(name = "")
    private String containerNum;

    /**  */
    @Excel(name = "")
    private String goods;

    /**  */
    @Excel(name = "")
    private String weight;

    public void settNum(String tNum) 
    {
        this.tNum = tNum;
    }

    public String gettNum() 
    {
        return tNum;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setNum(String num) 
    {
        this.num = num;
    }

    public String getNum() 
    {
        return num;
    }
    public void setCompany(String company) 
    {
        this.company = company;
    }

    public String getCompany() 
    {
        return company;
    }
    public void setContainerNum(String containerNum) 
    {
        this.containerNum = containerNum;
    }

    public String getContainerNum() 
    {
        return containerNum;
    }
    public void setGoods(String goods) 
    {
        this.goods = goods;
    }

    public String getGoods() 
    {
        return goods;
    }
    public void setWeight(String weight) 
    {
        this.weight = weight;
    }

    public String getWeight() 
    {
        return weight;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("tNum", gettNum())
            .append("name", getName())
            .append("num", getNum())
            .append("company", getCompany())
            .append("containerNum", getContainerNum())
            .append("goods", getGoods())
            .append("weight", getWeight())
            .toString();
    }
}

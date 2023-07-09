package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 物流信息对象 tran_info
 * 
 * @author 111
 * @date 2023-07-06
 */
public class TranInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 提单号 */
    private String id;

    /** 货主名称 */
    @Excel(name = "货主名称")
    private String owner;

    /** 货主代码 */
    @Excel(name = "货主代码")
    private String ownerNum;

    /** 物流公司 */
    @Excel(name = "物流公司")
    private String tranCompany;

    /** 集装箱号 */
    @Excel(name = "集装箱号")
    private String boxNum;

    /** 货物名称 */
    @Excel(name = "货物名称")
    private String goods;

    /** 货重 */
    @Excel(name = "货重")
    private Long weight;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setOwner(String owner) 
    {
        this.owner = owner;
    }

    public String getOwner() 
    {
        return owner;
    }
    public void setOwnerNum(String ownerNum) 
    {
        this.ownerNum = ownerNum;
    }

    public String getOwnerNum() 
    {
        return ownerNum;
    }
    public void setTranCompany(String tranCompany) 
    {
        this.tranCompany = tranCompany;
    }

    public String getTranCompany() 
    {
        return tranCompany;
    }
    public void setBoxNum(String boxNum) 
    {
        this.boxNum = boxNum;
    }

    public String getBoxNum() 
    {
        return boxNum;
    }
    public void setGoods(String goods) 
    {
        this.goods = goods;
    }

    public String getGoods() 
    {
        return goods;
    }
    public void setWeight(Long weight) 
    {
        this.weight = weight;
    }

    public Long getWeight() 
    {
        return weight;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("owner", getOwner())
            .append("ownerNum", getOwnerNum())
            .append("tranCompany", getTranCompany())
            .append("boxNum", getBoxNum())
            .append("goods", getGoods())
            .append("weight", getWeight())
            .toString();
    }
}

package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 集装箱动态对象 tran_trends
 * 
 * @author ruoyi
 * @date 2023-07-06
 */
public class TranTrends extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 堆存港口 */
    @Excel(name = "堆存港口")
    private String port;

    /** 集装箱号 */
    @Excel(name = "集装箱号")
    private String boxNum;

    /** 集装箱尺寸
 */
    @Excel(name = "集装箱尺寸 ")
    private Long boxSize;

    /** 提单号 */
    @Excel(name = "提单号")
    private String num;

    /** 堆场位置 */
    @Excel(name = "堆场位置")
    private String position;

    /** 操作 */
    @Excel(name = "操作")
    private String operate;

    /** 操作日期 */
    @Excel(name = "操作日期")
    private String time;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPort(String port) 
    {
        this.port = port;
    }

    public String getPort() 
    {
        return port;
    }
    public void setBoxNum(String boxNum) 
    {
        this.boxNum = boxNum;
    }

    public String getBoxNum() 
    {
        return boxNum;
    }
    public void setBoxSize(Long boxSize) 
    {
        this.boxSize = boxSize;
    }

    public Long getBoxSize() 
    {
        return boxSize;
    }
    public void setNum(String num) 
    {
        this.num = num;
    }

    public String getNum() 
    {
        return num;
    }
    public void setPosition(String position) 
    {
        this.position = position;
    }

    public String getPosition() 
    {
        return position;
    }
    public void setOperate(String operate) 
    {
        this.operate = operate;
    }

    public String getOperate() 
    {
        return operate;
    }
    public void setTime(String time) 
    {
        this.time = time;
    }

    public String getTime() 
    {
        return time;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("port", getPort())
            .append("boxNum", getBoxNum())
            .append("boxSize", getBoxSize())
            .append("num", getNum())
            .append("position", getPosition())
            .append("operate", getOperate())
            .append("time", getTime())
            .toString();
    }
}

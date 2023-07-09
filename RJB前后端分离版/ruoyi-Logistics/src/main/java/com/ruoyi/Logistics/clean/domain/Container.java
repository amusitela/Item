package com.ruoyi.Logistics.clean.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * Container对象 TEMP_集装箱动态
 * 
 * @author lyw
 * @date 2023-07-07
 */
public class Container extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer num;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String port;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String containerNum;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String cc;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String tNum;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String CPlace;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String status;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String date;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer error;

    public void setNum(Integer num) 
    {
        this.num = num;
    }

    public Integer getNum() 
    {
        return num;
    }
    public void setPort(String port) 
    {
        this.port = port;
    }

    public String getPort() 
    {
        return port;
    }
    public void setContainerNum(String containerNum) 
    {
        this.containerNum = containerNum;
    }

    public String getContainerNum() 
    {
        return containerNum;
    }
    public void setCc(String cc) 
    {
        this.cc = cc;
    }

    public String getCc() 
    {
        return cc;
    }
    public void settNum(String tNum) 
    {
        this.tNum = tNum;
    }

    public String gettNum() 
    {
        return tNum;
    }
    public void setCPlace(String CPlace) 
    {
        this.CPlace = CPlace;
    }

    public String getCPlace() 
    {
        return CPlace;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setDate(String date) 
    {
        this.date = date;
    }

    public String getDate() 
    {
        return date;
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
            .append("port", getPort())
            .append("containerNum", getContainerNum())
            .append("cc", getCc())
            .append("tNum", gettNum())
            .append("CPlace", getCPlace())
            .append("status", getStatus())
            .append("date", getDate())
            .append("error", getError())
            .toString();
    }
}

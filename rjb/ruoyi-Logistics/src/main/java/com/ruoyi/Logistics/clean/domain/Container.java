package com.ruoyi.Logistics.clean.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * Container对象 TEMP_集装箱动态
 * 
 * @author lyw
 * @date 2023-06-13
 */
public class Container extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    @Excel(name = "")
    private Integer num;

    /**  */
    @Excel(name = "")
    private String port;

    /**  */
    @Excel(name = "")
    private String containerNum;

    /**  */
    @Excel(name = "")
    private String cc;

    /**  */
    @Excel(name = "")
    private String tNum;

    /**  */
    @Excel(name = "")
    private String CPlace;

    /**  */
    @Excel(name = "")
    private String status;

    /**  */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "", width = 30, dateFormat = "yyyy-MM-dd")
    private Date date;

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
    public void setDate(Date date) 
    {
        this.date = date;
    }

    public Date getDate() 
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

package com.ruoyi.Logistics.clean.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * work对象 USER_WORK
 * 
 * @author lyw
 * @date 2023-06-14
 */
public class UserWork extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    @Excel(name = "")
    private Integer num;

    /**  */
    @Excel(name = "")
    private String shipCompany;

    /**  */
    @Excel(name = "")
    private String shipName;

    /**  */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "", width = 30, dateFormat = "yyyy-MM-dd")
    private Date ws;

    /**  */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "", width = 30, dateFormat = "yyyy-MM-dd")
    private Date we;

    /**  */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "", width = 30, dateFormat = "yyyy-MM-dd")
    private Date start;

    /**  */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "", width = 30, dateFormat = "yyyy-MM-dd")
    private Date end;

    /**  */
    @Excel(name = "")
    private String port;

    /**  */
    @Excel(name = "")
    private String tNum;

    /**  */
    @Excel(name = "")
    private String containerNum;

    /**  */
    @Excel(name = "")
    private String cc;

    /**  */
    @Excel(name = "")
    private String splace;

    /**  */
    @Excel(name = "")
    private String eplace;

    /**  */
    @Excel(name = "")
    private Integer status;

    public void setNum(Integer num) 
    {
        this.num = num;
    }

    public Integer getNum() 
    {
        return num;
    }
    public void setShipCompany(String shipCompany) 
    {
        this.shipCompany = shipCompany;
    }

    public String getShipCompany() 
    {
        return shipCompany;
    }
    public void setShipName(String shipName) 
    {
        this.shipName = shipName;
    }

    public String getShipName() 
    {
        return shipName;
    }
    public void setWs(Date ws) 
    {
        this.ws = ws;
    }

    public Date getWs() 
    {
        return ws;
    }
    public void setWe(Date we) 
    {
        this.we = we;
    }

    public Date getWe() 
    {
        return we;
    }
    public void setStart(Date start) 
    {
        this.start = start;
    }

    public Date getStart() 
    {
        return start;
    }
    public void setEnd(Date end) 
    {
        this.end = end;
    }

    public Date getEnd() 
    {
        return end;
    }
    public void setPort(String port) 
    {
        this.port = port;
    }

    public String getPort() 
    {
        return port;
    }
    public void settNum(String tNum) 
    {
        this.tNum = tNum;
    }

    public String gettNum() 
    {
        return tNum;
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
    public void setSplace(String splace) 
    {
        this.splace = splace;
    }

    public String getSplace() 
    {
        return splace;
    }
    public void setEplace(String eplace) 
    {
        this.eplace = eplace;
    }

    public String getEplace() 
    {
        return eplace;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("num", getNum())
            .append("shipCompany", getShipCompany())
            .append("shipName", getShipName())
            .append("ws", getWs())
            .append("we", getWe())
            .append("start", getStart())
            .append("end", getEnd())
            .append("port", getPort())
            .append("tNum", gettNum())
            .append("containerNum", getContainerNum())
            .append("cc", getCc())
            .append("splace", getSplace())
            .append("eplace", getEplace())
            .append("status", getStatus())
            .toString();
    }
}

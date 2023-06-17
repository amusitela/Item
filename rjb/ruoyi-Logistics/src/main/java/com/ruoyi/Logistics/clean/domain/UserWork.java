package com.ruoyi.Logistics.clean.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * work对象 USER_WORK
 * 
 * @author lyw
 * @date 2023-06-16
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
    @Excel(name = "")
    private String ws;

    /**  */
    @Excel(name = "")
    private String we;

    /**  */
    @Excel(name = "")
    private String start;

    /**  */
    @Excel(name = "")
    private String end;

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
    public void setWs(String ws) 
    {
        this.ws = ws;
    }

    public String getWs() 
    {
        return ws;
    }
    public void setWe(String we) 
    {
        this.we = we;
    }

    public String getWe() 
    {
        return we;
    }
    public void setStart(String start) 
    {
        this.start = start;
    }

    public String getStart() 
    {
        return start;
    }
    public void setEnd(String end) 
    {
        this.end = end;
    }

    public String getEnd() 
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

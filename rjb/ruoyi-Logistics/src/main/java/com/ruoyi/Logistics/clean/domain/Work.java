package com.ruoyi.Logistics.clean.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * work对象 TEMP_WORK
 * 
 * @author lyw
 * @date 2023-06-13
 */
public class Work extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    @Excel(name = "")
    private Long no;

    /**  */
    @Excel(name = "")
    private String shipcompany;

    /**  */
    @Excel(name = "")
    private String chipname;

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
    private String tnum;

    /**  */
    @Excel(name = "")
    private String containernum;

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

    /**  */
    @Excel(name = "")
    private Integer error;

    public void setNo(Long no) 
    {
        this.no = no;
    }

    public Long getNo() 
    {
        return no;
    }
    public void setShipcompany(String shipcompany) 
    {
        this.shipcompany = shipcompany;
    }

    public String getShipcompany() 
    {
        return shipcompany;
    }
    public void setChipname(String chipname) 
    {
        this.chipname = chipname;
    }

    public String getChipname() 
    {
        return chipname;
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
    public void setTnum(String tnum) 
    {
        this.tnum = tnum;
    }

    public String getTnum() 
    {
        return tnum;
    }
    public void setContainernum(String containernum) 
    {
        this.containernum = containernum;
    }

    public String getContainernum() 
    {
        return containernum;
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
            .append("no", getNo())
            .append("shipcompany", getShipcompany())
            .append("chipname", getChipname())
            .append("ws", getWs())
            .append("we", getWe())
            .append("start", getStart())
            .append("end", getEnd())
            .append("port", getPort())
            .append("tnum", getTnum())
            .append("containernum", getContainernum())
            .append("cc", getCc())
            .append("splace", getSplace())
            .append("eplace", getEplace())
            .append("status", getStatus())
            .append("error", getError())
            .toString();
    }
}

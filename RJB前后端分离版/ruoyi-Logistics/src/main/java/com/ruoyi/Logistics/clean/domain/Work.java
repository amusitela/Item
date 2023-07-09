package com.ruoyi.Logistics.clean.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * work对象 TEMP_WORK
 * 
 * @author lyw
 * @date 2023-07-07
 */
public class Work extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer num;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String shipcompany;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String chipname;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String ws;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String we;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String start;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String end;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String port;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String tnum;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String containernum;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String cc;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String splace;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String eplace;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer status;

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
            .append("num", getNum())
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

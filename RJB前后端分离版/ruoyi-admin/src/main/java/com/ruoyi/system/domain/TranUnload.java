package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 卸货表对象 tran_unload
 * 
 * @author ruoyi
 * @date 2023-07-06
 */
public class TranUnload extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 船名称 */
    @Excel(name = "船名称")
    private String boatname;

    /** 作业开始时间 */
    @Excel(name = "作业开始时间")
    private String begining;

    /** 作业结束时间 */
    @Excel(name = "作业结束时间")
    private String ending;

    /** 始发时间 */
    @Excel(name = "始发时间")
    private String origintime;

    /** 到达时间 */
    @Excel(name = "到达时间")
    private String arrivetime;

    /** 作业港口 */
    @Excel(name = "作业港口")
    private String workport;

    /** 提单号 */
    @Excel(name = "提单号")
    private String ladnum;

    /** 集装箱箱号 */
    @Excel(name = "集装箱箱号")
    private String boxnum;

    /** 箱尺寸（TEU） */
    @Excel(name = "箱尺寸", readConverterExp = "T=EU")
    private Long boxsize;

    /** 启运地 */
    @Excel(name = "启运地")
    private String originaddress;

    /** 目的地 */
    @Excel(name = "目的地")
    private String destination;

    /** 船公司 */
    @Excel(name = "船公司")
    private String boatcompany;

    /** $column.columnComment */
    private Long id;

    public void setBoatname(String boatname) 
    {
        this.boatname = boatname;
    }

    public String getBoatname() 
    {
        return boatname;
    }
    public void setBegining(String begining) 
    {
        this.begining = begining;
    }

    public String getBegining() 
    {
        return begining;
    }
    public void setEnding(String ending) 
    {
        this.ending = ending;
    }

    public String getEnding() 
    {
        return ending;
    }
    public void setOrigintime(String origintime) 
    {
        this.origintime = origintime;
    }

    public String getOrigintime() 
    {
        return origintime;
    }
    public void setArrivetime(String arrivetime) 
    {
        this.arrivetime = arrivetime;
    }

    public String getArrivetime() 
    {
        return arrivetime;
    }
    public void setWorkport(String workport) 
    {
        this.workport = workport;
    }

    public String getWorkport() 
    {
        return workport;
    }
    public void setLadnum(String ladnum) 
    {
        this.ladnum = ladnum;
    }

    public String getLadnum() 
    {
        return ladnum;
    }
    public void setBoxnum(String boxnum) 
    {
        this.boxnum = boxnum;
    }

    public String getBoxnum() 
    {
        return boxnum;
    }
    public void setBoxsize(Long boxsize) 
    {
        this.boxsize = boxsize;
    }

    public Long getBoxsize() 
    {
        return boxsize;
    }
    public void setOriginaddress(String originaddress) 
    {
        this.originaddress = originaddress;
    }

    public String getOriginaddress() 
    {
        return originaddress;
    }
    public void setDestination(String destination) 
    {
        this.destination = destination;
    }

    public String getDestination() 
    {
        return destination;
    }
    public void setBoatcompany(String boatcompany) 
    {
        this.boatcompany = boatcompany;
    }

    public String getBoatcompany() 
    {
        return boatcompany;
    }
    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("boatname", getBoatname())
            .append("begining", getBegining())
            .append("ending", getEnding())
            .append("origintime", getOrigintime())
            .append("arrivetime", getArrivetime())
            .append("workport", getWorkport())
            .append("ladnum", getLadnum())
            .append("boxnum", getBoxnum())
            .append("boxsize", getBoxsize())
            .append("originaddress", getOriginaddress())
            .append("destination", getDestination())
            .append("boatcompany", getBoatcompany())
            .append("id", getId())
            .toString();
    }
}

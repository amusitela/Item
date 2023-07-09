package com.ruoyi.Logistics.clean.domain;

import com.ruoyi.common.annotation.Excel;


/**
 * @author 李易蔚
 * @version 1.0
 */

@SuppressWarnings({"all"})
public class Conditions {


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
    private String goods;

    /**  */
    @Excel(name = "")
    private Integer status;

    public String getShipCompany() {
        return shipCompany;
    }

    public void setShipCompany(String shipCompany) {
        this.shipCompany = shipCompany;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getWs() {
        return ws;
    }

    public void setWs(String ws) {
        this.ws = ws;
    }

    public String getWe() {
        return we;
    }

    public void setWe(String we) {
        this.we = we;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String gettNum() {
        return tNum;
    }

    public void settNum(String tNum) {
        this.tNum = tNum;
    }

    public String getContainerNum() {
        return containerNum;
    }

    public void setContainerNum(String containerNum) {
        this.containerNum = containerNum;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getSplace() {
        return splace;
    }

    public void setSplace(String splace) {
        this.splace = splace;
    }

    public String getEplace() {
        return eplace;
    }

    public void setEplace(String eplace) {
        this.eplace = eplace;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }




}

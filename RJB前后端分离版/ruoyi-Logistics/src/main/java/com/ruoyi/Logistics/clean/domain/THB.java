package com.ruoyi.Logistics.clean.domain;

/**
 * @author 李易蔚
 * @version 1.0
 */

@SuppressWarnings({"all"})
public class THB {
    private String now;
    private String tb;
    private String hb;
    private String zz;

    public String getZz() {
        return zz;
    }

    public void setZz(String zz) {
        this.zz = zz;
    }

    public String getNow() {
        return now;
    }

    public void setNow(String now) {
        this.now = now;
    }

    public String getTb() {
        return tb;
    }

    public void setTb(String tb) {
        this.tb = tb;
    }

    public String getHb() {
        return hb;
    }

    public void setHb(String hb) {
        this.hb = hb;
    }

    @Override
    public String toString() {
        return "THB{" +
                "now='" + now + '\'' +
                ", tb='" + tb + '\'' +
                ", hb='" + hb + '\'' +
                ", zz='" + zz + '\'' +
                '}';
    }
}

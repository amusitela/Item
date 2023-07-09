package com.ruoyi.Logistics.clean.domain;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * @author 李易蔚
 * @version 1.0
 */

@SuppressWarnings({"all"})
public class Goods extends BaseEntity {
    private String goods;
    private String start;
    private String end;

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
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

    @Override
    public String toString() {
        return "Goods{" +
                "货物名称='" + goods + '\'' +
                ",启运地='" + start + '\'' +
                ", 目的地='" + end + '\'' +
                '}';
    }
}

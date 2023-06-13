package com.ruoyi.domain;

/**
 * @User: Mr.Yang
 * @Date: 2023/6/10
 */
public class Customer {

    private String num;
    private String name;
    private String phone;
    private String place;
    private int error;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "num='" + num + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", place='" + place + '\'' +
                ", error=" + error +
                '}';
    }
}

package com.example.admin.smile.Model;

public class Child  {
    String ten;
    String tuoi;
    String thongtin;
    int gt;
    boolean benh1,benh2,benh3,benh4,benh5,benh6;

    public Child(String ten, String tuoi, String thongtin, int gt, boolean benh1, boolean benh2, boolean benh3, boolean benh4, boolean benh5, boolean benh6) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.thongtin = thongtin;
        this.gt = gt;
        this.benh1 = benh1;
        this.benh2 = benh2;
        this.benh3 = benh3;
        this.benh4 = benh4;
        this.benh5 = benh5;
        this.benh6 = benh6;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTuoi() {
        return tuoi;
    }

    public void setTuoi(String tuoi) {
        this.tuoi = tuoi;
    }

    public String getThongtin() {
        return thongtin;
    }

    public void setThongtin(String thongtin) {
        this.thongtin = thongtin;
    }

    public int getGt() {
        return gt;
    }

    public void setGt(int gt) {
        this.gt = gt;
    }

    public boolean isBenh1() {
        return benh1;
    }

    public void setBenh1(boolean benh1) {
        this.benh1 = benh1;
    }

    public boolean isBenh2() {
        return benh2;
    }

    public void setBenh2(boolean benh2) {
        this.benh2 = benh2;
    }

    public boolean isBenh3() {
        return benh3;
    }

    public void setBenh3(boolean benh3) {
        this.benh3 = benh3;
    }

    public boolean isBenh4() {
        return benh4;
    }

    public void setBenh4(boolean benh4) {
        this.benh4 = benh4;
    }

    public boolean isBenh5() {
        return benh5;
    }

    public void setBenh5(boolean benh5) {
        this.benh5 = benh5;
    }

    public boolean isBenh6() {
        return benh6;
    }

    public void setBenh6(boolean benh6) {
        this.benh6 = benh6;
    }
}

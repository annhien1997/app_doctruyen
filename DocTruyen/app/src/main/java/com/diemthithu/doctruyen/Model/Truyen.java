package com.diemthithu.doctruyen.Model;

import com.google.gson.annotations.SerializedName;

public class Truyen {
    @SerializedName("id_truyen")
    private int id_truyen;
    @SerializedName("tenTruyen")
    private String tenTruyen;
    @SerializedName("tacGia")
    private String tacGia;
    @SerializedName("theLoai")
    private String theLoai;
    @SerializedName("noiDung")
    private String noiDung;
    @SerializedName("hinhAnh")
    private String hinhAnh;
    @SerializedName("anhBia")
    private String anhBia;
    @SerializedName("id_trangthai")
    private int  id_trangthai;

    public Truyen() {
    }

    public Truyen(int id_truyen, String tenTruyen, String tacGia, String theLoai, String noiDung, String hinhAnh, String anhBia, int id_trangthai) {
        this.id_truyen = id_truyen;
        this.tenTruyen = tenTruyen;
        this.tacGia = tacGia;
        this.theLoai = theLoai;
        this.noiDung = noiDung;
        this.hinhAnh = hinhAnh;
        this.anhBia = anhBia;
        this.id_trangthai = id_trangthai;
    }

    public int getId_truyen() {
        return id_truyen;
    }

    public void setId_truyen(int id_truyen) {
        this.id_truyen = id_truyen;
    }

    public String getTenTruyen() {
        return tenTruyen;
    }

    public void setTenTruyen(String tenTruyen) {
        this.tenTruyen = tenTruyen;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getAnhBia() {
        return anhBia;
    }

    public void setAnhBia(String anhBia) {
        this.anhBia = anhBia;
    }

    public int getId_trangthai() {
        return id_trangthai;
    }

    public void setId_trangthai(int id_trangthai) {
        this.id_trangthai = id_trangthai;
    }
}

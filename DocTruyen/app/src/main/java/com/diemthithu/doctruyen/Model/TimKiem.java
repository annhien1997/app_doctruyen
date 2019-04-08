package com.diemthithu.doctruyen.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TimKiem {

@SerializedName("id_truyen")
@Expose
private String idTruyen;
@SerializedName("tenTruyen")
@Expose
private String tenTruyen;
@SerializedName("tacGia")
@Expose
private String tacGia;
@SerializedName("theLoai")
@Expose
private String theLoai;
@SerializedName("noiDung")
@Expose
private String noiDung;
@SerializedName("hinhAnh")
@Expose
private String hinhAnh;
@SerializedName("anhBia")
@Expose
private String anhBia;
@SerializedName("id_trangthai")
@Expose
private String idTrangthai;

public String getIdTruyen() {
return idTruyen;
}

public void setIdTruyen(String idTruyen) {
this.idTruyen = idTruyen;
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

public String getIdTrangthai() {
return idTrangthai;
}

public void setIdTrangthai(String idTrangthai) {
this.idTrangthai = idTrangthai;
}

}
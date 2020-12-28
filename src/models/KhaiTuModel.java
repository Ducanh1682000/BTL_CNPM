/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author THUAN.HQ183840
 */
public class KhaiTuModel {
    private int ID;
    private int soGiayKhaiTu;
    private int idNguoiKhai;
    private int idNguoiChet;
    private Date ngayKhai;
    private Date ngayChet;
    private String lyDoChet;
    private String hoTen;
    private String gioiTinh;
    private Date ngaySinh;
    private String soCMND;

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getSoGiayKhaiTu() {
        return soGiayKhaiTu;
    }

    public void setSoGiayKhaiTu(int soGiayKhaiTu) {
        this.soGiayKhaiTu = soGiayKhaiTu;
    }

    public int getIdNguoiKhai() {
        return idNguoiKhai;
    }

    public void setIdNguoiKhai(int idNguoiKhai) {
        this.idNguoiKhai = idNguoiKhai;
    }

    public int getIdNguoiChet() {
        return idNguoiChet;
    }

    public void setIdNguoiChet(int idNguoiChet) {
        this.idNguoiChet = idNguoiChet;
    }

    public Date getNgayKhai() {
        return ngayKhai;
    }

    public void setNgayKhai(Date ngayKhai) {
        this.ngayKhai = ngayKhai;
    }

    public Date getNgayChet() {
        return ngayChet;
    }

    public void setNgayChet(Date ngayChet) {
        this.ngayChet = ngayChet;
    }

    public String getLyDoChet() {
        return lyDoChet;
    }

    public void setLyDoChet(String lyDoChet) {
        this.lyDoChet = lyDoChet;
    }
    
}

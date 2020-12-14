/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model_ho_khau;

import java.util.Date;

/**
 *
 * @author admin
 */
public class HoKhau {
    private int ID;
    private String maHoKhau;
    private String idChuHo;
    private String maKhuVuc;
    private String DiaChi;
    private Date ngayLap;
    private Date ngayChuyenDi;
    private String lyDoChuyen;
    private String nguoiThucHien;

    public HoKhau() {
    }

    
    public HoKhau(int ID, String maHoKhau, String idChuHo, String maKhuVuc, String DiaChi, Date ngayLap, Date ngayChuyenDi, String lyDoChuyen, String nguoiThucHien) {
        this.ID = ID;
        this.maHoKhau = maHoKhau;
        this.idChuHo = idChuHo;
        this.maKhuVuc = maKhuVuc;
        this.DiaChi = DiaChi;
        this.ngayLap = ngayLap;
        this.ngayChuyenDi = ngayChuyenDi;
        this.lyDoChuyen = lyDoChuyen;
        this.nguoiThucHien = nguoiThucHien;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMaHoKhau() {
        return maHoKhau;
    }

    public void setMaHoKhau(String maHoKhau) {
        this.maHoKhau = maHoKhau;
    }

    public String getIdChuHo() {
        return idChuHo;
    }

    public void setIdChuHo(String idChuHo) {
        this.idChuHo = idChuHo;
    }

    public String getMaKhuVuc() {
        return maKhuVuc;
    }

    public void setMaKhuVuc(String maKhuVuc) {
        this.maKhuVuc = maKhuVuc;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public Date getNgayChuyenDi() {
        return ngayChuyenDi;
    }

    public void setNgayChuyenDi(Date ngayChuyenDi) {
        this.ngayChuyenDi = ngayChuyenDi;
    }

    public String getLyDoChuyen() {
        return lyDoChuyen;
    }

    public void setLyDoChuyen(String lyDoChuyen) {
        this.lyDoChuyen = lyDoChuyen;
    }

    public String getNguoiThucHien() {
        return nguoiThucHien;
    }

    public void setNguoiThucHien(String nguoiThucHien) {
        this.nguoiThucHien = nguoiThucHien;
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.ThuPhi;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class ThongTinThuPhiModel {
    private int maDotThu;
    private String tenDotThu;
    private int maHoKhau;
    private int idChuHo;
    private String tenChuHo;
    private String diaChiThu;
    private int soNhanKhau;
    private int tongSoTien;
    private Date ngayThu;
    private String ghiChu;

    public String getTenDotThu() {
        return tenDotThu;
    }

    public void setTenDotThu(String tenDotThu) {
        this.tenDotThu = tenDotThu;
    }

    public int getIdChuHo() {
        return idChuHo;
    }

    public void setIdChuHo(int idChuHo) {
        this.idChuHo = idChuHo;
    }

    public String getTenChuHo() {
        return tenChuHo;
    }

    public void setTenChuHo(String tenChuHo) {
        this.tenChuHo = tenChuHo;
    }

    public String getDiaChiThu() {
        return diaChiThu;
    }

    public void setDiaChiThu(String diaChiThu) {
        this.diaChiThu = diaChiThu;
    }
    
    

    public int getMaDotThu() {
        return maDotThu;
    }

    public void setMaDotThu(int maDotThu) {
        this.maDotThu = maDotThu;
    }

    public int getMaHoKhau() {
        return maHoKhau;
    }

    public void setMaHoKhau(int maHoKhau) {
        this.maHoKhau = maHoKhau;
    }

    

    public int getSoNhanKhau() {
        return soNhanKhau;
    }

    public void setSoNhanKhau(int soNhanKhau) {
        this.soNhanKhau = soNhanKhau;
    }

    public int getTongSoTien() {
        return tongSoTien;
    }

    public void setTongSoTien(int tongSoTien) {
        this.tongSoTien = tongSoTien;
    }

    public Date getNgayThu() {
        return ngayThu;
    }

    public void setNgayThu(Date ngayThu) {
        this.ngayThu = ngayThu;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
    
    
}

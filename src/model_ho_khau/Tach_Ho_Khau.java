/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model_ho_khau;

import java.util.List;
import model_ho_khau.HoKhau;
import model_ho_khau.NhanKhautest;

/**
 *
 * @author admin
 */
public class Tach_Ho_Khau {
    private NhanKhautest nhankhau;
    private HoKhau hokhau;

    public Tach_Ho_Khau() {
    }

    public Tach_Ho_Khau(NhanKhautest nhankhau, HoKhau hokhau) {
        this.nhankhau = nhankhau;
        this.hokhau = hokhau;
    }
    
    public NhanKhautest getNhankhau() {
        return nhankhau;
    }

    public void setNhankhau(NhanKhautest nhankhau) {
        this.nhankhau = nhankhau;
    }

    public HoKhau getHokhau() {
        return hokhau;
    }

    public void setHokhau(HoKhau hokhau) {
        this.hokhau = hokhau;
    }


    }
    
    


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model_ho_khau;

import model_ho_khau.NhanKhautest;

/**
 *
 * @author admin
 */
public class ChonTvInTachHk {
    private NhanKhautest nk;
    private ThanhVienCuaHo tvh;

    public ChonTvInTachHk() {
    }
    public ChonTvInTachHk(NhanKhautest nk, ThanhVienCuaHo tvh) {
        this.nk = nk;
        this.tvh = tvh;
    }
    public NhanKhautest getNk() {
        return nk;
    }  
    
    public void setNk(NhanKhautest nk) {
        this.nk = nk;
    }

    public ThanhVienCuaHo getTvh() {
        return tvh;
    }

    public void setTvh(ThanhVienCuaHo tvh) {
        this.tvh = tvh;
    }

  
    
    
    
    
}

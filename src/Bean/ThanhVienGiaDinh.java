/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;
import models.ThanhVienCuaHoModel;
/**
 *
 * @author Vu Tran Duc Anh
 */
public class ThanhVienGiaDinh {
    private NhanKhauBean nhanKhau;
    private ThanhVienCuaHoModel thanhVienCuaHoModel;

    public ThanhVienGiaDinh(NhanKhauBean nhanKhau, ThanhVienCuaHoModel thanhVienCuaHoModel) {
        this.nhanKhau = nhanKhau;
        this.thanhVienCuaHoModel = thanhVienCuaHoModel;
    }
    
    public ThanhVienGiaDinh() {
        this.nhanKhau = new NhanKhauBean();
        this.thanhVienCuaHoModel = new ThanhVienCuaHoModel();
    }
    
    
    public NhanKhauBean getNhanKhau() {
        return nhanKhau;
    }

    public void setNhanKhau(NhanKhauBean nhanKhau) {
        this.nhanKhau = nhanKhau;
    }

    public ThanhVienCuaHoModel getThanhVienCuaHoModel() {
        return thanhVienCuaHoModel;
    }

    public void setThanhVienCuaHoModel(ThanhVienCuaHoModel thanhVienCuaHoModel) {
        this.thanhVienCuaHoModel = thanhVienCuaHoModel;
    }
}

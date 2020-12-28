/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model_ho_khau;

/**
 *
 * @author admin
 */
public class ThanhVienCuaHo {
    private int idNhanKhau;
    private int idHoKhau;
    private String quanHeVoiChuHo;

    public ThanhVienCuaHo() {
    }
    
    public int getIdNhanKhau() {
        return idNhanKhau;
    }

    public void setIdNhanKhau(int idNhanKhau) {
        this.idNhanKhau = idNhanKhau;
    }

    public int getIdHoKhau() {
        return idHoKhau;
    }

    public void setIdHoKhau(int idHoKhau) {
        this.idHoKhau = idHoKhau;
    }

    public String getQuanHeVoiChuHo() {
        return quanHeVoiChuHo;
    }

    public void setQuanHeVoiChuHo(String quanHeVoiChuHo) {
        this.quanHeVoiChuHo = quanHeVoiChuHo;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof ThanhVienCuaHo){
           ThanhVienCuaHo tv = (ThanhVienCuaHo) obj;
        if(this.idHoKhau == tv.getIdHoKhau() && this.idNhanKhau == tv.getIdNhanKhau()) 
            return true;
    }
        return false;
    
}
//    public static void main(String[] args) {
//        ThanhVienCuaHo tv1 = new ThanhVienCuaHo();
//        tv1.setIdHoKhau(2);
//        tv1.setIdNhanKhau(4);
//        ThanhVienCuaHo tv2 = new ThanhVienCuaHo();
//        tv2.setIdHoKhau(2);
//        tv2.setIdNhanKhau(3);
//        System.out.println(tv1.equals(tv2));
//    }
}

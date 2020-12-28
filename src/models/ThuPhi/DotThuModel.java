
package models.ThuPhi;

import java.util.Date;
/**
 *
 * @author ADMIN
 * 
 */
public class DotThuModel {
    private int maDotThu;
   
    private String tenDotThu;
    private boolean loaiPhiThu;
    private Date ngayBatDauThu;
    private Date ngayKetThucThu;
    private int soTienTrenMotNhanKhau;
    private Date ngayTao;

    public int getMaDotThu() {
        return maDotThu;
    }

    public void setMaDotThu(int maDotThu) {
        this.maDotThu = maDotThu;
    }

    
    public String getTenDotThu(){
        return tenDotThu;
    }
    
    public void setTenDotThu(String tenDotThu){
        this.tenDotThu = tenDotThu;
    }

    public boolean isLoaiPhiThu() {
        return loaiPhiThu;
    }

    public void setLoaiPhiThu(boolean loaiPhiThu) {
        this.loaiPhiThu = loaiPhiThu;
    }
    
    
    
    public Date getNgayBatDauThu(){
        return ngayBatDauThu;
    }
    
    public void setNgayBatDauThu(Date ngayBatDauThu){
        this.ngayBatDauThu = ngayBatDauThu;
    }
    
    public Date getNgayKetThucThu(){
        return ngayKetThucThu;
    }
    
    public void setNgayKetThucThu(Date ngayKetThucThu){
        this.ngayKetThucThu = ngayKetThucThu;
    }
    
    public int getSoTienTrenMotNhanKhau(){
        return soTienTrenMotNhanKhau;
    }
    
    public void setSoTienTrenMotNhanKhau(int soTienTrenMotNhanKhau){
        this.soTienTrenMotNhanKhau = soTienTrenMotNhanKhau;
    }
    
    public Date getNgayTao(){
        return ngayTao;
    }
    
    public void setNgayTao(Date ngayTao){
        this.ngayTao = ngayTao;
    }
}



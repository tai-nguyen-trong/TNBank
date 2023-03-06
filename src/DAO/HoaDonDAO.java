/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.HoaDon;
import Utils.XJdbc;

/**
 *
 * @author vietm
 */
public class HoaDonDAO {

    public void insert(HoaDon entity) {
        String sql = "INSERT INTO HoaDonChiTiet (soTaiKhoan, maNCC, maLoai, tenLoai, tenNCC, hoTen, ngayThanhToan, soTien, noiDung) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        XJdbc.update(sql,
                Integer.valueOf(entity.getSoTaiKhoan()),
                entity.getMaNCC(),
                entity.getMaKLoai(),
                entity.getTenLoai(),
                entity.getTenNCC(),
                entity.getHoTen(),
                entity.getNgThanhToan(),
                entity.getSoTien(),
                entity.getNoiDung()
        );
    }
}

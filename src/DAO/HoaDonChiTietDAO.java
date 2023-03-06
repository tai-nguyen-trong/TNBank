/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.HoaDonChiTiet;
import Utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vietm
 */
public class HoaDonChiTietDAO {

    String insert_sql = "insert HoaDonChiTiet (soTaiKhoan, maNCC, maLoai, tenLoai, tenNCC, hoTen, ngayThanhToan, soTien, noiDung) values (?,?,?,?,?,?,?,?,?)";
    String selectAll_sql = "select * from HoaDonChiTiet";

    public void insert(HoaDonChiTiet entity) {
        XJdbc.update(insert_sql,
                entity.getSoTaiKhoan(),
                entity.getMaNCC(),
                entity.getMaLoai(),
                entity.getTenLoai(),
                entity.getTenNCC(),
                entity.getHoTen(),
                entity.getNgayThanhToan(),
                entity.getSoTien(),
                entity.getNoiDung()
        );
    }

    public List<HoaDonChiTiet> selectAll() {
        return selectBySql(selectAll_sql);
    }

    protected List<HoaDonChiTiet> selectBySql(String sql, Object... args) {
        List<HoaDonChiTiet> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                HoaDonChiTiet hd = new HoaDonChiTiet();
                hd.setMaHD(rs.getInt("maHD"));
                hd.setSoTaiKhoan(rs.getInt("soTaiKhoan"));
                hd.setMaNCC(rs.getString("maNCC"));
                hd.setMaLoai(rs.getString("maLoai"));
                hd.setTenLoai(rs.getString("tenLoai"));
                hd.setTenNCC(rs.getString("tenNCC"));
                hd.setHoTen(rs.getString("hoTen"));
                hd.setNgayThanhToan(rs.getString("ngayThanhToan"));
                hd.setSoTien(rs.getFloat("soTien"));
                hd.setNoiDung(rs.getString("noiDung"));
                list.add(hd);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<HoaDonChiTiet> selectByTenNhaCungCap(String maCungCap) {
        String sql = "SELECT * FROM HoaDonChiTiet WHERE maCungCap=?";
        return selectBySql(sql, maCungCap);

    }

    public List<Object> selectIdBySql(String sql, Object... args) {
        List<Object> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                list.add(rs.getObject(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Object> selectYear() {
        String sql = "select year(ngayThanhToan) from HoaDonChiTiet group by year(ngayThanhToan) order by year(ngayThanhToan) desc";
        return selectIdBySql(sql);
    }

    public List<HoaDonChiTiet> selectByYeartenNhaCungCap(String maloai, String year) {
        String sql = "select * from HoaDonChiTiet where maLoai = ? and year(ngayThanhToan) = ?";
        return selectBySql(sql, maloai, year);
    }

    public List<Object> selectCount() {
        String sql = "select COUNT(maHD) from HoaDonChiTiet";
        return selectIdBySql(sql);
    }
    
}

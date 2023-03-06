/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Utils.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vietm
 */
public class ThongKeDAO {

    private String selectByYear_sql = "select maHD, soTaiKhoan, soTien, ngayThanhToan, tenLoai from HoaDonChiTiet where year(ngayThanhToan) = ?";
    private String selectYearDK_sql = "select year(ngayThanhToan) from HoaDonChiTiet group by year(ngayThanhToan) order by year(ngayThanhToan) desc";

    public List<Integer> selectYear() {
        return selectYearDK(selectYearDK_sql);
    }

    public List<Object[]> selectByYear(int year) {
        String[] cols = {"Mã Hoa Đơn", "Số Tài Khoản", "Số Tiền", "Ngày Thanh Toán", "Loại"};
        return getListOfArray(selectByYear_sql, cols, year);
    }

    private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                Object[] row = new Object[cols.length];
                for (int i = 0; i < row.length; i++) {
                    row[i] = rs.getObject(i + 1);
                }
                list.add(row);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private List<Integer> selectYearDK(String sql, Object... args) {
        List<Integer> list = new ArrayList<Integer>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

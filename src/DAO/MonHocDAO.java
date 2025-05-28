package DAO;

import Model.MonHoc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MonHocDAO {
    private String dbURL = "jdbc:sqlserver://localhost:1433;"
                         + "databaseName=QLGV;user=sa;password=sa;";
    
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbURL);
    }
    
    // Lấy danh sách tất cả môn học
    public List<MonHoc> getAllMonHoc() {
        List<MonHoc> dsMonHoc = new ArrayList<>();
        String sql = "SELECT MAMH, TENMH, TCLT, TCTH, MAKHOA FROM MONHOC";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                MonHoc mh = new MonHoc();
                mh.setMaMH(rs.getString("MAMH"));
                mh.setTenMH(rs.getString("TENMH"));
                mh.setTCLT(rs.getInt("TCLT"));
                mh.setTCTH(rs.getInt("TCTH"));
                mh.setMaKhoa(rs.getString("MAKHOA"));
                dsMonHoc.add(mh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsMonHoc;
    }
    
    // Thêm môn học mới
    public boolean themMonHoc(MonHoc mh) {
        String sql = "INSERT INTO MONHOC (MAMH, TENMH, TCLT, TCTH, MAKHOA) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, mh.getMaMH());
            stmt.setString(2, mh.getTenMH());
            stmt.setInt(3, mh.getTCLT());
            stmt.setInt(4, mh.getTCTH());
            stmt.setString(5, mh.getMaKhoa());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Sửa thông tin môn học
    public boolean suaMonHoc(MonHoc mh) {
        String sql = "UPDATE MONHOC SET TENMH=N?, TCLT=?, TCTH=?, MAKHOA=? WHERE MAMH=?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, mh.getTenMH());
            stmt.setInt(2, mh.getTCLT());
            stmt.setInt(3, mh.getTCTH());
            stmt.setString(4, mh.getMaKhoa());
            stmt.setString(5, mh.getMaMH());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Xóa môn học
    public boolean xoaMonHoc(String maMH) {
        String sql = "DELETE FROM MONHOC WHERE MAMH=?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, maMH);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Tìm kiếm theo mã môn học
    public MonHoc timTheoMaMH(String maMH) {
        String sql = "SELECT * FROM MONHOC WHERE MAMH=?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, maMH);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                MonHoc mh = new MonHoc();
                mh.setMaMH(rs.getString("MAMH"));
                mh.setTenMH(rs.getString("TENMH"));
                mh.setTCLT(rs.getInt("TCLT"));
                mh.setTCTH(rs.getInt("TCTH"));
                mh.setMaKhoa(rs.getString("MAKHOA"));
                return mh;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    // Tìm kiếm theo tín chỉ lý thuyết
    public List<MonHoc> timTheoTCLT(int tclt) {
        List<MonHoc> dsMonHoc = new ArrayList<>();
        String sql = "SELECT * FROM MONHOC WHERE TCLT=?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, tclt);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                MonHoc mh = new MonHoc();
                mh.setMaMH(rs.getString("MAMH"));
                mh.setTenMH(rs.getString("TENMH"));
                mh.setTCLT(rs.getInt("TCLT"));
                mh.setTCTH(rs.getInt("TCTH"));
                mh.setMaKhoa(rs.getString("MAKHOA"));
                dsMonHoc.add(mh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsMonHoc;
    }
    
    // Tìm kiếm theo tín chỉ thực hành
    public List<MonHoc> timTheoTCTH(int tcth) {
        List<MonHoc> dsMonHoc = new ArrayList<>();
        String sql = "SELECT * FROM MONHOC WHERE TCTH=?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, tcth);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                MonHoc mh = new MonHoc();
                mh.setMaMH(rs.getString("MAMH"));
                mh.setTenMH(rs.getString("TENMH"));
                mh.setTCLT(rs.getInt("TCLT"));
                mh.setTCTH(rs.getInt("TCTH"));
                mh.setMaKhoa(rs.getString("MAKHOA"));
                dsMonHoc.add(mh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsMonHoc;
    }
    
    // Tìm kiếm theo mã khoa
    public List<MonHoc> timTheoMaKhoa(String maKhoa) {
        List<MonHoc> dsMonHoc = new ArrayList<>();
        String sql = "SELECT * FROM MONHOC WHERE MAKHOA=?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, maKhoa);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                MonHoc mh = new MonHoc();
                mh.setMaMH(rs.getString("MAMH"));
                mh.setTenMH(rs.getString("TENMH"));
                mh.setTCLT(rs.getInt("TCLT"));
                mh.setTCTH(rs.getInt("TCTH"));
                mh.setMaKhoa(rs.getString("MAKHOA"));
                dsMonHoc.add(mh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsMonHoc;
    }
}

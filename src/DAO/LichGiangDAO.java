package DAO;

import Model.LichGiang;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LichGiangDAO {
    private String dbURL = "jdbc:sqlserver://localhost:1433;"
                         + "databaseName=QLGV;user=sa;password=sa;";
    
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbURL);
    }
    
    // Lấy tất cả lịch giảng
    public List<LichGiang> getAllLichGiang() {
        List<LichGiang> dsLichGiang = new ArrayList<>();
        String sql = "SELECT * FROM GIANGDAY";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                LichGiang lg = new LichGiang();
                lg.setMaLop(rs.getString("MALOP"));
                lg.setMaMH(rs.getString("MAMH"));
                lg.setMaGV(rs.getString("MAGV"));
                lg.setHocKy(rs.getString("HOCKY"));
                lg.setNam(rs.getInt("NAM"));
                lg.setNgBatDau(rs.getString("TUNGAY"));
                lg.setNgKetThuc(rs.getString("DENNGAY"));
                dsLichGiang.add(lg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsLichGiang;
    }
    
    // Thêm lịch giảng
    public boolean themLichGiang(LichGiang lg) {
        String sql = "INSERT INTO GIANGDAY (MALOP, MAMH, MAGV, HOCKY, NAM, TUNGAY, DENNGAY) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, lg.getMaLop());
            stmt.setString(2, lg.getMaMH());
            stmt.setString(3, lg.getMaGV());
            stmt.setString(4, lg.getHocKy());
            stmt.setInt(5, lg.getNam());
            stmt.setString(6, lg.getNgBatDau());
            stmt.setString(7, lg.getNgKetThuc());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Sửa lịch giảng
    public boolean suaLichGiang(LichGiang lg) {
        String sql = "UPDATE GIANGDAY SET HOCKY=?, NAM=?, TUNGAY=?, DENNGAY=? " +
                    "WHERE MALOP=? AND MAMH=? AND MAGV=?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, lg.getHocKy());
            stmt.setInt(2, lg.getNam());
            stmt.setString(3, lg.getNgBatDau());
            stmt.setString(4, lg.getNgKetThuc());
            stmt.setString(5, lg.getMaLop());
            stmt.setString(6, lg.getMaMH());
            stmt.setString(7, lg.getMaGV());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Xóa lịch giảng
    public boolean xoaLichGiang(String maLop, String maMH, String maGV) {
        String sql = "DELETE FROM GIANGDAY WHERE MALOP=? AND MAMH=? AND MAGV=?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, maLop);
            stmt.setString(2, maMH);
            stmt.setString(3, maGV);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Tìm theo mã lớp
    public List<LichGiang> timTheoMaLop(String maLop) {
        List<LichGiang> dsLichGiang = new ArrayList<>();
        String sql = "SELECT * FROM GIANGDAY WHERE MALOP=?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, maLop);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                LichGiang lg = new LichGiang();
                lg.setMaLop(rs.getString("MALOP"));
                lg.setMaMH(rs.getString("MAMH"));
                lg.setMaGV(rs.getString("MAGV"));
                lg.setHocKy(rs.getString("HOCKY"));
                lg.setNam(rs.getInt("NAM"));
                lg.setNgBatDau(rs.getString("TUNGAY"));
                lg.setNgKetThuc(rs.getString("DENNGAY"));
                dsLichGiang.add(lg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsLichGiang;
    }
    
    // Tìm theo mã môn học
    public List<LichGiang> timTheoMaMH(String maMH) {
        List<LichGiang> dsLichGiang = new ArrayList<>();
        String sql = "SELECT * FROM GIANGDAY WHERE MAMH=?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, maMH);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                LichGiang lg = new LichGiang();
                lg.setMaLop(rs.getString("MALOP"));
                lg.setMaMH(rs.getString("MAMH"));
                lg.setMaGV(rs.getString("MAGV"));
                lg.setHocKy(rs.getString("HOCKY"));
                lg.setNam(rs.getInt("NAM"));
                lg.setNgBatDau(rs.getString("TUNGAY"));
                lg.setNgKetThuc(rs.getString("DENNGAY"));
                dsLichGiang.add(lg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsLichGiang;
    }
    
    // Tìm theo mã giáo viên
    public List<LichGiang> timTheoMaGV(String maGV) {
        List<LichGiang> dsLichGiang = new ArrayList<>();
        String sql = "SELECT * FROM GIANGDAY WHERE MAGV=?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, maGV);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                LichGiang lg = new LichGiang();
                lg.setMaLop(rs.getString("MALOP"));
                lg.setMaMH(rs.getString("MAMH"));
                lg.setMaGV(rs.getString("MAGV"));
                lg.setHocKy(rs.getString("HOCKY"));
                lg.setNam(rs.getInt("NAM"));
                lg.setNgBatDau(rs.getString("TUNGAY"));
                lg.setNgKetThuc(rs.getString("DENNGAY"));
                dsLichGiang.add(lg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsLichGiang;
    }
    
    // Tìm theo học kỳ
    public List<LichGiang> timTheoHocKy(String hocKy) {
        List<LichGiang> dsLichGiang = new ArrayList<>();
        String sql = "SELECT * FROM GIANGDAY WHERE HOCKY=?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, hocKy);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                LichGiang lg = new LichGiang();
                lg.setMaLop(rs.getString("MALOP"));
                lg.setMaMH(rs.getString("MAMH"));
                lg.setMaGV(rs.getString("MAGV"));
                lg.setHocKy(rs.getString("HOCKY"));
                lg.setNam(rs.getInt("NAM"));
                lg.setNgBatDau(rs.getString("TUNGAY"));
                lg.setNgKetThuc(rs.getString("DENNGAY"));
                dsLichGiang.add(lg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsLichGiang;
    }
    
    // Tìm theo năm
    public List<LichGiang> timTheoNam(int nam) {
        List<LichGiang> dsLichGiang = new ArrayList<>();
        String sql = "SELECT * FROM GIANGDAY WHERE NAM=?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, nam);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                LichGiang lg = new LichGiang();
                lg.setMaLop(rs.getString("MALOP"));
                lg.setMaMH(rs.getString("MAMH"));
                lg.setMaGV(rs.getString("MAGV"));
                lg.setHocKy(rs.getString("HOCKY"));
                lg.setNam(rs.getInt("NAM"));
                lg.setNgBatDau(rs.getString("TUNGAY"));
                lg.setNgKetThuc(rs.getString("DENNGAY"));
                dsLichGiang.add(lg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsLichGiang;
    }
}

package Model.DAO;

import Connection.DatabaseConnection;
import Model.Object.DiemThi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DiemThiDAO {
    private DatabaseConnection dbConnection;
    
    public DiemThiDAO() {
        dbConnection = DatabaseConnection.getInstance();
    }
    
    private Connection getConnection() throws SQLException {
        return dbConnection.getConnection();
    }
    
    public List<DiemThi> getAllDiemThi() {
        List<DiemThi> list = new ArrayList<>();
        String sql = "SELECT * FROM KETQUATHI";
        
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                DiemThi dt = new DiemThi();
                dt.setMaHV(rs.getString("MAHV"));
                dt.setMaMH(rs.getString("MAMH"));
                dt.setLanThi(rs.getInt("LANTHI"));
                dt.setNgThi(rs.getString("NGAYTHI"));
                dt.setDiem(rs.getFloat("DIEM"));
                dt.setKetQua(rs.getString("KQUA"));
                list.add(dt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean themDiemThi(DiemThi dt) {
        String sql = "INSERT INTO KETQUATHI(MAHV, MAMH, LANTHI, NGAYTHI, DIEM, KQUA) VALUES(?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, dt.getMaHV());
            ps.setString(2, dt.getMaMH());
            ps.setInt(3, dt.getLanThi());
            ps.setString(4, dt.getNgThi());
            ps.setFloat(5, dt.getDiem());
            ps.setString(6, dt.getKetQua());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean suaDiemThi(DiemThi dt) {
        String sql = "UPDATE KETQUATHI SET NGAYTHI=?, DIEM=?, KQUA=? WHERE MAHV=? AND MAMH=? AND LANTHI=?";
        
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, dt.getNgThi());
            ps.setFloat(2, dt.getDiem());
            ps.setString(3, dt.getKetQua());
            ps.setString(4, dt.getMaHV());
            ps.setString(5, dt.getMaMH());
            ps.setInt(6, dt.getLanThi());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean xoaDiemThi(String maHV, String maMH, int lanThi) {
        String sql = "DELETE FROM KETQUATHI WHERE MAHV=? AND MAMH=? AND LANTHI=?";
        
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, maHV);
            ps.setString(2, maMH);
            ps.setInt(3, lanThi);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<DiemThi> timKiemTheoMaMH(String maMH) {
        List<DiemThi> list = new ArrayList<>();
        String sql = "SELECT * FROM KETQUATHI WHERE MAMH LIKE ?";
        
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, "%" + maMH + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DiemThi dt = new DiemThi();
                dt.setMaHV(rs.getString("MAHV"));
                dt.setMaMH(rs.getString("MAMH"));
                dt.setLanThi(rs.getInt("LANTHI"));
                dt.setNgThi(rs.getString("NGAYTHI"));
                dt.setDiem(rs.getFloat("DIEM"));
                dt.setKetQua(rs.getString("KQUA"));
                list.add(dt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<DiemThi> timKiemTheoLanThi(int lanThi) {
        List<DiemThi> list = new ArrayList<>();
        String sql = "SELECT * FROM KETQUATHI WHERE LANTHI = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, lanThi);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DiemThi dt = new DiemThi();
                dt.setMaHV(rs.getString("MAHV"));
                dt.setMaMH(rs.getString("MAMH"));
                dt.setLanThi(rs.getInt("LANTHI"));
                dt.setNgThi(rs.getString("NGAYTHI"));
                dt.setDiem(rs.getFloat("DIEM"));
                dt.setKetQua(rs.getString("KQUA"));
                list.add(dt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<DiemThi> timKiemTheoDiem(float diem) {
        List<DiemThi> list = new ArrayList<>();
        String sql = "SELECT * FROM KETQUATHI WHERE DIEM = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setFloat(1, diem);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DiemThi dt = new DiemThi();
                dt.setMaHV(rs.getString("MAHV"));
                dt.setMaMH(rs.getString("MAMH"));
                dt.setLanThi(rs.getInt("LANTHI"));
                dt.setNgThi(rs.getString("NGAYTHI"));
                dt.setDiem(rs.getFloat("DIEM"));
                dt.setKetQua(rs.getString("KQUA"));
                list.add(dt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

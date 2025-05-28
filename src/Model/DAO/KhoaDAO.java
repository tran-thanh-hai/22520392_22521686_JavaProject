package Model.DAO;

import Connection.DatabaseConnection;
import Model.Object.Khoa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KhoaDAO {
    private DatabaseConnection dbConnection;
    
    public KhoaDAO() {
        dbConnection = DatabaseConnection.getInstance();
    }
    
    private Connection getConnection() throws SQLException {
        return dbConnection.getConnection();
    }
    

    public List<Khoa> getAllKhoa() {
        List<Khoa> danhSachKhoa = new ArrayList<>();
        String sql = "SELECT * FROM KHOA";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Khoa khoa = new Khoa();
                khoa.setMaKhoa(rs.getString("MAKHOA"));
                khoa.setTenKhoa(rs.getString("TENKHOA"));
                khoa.setNgThanhLap(rs.getString("NGTLAP"));
                khoa.setTrgKhoa(rs.getString("TRGKHOA"));
                danhSachKhoa.add(khoa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachKhoa;
    }
    

    public boolean themKhoa(Khoa khoa) {
        String sql = "INSERT INTO KHOA (MAKHOA, TENKHOA, NGTLAP, TRGKHOA) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, khoa.getMaKhoa());
            stmt.setString(2, khoa.getTenKhoa());
            stmt.setString(3, khoa.getNgThanhLap());
            stmt.setString(4, khoa.getTrgKhoa());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
        

    public boolean suaKhoa(Khoa khoa) {
        String sql = "UPDATE KHOA SET TENKHOA = ?, NGTLAP = ?, TRGKHOA = ? WHERE MAKHOA = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, khoa.getTenKhoa());
            stmt.setString(2, khoa.getNgThanhLap());
            stmt.setString(3, khoa.getTrgKhoa());
            stmt.setString(4, khoa.getMaKhoa());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    

    public boolean xoaKhoa(String maKhoa) {
        String sql = "DELETE FROM KHOA WHERE MAKHOA = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, maKhoa);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    

    public Khoa timKhoaTheoMa(String maKhoa) {
        String sql = "SELECT * FROM KHOA WHERE MAKHOA = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, maKhoa);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Khoa khoa = new Khoa();
                khoa.setMaKhoa(rs.getString("MAKHOA"));
                khoa.setTenKhoa(rs.getString("TENKHOA"));
                khoa.setNgThanhLap(rs.getString("NGTLAP"));
                khoa.setTrgKhoa(rs.getString("TRGKHOA"));
                return khoa;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
} 
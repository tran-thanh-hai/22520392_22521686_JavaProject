package Model.DAO;

import Connection.DatabaseConnection;
import Model.Object.Lop;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LopDAO {
    private DatabaseConnection dbConnection;
    
    public LopDAO() {
        dbConnection = DatabaseConnection.getInstance();
    }
    
    private Connection getConnection() throws SQLException {
        return dbConnection.getConnection();
    }
    
    public List<Lop> getAllLop() {
        List<Lop> list = new ArrayList<>();
        String sql = "SELECT * FROM LOP";
        
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Lop lop = new Lop();
                lop.setMaLop(rs.getString("MALOP"));
                lop.setTenLop(rs.getString("TENLOP"));
                lop.setTrgLop(rs.getString("TRGLOP"));
                lop.setSiSo(rs.getInt("SISO"));
                lop.setMaGVCN(rs.getString("MAGVCN"));
                list.add(lop);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean themLop(Lop lop) {
        String sql = "INSERT INTO LOP(MALOP, TENLOP, TRGLOP, SISO, MAGVCN) VALUES(?, ?, ?, ?, ?)";
        
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, lop.getMaLop());
            ps.setString(2, lop.getTenLop());
            ps.setString(3, lop.getTrgLop());
            ps.setInt(4, lop.getSiSo());
            ps.setString(5, lop.getMaGVCN());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean suaLop(Lop lop) {
        String sql = "UPDATE LOP SET TENLOP=?, TRGLOP=?, SISO=?, MAGVCN=? WHERE MALOP=?";
        
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, lop.getTenLop());
            ps.setString(2, lop.getTrgLop());
            ps.setInt(3, lop.getSiSo());
            ps.setString(4, lop.getMaGVCN());
            ps.setString(5, lop.getMaLop());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean xoaLop(String maLop) {
        String sql = "DELETE FROM LOP WHERE MALOP=?";
        
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, maLop);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<Lop> timKiemTheoMaLop(String maLop) {
        List<Lop> list = new ArrayList<>();
        String sql = "SELECT * FROM LOP WHERE MALOP LIKE ?";
        
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, "%" + maLop + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Lop lop = new Lop();
                lop.setMaLop(rs.getString("MALOP"));
                lop.setTenLop(rs.getString("TENLOP"));
                lop.setTrgLop(rs.getString("TRGLOP"));
                lop.setSiSo(rs.getInt("SISO"));
                lop.setMaGVCN(rs.getString("MAGVCN"));
                list.add(lop);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<Lop> timKiemTheoMaGVCN(String maGVCN) {
        List<Lop> list = new ArrayList<>();
        String sql = "SELECT * FROM LOP WHERE MAGVCN LIKE ?";
        
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, "%" + maGVCN + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Lop lop = new Lop();
                lop.setMaLop(rs.getString("MALOP"));
                lop.setTenLop(rs.getString("TENLOP"));
                lop.setTrgLop(rs.getString("TRGLOP"));
                lop.setSiSo(rs.getInt("SISO"));
                lop.setMaGVCN(rs.getString("MAGVCN"));
                list.add(lop);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

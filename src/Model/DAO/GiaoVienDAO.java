package Model.DAO;

import Connection.DatabaseConnection;
import Model.Object.GiaoVien;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GiaoVienDAO {
    private DatabaseConnection dbConnection;
    
    public GiaoVienDAO() {
        dbConnection = DatabaseConnection.getInstance();
    }
    
    private Connection getConnection() throws SQLException {
        return dbConnection.getConnection();
    }
    

    public List<GiaoVien> getAllGiaoVien() {
        List<GiaoVien> danhSachGV = new ArrayList<>();
        String sql = "SELECT * FROM GIAOVIEN";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                GiaoVien gv = new GiaoVien();
                gv.setMaGV(rs.getString("MAGV"));
                gv.setHoTen(rs.getString("HOTEN"));
                gv.setChucVu(rs.getString("CHUCVU"));
                gv.setGioiTinh(rs.getString("GIOITINH"));
                gv.setMaKhoa(rs.getString("MAKHOA"));
                gv.setNgaySinh(rs.getString("NGAYSINH"));
                gv.setNgVaoLam(rs.getString("NGAYVAOLAM"));
                gv.setHeSoLuong(rs.getFloat("HESOLUONG"));
                gv.setLuongCoBan(rs.getFloat("LUONGCOBAN"));
                gv.setLuong(rs.getFloat("LUONG"));
                danhSachGV.add(gv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachGV;
    }
    

    public boolean themGiaoVien(GiaoVien gv) {
        String sql = "INSERT INTO GIAOVIEN (MAGV, HOTEN, CHUCVU, GIOITINH, MAKHOA, NGAYSINH, NGAYVAOLAM, HESOLUONG, LUONGCOBAN, LUONG) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, gv.getMaGV());
            stmt.setString(2, gv.getHoTen());
            stmt.setString(3, gv.getChucVu());
            stmt.setString(4, gv.getGioiTinh());
            stmt.setString(5, gv.getMaKhoa());
            stmt.setString(6, gv.getNgaySinh());
            stmt.setString(7, gv.getNgVaoLam());
            stmt.setFloat(8, gv.getHeSoLuong());
            stmt.setFloat(9, gv.getLuongCoBan());
            stmt.setFloat(10, gv.getLuong());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    

    public boolean suaGiaoVien(GiaoVien gv) {
        String sql = "UPDATE GIAOVIEN SET HOTEN = ?, CHUCVU = ?, GIOITINH = ?, MAKHOA = ?, " +
                    "NGAYSINH = ?, NGAYVAOLAM = ?, HESOLUONG = ?, LUONGCOBAN = ?, LUONG = ? " +
                    "WHERE MAGV = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, gv.getHoTen());
            stmt.setString(2, gv.getChucVu());
            stmt.setString(3, gv.getGioiTinh());
            stmt.setString(4, gv.getMaKhoa());
            stmt.setString(5, gv.getNgaySinh());
            stmt.setString(6, gv.getNgVaoLam());
            stmt.setFloat(7, gv.getHeSoLuong());
            stmt.setFloat(8, gv.getLuongCoBan());
            stmt.setFloat(9, gv.getLuong());
            stmt.setString(10, gv.getMaGV());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    

    public boolean xoaGiaoVien(String maGV) {
        String sql = "DELETE FROM GIAOVIEN WHERE MAGV = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, maGV);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public GiaoVien timTheoMaGV(String maGV) {
        String sql = "SELECT * FROM GIAOVIEN WHERE MAGV = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, maGV);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                GiaoVien gv = new GiaoVien();
                gv.setMaGV(rs.getString("MAGV"));
                gv.setHoTen(rs.getString("HOTEN"));
                gv.setChucVu(rs.getString("CHUCVU"));
                gv.setGioiTinh(rs.getString("GIOITINH"));
                gv.setMaKhoa(rs.getString("MAKHOA"));
                gv.setNgaySinh(rs.getString("NGAYSINH"));
                gv.setNgVaoLam(rs.getString("NGAYVAOLAM"));
                gv.setHeSoLuong(rs.getFloat("HESOLUONG"));
                gv.setLuongCoBan(rs.getFloat("LUONGCOBAN"));
                gv.setLuong(rs.getFloat("LUONG"));
                return gv;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    

    public List<GiaoVien> timTheoChucVu(String chucVu) {
        List<GiaoVien> danhSachGV = new ArrayList<>();
        String sql = "SELECT * FROM GIAOVIEN WHERE CHUCVU = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, chucVu);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                GiaoVien gv = new GiaoVien();
                gv.setMaGV(rs.getString("MAGV"));
                gv.setHoTen(rs.getString("HOTEN"));
                gv.setChucVu(rs.getString("CHUCVU"));
                gv.setGioiTinh(rs.getString("GIOITINH"));
                gv.setMaKhoa(rs.getString("MAKHOA"));
                gv.setNgaySinh(rs.getString("NGAYSINH"));
                gv.setNgVaoLam(rs.getString("NGAYVAOLAM"));
                gv.setHeSoLuong(rs.getFloat("HESOLUONG"));
                gv.setLuongCoBan(rs.getFloat("LUONGCOBAN"));
                gv.setLuong(rs.getFloat("LUONG"));
                danhSachGV.add(gv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachGV;
    }
    
    public List<GiaoVien> timTheoMaKhoa(String maKhoa) {
        List<GiaoVien> danhSachGV = new ArrayList<>();
        String sql = "SELECT * FROM GIAOVIEN WHERE MAKHOA = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, maKhoa);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                GiaoVien gv = new GiaoVien();
                gv.setMaGV(rs.getString("MAGV"));
                gv.setHoTen(rs.getString("HOTEN"));
                gv.setChucVu(rs.getString("CHUCVU"));
                gv.setGioiTinh(rs.getString("GIOITINH"));
                gv.setMaKhoa(rs.getString("MAKHOA"));
                gv.setNgaySinh(rs.getString("NGAYSINH"));
                gv.setNgVaoLam(rs.getString("NGAYVAOLAM"));
                gv.setHeSoLuong(rs.getFloat("HESOLUONG"));
                gv.setLuongCoBan(rs.getFloat("LUONGCOBAN"));
                gv.setLuong(rs.getFloat("LUONG"));
                danhSachGV.add(gv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachGV;
    }
    
    public List<GiaoVien> timTheoHeSoLuong(float heSoLuong) {
        List<GiaoVien> danhSachGV = new ArrayList<>();
        String sql = "SELECT * FROM GIAOVIEN WHERE HESOLUONG = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setFloat(1, heSoLuong);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                GiaoVien gv = new GiaoVien();
                gv.setMaGV(rs.getString("MAGV"));
                gv.setHoTen(rs.getString("HOTEN"));
                gv.setChucVu(rs.getString("CHUCVU"));
                gv.setGioiTinh(rs.getString("GIOITINH"));
                gv.setMaKhoa(rs.getString("MAKHOA"));
                gv.setNgaySinh(rs.getString("NGAYSINH"));
                gv.setNgVaoLam(rs.getString("NGAYVAOLAM"));
                gv.setHeSoLuong(rs.getFloat("HESOLUONG"));
                gv.setLuongCoBan(rs.getFloat("LUONGCOBAN"));
                gv.setLuong(rs.getFloat("LUONG"));
                danhSachGV.add(gv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachGV;
    }
    
    public boolean tinhLuong(String maGV) {
        String sql = "UPDATE GIAOVIEN SET LUONG = HESOLUONG * LUONGCOBAN WHERE MAGV = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, maGV);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean tinhLuongTatCa() {
        String sql = "UPDATE GIAOVIEN SET LUONG = HESOLUONG * LUONGCOBAN";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

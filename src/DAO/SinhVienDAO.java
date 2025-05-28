package DAO;

import Model.SinhVien;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SinhVienDAO {
    private String dbURL = "jdbc:sqlserver://localhost:1433;"
                         + "databaseName=QLGV;user=sa;password=sa;";
    
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbURL);
    }
    
    // Lấy tất cả sinh viên
    public List<SinhVien> getAllSinhVien() {
        List<SinhVien> dsSinhVien = new ArrayList<>();
        String sql = "SELECT MAHV, HOTEN, CHUCVU, GIOITINH, NGAYSINH, MALOP, NOISINH, DIEMTB, XEPLOAI FROM SINHVIEN";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                SinhVien sv = new SinhVien();
                sv.setMaHV(rs.getString("MAHV"));
                sv.setHoTen(rs.getString("HOTEN"));
                sv.setChucVu(rs.getString("CHUCVU"));
                sv.setGioiTinh(rs.getString("GIOITINH"));
                sv.setNgaySinh(rs.getString("NGAYSINH"));
                sv.setMaLop(rs.getString("MALOP"));
                sv.setNoiSinh(rs.getString("NOISINH"));
                sv.setDiemTB(rs.getFloat("DIEMTB"));
                sv.setXepLoai(rs.getString("XEPLOAI"));
                dsSinhVien.add(sv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsSinhVien;
    }
    
    // Thêm sinh viên mới
    public boolean themSinhVien(SinhVien sv) {
        String sql = "INSERT INTO SINHVIEN (MAHV, HOTEN, CHUCVU, GIOITINH, NGAYSINH, MALOP, NOISINH) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, sv.getMaHV());
            stmt.setString(2, sv.getHoTen());
            stmt.setString(3, sv.getChucVu());
            stmt.setString(4, sv.getGioiTinh());
            stmt.setString(5, sv.getNgaySinh());
            stmt.setString(6, sv.getMaLop());
            stmt.setString(7, sv.getNoiSinh());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Sửa thông tin sinh viên
    public boolean suaSinhVien(SinhVien sv) {
        String sql = "UPDATE SINHVIEN SET HOTEN=?, CHUCVU=?, GIOITINH=?, NGAYSINH=?, MALOP=?, NOISINH=? WHERE MAHV=?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, sv.getHoTen());
            stmt.setString(2, sv.getChucVu());
            stmt.setString(3, sv.getGioiTinh());
            stmt.setString(4, sv.getNgaySinh());
            stmt.setString(5, sv.getMaLop());
            stmt.setString(6, sv.getNoiSinh());
            stmt.setString(7, sv.getMaHV());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Xóa sinh viên
    public boolean xoaSinhVien(String maHV) {
        String sql = "DELETE FROM SINHVIEN WHERE MAHV=?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, maHV);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Tính điểm trung bình
    public boolean tinhDiemTrungBinh(String maHV) {
        // Trước tiên, tính điểm trung bình từ bảng KETQUATHI
        String sqlTinhDTB = 
            "SELECT AVG(DIEM) as DTB FROM " +
            "(SELECT MAHV, MAMH, LANTHI, DIEM, " +
            "ROW_NUMBER() OVER (PARTITION BY MAHV, MAMH ORDER BY LANTHI DESC) as LastAttempt " +
            "FROM KETQUATHI " +
            "WHERE MAHV = ? AND KQUA = N'Đạt') tmp " +  // Chỉ tính điểm của các lần thi đạt
            "WHERE LastAttempt = 1";  // Chỉ lấy lần thi cuối cùng của mỗi môn

        // Sau đó cập nhật vào bảng SINHVIEN
        String sqlUpdateSV = "UPDATE SINHVIEN SET DIEMTB = ? WHERE MAHV = ?";
        
        try (Connection conn = getConnection()) {
            // Tính điểm trung bình
            float diemTB = 0;
            
            try (PreparedStatement stmtTinhDTB = conn.prepareStatement(sqlTinhDTB)) {
                stmtTinhDTB.setString(1, maHV);
                ResultSet rs = stmtTinhDTB.executeQuery();
                
                if (rs.next()) {
                    diemTB = rs.getFloat("DTB");
                }
            }
            
            // Cập nhật điểm trung bình vào bảng SINHVIEN
            try (PreparedStatement stmtUpdateSV = conn.prepareStatement(sqlUpdateSV)) {
                stmtUpdateSV.setFloat(1, diemTB);
                stmtUpdateSV.setString(2, maHV);
                
                return stmtUpdateSV.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Xếp loại
    public boolean xepLoai(String maHV) {
        String sql = "UPDATE SINHVIEN SET XEPLOAI = CASE " +
                    "WHEN DIEMTB >= 8.5 THEN N'Xuất sắc' " +
                    "WHEN DIEMTB >= 7.0 THEN N'Khá' " +
                    "WHEN DIEMTB >= 5.5 THEN N'Trung bình' " +
                    "ELSE N'Yếu' END " +
                    "WHERE MAHV=?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, maHV);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Tìm kiếm theo mã sinh viên
    public SinhVien timTheoMaSV(String maHV) {
        String sql = "SELECT * FROM SINHVIEN WHERE MAHV=?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, maHV);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                SinhVien sv = new SinhVien();
                sv.setMaHV(rs.getString("MAHV"));
                sv.setHoTen(rs.getString("HOTEN"));
                sv.setChucVu(rs.getString("CHUCVU"));
                sv.setGioiTinh(rs.getString("GIOITINH"));
                sv.setNgaySinh(rs.getString("NGAYSINH"));
                sv.setMaLop(rs.getString("MALOP"));
                sv.setNoiSinh(rs.getString("NOISINH"));
                sv.setDiemTB(rs.getFloat("DIEMTB"));
                sv.setXepLoai(rs.getString("XEPLOAI"));
                return sv;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    // Tìm kiếm theo mã lớp
    public List<SinhVien> timTheoMaLop(String maLop) {
        List<SinhVien> dsSinhVien = new ArrayList<>();
        String sql = "SELECT * FROM SINHVIEN WHERE MALOP=?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, maLop);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                SinhVien sv = new SinhVien();
                sv.setMaHV(rs.getString("MAHV"));
                sv.setHoTen(rs.getString("HOTEN"));
                sv.setChucVu(rs.getString("CHUCVU"));
                sv.setGioiTinh(rs.getString("GIOITINH"));
                sv.setNgaySinh(rs.getString("NGAYSINH"));
                sv.setMaLop(rs.getString("MALOP"));
                sv.setNoiSinh(rs.getString("NOISINH"));
                sv.setDiemTB(rs.getFloat("DIEMTB"));
                sv.setXepLoai(rs.getString("XEPLOAI"));
                dsSinhVien.add(sv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsSinhVien;
    }
    
    // Tính điểm trung bình cho tất cả sinh viên
    public boolean tinhDiemTrungBinhTatCa() {
        // Lấy danh sách tất cả mã học viên
        String sqlGetAllMaHV = "SELECT DISTINCT MAHV FROM SINHVIEN";
        
        try (Connection conn = getConnection();
             PreparedStatement stmtGetMaHV = conn.prepareStatement(sqlGetAllMaHV);
             ResultSet rs = stmtGetMaHV.executeQuery()) {
            
            boolean success = true;
            while (rs.next()) {
                String maHV = rs.getString("MAHV");
                if (!tinhDiemTrungBinh(maHV)) {
                    success = false;
                }
            }
            return success;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Xếp loại cho tất cả sinh viên
    public boolean xepLoaiTatCa() {
        String sql = "UPDATE SINHVIEN SET XEPLOAI = CASE " +
                    "WHEN DIEMTB >= 8.5 THEN N'Xuất sắc' " +
                    "WHEN DIEMTB >= 7.0 THEN N'Khá' " +
                    "WHEN DIEMTB >= 5.5 THEN N'Trung bình' " +
                    "ELSE N'Yếu' END";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

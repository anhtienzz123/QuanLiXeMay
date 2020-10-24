package converter;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.KhachHang;
import entity.NhanVienHanhChinh;

public class NhanVienHanhChinhConvert {

	public NhanVienHanhChinhConvert() {

	}

	public static NhanVienHanhChinh getNhanVienHanhChinh(ResultSet resultSet) throws SQLException {

		String maNVHanhChinh = resultSet.getString("maNVHanhChinh");
		String hoTenNV = resultSet.getString("hoTenNV");
		String matKhau = resultSet.getString("matKhau");
		Date ngaySinh = resultSet.getDate("ngaySinh");
		String soDienThoai = resultSet.getString("soDienThoai");
		String diaChi = resultSet.getString("diaChi");
		String chucVu = resultSet.getString("chucVu");
		String trinhDoHocVan = resultSet.getString("trinhDoHocVan");
		boolean vaiTro = resultSet.getBoolean("vaiTro");

		NhanVienHanhChinh NVHanhChinh = new NhanVienHanhChinh(maNVHanhChinh, hoTenNV, matKhau, ngaySinh, soDienThoai,
				diaChi, chucVu, trinhDoHocVan, vaiTro);
		return NVHanhChinh;
	}

	public static void themNhanVienHanhChinh(PreparedStatement preparedStatement, NhanVienHanhChinh NVHanhChinh)
			throws SQLException {
		preparedStatement.setString(1, NVHanhChinh.getMaNVHanhChinh());
		preparedStatement.setString(2, NVHanhChinh.getHoTenNV());
		preparedStatement.setString(3, NVHanhChinh.getMatKhau());
		preparedStatement.setDate(4, NVHanhChinh.getNgaySinh());
		preparedStatement.setString(5, NVHanhChinh.getSoDienThoai());
		preparedStatement.setString(6, NVHanhChinh.getDiaChi());
		preparedStatement.setString(7, NVHanhChinh.getChucVu());
		preparedStatement.setString(8, NVHanhChinh.getTrinhDoHocVan());
		preparedStatement.setBoolean(9, NVHanhChinh.isVaiTro());

	}

	public static void capNhatNhanVienHanhChinh(PreparedStatement preparedStatement, NhanVienHanhChinh NVHanhChinh)
			throws SQLException {
		
		preparedStatement.setString(1, NVHanhChinh.getHoTenNV());
		preparedStatement.setString(2, NVHanhChinh.getMatKhau());
		preparedStatement.setDate(3, NVHanhChinh.getNgaySinh());
		preparedStatement.setString(4, NVHanhChinh.getSoDienThoai());
		preparedStatement.setString(5, NVHanhChinh.getDiaChi());
		preparedStatement.setString(6, NVHanhChinh.getChucVu());
		preparedStatement.setString(7, NVHanhChinh.getTrinhDoHocVan());
		preparedStatement.setBoolean(8, NVHanhChinh.isVaiTro());
		preparedStatement.setString(9, NVHanhChinh.getMaNVHanhChinh());
	}

}

package converter;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		String tenAnh = resultSet.getString("tenAnh");
		boolean vaiTro = resultSet.getBoolean("vaiTro");
		boolean gioiTinh = resultSet.getBoolean("gioiTinh");
		boolean trangThai = resultSet.getBoolean("trangThai");

		NhanVienHanhChinh NVHanhChinh = new NhanVienHanhChinh(maNVHanhChinh, hoTenNV, matKhau, gioiTinh, ngaySinh,
				soDienThoai, diaChi, tenAnh, chucVu, trinhDoHocVan, vaiTro, trangThai);
		return NVHanhChinh;
	}

	public static void themNhanVienHanhChinh(PreparedStatement preparedStatement, NhanVienHanhChinh NVHanhChinh)
			throws SQLException {
		preparedStatement.setString(1, NVHanhChinh.getMaNVHanhChinh());
		preparedStatement.setString(2, NVHanhChinh.getHoTenNV());
		preparedStatement.setString(3, NVHanhChinh.getMatKhau());
		preparedStatement.setBoolean(4, NVHanhChinh.isGioiTinh());
		preparedStatement.setDate(5, NVHanhChinh.getNgaySinh());
		preparedStatement.setString(6, NVHanhChinh.getSoDienThoai());
		preparedStatement.setString(7, NVHanhChinh.getDiaChi());
		preparedStatement.setString(8, NVHanhChinh.getTenAnh());
		preparedStatement.setString(9, NVHanhChinh.getChucVu());
		preparedStatement.setString(10, NVHanhChinh.getTrinhDoHocVan());
		preparedStatement.setBoolean(11, NVHanhChinh.isVaiTro());
		preparedStatement.setBoolean(12, NVHanhChinh.isTrangThai());

	}

	public static void capNhatNhanVienHanhChinh(PreparedStatement preparedStatement, NhanVienHanhChinh NVHanhChinh)
			throws SQLException {

		preparedStatement.setString(1, NVHanhChinh.getHoTenNV());
		preparedStatement.setString(2, NVHanhChinh.getMatKhau());
		preparedStatement.setBoolean(3, NVHanhChinh.isGioiTinh());
		preparedStatement.setDate(4, NVHanhChinh.getNgaySinh());
		preparedStatement.setString(5, NVHanhChinh.getSoDienThoai());
		preparedStatement.setString(6, NVHanhChinh.getDiaChi());
		preparedStatement.setString(7, NVHanhChinh.getTenAnh());
		preparedStatement.setString(8, NVHanhChinh.getChucVu());
		preparedStatement.setString(9, NVHanhChinh.getTrinhDoHocVan());
		preparedStatement.setBoolean(10, NVHanhChinh.isVaiTro());
		preparedStatement.setBoolean(11, NVHanhChinh.isTrangThai());
		preparedStatement.setString(12, NVHanhChinh.getMaNVHanhChinh());
	}

}

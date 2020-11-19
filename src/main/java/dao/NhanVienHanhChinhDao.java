package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import constant.KhachHangConstant;
import constant.NhanVienHanhChinhConstant;
import constant.NhanVienKiThuatConstant;
import converter.KhachHangConverter;
import converter.NhanVienHanhChinhConvert;
import db.DatabaseConnect;
import entity.KhachHang;
import entity.NhanVienHanhChinh;

public class NhanVienHanhChinhDao {
	private static NhanVienHanhChinhDao instance;
	private Connection connection;

	private NhanVienHanhChinhDao() {
		connection = DatabaseConnect.getInstance();
	}

	public static NhanVienHanhChinhDao getInstance() {
		if (instance == null)
			instance = new NhanVienHanhChinhDao();
		return instance;
	}

	public List<NhanVienHanhChinh> getNVHanhChinh() {
		List<NhanVienHanhChinh> nvHanhChinhs = new ArrayList<NhanVienHanhChinh>();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(NhanVienHanhChinhConstant.GET_NHAN_VIEN_HANH_CHINH);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				NhanVienHanhChinh nvHanhChinh = NhanVienHanhChinhConvert.getNhanVienHanhChinh(resultSet);
				nvHanhChinhs.add(nvHanhChinh);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return nvHanhChinhs;
	}

	public List<NhanVienHanhChinh> getNhanVienHanhChinhs(int from, int to) {

		List<NhanVienHanhChinh> nhanVienHanhChinhs = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(NhanVienHanhChinhConstant.GET_NHAN_VIEN_HANH_CHINHS_PHAN_TRANG);
			preparedStatement.setInt(1, from);
			preparedStatement.setInt(2, to);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				NhanVienHanhChinh nhanVienHanhChinh = NhanVienHanhChinhConvert.getNhanVienHanhChinh(resultSet);
				nhanVienHanhChinhs.add(nhanVienHanhChinh);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return nhanVienHanhChinhs;
	}

	public NhanVienHanhChinh getNVHanhChinhTheoMa(String maNVHanhChinh) {

		NhanVienHanhChinh nvHanhChinh = null;

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(NhanVienHanhChinhConstant.GET_NHAN_VIEN_HANH_CHINH_THEO_MA);
			preparedStatement.setString(1, maNVHanhChinh);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
				nvHanhChinh = NhanVienHanhChinhConvert.getNhanVienHanhChinh(resultSet);
	
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return nvHanhChinh;
	}

	public List<NhanVienHanhChinh> getNVHanhChinhTheoTen(String tenNVHanhChinh) {

		List<NhanVienHanhChinh> nvHanhChinhs = new ArrayList<NhanVienHanhChinh>();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(NhanVienHanhChinhConstant.GET_NHAN_VIEN_HANH_CHINH_THEO_TEN);
			preparedStatement.setString(1, "%" + tenNVHanhChinh + "%");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				NhanVienHanhChinh nvHanhChinh = NhanVienHanhChinhConvert.getNhanVienHanhChinh(resultSet);
				nvHanhChinhs.add(nvHanhChinh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return nvHanhChinhs;
	}

	public boolean themNhanVienHanhChinh(NhanVienHanhChinh nvHanhChinh) {

		int n = 0;

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(NhanVienHanhChinhConstant.THEM_NHAN_VIEN_HANH_CHINH);
			NhanVienHanhChinhConvert.themNhanVienHanhChinh(preparedStatement, nvHanhChinh);
			n = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return n > 0;
	}

	public boolean capNhatNhanVienHanhChinh(NhanVienHanhChinh nvHanhChinh) {

		int n = 0;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(NhanVienHanhChinhConstant.CAP_NHAP_NHAN_VIEN_HANH_CHINH);
			NhanVienHanhChinhConvert.capNhatNhanVienHanhChinh(preparedStatement, nvHanhChinh);
			n = preparedStatement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return n > 0;
	}

	public boolean kiemTraMaKhongTrung(String maNhanVienHanhChinh) {

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(NhanVienHanhChinhConstant.KIEM_TRA_MA_KHONG_TRUNG);
			preparedStatement.setString(1, maNhanVienHanhChinh);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
				return false;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;
	}

	public List<NhanVienHanhChinh> timKiemNhanVienHanhChinh(String timKiem, int from, int to, String field) {

		List<NhanVienHanhChinh> nhanVienHanhChinhs = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = null;

			switch (field) {
			case "":
				preparedStatement = connection
						.prepareStatement(NhanVienHanhChinhConstant.GET_NHAN_VIEN_HANH_CHINHS_PHAN_TRANG);
				break;
			case NhanVienHanhChinhConstant.MA_NHAN_VIEN_HANH_CHINH:
				preparedStatement = connection
						.prepareStatement(NhanVienHanhChinhConstant.TIM_KIEM_THEO_MA_NHAN_VIEN_HANH_CHINH);
				break;

			case NhanVienHanhChinhConstant.TEN_NHAN_VIEN_HANH_CHINH:
				preparedStatement = connection
						.prepareStatement(NhanVienHanhChinhConstant.TIM_KIEM_THEO_TEN_NHAN_VIEN_HANH_CHINH);
				break;

			case NhanVienHanhChinhConstant.SO_DIEN_THOAI:
				preparedStatement = connection.prepareStatement(NhanVienHanhChinhConstant.TIM_KIEM_THEO_SO_DIEN_THOAI);
				break;

			case NhanVienHanhChinhConstant.CHUC_VU:
				preparedStatement = connection.prepareStatement(NhanVienHanhChinhConstant.TIM_KIEM_THEO_SO_CHUC_VU);
				break;

			default:
				break;
			}

			preparedStatement.setString(1, "%" + timKiem + "%");
			preparedStatement.setInt(2, from);
			preparedStatement.setInt(3, to);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				NhanVienHanhChinh nhanVienHanhChinh = NhanVienHanhChinhConvert.getNhanVienHanhChinh(resultSet);
				nhanVienHanhChinhs.add(nhanVienHanhChinh);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return nhanVienHanhChinhs;
	}
	
	
	public int getMaxPageTimKiemNVHanhChinh(String timKiem, String field, int size) {

		int maxPage = 0;

		try {
			PreparedStatement preparedStatement = null;

			switch (field) {
			case "":
				preparedStatement = connection
						.prepareStatement(NhanVienHanhChinhConstant.GET_NHAN_VIEN_HANH_CHINHS_PHAN_TRANG_MAX_PAGE);
				break;
			case NhanVienHanhChinhConstant.MA_NHAN_VIEN_HANH_CHINH:
				preparedStatement = connection
						.prepareStatement(NhanVienHanhChinhConstant.TIM_KIEM_THEO_MA_NHAN_VIEN_HANH_CHINHS_MAX_PAGE);
				break;

			case NhanVienHanhChinhConstant.TEN_NHAN_VIEN_HANH_CHINH:
				preparedStatement = connection
						.prepareStatement(NhanVienHanhChinhConstant.TIM_KIEM_THEO_TEN_NHAN_VIEN_HANH_CHINHS_MAX_PAGE);
				break;

			case NhanVienHanhChinhConstant.SO_DIEN_THOAI:
				preparedStatement = connection.prepareStatement(NhanVienHanhChinhConstant.TIM_KIEM_THEO_SO_DIEN_THOAI_NHAN_VIEN_HANH_CHINHS_MAX_PAGE);
				break;

			case NhanVienHanhChinhConstant.CHUC_VU:
				preparedStatement = connection.prepareStatement(NhanVienHanhChinhConstant.TIM_KIEM_THEO_CHUC_VU_NHAN_VIEN_HANH_CHINHS_MAX_PAGE);
				break;

			default:
				break;
			}

			preparedStatement.setNString(1, "%" + timKiem + "%");

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next())
				maxPage = Integer.valueOf(resultSet.getString("total"));
			System.out.println(maxPage);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return (int) Math.ceil(maxPage * 1.00 / size);
	}

}

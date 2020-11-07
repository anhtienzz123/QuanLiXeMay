package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import constant.KhachHangConstant;
import converter.KhachHangConverter;
import db.DatabaseConnect;
import entity.KhachHang;

public class KhachHangDao {

	private static KhachHangDao instance;
	private Connection connection;

	// pattern singleton: đảm bảo trong vòng đời 1 ứng dụng chỉ cho phép duy nhất 1
	// đối tượng này đc tạo ra --> đảm bảo tiết kiệm bộ nhớ, tính hiệu năng
	private KhachHangDao() {
		connection = DatabaseConnect.getInstance();
	}

	public static KhachHangDao getInstance() {
		if (instance == null)
			instance = new KhachHangDao();
		return instance;
	}

	public List<KhachHang> getKhachHangs() {

		List<KhachHang> khachHangs = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(KhachHangConstant.GET_KHACH_HANGS);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				KhachHang khachHang = KhachHangConverter.getKhachHang(resultSet);
				khachHangs.add(khachHang);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return khachHangs;
	}

	public List<KhachHang> getKhachHangs(int from, int to) {

		List<KhachHang> khachHangs = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(KhachHangConstant.GET_KHACH_HANGS_PHAN_TRANG);
			preparedStatement.setInt(1, from);
			preparedStatement.setInt(2, to);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				KhachHang khachHang = KhachHangConverter.getKhachHang(resultSet);
				khachHangs.add(khachHang);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return khachHangs;
	}

	public KhachHang getKhachHangTheoMa(String maKhachHang) {

		KhachHang khachHang = null;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(KhachHangConstant.GET_KHACH_HANG_THEO_MA);
			preparedStatement.setString(1, maKhachHang);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
				khachHang = KhachHangConverter.getKhachHang(resultSet);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return khachHang;
	}
	
	public KhachHang getKhachHangTheoSoDienThoai(String soDienThoai) {

		KhachHang khachHang = null;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(KhachHangConstant.GET_KHACH_HANG_THEO_SO_DIEN_THOAI);
			preparedStatement.setString(1, soDienThoai);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
				khachHang = KhachHangConverter.getKhachHang(resultSet);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return khachHang;
	}

	public boolean themKhachHang(KhachHang khachHang) {

		int n = 0;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(KhachHangConstant.THEM_KHACH_HANG);
			KhachHangConverter.themKhachHang(preparedStatement, khachHang);
			n = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return n > 0;
	}

	public boolean capNhatKhachHang(KhachHang khachHang) {

		int n = 0;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(KhachHangConstant.CAP_NHAP_KHACH_HANG);
			KhachHangConverter.capNhatKhachHang(preparedStatement, khachHang);
			n = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return n > 0;
	}

	public boolean xoaKhachHang(String maKhachHang) {

		int n = 0;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(KhachHangConstant.XOA_KHACH_HANG);
			preparedStatement.setString(1, maKhachHang);
			n = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return n > 0;
	}

	// nếu không trùng thì return True
	public boolean kiemTraMaKhongTrung(String maKhachHang) {

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(KhachHangConstant.KIEM_TRA_MA_KHONG_TRUNG);
			preparedStatement.setString(1, maKhachHang);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
				return false;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	public List<KhachHang> timKiemKhachHangs(String timKiem, int from, int to, String field) {

		List<KhachHang> khachHangs = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = null;

			switch (field) {
			case "":
				preparedStatement = connection.prepareStatement(KhachHangConstant.GET_KHACH_HANGS_PHAN_TRANG);
				break;
			case KhachHangConstant.MA_KHACH_HANG:
				preparedStatement = connection.prepareStatement(KhachHangConstant.TIM_KIEM_THEO_MA_KHACH_HANG);
				break;
			case KhachHangConstant.SO_CMT:
				preparedStatement = connection.prepareStatement(KhachHangConstant.TIM_KIEM_THEO_SO_CMT);
				break;

			case KhachHangConstant.TEN_KHACH_HANG:
				preparedStatement = connection.prepareStatement(KhachHangConstant.TIM_KIEM_THEO_TEN_KHACH_HANG);
				break;

			case KhachHangConstant.SO_DIEN_THOAI:
				preparedStatement = connection.prepareStatement(KhachHangConstant.TIM_KIEM_THEO_SO_DIEN_THOAI);
				break;

			default:
				break;
			}

			preparedStatement.setString(1, "%" + timKiem + "%");
			preparedStatement.setInt(2, from);
			preparedStatement.setInt(3, to);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				KhachHang khachHang = KhachHangConverter.getKhachHang(resultSet);
				khachHangs.add(khachHang);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return khachHangs;
	}
}

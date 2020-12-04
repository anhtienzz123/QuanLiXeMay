package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import constant.NhanVienKiThuatConstant;
import converter.NhanVienKiThuatConvert;
import db.DatabaseConnect;
import entity.NhanVienKiThuat;

public class NhanVienKiThuatDao {
	private static NhanVienKiThuatDao instance;
	private Connection connection;

	private NhanVienKiThuatDao() {
		connection = DatabaseConnect.getInstance();
	}

	public static NhanVienKiThuatDao getInstance() {
		if (instance == null)
			instance = new NhanVienKiThuatDao();
		return instance;
	}

	public List<NhanVienKiThuat> getNVKiThuat() {
		List<NhanVienKiThuat> nvKiThuats = new ArrayList<NhanVienKiThuat>();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(NhanVienKiThuatConstant.GET_NHAN_VIEN_KI_THUAT);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				NhanVienKiThuat nvKiThuat = NhanVienKiThuatConvert.getNhanVienKiThuat(resultSet);
				nvKiThuats.add(nvKiThuat);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return nvKiThuats;
	}

	public List<NhanVienKiThuat> getNhanVienKiThuats(int from, int to) {

		List<NhanVienKiThuat> nhanVienKiThuats = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(NhanVienKiThuatConstant.GET_NHAN_VIEN_KI_THUATS_PHAN_TRANG);
			preparedStatement.setInt(1, from);
			preparedStatement.setInt(2, to);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				NhanVienKiThuat nhanVienKiThuat = NhanVienKiThuatConvert.getNhanVienKiThuat(resultSet);
				nhanVienKiThuats.add(nhanVienKiThuat);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return nhanVienKiThuats;
	}

	public NhanVienKiThuat getNVKiThuatTheoMa(String maNVKiThuat) {

		NhanVienKiThuat nvKiThuat = null;

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(NhanVienKiThuatConstant.GET_NHAN_VIEN_KI_THUAT_THEO_MA);
			preparedStatement.setString(1, maNVKiThuat);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
				nvKiThuat = NhanVienKiThuatConvert.getNhanVienKiThuat(resultSet);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return nvKiThuat;
	}

	public List<NhanVienKiThuat> getNVKiThuatTheoTens(String tenNVKiThuat) {

		List<NhanVienKiThuat> nvKiThuats = new ArrayList<NhanVienKiThuat>();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(NhanVienKiThuatConstant.GET_NHAN_VIEN_KI_THUAT_THEO_TEN);
//			System.out.println(preparedStatement);
			preparedStatement.setString(1, "%" + tenNVKiThuat + "%");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				NhanVienKiThuat nvKiThuat = NhanVienKiThuatConvert.getNhanVienKiThuat(resultSet);
				nvKiThuats.add(nvKiThuat);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return nvKiThuats;
	}

	public boolean themNhanVienKiThuat(NhanVienKiThuat nvKiThuat) {

		int n = 0;

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(NhanVienKiThuatConstant.THEM_NHAN_VIEN_KI_THUAT);
			NhanVienKiThuatConvert.themNhanVienKiThuat(preparedStatement, nvKiThuat);
			n = preparedStatement.executeUpdate();

		} catch (SQLException e) {

		}

		return n > 0;
	}

	public boolean capNhatNhanVienKiThuat(NhanVienKiThuat nvKiThuat) {

		int n = 0;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(NhanVienKiThuatConstant.CAP_NHAP_NHAN_VIEN_KI_THUAT);
			NhanVienKiThuatConvert.capNhatNhanVienKiThuat(preparedStatement, nvKiThuat);
			n = preparedStatement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return n > 0;
	}

	public boolean kiemTraMaKhongTrung(String maNVKiThuat) {

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(NhanVienKiThuatConstant.KIEM_TRA_MA_KHONG_TRUNG);
			preparedStatement.setString(1, maNVKiThuat);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
				return false;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	public List<NhanVienKiThuat> timKiemNhanVienKiThuats(String timKiem, int from, int to, String field) {

		List<NhanVienKiThuat> nhanVienKiThuats = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = null;

			switch (field) {
			case "":
				preparedStatement = connection
						.prepareStatement(NhanVienKiThuatConstant.GET_NHAN_VIEN_KI_THUATS_PHAN_TRANG);
				break;
			case NhanVienKiThuatConstant.MA_NHAN_VIEN_KI_THUAT:
				preparedStatement = connection
						.prepareStatement(NhanVienKiThuatConstant.TIM_KIEM_THEO_MA_NHAN_VIEN_KI_THUAT);
				break;
			case NhanVienKiThuatConstant.TEN_NHAN_VIEN_KI_THUAT:
				preparedStatement = connection
						.prepareStatement(NhanVienKiThuatConstant.TIM_KIEM_THEO_TEN_NHAN_VIEN_KI_THUAT);
				break;

			case NhanVienKiThuatConstant.BAC_THO:
				preparedStatement = connection.prepareStatement(NhanVienKiThuatConstant.TIM_KIEM_THEO_BAC_THO);
				break;

			case NhanVienKiThuatConstant.SO_NAM_KINH_NGHIEM:
				preparedStatement = connection
						.prepareStatement(NhanVienKiThuatConstant.TIM_KIEM_THEO_SO_NAM_KINH_NGHIEM);
				break;

			default:
				break;
			}

			preparedStatement.setString(1, "%" + timKiem + "%");
			preparedStatement.setInt(2, from);
			preparedStatement.setInt(3, to);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				NhanVienKiThuat nhanVienKiThuat = NhanVienKiThuatConvert.getNhanVienKiThuat(resultSet);
				nhanVienKiThuats.add(nhanVienKiThuat);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return nhanVienKiThuats;
	}

	public int getMaxPageTimKiemNVKiThuat(String timKiem, String field, int size) {

		int maxPage = 0;

		try {
			PreparedStatement preparedStatement = null;

			switch (field) {
			case "":
				preparedStatement = connection
						.prepareStatement(NhanVienKiThuatConstant.GET_NHAN_VIEN_KI_THUATS_PHAN_TRANG_MAX_PAGE);
				break;
			case NhanVienKiThuatConstant.MA_NHAN_VIEN_KI_THUAT:
				preparedStatement = connection
						.prepareStatement(NhanVienKiThuatConstant.TIM_KIEM_THEO_MA_NHAN_KI_THUATS_MAX_PAGE);
				break;
			case NhanVienKiThuatConstant.TEN_NHAN_VIEN_KI_THUAT:
				preparedStatement = connection
						.prepareStatement(NhanVienKiThuatConstant.TIM_KIEM_THEO_TEN_NHAN_VIEN_KI_THUATS_MAX_PAGE);
				break;

			case NhanVienKiThuatConstant.BAC_THO:
				preparedStatement = connection.prepareStatement(NhanVienKiThuatConstant.TIM_KIEM_THEO_CHUC_VU_BAC_THO_MAX_PAGE);
				break;

			case NhanVienKiThuatConstant.SO_NAM_KINH_NGHIEM:
				preparedStatement = connection
						.prepareStatement(NhanVienKiThuatConstant.TIM_KIEM_THEO_SO_NAM_KINH_NGHIEM_MAX_PAGE);
				break;

			default:
				break;
			}

			preparedStatement.setNString(1, "%" + timKiem + "%");

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next())
				maxPage = Integer.valueOf(resultSet.getString("total"));
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return (int) Math.ceil(maxPage * 1.00 / size);
	}

}

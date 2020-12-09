package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import constant.DanhMucBaoHanhConstant;
import converter.DanhMucBaoHanhConvert;
import db.DatabaseConnect;
import entity.DanhMucBaoHanh;

public class DanhMucBaoHanhDao {
	private static DanhMucBaoHanhDao instance;
	private Connection connection;

	private DanhMucBaoHanhDao() {
		try {
			DatabaseConnect.connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection = DatabaseConnect.getInstance();
	}

	public static DanhMucBaoHanhDao getInstance() {
		if (instance == null)
			instance = new DanhMucBaoHanhDao();
		return instance;
	}

	public List<DanhMucBaoHanh> getDanhMucBaoHanhs() {

		List<DanhMucBaoHanh> danhMucBaoHanhs = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(DanhMucBaoHanhConstant.GET_DANH_MUC_BAO_HANH);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				DanhMucBaoHanh danhMucBaoHanh = DanhMucBaoHanhConvert.getDanhMucBaoHanh(resultSet);
				danhMucBaoHanhs.add(danhMucBaoHanh);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return danhMucBaoHanhs;
	}

	public DanhMucBaoHanh getDanhMucBaoHanhTheoMa(String maDanhMucBaoHanh) {

		DanhMucBaoHanh danhMucBaoHanh = null;

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(DanhMucBaoHanhConstant.GET_DANH_MUC_BAO_HANH_THEO_MA);
			preparedStatement.setString(1, maDanhMucBaoHanh);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
				danhMucBaoHanh = DanhMucBaoHanhConvert.getDanhMucBaoHanh(resultSet);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return danhMucBaoHanh;
	}

	public DanhMucBaoHanh getDanhMucBaoHanhTheoTen(String tenDanhMucBaoHanh) {
		DanhMucBaoHanh danhMucBaoHanh = null;

		try {
			String sql = DanhMucBaoHanhConstant.GET_DANH_MUC_BAO_HANH_THEO_TEN + tenDanhMucBaoHanh + "%'";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				danhMucBaoHanh = DanhMucBaoHanhConvert.getDanhMucBaoHanh(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return danhMucBaoHanh;
	}

	public List<DanhMucBaoHanh> getDanhMucBaoHanhTheoTens(String tenDanhMucBaoHanh) {

		List<DanhMucBaoHanh> danhMucBaoHanhs = new ArrayList<DanhMucBaoHanh>();

		try {
			String sql = DanhMucBaoHanhConstant.GET_DANH_MUC_BAO_HANH_THEO_TEN + tenDanhMucBaoHanh + "%'";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				DanhMucBaoHanh danhMucBaoHanh = DanhMucBaoHanhConvert.getDanhMucBaoHanh(resultSet);
				danhMucBaoHanhs.add(danhMucBaoHanh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return danhMucBaoHanhs;
	}

	public boolean themDanhMucBaoHanh(DanhMucBaoHanh danhMucBaoHanh) {

		int n = 0;

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(DanhMucBaoHanhConstant.THEM_DANH_MUC_BAO_HANH);
			DanhMucBaoHanhConvert.themDanhMucBaoHanh(preparedStatement, danhMucBaoHanh);
			n = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return n > 0;
	}

	public boolean capNhatDanhMucBaoHanh(DanhMucBaoHanh danhMucBaoHanh) {

		int n = 0;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(DanhMucBaoHanhConstant.CAP_NHAP_DANH_MUC_BAO_HANH);
			DanhMucBaoHanhConvert.capDanhMucBaoHanh(preparedStatement, danhMucBaoHanh);
			n = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return n > 0;
	}

	public boolean kiemTraMaKhongTrung(String maDanhMucBaoHanh) {

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(DanhMucBaoHanhConstant.KIEM_TRA_MA_KHONG_TRUNG);
			preparedStatement.setString(1, maDanhMucBaoHanh);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
				return false;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

}

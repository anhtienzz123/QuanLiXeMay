package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import constant.Constant;
import constant.DanhMucBaoHanhConstant;
import converter.DanhMucBaoHanhConvert;
import converter.KhachHangConverter;
import db.DatabaseConnect;
import entity.DanhMucBaoHanh;
import entity.KhachHang;

public class DanhMucBaoHanhDao {
	private static DanhMucBaoHanhDao instance;
	private Connection connection;

	private DanhMucBaoHanhDao() {
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
			PreparedStatement preparedStatement = connection.prepareStatement(DanhMucBaoHanhConstant.GET_DANH_MUC_BAO_HANH_THEO_MA);
			preparedStatement.setString(1, maDanhMucBaoHanh);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
				danhMucBaoHanh = DanhMucBaoHanhConvert.getDanhMucBaoHanh(resultSet);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return danhMucBaoHanh;
	}

	public boolean themDanhMucBaoHanh(DanhMucBaoHanh danhMucBaoHanh) {

		int n = 0;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DanhMucBaoHanhConstant.THEM_DANH_MUC_BAO_HANH);
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
			PreparedStatement preparedStatement = connection.prepareStatement(DanhMucBaoHanhConstant.CAP_NHAP_DANH_MUC_BAO_HANH);
			DanhMucBaoHanhConvert.capDanhMucBaoHanh(preparedStatement, danhMucBaoHanh);
			n = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return n > 0;
	}

}

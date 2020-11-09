package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import constant.LoaiXeConstant;
import converter.LoaiXeConvert;
import db.DatabaseConnect;
import entity.LoaiXe;

public class LoaiXeDao {
	private static LoaiXeDao instance;
	private Connection connection;

	private LoaiXeDao() {
		connection = DatabaseConnect.getInstance();
	}

	public static LoaiXeDao getInstance() {
		if (instance == null)
			instance = new LoaiXeDao();
		return instance;
	}
	
	public List<LoaiXe> getLoaiXes() {

		List<LoaiXe> loaiXes = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(LoaiXeConstant.GET_LOAI_XE);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				LoaiXe loaiXe = LoaiXeConvert.getLoaiXe(resultSet);
				loaiXes.add(loaiXe);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return loaiXes;
	}
	
	public LoaiXe getLoaiXeTheoMa(String maLoaiXe) {

		LoaiXe loaiXe = null;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(LoaiXeConstant.GET_LOAI_XE_THEO_MA);
			preparedStatement.setString(1, maLoaiXe);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
				loaiXe = LoaiXeConvert.getLoaiXe(resultSet);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return loaiXe;
	}
	
	public LoaiXe getLoaiXeTheoTen(String tenLoaiXe) {

		LoaiXe loaiXe = null;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(LoaiXeConstant.GET_LOAI_XE_THEO_MA);
			preparedStatement.setString(1, tenLoaiXe);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
				loaiXe = LoaiXeConvert.getLoaiXe(resultSet);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return loaiXe;
	}
	
	public boolean capNhatLoaiXe(LoaiXe loaiXe) {

		int n = 0;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(LoaiXeConstant.CAP_NHAP_LOAI_XE);			
			LoaiXeConvert.capNhatLoaiXe(preparedStatement, loaiXe);
			n = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return n > 0;
	}
	
	public boolean themLoaiXe(LoaiXe loaiXe) {

		int n = 0;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(LoaiXeConstant.THEM_LOAI_XE);
			LoaiXeConvert.themLoaiXe(preparedStatement, loaiXe);
			n = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return n > 0;
	}
	
	public boolean kiemTraMaKhongTrung(String maLoaiXe) {

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(LoaiXeConstant.KIEM_TRA_MA_KHONG_TRUNG);
			preparedStatement.setString(1, maLoaiXe);

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

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DatabaseConnect;
import entity.KhachHang;
import entity.NhanVienHanhChinh;
import entity.NhanVienKiThuat;

import java.util.ArrayList;
import java.util.List;

import constant.Constant;
import constant.NhanVienHanhChinhConstant;
import converter.KhachHangConverter;
import converter.NhanVienHanhChinhConvert;
import converter.NhanVienKiThuatConvert;

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
			preparedStatement.setString(1,"%" +tenNVHanhChinh+"%");

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
			PreparedStatement preparedStatement = connection.prepareStatement(NhanVienHanhChinhConstant.CAP_NHAP_NHAN_VIEN_HANH_CHINH);			
			NhanVienHanhChinhConvert.capNhatNhanVienHanhChinh(preparedStatement, nvHanhChinh);
			n = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return n > 0;
	}

}

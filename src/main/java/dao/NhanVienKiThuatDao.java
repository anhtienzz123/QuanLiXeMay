package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	
	public List<NhanVienKiThuat> getNhanVienKiThuats (int from, int to){
		
		List<NhanVienKiThuat> nhanVienKiThuats = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(NhanVienKiThuatConstant.GET_NHAN_VIEN_KI_THUATS_PHAN_TRANG);
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
			System.out.println(preparedStatement);
			preparedStatement.setString(1, "%"+tenNVKiThuat+"%");

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
			e.printStackTrace();
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

}

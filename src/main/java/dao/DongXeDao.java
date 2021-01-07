package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import constant.DongXeConstant;
import converter.DongXeConvert;
import db.DatabaseConnect;
import entity.DongXe;

public class DongXeDao {
	private static DongXeDao instance;
	private Connection connection;

	private DongXeDao() {
		try {
			DatabaseConnect.connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection = DatabaseConnect.getInstance();
	}

	public static DongXeDao getInstance() {
		if (instance == null)
			instance = new DongXeDao();
		return instance;
	}

	public List<DongXe> getDongXes() {

		List<DongXe> dongXes = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DongXeConstant.GET_DONG_XE);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				DongXe dongXe = DongXeConvert.getDongXe(resultSet);
				dongXes.add(dongXe);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return dongXes;
	}

	public List<DongXe> getDongXesTheoTenHangXe(String tenHangXe) {

		List<DongXe> dongXes = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(DongXeConstant.GET_DONG_XE_THEO_TEN_HANG_XE);

			preparedStatement.setString(1, tenHangXe);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				DongXe dongXe = DongXeConvert.getDongXe(resultSet);
				dongXes.add(dongXe);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return dongXes;
	}

	public DongXe getDongXeTheoMa(String maDongXe) {

		DongXe dongXe = null;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DongXeConstant.GET_DONG_XE_THEO_MA);
			preparedStatement.setString(1, maDongXe);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next())
				dongXe = DongXeConvert.getDongXe(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dongXe;
	}

	public DongXe getDongXeTheoTen(String tenDongXe) {

		DongXe dongXe = null;

		try {
			String sql = DongXeConstant.GET_DONG_XE_THEO_TEN + tenDongXe + "%'";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next())
				dongXe = DongXeConvert.getDongXe(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dongXe;
	}

	public boolean capNhatDongXe(DongXe dongXe) {

		int n = 0;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DongXeConstant.CAP_NHAP_DONG_XE);
			DongXeConvert.capNhatDongXe(preparedStatement, dongXe);
			n = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return n > 0;
	}

	public boolean themDongXe(DongXe dongXe) {

		int n = 0;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DongXeConstant.THEM_DONG_XE);
			DongXeConvert.themDongXe(preparedStatement, dongXe);
			n = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return n > 0;
	}

	public boolean kiemTraMaKhongTrung(String maDongXe) {

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DongXeConstant.KIEM_TRA_MA_KHONG_TRUNG);
			preparedStatement.setString(1, maDongXe);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
				return false;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	public boolean xoaDongXe(String maDongXe) {

		int result = 0;
		try {
			String sql = "delete from DongXe where maDongXe = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, maDongXe);

			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Mã dòng xe đã bị ràng buộc, không xóa được");

		}

		return result > 0;
	}

	public boolean kiemTraKhongTrungTenDongXe(String tenDongXe) {

		try {
			String sql = "select * from DongXe where tenDongXe = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, tenDongXe);

			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next())
				return false;

		} catch (SQLException e) {

		}

		return true;
	}

	public List<DongXe> timKiemDongXeTheoTenDongXe(String tenDongXe) {

		List<DongXe> dongXes = new ArrayList<>();

		try {
			String sql = "select * from DongXe where tenDongXe like N'%" + tenDongXe + "%'";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				DongXe dongXe = DongXeConvert.getDongXe(resultSet);
				dongXes.add(dongXe);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return dongXes;
	}

	public List<DongXe> timKiemDongXeTheoMaDongXe(String maDongXe) {

		List<DongXe> dongXes = new ArrayList<>();

		try {
			String sql = "select * from DongXe where maDongXe like N'%" + maDongXe + "%'";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				DongXe dongXe = DongXeConvert.getDongXe(resultSet);
				dongXes.add(dongXe);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return dongXes;
	}
	
	public List<DongXe> timKiemDongXeTheoHang(String tenHangXe) {

		List<DongXe> dongXes = new ArrayList<>();

		try {
			String sql = "select * from DongXe inner join HangXe on DongXe.maHangXe = HangXe.maHangXe where tenHangXe like N'%"+tenHangXe +"%'";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				DongXe dongXe = DongXeConvert.getDongXe(resultSet);
				dongXes.add(dongXe);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return dongXes;
	}
	
	

}

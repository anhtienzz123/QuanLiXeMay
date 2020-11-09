package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import constant.HopDongConstant;
import converter.HopDongConverter;
import db.DatabaseConnect;
import entity.HopDong;

public class HopDongDao {

	private static HopDongDao instance;
	private Connection connection;

	private HopDongDao() {
		connection = DatabaseConnect.getInstance();
	}

	public static HopDongDao getInstance() {
		if (instance == null)
			instance = new HopDongDao();
		return instance;
	}

	public List<HopDong> getHopDongs() {

		List<HopDong> hopDongs = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(HopDongConstant.GET_HOP_DONGS);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				HopDong hopDong = HopDongConverter.getHopDong(resultSet);
				hopDongs.add(hopDong);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return hopDongs;

	}
	
	public List<HopDong> getHopDongs (int from, int to){
		
		List<HopDong> hopDongs = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(HopDongConstant.GET_HOP_DONGS_PHAN_TRANG);
			preparedStatement.setInt(1, from);
			preparedStatement.setInt(2, to);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				HopDong hopDong = HopDongConverter.getHopDong(resultSet);
				hopDongs.add(hopDong);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return hopDongs;
	}

	public HopDong getHopDongTheoMa(String maHopDong) {

		HopDong hopDong = null;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(HopDongConstant.GET_HOP_DONG_THEO_MA_HOP_DONG);
			preparedStatement.setString(1, maHopDong);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
				hopDong = HopDongConverter.getHopDong(resultSet);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return hopDong;
	}

	public boolean themHopDong(HopDong hopDong) {

		int n = 0;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(HopDongConstant.THEM_HOP_DONG);
			HopDongConverter.themHopDong(preparedStatement, hopDong);

			n = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return n > 0;
	}

	public boolean capNhatHopDong(HopDong hopDong) {

		int n = 0;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(HopDongConstant.CAP_NHAT_HOP_DONG);
			HopDongConverter.capNhatHopDong(preparedStatement, hopDong);

			n = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return n > 0;
	}
	
	public boolean kiemTraMaKhongTrung(String maHopDong) {

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(HopDongConstant.KIEM_TRA_MA_KHONG_TRUNG);
			preparedStatement.setString(1, maHopDong);

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

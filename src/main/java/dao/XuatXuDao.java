package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import constant.XuatXuConstant;
import converter.XuatXuConvert;
import db.DatabaseConnect;
import entity.XuatXu;

public class XuatXuDao {
	private static XuatXuDao instance;
	private Connection connection;

	private XuatXuDao() {
		connection = DatabaseConnect.getInstance();
	}

	public static XuatXuDao getInstance() {
		if (instance == null)
			instance = new XuatXuDao();
		return instance;
	}

	public List<XuatXu> getXuatXus() {

		List<XuatXu> xuatXus = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(XuatXuConstant.GET_XUAT_XU_XE);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				XuatXu xuatXu = XuatXuConvert.getXuatXu(resultSet);
				xuatXus.add(xuatXu);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return xuatXus;
	}
	
	public XuatXu getXuatXuTheoMa(String maXuatXu) {

		XuatXu xuatXu = null;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(XuatXuConstant.GET_XUAT_XU_THEO_MA);
			preparedStatement.setString(1, maXuatXu);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
				xuatXu = XuatXuConvert.getXuatXu(resultSet);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return xuatXu;
	}
	
	public XuatXu getXuatXuTheoTen(String tenXuatXu) {

		XuatXu xuatXu = null;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(XuatXuConstant.GET_XUAT_XU_THEO_MA);
			preparedStatement.setString(1, tenXuatXu);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
				xuatXu = XuatXuConvert.getXuatXu(resultSet);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return xuatXu;
	}
	
	public boolean capNhatXuatXu(XuatXu xuatXu) {

		int n = 0;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(XuatXuConstant.CAP_NHAP_XUAT_XU);			
			XuatXuConvert.capNhatXuatXu(preparedStatement, xuatXu);
			n = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return n > 0;
	}
	
	public boolean themXuatXu(XuatXu xuatXu) {

		int n = 0;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(XuatXuConstant.THEM_XUAT_XU);
			XuatXuConvert.themXuatXu(preparedStatement, xuatXu);
			n = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return n > 0;
	}
	
	public boolean kiemTraMaKhongTrung(String maXuatXu) {

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(XuatXuConstant.KIEM_TRA_MA_KHONG_TRUNG);
			preparedStatement.setString(1, maXuatXu);

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

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import constant.LoaiXeConstant;
import constant.PhieuBaoHanhConstant;
import constant.XeMayConstant;
import converter.LoaiXeConvert;
import converter.XeMayConvert;
import db.DatabaseConnect;
import entity.LoaiXe;
import entity.XeMay;

public class XeMayDao {
	private static XeMayDao instance;
	private Connection connection;

	private XeMayDao() {
		connection = DatabaseConnect.getInstance();
	}

	public static XeMayDao getInstance() {
		if (instance == null)
			instance = new XeMayDao();
		return instance;
	}

	public List<XeMay> getXeMays() {

		List<XeMay> xeMays = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(XeMayConstant.GET_XE_MAY);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				XeMay xeMay = XeMayConvert.getXeMay(resultSet);
				xeMays.add(xeMay);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return xeMays;
	}

	public XeMay getXeMayTheoMa(String maXeMay) {
		XeMay xeMay = null;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(XeMayConstant.GET_XE_MAY_THEO_MA);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
				xeMay = XeMayConvert.getXeMay(resultSet);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return xeMay;
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

	public boolean themXeMay(XeMay xeMay) {

		int n = 0;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(XeMayConstant.THEM_XE_MAY);
			XeMayConvert.themXeMay(preparedStatement, xeMay);
			n = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean capNhatXeMay(XeMay xeMay) {

		int n = 0;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(XeMayConstant.CAP_NHAP_XE_MAY);
			XeMayConvert.capNhatXeMay(preparedStatement, xeMay);
			n = preparedStatement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return n > 0;
	}
	
	public boolean kiemTraMaKhongTrung(String maXeMay) {

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(XeMayConstant.KIEM_TRA_MA_KHONG_TRUNG);
			preparedStatement.setString(1, maXeMay);

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

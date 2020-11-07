package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import constant.LoaiXeConstant;
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

//	public List<XeMay> getXeMaysTheoNhieuTieuChi(String timKiem, double gia1, double gia2,String mauSac, String xuatXu,
//			String loaiXe, String dongXe, String hangXe) {
//
//
//
//		String sql = "select maTour, tenTour, gia, ngayDi, ngayVe, ten, tinhThanh, tour.maDiaDanh from tour inner join diadanh on  tour.maDiaDanh = diadanh.maDiaDanh where ngayDi > curdate()";
//
//		if (!tenDiaDanh.trim().equals("")) {
//			sql += " and ten = '" + tenDiaDanh + "'";
//		}
//
//		if (!(gia1 == 0 && gia2 == 0)) {
//
//			if (gia1 == 0 && gia2 == 1999999) {
//				sql += " and gia <= 1999999";
//			}
//
//			if (gia1 == 2000000 && gia2 == 5000000) {
//				sql += " and gia >= " + gia1 + " and gia <= " + gia2;
//			}
//
//			if (gia1 == 5000001 && gia2 == 10000000) {
//				sql += " and gia >= " + gia1 + " and gia <= " + gia2;
//			}
//
//			if (gia1 == 10000001) {
//				sql += " and gia >= 10000001";
//			}
//
//		}
//
//		if (!ngayDi.equals("")) {
//			sql += " and ngayDi = '" + ngayDi + "'";
//
//		}
//
//		if (!tinhThanh.trim().equals("")) {
//			sql += " and tinhThanh = '" + tinhThanh + "'";
//
//		}
//
//		sql += " limit " + viTri + ", " + size;
//
//		List<Tour> listTours = new ArrayList<Tour>();
//
//		PreparedStatement preparedStatement;
//		ResultSet rSet;
//		try {
//			preparedStatement = connection.prepareStatement(sql);
//			rSet = preparedStatement.executeQuery();
//
//			while (rSet.next()) {
//				String maTour = rSet.getString("maTour");
//				String tenTour = rSet.getString("tenTour");
//				double giaTour = rSet.getDouble("gia");
//				Date ngDi = rSet.getDate("ngayDi");
//				Date ngayVe = rSet.getDate("ngayVe");
//
//				String maDiaDanh = rSet.getString("maDiaDanh");
//				DiaDanh diaDanh = getDiaDanh(maDiaDanh);
//
//				Tour tour = new Tour(maTour, tenTour, giaTour, ngDi, ngayVe, diaDanh);
//				listTours.add(tour);
//			}
//
//			rSet.close();
//			preparedStatement.close();
//			connection.close();
//			return listTours;
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return null;
//
//	}
}

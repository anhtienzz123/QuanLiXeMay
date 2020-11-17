package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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

	private static final String TAT_CA = "Tất cả";
	private static final String RONG = "";
	private static final String MA_XE = "Mã xe";
	private static final String TEN_XE = "Tên xe";

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
			preparedStatement.setString(1, maXeMay);
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
			PreparedStatement preparedStatement = connection.prepareStatement(XeMayConstant.KIEM_TRA_MA_KHONG_TRUNG);
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

	public int getMaxPageTheoNhieuTieuChi(String timKiem, String field, String gia, String mauXe, String tenXuatXu,
			String tenLoaiXe, String tenDongXe, String tenHangXe, int size) {

		String sql = "SELECT count(maXeMay) as total\r\n" + "from XeMay\r\n"
				+ "inner join XuatXu on XeMay.maXuatXu = XuatXu.maXuatXu\r\n"
				+ "inner join LoaiXe on XeMay.maLoaiXe = LoaiXe.maLoaiXe\r\n"
				+ "inner join DongXe on XeMay.maDongXe = DongXe.maDongXe\r\n"
				+ "inner join HangXe on DongXe.maHangXe = HangXe.maHangXe\r\n" + "where soLuong > 0";

		if (!timKiem.trim().equals(RONG)) {
			if (field.equalsIgnoreCase(TEN_XE)) {
				sql += " and tenXeMay like N'%" + timKiem + "%'";
			}

			if (field.equalsIgnoreCase(MA_XE)) {
				sql += " and maXeMay like N'%" + timKiem + "%'";
			}
		}

		if (!mauXe.trim().equalsIgnoreCase(TAT_CA)) {
			sql += " and mauXe = N'" + mauXe + "'";
		}

		if (!tenXuatXu.trim().equalsIgnoreCase(TAT_CA)) {
			sql += " and tenXuatXu = N'" + tenXuatXu + "'";
		}

		if (!tenLoaiXe.trim().equalsIgnoreCase(TAT_CA)) {
			sql += " and tenLoaiXe = N'" + tenLoaiXe + "'";
		}

		if (!tenDongXe.trim().equalsIgnoreCase(TAT_CA)) {
			sql += " and tenDongXe = N'" + tenDongXe + "'";
		}

		if (!tenHangXe.trim().equalsIgnoreCase(TAT_CA)) {
			sql += " and tenHangXe = N'" + tenHangXe + "'";
		}

		if (!gia.trim().equalsIgnoreCase(TAT_CA)) {

			if (gia.equalsIgnoreCase("Dưới 25tr")) {
				sql += " and giaNhap < 25000000";
			} else if (gia.equalsIgnoreCase("Trên 60tr")) {
				sql += " and giaNhap > 60000000";
			} else {
				sql += " and giaNhap between 25000000 and 60000000 ";
			}

		}

		int count = 0;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				count = resultSet.getInt("total");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return (int) Math.ceil(count * 1.00 / size);

	}

	public List<XeMay> getXeMaysTheoNhieuTieuChi(String timKiem, String field, String gia, String mauXe,
			String tenXuatXu, String tenLoaiXe, String tenDongXe, String tenHangXe, int from, int to) {

		String sql = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY maXeMay)\r\n" + "as row FROM XeMay) as a\r\n"
				+ "inner join XuatXu on a.maXuatXu = XuatXu.maXuatXu\r\n"
				+ "inner join LoaiXe on a.maLoaiXe = LoaiXe.maLoaiXe\r\n"
				+ "inner join DongXe on a.maDongXe = DongXe.maDongXe\r\n"
				+ "inner join HangXe on DongXe.maHangXe = HangXe.maHangXe\r\n" + "WHERE row between " + from + " and "
				+ to + " \r\n" + "and soLuong > 0";

		if (!timKiem.trim().equals(RONG)) {
			if (field.equalsIgnoreCase(TEN_XE)) {
				sql += " and tenXeMay like N'%" + timKiem + "%'";
			}

			if (field.equalsIgnoreCase(MA_XE)) {
				sql += " and maXeMay like N'%" + timKiem + "%'";
			}
		}

		if (!mauXe.trim().equalsIgnoreCase(TAT_CA)) {
			sql += " and mauXe = N'" + mauXe + "'";
		}

		if (!tenXuatXu.trim().equalsIgnoreCase(TAT_CA)) {
			sql += " and tenXuatXu = N'" + tenXuatXu + "'";
		}

		if (!tenLoaiXe.trim().equalsIgnoreCase(TAT_CA)) {
			sql += " and tenLoaiXe = N'" + tenLoaiXe + "'";
		}

		if (!tenDongXe.trim().equalsIgnoreCase(TAT_CA)) {
			sql += " and tenDongXe = N'" + tenDongXe + "'";
		}

		if (!tenHangXe.trim().equalsIgnoreCase(TAT_CA)) {
			sql += " and tenHangXe = N'" + tenHangXe + "'";
		}

		if (!gia.trim().equalsIgnoreCase(TAT_CA)) {

			if (gia.equalsIgnoreCase("Dưới 25tr")) {
				sql += " and giaNhap < 25000000";
			} else if (gia.equalsIgnoreCase("Trên 60tr")) {
				sql += " and giaNhap > 60000000";
			} else {
				sql += " and giaNhap between 25000000 and 60000000 ";
			}

		}

		// System.out.println(sql);

		List<XeMay> xeMays = new ArrayList<XeMay>();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				XeMay xeMay = XeMayConvert.getXeMay(resultSet);

				xeMays.add(xeMay);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return xeMays;

	}

	public Set<String> getMauXes() {
		Set<String> mauXes = new TreeSet<String>();

		String sql = "select mauXe from XeMay";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				mauXes.add(resultSet.getString("mauXe"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mauXes;
	}
}

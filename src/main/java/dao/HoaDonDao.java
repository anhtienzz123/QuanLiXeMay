package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import constant.HoaDonConstant;
import converter.HoaDonConverter;
import db.DatabaseConnect;
import entity.HoaDon;
import other.XuLyChung;

public class HoaDonDao {

	private static HoaDonDao instance;
	private Connection connection;

	// pattern singleton: đảm bảo trong vòng đời 1 ứng dụng chỉ cho phép duy nhất 1
	// đối tượng này đc tạo ra --> đảm bảo tiết kiệm bộ nhớ, tính hiệu năng
	private HoaDonDao() {
		connection = DatabaseConnect.getInstance();
	}

	public static HoaDonDao getInstance() {
		if (instance == null)
			instance = new HoaDonDao();
		return instance;
	}

	public List<HoaDon> getHoaDons() {

		List<HoaDon> hoaDons = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(HoaDonConstant.GET_HOA_DONS);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				HoaDon hoaDon = HoaDonConverter.getHoaDon(resultSet);

				hoaDons.add(hoaDon);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return hoaDons;

	}

	public List<HoaDon> getHoaDonsTheoNgayLap(int ngay, int thang, int nam) {

		List<HoaDon> hoaDons = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(HoaDonConstant.GET_HOA_DONS_THEO_NGAY_LAP);

			preparedStatement.setInt(1, ngay);
			preparedStatement.setInt(2, thang);
			preparedStatement.setInt(3, nam);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				HoaDon hoaDon = HoaDonConverter.getHoaDon(resultSet);

				hoaDons.add(hoaDon);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return hoaDons;

	}

	public List<HoaDon> getDons(int from, int to) {

		List<HoaDon> hoaDons = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(HoaDonConstant.GET_HOA_DONS_PHAN_TRANG);
			preparedStatement.setInt(1, from);
			preparedStatement.setInt(2, to);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				HoaDon hoaDon = HoaDonConverter.getHoaDon(resultSet);
				hoaDons.add(hoaDon);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return hoaDons;
	}

	public HoaDon getHoaDonTheoMaHoaDon(String maHoaDon) {

		HoaDon hoaDon = null;

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(HoaDonConstant.GET_HOA_DON_THEO_MA_HOA_DON);

			preparedStatement.setString(1, maHoaDon);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
				hoaDon = HoaDonConverter.getHoaDon(resultSet);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return hoaDon;

	}

	public boolean themHoaDon(HoaDon hoaDon) {

		ChiTietHoaDonDao chiTietHoaDonDao = ChiTietHoaDonDao.getInstance();

		int n = 0;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(HoaDonConstant.THEM_HOA_DON);

			connection.setAutoCommit(false);

			try {

				HoaDonConverter.themHoaDon(preparedStatement, hoaDon);
				n = preparedStatement.executeUpdate();
				chiTietHoaDonDao.themChiTietHoaDons(hoaDon.getChiTietHoaDons());

				connection.commit();
			} catch (Exception e) {
				connection.rollback();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return n > 0;

	}

	public boolean kiemTraMaKhongTrung(String maHoaDon) {

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(HoaDonConstant.KIEM_TRA_MA_KHONG_TRUNG);
			preparedStatement.setString(1, maHoaDon);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
				return false;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	public int getMaxPageTimKiemHoaDon(String timKiem, String field, LocalDate localDate, int size) {

		int maxPage = 0;

		String result = "";

		try {
			PreparedStatement preparedStatement = null;

			switch (field) {
			case "":

				result = HoaDonConstant.TIM_KIEM_THEO_MA_HOA_DON_MAX_PAGE;
				break;
			case HoaDonConstant.MA_HOA_DON:
				result = HoaDonConstant.TIM_KIEM_THEO_MA_HOA_DON_MAX_PAGE;
				break;
			case HoaDonConstant.MA_NHAN_VIEN_LAP_HOA_DON:
				result = HoaDonConstant.TIM_KIEM_THEO_MA_NHAN_VIEN_MAX_PAGE;
				break;

			case HoaDonConstant.TEN_NHAN_VIEN_LAP_HOA_DON:
				result = HoaDonConstant.TIM_KIEM_THEO_TEN_NHAN_VIEN_MAX_PAGE;
				break;

			case HoaDonConstant.MA_KHACH_HANG:
				result = HoaDonConstant.TIM_KIEM_THEO_MA_KHACH_HANG_MAX_PAGE;
				break;
			case HoaDonConstant.TEN_KHACH_HANG:
				result = HoaDonConstant.TIM_KIEM_THEO_TEN_KHACH_HANG_MAX_PAGE;
				break;
			case HoaDonConstant.SO_DIEN_THOAI_KHACH_HANG:
				result = HoaDonConstant.TIM_KIEM_THEO_SO_DIEN_THOAI_MAX_PAGE;
				break;

			default:
				break;
			}

			if (localDate != null) {
				result += " and day(ngayLap)=" + localDate.getDayOfMonth() + " and month(ngayLap)="
						+ localDate.getMonthValue() + " and year(ngayLap)=" + localDate.getYear();
			}

			preparedStatement = connection.prepareStatement(result);
			preparedStatement.setString(1, "%" + timKiem + "%");

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next())
				maxPage = Integer.valueOf(resultSet.getString("total"));

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return (int) Math.ceil(maxPage * 1.00 / size);
	}

	public List<HoaDon> timKiemHoaDons(String timKiem, String field, LocalDate localDate, int from, int to) {

		List<HoaDon> hoaDons = new ArrayList<>();

		String result = "";

		try {

			switch (field) {
			case "":

				result = HoaDonConstant.TIM_KIEM_THEO_MA_HOA_DON;
				break;
			case HoaDonConstant.MA_HOA_DON:
				result = HoaDonConstant.TIM_KIEM_THEO_MA_HOA_DON;
				break;
			case HoaDonConstant.MA_NHAN_VIEN_LAP_HOA_DON:
				result = HoaDonConstant.TIM_KIEM_THEO_MA_NHAN_VIEN;
				break;

			case HoaDonConstant.TEN_NHAN_VIEN_LAP_HOA_DON:
				result = HoaDonConstant.TIM_KIEM_THEO_TEN_NHAN_VIEN;
				break;

			case HoaDonConstant.MA_KHACH_HANG:
				result = HoaDonConstant.TIM_KIEM_THEO_MA_KHACH_HANG;
				break;
			case HoaDonConstant.TEN_KHACH_HANG:
				result = HoaDonConstant.TIM_KIEM_THEO_TEN_KHACH_HANG;
				break;
			case HoaDonConstant.SO_DIEN_THOAI_KHACH_HANG:
				result = HoaDonConstant.TIM_KIEM_THEO_SO_DIEN_THOAI;
				break;

			default:
				break;
			}

			if (localDate != null) {
				result += " and day(ngayLap)=" + localDate.getDayOfMonth() + " and month(ngayLap)="
						+ localDate.getMonthValue() + " and year(ngayLap)=" + localDate.getYear();
			}
			
			String sql = XuLyChung.xuLyCauSqlPhanTrang(result, from, to);
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setNString(1, "%" + timKiem + "%");
	
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				HoaDon hoaDon = HoaDonConverter.getHoaDon(resultSet);
				
				hoaDons.add(hoaDon);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return hoaDons;
	}
}

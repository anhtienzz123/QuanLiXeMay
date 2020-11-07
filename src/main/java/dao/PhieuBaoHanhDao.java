package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import constant.KhachHangConstant;
import constant.LoaiXeConstant;
import constant.PhieuBaoHanhConstant;
import converter.KhachHangConverter;
import converter.PhieuBaoHanhConverter;
import db.DatabaseConnect;
import entity.KhachHang;
import entity.PhieuBaoHanh;

public class PhieuBaoHanhDao {
	private static PhieuBaoHanhDao instance;
	private Connection connection;

	private PhieuBaoHanhDao() {
		connection = DatabaseConnect.getInstance();
	}

	public static PhieuBaoHanhDao getInstance() {
		if (instance == null)
			instance = new PhieuBaoHanhDao();
		return instance;
	}

	public List<PhieuBaoHanh> getPhieuBaoHanhs() {
		List<PhieuBaoHanh> phieuBaoHanhs = new ArrayList<PhieuBaoHanh>();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(PhieuBaoHanhConstant.GET_PHIEU_BAO_HANH);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				PhieuBaoHanh phieuBaoHanh = PhieuBaoHanhConverter.getPhieuBaoHanh(resultSet);
				phieuBaoHanhs.add(phieuBaoHanh);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return phieuBaoHanhs;
	}
	
	
	public List<PhieuBaoHanh> getPhieuBaoHanhs (int from, int to){
		
		List<PhieuBaoHanh> phieuBaoHanhs = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(PhieuBaoHanhConstant.GET_PHIEU_BAO_HANHS_PHAN_TRANG);
			preparedStatement.setInt(1, from);
			preparedStatement.setInt(2, to);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				PhieuBaoHanh phieuBaoHanh = PhieuBaoHanhConverter.getPhieuBaoHanh(resultSet);
				phieuBaoHanhs.add(phieuBaoHanh);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return phieuBaoHanhs;
	}

	public PhieuBaoHanh getPhieuBaoHanhTheoMa(String maPhieuBaoHanh) {

		PhieuBaoHanh phieuBaoHanh = null;

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(PhieuBaoHanhConstant.GET_PHIEU_BAO_HANH_THEO_MA);
			preparedStatement.setString(1, maPhieuBaoHanh);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
				phieuBaoHanh = PhieuBaoHanhConverter.getPhieuBaoHanh(resultSet);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return phieuBaoHanh;
	}

	public PhieuBaoHanh getPhieuBaoHanhTheoMaHopDong(String maHopDong) {

		PhieuBaoHanh phieuBaoHanh = null;

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(PhieuBaoHanhConstant.GET_PHIEU_BAO_HANH_THEO_MA_HOP_DONG);
			preparedStatement.setString(1, maHopDong);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
				phieuBaoHanh = PhieuBaoHanhConverter.getPhieuBaoHanh(resultSet);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return phieuBaoHanh;
	}

	public boolean themPhieuBaoHanh(PhieuBaoHanh phieuBaoHanh) {

		int n = 0;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(PhieuBaoHanhConstant.THEM_PHIEU_BAO_HANH);
			PhieuBaoHanhConverter.themPhieuBaoHanh(preparedStatement, phieuBaoHanh);
			n = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return n > 0;
	}

	public boolean capNhatPhieuBaoHanh(PhieuBaoHanh phieuBaoHanh) {

		int n = 0;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(PhieuBaoHanhConstant.CAP_NHAP_PHIEU_BAO_HANH);
			PhieuBaoHanhConverter.capDanhMucBaoHanh(preparedStatement, phieuBaoHanh);
			n = preparedStatement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return n > 0;
	}
	
	public boolean kiemTraMaKhongTrung(String maPhieuBaoHanh) {

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(PhieuBaoHanhConstant.KIEM_TRA_MA_KHONG_TRUNG);
			preparedStatement.setString(1, maPhieuBaoHanh);

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

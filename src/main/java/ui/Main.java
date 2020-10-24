package ui;

import java.sql.SQLException;

import converter.DocSo;
import dao.DanhMucBaoHanhDao;
import dao.KhachHangDao;
import db.DatabaseConnect;
import entity.DanhMucBaoHanh;
import entity.KhachHang;

public class Main {

	public static void main(String[] args) throws SQLException {
		DatabaseConnect.connect();
		KhachHangDao khachHangDao = KhachHangDao.getInstance();
		KhachHang khachHang = new KhachHang();
		DanhMucBaoHanhDao danhMucBaoHanhDao = DanhMucBaoHanhDao.getInstance();
		DanhMucBaoHanh danhMucBaoHanh = new DanhMucBaoHanh("DM123", "Bánh xe");
		System.out.println(danhMucBaoHanhDao.getDanhMucBaoHanhTheoMa("DM123"));
	}
	
}

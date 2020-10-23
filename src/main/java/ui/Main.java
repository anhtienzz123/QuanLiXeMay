package ui;

import java.sql.SQLException;

import converter.DocSo;
import dao.KhachHangDao;
import db.DatabaseConnect;
import entity.KhachHang;

public class Main {

	public static void main(String[] args) throws SQLException {
		DatabaseConnect.connect();
		KhachHangDao khachHangDao = KhachHangDao.getInstance();
		KhachHang khachHang = new KhachHang();

		System.out.println(khachHangDao.capNhatKhachHang(khachHang));
	}
	
}

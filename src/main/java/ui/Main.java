package ui;

import java.sql.Date;
import java.sql.SQLException;

import dao.KhachHangDao;
import db.DatabaseConnect;
import entity.KhachHang;

public class Main {

	public static void main(String[] args) throws SQLException {
		DatabaseConnect.connect();
		
		KhachHangDao khachHangDao = KhachHangDao.getInstance();
		KhachHang khachHang = new KhachHang("789", "1", "dsds", new Date(2020, 5, 2), "dsds", "dsds");
		System.out.println(khachHangDao.capNhatKhachHang(khachHang));;
	}
}

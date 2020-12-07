package ui;

import java.sql.SQLException;

import dao.XeMayDao;
import db.DatabaseConnect;

public class TestMain_TienHuynh {
	
	public static final String TAT_CA = "Tất cả";
   
	public static void main(String[] args) throws SQLException {
		DatabaseConnect.connect();
		
		XeMayDao xeMayDao = XeMayDao.getInstance();
		
		xeMayDao.getTenXeMaysTheoNhieuTieuChi("", "", TAT_CA, TAT_CA, TAT_CA, TAT_CA, TAT_CA, TAT_CA).forEach((key,value) -> {
			
			System.out.println(key+ " - " + value);
		});;
	}
}

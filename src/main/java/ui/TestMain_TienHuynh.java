package ui;

import java.io.IOException;
import java.sql.SQLException;

import dao.XeMayDao;
import db.DatabaseConnect;

public class TestMain_TienHuynh {


	public static final String FILE = "C:/Users/admin/Desktop/Test";
	
	public static final String TAT_CA = "Tất cả";
	private static final String RONG = "";
	private static final int FROM = 1;
	private static final int TO = 20;

	public static void main(String[] args) throws SQLException, IOException {
		DatabaseConnect.connect();
		
		XeMayDao xeMayDao = XeMayDao.getInstance();
		
//		System.out.println(xeMayDao.getMaxPageTheoNhieuTieuChiGomNhom(RONG, "Tên giá", TAT_CA, TAT_CA, TAT_CA, TAT_CA, TAT_CA, TAT_CA, 3) );
		
//		xeMayDao.getXeMaysTheoNhieuTieuChiGomNhom(RONG, "Tên giá", TAT_CA, TAT_CA, TAT_CA, TAT_CA, TAT_CA, TAT_CA, FROM, TO)
//		.forEach((key,value) -> {
//			System.out.println("==== Thong tin xe may");
//			System.out.println("- ten xe may" + key.getTenXeMay());
//			System.out.println("- gia xe may" + key.tinhGiaBan());
//			
//			System.out.println("==== So luong ton");
//			System.out.println("- so luong xe" + value);
//		});

		
	}
}

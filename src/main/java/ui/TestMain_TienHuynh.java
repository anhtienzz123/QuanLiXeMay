package ui;

import java.io.IOException;
import java.sql.SQLException;

import customoutput.ThongTinChungXeMay;
import dao.ThongKeQuanLiDao;
import dao.ThongTinChungXeMayDao;
import dao.XeMayDao;
import db.DatabaseConnect;
import other.SinhRaThongTin;

public class TestMain_TienHuynh {

	public static final String FILE = "C:/Users/admin/Desktop/Test";

	public static final String TAT_CA = "Tất cả";
	private static final String RONG = "";
	private static final int FROM = 1;
	private static final int TO = 20;

	public static void main(String[] args) throws SQLException, IOException {
		DatabaseConnect.connect();

		XeMayDao xeMayDao = XeMayDao.getInstance();
		ThongTinChungXeMayDao thongTinChungXeMayDao = ThongTinChungXeMayDao.getInstance();
		ThongKeQuanLiDao thongKeQuanLiDao = ThongKeQuanLiDao.getInstance();

		ThongTinChungXeMay thongTinChungXeMay = new ThongTinChungXeMay("SH Mode 50", "anh2",  2000, 1, 36, 150,
				"Xe tay ga", "SH",  "day la mo ta", null);

		System.out.println(thongTinChungXeMayDao.capNhapThongTinChungXeMay("SH Mode 51", thongTinChungXeMay)
				? "Cap nhat thanh cong"
				: "Cap nhat that bai");
		;

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
//
//		ThongTinChungXeMayDao thongTinChungXeMayDao = ThongTinChungXeMayDao.getInstance();
//		
//		System.out.println(thongTinChungXeMayDao.getThongTinChungXeMayTheoTenXeMay("Sh mode 50"));

		// Hàm sinh thông tin xe máy
		// 
		//SinhRaThongTin.sinhRaThongTinXeMay("data/xemay.txt", 2); // 2 là số lượng mỗi chiếc muốn random
//		
//		thongKeQuanLiDao.thongKeXeBanTrongNgay(9, 12, 2020).forEach((key,value) -> {
//			 System.out.println(key + " : " + value);
//		});
		
		thongKeQuanLiDao.thongXeSoLuongXeTon().forEach( (key,value) -> {
			System.out.println(key + " : " + value);
		});
	}
}

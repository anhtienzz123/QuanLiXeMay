package ui;

import dao.HoaDonDao;
import db.DatabaseConnect;
import entity.HoaDon;
import other.XuLiXuatFile;

public class TestMain_TienHuynh {

	public static final String FILE = "C:/Users/admin/Desktop/Test";

	public static final String TAT_CA = "Tất cả";
//	private static final String RONG = "";
//	private static final int FROM = 1;
//	private static final int TO = 20;

	public static void main(String[] args) throws Exception {
		DatabaseConnect.connect();

//		XeMayDao xeMayDao = XeMayDao.getInstance();
//		ThongTinChungXeMayDao thongTinChungXeMayDao = ThongTinChungXeMayDao.getInstance();
//		ThongKeQuanLiDao thongKeQuanLiDao = ThongKeQuanLiDao.getInstance();

		HoaDonDao hoaDonDao = HoaDonDao.getInstance();
		HoaDon hoaDon = hoaDonDao.getHoaDonTheoMaHoaDon("HD104174");

		XuLiXuatFile xuatFile = new XuLiXuatFile();

		//xuatFile.xuatHoaDonRaFileWord(hoaDon);

		//XWPFDocument doc = new XWPFDocument();

		xuatFile.xuatHoaDonRaFileWord1(hoaDon);

	}
}

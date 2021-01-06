package ui;


import java.util.Calendar;
import java.util.Date;

import dao.HopDongDao;
import dao.ThongKeQuanLiDao;
import db.DatabaseConnect;
import entity.HopDong;
import other.DinhDangTien;
import other.EmailSender;
import other.XuLyThoiGian;

public class TestMain_TienHuynh {

	public static final String FILE = "C:/Users/admin/Desktop/Test";

	public static final String TAT_CA = "Tất cả";
//	private static final String RONG = "";
//	private static final int FROM = 1;
//	private static final int TO = 20;

	public static void main(String[] args) throws Exception {
		DatabaseConnect.connect();
		HopDongDao hopDongDao = HopDongDao.getInstance();
		

//		Calendar cal = Calendar.getInstance();
//		cal.add(Calendar.DAY_OF_MONTH, 7);
//		
//		Date date = new Date(cal.get(Calendar.YEAR) , cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
//		System.out.println(date.getDate() + "-"+date.getMonth() + "-" + date.getYear());
//		
//		HopDong hopDong = hopDongDao.getHopDongTheoMa("HDG104477");
//		
//		System.out.println(hopDong.isCheckBaoHanh(date));
//		
//		hopDong.getThoiGianBaoHanhDinhKis().forEach( s -> {
//			System.out.println(s.getDate() + "-"+s.getMonth() + "-" + s.getYear());
//		});
		
		//EmailSender.sendEmailThongBaoBaoHanhDinhKi();
	}
	
	

}

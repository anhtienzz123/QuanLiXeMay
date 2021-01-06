package ui;

import java.util.Calendar;

import dao.HopDongDao;
import db.DatabaseConnect;
import other.EmailSender;

public class TestMain_TienHuynh {

	public static final String FILE = "C:/Users/admin/Desktop/Test";

	public static final String TAT_CA = "Tất cả";
	private static final String RONG = "";
	private static final int FROM = 1;
	private static final int TO = 20;

	public static void main(String[] args) throws Exception {
		DatabaseConnect.connect();
		HopDongDao hopDongDao = HopDongDao.getInstance();

		Calendar cal = Calendar.getInstance();

		// cal.add(Calendar.DAY_OF_MONTH, 7 );

		// System.out.println(cal.get(Calendar.YEAR));

		// Date date1 = new Date(2020, 10, 11);
		// Date date2 = new Date(2020, 9, 11);

		// Calendar cal1 = Calendar.getInstance();

		// cal1.setTime(date2);
		// System.out.println(cal1.get(Calendar.MONTH));

		// System.out.println(date1.compareTo(date2) );

//		HopDong hopDong = hopDongDao.getHopDongTheoMa("HDG104477");
//		
//		
//
//		Calendar calendar = Calendar.getInstance();
//		calendar.set(2021, 6, 4);
//		System.out.println(calendar.getTime().getYear());
//
//		@SuppressWarnings("deprecation")
//		Date thoiGian = new Date(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
//				calendar.get(Calendar.DAY_OF_MONTH));
//
//		
//		System.out.println(hopDong.isCheckBaoHanh(thoiGian));

		
		//EmailSender.sendEmailThongBaoBaoHanhDinhKi();
		
		Integer a = new Integer(1);
		Integer b = new Integer(2);
		
		swap(a, b);
		
		System.out.println(a);
	}
	
	public static void swap(Integer a, Integer b) {
		Integer temp = b;
		b = a;
		
		a = temp;
	}

}

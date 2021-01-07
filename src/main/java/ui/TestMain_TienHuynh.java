package ui;

import java.util.Date;

import dao.HopDongDao;
import db.DatabaseConnect;
import entity.HopDong;

public class TestMain_TienHuynh {




	public static void main(String[] args) throws Exception {

		DatabaseConnect.connect();
		
		HopDongDao honDongDao = HopDongDao.getInstance();
		
		HopDong hopDong = honDongDao.getHopDongTheoMa("HDG104477");
		hopDong.getThoiGianBaoHanhDinhKis().forEach(  s-> System.out.println(s.getDate() + "-" + s.getMonth() + "-" +s.getYear()));;
		Date date = new Date(2021, 1, 14);
		System.out.println(hopDong.checkDot(date));
		
	}

}

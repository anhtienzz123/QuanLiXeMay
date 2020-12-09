package converter;

import customoutput.ThongTinChungXeMay;
import entity.XeMay;

public class ThongTinChungXeMayConverter {

	public static ThongTinChungXeMay toThongTinChiTietXeMay(XeMay xeMay) {
		
		ThongTinChungXeMay thongTinChungXeMay = new ThongTinChungXeMay();
	
		thongTinChungXeMay.setTenXe(xeMay.getTenXeMay());
		thongTinChungXeMay.setTenAnh(xeMay.getTenAnh());
		thongTinChungXeMay.setGiaBan(xeMay.getGiaNhap());
		thongTinChungXeMay.setHeSoBan(xeMay.getHeSoBan());
		thongTinChungXeMay.setBaoHanh(xeMay.getThoiGianBaoHanh());
		thongTinChungXeMay.setSoPhanKhoi(xeMay.getSoPhanKhoi());
		thongTinChungXeMay.setLoaiXe(xeMay.getLoaiXe().getTenLoaiXe());
		thongTinChungXeMay.setDongXe(xeMay.getDongXe().getTenDongXe());
		thongTinChungXeMay.setHangXe(xeMay.getDongXe().getHangXe().getTenHangXe());
		thongTinChungXeMay.setMoTa(xeMay.getMoTa());
		
		
		return thongTinChungXeMay;
	}
}

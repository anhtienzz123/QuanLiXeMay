package converter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import customoutput.ThongTinChungXeMay;
import dao.DongXeDao;
import dao.LoaiXeDao;
import entity.XeMay;

public class ThongTinChungXeMayConverter {

	public static ThongTinChungXeMay toThongTinChiTietXeMay(XeMay xeMay) {
		
		ThongTinChungXeMay thongTinChungXeMay = new ThongTinChungXeMay();
	
		thongTinChungXeMay.setTenXe(xeMay.getTenXeMay());
		thongTinChungXeMay.setTenAnh(xeMay.getTenAnh());
		thongTinChungXeMay.setGiaBan(xeMay.getGiaNhap());
		thongTinChungXeMay.setHeSoBan(xeMay.getHeSoBan());
		thongTinChungXeMay.setThoiGianBaoHanh(xeMay.getThoiGianBaoHanh());
		thongTinChungXeMay.setSoPhanKhoi(xeMay.getSoPhanKhoi());
		thongTinChungXeMay.setLoaiXe(xeMay.getLoaiXe().getTenLoaiXe());
		thongTinChungXeMay.setDongXe(xeMay.getDongXe().getTenDongXe());
		thongTinChungXeMay.setHangXe(xeMay.getDongXe().getHangXe().getTenHangXe());
		thongTinChungXeMay.setMoTa(xeMay.getMoTa());
		
		
		return thongTinChungXeMay;
	}
	
	public static void capNhapThongTinChungXeMay(PreparedStatement preparedStatement, String tenXeMayCu,ThongTinChungXeMay thongTinChungXeMay) throws SQLException {
		preparedStatement.setString(1, thongTinChungXeMay.getTenXe());
		preparedStatement.setString(2, thongTinChungXeMay.getTenAnh());
		preparedStatement.setDouble(3, thongTinChungXeMay.getGiaBan());
		preparedStatement.setDouble(4, thongTinChungXeMay.getHeSoBan());
		preparedStatement.setInt(5, thongTinChungXeMay.getThoiGianBaoHanh());
		preparedStatement.setInt(6, thongTinChungXeMay.getSoPhanKhoi());
		
		LoaiXeDao loaiXeDao = LoaiXeDao.getInstance();
		DongXeDao dongXeDao = DongXeDao.getInstance();
	
		String maLoaiXe = loaiXeDao.getLoaiXeTheoTen(thongTinChungXeMay.getLoaiXe()).getMaLoaiXe();
		String maDongXe = dongXeDao.getDongXeTheoTen(thongTinChungXeMay.getDongXe()).getMaDongXe();

		preparedStatement.setString(7,  maLoaiXe);
		preparedStatement.setString(8, maDongXe);
		preparedStatement.setString(9, thongTinChungXeMay.getMoTa());
		preparedStatement.setString(10, tenXeMayCu);
		
		
		
	}
}

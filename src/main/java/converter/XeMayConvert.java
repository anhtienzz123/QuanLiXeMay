package converter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DongXeDao;
import dao.LoaiXeDao;
import dao.XuatXuDao;
import db.DatabaseConnect;
import entity.DongXe;
import entity.LoaiXe;
import entity.XeMay;
import entity.XuatXu;

public class XeMayConvert {
	public XeMayConvert() {
	}

	public static XeMay getXeMay(ResultSet resultSet) throws SQLException {

		DatabaseConnect.connect();
		LoaiXeDao loaiXeDao = LoaiXeDao.getInstance();
		XuatXuDao xuatXuDao = XuatXuDao.getInstance();
		DongXeDao dongXeDao = DongXeDao.getInstance();

		String maXeMay = resultSet.getString("maXeMay");
		String tenXeMay = resultSet.getString("tenXeMay");
		String urlAnh = resultSet.getString("urlAnh");
		int soLuong = resultSet.getInt("soLuong");
		double giaNhap = resultSet.getDouble("giaNhap");
		double heSoBan = resultSet.getDouble("heSoBan");
		int thoiGianBaoHanh = resultSet.getInt("thoiGianBaoHanh");
		String soKhung = resultSet.getString("soKhung");
		int soPhanKhoi = resultSet.getInt("soPhanKhoi");
		String soSuon = resultSet.getString("soSuon");
		String mauXe = resultSet.getString("maXe");
		LoaiXe loaiXe = loaiXeDao.getLoaiXeTheoMa(resultSet.getString("maLoaiXe"));
		DongXe dongXe = dongXeDao.getDongXeTheoMa(resultSet.getString("maDongXe"));
		XuatXu xuatXu = xuatXuDao.getXuatXuTheoMa(resultSet.getString("maXuatXu"));
		String moTa = resultSet.getString("moTa");
	

		XeMay xeMay = new XeMay(maXeMay, tenXeMay, urlAnh, soLuong, giaNhap, heSoBan, thoiGianBaoHanh, soKhung,
				soPhanKhoi, soSuon, mauXe, loaiXe, dongXe, xuatXu, moTa);
		return xeMay;

	}

	public static void themXeMay(PreparedStatement preparedStatement, XeMay xeMay) throws SQLException {
		preparedStatement.setString(1, xeMay.getMaXeMay());
		preparedStatement.setString(2, xeMay.getTenXeMay());
		preparedStatement.setString(3, xeMay.getUrlAnh());
		preparedStatement.setInt(4, xeMay.getSoLuong());
		preparedStatement.setDouble(5, xeMay.getGiaNhap());
		preparedStatement.setDouble(6,xeMay.getHeSoBan());
		preparedStatement.setInt(7, xeMay.getThoiGianBaoHanh());
		preparedStatement.setString(8, xeMay.getSoKhung());
		preparedStatement.setInt(9, xeMay.getSoPhanKhoi());
		preparedStatement.setString(10, xeMay.getSoSuon());
		preparedStatement.setString(11, xeMay.getMauXe());
		preparedStatement.setString(12, xeMay.getLoaiXe().getMaLoaiXe());
		preparedStatement.setString(13, xeMay.getDongXe().getMaDongXe());
		preparedStatement.setString(14, xeMay.getXuatXu().getMaXuatXu());
		preparedStatement.setString(15, xeMay.getMoTa());
	

	}

	public static void capNhatXeMay(PreparedStatement preparedStatement, XeMay xeMay) throws SQLException {
		preparedStatement.setString(1, xeMay.getTenXeMay());
		preparedStatement.setString(2, xeMay.getUrlAnh());
		preparedStatement.setInt(3, xeMay.getSoLuong());
		preparedStatement.setDouble(4, xeMay.getGiaNhap());
		preparedStatement.setDouble(5, xeMay.getHeSoBan());
		preparedStatement.setInt(6, xeMay.getThoiGianBaoHanh());
		preparedStatement.setString(7, xeMay.getSoKhung());
		preparedStatement.setInt(8, xeMay.getSoPhanKhoi());
		preparedStatement.setString(9, xeMay.getSoSuon());
		preparedStatement.setString(10, xeMay.getMauXe());
		preparedStatement.setString(11, xeMay.getLoaiXe().getMaLoaiXe());
		preparedStatement.setString(12, xeMay.getDongXe().getMaDongXe());
		preparedStatement.setString(13, xeMay.getXuatXu().getMaXuatXu());
		preparedStatement.setString(14, xeMay.getMoTa());
		preparedStatement.setString(15, xeMay.getMaXeMay());
	}
}

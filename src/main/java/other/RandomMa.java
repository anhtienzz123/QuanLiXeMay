package other;

import java.util.Random;

import constant.TenEntity;
import dao.DanhMucBaoHanhDao;
import dao.DongXeDao;
import dao.HangXeDao;
import dao.HoaDonDao;
import dao.HopDongDao;
import dao.KhachHangDao;
import dao.LoaiXeDao;
import dao.NhanVienHanhChinhDao;
import dao.NhanVienKiThuatDao;
import dao.PhieuBaoHanhDao;
import dao.XeMayDao;
import dao.XuatXuDao;
import entity.KhachHang;
import entity.NhanVienHanhChinh;

public class RandomMa {

	private RandomMa() {

	}

	public static String getMaNgauNhien(String tenEntity) {

		String ketQua = "";
		switch (tenEntity) {
		case TenEntity.KHACH_HANG:

			ketQua = randomMaKhachHang();
			break;

		case TenEntity.NHAN_VIEN_HANH_CHINH:

			ketQua = randomMaNhanVienHanhChinh();
			break;

		case TenEntity.NHAN_VIEN_KI_THUAT:

			ketQua = randomMaNhanVienKiThuat();
			break;

		case TenEntity.HOA_DON:

			ketQua = randomMaHoaDon();
			break;

		case TenEntity.HOP_DONG:

			ketQua = randomMaHopDong();
			break;

		case TenEntity.PHIEU_BAO_HANH:

			ketQua = randomMaPhieuBaoHanh();
			break;

		case TenEntity.DANH_MUC_BAO_HANH:

			ketQua = randomMaDanhMucBaoHanh();
			break;

		case TenEntity.XE_MAY:

			ketQua = randomMaXeMay();
			break;

		case TenEntity.DONG_XE:

			ketQua = randomMaDongXe();
			break;

		case TenEntity.HANG_XE:

			ketQua = randomMaHangXe();
			break;

		case TenEntity.LOAI_XE:

			ketQua = randomMaLoaiXe();
			break;

		case TenEntity.XUAT_XU:

			ketQua = randomMaXuatXu();
			break;

		default:
			break;
		}

		return ketQua;

	}

	private static String randomMaKhachHang() {

		KhachHangDao khachHangDao = KhachHangDao.getInstance();
		String ma = "";

		do {
			ma = TenEntity.KHACH_HANG + sinhMaNgauNhien();
		} while (!khachHangDao.kiemTraMaKhongTrung(ma));

		return ma;
	}

	private static String randomMaNhanVienHanhChinh() {

		NhanVienHanhChinhDao nhanVienHanhChinhDao = NhanVienHanhChinhDao.getInstance();
		String ma = "";

		do {
			ma = TenEntity.KHACH_HANG + sinhMaNgauNhien();
		} while (!nhanVienHanhChinhDao.kiemTraMaKhongTrung(ma));

		return ma;
	}

	private static String randomMaNhanVienKiThuat() {
		NhanVienKiThuatDao nhanVienKiThuatDao = NhanVienKiThuatDao.getInstance();
		String ma = "";
		do {
			ma = TenEntity.NHAN_VIEN_KI_THUAT + sinhMaNgauNhien();
		} while (!nhanVienKiThuatDao.kiemTraMaKhongTrung(ma));

		return ma;
	}

	private static String randomMaHoaDon() {
		HoaDonDao hoaDonDao = HoaDonDao.getInstance();
		String ma = "";

		do {
			ma = TenEntity.HOA_DON + sinhMaNgauNhien();
		} while (!hoaDonDao.kiemTraMaKhongTrung(ma));

		return ma;

	}

	private static String randomMaHopDong() {
		HopDongDao hopDongDao = HopDongDao.getInstance();
		String ma = "";
		do {
			ma = TenEntity.HOP_DONG + sinhMaNgauNhien();
		} while (!hopDongDao.kiemTraMaKhongTrung(ma));

		return ma;
	}

	private static String randomMaPhieuBaoHanh() {
		PhieuBaoHanhDao phieuBaoHanhDao = PhieuBaoHanhDao.getInstance();
		String ma = "";
		do {
			ma = TenEntity.PHIEU_BAO_HANH + sinhMaNgauNhien();
		} while (!phieuBaoHanhDao.kiemTraMaKhongTrung(ma));

		return ma;
	}

	private static String randomMaDanhMucBaoHanh() {
		DanhMucBaoHanhDao danhMucBaoHanhDao = DanhMucBaoHanhDao.getInstance();
		String ma = "";
		do {
			ma = TenEntity.DANH_MUC_BAO_HANH + sinhMaNgauNhien();
		} while (!danhMucBaoHanhDao.kiemTraMaKhongTrung(ma));

		return ma;
	}

	private static String randomMaXeMay() {
		XeMayDao xeMayDao = XeMayDao.getInstance();
		String ma = "";
		do {
			ma = TenEntity.XE_MAY + sinhMaNgauNhien();
		} while (!xeMayDao.kiemTraMaKhongTrung(ma));

		return ma;
	}

	private static String randomMaDongXe() {
		DongXeDao dongXeDao = DongXeDao.getInstance();
		String ma = "";
		do {
			ma = TenEntity.DONG_XE + sinhMaNgauNhien();
		} while (!dongXeDao.kiemTraMaKhongTrung(ma));

		return ma;
	}

	private static String randomMaHangXe() {
		HangXeDao hangXeDao = HangXeDao.getInstance();
		String ma = "";
		do {
			ma = TenEntity.HANG_XE + sinhMaNgauNhien();
		} while (!hangXeDao.kiemTraMaKhongTrung(ma));

		return ma;
	}

	private static String randomMaLoaiXe() {
		LoaiXeDao loaiXeDao = LoaiXeDao.getInstance();
		String ma = "";
		do {
			ma = TenEntity.LOAI_XE + sinhMaNgauNhien();
		} while (!loaiXeDao.kiemTraMaKhongTrung(ma));

		return ma;
	}

	private static String randomMaXuatXu() {
		XuatXuDao xuatXuDao = XuatXuDao.getInstance();
		String ma = "";
		do {
			ma = TenEntity.XUAT_XU + sinhMaNgauNhien();
		} while (!xuatXuDao.kiemTraMaKhongTrung(ma));

		return ma;
	}

	private static String sinhMaNgauNhien() {
		Random random = new Random();
		return String.valueOf(random.nextInt((999999 - 100000) + 1) + 100000);
	}

}

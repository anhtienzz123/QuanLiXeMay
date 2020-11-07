package other;

import java.util.Random;

import constant.TenEntity;
import dao.KhachHangDao;
import dao.NhanVienHanhChinhDao;
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

		return "";
	}

	private static String randomMaHoaDon() {

		return "";
	}

	private static String randomMaHopDong() {

		return "";
	}

	private static String randomMaPhieuBaoHanh() {

		return "";
	}

	private static String randomMaDanhMucBaoHanh() {

		return "";
	}

	private static String randomMaXeMay() {

		return "";
	}

	private static String randomMaDongXe() {

		return "";
	}

	private static String randomMaHangXe() {

		return "";
	}

	private static String randomMaLoaiXe() {

		return "";
	}

	private static String randomMaXuatXu() {

		return "";
	}

	private static String sinhMaNgauNhien() {
		Random random = new Random();
		return String.valueOf(random.nextInt((999999 - 100000) + 1) + 100000);
	}

}

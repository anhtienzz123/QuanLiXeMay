package other;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import constant.TenEntity;
import dao.KhachHangDao;
import dao.NhanVienHanhChinhDao;
import dao.NhanVienKiThuatDao;
import entity.KhachHang;
import entity.NhanVienHanhChinh;
import entity.NhanVienKiThuat;

public class SinhRaThongTin {

	private SinhRaThongTin() {

	}

	// Sinh ra danh sách thông tin nhân viên hành chính
	public static void sinhVaLuuDanhSachThongTinNhanVienHanhChinh(int soLuong) {

		NhanVienHanhChinhDao nhanVienHanhChinhDao = NhanVienHanhChinhDao.getInstance();
		List<NhanVienHanhChinh> nhanVienHanhChinhs = sinhRaDanhSachThongTinNhanVienHanhChinh(soLuong);
		nhanVienHanhChinhs.forEach(s -> nhanVienHanhChinhDao.themNhanVienHanhChinh(s));
	}

	// Sinh ra danh sách thông tin nhân viên kĩ thuật
	public static void sinhVaLuuDanhSachThongTinNhanVienKiThuat(int soLuong) {

		NhanVienKiThuatDao nhanVienKiThuatDao = NhanVienKiThuatDao.getInstance();
		List<NhanVienKiThuat> nhanVienKiThuats = sinhRaDanhSachThongTinNhanVienKiThuat(soLuong);
		nhanVienKiThuats.forEach(s -> nhanVienKiThuatDao.themNhanVienKiThuat(s));
	}

	//  Sinh ra danh sách thông tin khách hàng
	public static void sinhVaLuuDanhSachThongTinKhachHang(int soLuong) {

		KhachHangDao khachHangDao = KhachHangDao.getInstance();
		List<KhachHang> khachHangs = sinhRaDanhSachThongTinKhachHang(soLuong);
		khachHangs.forEach(s -> khachHangDao.themKhachHang(s));
	}
	
	
	

	public static List<NhanVienHanhChinh> sinhRaDanhSachThongTinNhanVienHanhChinh(int size) {

		List<NhanVienHanhChinh> nhanVienHanhChinhs = new ArrayList<NhanVienHanhChinh>();

		int i = 0;

		while (i < size) {
			NhanVienHanhChinh NhanVienHanhChinh = sinhRaNhanVienHanhChinh();

			if (!nhanVienHanhChinhs.contains(NhanVienHanhChinh)) {
				nhanVienHanhChinhs.add(NhanVienHanhChinh);
				i++;
			}

		}

		return nhanVienHanhChinhs;

	}

	public static List<NhanVienKiThuat> sinhRaDanhSachThongTinNhanVienKiThuat(int size) {

		List<NhanVienKiThuat> nhanVienKiThuats = new ArrayList<>();

		int i = 0;

		while (i < size) {
			NhanVienKiThuat nhanVienKiThuat = sinhRaNhanVienKiThuat();

			if (!nhanVienKiThuats.contains(nhanVienKiThuat)) {
				nhanVienKiThuats.add(nhanVienKiThuat);
				i++;
			}

		}

		return nhanVienKiThuats;

	}

	public static List<KhachHang> sinhRaDanhSachThongTinKhachHang(int size) {

		List<KhachHang> khachHangs = new ArrayList<KhachHang>();

		int i = 0;

		while (i < size) {
			KhachHang khachHang = sinhRaKhachHang();

			if (!khachHangs.contains(khachHang)) {
				khachHangs.add(khachHang);
				i++;
			}

		}

		return khachHangs;

	}

	public static KhachHang sinhRaKhachHang() {

		String maKhachHang = RandomMa.getMaNgauNhien(TenEntity.KHACH_HANG);
		String soCMT = RandomThongTin.randomSoCMT();

		Random random = new Random();
		String hoTenKH = random.nextInt(2) == 0 ? RandomThongTin.randomHoTenConTrai()
				: RandomThongTin.randomHoTenConGai();
		String soDienThoai = RandomThongTin.randomSoDienThoai();
		Date ngaySinh = RandomThongTin.randomNgaySinh();
		String diaChiKH = RandomThongTin.randomDiaChi();

		KhachHang khachHang = new KhachHang(maKhachHang, soCMT, hoTenKH, ngaySinh, soDienThoai, diaChiKH);

		return khachHang;
	}

	public static NhanVienHanhChinh sinhRaNhanVienHanhChinh() {

		Random random = new Random();

		String maNVHanhChinh = RandomMa.getMaNgauNhien(TenEntity.NHAN_VIEN_HANH_CHINH);
		// 0 là con trai, 1 là con gái
		int loaiGioiTinh = random.nextInt(2);

		String hoTenNV = loaiGioiTinh == 0 ? RandomThongTin.randomHoTenConTrai() : RandomThongTin.randomHoTenConGai();
		String matKhau = maNVHanhChinh;
		boolean gioiTinh = loaiGioiTinh == 0 ? true : false;
		Date ngaySinh = RandomThongTin.randomNgaySinh();
		String soDienThoai = RandomThongTin.randomSoDienThoai();
		String diaChi = RandomThongTin.randomDiaChi();
		String chucVu = "Bán hàng";
		String trinhDoHocVan = "Đại học";
		boolean vaiTro = true;
		boolean trangThai = true;

		NhanVienHanhChinh nhanVienHanhChinh = new NhanVienHanhChinh(maNVHanhChinh, hoTenNV, matKhau, gioiTinh, ngaySinh,
				soDienThoai, diaChi, null, chucVu, trinhDoHocVan, vaiTro, trangThai);

		return nhanVienHanhChinh;

	}

	public static NhanVienKiThuat sinhRaNhanVienKiThuat() {

		Random random = new Random();

		String maNVKiThuat = RandomMa.getMaNgauNhien(TenEntity.NHAN_VIEN_KI_THUAT);

		// 0 là con trai, 1 là con gái
		int loaiGioiTinh = random.nextInt(4);

		String hoTen = loaiGioiTinh == 0 ? RandomThongTin.randomHoTenConGai() : RandomThongTin.randomHoTenConTrai();
		Date ngaySinh = RandomThongTin.randomNgaySinh();
		String soDienThoai = RandomThongTin.randomSoDienThoai();
		String diaChi = RandomThongTin.randomDiaChi();
		boolean gioiTinh = loaiGioiTinh == 0 ? false : true;

		int bacTho = random.nextInt(7) + 1;
		int soNamKinhNghiem = bacTho * 2;
		boolean trangThai = true;

		NhanVienKiThuat nhanVienKiThuat = new NhanVienKiThuat(maNVKiThuat, hoTen, ngaySinh, soDienThoai, diaChi,
				soNamKinhNghiem, bacTho, trangThai, null, gioiTinh);

		return nhanVienKiThuat;

	}



}

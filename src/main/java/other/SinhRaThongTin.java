package other;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import constant.TenEntity;
import dao.DongXeDao;
import dao.KhachHangDao;
import dao.LoaiXeDao;
import dao.NhanVienHanhChinhDao;
import dao.NhanVienKiThuatDao;
import dao.XeMayDao;
import dao.XuatXuDao;
import entity.DongXe;
import entity.KhachHang;
import entity.LoaiXe;
import entity.NhanVienHanhChinh;
import entity.NhanVienKiThuat;
import entity.XeMay;
import entity.XuatXu;

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

	// Sinh ra danh sách thông tin khách hàng
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

	public static boolean sinhRaThongTinXeMay(String file, int soLuongSinhRaChoMoiChiec) {

		boolean result = false;
		XeMayDao xeMayDao = XeMayDao.getInstance();

		// Đọc dữ liệu từ File với Scanner
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(file);

			Scanner scanner = new Scanner(fileInputStream);
			scanner.nextLine();

			try {
				while (scanner.hasNextLine()) {

					List<XeMay> xeMays = bienDoiTextDataThanhXeMays(scanner.nextLine(), soLuongSinhRaChoMoiChiec);

					xeMays.forEach(s -> xeMayDao.themXeMay(s));

				}

				result = true;
			} finally {
				try {
					scanner.close();
					fileInputStream.close();
				} catch (IOException ex) {

				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;

	}

	private static List<XeMay> bienDoiTextDataThanhXeMays(String datas, int soLuong) {

		LoaiXeDao loaiXeDao = LoaiXeDao.getInstance();
		DongXeDao dongXeDao = DongXeDao.getInstance();
		XuatXuDao xuatXuDao = XuatXuDao.getInstance();

		List<XeMay> xeMays = new ArrayList<XeMay>();

		String[] temp = datas.split(";");

		String tenXeMay = temp[0];
		String tenAnh = temp[1];
		double giaNhap = Double.valueOf(temp[2]);
		double heSoBan = Double.valueOf(temp[3]);
		int thoiGianBaoHanh = Integer.valueOf(temp[4]);
		int soPhanKhoi = Integer.valueOf(temp[5]);

	   
		LoaiXe loaiXe = loaiXeDao.getLoaiXeTheoTen(temp[7]);
		if (loaiXe == null) {
			loaiXeDao.themLoaiXe(new LoaiXe(RandomMa.getMaNgauNhien(TenEntity.LOAI_XE), temp[7]));

			loaiXe = loaiXeDao.getLoaiXeTheoTen(temp[7]);
		}

		DongXe dongXe = dongXeDao.getDongXeTheoTen(temp[8]);

		for (int i = 0; i < soLuong; i++) {

			String maXeMay = RandomMa.getMaNgauNhien(TenEntity.XE_MAY);
			String soKhung = RandomThongTin.randomSoKhungXeMay();
			String soSuon = RandomThongTin.randomSoSuon();

			String mauXe = randomMauXe(temp[6]);
			String tenXuatXu = randomXuatXu(temp[9]);

			XuatXu xuatXu = xuatXuDao.getXuatXuTheoTen(tenXuatXu);
			if (xuatXu == null) {
				xuatXuDao.themXuatXu(new XuatXu(RandomMa.getMaNgauNhien(TenEntity.XUAT_XU), tenXuatXu));
				xuatXu = xuatXuDao.getXuatXuTheoTen(tenXuatXu);

			}

			XeMay xeMay = new XeMay(maXeMay, tenXeMay, tenAnh, 1, giaNhap, heSoBan, thoiGianBaoHanh, soKhung,
					soPhanKhoi, soSuon, mauXe, loaiXe, dongXe, xuatXu);

			xeMays.add(xeMay);
		}

		return xeMays;

	}

	private static String randomMauXe(String mauXe) {

		String result = "";

		String[] temp = mauXe.split(",");

		Random random = new Random();

		int rd = random.nextInt(temp.length);

		result = temp[rd];

		return result;
	}

	private static String randomXuatXu(String xuatXu) {

		String result = "";

		String[] temp = xuatXu.split(",");

		Random random = new Random();

		int rd = random.nextInt(temp.length);

		result = temp[rd];

		return result;
	}

	public static void main(String[] args) {
		sinhRaThongTinXeMay("data/xemay.txt", 2);
	}

}

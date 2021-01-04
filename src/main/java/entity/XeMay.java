package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class XeMay {

	private String maXeMay;
	private String tenXeMay;
	private String tenAnh;
	private int soLuong;
	private double giaNhap;
	private double heSoBan;
	private int thoiGianBaoHanh;
	private String soKhung;
	private int soPhanKhoi;
	private String soSuon;
	private String mauXe;
	private LoaiXe loaiXe;
	private DongXe dongXe;
	private XuatXu xuatXu;
	private String moTa;

	public XeMay(String maXeMay, String tenXeMay) {
		super();
		this.maXeMay = maXeMay;
		this.tenXeMay = tenXeMay;
	}

	public double tinhGiaBan() {
		return giaNhap * (1 + (heSoBan / 100));
	}

	public double tinhThue() {
		return (tinhGiaBan() / 100) * dongXe.getThue();
	}

	public XeMay(String tenXeMay, double giaNhap, int thoiGianBaoHanh, LoaiXe loaiXe, DongXe dongXe) {
		super();
		this.tenXeMay = tenXeMay;
		this.giaNhap = giaNhap;
		this.thoiGianBaoHanh = thoiGianBaoHanh;
		this.loaiXe = loaiXe;
		this.dongXe = dongXe;
	}

	public XeMay(String maXeMay, String tenXeMay, String tenAnh, int soLuong, double giaNhap, double heSoBan,
			int thoiGianBaoHanh, String soKhung, int soPhanKhoi, String soSuon, String mauXe, LoaiXe loaiXe,
			DongXe dongXe, XuatXu xuatXu) {
		super();
		this.maXeMay = maXeMay;
		this.tenXeMay = tenXeMay;
		this.tenAnh = tenAnh;
		this.soLuong = soLuong;
		this.giaNhap = giaNhap;
		this.heSoBan = heSoBan;
		this.thoiGianBaoHanh = thoiGianBaoHanh;
		this.soKhung = soKhung;
		this.soPhanKhoi = soPhanKhoi;
		this.soSuon = soSuon;
		this.mauXe = mauXe;
		this.loaiXe = loaiXe;
		this.dongXe = dongXe;
		this.xuatXu = xuatXu;
	}

}

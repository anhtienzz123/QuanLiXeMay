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

	public double getThue() {
		return (tinhGiaBan() / 100) * dongXe.getThue();
	}

}

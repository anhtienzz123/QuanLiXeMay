package customoutput;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThongTinChungXeMay {
	
	private String tenXe;
	private String tenAnh;
	private int soLuongXe;
	private double giaBan;
	private double heSoBan;
	private int thoiGianBaoHanh;
	private int soPhanKhoi;
	private String loaiXe;
	private String dongXe;
	private String hangXe;
	private String moTa;
	private List<ThongTinChiTietXeMay> thongTinChiTietXeMays;
	public ThongTinChungXeMay(String tenXe, String tenAnh, double giaBan, double heSoBan, int thoiGianBaoHanh,
			int soPhanKhoi, String loaiXe, String dongXe, String moTa,
			List<ThongTinChiTietXeMay> thongTinChiTietXeMays) {
		super();
		this.tenXe = tenXe;
		this.tenAnh = tenAnh;
		this.giaBan = giaBan;
		this.heSoBan = heSoBan;
		this.thoiGianBaoHanh = thoiGianBaoHanh;
		this.soPhanKhoi = soPhanKhoi;
		this.loaiXe = loaiXe;
		this.dongXe = dongXe;
		this.moTa = moTa;
		this.thongTinChiTietXeMays = thongTinChiTietXeMays;
	}
	
	
	
}

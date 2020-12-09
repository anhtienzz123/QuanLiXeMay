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
	private int baoHanh;
	private int soPhanKhoi;
	private String loaiXe;
	private String dongXe;
	private String hangXe;
	private String moTa;
	private List<ThongTinChiTietXeMay> thongTinChiTietXeMays;
	
}

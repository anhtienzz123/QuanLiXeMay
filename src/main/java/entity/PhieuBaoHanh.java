package entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhieuBaoHanh {

	private String maPhieuBaoHanh;
	private HopDong hopDong;
	private Date ngayBaoHanh;
	private NhanVienKiThuat nhanVienKiThuat;
	private List<ChiTietBaoHanh> chiTietBaoHanhs;

	public PhieuBaoHanh(String maPhieuBaoHanh) {

		this.maPhieuBaoHanh = maPhieuBaoHanh;
	}

	public PhieuBaoHanh(String maPhieuBaoHanh, HopDong hopDong, Date ngayBaoHanh, NhanVienKiThuat nhanVienKiThuat) {
		super();
		this.maPhieuBaoHanh = maPhieuBaoHanh;
		this.hopDong = hopDong;
		this.ngayBaoHanh = ngayBaoHanh;
		this.nhanVienKiThuat = nhanVienKiThuat;
		
		this.chiTietBaoHanhs = new ArrayList<ChiTietBaoHanh>();
	}

	public void themChiTietBaoHanh(ChiTietBaoHanh chiTietBaoHanh) {

//		System.out.println(chiTietBaoHanh.getDanhMucBaoHanh().getTenDanhMucBaoHanh());
		for (ChiTietBaoHanh ctBaoHanh : chiTietBaoHanhs) {

			if (ctBaoHanh.getDanhMucBaoHanh().getMaDanhMucBaoHanh()
					.equalsIgnoreCase(chiTietBaoHanh.getDanhMucBaoHanh().getMaDanhMucBaoHanh())) {
				return;
			}
		}
		this.chiTietBaoHanhs.add(chiTietBaoHanh);
	}

}

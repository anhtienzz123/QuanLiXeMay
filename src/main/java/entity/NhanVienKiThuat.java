package entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NhanVienKiThuat {

	private String maNVKiThuat;
	private String hoTen;
	private Date ngaySinh;
	private String soDienThoai;
	private String diaChi;
	private int soNamKinhNghiem;
	private int bacTho;
	private boolean trangThai;
	private String tenAnh;
	private boolean gioiTinh;

	public NhanVienKiThuat(String maNVKiThuat) {

		this.maNVKiThuat = maNVKiThuat;
	}

	@Override
	public boolean equals(Object obj) {

		NhanVienKiThuat nhanVienKiThuat = (NhanVienKiThuat) obj;

		if (nhanVienKiThuat.getMaNVKiThuat().equalsIgnoreCase(maNVKiThuat)
				|| nhanVienKiThuat.getHoTen().equalsIgnoreCase(hoTen)
				|| nhanVienKiThuat.getSoDienThoai().equalsIgnoreCase(soDienThoai))
			return true;

		return false;
	}

	@Override
	public int hashCode() {
		
		return super.hashCode();
	}
}

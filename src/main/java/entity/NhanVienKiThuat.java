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
}

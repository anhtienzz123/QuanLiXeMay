package entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NhanVienHanhChinh {

	private String maNVHanhChinh;
	private String hoTenNV;
	private String matKhau;
	private boolean gioiTinh;
	private Date ngaySinh;
	private String soDienThoai;
	private String diaChi;
	private String tenAnh;
	private String chucVu;
	private String trinhDoHocVan;
	private boolean vaiTro;
	private boolean trangThai;

}

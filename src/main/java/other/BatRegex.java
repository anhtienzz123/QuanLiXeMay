package other;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class BatRegex {

	private BatRegex() {

	}

	public static final String SO_CMT = "Số chứng minh thư phải gồm 9 hoặc 12 kí tự số.";
	public static final String TEN_KHACH_HANG = "Tên khách hàng không được có số.";
	public static final String SO_DIEN_THOAI = "Số điện thoại phải gồm 10 chữ số, bắt đầu bằng số 0";
	public static final String NGAY_SINH = "Ngày sinh phải lớn hơn 18 tuổi";
	public static final String BAO_HANH = "Bảo hành là số nguyên và lớn hơn 0";
	public static final String SO_KHUNG = "Số khung gồm có 17 kí tự";
	public static final String SO_SUON = "Số sườn có dạng XX-YYYYYY (X: là chữ cái, Y: là kí tự số)";
	public static final String HE_SO_BAN = "Hệ số bán là số nguyên";
	public static final String SO_LUONG = "Số lượng là kí tự số và lớn hơn 0";
	public static final String GIA_NHAP = "Giá nhập là kí tự số và lớn hơn 0";
	public static final String TEN_XE = "Tên xe không được để trống";

	// đúng nếu hợp lệ
	public static boolean kiemTraSoCMT(JTextField text) {

		String regex = "^\\d{9}$";

		if (text.getText().matches(regex))
			return true;

		return false;
	}

	public static boolean kiemTraTen(JTextField text) {

		String regex = "^\\D+";

		if (text.getText().matches(regex))
			return true;

		return false;
	}

	public static boolean kiemTraSoDienThoai(JTextField text) {

		String regex = ("(^(03)[2-9]\\d{7})|(^(07)[06-9]\\d{7})|(^(08)[1-5]\\d{7})|(^(056)\\d{7})|(^(058)\\d{7})|(^(059)\\d{7})|(^(09)[0-46-9]\\d{7})");

		if (text.getText().matches(regex))
			return true;

		return false;
	}

	public static boolean kiemTraNgaySinh(JDateChooser ngaySinh) {

		LocalDate today = LocalDate.now();
		LocalDate birthday = ngaySinh.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		Period p = Period.between(birthday, today);

		if (p.getYears() >= 18)
			return true;

		return false;
	}

	public static boolean kiemTraTenXe(JTextField text) {

		String regex = "^\\D+";

		if (text.getText().matches(regex))
			return true;

		return false;
	}

	public static boolean kiemTraSoLuong(JTextField text) {

		String regex = "^[1-9]{1}(\\d*)$";

		if (text.getText().matches(regex))
			return true;

		return false;
	}

	public static boolean kiemTraGiaNhap(JTextField text) {

		String regex = "^[1-9]{1}(\\d*)$";

		if (text.getText().matches(regex))
			return true;

		return false;
	}

	public static boolean kiemTraSoKhung(JTextField text) {

		String regex = "^\\w{17}$";

		if (text.getText().matches(regex))
			return true;

		return false;
	}

	public static boolean kiemTraSoSuon(JTextField text) {

		String regex = "^[A-Za-z]{2}[-]\\d{6}$";

		if (text.getText().matches(regex))
			return true;

		return false;
	}

	public static boolean kiemTraHeSoBan(JTextField text) {

		String regex = "^(-)?\\d+?$";

		if (text.getText().matches(regex)) {
			return true;
		}

		return false;
	}

	public static boolean kiemTraBaoHanh(JTextField text) {

		String regex = "^[1-9]{1}(\\d*)$";

		if (text.getText().matches(regex))
			return true;

		return false;
	}

}

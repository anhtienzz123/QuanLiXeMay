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

		String regex = "^0\\d{9}$";

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

}

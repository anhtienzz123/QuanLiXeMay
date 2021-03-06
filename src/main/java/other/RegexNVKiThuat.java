package other;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class RegexNVKiThuat {

	public static final String TEN_NV = "Tên nhân viên không chứa số và kí tự đặc biệt";
	public static final String SO_DT = "Số điện thoại không hợp lệ";
	public static final String DIA_CHI = "Địa chỉ không hợp lệ";
	public static final String SO_NAM_KN = "Số năm kinh nghiệm không hợp lệ";
	public static final String NGAY_SINH = "Ngày sinh phải lớn hơn 18 tuổi";

	public static boolean ktraTenNV(JTextField text) {
		String regex = "\\D+";
		if (text.getText().matches(regex))
			return true;
		return false;
	}

	public static boolean ktraSDT(JTextField text) {
		String regex = ("(^(03)[2-9]\\d{7})|(^(07)[06-9]\\d{7})|(^(08)[1-5]\\d{7})|(^(056)\\d{7})|(^(058)\\d{7})|(^(059)\\d{7})|(^(09)[0-46-9]\\d{7})");
		if (text.getText().matches(regex))
			return true;
		return false;

	}

	public static boolean KtraDiaChi(JTextField text) {
		if (!text.getText().trim().equals(""))
			return true;
		return false;

	}

	public static boolean KtraSoNamKN(JTextField text) {
		try {
			int sonam = Integer.parseInt(text.getText().trim());
			if(sonam <= 0)
				return false;
		} catch (Exception e) {
			
			return false;
		}
		return true;
		
	}

	public static boolean ktraNgaySinh(JDateChooser ngaySinh) {
		LocalDate today = LocalDate.now();
		LocalDate birthday = ngaySinh.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		Period p = Period.between(birthday, today);

		if (p.getYears() >= 18)
			return true;
		return false;
	}

}

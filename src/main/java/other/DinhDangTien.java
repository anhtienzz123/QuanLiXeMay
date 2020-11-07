package other;

import java.text.NumberFormat;
import java.util.Locale;

public class DinhDangTien {

	public static String format(double tien) {
		Locale localeVN = new Locale("vi", "VN");
		NumberFormat vn = NumberFormat.getInstance(localeVN);
		String str_money = vn.format(tien);
		return str_money + " VNĐ";
	}
}

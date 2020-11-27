package other;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

import dao.KhachHangDao;

public class RandomThongTin {

	private RandomThongTin() {

	}

	public static String randomSoDienThoai() {

		KhachHangDao khachHangDao = KhachHangDao.getInstance();

		String result = "";

		// các đầu số điện thoại
		List<String> dauSos = Arrays.asList("086", "096", "097", "098", "032", "033", "034", "035", "036", "037", "038",
				"039", "088", "091", "094", "083", "084", "085", "081", "082", "089", "090", "093", "070", "079", "077",
				"076", "078", "092", "056", "058");

		Random random = new Random();

		do {
			String dauSo = dauSos.get(random.nextInt(dauSos.size()));
			result = dauSo + RandomStringUtils.randomNumeric(7);
		} while (!khachHangDao.kiemTraSoDienThoaiKhongTrung(result));

		return result;

	}

	// CMT gồm 9 chữ số hoặc 12 chữ số
	public static String randomSoCMT() {
		KhachHangDao khachHangDao = KhachHangDao.getInstance();
		Random random = new Random();
		// Chỉ random ra 2 số 0 và 1
		String result = "";

		do {
			int temp = random.nextInt(2);

			result = temp == 0 ? RandomStringUtils.randomNumeric(9) : RandomStringUtils.randomNumeric(12);
		} while (!khachHangDao.kiemTraSoCMTKhongTrung(result));

		return result;

	}

	public static String randomSoKhungXeMay() {
		Random random = new Random();
		List<String> quocGiaSanXuats = Arrays.asList("1", "4", "5", "2", "3", "J", "K", "S", "W", "Y");
		List<String> nhaSanXuats = Arrays.asList("A", "B", "G", "L", "N");

		StringBuffer result = new StringBuffer("");
		result.append(quocGiaSanXuats.get(random.nextInt(quocGiaSanXuats.size())));
		result.append(nhaSanXuats.get(random.nextInt(nhaSanXuats.size())));
		result.append(random.nextInt(10));
		result.append(RandomStringUtils.randomAlphabetic(2));
		result.append(RandomStringUtils.randomNumeric(2));
		result.append(RandomStringUtils.randomAlphabetic(1));
		result.append(RandomStringUtils.randomNumeric(9));

		return result.toString().toUpperCase();
	}

	public static String randomSoSuon() {

		String result = "VN-" + RandomStringUtils.randomNumeric(6);
		return result;
	}

	
}

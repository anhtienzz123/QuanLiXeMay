package other;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

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

	public static Date randomNgaySinh() {

		Random random = new Random();
		int namSinh = random.nextInt(21) + 1975;
		int thangSinh = random.nextInt(12) + 1;
		int ngaySinh = 1;

		if (thangSinh == 2)
			ngaySinh = random.nextInt(28) + 1;
		else if (thangSinh == 1 || thangSinh == 3 || thangSinh == 5 || thangSinh == 7 || thangSinh == 8
				|| thangSinh == 10 || thangSinh == 12)
			ngaySinh = random.nextInt(31) + 1;
		else
			ngaySinh = random.nextInt(30) + 1;

		String result = String.valueOf(ngaySinh) + "-" + String.valueOf(thangSinh) + "-" + String.valueOf(namSinh);
		Date nSinh = XuLyThoiGian.chuyenStringThanhDate(result);
		return nSinh;
	}

	public static final String randomHoTenConTrai() {

		Random random = new Random();

		List<String> hos = Arrays.asList("Nguyễn", "Nguyễn", "Nguyễn", "Nguyễn", "Nguyễn", "Nguyễn", "Trần", "Lê", "Lê",
				"Lê", "Phạm", "Phạm", "Phạm", "Huỳnh", "Huỳnh", "Huỳnh", "Huỳnh", "Phan", "Võ", "Đặng", "Bùi", "Đỗ",
				"Hồ", "Ngô", "Dương", "Lý");

		List<String> dems = Arrays.asList("Quốc", "Tuấn", "Thanh", "Thế", "Anh", "Mạnh", "Ngọc", "Trung", "Anh", "Anh",
				"Tấn", "Đông", "Nhật", "Đức", "Văn", "Xuân", "Quốc", "Hàng", "Mỹ", "Quang", "Thành", "Văn", "Đình");
		List<String> tens = Arrays.asList("An", "Ân", "Anh", "Bình", "Cường", "Đăng", "Đạt", "Đức", "Hải", "Hào",
				"Hiển", "Hoài", "Hoàng", "Hoang", "Hưng", "Huy", "Kha", "Khải", "Khang", "Khánh", "Lâm", "Liêm", "Linh",
				"Long", "Minh", "Nam", "Nghĩa", "Nghiêm", "Phong", "Phúc", "Phước", "Sơn", "Tài", "Tâm", "Thiện",
				"Thông", "Thọ", "Tuấn", "Thanh", "Khương", "Toàn", "Tôn", "Tồn", "Trọng", "Tú", "Vinh", "Vượng", "Tòng",
				"Giáp", "Đoàn", "Trường", "Duy", "Mạnh", "Ngọc");

		String ho = hos.get(random.nextInt(hos.size()));
		String dem = "";
		String ten = "";

		do {
			dem = dems.get(random.nextInt(dems.size()));
		} while (dem.equalsIgnoreCase(ho));

		do {
			ten = tens.get(random.nextInt(tens.size()));
		} while (ten.equalsIgnoreCase(ho) || ten.equalsIgnoreCase(dem));

		String result = ho + " " + dem + " " + ten;

		return result;
	}

	public static final String randomHoTenConGai() {

		Random random = new Random();

		List<String> hos = Arrays.asList("Nguyễn", "Nguyễn", "Nguyễn", "Nguyễn", "Nguyễn", "Nguyễn", "Trần", "Lê", "Lê",
				"Lê", "Phạm", "Phạm", "Phạm", "Huỳnh", "Huỳnh", "Huỳnh", "Huỳnh", "Phan", "Võ", "Đặng", "Bùi", "Đỗ",
				"Hồ", "Ngô", "Dương", "Lý");

		List<String> temp = Arrays.asList("Minh Anh", "Nguyệt Ánh", "Kim Chi", "Mỹ Duyên", "Mỹ Dung", "Ánh Dương",
				"Linh Đan", "Hải Đường", "Nhật Hạ", "Thanh Hà", "Đinh Hương", "Gia Hân", "Thanh Hà", "Ngọc Hoa",
				"Lan Hương", "Thiên Hà", "Ngân Tú", "Tuệ Lâm", "Mỹ Lệ", "Kim Ngân", "An Nhiên", "Thảo Nguyên",
				"Tuyết Nhung", "Nhã Phương", "Cát Tiên", "Anh Thư", "Thanh Tú", "Tú Vi", "Hạ Vũ", "Yến Nhi", "An Chi",
				"Hải Yến", "Thảo Phương", "Thanh Thúy", "Vân Khánh", "Bảo Ái", "Đa Quỳnh", "Tố Như", "Diệp Thảo",
				"Diệu Tú", "Mộc Miên", "Diệp Bích", "Hương Tràm", "An Diệp", "Thiên Kim", "Nhã Lan", "Mỹ Ngọc",
				"Hoài Phương", "Thảo Linh", "Quế Anh");

		List<String> dems = temp.stream().map(s -> s.split(" ")[0]).collect(Collectors.toList());
		List<String> tens = temp.stream().map(s -> s.split(" ")[1]).collect(Collectors.toList());

		String ho = hos.get(random.nextInt(hos.size()));
		String dem = "";
		String ten = "";

		do {
			dem = dems.get(random.nextInt(dems.size()));
		} while (dem.equalsIgnoreCase(ho));

		do {
			ten = tens.get(random.nextInt(tens.size()));
		} while (ten.equalsIgnoreCase(ho) || ten.equalsIgnoreCase(dem));

		String result = ho + " " + dem + " " + ten;

		return result;
	}

	public static final String randomDiaChi() {

		List<String> diaChis = new ArrayList<String>();

		String url = "data/diachi.txt";
		// Đọc dữ liệu từ File với Scanner
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(url);

			Scanner scanner = new Scanner(fileInputStream);

			try {
				while (scanner.hasNextLine()) {
					diaChis.add(scanner.nextLine());
				}
			} finally {
				try {
					scanner.close();
					fileInputStream.close();
				} catch (IOException ex) {

				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String result = diaChis.get(new Random().nextInt(diaChis.size()));

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

	public static void main(String[] args) {

		System.out.println(randomDiaChi());
	}

}

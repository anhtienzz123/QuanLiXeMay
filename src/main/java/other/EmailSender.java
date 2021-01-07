package other;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import dao.HopDongDao;
import entity.HopDong;

public class EmailSender {

	private static final String EMAIL = "testlaptrinhzz123@gmail.com";
	private static final String PASSWORD = "testlaptrinh123@";
	private static final String SUBJECT = "Thông báo bảo hành định kì";

	public static void main(String[] args) throws Exception {

		sendText("anhtienzz123@gmail.com", "Dsds");
		System.out.println("goi thanh cong");

	}

	public static void sendEmailThongBaoBaoHanhDinhKi() {

		try {
			// nếu đã gởi rồi thì thôi không gởi nữa
			if (checkDaGuiEmail()) {
				System.out.println("da goi email roio");
				return;
			}

		} catch (FileNotFoundException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HopDongDao hopDongDao = HopDongDao.getInstance();

		// lấy ngày hiện tại
		Calendar calendar = Calendar.getInstance();

		// 7 ngay sau
		calendar.add(Calendar.DAY_OF_MONTH, 7);

		@SuppressWarnings("deprecation")
		Date thoiGian = new Date(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
				calendar.get(Calendar.DAY_OF_MONTH));

		List<HopDong> hopDongs = hopDongDao.getHopDongs();

		for (HopDong hopDong : hopDongs) {
			// nếu hợp đồng nào có ngày trùng với bảo hành thì gởi email
			if (hopDong.isCheckBaoHanh(thoiGian))
				sendBaoHanh(hopDong);

		}

	}

	@SuppressWarnings("deprecation")
	public static boolean checkDaGuiEmail() throws ParseException, FileNotFoundException {

		boolean result = false;

		String file = "data/goiEmail.txt";

		Scanner scanner = new Scanner(new FileInputStream(file));

		String ngayDaGoi = "";

		while (scanner.hasNextLine()) {
			ngayDaGoi = scanner.nextLine();
			break;
		}

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date date = format.parse(ngayDaGoi);

		Calendar calendar = Calendar.getInstance();
		Date ngayHienTai = calendar.getTime();

		if (date.getDate() == ngayHienTai.getDate() & date.getMonth() == ngayHienTai.getMonth()
				&& date.getYear() == ngayHienTai.getYear()) {
			result = true;
		} else {

			PrintWriter writer = new PrintWriter(new FileOutputStream(file));
			writer.write(format.format(ngayHienTai));

			writer.close();
			result = false;
		}

		scanner.close();

		return result;

	}

	@SuppressWarnings("deprecation")
	public static void sendBaoHanh(HopDong hopDong) {

		String emailNguoiNhan = hopDong.getHoaDon().getKhachHang().getEmail();
		String tenKhachHang = hopDong.getHoaDon().getKhachHang().getHoTenKH();
		String maHopDong = hopDong.getMaHopDong();
		String ngayLapHopDong = XuLyThoiGian.chuyenDateThanhString(hopDong.getHoaDon().getNgayLap());
		String tenXeMay = hopDong.getXeMay().getTenXeMay() + "(" + hopDong.getXeMay().getSoKhung() + ")";

		Calendar calendar = Calendar.getInstance();

		calendar.add(Calendar.DAY_OF_MONTH, 7);

		Date date = calendar.getTime();

		int year = date.getYear() + 1900, month = date.getMonth() + 1;
		String ngayBaoHanh = date.getDate() + "-" + month + "-" + year;

		int dot = hopDong.checkDot(new Date(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
				calendar.get(Calendar.DAY_OF_MONTH)));

		String ngayBatDau = "";
		
		if(dot>1) {
			int x = dot -1;
			Date temp = hopDong.getThoiGianBaoHanhDinhKis().get(x);
			
			int month1 = temp.getMonth() + 1;
			
			ngayBatDau = temp.getDate() + "-" +month1 + "-" + temp.getYear();
		}else {
			
			int n1 = hopDong.getHoaDon().getNgayLap().getDate();
			int m1 = hopDong.getHoaDon().getNgayLap().getMonth() +1;
			int y1 = hopDong.getHoaDon().getNgayLap().getYear() + 1900;
			ngayBatDau = n1 + "-" +m1 + "-" + y1;
			
		}
		
		System.out.println("ngay bat dau: " + ngayBatDau);

		String noiDung = "Xin chào ông/bà: " + tenKhachHang + "\r\n" + "\r\n"
				+ "MotorCycle VietNam cảm ơn quý khách hàng đã tin tưởng và ủng hộ cửa hàng chúng tôi trong suốt thời gian qua.\r\n"
				+ "\r\n" + "Theo hợp đồng (Mã hợp đồng: " + maHopDong + ") đã lập ngày " + ngayLapHopDong
				+ " và chính sách bảo hành của cửa hàng, chúng tôi gửi gmail này đến quý khách để thông báo thời gian bảo hành xe máy của xe "
				+ tenXeMay + " sẽ bắt đầu từ ngày " + ngayBatDau + " đến ngày " + ngayBaoHanh + " đợt " + dot + "\r\n"
				+ "\r\n"
				+ "Một lần nữa MotorCycle VietNam xin chân thành cảm ơn tới quý khách hàng và mong sẽ tiếp tục nhận được sự ủng hộ quý khách trong thời gian tới.\r\n"
				+ "\r\n" + "Xin trân trọng cảm ơn!";

		try {
			sendText(emailNguoiNhan, noiDung);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void sendText(String emailNguoiNhan, String noiDung) throws AddressException, MessagingException {
		Properties mailServerProperties;
		Session getMailSession;
		MimeMessage mailMessage;

		// Step1: setup Mail Server
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");

		// Step2: get Mail Session
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		mailMessage = new MimeMessage(getMailSession);

		mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailNguoiNhan));

		mailMessage.setFrom(new InternetAddress(EMAIL));
		mailMessage.setSubject(SUBJECT);
		mailMessage.setText(noiDung);

		// Step3: Send mail
		Transport transport = getMailSession.getTransport("smtp");

		transport.connect("smtp.gmail.com", EMAIL, PASSWORD);
		transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
		transport.close();
	}

}

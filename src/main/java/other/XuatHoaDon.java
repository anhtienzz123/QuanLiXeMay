package other;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import customoutput.ChiTietHoaDonReport;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class XuatHoaDon {

	public static final String FILE_REPORT = "C:/Users/admin/Documents/Java/JavaCore/QuanLiXeMay/QuanLiXeMay/src/main/java/other/TemplateHoaDon.jrxml";

	public static void xuatHoaDon(HoaDon hoaDon) throws Exception {

		List<ChiTietHoaDonReport> listItems = new ArrayList<ChiTietHoaDonReport>();
		DecimalFormat df = new DecimalFormat("###.##");

		listItems = toChiTietHoaDonReports(hoaDon);
	

		JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(listItems);

		Map<String, Object> parameters = new HashMap<String, Object>();

		String maHoaDon = hoaDon.getMaHoaDon();
		
		
		String tenNguoiMua = hoaDon.getKhachHang().getHoTenKH();
		String soDienThoai = hoaDon.getKhachHang().getSoDienThoai();
		String diaChi = hoaDon.getKhachHang().getDiaChiKH();
		String tongTienBangSo = DinhDangTien.format(hoaDon.tinhTongTienHoaDon());

		String tongTienBangChu = DocSo.readNum(df.format(hoaDon.tinhTongTienHoaDon()));

		parameters.put("maHoaDon", maHoaDon);
		parameters.put("ngayLap", XuLyThoiGian.chuyenDateThanhString(hoaDon.getNgayLap()));
		
		parameters.put("tenNguoiMua", tenNguoiMua);
		parameters.put("soDienThoai", soDienThoai);
		parameters.put("diaChi", diaChi);

		parameters.put("chiTietHoaDons", itemsJRBean);
		parameters.put("tongTienBangSo", tongTienBangSo);
		parameters.put("tongTienBangChu", tongTienBangChu);

		InputStream input = new FileInputStream(FILE_REPORT);

		JasperDesign jasperDesign = JRXmlLoader.load(input);

		/* compiling jrxml with help of JasperReport class */
		JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

		/* Using jasperReport object to generate PDF */
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

		/* call jasper engine to display report in jasperviewer window */
		JasperViewer.viewReport(jasperPrint, false);
		

		System.out.println("File Generated");
	}
	
	public static List<ChiTietHoaDonReport> toChiTietHoaDonReports(HoaDon hoaDon){
		
		List<ChiTietHoaDonReport> chiTietHoaDonReports = new ArrayList<ChiTietHoaDonReport>();
		
		int i = 1;
		
		for (ChiTietHoaDon chiTietHoaDon : hoaDon.getChiTietHoaDons()) {
			
			int stt = i;
			String tenXeMay = chiTietHoaDon.getXeMay().getTenXeMay() +"\n" + chiTietHoaDon.getXeMay().getSoKhung();
			String giaBan = DinhDangTien.format(chiTietHoaDon.getGiaBan());
			String baoHanh = chiTietHoaDon.getXeMay().getThoiGianBaoHanh() + " tháng";
			
			ChiTietHoaDonReport chiTietHoaDonReport = new ChiTietHoaDonReport(stt, tenXeMay, giaBan, baoHanh);
			
			chiTietHoaDonReports.add(chiTietHoaDonReport);
		    i++;
			
		}
		
		return chiTietHoaDonReports;
	}

	

	
}

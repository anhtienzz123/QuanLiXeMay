package other;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.HoaDon;
import entity.Test;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
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

		List<Test> listItems = new ArrayList<Test>();

		Test test = new Test("1", "tien", "20", "13-04-2020");
		Test test1 = new Test("2", "tuan", "20", "13-04-2020");

		listItems.add(test);
		listItems.add(test1);

		JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(listItems);

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("duLieu", itemsJRBean);
		parameters.put("ngay", "13-04-2020");

		InputStream input = new FileInputStream(FILE_REPORT);

		JasperDesign jasperDesign = JRXmlLoader.load(input);

		/* compiling jrxml with help of JasperReport class */
		JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

		/* Using jasperReport object to generate PDF */
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

		/* call jasper engine to display report in jasperviewer window */
		JasperViewer.viewReport(jasperPrint);
		
		System.out.println("File Generated");
	}

	
	public static void main(String[] args) throws Exception {
		xuatHoaDon(null);
	}
	
	public static void test(List<Test> list) throws JRException {

		InputStream arq = XuatHoaDon.class.getResourceAsStream("/other/Blank_A4.jrxml");

		JasperReport report = JasperCompileManager.compileReport(arq);

		Map<String, Object> result = new HashMap<String, Object>();

		result.put("name", "13-04-2020");
		// JasperPrint print = JasperFillManager.fillReport(report, result, new
		// JRBeanCollectionDataSource(list));

		JasperPrint print = JasperFillManager.fillReport(report, result, new JREmptyDataSource());

		JasperViewer.viewReport(print, false);
	}
}

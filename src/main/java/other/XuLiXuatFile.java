package other;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigInteger;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;

import entity.ChiTietHoaDon;
import entity.HoaDon;

public class XuLiXuatFile {

	public static final String FILE = "C:/Users/admin/Desktop/Test";
	
	public void xuatHoaDonRaFileWord(HoaDon hoaDon) throws Exception {
		
		// Tạo document
		XWPFDocument document = new XWPFDocument();

		// Write the Document in file system
		FileOutputStream out = new FileOutputStream(new File(FILE, "create_table.docx"));

		// tạo title
		XWPFParagraph title = document.createParagraph();
		title.setAlignment(ParagraphAlignment.CENTER);
		
		XWPFRun titleRun = title.createRun();
		titleRun.setText("Hóa Đơn");
		titleRun.setBold(true);
		titleRun.setFontSize(30);
		
		// Thong tin hoa don
		// mã hóa đơn, ngày lập, tên nhân viên lập, tên khách hàng, số điện thoại
		
		 XWPFParagraph paragraph = document.createParagraph();
	     XWPFRun run = paragraph.createRun();
	     run.setText("Mã hóa đơn: " + hoaDon.getMaHoaDon()+ "\r\r\r\r\n" + "Ngày lập: " + hoaDon.getNgayLap());
	     
	     XWPFParagraph paragraph1 = document.createParagraph();
	     XWPFRun run1 = paragraph1.createRun();
	     run1.setText("Tên nhân viên lập: " + hoaDon.getNhanVienHanhChinh().getHoTenNV());
	     
	     XWPFParagraph paragraph2 = document.createParagraph();
	     XWPFRun run2 = paragraph2.createRun();
	     run2.setText("Tên khách hàng: " + hoaDon.getKhachHang().getHoTenKH() + "\r\r\r Số điện thoại: " + hoaDon.getKhachHang().getSoDienThoai());
		
		
		// Tạo table
		XWPFTable table = document.createTable();
		table.setCellMargins(100, 100, 100, 100);
		table.setWidth(50);

		// Tạo dòng tiêu đề
		XWPFTableRow tableRowOne = table.getRow(0);
	

		tableRowOne.getCell(0).setText("STT");
		tableRowOne.addNewTableCell().setText("Tên xe");
		tableRowOne.addNewTableCell().setText("Giá bán");
		tableRowOne.addNewTableCell().setText("Đơn vị tính");
		tableRowOne.addNewTableCell().setText("Tổng tiền");
		int count = 1;
		
		
		// Set size
		CTTblWidth width = table.getCTTbl().addNewTblPr().addNewTblW();
		width.setType(STTblWidth.DXA);
		width.setW(BigInteger.valueOf(9072));
		
		// Set border
		
		CTTblPr tblpro = table.getCTTbl().getTblPr();

		CTTblBorders borders = tblpro.addNewTblBorders();
		borders.addNewBottom().setVal(STBorder.SINGLE); 
		borders.addNewLeft().setVal(STBorder.SINGLE);
		borders.addNewRight().setVal(STBorder.SINGLE);
		borders.addNewTop().setVal(STBorder.SINGLE);
		//also inner borders
		borders.addNewInsideH().setVal(STBorder.SINGLE);
		borders.addNewInsideV().setVal(STBorder.SINGLE);
		

		
		for (ChiTietHoaDon chiTietHoaDon : hoaDon.getChiTietHoaDons()) {
			
			// create second row
			XWPFTableRow tableRow= table.createRow();
			tableRow.setHeight(50);
			tableRow.getCell(0).setText(count+"");
			tableRow.getCell(1).setText(chiTietHoaDon.getXeMay().getTenXeMay());
			tableRow.getCell(2).setText(chiTietHoaDon.getGiaBan() + "" );
			tableRow.getCell(3).setText("Chiếc");
			tableRow.getCell(4).setText(chiTietHoaDon.getGiaBan() + "");
			
			count++;
		}
		
	
	
		document.write(out);
		out.close();
		document.close();
		System.out.println("Xuất file word thành công");
		
	
	}
}

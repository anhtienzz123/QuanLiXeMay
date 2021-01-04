package other;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.text.DecimalFormat;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

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

//	public static final String FILE = "C:\\Users\\admin\\Documents\\Java\\JavaCore\\QuanLiXeMay\\QuanLiXeMay\\hoadon";
	public static final String FILE = "C:\\Users\\ASUS\\OneDrive\\Máy tính\\XuatHoaDon";

	

	public void xuatHoaDonRaFileWord1(HoaDon hoaDon) throws Exception {

		// Tạo document
		XWPFDocument document = new XWPFDocument();

		// Write the Document in file system
		FileOutputStream out = new FileOutputStream(new File(FILE, hoaDon.getMaHoaDon().trim() +".docx"));

		// tạo title
		XWPFParagraph title = document.createParagraph();
		title.setAlignment(ParagraphAlignment.CENTER);

		XWPFRun titleRun = title.createRun();
		titleRun.setText("Hóa Đơn bán hàng");
		titleRun.setBold(true);
		titleRun.setFontSize(30);

		// Thong tin hóa đơn

		XWPFParagraph paragraph1 = document.createParagraph();
		

		XWPFRun run12 = paragraph1.createRun();
		run12.setText("Mã hóa đơn: " + hoaDon.getMaHoaDon());
		run12.addBreak();
		XWPFRun run13 = paragraph1.createRun();
		run13.setText("Ngày lập hóa đơn: "+ XuLyThoiGian.chuyenDateThanhString(hoaDon.getNgayLap()));
		run13.addBreak();
		XWPFRun run14 = paragraph1.createRun();
		run14.setText("Mã nhân viên: " + hoaDon.getNhanVienHanhChinh().getMaNVHanhChinh() );
		run14.addBreak();
		XWPFRun run15 = paragraph1.createRun();
		run15.setText("Tên nhân viên: " + hoaDon.getNhanVienHanhChinh().getHoTenNV());

		XWPFParagraph paragraph2 = document.createParagraph();
		XWPFRun run2 = paragraph2.createRun();
		run2.setText("Tên khách hàng: " + hoaDon.getKhachHang().getHoTenKH());
		run2.addBreak();
		XWPFRun run3 = paragraph2.createRun();
		run3.setText("Số điện thoại: " + hoaDon.getKhachHang().getSoDienThoai());

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
		tableRowOne.addNewTableCell().setText("Thuế");
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
		// also inner borders
		borders.addNewInsideH().setVal(STBorder.SINGLE);
		borders.addNewInsideV().setVal(STBorder.SINGLE);

		for (ChiTietHoaDon chiTietHoaDon : hoaDon.getChiTietHoaDons()) {

			// create second row
			XWPFTableRow tableRow = table.createRow();
			tableRow.setHeight(50);
			tableRow.getCell(0).setText(count + "");
			tableRow.getCell(1)
					.setText(chiTietHoaDon.getXeMay().getTenXeMay() + "\\" + chiTietHoaDon.getXeMay().getSoKhung());
			tableRow.getCell(2).setText(DinhDangTien.format(chiTietHoaDon.getXeMay().tinhGiaBan())) ;
			tableRow.getCell(3).setText("Chiếc");
			tableRow.getCell(4).setText(DinhDangTien.format(chiTietHoaDon.getXeMay().tinhThue() ));
			tableRow.getCell(5).setText(DinhDangTien.format(chiTietHoaDon.getGiaBan() ));

			count++;
		}
		
		XWPFParagraph paragraph3 = document.createParagraph();
		paragraph3.setAlignment(ParagraphAlignment.RIGHT);
		XWPFRun run31 = paragraph3.createRun();
		run31.setText("Tổng tiền: " + DinhDangTien.format(hoaDon.tinhTongTienHoaDon()));
		run31.addBreak();
		XWPFRun run32 = paragraph3.createRun();
		DecimalFormat df = new DecimalFormat("###.##");
		run32.setText("Bằng chữ: " + DocSo.readNum(df.format(hoaDon.tinhTongTienHoaDon())) +"đồng");

		document.write(out);
		out.close();
		document.close();
		System.out.println("Xuất file word thành công");

	}

	public static byte[] hexToBytes(String hexString) {
		HexBinaryAdapter adapter = new HexBinaryAdapter();
		byte[] bytes = adapter.unmarshal(hexString);
		return bytes;
	}

}

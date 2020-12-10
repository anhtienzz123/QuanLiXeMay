package other;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constant.TenEntity;
import dao.DongXeDao;
import dao.HangXeDao;
import dao.LoaiXeDao;
import dao.XuatXuDao;
import entity.DongXe;
import entity.HangXe;
import entity.LoaiXe;
import entity.XeMay;
import entity.XuatXu;

public class ImportExcelFile {
	public static final int COLUMN_MAXE = 0;
	public static final int COLUMN_TENXE = 1;
	public static final int COLUMN_GIANHAP = 2;
	public static final int COLUMN_HESOBAN = 3;
	public static final int COLUMN_BAOHANH = 4;
	public static final int COLUMN_SOKHUNG = 5;
	public static final int COLUMN_SOSUON = 6;
	public static final int COLUMN_PHANKHOI = 7;
	public static final int COLUMN_MAUXE = 8;
	public static final int COLUMN_LOAIXE = 9;
	public static final int COLUMN_HANGXE = 10;
	public static final int COLUMN_DONGXE = 11;
	public static final int COLUMN_XUATXU = 12;
	public static final int COLUMN_MOTA = 13;
	private static HangXe hangXe;

	public static void main(String[] args) throws IOException {
		final String excelFilePath = "Img\\demo.xlsx";
		final List<XeMay> listXeMay = readExcel(excelFilePath);
		for (XeMay xeMay : listXeMay) {
			System.out.println(xeMay);
		}
	}

	public static List<XeMay> readExcel(String excelFilePath) throws IOException {
		List<XeMay> listXeMay = new ArrayList<>();

		// Get file
		InputStream inputStream = new FileInputStream(new File(excelFilePath));

		// Get workbook
		Workbook workbook = getWorkbook(inputStream, excelFilePath);

		// Get sheet
		Sheet sheet = workbook.getSheetAt(0);

		// Get all rows
		Iterator<Row> iterator = sheet.iterator();
		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			if (nextRow.getRowNum() == 0) {
				// Ignore header
				continue;
			}

			// Get all cells
			Iterator<Cell> cellIterator = nextRow.cellIterator();

			// Read cells and set value for book object
			XeMay xeMay = new XeMay();
//			xeMay.setMaXeMay(RandomMa.getMaNgauNhien(TenEntity.XE_MAY).trim());
			xeMay.setSoLuong(1);
			while (cellIterator.hasNext()) {
				// Read cell
				Cell cell = cellIterator.next();
				Object cellValue = getCellValue(cell);
				if (cellValue == null || cellValue.toString().isEmpty()) {
					continue;
				}
				// Set value for book object
//                String columnIndex = cell.getStringCellValue();
				int columnIndex = cell.getColumnIndex();

				switch (columnIndex) {
				case COLUMN_MAXE:
					xeMay.setMaXeMay(getCellValue(cell).toString().trim());
					break;
				case COLUMN_TENXE:
					xeMay.setTenXeMay(getCellValue(cell).toString().trim());
					break;
				case COLUMN_GIANHAP:
					xeMay.setGiaNhap((double) getCellValue(cell));
					break;
				case COLUMN_HESOBAN:
					xeMay.setHeSoBan((double) getCellValue(cell));
					break;
				case COLUMN_BAOHANH:
					double baoHanh = (double) getCellValue(cell);
					xeMay.setThoiGianBaoHanh((int) Math.round(baoHanh));
					break;
				case COLUMN_SOKHUNG:
					xeMay.setSoKhung(getCellValue(cell).toString().trim());
					break;
				case COLUMN_SOSUON:
					xeMay.setSoSuon(getCellValue(cell).toString().trim());
					break;
				case COLUMN_PHANKHOI:
					double phanKhoi = (double) getCellValue(cell);
					xeMay.setSoPhanKhoi((int) Math.round(phanKhoi));
					break;
				case COLUMN_MAUXE:
					xeMay.setMauXe(getCellValue(cell).toString().trim());
					break;
				case COLUMN_LOAIXE:
					LoaiXe loaiXe = LoaiXeDao.getInstance().getLoaiXeTheoTen(getCellValue(cell).toString().trim());
					if(loaiXe == null) {
						loaiXe = new LoaiXe();
						loaiXe.setMaLoaiXe(RandomMa.getMaNgauNhien(TenEntity.LOAI_XE));
						loaiXe.setTenLoaiXe(getCellValue(cell).toString().trim());
						
						LoaiXeDao.getInstance().themLoaiXe(loaiXe);
					}
					xeMay.setLoaiXe(loaiXe);
					break;
					
				case COLUMN_HANGXE:
					hangXe = HangXeDao.getInstance().getHangXeTheoTen(getCellValue(cell).toString().trim());
					if(hangXe == null) {
						hangXe = new HangXe();
						hangXe.setMaHangXe(RandomMa.getMaNgauNhien(TenEntity.HANG_XE));
						hangXe.setTenHangXe(getCellValue(cell).toString().trim());
						
						HangXeDao.getInstance().themHangXe(hangXe);
					}
					break;
				case COLUMN_DONGXE:
					DongXe dongXe = DongXeDao.getInstance().getDongXeTheoTen(getCellValue(cell).toString().trim());
					if(dongXe == null) {
						dongXe = new DongXe();
						dongXe.setMaDongXe(RandomMa.getMaNgauNhien(TenEntity.DONG_XE));
						dongXe.setTenDongXe(getCellValue(cell).toString().trim());
						dongXe.setThue(5);
						dongXe.setHangXe(hangXe);
						
						DongXeDao.getInstance().themDongXe(dongXe);
					}
					xeMay.setDongXe(dongXe);
					break;
				case COLUMN_XUATXU:
					XuatXu xuatXu = XuatXuDao.getInstance().getXuatXuTheoTen(getCellValue(cell).toString().trim());
					if(xuatXu == null) {
						xuatXu = new XuatXu();
						xuatXu.setMaXuatXu(RandomMa.getMaNgauNhien(TenEntity.XUAT_XU));
						xuatXu.setTenXuatXu(getCellValue(cell).toString().trim());
						XuatXuDao.getInstance().themXuatXu(xuatXu);
					}
					xeMay.setXuatXu(xuatXu);
					break;
				case COLUMN_MOTA:
					xeMay.setMoTa(getCellValue(cell).toString().trim());
					break;
				default:
					break;
				}

			}
			listXeMay.add(xeMay);
		}

		workbook.close();
		inputStream.close();

		return listXeMay;
	}

	// Get Workbook
	private static Workbook getWorkbook(InputStream inputStream, String excelFilePath) throws IOException {
		Workbook workbook = null;
		if (excelFilePath.endsWith("xlsx")) {
			workbook = new XSSFWorkbook(inputStream);
		} else if (excelFilePath.endsWith("xls")) {
			workbook = new HSSFWorkbook(inputStream);
		} else {
			throw new IllegalArgumentException("The specified file is not Excel file");
		}

		return workbook;
	}

	// Get cell value
	private static Object getCellValue(Cell cell) {
		CellType cellType = cell.getCellTypeEnum();
		Object cellValue = null;
		switch (cellType) {
		case BOOLEAN:
			cellValue = cell.getBooleanCellValue();
			break;
		case FORMULA:
			Workbook workbook = cell.getSheet().getWorkbook();
			FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
			cellValue = evaluator.evaluate(cell).getNumberValue();
			break;
		case NUMERIC:
			cellValue = cell.getNumericCellValue();
			break;
		case STRING:
			cellValue = cell.getStringCellValue();
			break;
		case _NONE:
		case BLANK:
		case ERROR:
			break;
		default:
			break;
		}

		return cellValue;
	}
}
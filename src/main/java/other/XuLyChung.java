package other;

import java.util.List;

public class XuLyChung {

	public static String[] doiListThanhArray(List<String> listString) {
		int size = listString.size();

		String[] arrays = new String[size + 1];
		arrays[0] = "Tất cả";

		for (int i = 0; i < listString.size(); i++) {
			arrays[i + 1] = listString.get(i);
		}

		return arrays;
	}

	public static String[] doiListThanhArrayThemXe(List<String> listString) {
		int size = listString.size();

		String[] arrays = new String[size + 1];

		for (int i = 0; i < listString.size(); i++) {
			arrays[i] = listString.get(i);
		}

		return arrays;
	}

	public static String xuLyCauSqlPhanTrang(String sql, int from, int to) {
		String result = "SELECT * FROM (" + sql + ")as a where a.row between " + from + " and " + to;

		return result;
	}

//	Copy file
//	public static void copyFile(String from, String to) {
//		Path src = Paths.get(from);
//		Path dest = Paths.get(to);
//		try {
//			Files.copy(src.toFile(), dest.toFile());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}

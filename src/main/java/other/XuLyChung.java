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
}

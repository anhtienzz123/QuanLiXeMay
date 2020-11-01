package other;

import java.util.Random;

public class RandomMa {

	private RandomMa() {

	}

	public static String getMaNgauNhien(String tienTo) {
		Random random = new Random();
		return tienTo + String.valueOf(random.nextInt((999999 - 100000) + 1) + 100000);
	}

}

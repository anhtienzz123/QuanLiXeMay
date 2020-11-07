package ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TestCardLayout {
	public static void main(String[] args) {
		taoMa().forEach(s->{
			System.out.println(s);
		});
		
	}
	public static List<Integer> taoMa() {
		List<Integer> lst = new ArrayList<Integer>(Arrays.asList(0,1,2,3,4));
		List<Integer> lst2 = new ArrayList<Integer>();
		int ma;
		do {
			Random random = new Random();
			ma = random.nextInt(6);
			lst2.add(ma);
		}while(lst.contains(ma));
		return lst2;
	}
	

}

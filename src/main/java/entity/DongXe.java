package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DongXe {

	private String maDongXe;
	private String tenDongXe;
	private HangXe hangXe;
	
	
	public DongXe(String maDongXe, String tenDongXe) {
		super();
		this.maDongXe = maDongXe;
		this.tenDongXe = tenDongXe;
	}
	
	
}

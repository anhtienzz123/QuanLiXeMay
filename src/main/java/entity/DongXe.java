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
	private double thue;
	private HangXe hangXe;

}

package entity;

public class Test {

	
	private String id;
	private String name;
	private String age;
	private String ngayLapHoaDon;
	
	public Test() {
		// TODO Auto-generated constructor stub
	}
	
	public Test(String id, String name, String age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	


	public Test(String id, String name, String age, String ngayLapHoaDon) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.ngayLapHoaDon = ngayLapHoaDon;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getNgayLapHoaDon() {
		return ngayLapHoaDon;
	}

	public void setNgayLapHoaDon(String ngayLapHoaDon) {
		this.ngayLapHoaDon = ngayLapHoaDon;
	}
	
	
}

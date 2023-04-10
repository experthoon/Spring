package spring.di.ex3;

public class SawonData {
	private String sawonname;
	private int pay;
	private String ipsady;
	
	
	public SawonData() {
		
	}
	
	//사원명은 생성자 주입 명시적 생성자 그러면 디폴트 생성자가 없는 것과 마찬가지
	public SawonData(String name) {
		sawonname = name;
	}

	//급여, 입사일은 setter 주입
	
	public String getSawonname() {
		return sawonname;
	}

	public void setSawonname(String sawonname) {
		this.sawonname = sawonname;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public String getIpsady() {
		return ipsady;
	}

	public void setIpsady(String ipsady) {
		this.ipsady = ipsady;
	}
	
	
	
}

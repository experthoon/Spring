package spring.di.ex3;

public class SawonData {
	private String sawonname;
	private int pay;
	private String ipsady;
	
	
	public SawonData() {
		
	}
	
	//������� ������ ���� ����� ������ �׷��� ����Ʈ �����ڰ� ���� �Ͱ� ��������
	public SawonData(String name) {
		sawonname = name;
	}

	//�޿�, �Ի����� setter ����
	
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

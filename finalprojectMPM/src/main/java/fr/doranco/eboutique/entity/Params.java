package fr.doranco.eboutique.entity;

public class Params {

	private Integer id;
	
	private byte[] cleCryptagePwd;
	
	private byte[] cleCryptageCp;
	
	
	public Params() {
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public byte[] getCleCryptagePwd() {
		return cleCryptagePwd;
	}

	public void setCleCryptagePwd(byte[] cleCryptagePwd) {
		this.cleCryptagePwd = cleCryptagePwd;
	}

	public byte[] getCleCryptageCp() {
		return cleCryptageCp;
	}

	public void setCleCryptageCp(byte[] cleCryptageCp) {
		this.cleCryptageCp = cleCryptageCp;
	}

	@Override
	public String toString() {
		return "Params [id=" + id + ", cleCryptagePwd=" + cleCryptagePwd + ", cleCryptageCp=" + cleCryptageCp + "]";
	}

}

package fr.doranco.eboutique.entity;




public class Params {
	private Integer id;
	private String cle_cryptage_pwd;
	private String cle_cryptage_cp;
	public Params() {
		// TODO Auto-generated constructor stub
	}
	public Params(Integer id, String cle_cryptage_pwd, String cle_cryptage_cp) {
		this.id = id;
		this.cle_cryptage_pwd = cle_cryptage_pwd;
		this.cle_cryptage_cp = cle_cryptage_cp;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCle_cryptage_pwd() {
		return cle_cryptage_pwd;
	}
	public void setCle_cryptage_pwd(String cle_cryptage_pwd) {
		this.cle_cryptage_pwd = cle_cryptage_pwd;
	}
	public String getCle_cryptage_cp() {
		return cle_cryptage_cp;
	}
	public void setCle_cryptage_cp(String cle_cryptage_cp) {
		this.cle_cryptage_cp = cle_cryptage_cp;
	}
	@Override
	public String toString() {
		return "Params [id=" + id + ", cle_cryptage_pwd=" + cle_cryptage_pwd + ", cle_cryptage_cp=" + cle_cryptage_cp
				+ "]";
	}
	
	
}

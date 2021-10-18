package fr.doranco.eboutique.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotEmpty;

public class Params {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	@Lob
	@Column(name = "cle_cryptage_pwd", columnDefinition="bytea", nullable = false)
	private Byte[] cle_cryptage_pwd;
	
	@NotEmpty
	@Lob
	@Column(name = "cle_cryptage_cp", columnDefinition="bytea", nullable = false)
	private Byte[] cle_cryptage_cp;
	
	
	public Params() {
		// TODO Auto-generated constructor stub
	}
	public Params(Integer id, Byte[] cle_cryptage_pwd, Byte[] cle_cryptage_cp) {
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
	public Byte[] getCle_cryptage_pwd() {
		return cle_cryptage_pwd;
	}
	public void setCle_cryptage_pwd(Byte[] cle_cryptage_pwd) {
		this.cle_cryptage_pwd = cle_cryptage_pwd;
	}
	public Byte[] getCle_cryptage_cp() {
		return cle_cryptage_cp;
	}
	public void setCle_cryptage_cp(Byte[] cle_cryptage_cp) {
		this.cle_cryptage_cp = cle_cryptage_cp;
	}
	@Override
	public String toString() {
		return "Params [id=" + id + ", cle_cryptage_pwd=" + cle_cryptage_pwd + ", cle_cryptage_cp=" + cle_cryptage_cp
				+ "]";
	}
	
	
}

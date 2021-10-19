package fr.doranco.eboutique.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "params")
public class Params {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Column(name = "cle_cryptage_pwd", nullable = false)
	private Byte[] cle_cryptage_pwd;
	
	@NotNull
	@Column(name = "cle_cryptage_cp", nullable = false)
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

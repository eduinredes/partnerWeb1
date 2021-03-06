// default package
// Generated 05/08/2015 12:11:46 PM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Centoper generated by hbm2java
 */
@Entity
@Table(name = "centoper", catalog = "partnerWeb")
public class Centoper implements java.io.Serializable {

	private String code;
	private String cdes;

	public Centoper() {
	}

	public Centoper(String code) {
		this.code = code;
	}

	public Centoper(String code, String cdes) {
		this.code = code;
		this.cdes = cdes;
	}

	@Id

	@Column(name = "code", unique = true, nullable = false, length = 6)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "cdes", length = 70)
	public String getCdes() {
		return this.cdes;
	}

	public void setCdes(String cdes) {
		this.cdes = cdes;
	}

}

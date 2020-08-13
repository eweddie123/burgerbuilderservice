package burgerbuilder.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer addressId;
	
	@NotNull
    @Column(name = "country")
	private String country;
	
	@NotNull
    @Column(name = "street")
	private String street;
	
	@NotNull
    @Column(name = "zipcode")
	private String zipcode;
	
	public Integer getAddressId() {
		return this.addressId;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getCountry() {
		return this.country;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getStreet() {
		return this.street;
	}
	
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	public String getZipcode() {
		return this.zipcode;
	}
}

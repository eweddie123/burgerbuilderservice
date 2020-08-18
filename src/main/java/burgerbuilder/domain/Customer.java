package burgerbuilder.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Customer {
	@Id
  	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer customerId;
	
	@NotNull
    @Column(name = "email")
	private String email;
	
	@NotNull
    @Column(name = "name")
	private String name;
	
	@NotNull
    @Column(name = "country")
	private String country;
	
	@NotNull
    @Column(name = "street")
	private String street;
	
	@NotNull
    @Column(name = "zipcode")
	private String zipcode;
	
	public Integer getCustomerId() {
		return this.customerId;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
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

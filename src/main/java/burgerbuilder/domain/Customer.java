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
    @Column(name = "address")
	private Integer address;
	
	@NotNull
    @Column(name = "email")
	private String email;
	
	@NotNull
    @Column(name = "name")
	private String name;
	
	public Integer getCustomerId() {
		return this.customerId;
	}
	
	public void setAddress(Integer address) {
		this.address = address;
	}
	
	public Integer getAddress() {
		return this.address;
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
}

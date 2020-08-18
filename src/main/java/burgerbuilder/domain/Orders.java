package burgerbuilder.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Orders {
	@Id
  	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer ordersId;
	
	@NotNull
    @Column(name = "price")
	private Double price;
	
	@NotNull
    @Column(name = "customer")
	private Integer customer;
	
	@NotNull
    @Column(name = "deliveryMethod")
	private String deliveryMethod;
	
	@NotNull
    @Column(name = "salad")
	private Integer salad;
	
	@NotNull
    @Column(name = "bacon")
	private Integer bacon;
	
	@NotNull
    @Column(name = "meat")
	private Integer meat;
	
	@NotNull
    @Column(name = "cheese")
	private Integer cheese;
	
	public Integer getOrdersId() {
		return ordersId;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setCustomer(Integer customer) {
		this.customer = customer;
	}
	
	public Integer getCustomer() {
		return customer;
	}
	
	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}
	
	public String getDeliveryMethod() {
		return this.deliveryMethod;
	}
	
	public void setSalad(Integer salad) {
		this.salad = salad;
	}
	
	public Integer getSalad() {
		return this.salad;
	}
	
	public void setBacon(Integer bacon) {
		this.bacon = bacon;
	}
	
	public Integer getBacon() {
		return this.bacon;
	}
	
	public void setMeat(Integer meat) {
		this.meat = meat;
	}
	
	public Integer getMeat() {
		return this.meat;
	}
	
	public void setCheese(Integer cheese) {
		this.cheese = cheese;
	}
	
	public Integer getCheese() {
		return this.cheese;
	}
}

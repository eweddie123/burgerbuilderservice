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
    @Column(name = "ingredients")
	private Integer ingredients;
	
	@NotNull
    @Column(name = "price")
	private Integer price;
	
	@NotNull
    @Column(name = "customer")
	private Integer customer;
	
	@NotNull
    @Column(name = "deliveryMethod")
	private String deliveryMethod;
	
	public Integer getOrdersId() {
		return ordersId;
	}
	
	public void setIngredients(Integer ingredients) {
		this.ingredients = ingredients;
	}
	
	public Integer getIngredients() {
		return ingredients;
	}
	
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	public Integer getPrice() {
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
}

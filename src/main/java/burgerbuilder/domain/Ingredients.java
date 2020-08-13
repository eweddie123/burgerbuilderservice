package burgerbuilder.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Ingredients {
	@Id
  	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer ingredientsId;
	
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
	
	public Integer getIngredientsId() {
		return this.ingredientsId;
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

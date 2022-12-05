package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BOOKS")
public class BookStore {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String b_name;
	@Column
	private String A_name;
	@Column
	private String description;
	@Column
	private String genre;
	@Column
	private float price;
	@Column
	private int Quantity;
	public BookStore() {
		super();
		
	}
	public BookStore(String b_name, String a_name, String description, String genre, float price, int quantity) {
		super();
		this.b_name = b_name;
		A_name = a_name;
		this.description = description;
		this.genre = genre;
		this.price = price;
		Quantity = quantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getA_name() {
		return A_name;
	}
	public void setA_name(String a_name) {
		A_name = a_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	@Override
	public String toString() {
		return "BookStore [id=" + id + ", b_name=" + b_name + ", A_name=" + A_name + ", description=" + description
				+ ", genre=" + genre + ", price=" + price + ", Quantity=" + Quantity + "]";
	}
	
}
	
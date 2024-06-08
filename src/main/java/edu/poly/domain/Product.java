package edu.poly.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Products")
public class Product implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	private String name;
	private int quantity;
	private double price;
	private double weight;
	private String image;
	private String description;
	private double discount;
	private Date createDate;
	private boolean stock; // còn hàng hay không
	@ManyToOne
	@JoinColumn(name = "categoryId")
	Category category;
	@OneToMany(mappedBy = "product")
	List<OrderDetail> orderDetails;
	@OneToMany(mappedBy = "product")
	private List<CartItem> cartItems;
}

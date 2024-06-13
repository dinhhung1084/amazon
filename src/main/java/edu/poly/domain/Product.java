package edu.poly.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
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
	@NotNull
	private String name;
	private int quantity;
	private double price;
	private double weight;
	private String image;
	private String description;
	private double discount;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date createDate;
	private boolean stock;
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;
	@OneToMany(mappedBy = "product")
	List<OrderDetail> orderDetails;
	@OneToMany(mappedBy = "product")
	private List<CartItem> cartItems;

}

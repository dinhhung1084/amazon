package edu.poly.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
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
	private int categoryId;
}

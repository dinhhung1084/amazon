package edu.poly.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
	private int productId;
	@NotNull
	private String name;
	private int quantity;
	private double price;
	private double weight;
	private String image;
	//
	private MultipartFile imgFile;
	private String description;
	private double discount;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date createDate;
	private boolean stock;
	private int categoryId;

}

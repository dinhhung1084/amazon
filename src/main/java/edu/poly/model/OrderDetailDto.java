package edu.poly.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDto {
	private int orderDetailId;
	private int quantity;
	private double price;
	private int productId;
	private int orderId;
}

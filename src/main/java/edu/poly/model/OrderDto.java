package edu.poly.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
	private int orderId;
	private Date orderDate;
	private double amount;
	private short status;
	private int customerId;

}

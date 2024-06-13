package edu.poly.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
	private int orderId;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date orderDate;
	private double amount;
	private short status;
	private int customerId;
	private boolean isActivated;
}

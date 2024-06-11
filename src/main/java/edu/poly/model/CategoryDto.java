package edu.poly.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
	private Integer categoryId;
	private String name;
	private String description;
	private Boolean isEdit = false;
}

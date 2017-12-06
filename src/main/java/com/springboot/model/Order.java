package com.springboot.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
/**
 * 
 * @author zhouxm
 *
 */
@Entity
@Table(name = "t_order")
public class Order {
	@Id@Setter@Getter
	private Long orderId;
	
	@Setter@Getter
	private Long userId;

}

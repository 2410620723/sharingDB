package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dao.OrderRepository;
import com.springboot.model.Order;
/**
 * 
 * @author zhouxm
 *
 */
@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> queryOrdersByOrderId(Long orderId){
		return orderRepository.queryOrdersByOrderId(orderId);
	}
	
	public Integer deleteByOrderId(Long orderId){
		return orderRepository.deleteByOrderId(orderId);
	}

	public Integer updateByOrderId(Long orderId, Long userId){
		return orderRepository.updateByOrderId(orderId, userId);
	}
}

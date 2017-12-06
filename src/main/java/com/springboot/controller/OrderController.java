package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dangdang.ddframe.rdb.sharding.id.generator.IdGenerator;
import com.springboot.dao.OrderRepository;
import com.springboot.model.Order;
import com.springboot.service.OrderService;

/**
 * 
 * @author zhouxm
 *
 */
@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private IdGenerator idGenerator;
	
	@PostMapping("/add")
	public String add(){
		/*for (int i = 0; i < 10; i++) {
			Order order = new Order();
			order.setUserId((long) i);
			order.setOrderId((long) i);
			orderRepository.save(order);
		}
		for (int i = 10; i < 20; i++) {
            Order order = new Order();
            order.setUserId((long) i + 1);
            order.setOrderId((long) i);
            orderRepository.save(order);
        }*/
		Order order = new Order();
        order.setUserId(idGenerator.generateId().longValue());
        order.setOrderId(idGenerator.generateId().longValue());
        orderRepository.save(order);
		return "success";
	}
	@RequestMapping("/query")
    private Object queryAll() {
        return orderRepository.findAll();
    }
	
	@GetMapping("/query/{orderId}")
	private List<Order> queryByOrderId(@PathVariable Long orderId){
		return orderService.queryOrdersByOrderId(orderId);
	}
	
	@DeleteMapping("/delete/{orderId}")
	private String deleteByOrderId(@PathVariable Long orderId){
		Integer count = orderService.deleteByOrderId(orderId);
		return count > 0 ? "success" : "error";
	}
	
	@PutMapping("/put/{orderId}/{userId}")
	public String updateByOrderId(@PathVariable Long orderId, @PathVariable Long userId){
		Integer count = orderService.updateByOrderId(orderId, userId);
		return count > 0 ? "success" : "error";
	}

}

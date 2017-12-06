package com.springboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.model.Order;
/**
 * 
 * @author zhouxm
 *
 */
public interface OrderRepository extends CrudRepository<Order, Long> {
	/**
	 * 根据orderId查找order信息
	 * @param orderId
	 * @return
	 */
	@Query("select o from Order o where orderId = :orderId")
	public List<Order> queryOrdersByOrderId(@Param(value = "orderId") Long orderId);
	
	/**
	 * 根据orderId 删除order信息
	 * @param orderId
	 * @return
	 */
	@Modifying
	@Transactional(rollbackFor = Exception.class)
	@Query("delete from Order o where o.orderId = :orderId")
	public Integer deleteByOrderId(@Param(value = "orderId") Long orderId);
	
	/**
	 * 根据用户orderId更新用户userId
	 * @param orderId
	 * @param userId
	 * @return
	 */
	@Modifying
	@Transactional(rollbackFor = Exception.class)
	@Query("update Order set userId = :userId where orderId = :orderId")
	public Integer updateByOrderId(@Param(value = "orderId") Long orderId, @Param(value = "userId") Long userId);
}

package com.gopi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gopi.entity.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem , Long>{

}

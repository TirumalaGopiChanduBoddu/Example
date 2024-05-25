package com.gopi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gopi.entity.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order , Long>{

}

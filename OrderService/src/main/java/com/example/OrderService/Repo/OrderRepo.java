package com.example.OrderService.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.OrderService.Entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order , Long> {

}

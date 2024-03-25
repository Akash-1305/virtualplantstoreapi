package com.example.VirtualPlantStore.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.VirtualPlantStore.Entity.Orders;
import com.example.VirtualPlantStore.Entity.User;

public interface OrdersRepo extends JpaRepository<Orders, String> {

	List<Orders> findByUser(User user);
}

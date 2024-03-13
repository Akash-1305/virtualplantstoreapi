package com.example.VirtualPlantStore.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.VirtualPlantStore.Entity.Cart;
import com.example.VirtualPlantStore.Entity.Product;
import com.example.VirtualPlantStore.Entity.User;

public interface CartRepo extends JpaRepository<Cart, Integer>{
	Optional<Cart> findByUserAndProduct(User user, Product product); 
	
	List<Cart> findByUser(User users);
	
	@Override
	void deleteAll(Iterable<? extends Cart> entities);
}

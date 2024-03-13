package com.example.VirtualPlantStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.VirtualPlantStore.Entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}

package com.example.VirtualPlantStore.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.VirtualPlantStore.Entity.Admin;

public interface AdminRepo extends JpaRepository<Admin,Integer>{
	
	Optional<Admin> findByEmail(String email);
	boolean existsByEmail(String email);
	boolean existsByMobile (String mobile);
	
}

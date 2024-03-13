package com.example.VirtualPlantStore.Repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.VirtualPlantStore.Entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
	Optional<User> findByEmail(String email);
	boolean existsByEmail(String email);
	boolean existsByMobile (String mobile);

}

package co.grandcircus.tasklist.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.tasklist.entity.User;

public interface UserDao extends JpaRepository<User, Long> {
		
		
		User findByEmail(String email);
		

}
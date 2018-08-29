package co.grandcircus.tasklist.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.tasklist.entity.Task;
import co.grandcircus.tasklist.entity.User;

public interface TaskDao extends JpaRepository<Task, Long> {

	List<Task> findByUser(User user);
	
}
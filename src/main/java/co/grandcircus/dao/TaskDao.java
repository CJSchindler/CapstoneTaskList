package co.grandcircus.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.entity.Task;

public interface TaskDao extends JpaRepository<Task, Long> {


}
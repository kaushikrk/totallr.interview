package com.interview.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.interview.model.*;

public interface TaskRepo extends JpaRepository<Task,Integer>{
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Task c set c.name = :name WHERE c.id = :id")
    void setCustomerName(@Param("id") int id, @Param("name") String name);
}

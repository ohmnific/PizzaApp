package com.pizzahut.repository;

import com.pizzahut.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza,Integer> {
    @Query(value = "SELECT pizza_id FROM orders WHERE user_id=:id", nativeQuery = true)
    List<Integer> findIdsById(@Param("id") Integer id);
}

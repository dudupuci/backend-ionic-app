package com.megashop.app.repository;

import com.megashop.app.entities.Category;
import com.megashop.app.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}

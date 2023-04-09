package com.project.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.foodapp.dto.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

}

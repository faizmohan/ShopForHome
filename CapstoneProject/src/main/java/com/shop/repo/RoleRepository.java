package com.shop.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.Roles;

public interface RoleRepository extends JpaRepository<Roles, Long>{

}

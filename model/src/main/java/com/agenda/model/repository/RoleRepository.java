package com.agenda.model.repository;

import com.agenda.model.entity.Role;
import com.agenda.model.entity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository <Role, Long> {
	Optional <Role> findByName(RoleName roleName);
}
package com.example.lma.repos;

import com.example.lma.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByrole(String role);
}

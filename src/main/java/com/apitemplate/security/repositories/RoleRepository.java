package com.apitemplate.security.repositories;


import java.util.Optional;

import com.apitemplate.security.models.ERole;
import com.apitemplate.security.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}
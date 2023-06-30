package com.example.kinoteka.domain.type;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TypeRepository extends CrudRepository<Type, Long> {
    Optional<Type> findByNameIgnoreCase(String name);

}

package com.lucas.butcher.repositories;

import com.lucas.butcher.models.OpenTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpenTimeRepository extends JpaRepository<OpenTime, Long> {
}

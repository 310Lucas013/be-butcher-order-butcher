package com.lucas.butcher.repositories;

import com.lucas.butcher.models.Butcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ButcherRepository extends JpaRepository<Butcher, Long> {
    Butcher getByCredentialsId(Long credentialsId);
}

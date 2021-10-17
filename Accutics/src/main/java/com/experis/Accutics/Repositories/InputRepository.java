package com.experis.Accutics.Repositories;

import com.experis.Accutics.Models.Input;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InputRepository extends JpaRepository<Input, Long> {
}

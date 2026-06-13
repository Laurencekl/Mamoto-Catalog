package com.example.mamotoapi.repository;

import com.example.mamotoapi.model.Moto;
import com.example.mamotoapi.model.StatusMoto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MotoRepository extends JpaRepository<Moto, Long>{

    List<Moto> findByStatus(StatusMoto status);
}

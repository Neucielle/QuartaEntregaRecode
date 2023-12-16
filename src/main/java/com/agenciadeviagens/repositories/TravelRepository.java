package com.agenciadeviagens.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agenciadeviagens.models.Travel;

@Repository
public interface TravelRepository extends JpaRepository<Travel, Long> {

}

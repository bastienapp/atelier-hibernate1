package com.example.shoesfactory.repositories;

import com.example.shoesfactory.entities.Shoes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoesRepository extends JpaRepository<Shoes,Long> {

}

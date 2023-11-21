package com.senac.entregas.data;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository; 

@Repository
public interface MotoboyRepository extends JpaRepository<MotoboyEntity, Integer>{
    
}

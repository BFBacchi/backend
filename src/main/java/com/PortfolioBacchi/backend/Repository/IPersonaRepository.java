
package com.PortfolioBacchi.backend.Repository;

import com.PortfolioBacchi.backend.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IPersonaRepository extends JpaRepository <Persona, Long> {
    
}

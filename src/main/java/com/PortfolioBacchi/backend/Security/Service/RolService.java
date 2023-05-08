/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortfolioBacchi.backend.Security.Service;

import com.PortfolioBacchi.backend.Security.Entity.Rol;
import com.PortfolioBacchi.backend.Security.Enums.RolNombre;
import com.PortfolioBacchi.backend.Security.Repository.iRolRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    @Autowired
    iRolRepository irolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return irolRepository.findByRolNombre(rolNombre);
        
    }
    
    public void save(Rol rol){
        irolRepository.save(rol);
        
    }
}

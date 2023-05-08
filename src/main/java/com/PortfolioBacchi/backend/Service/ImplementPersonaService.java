
package com.PortfolioBacchi.backend.Service;

import com.PortfolioBacchi.backend.Entity.Persona;
import com.PortfolioBacchi.backend.Interface.IPersonaService;
import com.PortfolioBacchi.backend.Repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImplementPersonaService implements IPersonaService{

    @Autowired IPersonaRepository ipersonarepository;
            
    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = ipersonarepository.findAll();
        return persona;
        
    }

    @Override
    public void guardarPersona(Persona persona) {
        ipersonarepository.save(persona);
    }

    @Override
    public void eliminarPersona(Long id) {
        ipersonarepository.deleteById(id);
    }

    @Override
    public Persona buscarPersona(Long id) {
       Persona persona = ipersonarepository.findById(id).orElse(null);
       return persona;
    }
    
}

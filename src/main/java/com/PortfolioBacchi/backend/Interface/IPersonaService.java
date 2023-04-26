
package com.PortfolioBacchi.backend.Interface;

import com.PortfolioBacchi.backend.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    
    public List<Persona> getPersona();
    
    public void guardarPersona(Persona persona);
    
    public void eliminarPersona(Long id);
    
    public Persona buscarPersona (Long id);
    
}

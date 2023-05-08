
package com.PortfolioBacchi.backend.Controler;


import com.PortfolioBacchi.backend.Entity.Persona;
import com.PortfolioBacchi.backend.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:58891")
public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    
    @GetMapping("/personas/get")
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }  
    
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona) {
        ipersonaService.guardarPersona(persona);
        return "La persona ha sido creada con exito";
    }    
    
    @DeleteMapping("/personas/borrar/{id}")
    public String deletepersona(@PathVariable Long id){
        ipersonaService.eliminarPersona(id);
        return "La persona fue eliminada correctamente";
    }
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                               @RequestParam("nombre") String nuevoNombre, 
                               @RequestParam("apellido") String nuevoApellido,
                               @RequestParam("nombre") String nuevoImagen){
        Persona persona = ipersonaService.buscarPersona(id);
        
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImagen(nuevoImagen);
        
        
        ipersonaService.guardarPersona(persona);
        return persona;
    
    }
    
    @GetMapping("/personas/traer/perfil")
    public Persona buscarPersona(){
        return ipersonaService.buscarPersona((long)1);
    } 
    
    
}

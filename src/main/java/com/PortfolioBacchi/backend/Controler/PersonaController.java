
package com.PortfolioBacchi.backend.Controler;


import com.PortfolioBacchi.backend.Entity.Persona;
import com.PortfolioBacchi.backend.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    
    @GetMapping("/personas/get")
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }  
    
    @PostMapping("/personas/crear")
    public String createPersona(@ResponseBody Persona persona) {
        ipersonaService.guardarPersona(persona);
        return "La persona ha sido creada con exito";
    }    
    
}

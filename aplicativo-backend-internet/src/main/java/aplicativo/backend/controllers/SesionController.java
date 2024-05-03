package aplicativo.backend.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.RestController;

import aplicativo.backend.entities.User;
import aplicativo.backend.services.SesionService;
import aplicativo.backend.util.ResponseData;





@RestController
@RequestMapping("api/sesion")
public class SesionController {
	
	@Autowired
	private  SesionService sesionService;
	
	
	@PostMapping("/login")
	public ResponseData login(@RequestBody User usuario)  {
            return sesionService.login(usuario); 
	}
	
	@PostMapping("/logout")
	public ResponseData logout(@RequestBody User usuario) {
		
		
	
            return sesionService.logout(usuario);
            
     
          
	}
	
	@PostMapping("/password")
	public ResponseData detalle(@RequestBody Map<String, String> requestBody) {
		String username = requestBody.get("username");
	    return sesionService.Password(username);
	}
	

}

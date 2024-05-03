package aplicativo.backend.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import aplicativo.backend.entities.Client;
import aplicativo.backend.entities.User;
import aplicativo.backend.services.UserService;
import aplicativo.backend.util.ResponseData;

@RestController
@RequestMapping("api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/listar")
	public ResponseData listar() {
		return userService.findAll();
	}
	
	
	
	@PostMapping("/ver")
	public ResponseData detalle(@RequestBody Map<String, Integer> requestBody) {
	    Integer id = requestBody.get("id");
	    return userService.findById(id);
	}

	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseData crear(  @RequestBody User user )  {
	
			 
		ResponseData response = userService.save(user, null);
		return response;
		
	}
	

	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseData editar( @RequestBody User user, @PathVariable Integer id)  {
			ResponseData response = userService.save(user,id);
			return response;
			
	}


	
	@PostMapping("/aprobar")
	public ResponseData Aprobar(@RequestBody Map<String, Integer> requestBody) {
	    Integer id = requestBody.get("id");
	    return userService.approveUser(id);
	}

	
	@PostMapping("/assign")
	
	public ResponseData assignacio(@RequestParam Integer userId, @RequestParam Integer cashId) {
	    
	    return userService.asignacionCaja(userId, cashId);
	}

}

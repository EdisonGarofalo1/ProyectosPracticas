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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import aplicativo.backend.entities.Attention;
import aplicativo.backend.entities.Client;
import aplicativo.backend.entities.Turn;
import aplicativo.backend.services.TurnoService;
import aplicativo.backend.util.ResponseData;

@RestController
@RequestMapping("api/turn")
public class TurnController {

	@Autowired
	private TurnoService turnoService;
	
	@GetMapping("/listar")
	public ResponseData listar() {
		return turnoService.findAll();
	}
	

	@PostMapping("/ver")
	public ResponseData detalle(@RequestBody Map<String, Integer> requestBody) {
	    Integer id = requestBody.get("id");
	    return turnoService.findById(id);
	}

	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseData crear(  @RequestBody Turn turn )  {
	
			 
		ResponseData response = turnoService.save(turn, null);
		return response;
		
	}
	
	
	
	@PostMapping("/attention")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseData attention(  @RequestBody Attention attention )  { 
		ResponseData response = turnoService.servicioAttention(attention);
		return response;
		
	}

	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseData editar( @RequestBody Turn turn  , @PathVariable Integer id)  {
			ResponseData response = turnoService.save(turn,id);
			return response;
			
	}


}

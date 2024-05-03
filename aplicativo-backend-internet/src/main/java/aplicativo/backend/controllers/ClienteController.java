package aplicativo.backend.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import aplicativo.backend.entities.Client;
import aplicativo.backend.services.ClientService;
import aplicativo.backend.util.ResponseData;

@RestController
@RequestMapping("api/client")
public class ClienteController {
	
	@Autowired
	private ClientService clientService;
	

	@GetMapping("/listar")
	public ResponseData listar() {
		return clientService.findAll();
	}


	

	
	@PostMapping("/ver")
	public ResponseData detalle(@RequestBody Map<String, Integer> requestBody) {
	    Integer id = requestBody.get("id");
	    return clientService.findById(id);
	}
	
	
	@PostMapping("/buscar")
	public ResponseData buscar(@RequestBody Map<String, String> requestBody) {
	    String identification = requestBody.get("identification");
	    return clientService.buscaridentificaccion(identification);
	}

	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseData crear(  @RequestBody Client client )  {
			 
		ResponseData response = clientService.save(client, null);
		return response;
		
	}
	
	@PostMapping("/crearmasiva")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseData cargaMaxiba( @RequestBody String json ,@RequestParam Integer accion)  {
			 
		ResponseData response = clientService.saveCargaMasiva(json,accion);
		return response;
		
	}
	

	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseData editar( @RequestBody Client client, @PathVariable Integer id)  {
			ResponseData response = clientService.save(client,id);
			return response;
			
	}


}

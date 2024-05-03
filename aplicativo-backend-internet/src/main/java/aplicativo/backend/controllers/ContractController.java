package aplicativo.backend.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import aplicativo.backend.entities.Contract;
import aplicativo.backend.entities.Methodpayment;
import aplicativo.backend.entities.Payments;
import aplicativo.backend.entities.Services;
import aplicativo.backend.services.ContractService;
import aplicativo.backend.util.ResponseData;

@RestController
@RequestMapping("api/contract")
public class ContractController {

	@Autowired
	private ContractService contractService;
	
	@GetMapping("/listar")
	public ResponseData listar() {
		return contractService.findAll();
	}

	

	@PostMapping("/ver")
	public ResponseData detalle(@RequestBody Map<String, Integer> requestBody) {
	    Integer id = requestBody.get("id");
	    return contractService.findById(id);
	}

	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseData crear(  @RequestBody Contract contract )  {
	
			 
		ResponseData response = contractService.save(contract, null);
		return response;
		
	}
	

	
	@PostMapping("/editar")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseData editar( @RequestBody  Contract contract,@RequestParam Integer contractid)  {
			ResponseData response = contractService.save(contract,contractid);
			return response;
			
	}
	
	
	
	
	@PostMapping("/cacelacion")
	public ResponseData eliminar(@RequestBody Map<String, Integer> requestBody) {
	    Integer id = requestBody.get("id");
	     ResponseData response=contractService.eliminarContract(id);
	     return response;
	}
	
	
	@PostMapping("/crearservice")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseData crearservice(  @RequestBody Services service )  {
	
			 
		ResponseData response = contractService.saveService(service);
		return response;
		
		
	}
	
	
	
	@PostMapping("/crearfromapago")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseData crearfromapago(  @RequestBody List<Methodpayment> methodpayment )  {
	
			 
		ResponseData response = contractService.saveFormaPago(methodpayment);
		return response;
		
	}
	
	
	
	@PostMapping("/cambiometodopago")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseData metodopago( @RequestParam Integer contractid,  @RequestParam Integer methodpaymentid)  {
			ResponseData response = contractService.cambioformapago(contractid,methodpaymentid);
			return response;
			
	}
	
	
	@PostMapping("/pagos")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseData pagos(  @RequestBody Payments pagos )  { 
		ResponseData response = contractService.pagos(pagos);
		return response;
		
	}
	

}

package aplicativo.backend.services;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.main.JsonSchema;

import aplicativo.backend.dto.ContractResponseDTO;
import aplicativo.backend.entities.Contract;
import aplicativo.backend.entities.Device;
import aplicativo.backend.entities.Methodpayment;
import aplicativo.backend.entities.Payments;
import aplicativo.backend.entities.Services;
import aplicativo.backend.entities.Statuscontract;

import aplicativo.backend.repository.ContractRepository;
import aplicativo.backend.repository.DeviceRepository;
import aplicativo.backend.repository.MethodpaymentRepository;
import aplicativo.backend.repository.PaymentsRepository;
import aplicativo.backend.repository.ServicesRepository;
import aplicativo.backend.util.JsonSchemaLoader;
import aplicativo.backend.util.MessageUtil;
import aplicativo.backend.util.ResponseData;

@Service
public class ContractServiceImp implements ContractService {

	@Autowired
	private ContractRepository contractRepository;

	@Autowired
	private ServicesRepository servicesRepository;

	@Autowired
	private DeviceRepository deviceRepository;

	@Autowired
	private MethodpaymentRepository methodpaymentRepository;

	 @Autowired
	    private ModelMapper modelMapper;
	
	@Autowired
	private PaymentsRepository paymentsRepository;

	@Override
	public ResponseData findAll() {

		ResponseData response = new ResponseData();

		Map<String, Object> mapContrato = new HashMap<>();
		try {

			List<Contract> listcontrato = contractRepository.findAll();

			if (!listcontrato.isEmpty()) {
				
				List<ContractResponseDTO> listDTO = listcontrato.stream()
					      
                        .map(this::convertToDTO)
                        
                        .collect(Collectors.toList());
				mapContrato.put("listcontrato", listDTO);
				response.setData(mapContrato);
				response.setCode(MessageUtil.OK.name());
				response.setMessage(MessageUtil.OK.getKey());
			} else {
				response.setCode(MessageUtil.NOTFOUND.name());
				response.setMessage(MessageUtil.NOTFOUND.getKey());
			}

		} catch (Exception e) {
			e.printStackTrace();
			response.setCode(MessageUtil.ERRORCONSULTA.name());
			response.setMessage(MessageUtil.ERRORCONSULTA.getKey() + e.getMessage());
		}
		return response;

	}

	@Override
	public ResponseData findById(Integer id) {
		ResponseData response = new ResponseData();

		Map<String, Object> mapContrato = new HashMap<>();
		try {

			Contract contrato = contractRepository.findById(id).orElse(null);

			if (contrato != null) {

				ContractResponseDTO contratoDTO = convertToDTO(contrato);
				mapContrato.put("contrato", contratoDTO);
				response.setData(mapContrato);

				response.setCode(MessageUtil.OK.name());
				response.setMessage(MessageUtil.OK.getKey());
			} else {
				response.setCode(MessageUtil.NOTFOUND.name());
				response.setMessage(MessageUtil.NOTFOUND.getKey());
			}

		} catch (Exception e) {

			response.setCode(MessageUtil.ERRORCONSULTA.name());
			response.setMessage(MessageUtil.ERRORCONSULTA.getKey() + e.getMessage());
		}

		return response;

	}

	@Override
	public ResponseData save(Contract contract, Integer id) {
		
	
		ResponseData response = new ResponseData();	 
        
		try {

			
			
			if (id != null) {
				Contract contractresponse = contractRepository.findById(id).orElse(null);

				if (contractresponse != null) {

					
					
						
						//fecha final del contrato
						contract.setEnddate(contractresponse.getEnddate());
						
						Statuscontract status = new Statuscontract();
			            
			            status.setStatusid("SUS");
			            
						contractresponse.setStatuscontract(status);
						
						contractRepository.save(contractresponse);
						
						
						Statuscontract statusrenovacion = new Statuscontract();
						statusrenovacion.setStatusid("RCO");
						
						contract.setStatuscontract(statusrenovacion);
						contractRepository.save(contract);
						
						response.setCode(MessageUtil.UPDATED.name());
						response.setMessage(MessageUtil.UPDATED.getKey());
		

				} else {
					response.setCode(MessageUtil.NOTFOUND.name());
					response.setMessage(MessageUtil.NOTFOUND.getKey());
				}

			} else {
				
		
				
				
				contractRepository.save(contract);
				response.setCode(MessageUtil.CREATED.name());
				response.setMessage(MessageUtil.CREATED.getKey());

			}
			
		        
		} catch (Exception e) {
			response.setCode(MessageUtil.INTERNALERROR.name());
			response.setMessage(MessageUtil.INTERNALERROR.getKey() + "\n" + e.getMessage());
			
			

		}

		return response;

	}

	
	
	@Override
	public ResponseData eliminarContract(Integer idContract) {
		

		 LocalDate fechaActual = LocalDate.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        String fechaFormateada = fechaActual.format(formatter);
	        Date fechaDate = java.sql.Date.valueOf(fechaFormateada);
	
		
		ResponseData response = new ResponseData();
		try {
			Optional<Contract>  optionalcontrato = contractRepository.findById(idContract);

			if (optionalcontrato.isPresent()) {
				Contract contract = optionalcontrato.get();
				
				  // Crear una instancia de Statuscontract con el estado deseado
	            Statuscontract status = new Statuscontract();
	            
	            status.setStatusid("CCO"); // Aquí estableces el ID del estado deseado
	            // Puedes establecer la descripción si es necesario
				
				contract.setStatuscontract(status);
				contract.setEnddate(fechaDate);
				
				contractRepository.save(contract);
				response.setCode(MessageUtil.CANCELACION.name());
				response.setMessage(MessageUtil.CANCELACION.getKey());
			} else {
				response.setCode(MessageUtil.NOTFOUND.name());
				response.setMessage(MessageUtil.NOTFOUND.getKey());
			}

		} catch (Exception e) {

		}

		return response;
	}

	@Override
	public ResponseData saveService(Services service) {
		
		ResponseData response = new ResponseData();

		try {
			// Guardar el servicio primero para obtener su ID generado

			Services savedService = servicesRepository.save(service);

			// Asignar el servicio a los dispositivos y guardar los dispositivos
			List<Device> devices = service.getDevice();
			if (devices != null && !devices.isEmpty()) {
				for (Device device : devices) {
					device.setService(savedService); // Asignar el servicio al dispositivo
					deviceRepository.save(device); // Guardar el dispositivo
				}
			}

			response.setCode(MessageUtil.CREATED.name());
			response.setMessage(MessageUtil.CREATED.getKey());

		} catch (Exception e) {

			response.setCode(MessageUtil.ERRORCONSULTA.name());
			response.setMessage(MessageUtil.ERRORCONSULTA.getKey() + e.getMessage());
		}

		return response;

	}

	@Override
	public ResponseData saveFormaPago(List<Methodpayment> formaspago) {

		ResponseData response = new ResponseData();

		try {

			// Iterar sobre la lista de formas de pago y guardar cada una
			for (Methodpayment formaPago : formaspago) {
				methodpaymentRepository.save(formaPago);
			}

//	       methodpaymentRepository.save(formapago);

			response.setCode(MessageUtil.CREATED.name());
			response.setMessage(MessageUtil.CREATED.getKey());

		} catch (Exception e) {

			response.setCode(MessageUtil.ERRORCONSULTA.name());
			response.setMessage(MessageUtil.ERRORCONSULTA.getKey() + e.getMessage());
		}

		return response;

	}

	@Override
	public ResponseData cambioformapago(Integer id, Integer metodopagoid) {

		ResponseData response = new ResponseData();
		try {
		Contract  contratoresponse = contractRepository.findById(id).orElse(null);
		
		if(contratoresponse != null) {
		
			Methodpayment  tipomedopago = new Methodpayment();
			tipomedopago.setMethodpaymentid(metodopagoid);
			
			contratoresponse.setMethodpayment(tipomedopago);
			
            contractRepository.save(contratoresponse);

		response.setCode(MessageUtil.UPDATED.name());
		response.setMessage(MessageUtil.UPDATED.getKey());
		
	}else {
		
		response.setCode(MessageUtil.NOTFOUND.name());
		response.setMessage(MessageUtil.NOTFOUND.getKey());
		
	}}
	catch (Exception e) {

		response.setCode(MessageUtil.ERRORCONSULTA.name());
		response.setMessage(MessageUtil.ERRORCONSULTA.getKey() + e.getMessage());
	}

	return response;
	}

	@Override
	public ResponseData pagos(Payments pagos) {
	
		ResponseData response = new ResponseData();

		try {
			
			paymentsRepository.save(pagos);
			response.setCode(MessageUtil.CREATED.name());
			response.setMessage(MessageUtil.CREATED.getKey());

		}
		catch (Exception e) {

			response.setCode(MessageUtil.ERRORCONSULTA.name());
			response.setMessage(MessageUtil.ERRORCONSULTA.getKey() + e.getMessage());
		}

		return response;
	}

	
	  private ContractResponseDTO convertToDTO(Contract contract) {
	        return modelMapper.map(contract, ContractResponseDTO.class); // Si estás utilizando ModelMapper
	       
	    }
}

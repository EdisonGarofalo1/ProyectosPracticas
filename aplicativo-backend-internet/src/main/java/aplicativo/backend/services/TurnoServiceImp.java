package aplicativo.backend.services;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import aplicativo.backend.entities.Turn;
import aplicativo.backend.repository.AttentionRepository;
import aplicativo.backend.repository.TurnRepository;

import aplicativo.backend.util.MessageUtil;
import aplicativo.backend.util.ResponseData;
import aplicativo.backend.dto.TurnResponseDTO;
import aplicativo.backend.entities.Attention;
import aplicativo.backend.entities.AttentionType;

@Service
public class TurnoServiceImp  implements TurnoService{

	
	@Autowired
	private TurnRepository turnRepository;
	
	
	@Autowired
	private AttentionRepository attentionRepository;
	

	  @Autowired
	    private ModelMapper modelMapper;
	
	

	   
	@Override
	public ResponseData findAll() {
	

		ResponseData response = new ResponseData();

		Map<String, Object> mapTurno = new HashMap<>();
		try {

			List<Turn> listturn = turnRepository.findAll();

			if (!listturn.isEmpty()) {
				
				
				List<TurnResponseDTO> listDTO = listturn.stream()
			      
                .map(this::convertToDTO)
                
                .collect(Collectors.toList());
				
				mapTurno.put("listaturno", listDTO);
				response.setData(mapTurno);
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

		Map<String, Object> mapTurno = new HashMap<>();
		try {

			Turn trun = turnRepository.findById(id).orElse(null);
		
			if (trun != null) {
			
				
				
				TurnResponseDTO turnDTO = convertToDTO(trun);
				mapTurno.put("Turno", turnDTO);
				response.setData(mapTurno);

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
	public ResponseData save(Turn turn, Integer id) {
		
		
		 LocalDate fechaActual = LocalDate.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        String fechaFormateada = fechaActual.format(formatter);
	        Date fechaDate = java.sql.Date.valueOf(fechaFormateada);
		
		
		ResponseData response = new ResponseData();	 
        
		try {


			
			if (id != null) {
				Turn Turnresponse = turnRepository.findById(id).orElse(null);

				if (Turnresponse != null) {

					

					Turnresponse.setDate(fechaDate);
					Turnresponse.setCash(turn.getCash());
					//Clientresponse.setIdentification(client.getIdentification());
					Turnresponse.setUsergestorid(turn.getUsergestorid());
					
				
					
					

					turnRepository.save(Turnresponse);

					response.setCode(MessageUtil.UPDATED.name());
					response.setMessage(MessageUtil.UPDATED.getKey());

				} else {
					response.setCode(MessageUtil.NOTFOUND.name());
					response.setMessage(MessageUtil.NOTFOUND.getKey());
				}

			} else {
				
				turn.setDate(fechaDate);
				
				turnRepository.save(turn);
				response.setCode(MessageUtil.CREATED.name());
				response.setMessage(MessageUtil.CREATED.getKey());

			}
			
//		        } else {
//		      
//
//		                response.setCode(MessageUtil.JSONSCHEMA.name());
//		                response.setMessage(MessageUtil.JSONSCHEMA.getKey() + report.toString());
//
//
//		        }
		} catch (Exception e) {
			response.setCode(MessageUtil.INTERNALERROR.name());
			response.setMessage(MessageUtil.INTERNALERROR.getKey() + "\n" + e.getMessage());
			
			

		}

		return response;


	}

	@Override
	public ResponseData eliminarTurn(Integer idTurn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseData servicioAttention(Attention attention) {
	
	ResponseData response = new ResponseData();	 
        
		try {
			
			  AttentionType tipoAtencion = attention.getAttentionType();
			   String descripcionGenerada = generarDescripcion(tipoAtencion);
			
				Turn Turnresponse = turnRepository.findById(attention.getTurn().getTurnid()).orElse(null);
			   
				Turnresponse.setDescription(descripcionGenerada);
				
				turnRepository.save(Turnresponse);
			
			    attentionRepository.save(attention);
				response.setCode(MessageUtil.CREATED.name());
				response.setMessage(MessageUtil.CREATED.getKey());

			
		} catch (Exception e) {
			response.setCode(MessageUtil.INTERNALERROR.name());
			response.setMessage(MessageUtil.INTERNALERROR.getKey() + "\n" + e.getMessage());
			
			

		}

		return response;

	}


	 private TurnResponseDTO convertToDTO(Turn turn){
	        return modelMapper.map(turn, TurnResponseDTO.class); // Si estás utilizando ModelMapper
	       
	    }
	 
	 
	 private String generarDescripcion(AttentionType tipoAtencion) {
	        // Aquí puedes implementar la lógica para generar la descripción según el tipo de atención
	        // Por ejemplo, asumiendo que el formato es 2 letras mayúsculas seguidas de 4 números
	        // AC0001 – Atención al cliente, PS0001 – Pago de servicio
	        String tipoAbreviado = tipoAtencion.getAttentiontypeid();
	        Long count = turnRepository.countByTipoAtencion(tipoAbreviado); // Contar la cantidad de turnos para este tipo de atención
	        
	        String numeroFormato = String.format("%04d", count + 1); // Formatear el número con 4 dígitos

	        return tipoAbreviado + numeroFormato;
	       
	    }

}

package aplicativo.backend.services;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aplicativo.backend.dto.UserDTO;
import aplicativo.backend.entities.Sesion;
import aplicativo.backend.entities.User;
import aplicativo.backend.entities.UserStatus;
import aplicativo.backend.repository.SesionRepository;
import aplicativo.backend.repository.UserRepository;

import aplicativo.backend.repository.UserCashRepository;
import aplicativo.backend.util.MessageUtil;
import aplicativo.backend.util.ResponseData;






@Service
public class SesionServiceImp implements  SesionService{


	
	@Autowired
	   private SesionRepository sesionRepository;
	
	@Autowired
	   private UserRepository   usuarioRepository;
	
	  @Autowired
	    private ModelMapper modelMapper;
	@Autowired
	   private UserCashRepository  UserCashRepository;
	

	@Override
	public ResponseData login(User usuario)  {
		
		Map<String, Object> mapUser = new HashMap<>();
		ResponseData response = new ResponseData();
		try {
			User usuarioDb = usuarioRepository.buscarusername(usuario.getUsername());

                 if(usuarioDb == null ) {
                	 
                	 
                	 response.setMessage("No se encontro Username ");
					 return response;
			}
			 
			 
			 if ( usuarioDb.getPassword().equals(usuario.getPassword())) { 
	        	
				 boolean existeSecionActiva = usuarioRepository.existsByUserIdAndStatusActive(usuarioDb.getUserid());
	        	
				 if(existeSecionActiva) {
					 response.setMessage("Ya existe una sesión activa para este usuario");
					 return response;
				 }
				 
				 Integer id_caja = UserCashRepository.encontraidcaja(usuarioDb.getUserid());
				 
				 UserStatus  statur = new UserStatus();
						 
				statur.setStatusid("A");
					
				 usuarioDb.setUserStatus(statur);;
				 
				 usuarioRepository.save(usuarioDb);
				 
				 Sesion sesion = new Sesion();
	        	
	             sesion.setUsuario(usuarioDb);
	             
	             sesion.setCashid(1);
	             
	             sesion.setFechaIngreso(new Date(System.currentTimeMillis()));
	           
	             sesionRepository.save(sesion);
	             response.setMessage("Se logio con exito");
                 response.setCode(usuarioDb.getRol().getRolName());
                 UserDTO userDTO = convertToDTO(usuarioDb);
 				
 				mapUser.put("user", userDTO);
                 response.setData(mapUser);
	             return response;
	            
				 
	        }else {
	          
			 response.setMessage("Credenciales de inicio de sesión incorrectas.");
			 return response;
	        	
	        } 

			
		} catch (Exception e) {
	     
			response.setCode(MessageUtil.INTERNALERROR.name());
			response.setMessage(MessageUtil.INTERNALERROR.getKey() + e.getMessage());
		}
		
	     return response;
	}

	@Override
	public ResponseData logout(User usuario)  {
		ResponseData response = new ResponseData();
//		
	     return null;
		
	}

	@Override
	public ResponseData Password(String username) {
		ResponseData response = new ResponseData();
		Map<String, Object> mapUser = new HashMap<>();
		try {
		   User user = usuarioRepository.buscarusername(username);
		
		   
			if (user != null) {
				
				UserDTO userDTO = convertToDTO(user);
				
				mapUser.put("user", userDTO);
				response.setData(mapUser);

				
				response.setCode(MessageUtil.OK.name());
				response.setMessage(MessageUtil.OK.getKey());
			} else {
				response.setCode(MessageUtil.NOTFOUND.name());
				response.setMessage(MessageUtil.NOTFOUND.getKey());
			}
		   
	} catch (Exception e) {
		response.setCode(MessageUtil.INTERNALERROR.name());
		response.setMessage(MessageUtil.INTERNALERROR.getKey() + e.getMessage());
	}
     return response;
	}
	
	
	  private UserDTO convertToDTO(User user) {
	        return modelMapper.map(user, UserDTO.class); // Si estás utilizando ModelMapper
	       
	    }

}

package aplicativo.backend.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;


import aplicativo.backend.dto.UserDTO;
import aplicativo.backend.entities.Cash;
import aplicativo.backend.entities.Client;
import aplicativo.backend.entities.User;
import aplicativo.backend.entities.UserCash;
import aplicativo.backend.repository.CashRepository;
import aplicativo.backend.repository.UserCashRepository;
import aplicativo.backend.repository.UserRepository;
import aplicativo.backend.util.JsonSchemaLoader;
import aplicativo.backend.util.MessageUtil;
import aplicativo.backend.util.ResponseData;

@Service
public class UserServiceImp implements UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	  @Autowired
	    private ModelMapper modelMapper;
	
	@Autowired
	private UserCashRepository userCashRepository;
	
	@Autowired
	private CashRepository cashRepository;
	
	private final JsonSchema userSchema;
	   private final ObjectMapper objectMapper;
	   
	   @Autowired
	   public UserServiceImp(ObjectMapper objectMapper) throws Exception {
	       this.userSchema = JsonSchemaLoader.loadSchemaFromInputStream(getClass().getResourceAsStream("/json/user-schema.json"));
	       this.objectMapper = objectMapper;
	   }
	   
	
	@Override
	public ResponseData findAll() {
		
		ResponseData response = new ResponseData();

		Map<String, Object> mapUser = new HashMap<>();
		try {

			List<User> listuser = userRepository.findAll();

			if (!listuser.isEmpty()) {
				

				List<UserDTO> listDTO = listuser.stream()
      
                        .map(this::convertToDTO)
                        
                        .collect(Collectors.toList());
				
				mapUser.put("listuser", listDTO);
				response.setData(mapUser);
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

		Map<String, Object> mapUser = new HashMap<>();
		try {

			User user = userRepository.findById(id).orElse(null);
		
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

			response.setCode(MessageUtil.ERRORCONSULTA.name());
			response.setMessage(MessageUtil.ERRORCONSULTA.getKey() + e.getMessage());
		}

		return response;

	}

	@Override
	public ResponseData save(User usuario, Integer id) {
		
		 LocalDate fechaActual = LocalDate.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        String fechaFormateada = fechaActual.format(formatter);
	        Date fechaDate = java.sql.Date.valueOf(fechaFormateada);
		
         ResponseData response = new ResponseData();	 
        
		try {
		
			   String json = objectMapper.writeValueAsString(usuario);
		        ProcessingReport report = userSchema.validate(objectMapper.readTree(json));
		        		        
		        if (report.isSuccess()) {
		        	
		        	User responseuser = userRepository.findById(usuario.getUsercreate()).orElse(null);
		        	
		        	if(responseuser == null) {
		        		
		        		response.setCode(MessageUtil.NOTFOUND01.name());
						response.setMessage(MessageUtil.NOTFOUND01.getKey());
						
						return response;
		        		
		        	}
		        	
			
			if (id != null) {
				
				User Userresponse = userRepository.findById(id).orElse(null);

				if (Userresponse != null) {
					Userresponse.setUsername(usuario.getUsername());
					Userresponse.setEmail(usuario.getEmail());
					Userresponse.setPassword(usuario.getPassword());
					Userresponse.setRol(usuario.getRol());
					Userresponse.setUserStatus(usuario.getUserStatus());
					userRepository.save(Userresponse);

					response.setCode(MessageUtil.UPDATED.name());
					response.setMessage(MessageUtil.UPDATED.getKey());

				} else {
					response.setCode(MessageUtil.NOTFOUND.name());
					response.setMessage(MessageUtil.NOTFOUND.getKey());
				}

			} else {
				
				
				User  userDb = userRepository.buscarusername(usuario.getUsername());


				if (userDb != null && usuario.getUserid() == null) {

					response.setCode(MessageUtil.MODULOEXIST.name());
					response.setMessage(MessageUtil.MODULOEXIST.getKey());
					
					return response;
				} 
				
			
			
				
				if ("Administrador".equals(responseuser.getRol().getRolName())) {
			
					usuario.setUserapproval(1);
					usuario.setCreationdate(fechaDate);
					usuario.setDateapproval(fechaDate);
					userRepository.save(usuario);
					
					response.setCode(MessageUtil.CREATED.name());
					response.setMessage(MessageUtil.CREATED.getKey());
					
				}else if("Gestores".equals(responseuser.getRol().getRolName())){
					
					usuario.setUserapproval(0);
					usuario.setCreationdate(fechaDate);
					userRepository.save(usuario);
					response.setCode(MessageUtil.CREATED.name());
					response.setMessage(MessageUtil.CREATED.getKey());
				}else {
					response.setCode("");
					response.setMessage("user no Autorizado");
					
				}
				
			

			}
			
		        } else {
		      

		                response.setCode(MessageUtil.JSONSCHEMA.name());
		                response.setMessage(MessageUtil.JSONSCHEMA.getKey() + report.toString());


		        }
		} catch (Exception e) {
			response.setCode(MessageUtil.INTERNALERROR.name());
			response.setMessage(MessageUtil.INTERNALERROR.getKey() + "\n" + e.getMessage());
			
			

		}

		return response;


	}

	@Override
	public ResponseData eliminarUsuario(Integer idUsuario) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ResponseData approveUser(Integer idUsuario) {
		
		 LocalDate fechaActual = LocalDate.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        String fechaFormateada = fechaActual.format(formatter);
	        Date fechaDate = java.sql.Date.valueOf(fechaFormateada);
		
      ResponseData response = new ResponseData();
		  User UserDb = userRepository.findById(idUsuario).orElse(null);
		  
		   if( UserDb != null ) {
			   UserDb.setUserapproval(1);
			   UserDb.setCreationdate(fechaDate);
			   UserDb.setDateapproval(fechaDate);
			  
			   userRepository.save(UserDb);
			   
			   response.setCode(MessageUtil.CREATED.name());
				response.setMessage("Usuario aprobada con éxito");
			   
			 
		   }else {
			   response.setCode(MessageUtil.NOTFOUND.name());
				response.setMessage(MessageUtil.NOTFOUND.getKey());
			   
		   }
		   
		   return  response;
	    
	}


	@Override
	public ResponseData asignacionCaja(Integer userid, Integer cashid) {
		
		 ResponseData response = new ResponseData();
		User user = userRepository.findById(userid).orElse(null);
		Cash cash  = cashRepository.findById(cashid).orElse(null);

//		  UserCash existingAssignment = userCashRepository.findByUserAndCash(userid, cashid);
//	        if (existingAssignment != null) {
//	         
//	            throw new RuntimeException("La asignación de efectivo ya existe para este usuario.");
//	        }
//
//		
		if(user != null &&  cash != null) {
			
			 UserCash userCash = new UserCash();
		        userCash.setUser(user);
		        userCash.setCash(cash);

		        // Guardar la asignación en la base de datos
		        userCashRepository.save(userCash);
		        
		        response.setCode(MessageUtil.CREATED.name());
				response.setMessage("asignado correctamente al usuario");
		}else {
			
			   response.setCode(MessageUtil.CHECKREQUEST.name());
				response.setMessage("no existe eso  datos");
		}
		
       
		return response;
	}

	
	  private UserDTO convertToDTO(User user) {
	        return modelMapper.map(user, UserDTO.class); // Si estás utilizando ModelMapper
	       
	    }
}

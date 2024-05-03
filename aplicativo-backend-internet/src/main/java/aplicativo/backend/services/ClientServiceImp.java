package aplicativo.backend.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.main.JsonSchema;

import aplicativo.backend.dto.ClientDTO;
import aplicativo.backend.entities.Client;
import aplicativo.backend.entities.Rol;
import aplicativo.backend.entities.User;
import aplicativo.backend.entities.UserStatus;
import aplicativo.backend.repository.ClientRepository;
import aplicativo.backend.repository.UserRepository;
import aplicativo.backend.util.JsonSchemaLoader;
import aplicativo.backend.util.MessageUtil;
import aplicativo.backend.util.ResponseData;
import com.github.fge.jsonschema.main.JsonSchema;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.report.MessageProvider;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;

import org.json.JSONArray;
import org.json.JSONObject;

@Service
public class ClientServiceImp implements  ClientService{

	
	
	@Autowired
	private  ClientRepository clientRepository;
	
	@Autowired
	private UserRepository  userRepository;
	
	  @Autowired
	    private ModelMapper modelMapper; 
	
	private final JsonSchema userSchema;
	   private final ObjectMapper objectMapper;
	   
	   @Autowired
	   public ClientServiceImp(ObjectMapper objectMapper) throws Exception {
	       this.userSchema = JsonSchemaLoader.loadSchemaFromInputStream(getClass().getResourceAsStream("/json/client-schema.json"));
	       this.objectMapper = objectMapper;
	   }
	   
	   
	@Override
	public ResponseData findAll() {
	
		ResponseData response = new ResponseData();

		Map<String, Object> mapCliente = new HashMap<>();
		try {

			List<Client> listcliente = clientRepository.findAll();

			if (!listcliente.isEmpty()) {
			
				
				List<ClientDTO> listClientesDTO = listcliente.stream()
                       // .map(this::convertToDTO)
                        .map(this::convertToDTO01)
                        
                        .collect(Collectors.toList());
				
				mapCliente.put("listclientes", listClientesDTO);
				
				response.setData(mapCliente);
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

		Map<String, Object> mapCliente = new HashMap<>();
		try {

			Client client = clientRepository.findById(id).orElse(null);
		
			if (client != null) {
			
				 ClientDTO clientDTO = convertToDTO(client);
				mapCliente.put("client", clientDTO);
				response.setData(mapCliente);

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
	public ResponseData save(Client client, Integer id) {
	
		
		ResponseData response = new ResponseData();	 
        
		try {

			   String json = objectMapper.writeValueAsString(client);
		        ProcessingReport report = userSchema.validate(objectMapper.readTree(json));
		        
			
		        
		        
		        
		        if (report.isSuccess()) {
			
			if (id != null) {
				Client Clientresponse = clientRepository.findById(id).orElse(null);

				if (Clientresponse != null) {

					

					Clientresponse.setName(client.getName());
					Clientresponse.setLastName(client.getLastName());
					Clientresponse.setEmail(client.getEmail());
					Clientresponse.setPhonenumber(client.getPhonenumber());
					Clientresponse.setAddress(client.getAddress());
					Clientresponse.setReferencceaddress(client.getReferencceaddress());
					
					

					clientRepository.save(Clientresponse);

					response.setCode(MessageUtil.UPDATED.name());
					response.setMessage(MessageUtil.UPDATED.getKey());

				} else {
					response.setCode(MessageUtil.NOTFOUND.name());
					response.setMessage(MessageUtil.NOTFOUND.getKey());
				}

			} else {
				
				
				Client clientDb = clientRepository.buscarClientidentification(client.getIdentification());


				if (clientDb != null && client.getClientid() == null) {

					response.setCode(MessageUtil.MODULOEXIST.name());
					response.setMessage(MessageUtil.MODULOEXIST.getKey());
					
					return response;
				} 
				
				
				clientRepository.save(client);
				response.setCode(MessageUtil.CREATED.name());
				response.setMessage(MessageUtil.CREATED.getKey());

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
	public ResponseData eliminarClient(Integer idClient) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ResponseData buscaridentificaccion(String identification) {
		
		ResponseData response = new ResponseData();

		Map<String, Object> mapCliente = new HashMap<>();
		try {

			Client client = clientRepository.buscarClientidentification(identification);
		
			if (client != null) {
			
				 ClientDTO clientDTO = convertToDTO(client);
				mapCliente.put("client", clientDTO);
				response.setData(mapCliente);

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
	
	
	private ClientDTO convertToDTO(Client client) {
	    ClientDTO clientDTO = new ClientDTO();
	    clientDTO.setClientid(client.getClientid());
	    clientDTO.setName(client.getName());
	    clientDTO.setLastName(client.getLastName());
	    clientDTO.setIdentification(client.getIdentification());
	    clientDTO.setEmail(client.getEmail());
	    clientDTO.setPhonenumber(client.getPhonenumber());
	    clientDTO.setAddress(client.getAddress());
	    clientDTO.setReferencceaddress(client.getReferencceaddress());
	    return clientDTO;
	}

	  private ClientDTO convertToDTO01(Client client) {
	        return modelMapper.map(client, ClientDTO.class); // Si estás utilizando ModelMapper
	       
	    }


	@Override
	public ResponseData saveCargaMasiva(String Json,Integer accion) {
		
		ResponseData response = new ResponseData();
		
		try {
		 JSONArray jsonArray = new JSONArray(Json);
		 
		 if(accion == 1) {
			 
			  List<Client> clients = new ArrayList<>();
		         
		         for (int i = 0; i < jsonArray.length(); i++) {
		             JSONObject jsonObject = jsonArray.getJSONObject(i);
		             Client clientnew = new Client();
		             clientnew.setName(jsonObject.getString("name"));
		             clientnew.setLastName(jsonObject.getString("lastName"));
		             clientnew.setIdentification(jsonObject.getString("identification"));
		             clientnew.setEmail(jsonObject.getString("email"));
		             clientnew.setPhonenumber(jsonObject.getString("phonenumber"));
		             clientnew.setAddress(jsonObject.getString("address"));
		             clientnew.setReferencceaddress(jsonObject.getString("referencceaddress"));
		             clients.add(clientnew);
		         }
		         for (Client client : clients) {
		             clientRepository.save(client);
		         }
		         
		     
				response.setCode(MessageUtil.CREATED.name());
				response.setMessage(MessageUtil.CREATED.getKey());

			 
		 } else if(accion == 2) {
			 
			  List<User> usersList = new ArrayList<>();
			  
			  
			  for (int i = 0; i < jsonArray.length(); i++) {
			        JSONObject jsonObject = jsonArray.getJSONObject(i);
			        
			        User user = new User();
			        user.setUsername(jsonObject.getString("username"));
			        user.setEmail(jsonObject.getString("email"));
			        user.setPassword(jsonObject.getString("password"));
			        
			        // Obtener el objeto "rol" y su propiedad "rolId"
			        JSONObject rolObject = jsonObject.getJSONObject("rol");
			        int rolId = rolObject.getInt("rolId");
			        
			        // Asignar el valor de "rolId" al objeto "Rol" del usuario
			        Rol rol = new Rol();
			        rol.setRolId(rolId);
			        user.setRol(rol);
			        
			        user.setUsercreate(jsonObject.getInt("usercreate"));
			        
			        // Obtener el objeto "userStatus" y su propiedad "statusid"
			        JSONObject userStatusObject = jsonObject.getJSONObject("userStatus");
			        String statusid = userStatusObject.getString("statusid");
			        
			        // Asignar el valor de "statusid" al objeto "UserStatus" del usuario
			        UserStatus userStatus = new UserStatus();
			        userStatus.setStatusid(statusid);
			        user.setUserStatus(userStatus);
			        
			        usersList.add(user);
			    }

		         

		        
			  for (User user : usersList) {
		        	 userRepository.save(user);
		         }
	         
		     
				response.setCode(MessageUtil.CREATED.name());
				response.setMessage(MessageUtil.CREATED.getKey());


			 
			 
		 }
		 
       
		} catch (Exception e) {

			response.setCode(MessageUtil.ERRORCONSULTA.name());
			response.setMessage(MessageUtil.ERRORCONSULTA.getKey() + e.getMessage());
		}

		return response;
	}



}

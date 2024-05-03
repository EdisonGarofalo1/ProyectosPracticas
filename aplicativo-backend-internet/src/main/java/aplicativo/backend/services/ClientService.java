package aplicativo.backend.services;



import aplicativo.backend.entities.Client;
import aplicativo.backend.util.ResponseData;

public interface ClientService {
	
	public ResponseData findAll();
	public ResponseData findById(Integer id) ;
	public ResponseData save(Client client,Integer id) ;
	
	public ResponseData saveCargaMasiva(String Json, Integer accion) ;
	
	public ResponseData  eliminarClient(Integer idClient);
	public ResponseData  buscaridentificaccion(String identification);
	


}

package aplicativo.backend.services;

import aplicativo.backend.entities.User;
import aplicativo.backend.util.ResponseData;

public interface UserService {
	
	public ResponseData findAll();
	public ResponseData findById(Integer id) ;
	public ResponseData save(User usuario,Integer id) ;
	public ResponseData  eliminarUsuario(Integer idUsuario);
	
	public ResponseData  approveUser(Integer idUsuario);
	
	public ResponseData  asignacionCaja(Integer userid, Integer cashid);
	
	

}

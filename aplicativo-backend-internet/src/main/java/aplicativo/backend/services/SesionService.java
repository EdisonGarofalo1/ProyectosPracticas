package aplicativo.backend.services;

import aplicativo.backend.entities.User;
import aplicativo.backend.util.ResponseData;

public interface SesionService  {
	

	public ResponseData login(User usuario) ;
	
	public ResponseData logout(User usuario) ;
	public ResponseData Password(String username) ;
	

}

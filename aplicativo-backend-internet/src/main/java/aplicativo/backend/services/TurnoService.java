package aplicativo.backend.services;


import aplicativo.backend.entities.Turn;
import aplicativo.backend.entities.Attention;
import aplicativo.backend.util.ResponseData;

public interface TurnoService {
	
	public ResponseData findAll();
	public ResponseData findById(Integer id) ;
	public ResponseData save(Turn turn,Integer id) ;
	public ResponseData  servicioAttention(Attention attention);
	public ResponseData  eliminarTurn(Integer idTurn);

}

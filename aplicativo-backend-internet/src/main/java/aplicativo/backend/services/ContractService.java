package aplicativo.backend.services;


import java.util.List;

import aplicativo.backend.entities.Contract;
import aplicativo.backend.entities.Methodpayment;
import aplicativo.backend.entities.Payments;
import aplicativo.backend.entities.Services;
import aplicativo.backend.util.ResponseData;

public interface ContractService {
	
	public ResponseData findAll();
	public ResponseData findById(Integer id) ;
	public ResponseData saveService(Services service) ;
	public ResponseData saveFormaPago(List<Methodpayment> formaspago) ;
	public ResponseData save(Contract contract,Integer id) ;
	public ResponseData cambioformapago(Integer id,  Integer metodopagoid) ;
	
	public ResponseData pagos(Payments pagos) ;
	
	public ResponseData  eliminarContract(Integer idContract);

}

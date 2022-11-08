package br.com.sglps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sglps.dao.InterfaceMotoristaDAO;
import br.com.sglps.model.Motorista;



@Service
public class MotoristaServiceImpl implements InterfaceMotoristaService {

	
	//referencia InterfaceMotoristaDAO
	InterfaceMotoristaDAO motoristaDAO;
	
	
	/*******************************************************************************/
	
	@Autowired
	public void setMotoristaDAO(InterfaceMotoristaDAO motoristaDAO) {
		this.motoristaDAO = motoristaDAO;
	}
	
	
	/*******************************************************************************/	
	
	public void inserirMotorista(Motorista motorista) {
			motoristaDAO.inserirMotorista(motorista);
		
	}

	/*******************************************************************************/

	public void atualizarMotorista(Motorista motorista) {
			motoristaDAO.atualizarMotorista(motorista);
		
	}
	
	/*******************************************************************************/

	public List<Motorista> buscarTodosMotoristas() {
			return motoristaDAO.buscarTodosMotoristas();
	}
	
	/*******************************************************************************/

	public Motorista buscarMotoristaPorId(Integer idMotorista) {
			return motoristaDAO.buscarMotoristaPorId(idMotorista);
	}

	/*******************************************************************************/

	public List<Motorista> disponivelBuscarTodosMotoristas() {
		return motoristaDAO.disponivelBuscarTodosMotoristas();
	}
	
	
	
	
	
	
	
	
	

}

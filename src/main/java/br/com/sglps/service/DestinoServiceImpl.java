package br.com.sglps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sglps.dao.InterfaceDestinoDAO;
import br.com.sglps.model.Destino;


@Service
public class DestinoServiceImpl implements InterfaceDestinoService{

	
	//referencia InterfaceDestinoDAO
	InterfaceDestinoDAO destinoDAO;
	
	/*******************************************************************************/
	
	@Autowired
	public void setDestinoDAO(InterfaceDestinoDAO destinoDAO) {
		this.destinoDAO = destinoDAO;
	}
	
		
	
	/*******************************************************************************/
	
	public void inserirDestino(Destino destino) {
		destinoDAO.inserirDestino(destino);
		
	}

	

	/*******************************************************************************/
	
	public void atualizarDestino(Destino destino) {
		destinoDAO.atualizarDestino(destino);
		
	}

	/*******************************************************************************/
	
	public List<Destino> buscarTodosDestinos() {
		return destinoDAO.buscarTodosDestinos();
	}

	/*******************************************************************************/
	
	public Destino buscarDestinoPorId(Integer idDestino) {
		return destinoDAO.buscarDestinoPorId(idDestino);
	}
	
	
	
	
	
	
	
	

}

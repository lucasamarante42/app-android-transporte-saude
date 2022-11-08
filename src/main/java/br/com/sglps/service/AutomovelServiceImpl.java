package br.com.sglps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sglps.dao.InterfaceAutomovelDAO;
import br.com.sglps.model.Automovel;


@Service
public class AutomovelServiceImpl implements InterfaceAutomovelService{

	
	//referencia InterfaceAutomovelDAO
	InterfaceAutomovelDAO automovelDAO;
	
	
	/*******************************************************************************/
	@Autowired
	public void setAutomovelDAO(InterfaceAutomovelDAO automovelDAO) {
		this.automovelDAO = automovelDAO;
	}
	
	
	/*******************************************************************************/
	
	public void inserirAutomovel(Automovel automovel) {
		automovelDAO.inserirAutomovel(automovel);
		
	}
		

	/*******************************************************************************/
	
	public void atualizarAutomovel(Automovel automovel) {
		automovelDAO.atualizarAutomovel(automovel);
		
	}

	/*******************************************************************************/
	
	public List<Automovel> buscarTodosAutomoveis() {
		return automovelDAO.buscarTodosAutomoveis();
	}

	/*******************************************************************************/
	
	public Automovel buscarAutomovelPorId(Integer idAutomovel) {
		return automovelDAO.buscarAutomovelPorId(idAutomovel);
	}

	/*******************************************************************************/

	public List<Automovel> disponivelBuscarTodosAutomoveis() {
		return automovelDAO.disponivelBuscarTodosAutomoveis();
	}
	
	
	
	
	
	
	
	
	
	
	
	

}

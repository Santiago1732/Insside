package tiendaTelefonica.example.insside.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import tiendaTelefonica.example.insside.Cliente;

@Service
public class ClientesServiceImpl implements IClientesService{

	private List<Cliente> lista = null;

	public ClientesServiceImpl() {
		
		lista = new LinkedList<Cliente>();
	}
	
	@Override
	public List<Cliente> buscarTodas() {
		return lista;
	}


	//Metodo para buscar por numero orden. 
	public Cliente buscarPorOrden(String numeroOrden) {

		for (Cliente v : lista) {
			if (v.getNumeroOrden() == numeroOrden) {
				return v;
			}
		}
		
		return null;
	}
	
	@Override
	public void guardar(Cliente cliente) {
		lista.add(cliente);
		
	}
	
	

}

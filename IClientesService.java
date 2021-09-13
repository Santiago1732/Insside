package tiendaTelefonica.example.insside.service;

import java.util.List;

import tiendaTelefonica.example.insside.Cliente;

public interface IClientesService{
	void guardar(Cliente cliente); 
	List <Cliente> buscarTodas();
	/*Cliente buscarPorId(Integer idCliente);*/
	Cliente buscarPorOrden(String numeroOrden); 
}

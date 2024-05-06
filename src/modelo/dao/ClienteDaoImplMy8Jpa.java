package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.entidades.Cliente;



public class ClienteDaoImplMy8Jpa implements ClienteDao{

	@Override
	public boolean alta(Cliente obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(String clave) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificar(Cliente obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cliente buscarUno(String clave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

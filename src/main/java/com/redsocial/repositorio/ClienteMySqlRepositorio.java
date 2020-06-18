package com.redsocial.repositorio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.redsocial.entidad.Cliente;

@Repository
public class ClienteMySqlRepositorio implements ClienteRepositorio{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int elimina(int idCliente) {
		return jdbcTemplate.update("delete from cliente where idcliente=?", new Object[] { idCliente});
	}

	@Override
	public int inserta(Cliente obj) {
		 return jdbcTemplate.update("insert into cliente values(null,?,?,?,?,?)", new Object[] { obj.getNombre(), obj.getApellido(), obj.getDni(), obj.getTelefono(),obj.getDireccion()});
			
	}

	@Override
	public int actualiza(Cliente obj) {
		return jdbcTemplate.update("update cliente set nombre =?, apellido =?, dni =?, telefono =?, direccion =?  where idcliente =? ", new Object[] { obj.getNombre(), obj.getApellido(), obj.getDni(), obj.getTelefono(),obj.getDireccion(),obj.getIdCliente()});

	}

	@Override
	public List<Cliente> lista(String filtro) {
		List<Cliente> lista = jdbcTemplate.query("select * from cliente where nombre like ? ",new Object[] { filtro+"%" }, new RowMapper<Cliente>() {
            @Override
            public Cliente mapRow(ResultSet rs, int arg1) throws SQLException {
            	Cliente obj = new Cliente();
            	obj.setIdCliente(rs.getInt("idcliente"));
            	obj.setNombre(rs.getString("nombre"));
            	obj.setApellido(rs.getString("apellido"));
            	obj.setDni(rs.getString("dni"));
            	obj.setTelefono(rs.getString("telefono"));
            	obj.setDireccion(rs.getString("direccion"));
                return obj;
            }
        });
        return lista;
	}
	
	

}

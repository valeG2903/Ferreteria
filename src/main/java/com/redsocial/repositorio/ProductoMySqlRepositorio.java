package com.redsocial.repositorio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.redsocial.entidad.Producto;

@Repository
public class ProductoMySqlRepositorio implements ProductoRepositorio{

	@Autowired
	private JdbcTemplate jdbcTemplate;
		
	@Override
	public int elimina(int idProducto) {
		 return jdbcTemplate.update("delete from producto where idproducto=?", new Object[] { idProducto});
	}

	@Override
	public int inserta(Producto obj) {
		 return jdbcTemplate.update("insert into producto values(null,?,?,?,?)", new Object[] { obj.getNombre(), obj.getMarca(), obj.getStock(), obj.getEstado()});
	}

	@Override
	public int actualiza(Producto obj) {
		 return jdbcTemplate.update("update producto set nombre =?, marca =?, stock =?, estado =? where idproducto =? ", new Object[] { obj.getNombre(), obj.getMarca(), obj.getStock(), obj.getEstado(),obj.getIdProducto()});

	}

	@Override
	public List<Producto> lista(String filtro) {
		List<Producto> lista = jdbcTemplate.query("select * from producto where nombre like ? ",new Object[] { filtro+"%" }, new RowMapper<Producto>() {
            @Override
            public Producto mapRow(ResultSet rs, int arg1) throws SQLException {
            	Producto obj = new Producto();
            	obj.setIdProducto(rs.getInt("idproducto"));
            	obj.setNombre(rs.getString("nombre"));
            	obj.setMarca(rs.getString("marca"));
            	obj.setStock(rs.getInt("stock"));
            	obj.setEstado(rs.getString("estado"));
                return obj;
            }
        });
        return lista;
	}

}

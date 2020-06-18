package com.redsocial.repositorio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.redsocial.entidad.Factura;

@Repository
public class FacturaMySqlRepositorio implements FacturaRepositorio {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int elimina(int idFactura) {
		return jdbcTemplate.update("delete from factura where idfactura=?", new Object[] { idFactura});

	}

	@Override
	public int inserta(Factura obj) {
		return jdbcTemplate.update("insert into factura values(null,?,?,null,null,?,?)", new Object[] { obj.getNumero_factura(), obj.getFecha_factura(), obj.getTotal_venta(), obj.getEstado_factura()}); 

	}

	@Override
	public int actualiza(Factura obj) {
		return jdbcTemplate.update("update factura set numero_factura =?, fecha_factura =?, total_venta =?, estado_factura =?  where idfactura =? ", new Object[] { obj.getNumero_factura(), obj.getFecha_factura(), obj.getTotal_venta(), obj.getEstado_factura(),obj.getIdFactura()});

	}

	@Override
	public List<Factura> lista(String filtro) {
		List<Factura> lista = jdbcTemplate.query("select * from factura where idfactura like ? ",new Object[] { filtro+"%" }, new RowMapper<Factura>() {
            @Override
            public Factura mapRow(ResultSet rs, int arg1) throws SQLException {
            	Factura obj = new Factura();
            	obj.setIdFactura(rs.getInt("idfactura"));
            	obj.setNumero_factura(rs.getString("numero_factura"));
            	obj.setFecha_factura(rs.getString("fecha_factura"));
            	obj.setTotal_venta(rs.getString("total_venta"));
            	obj.setEstado_factura(rs.getString("estado_factura"));
                return obj;
            }
        });
        return lista;
	}
	
	
	
	
 }

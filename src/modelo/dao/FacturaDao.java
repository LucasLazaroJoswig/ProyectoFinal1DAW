package modelo.dao;

import modelo.entidades.Factura;

public interface FacturaDao {
	int altaFactura(Factura factura);
	Factura buscarUno (String codigo);
}

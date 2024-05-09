package modelo.dao;

import modelo.entidades.Factura;


public class FacturaDaoImplMy8Jpa extends AbstractDaoImplmy8Jpa implements FacturaDao{

	@Override
	public int altaFactura(Factura factura) {
		try {
			tx.begin();
				em.persist(factura);
			tx.commit();
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Factura buscarUno(String codigo) {
		return em.find(Factura.class, codigo);
	}

}

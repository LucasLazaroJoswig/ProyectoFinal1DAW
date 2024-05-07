package modelo.entidades;

import java.io.Serializable; 
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the proyectos database table.
 * 
 */
@Entity
@Table(name="proyectos")
@NamedQuery(name="Proyecto.findAll", query="SELECT p FROM Proyecto p")
public class Proyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_proyecto")
	private String idProyecto;

	@Column(name="coste_real")
	private double costeReal;

	@Column(name="costes_previsto")
	private double costesPrevisto;

	private String descripcion;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin_previsto")
	private Date fechaFinPrevisto;
	

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin_real")
	private Date fechaFinReal;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio")
	private Date fechaInicio;

	@Column(name="venta_previsto")
	private double ventaPrevisto;

	//uni-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="cif")
	private Cliente cliente;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="jefe_proyecto")
	private Empleado empleado;

	public Proyecto() {
	}

	public String getIdProyecto() {
		return this.idProyecto;
	}

	public void setIdProyecto(String idProyecto) {
		this.idProyecto = idProyecto;
	}

	public double getCosteReal() {
		return this.costeReal;
	}

	public void setCosteReal(double costeReal) {
		this.costeReal = costeReal;
	}

	public double getCostesPrevisto() {
		return this.costesPrevisto;
	}

	public void setCostesPrevisto(double costesPrevisto) {
		this.costesPrevisto = costesPrevisto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaFinPrevisto() {
		return this.fechaFinPrevisto;
	}

	public void setFechaFinPrevisto(Date fechaFinPrevisto) {
		this.fechaFinPrevisto = fechaFinPrevisto;
	}

	public Date getFechaFinReal() {
		return this.fechaFinReal;
	}

	public void setFechaFinReal(Date fechaFinReal) {
		this.fechaFinReal = fechaFinReal;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public double getVentaPrevisto() {
		return this.ventaPrevisto;
	}

	public void setVentaPrevisto(double ventaPrevisto) {
		this.ventaPrevisto = ventaPrevisto;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
public   double MargenPrevisto () {

	return ventaPrevisto - costesPrevisto;
}

public double MargenReal() {
	
	return ventaPrevisto - costeReal;
}

public double DiferenciaGastos() {

	return costeReal - costesPrevisto;
}

public int diferenciaFinPrevistoReal() {
	
	return   (int) (fechaFinPrevisto.getTime() - fechaFinReal.getTime());

}
}
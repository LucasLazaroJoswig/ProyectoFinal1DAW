package modelo.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the subcontratados_con_proyecto database table.
 * 
 */
@Entity
@Table(name="subcontratados_con_proyecto")
@NamedQuery(name="SubcontratadosConProyecto.findAll", query="SELECT s FROM SubcontratadosConProyecto s")
public class SubcontratadosConProyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="numero_orden")
	private int numeroOrden;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_incorporacion")
	private Date fechaIncorporacion;

	@Column(name="horas_asignadas")
	private int horasAsignadas;

	@Column(name="id_proyecto")
	private String idProyecto;

	//bi-directional many-to-one association to Subcontratado
	@ManyToOne
	@JoinColumn(name="id_sub")
	private Subcontratado subcontratado;

	public SubcontratadosConProyecto() {
	}

	public int getNumeroOrden() {
		return this.numeroOrden;
	}

	public void setNumeroOrden(int numeroOrden) {
		this.numeroOrden = numeroOrden;
	}

	public Date getFechaIncorporacion() {
		return this.fechaIncorporacion;
	}

	public void setFechaIncorporacion(Date fechaIncorporacion) {
		this.fechaIncorporacion = fechaIncorporacion;
	}

	public int getHorasAsignadas() {
		return this.horasAsignadas;
	}

	public void setHorasAsignadas(int horasAsignadas) {
		this.horasAsignadas = horasAsignadas;
	}

	public String getIdProyecto() {
		return this.idProyecto;
	}

	public void setIdProyecto(String idProyecto) {
		this.idProyecto = idProyecto;
	}

	public Subcontratado getSubcontratado() {
		return this.subcontratado;
	}

	public void setSubcontratado(Subcontratado subcontratado) {
		this.subcontratado = subcontratado;
	}

}
package modelo.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


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

	//uni-directional many-to-one association to Proyecto
		@ManyToOne
		@JoinColumn(name="id_proyecto")
		private Proyecto proyecto;

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

	public Proyecto getIdProyecto() {
		return this.proyecto;
	}

	public void setIdProyecto(Proyecto idProyecto) {
		this.proyecto = proyecto;
	}

	public Subcontratado getSubcontratado() {
		return this.subcontratado;
	}

	public void setSubcontratado(Subcontratado subcontratado) {
		this.subcontratado = subcontratado;
	}

	public SubcontratadosConProyecto(int numeroOrden, Date fechaIncorporacion, int horasAsignadas, Proyecto proyecto,
			Subcontratado subcontratado) {
		super();
		this.numeroOrden = numeroOrden;
		this.fechaIncorporacion = fechaIncorporacion;
		this.horasAsignadas = horasAsignadas;
		this.proyecto = proyecto;
		this.subcontratado = subcontratado;
	}

	@Override
	public String toString() {
		return "SubcontratadosConProyecto [numeroOrden=" + numeroOrden + ", fechaIncorporacion=" + fechaIncorporacion
				+ ", horasAsignadas=" + horasAsignadas + ", proyecto=" + proyecto + ", subcontratado="
				+ subcontratado + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(numeroOrden);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubcontratadosConProyecto other = (SubcontratadosConProyecto) obj;
		return numeroOrden == other.numeroOrden;
	}
	public double costeHorasAsignadas() {
		double precio_por_hora =subcontratado.getIdPerfil().getTasaStandard();
		return precio_por_hora*horasAsignadas;
	}
}
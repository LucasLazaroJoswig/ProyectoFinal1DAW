package modelo.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the subcontratados database table.
 * 
 */
@Entity
@Table(name="subcontratados")
@NamedQuery(name="Subcontratado.findAll", query="SELECT s FROM Subcontratado s")
public class Subcontratado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_sub")
	private String idSub;

	private String apellidos;

	@Column(name="id_perfil")
	private int idPerfil;

	private String nombre;

	//bi-directional many-to-one association to SubcontratadosConProyecto
	@OneToMany(mappedBy="subcontratado")
	private List<SubcontratadosConProyecto> subcontratadosConProyectos;

	public Subcontratado() {
	}

	public String getIdSub() {
		return this.idSub;
	}

	public void setIdSub(String idSub) {
		this.idSub = idSub;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getIdPerfil() {
		return this.idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<SubcontratadosConProyecto> getSubcontratadosConProyectos() {
		return this.subcontratadosConProyectos;
	}

	public void setSubcontratadosConProyectos(List<SubcontratadosConProyecto> subcontratadosConProyectos) {
		this.subcontratadosConProyectos = subcontratadosConProyectos;
	}

	public SubcontratadosConProyecto addSubcontratadosConProyecto(SubcontratadosConProyecto subcontratadosConProyecto) {
		getSubcontratadosConProyectos().add(subcontratadosConProyecto);
		subcontratadosConProyecto.setSubcontratado(this);

		return subcontratadosConProyecto;
	}

	public SubcontratadosConProyecto removeSubcontratadosConProyecto(SubcontratadosConProyecto subcontratadosConProyecto) {
		getSubcontratadosConProyectos().remove(subcontratadosConProyecto);
		subcontratadosConProyecto.setSubcontratado(null);

		return subcontratadosConProyecto;
	}

}
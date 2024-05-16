package modelo.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;


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

	//uni-directional many-to-one association to Perfil
		@ManyToOne
		@JoinColumn(name="id_perfil")
		private Perfil perfil;

	private String nombre;

	
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

	public Perfil getIdPerfil() {
		return this.perfil;
	}

	public void setIdPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String nombreCompleto() {
		String nombreCompleto=nombre +" "+ apellidos;
		return nombreCompleto;
	}

	public Subcontratado(String idSub, String apellidos, Perfil perfil, String nombre) {
		super();
		this.idSub = idSub;
		this.apellidos = apellidos;
		this.perfil = perfil;
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Subcontratado [idSub=" + idSub + ", apellidos=" + apellidos + ", idPerfil=" + perfil + ", nombre="
				+ nombre + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idSub);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subcontratado other = (Subcontratado) obj;
		return Objects.equals(idSub, other.idSub);
	}

	

	

}
package modelo.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Objects;


/**
 * The persistent class for the perfiles database table.
 * 
 */
@Entity
@Table(name="perfiles")
@NamedQuery(name="Perfil.findAll", query="SELECT p FROM Perfil p")
public class Perfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_perfil")
	private int idPerfil;

	private String nombre;

	@Column(name="tasa_standard")
	private double tasaStandard;

	public Perfil() {
	}
	

	public Perfil(int idPerfil, String nombre, double tasaStandard) {
		super();
		this.idPerfil = idPerfil;
		this.nombre = nombre;
		this.tasaStandard = tasaStandard;
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

	public double getTasaStandard() {
		return this.tasaStandard;
	}

	public void setTasaStandard(double tasaStandard) {
		this.tasaStandard = tasaStandard;
	}

	@Override
	public String toString() {
		return "Perfil [idPerfil=" + idPerfil + ", Nombre=" + nombre + ", Tasa Standard=" + tasaStandard + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPerfil);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Perfil other = (Perfil) obj;
		return idPerfil == other.idPerfil;
	}
	

}
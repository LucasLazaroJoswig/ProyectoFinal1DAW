package modelo.entidades;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;


/**
 * The persistent class for the empleados database table.
 * 
 */
@Entity
@Table(name="empleados")
@NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_empl")
	private int idEmpl;

	private String apellidos;

	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ingreso")
	private Date fechaIngreso;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	private String genero;

	private String nombre;

	private String password;

	private double salario;

	//uni-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name="id_depar")
	private Departamento departamento;

	//uni-directional many-to-one association to Perfil
	@ManyToOne
	@JoinColumn(name="id_perfil")
	private Perfil perfil;

	//bi-directional many-to-one association to Proyecto
	@OneToMany(mappedBy="empleado")
	private List<Proyecto> proyectos;

	public Empleado() {
	}
	
	
	public Empleado(int idEmpl, String apellidos, String email, Date fechaIngreso, Date fechaNacimiento, String genero,
			String nombre, String password, double salario, Departamento departamento, Perfil perfil,List<Proyecto> proyectos) {
		super();
		this.idEmpl = idEmpl;
		this.apellidos = apellidos;
		this.email = email;
		this.fechaIngreso = fechaIngreso;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
		this.nombre = nombre;
		this.password = password;
		this.salario = salario;
		this.departamento = departamento;
		this.perfil = perfil;
		this.proyectos = proyectos;
	}


	public int getIdEmpl() {
		return this.idEmpl;
	}

	public void setIdEmpl(int idEmpl) {
		this.idEmpl = idEmpl;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getSalario() {
		return this.salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public List<Proyecto> getProyectos() {
		return this.proyectos;
	}

	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

	public Proyecto addProyecto(Proyecto proyecto) {
		getProyectos().add(proyecto);
		proyecto.setEmpleado(this);

		return proyecto;
	}

	public Proyecto removeProyecto(Proyecto proyecto) {
		getProyectos().remove(proyecto);
		proyecto.setEmpleado(null);

		return proyecto;
	}

	@Override
	public String toString() {
		return "Empleado [idEmpl=" + idEmpl + ", Apellidos=" + apellidos + ", Nombre=" + nombre+
				", Email=" + email + ", Fecha Ingreso="+ fechaIngreso + ", Fecha Nacimiento=" + fechaNacimiento + 
				", Género=" + genero +  ", Password=" + password + ", Salario=" + salario + ", Departamento=" + departamento + ", Perfil="
				+ perfil + ", Proyectos=" + proyectos + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idEmpl);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return idEmpl == other.idEmpl;
	}
	public double salarioBruto() {

		return this.salario;
	}
	public String literalSexo() {
		switch (genero) {
		case "H": {
			return "Hombre";
		}
		case "M":{
			return "Mujer";
		}
		default:
			return "El empleado no tiene el genero asignado con el formato adecuado: H o M";
		}
	}
	public double salarioMensual(int meses) {
		
		double salarioBruto = salario;
		double salarioMensual = salarioBruto / meses;
		return salarioMensual;
	}
	public String obtenerEmail() {
		return nombre.substring(0,1).toLowerCase()+ apellidos.split(" ")[0].toLowerCase();
		
	}
	public String nombreCompleto() {
		String nombreCompleto=nombre +" "+ apellidos;
		return nombreCompleto;
	}

	
}
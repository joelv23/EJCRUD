package Modelo;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column (name = "firstname", length = 40)
    private String nombre;

    @Column(name = "lastname", length = 40)
    private String apellido;

    @Column(name = "mail", nullable = false, length = 50, unique = true)
    private String email;

    public Usuario() {

    }

    public Usuario(String nombre, String apellido, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

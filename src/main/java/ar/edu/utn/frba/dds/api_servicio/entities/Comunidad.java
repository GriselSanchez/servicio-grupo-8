package ar.edu.utn.frba.dds.api_servicio.entities;

import java.util.List;

public class Comunidad {
  private Long id;
  private String nombre;
  private String descripcion;
  private GradoDeConfiabilidad gradoDeConfiabilidad;
  private Double puntosDeConfianza;
  private List<Usuario> usuarios;
  private Boolean activo;


  public Comunidad(String nombre, List <Usuario> usuarios) {
    super();
    this.nombre = nombre;
    this.usuarios = usuarios;
    this.puntosDeConfianza = 5.0;
  }
  public Comunidad() {
    super();
  }

  public Double getPuntosDeConfianza() {
    return puntosDeConfianza;
  }

  public void setPuntosDeConfianza(Double puntosDeConfianza) {
    this.puntosDeConfianza = puntosDeConfianza;
  }

  public GradoDeConfiabilidad getGradoDeConfiabilidad() {
    return gradoDeConfiabilidad;
  }

  public void setGradoDeConfiabilidad(GradoDeConfiabilidad gradoDeConfiabilidad) {
    this.gradoDeConfiabilidad = gradoDeConfiabilidad;
  }

  public List<Usuario> getUsuarios() {
    return usuarios;
  }

  public void setUsuarios(List<Usuario> usuarios) {
    this.usuarios = usuarios;
  }

  public Comunidad(String nombre, String descripcion) {
    super();
    this.nombre = nombre;
    this.descripcion = descripcion;
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

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }
}

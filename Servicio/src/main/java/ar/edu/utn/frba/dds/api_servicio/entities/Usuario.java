package ar.edu.utn.frba.dds.api_servicio.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario {

  private Long id;
  private String nombre;
  private Double puntosDeConfianza;
  private GradoDeConfiabilidad gradoConfiabilidad;
  private List<Incidente> incidentes;
  private Boolean activo;

  public Boolean getActivo() {
    return activo;
  }

  public void setActivo(Boolean activo) {
    this.activo = activo;
  }

  public GradoDeConfiabilidad getGradoConfiabilidad() {
    return gradoConfiabilidad;
  }

  public void setGradoConfiabilidad(GradoDeConfiabilidad gradoConfiabilidad) {
    this.gradoConfiabilidad = gradoConfiabilidad;
  }

  public List<Incidente> getIncidentes() {
    return incidentes;
  }

  public void setIncidentes(List<Incidente> incidentes) {
    this.incidentes = incidentes;
  }

  public Usuario(String nombre, List <Incidente> incidentes) {
    super();
    this.nombre = nombre;
    this.incidentes = incidentes;
    this.puntosDeConfianza = 5.0;
  }

  public Double getPuntosDeConfianza() {
    return puntosDeConfianza;
  }

  public void setPuntosDeConfianza(Double puntosDeConfianza) {
    this.puntosDeConfianza = puntosDeConfianza;
  }

  public Usuario() {
    super();
    this.puntosDeConfianza = 5.0;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Usuario usuario = (Usuario) o;
    return Objects.equals(nombre, usuario.nombre);
  }

}
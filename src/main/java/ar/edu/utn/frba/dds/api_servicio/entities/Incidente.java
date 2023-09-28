package ar.edu.utn.frba.dds.api_servicio.entities;

import java.time.LocalDateTime;
import java.util.Objects;

public class Incidente {
  private Long id;
  private String descripcion;
  private Boolean cerrado;
  private Usuario usuarioApertura;
  private Usuario usuarioCierre;
  private LocalDateTime fechaApertura;
  private LocalDateTime fechaCierre;

  public Incidente(String descripcion, Usuario usuarioApertura, Usuario usuarioCierre, LocalDateTime fechaApertura, LocalDateTime fechaCierre) {
    super();
    this.descripcion = descripcion;
    this.usuarioApertura = usuarioApertura;
    this.usuarioCierre = usuarioCierre;
    this.fechaApertura = fechaApertura;
    this.fechaCierre = fechaCierre;
  }

  public Incidente() {
    super();
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public Usuario getUsuarioApertura() {
    return usuarioApertura;
  }

  public void setUsuarioApertura(Usuario usuarioApertura) {
    this.usuarioApertura = usuarioApertura;
  }

  public Usuario getUsuarioCierre() {
    return usuarioCierre;
  }

  public void setUsuarioCierre(Usuario usuarioCierre) {
    this.usuarioCierre = usuarioCierre;
  }

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }


  public LocalDateTime getFechaApertura() {
    return fechaApertura;
  }

  public void setFechaApertura(LocalDateTime fechaApertura) {
    this.fechaApertura = fechaApertura;
  }

  public LocalDateTime getFechaCierre() {
    return fechaCierre;
  }

  public void setFechaCierre(LocalDateTime fechaCierre) {
    this.fechaCierre = fechaCierre;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Incidente incidente = (Incidente) o;
    return Objects.equals(id, incidente.id);
  }
  public boolean tieneMismaDescripcion(Incidente otroIncidente) {
    return Objects.equals(this.descripcion, otroIncidente.descripcion);
  }
}

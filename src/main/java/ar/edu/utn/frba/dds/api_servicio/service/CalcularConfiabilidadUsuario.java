package ar.edu.utn.frba.dds.api_servicio.service;

import ar.edu.utn.frba.dds.api_servicio.entities.GradoDeConfiabilidad;
import ar.edu.utn.frba.dds.api_servicio.entities.Incidente;
import ar.edu.utn.frba.dds.api_servicio.entities.Usuario;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

import java.time.Duration;
import java.util.List;

public class CalcularConfiabilidadUsuario {
  public Boolean actualizarActividadUsuario(Usuario usuario){
      return actualizarGradoConfiabilidad(usuario) != GradoDeConfiabilidad.NO_CONFIABLE;
  }

  public GradoDeConfiabilidad actualizarGradoConfiabilidad(Usuario usuario){
    Double puntaje = usuario.getPuntosDeConfianza();
    if(puntaje<2){
        return GradoDeConfiabilidad.NO_CONFIABLE;
    }else if (puntaje>=2 && puntaje<=3){
        return GradoDeConfiabilidad.CON_RESERVAS;
    } else if (puntaje>3 && puntaje<5) {
        return GradoDeConfiabilidad.CONFIABLE_NIVEL_1;
    } else {
      return  GradoDeConfiabilidad.CONFIABLE_NIVEL_2;
    }
  }

  public Double actualizarPuntajeConfianza(Usuario usuario) {
    List <Incidente> incidentes = usuario.getIncidentes();

    incidentes.stream().forEach(incidente ->
                                descontarPuntaje(usuario,
                                puntosDeConfianza(incidentes,
                                incidente, usuario)));

    return usuario.getPuntosDeConfianza();
  }

  public Double puntosDeConfianza(List <Incidente> incidentes, Incidente incidente, Usuario usuario){
      if (esAperturaFraudulenta(incidente) || esCierreFraudulento(incidente, incidentes, usuario)){
          return 0.2;
      }else{
        if(esIncidenteSemanal(incidente)){
          return -0.5;
        }
      }
      return 0.0;
  }
  private boolean esIncidenteSemanal(Incidente incidente) {
    LocalDate now = LocalDate.now();
    LocalDate inicioDeLaSemana = now.with(DayOfWeek.MONDAY);
    LocalDate finDeLaSemana = now.with(DayOfWeek.SUNDAY);

    return !incidente.getFechaApertura().toLocalDate().isBefore(inicioDeLaSemana) &&
        !incidente.getFechaCierre().toLocalDate().isAfter(finDeLaSemana);
  }

  private boolean esCierreFraudulento(Incidente incidente1, Collection<Incidente> todosLosIncidentes, Usuario usuario) {
    for (Incidente incidente2 : todosLosIncidentes) {
      if (esCierreFraudulento(incidente1, incidente2, usuario)) {
        return true;
      }
    }
    return false;
  }

  private boolean esAperturaFraudulenta(Incidente incidente) {
    Long diferencia = obtenerDiferencia(incidente.getFechaApertura(), incidente.getFechaCierre());
    return diferencia < 3 && incidente.getUsuarioApertura().equals(incidente.getUsuarioCierre());
  }
  private boolean esCierreFraudulento(Incidente incidente1, Incidente incidente2, Usuario usuarioActual) {
    long diferencia = obtenerDiferencia(incidente1.getFechaCierre(), incidente2.getFechaApertura());

    return diferencia < 3 &&
        !incidente1.equals(incidente2) &&
        incidente1.tieneMismaDescripcion(incidente2) &&
        incidente1.getUsuarioCierre().equals(usuarioActual);
  }

  private Long obtenerDiferencia(LocalDateTime unaFecha, LocalDateTime otraFecha) {
    return Duration.between(unaFecha, otraFecha).toMinutes();
  }
  private void descontarPuntaje(Usuario usuario, Double puntos) {
     usuario.setPuntosDeConfianza(usuario.getPuntosDeConfianza() - puntos);
  }

}


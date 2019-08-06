package co.com.ajac.ports;


import co.com.ajac.entities.residentes.Residente;
import co.com.ajac.entities.residentes.habitantes.Habitante;
import coremodel.datosbasicos.Identificacion;
import io.vavr.control.Option;

public interface ResidenteRepository {
	
	Residente guardarResidenteCompleto(Residente resident);
	
	Habitante guardarHabitanteCompleto(Habitante resident);
	
	boolean verificarExistenciaDeAlgunaPersonaPorSuIdentificacion(Identificacion identification);
	
	boolean verificarExistenciaDeAlgunaPersonaPorSuHuellaDigital(String huella);
	
	boolean verificarExistenciaDeAlgunaPersonaPorSuCodigoseguridad(String codigoSeguridad);
	
	Option<Residente> obtenerResidentePorSuIdentificacion(Identificacion identification);

}

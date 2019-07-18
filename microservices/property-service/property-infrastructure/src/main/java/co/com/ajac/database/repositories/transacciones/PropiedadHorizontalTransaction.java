package co.com.ajac.database.repositories.transacciones;

import org.jdbi.v3.sqlobject.CreateSqlObject;
import org.jdbi.v3.sqlobject.transaction.Transaction;

import co.com.ajac.database.repositories.propiedadhorizontal.administrador.AdministradorDAO;
import co.com.ajac.database.repositories.propiedadhorizontal.propiedadhorizontal.PropiedadHorizontalDAO;
import co.com.ajac.database.repositories.propiedadhorizontal.propiedadhorizontal.PropiedadHorizontalRecord;


public interface PropiedadHorizontalTransaction {

	@CreateSqlObject
	AdministradorDAO administradorDAO();
	
	@CreateSqlObject
	PropiedadHorizontalDAO propiedadHorizontalDAO();
	
	@Transaction
	default PropiedadHorizontalRecord guardarPropiedadHorizontalCompleta(PropiedadHorizontalRecord propiedadHorizontalRecord) {
		
		propiedadHorizontalDAO().registrarPropiedadHorizontal(propiedadHorizontalRecord);
		administradorDAO().registrarAdministradorDeUnaPropiedadHorizontal(
				propiedadHorizontalRecord.getAdministrador());
		
		return propiedadHorizontalRecord;
	}
}

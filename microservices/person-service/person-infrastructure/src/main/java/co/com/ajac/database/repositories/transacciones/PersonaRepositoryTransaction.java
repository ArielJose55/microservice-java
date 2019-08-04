package co.com.ajac.database.repositories.transacciones;

import org.jdbi.v3.sqlobject.CreateSqlObject;
import org.jdbi.v3.sqlobject.transaction.Transaction;

import co.com.ajac.database.repositories.personanatural.PersonaNaturalDAO;
import co.com.ajac.database.repositories.residente.ResidenteDAO;
import co.com.ajac.database.repositories.residente.ResidenteRecord;
import co.com.ajac.database.repositories.usuario.UsuarioDAO;
import co.com.ajac.database.repositories.usuario.UsuarioRecord;

public interface PersonaRepositoryTransaction {

	@CreateSqlObject
	PersonaNaturalDAO personaNaturalDAO();
	
	@CreateSqlObject
	UsuarioDAO usuarioDAO();
	
	@CreateSqlObject
	ResidenteDAO residenteDAO();
	
	@Transaction
	default UsuarioRecord guardarUsuarioCompleto(UsuarioRecord usuarioRecord) {
		
		personaNaturalDAO().registrarPersonaNatural(usuarioRecord.getPersonaNaturalRecord());
		
		usuarioDAO().registrarUsuario(usuarioRecord);
		
		return usuarioRecord;
	}
	
	@Transaction
	default ResidenteRecord guardarPersonaCompleto(ResidenteRecord residenteRecord) {
		
		personaNaturalDAO().registrarPersonaNatural(residenteRecord.getPersonaNaturalRecord());
		
		residenteDAO().registrarResidente(residenteRecord);
	
		return residenteRecord;
		
	}
}

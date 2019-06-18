package co.com.ajac.ports;

import co.com.ajac.models.PeatonalAccess;
import io.vavr.control.Option;

public interface PeatonalAccessRegisterRepository {

	Option<Integer> registerAccessPeatonal(PeatonalAccess peatonalAccess);
}
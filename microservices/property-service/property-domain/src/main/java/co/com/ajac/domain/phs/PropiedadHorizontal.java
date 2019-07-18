package co.com.ajac.domain.phs;



import co.com.ajac.domain.cps.CommonProperty;
import co.com.ajac.domain.pps.PrivateProperty;
import io.vavr.collection.List;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@RequiredArgsConstructor
@ToString
public class PropiedadHorizontal {
	
	private final String nit;
	
	private final String nombreDistintivo;
	
	private final Administrador administrador;
	
	private final List<CommonProperty> bienesCommunes;
	
	private final List<PrivateProperty> bienesPrivados;

}

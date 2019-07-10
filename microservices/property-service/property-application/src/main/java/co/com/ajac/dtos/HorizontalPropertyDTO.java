package co.com.ajac.dtos;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor

public class HorizontalPropertyDTO {
	
	private final Integer id;
	private final String numId;
	private final String typeId;
	private final String nameDistintive;
	private final String socialObjective;
	private final String businessName;
	private final List<CommonPropertyDTO> commonProperties;

}

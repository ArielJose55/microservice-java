package co.com.ajac.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class CommonPropertyDTO {
		private final Integer id;
		private final String name;
		private final Boolean essential;
}

package coremodel;

import java.util.Arrays;

public enum TypePhone {
	MOBILE("Celular"),
	PHONE("Fijo");
	
	private final String description;

	private TypePhone(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
	public static TypePhone getTypePhone(String description) {
		return Arrays.asList(TypePhone.values())
			.stream()
			.filter(type -> description != null && description.compareTo("") != 0 && description.equalsIgnoreCase(type.getDescription()))
			.findFirst()
			.orElseThrow(() -> new BusinessException("No exite ningun tipo de telefono con esta descripcion"));
	}
	
}
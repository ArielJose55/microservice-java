package co.com.ajac.endpoints;

import co.com.ajac.commands.RegistrarResidenteCommand;
import co.com.ajac.queries.PersonQueryResource;

//@RestController
//@RequestMapping("/residents")
public class ResidentController {
	
	private final RegistrarResidenteCommand createResident;
	
	private final PersonQueryResource personQueryResource;
		
	//@Autowired
	public ResidentController(RegistrarResidenteCommand createResident, PersonQueryResource personQueryResource) {
		this.createResident = createResident;
		this.personQueryResource = personQueryResource;
	}

//	@PostMapping
//	public void add(@Valid @RequestBody Residente resident) {
//		createResident.execute(resident);
//	}
//	
//	@GetMapping("/{id}")
//	public Residente get(@PathVariable("id") String identification) {
//		return personQueryResource.findOneResidentByIdentification(identification);
//	}
//	
//	@GetMapping("/hp/{id}")
//	public List<Residente> getAll(@PathVariable("id") Integer idHp){
//		return personQueryResource.findAllResidentByHorizontalProperty(idHp);
//	}
	
}
# Rest
## Person-service

### Usuario
#### Login

**URL**: http://localhost:8001/person/api/v1/users/login

**Body request**:

En el caso que sea ADMIN entonces treera las propiedades horizontales que administra
```json
{
	"username": "fnica",
	"password": "0002"
}
```
**Response**
```json
{
  "numeroIdentificacion": "111100",
  "tipoIdentificacion": "CC",
  "username": "fnica",
  "password": "0002",
  "segundoNombre": "Corona",
  "primerApellido": "Nicasio",
  "segundoApellido": "Aguila",
  "nombreCompleto": "Nicasio Aguila Nicasio Aguila",
  "tipoUsuario": "ADM",
  "estadoUsuario": "AC",
  "propiedades": [
    {
      "nit": "150",
      "nombreDistintivo": "Pinar del Rio 1",
      "objetoSocial": "Propiedad horizontal para pobres",
      "razonSocial": "PH Pinar del Rio 1"
    },
    {
      "nit": "151",
      "nombreDistintivo": "Pinar del Rio 2",
      "objetoSocial": "Propiedad horizontal para ricos",
      "razonSocial": "PH Pinar del Rio 2"
    },
    {
      "nit": "152",
      "nombreDistintivo": "Pinar del Rio 3",
      "objetoSocial": "Propiedad horizontal para ricos indefensos",
      "razonSocial": "PH Pinar del Rio 3"
    }
  ]
}
```
#### Obtiene usuario

**GET** - **URL**: http://localhost:8001/person/api/v1/users/"tipoId"/"numID"

Ejemplo: http://localhost:8001/person/api/v1/users/CC/205144710

Respuesta:
```json
{
  "numeroIdentificacion": "205144710",
  "tipoIdentificacion": "CC",
  "username": "Juiti",
  "password": "0001",
  "segundoNombre": "Meza",
  "primerApellido": "Julianiti",
  "segundoApellido": "Alvarez",
  "nombreCompleto": "Julianiti Alvarez Julianiti Alvarez",
  "tipoUsuario": "AUX",
  "estadoUsuario": "AC"
}
```

### Registra usuario
**GET** - **URL**:<br>
http://localhost:8001/person/api/v1/users

**Body**<br>
```json
{
	"username": <String>,
	"password": <String>,
	"numeroIdentificacion": <String>,
	"tipoIdentificacion": <String>,
	"primerNombre": <String>,
	"segundoNombre": <String>,
	"primerApellido": <String>,
	"segundoApellido": <String>,
	"tipoUsuario": <String>,
}
```
Ejemplo:
```json
{
	"username": "feliciano",
	"password": "0003",
	"numeroIdentificacion": "1111",
	"tipoIdentificacion": "CC",
	"primerNombre": "Feliciano",
	"segundoNombre": "Federico",
	"primerApellido": "Corona",
	"segundoApellido":"Aguila",
	"tipoUsuario": "RDT"
}
```
## Propiedades

### Propiedad Comun
### Registrar nueva propiedad comun
* **POST** - **URL**<br>
http://localhost:8000/property/api/v1/phs/pcs
* **Body request**<br>
```json
{
"nombre":<String>,
"esencial": <Boolean>,
"propiedadHorizontal": <String>
}
```
+ **Ejemplo**<br>
```json
{
"nombre":"Parqueadero",
"esencial": false,
"propiedadHorizontal": "150"
}
```
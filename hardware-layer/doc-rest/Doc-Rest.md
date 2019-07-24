# Rest
## Person-service

### Usuario
+ Login

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
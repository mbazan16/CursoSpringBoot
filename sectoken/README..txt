Para probar este proyecto se debe utilizar una aplicación tipo Postman o SOAPUI  y realizar el siguiente proceso:


* Primero se lanzará esta petición GET/POST http://localhost:8080/authenticate
Con el siguiente fichero JSON en el Body del request:
{
	"username":"admin",
	"password":"admin"
}

Esto nos devolverá un response status 200 OK y en el Headers en Autorization estará el token:"Bearer ...."

* Segundo se lanzará la petición GET http://localhost:8080/users, antes de eso en el Headers se seleccionara
 la Key Authorization y como valor se copiará todo el token "Bearer ....". Ahora lanzamos la petición
 
 De resultado nos devolverá un response status 200 OK y en el body:
 [
    {
        "id": 1,
        "name": "Paco"
    },
    {
        "id": 2,
        "name": "Pedro"
    },
    {
        "id": 3,
        "name": "Juan"
    }
]
 


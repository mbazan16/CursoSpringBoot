Para probar este proyecto se debe utilizar  la aplicación Postman o soapUI:

* Primero se configura  una petición POST  localhost:8080/oauth/token
  Autorizacion: Basica username:cliente password: password
  Body en formato x-www-form-urlencoder
  password secret
  username user  
  grant_type password 
  
  "user" es el usuario para el cual necesitamos el token va a tener el rol "USER"
  si cambiamos el valor a admin, en nuestro proyecto, va a tener el rol "ADMIN"
  
  Se lanza la petición y nos devuelve 
  {
    "access_token": "a29e00df-94fb-4521-8612-97967fb577f5",
    "token_type": "bearer",
    "refresh_token": "6dcaa0e9-7527-4f9d-9ca5-e40c05da6f71",
    "expires_in": 43199,
    "scope": "read write"
}
El token a utilizar es:a29e00df-94fb-4521-8612-97967fb577f5

* Segundo se configura una petición GET localhost:8080/privada
  Autorizacion: Basica username:user password: secret
  En Header, con key Authorization introducimos como valor Bearer <token> 
  El token generado con user
  
  Se lanza la petición se nos muestra "Pagina privada"
  , si quitamos el token o probamos con otros usuarios no nos permite el acceso.
  
  
 
Para  ejecutar este proyecto es necesario utilizar un certificado, para ello debemos seguir los siguientes pasos:
* Generar el certificado
keytool -genkeypair -alias tomcat -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore keystore.p12 -validity 3650 -storepass password
keytool -genkeypair -alias mycertificate -keyalg RSA -keysize 2048 -keystore keystore.jks -validity 3650 -storepass password

*Verificar el certificado
keytool -list -v -storetype pkcs12 -keystore keystore.p12
keytool -list -v -keystore keystore.jks

---------------------------------------------------------------------------------------------------------------------------------
Para permitir conexion inseguras localhost, en la barra de navegación : chrome://flags/#allow-insecure-localhost


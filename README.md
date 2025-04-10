Desafio Usuarios

- Se genera una base de datos en memoria de manera automatica, con las tablas que estan en el package dto del proyecto.
- Existe un archivo data.sql, en el que se hace un insert a la base de datos creada para guardar la expresion regular para validar el email
- Se disponibiliza un endpoint para actualizar la expresion regular de validacion de email
- Para ingresar a ver la DB http://localhost:8080/h2-ui/ usuario y pass definidas en application.properties
- Especificacion del api http://localhost:8080/swagger-ui/index.html
- Se deja en la raiz del proyecto el diagrama de secuencia de los controller disponibles
- Se uso JWT para la generacion de token, pero a la Api no se le agrego validacion. 
- Se agrega un collection para abrir desde postman los endpoint disponibles.
- Se recomienda el uso de intellij para levantar el proyecto


- Para realizar las pruebas se debe ejecutar desde intellIj carpeta test, seleccionar carpeta java con boton derecho, Run Test in usuarios.


- Para levantar local en IntellIj seleccionar en la configuracion UsuariosApplication y dar run, esto deberia levantar el proyecto y crear base de datos, luego abrir el archivo Usuarios.postman_collection.json con postman y se puede ejecutar con los endpoint de pruebas ya cargados.
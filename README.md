# ArquitecturasTudai2024G25
TPE Arquitecturas Web Tudai 2024 grupo 25

## Guia para configuracion y funcionamiento del proyecto

### Requisitos: 
    DOCKER: Se utiliza el archivo mySQLdocker.yml para levantar el servidor
    YSQL WORKBENCH : interfaz grafica para la base de datos.


### Archivos de configuración:
    ArquitecturasTp1Tudai2024/mySQLdocker.yml (manejo de contenedores)
    ArquitecturasTp1Tudai2024/pom.xml (gestor de dependencias)


## Configuracion y Ejecución:
Descargado el repositorio y abierto en el ambiente de desarrollo corroborar las
siguientes configuraciónes:
 

### Levantar imagen docker mySQLdocker.yml
Ejecutar en consola desde path ArquitecturasTP1Tudai2024/ y esperar que la imagen haya sido cargada.

    docker-compose -f mySQLdocker.yml up 

### Verificar conexión con DB en mySQL WorkBrench
Abrir aplicación y crear una nueva conexión 

    dbName:dbArquiTpG25
    username: user
    userpassword: password

###### En consola ingresar las sentencias USER dbArquiTPG25 database para poder utilizar el esquema

### Ejecución
Ejecutar metodo Main, ubicado en el path ArquitecturasTP1Tudai2024/App.java.    
    
    La ejecución de esta clase procedera a crear el esquema de entidades en la base y
    completar con datos las mismas.


## Manejo de erroes de ejecución
  
    Revisar actualizaciónes y versiones de dependencias compatibles en los archivos de configuración 

    












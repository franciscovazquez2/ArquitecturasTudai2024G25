# ArquitecturasTudai2024G25
TPE Arquitecturas Web Tudai 2024 grupo 25

## Introducción
Este proyecto implementa una arquitectura basada en JDBC (Java Database Connectivity) para gestionar la conexión a bases de datos en Java, siguiendo un enfoque orientado a objetos que asegura flexibilidad, mantenibilidad y separación de responsabilidades. La arquitectura se sustenta en el uso de los patrones de diseño DAO (Data Access Object), Factory y DTO (Data Transfer Object).

## JDBC
JDBC es una API estándar que permite a las aplicaciones Java interactuar con bases de datos relacionales. A través de esta tecnología, la aplicación se conecta a una base de datos para ejecutar consultas SQL, realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar), y manejar transacciones de manera eficiente.

## Patrones de diseño
**DAO (Data Access Object):** Este patrón define una capa de abstracción que separa la lógica de acceso a los datos del resto de la aplicación. Cada entidad del sistema tiene un DAO correspondiente que contiene los métodos necesarios para interactuar con la base de datos (insertar, actualizar, eliminar, consultar).

**Factory:** Se implementa este patrón para instanciar DAOs de manera flexible, permitiendo que las diferentes implementaciones de los DAOs se manejen de forma centralizada. Esto facilita el intercambio de diferentes estrategias de acceso a datos o bases de datos sin modificar el código del cliente.

**DTO (Data Transfer Object):** Este patrón se usa para transferir datos entre las diferentes capas de la aplicación, encapsulando los datos en objetos que representan entidades de negocio. Los DTO ayudan a mejorar el rendimiento al reducir el número de llamadas entre capas y mantener la coherencia de los datos.

## Guia para configuracion y funcionamiento del proyecto

### Requisitos: 
**DOCKER**: Se utiliza el archivo mySQLdocker.yml para levantar el servidor

**MYSQL WORKBENCH** : interfaz grafica para la base de datos, tambien se puede utilizar otra interfaz desde un entorno de desarrollo(Intelijji)


### Archivos de configuración:
*ArquitecturasTp1Tudai2024/mySQLdocker.yml* (manejo de contenedores)

*ArquitecturasTp1Tudai2024/pom.xml* (gestor de dependencias)

## Configuracion y Ejecución:
Descargado el repositorio y abierto en el ambiente de desarrollo corroborar las
siguientes configuraciónes:
 
1.**Ejecutar en consola desde path ArquitecturasTP1Tudai2024/ y esperar que la imagen haya sido cargada.**

    docker-compose -f mySQLdocker.yml up 

2.**Verificar conexión con DB**
Dependiendo la interfaz utilizada, si la conexión al esquema no existe configurar: 

    dbName:dbArquiTpG25
    username: user
    userpassword: password

En consola de consultas SQL utilizada ingresar la sentencia ***USER dbArquiTPG25 database***  para poder utilizar el esquema

## Ejecución

**Breve explicaciónn**-Este programa por medio de una conexión JDBC nombrada en la *Introducción* con una base de datos, en principio ejecuta un metodo de inicialización que conecta el Driver, se genera la conexión, creación de esquema y carga de datos.
Por ultimó procede a mostrar por consola dos consultas a la base.

Ejecutar metodo Main, ubicado en *ArquitecturasTP1Tudai2024/App.java*    
    
    La ejecución de esta clase procedera a crear el esquema de entidades en la base y
    completar con datos las mismas.

```java
        public static void main(String[] args) throws SQLException {
        
        ConnectionMYQSL.getConnection();

        InitializeJDBC.createSchema();
        InitializeJDBC.loadTables();
             
            System.out.println("Clientes mas facturados");

            List<ClientMaxFactureDTO>clientesMasFacturados = MYSQLClientDAO.getInstance().selectMaxFacture();

            for (ClientMaxFactureDTO c : clientesMasFacturados){
                System.out.println(c.toString());
            }

            System.out.println("Product Collected");

            List<ProductColletedDTO>productCollected = MYSQLProductDAO.getInstance().selectMostProductColleted();

            for (ProductColletedDTO c : productCollected){
                System.out.println(c.toString());
            }

        ConnectionMYQSL.closeConnection();
    }
```

## Manejo de erroes de ejecución

    Revisar actualizaciónes y versiones de dependencias compatibles en los archivos de configuración 













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

# Estructura del Proyecto
Este proyecto está organizado en varios paquetes dentro de la carpeta src/main/java, cada uno con responsabilidades específicas. A continuación, se describe brevemente el propósito de cada uno:

![image](https://github.com/user-attachments/assets/ad8f4b6e-b9cc-46c2-8dae-d557997bc394)

**csvFiles:** Contiene los archivos CSV que se utilizan para cargar datos iniciales en la base de datos. Estos archivos son leídos y procesados para poblar las tablas.

**dao:** Este paquete contiene las clases que implementan el patrón DAO (Data Access Object). Cada DAO es responsable de la interacción con la base de datos para una entidad específica, proporcionando métodos como insertar, actualizar, eliminar y consultar datos.

**dto:** Aquí se encuentran los Data Transfer Objects (DTOs). Estas clases encapsulan los datos que se transfieren entre las capas de la aplicación, evitando la sobrecarga de múltiples llamadas a la base de datos.

**entity:** Este paquete contiene las clases que representan las entidades del dominio del negocio. Estas clases mapean las tablas de la base de datos y definen los atributos correspondientes.

**factory:** Contiene las implementaciones del patrón Factory, el cual se encarga de crear las instancias de los DAOs. Esto permite manejar de forma centralizada la creación de objetos, facilitando la escalabilidad y el mantenimiento del código. Tambíen se encuentra en este paquete la clase Factory que permite crear daos segun el modelo de persistencia que se desee utilizar, para este proyecto MYSQL.

**initialize:** Aquí se encuentran las clases encargadas de inicializar la base de datos. Estas clases contienen métodos para crear el esquema de la base de datos.

**org.example:** Aquí se podría ubicar el punto de entrada de la aplicación (App.java) o utilidades comunes.

**schemaDataBase:** Paquete que contiene la estructura del esquema de la base de datos, asegurando que las definiciones de las tablas y relaciones estén correctamente implementadas.

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

    Ejecutar metodo Main, ubicado en *ArquitecturasTP1Tudai2024/src/java/org.example/App.java*    
    
La ejecución de esta clase procedera a crear el esquema de entidades en la base y
completar con datos las mismas.

```java
    public static void main(String[] args) throws SQLException {

    ConnectionMYQSL.getConnection();

    InitializeJDBC.createSchema();
    InitializeJDBC.loadTables();

    System.out.println("\nEl producto que mas recaudo es: "); //Ejercicio 3

    List<ProductColletedDTO>productCollected = MYSQLProductDAO.getInstance().selectMostProductColleted();

    for (ProductColletedDTO c : productCollected){
        System.out.println(c.toString());
    }

    System.out.println("\nClientes mas facturados: "); //Ejercicio 4

    List<ClientMaxFactureDTO>clientesMasFacturados = MYSQLClientDAO.getInstance().selectMaxFacture();

    for (ClientMaxFactureDTO c : clientesMasFacturados){
        System.out.println(c.toString());
    }

    ConnectionMYQSL.closeConnection();
}
```

## Manejo de erroes de ejecución

Revisar actualizaciónes y versiones de dependencias compatibles en los archivos de configuración

Los paths correspondientes a la lectura de archivos CSV para la carga de datos en la base, se encuentran en la clase
CSVreader ubicado en src/main/java/csvFiles y fueron testeados con rutas relativas.
    
   ```java
       private static final String PATH="ArquitecturasTp1Tudai2024/src/main/java/csvFiles/";
   ```
    
Si el sistema arroja que no encuentra en el sistema el archivo de lectura, utilizar una ruta absoluta.
    

## Conclusión
Este proyecto implementa una solución robusta y eficiente para la gestión de datos utilizando una arquitectura basada en JDBC, apoyada por patrones de diseño como DAO, Factory y DTO. La integración con MySQL a través de Docker permite un entorno de desarrollo fácilmente replicable y adaptable a diferentes configuraciones. Con un enfoque orientado a objetos, el código es flexible y escalable, asegurando que futuras modificaciones o ampliaciones puedan ser implementadas sin grandes refactorizaciones









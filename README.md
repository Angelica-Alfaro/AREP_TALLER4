# Escuela Colombiana de Ingeniería Julio Garavito

# Modularización con virtualización e introducción a Docker y AWS

#### Autor🙎
> - María Angélica Alfaro Fandiño

#### 🔎 Descripción
Construcción de la aplicación web **APP-LB-RoundRobin** usando el micro-framework de Spark con dos servicios **LogService** y **MongoDB**. Se crea un contenedor en Docker para aplicación, se sube la imagen a un repositorio en DockerHub y finalmente en una máquina virtual de AWS se despliega el contenedor anteriormente creado. 

## 🛠️ Arquitectura y diseño detallado de la aplicación
El proyecto está compuesto por:

- El servicio **MongoDB**, que es una instancia de MongoDB corriendo en un contenedor de Docker en una máquina virtual de EC2. El servicio corre por el puerto ***27017***.

- El **LogService**, es un servicio REST que recibe una cadena, la almacena en la base de datos y responde en un objeto JSON con las 10 ultimas cadenas almacenadas en la base de datos y la fecha en que fueron almacenadas. Hay tres instancia del servicio que corren por los puertos ***33001, 33002, 33003***.

  - Cuenta con 2 endpoints:
       
     📌 ***(GET)*** /string. Obtiene de las últimas 10 cadenas almacenadas en la instancia de MongoDB con la fecha de creación .
     
     📌 ***(POST)*** /string. Almacena en la base de datos la cadena con su fecha de creación, retorna la información almacenada.

- La aplicación web **APP-LB-RoundRobin** que corre por el puerto ***36000***, está compuesta por un cliente web y un servicio REST. El cliente web a través de la acción de un botón envia los mensajes del usuario al servicio REST y actualiza la pantalla con la información que este le regresa en formato JSON. El servicio REST recibe la cadena e implementa un algoritmo de balanceo de cargas de Round Robin, delegando el procesamiento del mensaje y el retorno de la respuesta a cada una de las tres instancias del servicio **LogService**.

  - Cuenta con 2 endpoints:

       📌 ***(GET)*** /string. Permite acceder al servicio de **LogService** para obtener las últimas 10 cadenas almacenadas en la instancia de MongoDB con la          fecha de creación .

       📌 ***(POST)*** /string. Permite acceder al servicio de **LogService** para almacenar en la base de datos la cadena con su fecha de creación, retorna la          información almacenada.
       
## 💡 Herramientas utilizadas
- Maven
- Eclipse
- GitHub
- Heroku
- DockerHub
- AWl servicio de 


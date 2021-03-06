# Escuela Colombiana de Ingenier铆a Julio Garavito

# Modularizaci贸n con virtualizaci贸n e introducci贸n a Docker y AWS

#### Autor馃檸
> - Mar铆a Ang茅lica Alfaro Fandi帽o

#### 馃攷 Descripci贸n
Construcci贸n de la aplicaci贸n web **APP-LB-RoundRobin** usando el micro-framework de Spark con dos servicios **LogService** y **MongoDB**. Se crea un contenedor en Docker para aplicaci贸n, se sube la imagen a un repositorio en DockerHub y finalmente en una m谩quina virtual de AWS se despliega el contenedor anteriormente creado. 

## 馃洜锔? Arquitectura y dise帽o detallado de la aplicaci贸n

<!DOCTYPE html>
<html>
    <head></head>
    <body>
        <p align="center">
          <img src="https://github.com/Angelica-Alfaro/AREP_TALLER4/blob/master/Imgs/Dise%C3%B1o.jpeg" width="500"/>
        </p>
    </body>
</html>
El proyecto est谩 compuesto por:

- El servicio **MongoDB**, que es una instancia de MongoDB corriendo en un contenedor de Docker en una m谩quina virtual de EC2. El servicio corre por el puerto ***27017***.

- El **LogService**, es un servicio REST que recibe una cadena, la almacena en la base de datos y responde en un objeto JSON con las 10 ultimas cadenas almacenadas en la base de datos y la fecha en que fueron almacenadas. Hay tres instancia del servicio que corren por los puertos ***33001, 33002, 33003***.

  - Cuenta con 2 endpoints:
       
     馃搶 ***(GET)*** /string. Obtiene de las 煤ltimas 10 cadenas almacenadas en la instancia de MongoDB con la fecha de creaci贸n .
     
     馃搶 ***(POST)*** /string. Almacena en la base de datos la cadena con su fecha de creaci贸n, retorna la informaci贸n almacenada.

- La aplicaci贸n web **APP-LB-RoundRobin** que corre por el puerto ***36000***, est谩 compuesta por un cliente web y un servicio REST. El cliente web a trav茅s de la acci贸n de un bot贸n envia los mensajes del usuario al servicio REST y actualiza la pantalla con la informaci贸n que este le regresa en formato JSON. El servicio REST recibe la cadena e implementa un algoritmo de balanceo de cargas de Round Robin, delegando el procesamiento del mensaje y el retorno de la respuesta a cada una de las tres instancias del servicio **LogService**.

  - Cuenta con 2 endpoints:

       馃搶 ***(GET)*** /string. Permite acceder al servicio de **LogService** para obtener las 煤ltimas 10 cadenas almacenadas en la instancia de MongoDB con la          fecha de creaci贸n .

       馃搶 ***(POST)*** /string. Permite acceder al servicio de **LogService** para almacenar en la base de datos la cadena con su fecha de creaci贸n, retorna la          informaci贸n almacenada.
       
<!DOCTYPE html>
<html>
    <head></head>
    <body>
      <p align="center">
        <img src="https://github.com/Angelica-Alfaro/AREP_TALLER4/blob/master/Imgs/Arquitectura.jpeg" width="400"/>
      </p>
    </body>
</html>

## 馃摲 Creaci贸n de im谩genes
- A trav茅s del comando ***docker-compose up -d*** se ejecuta el archivo ***docker-compose.yml*** de cada carpeta del proyecto (en este caso Logservice y APP-LB-RoundRobin), que a trav茅s del ***DockerFile*** se encarga de construir la imagen para subir al repositorio en DockerHub.

  <!DOCTYPE html>
  <html>
      <head></head>
      <body>
            <img src="https://github.com/Angelica-Alfaro/AREP_TALLER4/blob/master/Imgs/DockerHub.PNG" width="700"/>
      </body>
  </html>
  
 - Se crea una m谩quina EC2 en AWS, se descarga Docker ***(sudo yum install docker)***, docker-compose y se hace un archivo ***docker-compose.yml*** en la ra铆z del proyecto para que descarge las im谩genes de los contenedores que se encuentran en DockerHub y los corra en los puertos indicados.
  
    <!DOCTYPE html>
    <html>
        <head></head>
        <body>
              <img src="https://github.com/Angelica-Alfaro/AREP_TALLER4/blob/master/Imgs/Docker-compose.PNG" width="300"/>
        </body>
    </html>
    
## 馃摑 Evidencia
### Cliente web
<!DOCTYPE html>
<html>
    <head></head>
    <body>
        <p align="center">
          <img src="https://github.com/Angelica-Alfaro/AREP_TALLER4/blob/master/Imgs/Frontend%20.PNG"/>
        </p>
    </body>
</html>

### GET /string
<!DOCTYPE html>
<html>
    <head></head>
    <body>
        <p align="center">
          <img src="https://github.com/Angelica-Alfaro/AREP_TALLER4/blob/master/Imgs/Get.PNG"/>
        </p>
    </body>
</html>

### POST /string
<!DOCTYPE html>
<html>
    <head></head>
    <body>
        <p align="center">
          <img src="https://github.com/Angelica-Alfaro/AREP_TALLER4/blob/master/Imgs/Post.PNG"/>
        </p>
    </body>
</html>
       
## 馃挕 Herramientas utilizadas
- Maven
- Eclipse
- GitHub
- Heroku
- DockerHub
- AWl servicio de 


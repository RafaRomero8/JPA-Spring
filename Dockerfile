FROM openjdk:8-jdk-alpine 
COPY "./target/ms-productos-0.0.1-SNAPSHOT.jar" "app.jar" 
EXPOSE 8090 
ENTRYPOINT ["java","-jar","app.jar"]  #array de comados para ejecutar el proyecto
 
#8090 es el puerto del proyecto que se expone
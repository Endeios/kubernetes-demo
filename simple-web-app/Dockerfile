FROM adoptopenjdk:11-jre-hotspot
RUN mkdir /opt/app
COPY target/simple-web-app-0.0.1-SNAPSHOT.jar /opt/app/app.jar
WORKDIR /opt/app
CMD ["java", "-jar", "app.jar"]
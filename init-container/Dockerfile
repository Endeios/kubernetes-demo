FROM adoptopenjdk:11-jre-hotspot
RUN mkdir /opt/app
COPY target/init-container-0.0.1-SNAPSHOT.jar /opt/app/init.jar
WORKDIR /opt/app
CMD ["java", "-jar", "init.jar"]
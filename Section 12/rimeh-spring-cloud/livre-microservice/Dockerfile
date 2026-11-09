#Start with a base image containing Java runtime 
FROM eclipse-temurin:25-jdk

#Information around who maintains the image 
LABEL "org.opencontainers.image.authors"="rimeh.com"

# Installer curl pour les healthchecks Docker
RUN apt-get update && apt-get install -y curl && rm -rf /var/lib/apt/lists/*

# Add the application's jar to the image
COPY target/livre-microservice-0.0.1-SNAPSHOT.jar livre-microservice-0.0.1-SNAPSHOT.jar

# execute the application 
ENTRYPOINT ["java", "-jar", "livre-microservice-0.0.1-SNAPSHOT.jar"]
FROM openjdk:17

WORKDIR /app

COPY target/student_service-0.0.1-SNAPSHOT.jar student_service-0.0.1-SNAPSHOT.jar

EXPOSE 8282

CMD ["java", "-jar", "student_service-0.0.1-SNAPSHOT.jar"]
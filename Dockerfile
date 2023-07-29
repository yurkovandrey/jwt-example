FROM eclipse-temurin:17-jdk-alpine as build
WORKDIR /workspace/app

COPY gradle gradle
COPY src src
COPY build.gradle .
COPY gradlew .
COPY settings.gradle .

RUN ./gradlew build

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /workspace/app
COPY --from=build /workspace/app/build/libs/JwtExample-0.0.1.jar .
ENTRYPOINT ["/opt/java/openjdk/bin/java", "-jar", "JwtExample-0.0.1.jar"]
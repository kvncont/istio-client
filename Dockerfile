FROM amazoncorretto:17-alpine3.15

ARG JAR_NAME=istio-client-0.0.1-SNAPSHOT.jar

ENV TZ=America/Costa_Rica

EXPOSE 8080/tcp

COPY target/${JAR_NAME} /home/${JAR_NAME}

VOLUME /tmp

WORKDIR /home/

CMD  java -jar -XX:+UseG1GC ${JAR_NAME}

# DEFAULT HEALTHCKECK: interval 30s, timeout 30s, start-period 0s, and retries 3
HEALTHCHECK CMD curl --fail http://localhost:8080/actuator/health || exit 1
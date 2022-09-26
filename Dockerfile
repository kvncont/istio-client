FROM amazoncorretto:17-alpine3.15

ENV TZ=America/Costa_Rica

EXPOSE 8080/tcp

COPY target/istio-client-0.0.1-SNAPSHOT.jar /home/istio-client-0.0.1-SNAPSHOT.jar

VOLUME /tmp

WORKDIR /home/

CMD  java -jar -XX:+UseG1GC istio-client-0.0.1-SNAPSHOT.jar

# DEFAULT HEALTHCKECK: interval 30s, timeout 30s, start-period 0s, and retries 3
HEALTHCHECK CMD curl --fail http://localhost:8080/actuator/health || exit 1
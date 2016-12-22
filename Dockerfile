FROM maven

MAINTAINER hmz1988@gmail.com

RUN mkdir -p /app
WORKDIR /app
COPY . /app
RUN sh -c 'mvn clean package'
ADD ./target/restexample-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
FROM openjdk:8u181-jdk

LABEL maintainer="Marek Kalkowski"

VOLUME /tmp

EXPOSE 8080

ARG JAR_FILE=target/interviewTask.jar

ADD ${JAR_FILE} interviewTask.jar

ENTRYPOINT ["java","-jar","/interviewTask.jar"]
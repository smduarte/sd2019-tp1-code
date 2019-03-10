FROM maven:3.5.3-jdk-8-alpine as target

WORKDIR /build

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src/ /build/src/

RUN mvn clean compile package 

FROM smduarte/sd19-tp1-openjdk8

MAINTAINER Sérgio Duarte <smd@fct.unl.pt>

WORKDIR /home/sd

COPY --from=target /build/target/lib/*.jar /home/sd/ 
COPY --from=target /build/target/*.jar /home/sd/

COPY sd2019-tp1.props /props/
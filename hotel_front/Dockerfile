FROM openjdk:8-jre
ARG TARGET
ENV TARGET_ENV ${TARGET}
ADD target/hotel_front-*.jar hotel_front.jar
ENTRYPOINT ["java","-jar","hotel_front.jar","-Dspring.profiles.active=$TARGET_ENV"]
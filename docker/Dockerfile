FROM frolvlad/alpine-oraclejdk8:slim
ADD noob.jar noob.jar
RUN sh -c 'touch /noob.jar'
EXPOSE 8888
ENTRYPOINT [ "sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar /noob.jar" ]
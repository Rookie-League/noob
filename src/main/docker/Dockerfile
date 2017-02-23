FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD noob.jar noob.jar
RUN sh -c 'touch /noob.jar'
ENV JAVA_OPTS=""
EXPOSE 10000
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /noob.jar" ]
FROM java:alpine
ADD noob.jar noob.jar
RUN sh -c 'touch /noob.jar'
EXPOSE 8888
ENTRYPOINT [ "sh", "-c", "java ${JAVA_OPTIONS} -Djava.security.egd=file:/dev/./urandom -jar /noob.jar ${MAIN_ARGS}" ]
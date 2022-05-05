FROM amazoncorretto:11.0.15
WORKDIR /app
EXPOSE $SERVER_PORT
ADD ./build/libs/url-shortener-1.0.0.jar .
CMD ["sh", "-c", "DATABASE_USERNAME=sa DATABASE_PASSWORD= SERVER_PORT=$SERVER_PORT java -jar url-shortener-1.0.0.jar"]
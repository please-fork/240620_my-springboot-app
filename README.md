```sh
# 레포지터리를 clone 후 빌드
docker build -t my-springboot-app .
# Spring Boot 애플리케이션 컨테이너 실행 
docker run -d --name springboot_container --link mariadb_container:mysql -e SPRING_DATASOURCE_URL=jdbc:mariadb://mariadb_container:3306/exampledb -e SPRING_DATASOURCE_USERNAME=exampleuser -e SPRING_DATASOURCE_PASSWORD=examplepass -p 8080:8080 my-springboot-app
# http://localhost:8080/api/books
```
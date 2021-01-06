# Maven-Spring-Boot
Springboot example using Maven multi modules 


- mvnw clean install

- mvnw spring-boot:run -pl client        -> default profile is prod
- mvnw spring-boot:run -pl client -Pprod 
- mvnw spring-boot:run -pl client -Pdev

- mvnw spring-boot:run -pl admin

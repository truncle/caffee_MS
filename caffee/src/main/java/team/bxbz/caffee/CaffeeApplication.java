package team.bxbz.caffee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class CaffeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CaffeeApplication.class, args);
        System.out.println("HelloWorld");
    }

}

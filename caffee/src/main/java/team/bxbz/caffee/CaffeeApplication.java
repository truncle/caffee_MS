package team.bxbz.caffee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import team.bxbz.caffee.service.UserService;

@SpringBootApplication
public class CaffeeApplication {
    public static void main(String[] args) {
        SpringApplication.run(CaffeeApplication.class, args);
    }
}

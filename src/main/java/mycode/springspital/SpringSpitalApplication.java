package mycode.springspital;

import mycode.springspital.users.repository.UserRepositoryImpl;
import mycode.springspital.view.View;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringSpitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSpitalApplication.class, args);
    }
    @Bean
    CommandLineRunner show(View view){
        return args -> {
            view.play();


        };


    }


}

package com.capgemini;

import com.capgemini.model.Room;
import com.capgemini.repositories.RoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.sql.SQLException;


/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args ) throws SQLException {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public CommandLineRunner demo(RoomRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new Room(1L,"JackBauer",2));
            repository.save(new Room(2L,"Chloe'Brian",4));
            repository.save(new Room(3L,"KimBauer",4));
            repository.save(new Room(4L,"DavidPalmer",6));
            repository.save(new Room(5L,"MichelleDessler",3));
        };
    }
}


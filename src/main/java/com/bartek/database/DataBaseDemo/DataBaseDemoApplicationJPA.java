package com.bartek.database.DataBaseDemo;

import com.bartek.database.DataBaseDemo.entity.Person;
import com.bartek.database.DataBaseDemo.jdbc.PersonJdbcDAO;
import com.bartek.database.DataBaseDemo.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DataBaseDemoApplicationJPA implements CommandLineRunner {

    @Autowired
    PersonJpaRepository personJpaRepository;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void run(String... args) throws Exception {

        logger.info("User id 10001 -> {}", personJpaRepository.findById(10001));
        logger.info("Inserting 10006", personJpaRepository.insert(new Person("Bartek", "Lublin", new Date())));
        logger.info("Update 10003", personJpaRepository.update(new Person("ChangeName", "ChangeLoc", new Date())));
        logger.info("\nAll users -> {}", personJpaRepository.findAll());

    }

    public static void main(String[] args) {
        SpringApplication.run(DataBaseDemoApplicationJPA.class, args);


    }


}

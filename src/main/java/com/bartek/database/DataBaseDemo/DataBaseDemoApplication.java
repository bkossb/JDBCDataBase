package com.bartek.database.DataBaseDemo;

import com.bartek.database.DataBaseDemo.entity.Person;
import com.bartek.database.DataBaseDemo.jdbc.PersonJdbcDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DataBaseDemoApplication implements CommandLineRunner {

    @Autowired
    PersonJdbcDAO dao;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void run(String... args) throws Exception {
        logger.info("\nAll users -> {}", dao.findAll());
        logger.info("\nUser id ->{}", dao.findById(10002));
        logger.info("\nUser name ->{}", dao.findByName("Ranga"));
        logger.info("\nUser location ->{}", dao.findByLocation("Hydrebad"));
        logger.info("\nDelete user by id -> Nr rows of deleted {}", dao.deleteById(10001));

        logger.info("Inserting 10006", dao.insertPerson(new Person(10006, "Bartek", "Lublin", new Date())));
        logger.info("Update 10003", dao.updatePerson(new Person(10003, "ChangeName", "ChangeLoc", new Date())));
    }

    public static void main(String[] args) {
        SpringApplication.run(DataBaseDemoApplication.class, args);


    }


}

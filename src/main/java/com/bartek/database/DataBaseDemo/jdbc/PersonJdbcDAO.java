package com.bartek.database.DataBaseDemo.jdbc;

import com.bartek.database.DataBaseDemo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbcDAO {

    class PersonRowMapper implements RowMapper<Person>{
        @Override
        public Person mapRow(ResultSet resultSet, int i) throws SQLException {
            Person person = new Person();
            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            person.setLocation(resultSet.getString("location"));
            person.setBirthDate(resultSet.getTimestamp("birth_date"));
            return person;
        }
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    //
    public List<Person> findAll() {
        return jdbcTemplate.query("select * from person", new PersonRowMapper());
    }

    public Person findById(int id) {
        return jdbcTemplate.queryForObject("select * from person where id = ?", new Object[]{id},
                new BeanPropertyRowMapper<Person>(Person.class));
    }

    public Person findByName(String name) {
        return jdbcTemplate.queryForObject("select * from person where name = ?", new Object[]{name},
                new BeanPropertyRowMapper<Person>(Person.class));
    }

    public List<Person> findByLocation(String location) {
        return jdbcTemplate.query("select * from person where location = ?", new Object[]{location},
                new BeanPropertyRowMapper<Person>(Person.class));
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("delete FROM person where id = ? ", new Object[]{id});
    }

    public int deleteByName(String name) {
        return jdbcTemplate.update("delete FROM person where name = ? ", new Object[]{name});
    }

    public int deleteByLocation(String location) {
        return jdbcTemplate.update("delete FROM person where location = ? ", new Object[]{location});
    }

    public int insertPerson(Person person) {

        return jdbcTemplate.update("INSERT into person (ID, NAME,LOCATION, BIRTH_DATE) VALUES(?,?,?,?)", new Object[]{person.getId(),person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime())});

    }

    public int updatePerson(Person person) {

        return jdbcTemplate.update("update person SET name=?, location = ?, birth_date = ? where id=?"
                , new Object[]{person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()), person.getId()});

    }

}

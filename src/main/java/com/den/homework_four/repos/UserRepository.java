package com.den.homework_four.repos;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.den.homework_four.model.User;

import java.util.List;

@Repository
@AllArgsConstructor
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public User findUserById(Integer id) {
        String sql = "SELECT * FROM userTable WHERE id=?";
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };
        return jdbcTemplate.queryForObject(sql, userRowMapper, id);
    }

    public List<User> findAll(){
        String sql = "SELECT * FROM userTable";
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };
        return jdbcTemplate.query(sql, userRowMapper);
    }

    public void save(User user) {
        String sql = "INSERT INTO userTable (firstName, lastName) VALUES (?, ?)";
        jdbcTemplate.update(sql, user.getFirstName(), user.getLastName());
    }

    public void deleteById (int id) {
        String sql = "DELETE FROM userTable WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    public void update(User user){
        String sql = "UPDATE userTable SET firstName=?, lastName=? WHERE id=?";
        jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getId());
    }

}

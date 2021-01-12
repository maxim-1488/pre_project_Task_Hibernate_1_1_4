package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    private final Connection connection = Util.getMySQLConnection();

    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        //комадна создания таблицы
        String sqlCommand = "CREATE TABLE users (id BIGINT NOT NULL AUTO_INCREMENT, name VARCHAR(45), " +
                "lastName VARCHAR(45), age SMALLINT NOT NULL, PRIMARY KEY (id))";

        try (Statement statement = connection.createStatement()) {
            //создание таблицы
            statement.executeUpdate(sqlCommand);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try (Statement statement = connection.createStatement()) {
            //удаление таблицы
            statement.execute("DROP TABLE users");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (Statement statement = connection.createStatement()) {
            //добавление юзеров
            statement.execute("INSERT INTO users (name, lastName, age) VALUES (?, ?, ?)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try (Statement statement = connection.createStatement()) {
            //добавление юзеров
            statement.execute("DELETE FROM users WHERE id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        return null;
    }

    public void cleanUsersTable() {
        try (Statement statement = connection.createStatement()) {
            //удаление таблицы
            statement.execute("DELETE FROM users");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

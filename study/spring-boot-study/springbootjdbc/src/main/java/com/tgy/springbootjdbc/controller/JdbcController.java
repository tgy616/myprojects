package com.tgy.springbootjdbc.controller;

import com.tgy.springbootjdbc.domain.User;
import com.tgy.springbootjdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

/**
 * @author tanggy
 * @date 2018/5/25
 */
@RestController
public class JdbcController {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserService userService;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/jdbc/meta/transaction/supported")
    public boolean supportedTransaction() {
        boolean supported = false;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            supported = databaseMetaData.supportsTransactions();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return supported;
    }

    @RequestMapping("/user/get")
    public Map<String, Object> getUser(@RequestParam(value = "id", defaultValue = "1") int id) {

        Map<String, Object> data = new HashMap<String, Object>();
        Connection connection = null;
        Savepoint savepoint = null;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
//            savepoint = connection.setSavepoint();
            PreparedStatement statement = connection.prepareStatement("SELECT ID,NAME,AGE FROM T_USER WHERE ID = ? ");
            statement.setInt(1, id);
            //ResultSet resultSet=statement.executeQuery("SELECT ID,NAME,AGE FROM T_USER WHERE ID="+id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                int id_ = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                data.put("id", id);
                data.put("name", name);
                data.put("age", age);
            }

            connection.commit();

        } catch (SQLException e) {
//            if (connection != null) {
//                connection.rollback(savepoint);
//            }
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true);
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return data;
    }

    @RequestMapping(value="/user/add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> saveUser(@RequestBody User user) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("success",userService.save(user));
        return data;
    }

    @RequestMapping("/users")
    public List<Map<String, Object>> getUsers() {
        return jdbcTemplate.execute(new StatementCallback<List<Map<String, Object>>>() {
            @Override
            public List<Map<String, Object>> doInStatement(Statement stmt) throws SQLException, DataAccessException {
                ResultSet resultSet = stmt.executeQuery("SELECT * FROM t_user");
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                int columnCount = resultSetMetaData.getColumnCount();
                List<String> columnNames = new ArrayList<>(columnCount);
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = resultSetMetaData.getColumnName(i);
                    columnNames.add(columnName);
                }
                List<Map<String, Object>> data = new LinkedList<>();
                while (resultSet.next()) {
                    Map<String, Object> columnData = new LinkedHashMap<>();
                    for (String columnName : columnNames) {
                        Object columnValue = resultSet.getObject(columnName);
                        columnData.put(columnName, columnValue);
                    }
                    data.add(columnData);
                }
                return data;
            }
        });
    }
}


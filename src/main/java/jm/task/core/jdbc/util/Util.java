package jm.task.core.jdbc.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    // "?serverTimezone=UTC" - эта запись для установки часового пояса MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/pre_proejct_1?serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "14091988";

    public static Connection getMySQLConnection() {

        Connection connection = null;

        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

    //throws SQLException,
//            ClassNotFoundException {
//
//        System.out.println("Get connection ... ");
//
//        // Get a Connection object
//        Connection conn = Util.getMySQLConnection();
//
//        System.out.println("Get connection " + conn);
//
//        System.out.println("Done!");
//    }

    // реализация настройки соеденения с БД

//    public static Connection getMySQLConnection() throws SQLException, ClassNotFoundException {
//        String hostName = "localhost";
//        String dbName = "pre_proejct_1";
//        String userName = "root";
//        String password = "14091988";
//
//        return getMySQLConnection(hostName, dbName, userName, password);
//    }
//
//    public static Connection getMySQLConnection(String hostName, String dbName, String userName,
//                                                String password) throws SQLException, ClassNotFoundException {
//        // "?serverTimezone=UTC" - эта запись для установки часового пояса MySQL
//        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName + "?serverTimezone=UTC";
//        Connection conn = DriverManager.getConnection(connectionURL, userName, password);
//        return conn;
//    }


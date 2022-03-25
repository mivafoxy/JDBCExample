import java.sql.*;

/*
1.	Предложение SELECT – SELECT {columns} FROM {table_name}
2.	Предложение INSERT – INSERT INTO {table_name}({table_columns}) VALUES({values})
3.	Предложение UPDATE – UPDATE {table_name} SET {column_name} = {value} WHERE {column_name} = {value}
4.	Предложение DELETE – DELETE FROM {table_name} WHERE {condition}

 */
public class Main {
    public static String sqlCreateUsersTable = "CREATE TABLE IF NOT EXISTS users (id integer PRIMARY KEY, login text NOT NULL);";
    public static String sqlInsertUserInTable = "INSERT INTO users(login) VALUES(\"oldLogin\");";
    public static String sqlSelectUsersFromTable = "SELECT login FROM users;";
    public static String sqlUpdateUser = "UPDATE users SET login = \"чикчирик\" WHERE id = 1";
    public static String sqlDeleteUser = "DELETE FROM users WHERE id = 1";
    public static String sqlInsertQueryWithParameter = "INSERT INTO users(login) VALUES(?);";


    public static void main(String[] args) {
        // Connection - соединение с БД.
        // Statement - позволяет отправлять запрос к БД
        // PreparedStatement - позволяет отправлять параметризованные запросы к БД

        // jdbc:sqlite:sqlite_database_file_path
        // DriverManager
        String url = "jdbc:sqlite:test.db";
        String[] logins = {
            "hello",
            "bye",
            "login1",
            "jojo"
        };
        try (Connection sqliteConnection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = sqliteConnection.prepareStatement(sqlInsertQueryWithParameter)
        ) {
            for (String login : logins) {
                preparedStatement.setString(1, login);
                preparedStatement.execute();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


}

package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {
    public static void main(String[] args) {
        String filePath = "src/main/sql/init_db.sql";
        try {
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();

            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            StringBuilder stringBuilder = new StringBuilder();

            while (line != null) {
                stringBuilder.append(line);
                if (line.endsWith(";")) {
                    String query = stringBuilder.toString();
                    statement.execute(query);
                    stringBuilder.setLength(0);
                }
                line = reader.readLine();
            }

            reader.close();
            statement.close();
            connection.close();

            System.out.println("Базу даних успішно проініціалізовано!");
        } catch (SQLException e) {
            System.err.println("Помилка SQL: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }
}
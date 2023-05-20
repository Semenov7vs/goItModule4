package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabasePopulateService {

    public static void main(String[] args) {
        String fileName = "src/main/sql/populate_db.sql";

            try {
                Connection connection = Database.getConnection();
                Statement statement = connection.createStatement();

                BufferedReader reader = new BufferedReader(new FileReader(fileName));
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

                System.out.println("Базу даних успішно заповнено!");
            } catch (SQLException e) {
                System.err.println("Помилка SQL: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Помилка: " + e.getMessage());
            }
        }
    }
package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    public static void main(String[] args) {
        DatabaseQueryService queryService = new DatabaseQueryService();

        //Виклик find_max_projects_client.sql

//        List<MaxProjectCountClient> maxProjectCountClientsList = queryService.findMaxProjectsClient();
//        for (MaxProjectCountClient client : maxProjectCountClientsList) {
//            System.out.println("Name: " + client.getName() + ", Project Count: " + client.getProjectCount());
//        }

        //Виклик find_longest_project.sql

//        List<TheLongestProject> theLongestProjectsList = queryService.findTheLongestProject();
//        for (TheLongestProject test : theLongestProjectsList) {
//            System.out.println("Id: " + test.getId() + ", Month Count: " + test.getMonthCount());
//  }

        //Виклик find_max_salary_worker.sql

//        List<MaxSalary> maxSalaryList = queryService.findMaxSalary();
//        for (MaxSalary test : maxSalaryList) {
//            System.out.println("Name: " + test.getName() + ", Salary: " + test.getSalary());
//        }

        //Виклик find_youngest_eldest_workers.sql

//        List<YoungestEldestWorkers> youngestEldestWorkersList = queryService.findYoungestEldestWorkers();
//        for (YoungestEldestWorkers test : youngestEldestWorkersList) {
//            System.out.println("Type: " + test.getType() + ", Name: " + test.getName() + " Birthday: " + test.getBirthday());
//        }

        //Виклик print_project_prices.sql

//        List<ProjectPrices> projectPricesList = queryService.findPricesOfProjects();
//        for (ProjectPrices test : projectPricesList) {
//            System.out.println("Id: " + test.getProjectId() + ", Cost: " + test.getProjectCost());
//        }
    }

    public List<MaxProjectCountClient> findMaxProjectsClient() {
        String fileNameOfMaxProjectClients = "src/main/sql/find_max_projects_client.sql";
        List<MaxProjectCountClient> result = new ArrayList<>();

        try {
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();

            BufferedReader reader = new BufferedReader(new FileReader(fileNameOfMaxProjectClients));
            StringBuilder stringBuilder = new StringBuilder();
            String line = reader.readLine();

            while (line != null) {
                stringBuilder.append(line).append(" ");
                if (line.endsWith(";")) {
                    String query = stringBuilder.toString();
                    ResultSet resultSet = statement.executeQuery(query);

                    while (resultSet.next()) {
                        String name = resultSet.getString("NAME");
                        int projectCount = resultSet.getInt("project_count");
                        result.add(new MaxProjectCountClient(name, projectCount));
                    }

                    resultSet.close();
                    stringBuilder.setLength(0);
                }
                line = reader.readLine();
            }

            reader.close();
            statement.close();
            connection.close();

            System.out.println("Інформація про максимальну кількість проектів виконана!" + "\n");
        } catch (SQLException e) {
            System.err.println("Помилка SQL: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Помилка: " + e.getMessage());
        }

        return result;
    }

    public List<TheLongestProject> findTheLongestProject() {
        String fileNameOfLongestFile = "src/main/sql/find_longest_project.sql";
        List<TheLongestProject> resultOfLongestFile = new ArrayList<>();

        try {
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();

            BufferedReader reader = new BufferedReader(new FileReader(fileNameOfLongestFile));
            StringBuilder stringBuilder = new StringBuilder();
            String line = reader.readLine();

            while (line != null) {
                stringBuilder.append(line).append(" ");
                if (line.endsWith(";")) {
                    String query = stringBuilder.toString();
                    ResultSet resultSet = statement.executeQuery(query);

                    while (resultSet.next()) {
                        int id = resultSet.getInt("ID");
                        int monthCount = resultSet.getInt("month_count");
                        resultOfLongestFile.add(new TheLongestProject(id, monthCount));
                    }

                    resultSet.close();
                    stringBuilder.setLength(0);
                }
                line = reader.readLine();
            }

            reader.close();
            statement.close();
            connection.close();

            System.out.println("Інформація про найбільший проект виконана!"+ "\n");
        } catch (SQLException e) {
            System.err.println("Помилка SQL: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Помилка: " + e.getMessage());
        }
        return resultOfLongestFile;
    }

    public List<MaxSalary> findMaxSalary() {
        String fileNameOfMaxSalary = "src/main/sql/find_max_salary_worker.sql";
        List<MaxSalary> resultOfMaxSalary = new ArrayList<>();

        try {
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();

            BufferedReader reader = new BufferedReader(new FileReader(fileNameOfMaxSalary));
            StringBuilder stringBuilder = new StringBuilder();
            String line = reader.readLine();

            while (line != null) {
                stringBuilder.append(line).append(" ");
                if (line.endsWith(";")) {
                    String query = stringBuilder.toString();
                    ResultSet resultSet = statement.executeQuery(query);

                    while (resultSet.next()) {
                        String name = resultSet.getString("NAME");
                        int salary = resultSet.getInt("salary");
                        resultOfMaxSalary.add(new MaxSalary(name, salary));
                    }
                    resultSet.close();
                    stringBuilder.setLength(0);
                }
                line = reader.readLine();
            }

            reader.close();
            statement.close();
            connection.close();

            System.out.println("Інформація про найбільшу зарплатню виконана!" + "\n");
        } catch (SQLException e) {
            System.err.println("Помилка SQL: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Помилка: " + e.getMessage());
        }
        return resultOfMaxSalary;
    }

    public List<YoungestEldestWorkers> findYoungestEldestWorkers() {
        String fileNameOfYoungestEldest = "src/main/sql/find_youngest_eldest_workers.sql";
        List<YoungestEldestWorkers> resultOfYoungestEldes = new ArrayList<>();

        try {
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();

            BufferedReader reader = new BufferedReader(new FileReader(fileNameOfYoungestEldest));
            StringBuilder stringBuilder = new StringBuilder();
            String line = reader.readLine();

            while (line != null) {
                stringBuilder.append(line).append(" ");
                if (line.endsWith(";")) {
                    String query = stringBuilder.toString();
                    ResultSet resultSet = statement.executeQuery(query);

                    while (resultSet.next()) {
                        String type = resultSet.getString("TYPE");
                        String name = resultSet.getString("NAME");
                        String birthday = resultSet.getString("birthday");
                        resultOfYoungestEldes.add(new YoungestEldestWorkers(type, name, birthday));
                    }
                    resultSet.close();
                    stringBuilder.setLength(0);
                }
                line = reader.readLine();
            }

            reader.close();
            statement.close();
            connection.close();

            System.out.println("Інформація про наймолодшого та найстарішого працівника виконана!" + "\n");
        } catch (SQLException e) {
            System.err.println("Помилка SQL: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Помилка: " + e.getMessage());
        }
        return resultOfYoungestEldes;
    }

    public List<ProjectPrices> findPricesOfProjects() {
        String fileNameOfPricesOfProjects = "src/main/sql/print_project_prices.sql";
        List<ProjectPrices> resultOfPricesOfProjects = new ArrayList<>();

        try {
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();

            BufferedReader reader = new BufferedReader(new FileReader(fileNameOfPricesOfProjects));
            StringBuilder stringBuilder = new StringBuilder();
            String line = reader.readLine();

            while (line != null) {
                stringBuilder.append(line).append(" ");
                if (line.endsWith(";")) {
                    String query = stringBuilder.toString();
                    ResultSet resultSet = statement.executeQuery(query);

                    while (resultSet.next()) {
                        int id = resultSet.getInt("project_id");
                        int cost = resultSet.getInt("project_cost");
                        resultOfPricesOfProjects.add(new ProjectPrices(id, cost));
                    }
                    resultSet.close();
                    stringBuilder.setLength(0);
                }
                line = reader.readLine();
            }

            reader.close();
            statement.close();
            connection.close();

            System.out.println("Інформація про вартість проектів виконана!" + "\n");
        } catch (SQLException e) {
            System.err.println("Помилка SQL: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Помилка: " + e.getMessage());
        }
        return resultOfPricesOfProjects;
    }
}

class ProjectPrices{
    private int projectId;
    private int projectCost;

    public ProjectPrices(int projectId, int projectCost) {
        this.projectId = projectId;
        this.projectCost = projectCost;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getProjectCost() {
        return projectCost;
    }

    public void setProjectCost(int projectCost) {
        this.projectCost = projectCost;
    }
}

class YoungestEldestWorkers{
    private String type;
    private String name;
    private String birthday;

    public YoungestEldestWorkers(String type, String name, String birthday) {
        this.type = type;
        this.name = name;
        this.birthday = birthday;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}

class MaxSalary{
    private String name;
    private int salary;

    public MaxSalary(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}

class TheLongestProject{
    private int id;
    private int monthCount;

    public TheLongestProject(int id, int monthCount) {
        this.id = id;
        this.monthCount = monthCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMonthCount() {
        return monthCount;
    }

    public void setMonthCount(int monthCount) {
        this.monthCount = monthCount;
    }
}


class MaxProjectCountClient {
    private String name;
    private int projectCount;

    public MaxProjectCountClient(String name, int projectCount) {
        this.name = name;
        this.projectCount = projectCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProjectCount() {
        return projectCount;
    }

    public void setProjectCount(int projectCount) {
        this.projectCount = projectCount;
    }
}
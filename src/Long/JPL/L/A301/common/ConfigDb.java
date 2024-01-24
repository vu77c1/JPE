package JPL.L.A301.common;

import java.sql.Connection;

public class ConfigDb {
    public static Connection connection;
    public static String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String JDBC_URL = "jdbc:sqlserver://localhost:1433;database=SMS;TrustServerCertificate=true;";
    public static String USERNAME = "sa";
    public static String PASSWORD = "Tuanvu1993@";
}

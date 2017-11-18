package testcode.crypto;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.System.out;

public class ErrorMessages {
    public void vulnerableErrorMessage1(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://prod.company.com/production");
            OutputStream out = resp.getOutputStream();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace(out); // Normal Priority
        } catch (Exception e) {
            e.printStackTrace(); // Low Priority
        }
    }

    public void vulnerableErrorMessage2() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://prod.company.com/production");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace(); // Low Priority
        }
    }

    public void vulnerableErrorMessage3() {
        FileInputStream fis = null;
        try {
            String fileName = "fileName";
            fis = new FileInputStream(fileName);
        } catch (Exception e) {
            e.printStackTrace(); // Low Priority
        }
    }
}

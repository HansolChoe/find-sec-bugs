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
            OutputStream out = resp.getOutputStream();
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }

    public void vulnerableErrorMessage2() {
        try {
            String password = "Password";
            Connection conn = DriverManager.getConnection("jdbc:mysql://prod.company.com/production");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void vulnerableErrorMessage3() {
        FileInputStream fis = null;
        try {
            String fileName = "fileName";
            fis = new FileInputStream(fileName);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }
}

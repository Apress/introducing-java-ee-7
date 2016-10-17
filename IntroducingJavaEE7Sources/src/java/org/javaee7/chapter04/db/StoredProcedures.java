package org.javaee7.chapter04.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Juneau
 */
public class StoredProcedures {

    /**
     * Stored procedure for a derby database
     */
    public static void createEmp(String firstName,
            String lastName,
            String status) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:default:connection");
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String ins =
                "insert into EMPLOYEE values("
                + "next value for employee_pk_s, "
                + "?, ?, null, null, ?) ";

        pstmt = con.prepareStatement(ins);
        pstmt.setString(1, firstName);
        pstmt.setString(2, lastName);
        pstmt.setString(3, status);
        pstmt.executeUpdate();

    }
}

package com.kodilla.jdbc;

import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StoredProcTestSuite {
    @Test
    public void testUpdateVipLevel() throws SQLException {
        //Given
        DbManager2 dbManager2 = DbManager2.getInstance();
        String sqlUpdate = "UPDATE READERS SET VIP_LEVEL = \"Non set\"";
        Statement statement = dbManager2.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);

        //When
        String sqlProcedureCall = "CALL UpdateVipLevels();";
        statement.execute(sqlProcedureCall);

        //Then
        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM READERS WHERE VIP_LEVEL = \"Non set\"";
        ResultSet resultSet = statement.executeQuery(sqlCheckTable);
        int howMany = -1;
        if(resultSet.next()){
            howMany = resultSet.getInt("HOW_MANY");
        }
        Assert.assertEquals(0,howMany);
    }

    @Test
    public void testUpdateBestsellers() throws SQLException {
        //Given
        DbManager2 dbManager2 = DbManager2.getInstance();
        String sqlUpdate = "UPDATE BOOKS SET BESTSELLER = null";
        Statement statement = dbManager2.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);

        //When
        String sqlProcedureCall = "CALL UpdateBestsellers();";
        statement.execute(sqlProcedureCall);

        //Then
        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM BOOKS WHERE BESTSELLER IS NULL";
        ResultSet resultSet = statement.executeQuery(sqlCheckTable);
        int howMany = -1;
        if(resultSet.next()){
            howMany = resultSet.getInt("HOW_MANY");
        }
        Assert.assertEquals(0,howMany);
    }
}

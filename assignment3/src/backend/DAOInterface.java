//Nilofar M. Ali
//CSC413-02 Spring 2024
//Assignment 3

package backend;

import java.sql.SQLException;


public interface DAOInterface<T> {

    T get(int id) throws SQLException;
    //List<T> getAll() throws SQLException;
    int insert(T e) throws SQLException;
    int update(T e) throws SQLException;
    int delete(int id) throws SQLException;

}


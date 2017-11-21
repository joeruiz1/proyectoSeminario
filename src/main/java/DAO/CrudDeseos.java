/*
    <servlet-mapping>
        <servlet-name>CrearDeseos</servlet-name>
        <url-pattern>/CrearDeseos</url-pattern>
    </servlet-mapping>
    <servlet-mapping>
        <servlet-name>verDeseos</servlet-name>
        <url-pattern>/verDeseos</url-pattern>
    </servlet-mapping>
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.DbUtil;
import VO.Deseos;
import VO.Factura;
import VO.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class CrudDeseos {

    private Connection connection;

    public CrudDeseos() {
        connection = DbUtil.getConnection();
    }

    public void deseos(Deseos de) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into Deseos (id_deseo,id_libro,nombre_libro,precio) values (?, ?, ?, ?)");

            // Parameters start with 1
            preparedStatement.setInt(1, de.getId_deseos());
            preparedStatement.setInt(2, de.getId_libro());
            preparedStatement.setString(3, de.getNombre_libro());
            preparedStatement.setInt(4, de.getPrecio());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Deseos> mostarDeseos() {
        List<Deseos> dese = new ArrayList<Deseos>();
        try {
            System.out.println("LLegue hasta aca");
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select * from Deseos");
            while (rs.next()) {

                Deseos d = new Deseos();
                d.setId_deseos(rs.getInt("id_deseo"));
                d.setId_libro(rs.getInt("id_libro"));   
                d.setNombre_libro(rs.getString("nombre_libro"));                             
                d.setPrecio(rs.getInt("precio"));

                dese.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dese;
    }

}

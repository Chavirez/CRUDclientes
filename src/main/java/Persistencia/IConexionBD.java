package Persistencia;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 
 * @author eduar
 */
public interface IConexionBD {
    public Connection crearConexion() throws SQLException;
}
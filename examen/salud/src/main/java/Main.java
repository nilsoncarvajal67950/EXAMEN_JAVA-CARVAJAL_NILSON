

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.centro_salud.infrastructure.adapter.ui.UiAuth;
import com.centro_salud.domain.validation.InputValidator;
import com.centro_salud.infrastructure.adapter.ui.Manageable;
import com.centro_salud.infrastructure.adapter.ui.UiHome;
import com.centro_salud.infrastructure.database.ConnectMysqlFactory;
import com.centro_salud.infrastructure.database.ConnectionDb;

public class Main {
    private static final String CONNECTION_SUCCESS_MSG = """
        =============================================================
        |   CONEXIÓN A LA BASE DE DATOS ESTABLECIDA CORRECTAMENTE   |
        =============================================================
        """;
        
    private static final String CONNECTION_FAIL_MSG = """
        ===================================================        
        |    ERROR AL CONECTAR A LA BASE DE DATOS         |
        ===================================================
        """;
        
    private static final String EXIT_MSG = "Gracias por usar el sistema";

    public static void main(String[] args) {
        try {
            
            ConnectionDb conexionDB = ConnectMysqlFactory.crearConexion();
            Connection conexion = conexionDB.getConexion();
            
            if (conexion == null || conexion.isClosed()) {
                System.err.println(CONNECTION_FAIL_MSG);
                return;
            }
            
            System.out.println(CONNECTION_SUCCESS_MSG);
            pause(1500);
            InputValidator.clearConsole();
            
           
            handleMainFlow(conexion);
            
        } catch (SQLException e) {
            System.err.println(CONNECTION_FAIL_MSG);
            System.err.println("Error: " + e.getMessage());
        } finally {
            System.out.println(EXIT_MSG);
        }
    }
}
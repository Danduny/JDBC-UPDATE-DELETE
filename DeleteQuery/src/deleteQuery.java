import java.sql.*;
import javax.swing.*;

public class deleteQuery {
    public static void main(String[] args) {

        Connection connection;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alza", "root", "password");

        String auta = JOptionPane.showInputDialog(null,"Enter car name to delete data:");

        PreparedStatement preparedStatement = connection.prepareStatement
                ("DELETE FROM knihy\n" +
                        "WHERE auta = ?");

        preparedStatement.setString(1, auta);

        int nrows = preparedStatement.executeUpdate();
        if(nrows>0)
            JOptionPane.showMessageDialog(null,"Data deleted successfully", "Success",JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null,"Data deletion failed", "Error",JOptionPane.ERROR_MESSAGE);
        preparedStatement.close();
        connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

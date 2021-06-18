import java.sql.*;
import javax.swing.*;

public class updateQuery {
    public static void main(String[] args) {

        Connection connection;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alza", "root", "password");

            String auta = JOptionPane.showInputDialog(null,"Enter car name to update data:");

            String newnazev = "Squirelo";
            String newauto = "Lamborghini";
            String newobsah = "7.5L V16";
            int newcena = 999999;

            PreparedStatement preparedStatement = connection.prepareStatement
                    ("UPDATE auta\n" +
                            "SET column1=?, column2=?, column3=?, column4=?\n" +
                            "WHERE auta=?");

            preparedStatement.setString(1, newnazev);
            preparedStatement.setString(2, newauto);
            preparedStatement.setString(3, newobsah);
            preparedStatement.setString(4, Integer.toString(newcena));
            preparedStatement.setString(5, auta);

            int nrows = preparedStatement.executeUpdate();
            if(nrows>0)
                JOptionPane.showMessageDialog(null,"Data updated successfully", "Success",JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(null,"Data update failed", "Error",JOptionPane.ERROR_MESSAGE);
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

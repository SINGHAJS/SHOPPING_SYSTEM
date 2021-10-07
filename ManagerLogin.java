package KFC_SHOPPING_SYSTEM;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;

/**
 *
 * @author Ajit Singh ID: 19070642
 * @author Rohit Singh ID: 17981754
 *
 */

public class ManagerLogin {
    
public static void verifyCustomerLogin(LoginView aView, ManagerView aMgrView, String aManagerTable, DBManager DBM, PreparedStatement ps, ResultSet rs) {
        String aCustomerLogin = "SELECT * FROM " + aManagerTable + " WHERE USERNAME=? AND PASSWORD=?";

        try {
            ps = DBM.getConnection().prepareStatement(aCustomerLogin);
            ps.setString(1, aView.aNameField.getText());
            ps.setString(2, aView.aPassField.getText());
            rs = ps.executeQuery();
                        
            if (rs.next()) {
                JOptionPane.showMessageDialog(aView.aLoginPageFrame, "WELCOME MANAGER TO THE KFC SYSTEM", "MANAGER LOGIN SUCCESSFUL", JOptionPane.INFORMATION_MESSAGE);
                aView.aLoginPageFrame.setVisible(false);
                aMgrView.aManagerFrame.setVisible(true);
            } 
            else {
                JOptionPane.showMessageDialog(aView.aLoginPageFrame, "PLEASE MAKE SURE YOU ARE AN EXISTING MANAGER AND HAVE ENTERED CORRECT INFORMATION", "MANAGER LOGIN UNSUCCESSFUL", JOptionPane.INFORMATION_MESSAGE);                
            }
        } catch (SQLException ex) {
            System.out.println("[ERROR: " + ex + "]");
            JOptionPane.showMessageDialog(aView.aLoginPageFrame, "SQL EXCEPTION OCCURED", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}

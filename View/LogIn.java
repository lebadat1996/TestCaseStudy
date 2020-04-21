package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import View.EmployeeManager.*;

public class LogIn {
    private JTextField txtUser;
    private JButton loginButton;
    private JButton resetButton;
    private JButton exitButton;
    private JPanel Login;
    private JPasswordField txtPassword;


    public LogIn() {
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtPassword.setText("");
                txtUser.setText("");
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idUser = "[A-Za-z]{5,10}\\d{2,4}$";
                String user = txtUser.getText();
                String IdPassword = "[a-z]{5,7}\\d{4}$";
                String password = txtPassword.getText();
                if (user.matches(idUser) && password.matches(IdPassword)) {
                    if (user.contains("BaDat1996") && password.contains("badat1996")) {
                        JOptionPane.showMessageDialog(null,"Login success");
                        txtUser.setText(null);
                        txtPassword.setText(null);
                        EmployeeManager login = new EmployeeManager();
                        EmployeeManager.main(null);
                    } else {
                        JOptionPane.showMessageDialog(null, "Login Error");
                    }
                }else JOptionPane.showMessageDialog(null, "Login Error");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("LogIn");
        frame.setSize(300, 200);
        frame.setContentPane(new LogIn().Login);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

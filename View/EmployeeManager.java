package View;

import Model.Employee;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class EmployeeManager {
    private JTextField txtName;
    private JTextField txtAge;
    private JTextField txtAddress;
    private JTextField txtEmail;
    private JTextField txtPhoneNumber;
    private JTextField txtSalary;
    private JButton txtAdd;
    private JButton txtDisPlay;
    private JButton txtEdit;
    private JButton txtDeletes;
    private JTable table1;
    private JPanel EmployeeManager;
    private JButton txtSave;
    private JRadioButton txtMale;
    private JRadioButton txtFemale;
    private JButton txtReset;
    private JRadioButton btnOther;
    private JTextField txtDoB;
    private JScrollPane jTable1;
    private JTextField txtSearch;
    List<Employee> employeeList = new ArrayList<>();
    DefaultTableModel model;
    int i = 0;

    public EmployeeManager() {
        txtMale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtMale.isSelected()) {
                    txtFemale.setSelected(false);
                    btnOther.setSelected(false);
                }
            }
        });
        txtFemale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtFemale.isSelected()) {
                    txtMale.setSelected(false);
                    btnOther.setSelected(false);
                }
            }
        });
        txtAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnAdd();
            }
        });
        txtReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnRest();
            }
        });
        btnOther.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btnOther.isSelected()) {
                    txtMale.setSelected(false);
                    txtFemale.setSelected(false);
                }
            }
        });

        table1.setModel(new DefaultTableModel(null,
                new String[]{"ID", "Name", "Age", "Address", "DateOfBirth",
                        "Email", "Phone Number", "Salary", "Gender"}));
        txtDisPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReaderFile();
            }
        });

        txtSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WriterFile();
            }
        });
        txtDeletes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model = (DefaultTableModel) table1.getModel();
                try {
                    int index = table1.getSelectedRow();
                    model.removeRow(index);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Selection index row !!");
                }

            }
        });

        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                model = (DefaultTableModel) table1.getModel();
                String tbName = model.getValueAt(table1.getSelectedRow(), 1).toString();
                String tbAge = model.getValueAt(table1.getSelectedRow(), 2).toString();
                String tbAdd = model.getValueAt(table1.getSelectedRow(), 3).toString();
                String tbDob = model.getValueAt(table1.getSelectedRow(), 4).toString();
                String tbEmail = model.getValueAt(table1.getSelectedRow(), 5).toString();
                String tbPhone = model.getValueAt(table1.getSelectedRow(), 6).toString();
                String tbSalary = model.getValueAt(table1.getSelectedRow(), 7).toString();
                String male = model.getValueAt(table1.getSelectedRow(), 8).toString();
                String female = model.getValueAt(table1.getSelectedRow(), 8).toString();
                String other = model.getValueAt(table1.getSelectedRow(), 8).toString();
                txtName.setText(tbName);
                txtAge.setText(tbAge);
                txtAddress.setText(tbAdd);
                txtDoB.setText(tbDob);
                txtEmail.setText(tbEmail);
                txtPhoneNumber.setText(tbPhone);
                txtSalary.setText(tbSalary);
                txtMale.setSelected(Boolean.parseBoolean(male));
                txtFemale.setSelected(Boolean.parseBoolean(female));
                btnOther.setSelected(Boolean.parseBoolean(other));
            }
        });
        txtEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model = (DefaultTableModel) table1.getModel();
                if (table1.getSelectedRowCount() == 1) {
                    String name = txtName.getText();
                    String Address = txtAddress.getText();
                    String age = txtAge.getText();
                    String dob = txtDoB.getText();
                    String salary = txtSalary.getText();
                    String email = txtEmail.getText();
                    String phone = txtPhoneNumber.getText();
                    String male = txtMale.getText();
                    String feMale = txtFemale.getText();
                    String other = btnOther.getText();
                    model.setValueAt(name, table1.getSelectedRow(), 1);
                    model.setValueAt(age, table1.getSelectedRow(), 2);
                    model.setValueAt(Address, table1.getSelectedRow(), 3);
                    model.setValueAt(dob, table1.getSelectedRow(), 4);
                    model.setValueAt(email, table1.getSelectedRow(), 5);
                    model.setValueAt(phone, table1.getSelectedRow(), 6);
                    model.setValueAt(salary, table1.getSelectedRow(), 7);
                    model.setValueAt(male, table1.getSelectedRow(), 8);
                    model.setValueAt(feMale, table1.getSelectedRow(), 8);
                    model.setValueAt(other, table1.getSelectedRow(), 8);
                    JOptionPane.showMessageDialog(null, "Edit success");
                } else {
                    if (table1.getRowCount() == 0) {
                        JOptionPane.showMessageDialog(null, "Table isEmpty");
                    } else {
                        JOptionPane.showMessageDialog(null, "Selection row for Edit");
                    }
                }
            }
        });
        txtSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                model = (DefaultTableModel) table1.getModel();
                String search = txtSearch.getText();
                TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
                table1.setRowSorter(tr);
                tr.setRowFilter(RowFilter.regexFilter(search));
            }
        });
    }

    private void WriterFile() {
        String filePath = "File.txt";
        File file = new File(filePath);
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int j = 0; j < table1.getRowCount(); j++) {
                for (int k = 0; k < table1.getColumnCount(); k++) {
                    bw.write(table1.getValueAt(j, k).toString() + " ");
                }
                bw.newLine();
            }
            bw.close();
            fw.close();
            JOptionPane.showMessageDialog(null, "success");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private void ReaderFile() {
        String filePath = "File.txt";
        File file = new File(filePath);
        try {
            FileReader fr = new FileReader(file);
            BufferedReader bfr = new BufferedReader(fr);
            model = (DefaultTableModel) table1.getModel();
            Object[] line = bfr.lines().toArray();
            for (int j = 0; j < line.length; j++) {
                String[] row = line[j].toString().split(" ");
                model.addRow(row);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void btnAdd() {
        Employee employee = new Employee();
        String idName = "[A-Za-z]{6,10}";
        String name = employee.setName(txtName.getText());
        String idAddress = "[a-zA-Z]{0,9}[-|/][a-zA-Z]{0,9}$";
        String Add = employee.setAddress(txtAddress.getText());
        String idEmail = "[a-z]{0,9}[@]gmail[.]com$";
        String email = employee.setEmail(txtEmail.getText());
        String idDob = "\\d{1,2}[-|/]\\d{1,2}[-|/]\\d{1,4}";
        String dob = employee.setDateOfBirth(txtDoB.getText());
        String idPhone = "\\d{2}[-]\\d{0,9}";
        String phone = employee.setPhoneNumber(txtPhoneNumber.getText());
        String idSalary = "\\d{0,9}[$]";
        String salary = employee.setSalary(txtSalary.getText());
        String idAge = "\\d{1,3}";
        String age = employee.setAge(txtAge.getText());
        if (!name.matches(idName) || !Add.matches(idAddress) || !email.matches(idEmail) || !dob.matches(idDob) ||
                !phone.matches(idPhone) || !salary.matches(idSalary) || !age.matches(idAge)) {
            JOptionPane.showMessageDialog(null, "Enter the information again!");
        } else {
            if (txtMale.isSelected()) {
                employee.setGender(txtMale.getText());
            }
            if (txtFemale.isSelected()) {
                employee.setGender(txtFemale.getText());
            }
            if (btnOther.isSelected()) {
                employee.setGender(btnOther.getText());
            }
            for (Employee employee1 : employeeList) {
                if (employee1.getName().equals(txtName.getText())) {
                    JOptionPane.showMessageDialog(null, "Enter another name");
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Add success");
            employeeList.add(employee);
            employeeList.get(i).ShowInfo();
            i++;
            model = (DefaultTableModel) table1.getModel();
            model.addRow(new Object[]{table1.getRowCount() + 1, employee.getName(), employee.getAge(),
                    employee.getAddress(), employee.getDateOfBirth(),
                    employee.getEmail(), employee.getPhoneNumber(), employee.getSalary(), employee.getGender()
            });
        }
    }

    private void btnRest() {
        txtAge.setText(" ");
        txtPhoneNumber.setText(" ");
        txtName.setText(" ");
        txtAddress.setText(" ");
        txtEmail.setText(" ");
        txtSalary.setText(" ");
        txtDoB.setText(" ");
        txtFemale.setSelected(false);
        txtMale.setSelected(false);
        btnOther.setSelected(true);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("EmployeeManager");
        frame.setSize(600, 600);
        frame.setContentPane(new EmployeeManager().EmployeeManager);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

package app.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.model.beans.CustomerModel;
import org.model.dao.CustomerDAO;
import org.model.db.Database;

public class CustomerManage extends JDialog {
	JTextField textCusID;
	JTextField textCusName;
	JTextField textAddr;
	JTextField textPhone;
	JTextField textEmail;
	JTextField textUsername;
	JTextField textPassword;
	JTextField textTimereg;

	public CustomerManage(JFrame frame) {
		super(frame, true);

		JTable table = new JTable();

		Object[] colums = { "CUSTOMER_ID", "CUS_NAME", "ADDRESS", "PHONE", "EMAIL", "USERNAME", "PASSWD", "TIME_REG" };
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(colums);
		table.setModel(model);

		table.setBackground(Color.LIGHT_GRAY);
		table.setForeground(Color.BLACK);
		Font font = new Font("", 1, 22);
		table.setRowHeight(30);

		// get customer from db
		getAllCustomer(model);

		textCusID = new JTextField();
		textCusName = new JTextField();
		textAddr = new JTextField();
		textPhone = new JTextField();
		textEmail = new JTextField();
		textUsername = new JTextField();
		textPassword = new JTextField();
		textTimereg = new JTextField();

		JButton btnAdd = new JButton("Add");
		JButton btnUpdate = new JButton("Update ");
		JButton btnDelete = new JButton("Delete");

		
		
				//label
				JLabel label1 = new JLabel("รหัสลูกค้า   ");
				JLabel label2 = new JLabel("ชื่อ ");
				JLabel label3 = new JLabel("ที่อยู่ ");
				JLabel label4 = new JLabel("เบอร์โทรศัพท์  ");
				JLabel label5 = new JLabel("อีเมล์");
				JLabel label6 = new JLabel("Username");
				JLabel label7 = new JLabel("Password ");
				JLabel label8 = new JLabel("เวลา ");
				;
				label1.setBounds(20, 220, 100, 25);
				label2.setBounds(20, 250, 100, 25);
				label3.setBounds(20, 280, 100, 25);
				label4.setBounds(20, 310, 100, 25);
				label5.setBounds(20, 340, 100, 25);
				label6.setBounds(20, 370, 100, 25);
				label7.setBounds(20, 400, 100, 25);
				label8.setBounds(20, 430, 100, 25);
				
				add(label1);
				add(label2);
				add(label3);
				add(label4);
				add(label5);
				add(label6);
				add(label7);
				add(label8);
		
		textCusID.setBounds(150, 220, 100, 25);
		textCusName.setBounds(150, 250, 100, 25);
		textAddr.setBounds(150, 280, 100, 25);
		textPhone.setBounds(150, 310, 100, 25);
		textEmail.setBounds(150, 340, 100, 25);
		textUsername.setBounds(150, 370, 100, 25);
		textPassword.setBounds(150, 400, 100, 25);
		textTimereg.setBounds(150, 430, 100, 25);

		textCusID.setEnabled(false);
		textTimereg.setEnabled(false);

		btnAdd.setBounds(350, 220, 100, 25);
		btnUpdate.setBounds(350, 265, 100, 25);
		btnDelete.setBounds(350, 310, 100, 25);

		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(0, 0, 880, 200);

		setLayout(null);

		/// add pane
		add(pane);
		// add textf
		add(textCusID);
		add(textCusName);
		add(textAddr);
		add(textPhone);
		add(textEmail);
		add(textUsername);
		add(textPassword);
		add(textTimereg);

		// add btn
		add(btnAdd);
		add(btnUpdate);
		add(btnDelete);

		Object[] row = new Object[8];
		// add actions
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("addActionListener");
				Database db = new Database();
				CustomerDAO cusDAO = new CustomerDAO(db);
				CustomerModel cusModel = new CustomerModel();
				
				String cusName = textCusName.getText();
				String cusAddr = textAddr.getText();
				String cusPhone = textPhone.getText();
				String cusEmail = textEmail.getText();
				String cusUsername = textUsername.getText();
				String cusPassword = textPassword.getText();

				cusModel.setCusname(cusName);
				cusModel.setAddress(cusAddr);
				cusModel.setPhone(cusPhone);
				cusModel.setEmail(cusEmail);
				cusModel.setUsername(cusUsername);
				cusModel.setPasswd(cusPassword);
			
				int return_id = cusDAO.Add(cusModel);
				db.commit();
				db.close();
				
				db = new Database();
				
				cusDAO = new CustomerDAO(db);
				System.out.println("addActionListener 1");
				cusModel = cusDAO.FindByID(return_id);
				System.out.println("addActionListener 2");
				db.close();
				
				row[0] = cusModel.getCustomerId();
				row[1] = cusModel.getCusname();
				row[2] = cusModel.getAddress();
				row[3] = cusModel.getPhone();
				row[4] = cusModel.getEmail();
				row[5] = cusModel.getUsername();
				row[6] = cusModel.getPasswd();
				row[7] = cusModel.getTime_reg();

				model.addRow(row);
			}
		});
		btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("btnUpdate");
				int i = table.getSelectedRow();
				if (i >= 0) {
					System.out.println("row-update-select" + i);
					System.out.println("row-update-customer-id" + textCusID.getText());
					int cusID = Integer.parseInt(textCusID.getText().trim());
					String cusName = textCusName.getText();
					String cusAddr = textAddr.getText();
					String cusPhone = textPhone.getText();
					String cusEmail = textEmail.getText();
					String cusUsername = textUsername.getText();
					String cusPassword = textPassword.getText();

					Database db = new Database();
					CustomerDAO cusDAO = new CustomerDAO(db);
					CustomerModel cusModel = new CustomerModel();
					cusModel.setCustomerId(cusID);
					cusModel.setCusname(cusName);
					cusModel.setAddress(cusAddr);
					cusModel.setPhone(cusPhone);
					cusModel.setEmail(cusEmail);
					cusModel.setUsername(cusUsername);
					cusModel.setPasswd(cusPassword);
					cusDAO.Update(cusModel);

					db.commit();
					db.close();

					setTableGet(i, model);
				} else {

				}
			}
		});
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("btnDelete");
				int i = table.getSelectedRow();
				if (i >= 0) {
					System.out.println("row-Delete" + i);
					System.out.println("row-Delete" + textCusID.getText());
					int cusID = Integer.parseInt(textCusID.getText().trim());

					Database db = new Database();
					CustomerDAO cusDAO = new CustomerDAO(db);
					CustomerModel cusModel = new CustomerModel();
					cusModel.setCustomerId(cusID);
					cusDAO.Delete(cusModel);
					db.commit();
					db.close();

					model.removeRow(i);
				} else {
				}
			}
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("table");
				int i = table.getSelectedRow();
				setTable(i, model);
			}
		});

		setTitle("Customer Management");
		setSize(900, 600);
		setLocationRelativeTo(null);
	}

	public void getAllCustomer(DefaultTableModel model) {
		Database db = new Database();
		CustomerDAO cusDAO = new CustomerDAO(db);
		ArrayList<CustomerModel> cusList = cusDAO.FindAll();
		db.close();
		int i = 0;
		for (Iterator<CustomerModel> iterator = cusList.iterator(); iterator.hasNext(); i++) {
			CustomerModel cusModel = iterator.next();
			// System.out.println(cusModel.getCustomerId());
			model.addRow(new Object[0]);

			model.setValueAt(cusModel.getCustomerId(), i, 0);
			model.setValueAt(cusModel.getCusname(), i, 1);
			model.setValueAt(cusModel.getAddress(), i, 2);
			model.setValueAt(cusModel.getPhone(), i, 3);
			model.setValueAt(cusModel.getEmail(), i, 4);
			model.setValueAt(cusModel.getUsername(), i, 5);
			model.setValueAt(cusModel.getPasswd(), i, 6);
			model.setValueAt(cusModel.getTime_reg(), i, 7);

		}
	}

	public void setTable(int i, DefaultTableModel model) {
		textCusID.setText(model.getValueAt(i, 0).toString());
		textCusName.setText(model.getValueAt(i, 1).toString());
		textAddr.setText(model.getValueAt(i, 2).toString());
		textPhone.setText(model.getValueAt(i, 3).toString());
		textEmail.setText(model.getValueAt(i, 4).toString());
		textUsername.setText(model.getValueAt(i, 5).toString());
		textPassword.setText(model.getValueAt(i, 6).toString());
		textTimereg.setText(model.getValueAt(i, 7).toString());

	}

	public void setTableGet(int i, DefaultTableModel model) {
		model.setValueAt(textCusID.getText(), i, 0);
		model.setValueAt(textCusName.getText(), i, 1);
		model.setValueAt(textAddr.getText(), i, 2);
		model.setValueAt(textPhone.getText(), i, 3);
		model.setValueAt(textEmail.getText(), i, 4);
		model.setValueAt(textUsername.getText(), i, 5);
		model.setValueAt(textPassword.getText(), i, 6);
		model.setValueAt(textTimereg.getText(), i, 7);

	}

	public void getText() {

	}
}

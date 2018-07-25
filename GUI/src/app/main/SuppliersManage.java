package app.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.model.beans.CustomerModel;
import org.model.beans.StationeriesModel;
import org.model.beans.SuppliersModel;
import org.model.dao.CustomerDAO;
import org.model.dao.StationeriesDAO;
import org.model.dao.SuppliersDAO;
import org.model.db.Database;

import app.main.SuppliersGoodsManage.Item;

public class SuppliersManage extends JDialog {
	JTextField textSuppD;
	JTextField textSuppName;
	JTextField textSuppAddr;
	JTextField textSuppPhone;
	JTextField textSuppEmail;
	JTextField textTimereg;

	public SuppliersManage(JFrame frame) {
		super(frame, true);

		JTable table = new JTable();

		Object[] colums = { "SUPPLIERS_ID", "NAME", "ADDRESS", "PHONE", "EMAIL", "TIME_REG" };
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(colums);
		table.setModel(model);

		table.setBackground(Color.LIGHT_GRAY);
		table.setForeground(Color.BLACK);
		Font font = new Font("", 1, 22);
		table.setRowHeight(30);

		// get customer from db
		getAllSuppliers(model);

		textSuppD = new JTextField();
		textSuppName = new JTextField();
		textSuppAddr = new JTextField();
		textSuppPhone = new JTextField();
		textSuppEmail = new JTextField();
		textTimereg = new JTextField();

		JButton btnAdd = new JButton("Add");
		JButton btnUpdate = new JButton("Update ");
		JButton btnDelete = new JButton("Delete");

		

		//label
		JLabel label1 = new JLabel("ÃËÑÊ «Ñ¾ ");
		JLabel label2 = new JLabel("ª×èÍ «Ñ¾	");
		JLabel label3 = new JLabel("·ÕèÍÂÙè ");
		JLabel label4 = new JLabel("àºÍÃìâ·ÃÈÑ¾·ì  ");
		JLabel label5 = new JLabel("ÍÕàÁÅì");
		JLabel label6 = new JLabel("àÇÅÒ");
		
		
		label1.setBounds(20, 220, 100, 25);
		label2.setBounds(20, 250, 100, 25);
		label3.setBounds(20, 280, 100, 25);
		label4.setBounds(20, 310, 100, 25);
		label5.setBounds(20, 340, 100, 25);
		label6.setBounds(20, 370, 100, 25);
	
		add(label1);
		add(label2);
		add(label3);
		add(label4);
		add(label5);
		add(label6);
		
		
		
		
		textSuppD.setBounds(150, 220, 100, 25);
		textSuppName.setBounds(150, 250, 100, 25);
		textSuppAddr.setBounds(150, 280, 100, 25);
		textSuppPhone.setBounds(150, 310, 100, 25);
		textSuppEmail.setBounds(150, 340, 100, 25);
		textTimereg.setBounds(150, 370, 100, 25);

		textSuppD.setEnabled(false);
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
		add(textSuppD);
		add(textSuppName);
		add(textSuppAddr);
		add(textSuppPhone);
		add(textSuppEmail);
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
				SuppliersDAO suppDAO = new SuppliersDAO(db);
				SuppliersModel suppModel = new SuppliersModel();

				String suppName = textSuppName.getText();
				String suppAddr = textSuppAddr.getText();
				String suppPhone = textSuppPhone.getText();
				String suppEmail = textSuppEmail.getText();

				suppModel.setName(suppName);
				suppModel.setAddress(suppAddr);
				suppModel.setPhone(suppPhone);
				suppModel.setEmail(suppEmail);

				int return_id = suppDAO.Add(suppModel);
				db.commit();
				db.close();

				db = new Database();

				suppDAO = new SuppliersDAO(db);
				System.out.println("addActionListener 1");
				suppModel = suppDAO.FindByID(return_id);
				System.out.println("addActionListener 2");
				db.close();

				row[0] = suppModel.getSuppliers_id();
				row[1] = suppModel.getName();
				row[2] = suppModel.getAddress();
				row[3] = suppModel.getPhone();
				row[4] = suppModel.getEmail();
				row[5] = suppModel.getTime_reg();

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
					System.out.println("row-update-supp-id" + textSuppD.getText());
					int suppID = Integer.parseInt(textSuppD.getText().trim());
					String suppName = textSuppName.getText();
					String suppAddr = textSuppAddr.getText();
					String suppPhone = textSuppPhone.getText();
					String suppEmail = textSuppEmail.getText();

					Database db = new Database();
					SuppliersDAO suppDAO = new SuppliersDAO(db);
					SuppliersModel suppModel = new SuppliersModel();
					suppModel.setSuppliers_id(suppID);
					suppModel.setName(suppName);
					suppModel.setAddress(suppAddr);
					suppModel.setPhone(suppPhone);
					suppModel.setEmail(suppEmail);

					suppDAO.Update(suppModel);

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
					System.out.println("row-Delete" + textSuppD.getText());
					int suppID = Integer.parseInt(textSuppD.getText().trim());

					Database db = new Database();
					SuppliersDAO suppDAO = new SuppliersDAO(db);
					SuppliersModel suppModel = new SuppliersModel();
					suppModel.setSuppliers_id(suppID);
					suppDAO.Delete(suppModel);
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

		setTitle("Suppliers Management");
		setSize(900, 600);
		setLocationRelativeTo(null);
	}

	public void getAllSuppliers(DefaultTableModel model) {
		Database db = new Database();
		SuppliersDAO suppDAO = new SuppliersDAO(db);
		ArrayList<SuppliersModel> suppList = suppDAO.FindAll();
		db.close();
		int i = 0;
		for (Iterator<SuppliersModel> iterator = suppList.iterator(); iterator.hasNext(); i++) {
			SuppliersModel suppModel = iterator.next();
			// System.out.println(cusModel.getCustomerId());
			model.addRow(new Object[0]);

			model.setValueAt(suppModel.getSuppliers_id(), i, 0);
			model.setValueAt(suppModel.getName(), i, 1);
			model.setValueAt(suppModel.getAddress(), i, 2);
			model.setValueAt(suppModel.getPhone(), i, 3);
			model.setValueAt(suppModel.getEmail(), i, 4);
			model.setValueAt(suppModel.getTime_reg(), i, 5);

		}
	}

	public void setTable(int i, DefaultTableModel model) {
		textSuppD.setText(model.getValueAt(i, 0).toString());
		textSuppName.setText(model.getValueAt(i, 1).toString());
		textSuppAddr.setText(model.getValueAt(i, 2).toString());
		textSuppPhone.setText(model.getValueAt(i, 3).toString());
		textSuppEmail.setText(model.getValueAt(i, 4).toString());
		textTimereg.setText(model.getValueAt(i, 5).toString());

	}

	public void setTableGet(int i, DefaultTableModel model) {
		model.setValueAt(textSuppD.getText(), i, 0);
		model.setValueAt(textSuppName.getText(), i, 1);
		model.setValueAt(textSuppAddr.getText(), i, 2);
		model.setValueAt(textSuppPhone.getText(), i, 3);
		model.setValueAt(textSuppEmail.getText(), i, 4);
		model.setValueAt(textTimereg.getText(), i, 5);

	}
}

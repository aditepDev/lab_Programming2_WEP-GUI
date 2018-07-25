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
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.model.beans.InvoiceDetailsModel;
import org.model.beans.InvoiceModel;
import org.model.beans.StationeriesModel;
import org.model.beans.SupplierGoodModel;
import org.model.beans.SuppliersModel;
import org.model.dao.InvoiceDAO;
import org.model.dao.InvoiceDetailsDAO;
import org.model.dao.StationeriesDAO;
import org.model.dao.SupplierGoodDAO;
import org.model.dao.SuppliersDAO;
import org.model.db.Database;

import app.main.SuppliersGoodsManage.Item;

public class ProcureMentChkManage extends JDialog {
	public ProcureMentChkManage(JFrame frame) {
		super(frame, true);

		JTable table = new JTable();
		JTable table2 = new JTable();

		Object[] columns = { "INVOICE_ID", "SUPPLIERS_ID", "SUPPLIERS_NAME", "INV_DATE", "TOTAL", "STATUS",
				"TIME_REG" };
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		table.setModel(model);

		table.setBackground(Color.LIGHT_GRAY);
		table.setForeground(Color.BLACK);
		Font font = new Font("", 1, 22);
		table.setFont(font);
		table.setRowHeight(30);

		Object[] columns1 = { "INVOICE_DETAILS_ID", "INVOICE_ID", "GOODS_ID", "GOODS_NAME", "QTY", "AMOUNT", "STATUS",
				"TIME_REG" };
		DefaultTableModel model1 = new DefaultTableModel();
		model1.setColumnIdentifiers(columns1);

		table2.setModel(model1);
		table2.setBackground(Color.LIGHT_GRAY);
		table2.setForeground(Color.BLACK);
		table2.setFont(font);
		table2.setRowHeight(30);

		// get customer from db
		getAllInvoice(model);

		JButton btnUpdateAll = new JButton("Update All");
		JButton btnUpdate = new JButton("Update");
		JButton btnUpdateC = new JButton("Disble");

		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(0, 0, 880, 200);

		JScrollPane pane2 = new JScrollPane(table2);
		pane2.setBounds(0, 200, 880, 200);

		btnUpdateAll.setBounds(20, 450, 100, 25);
		btnUpdate.setBounds(20, 480, 100, 25);
		btnUpdateC.setBounds(20, 510, 100, 25);

		setLayout(null);
		add(btnUpdateC);
		add(btnUpdateAll);
		add(btnUpdate);
		add(pane);
		add(pane2);

	//	Object[] row = new Object[8];
		// add actions

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				setTable(Integer.parseInt(model.getValueAt(i, 0).toString()), model1);
			}
		});

		btnUpdateC.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int i = table2.getSelectedRow();
				int i2 = table.getSelectedRow();
				System.out.println(i);
				if (i >= 0) {
					Database db = new Database();
					InvoiceDetailsDAO invDDAO = new InvoiceDetailsDAO(db);
					InvoiceDetailsModel invDModel = new InvoiceDetailsModel();
					invDModel.setInvoice_deteils_id(Integer.parseInt(table2.getValueAt(i, 0).toString()));
					invDModel.setStatus(0);
					invDDAO.UpdateStatus(invDModel);

					if (invDModel.getStatus() == 0) {
						InvoiceDAO InvDAO = new InvoiceDAO(db);
						InvoiceModel InvModel = new InvoiceModel();
						InvModel.setInvoice_id(Integer.parseInt(table.getValueAt(i2, 0).toString()));
						InvModel.setStatus(1);
						InvDAO.Updatestatus(InvModel);
						db.close();
					} else if (invDModel.getStatus() >= 1) {
						InvoiceDAO InvDAO = new InvoiceDAO(db);
						InvoiceModel InvModel = new InvoiceModel();
						InvModel.setInvoice_id(Integer.parseInt(table.getValueAt(i2, 0).toString()));
						InvModel.setStatus(0);
						InvDAO.Updatestatus(InvModel);
						db.close();
					}

					setTable(Integer.parseInt(model.getValueAt(i2, 0).toString()), model1);
					getAllInvoice(model);
				} else {
					JOptionPane.showMessageDialog(frame, "Please select row on Invoice Datails table");
				}
			}

		});

		btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int i = table2.getSelectedRow();
				int i2 = table.getSelectedRow();
				System.out.println("table" + i);

				if (i >= 0) {
					Database db = new Database();
					InvoiceDetailsDAO invDDAO = new InvoiceDetailsDAO(db);
					InvoiceDetailsModel invDModel = new InvoiceDetailsModel();
					invDModel.setInvoice_deteils_id(Integer.parseInt(table2.getValueAt(i, 0).toString()));
					invDModel.setStatus(1);
					invDDAO.UpdateStatus(invDModel);
				
					InvoiceDAO InvDAO = new InvoiceDAO(db);
					InvoiceModel InvModel = new InvoiceModel();
					invDDAO = new InvoiceDetailsDAO(db);
					invDModel = new InvoiceDetailsModel();
					
					if (invDModel.getStatus() == 0) {
						InvModel.setInvoice_id(Integer.parseInt(table.getValueAt(i2, 0).toString()));
						InvModel.setStatus(1);
						InvDAO.Updatestatus(InvModel);
					} else if (invDModel.getStatus() == 1) {
						InvModel.setInvoice_id(Integer.parseInt(table.getValueAt(i2, 0).toString()));
						InvModel.setStatus(0);
						InvDAO.Updatestatus(InvModel);
					}
						
					

					db.close();
					setTable(Integer.parseInt(model.getValueAt(i2, 0).toString()), model1);
					getAllInvoice(model);
				} else {
					JOptionPane.showMessageDialog(frame, "Please select row on Invoice Datails table");
				}
			}

		});

		btnUpdateAll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				System.out.println(i);
				if (i >= 0) {
					Database db = new Database();
					InvoiceDAO InvDAO = new InvoiceDAO(db);
					InvoiceModel InvModel = new InvoiceModel();
					InvModel.setInvoice_id(Integer.parseInt(table.getValueAt(i, 0).toString()));
					InvModel.setStatus(2);
					InvDAO.Updatestatus(InvModel);
					db.close();

					db = new Database();
					InvoiceDetailsDAO invDDAO = new InvoiceDetailsDAO(db);
					InvoiceDetailsModel invDModel = new InvoiceDetailsModel();
					invDModel.setInvoice_id(InvModel);
					invDModel.setStatus(1);
					invDDAO.UpdateStatusByInvoice(invDModel);
					db.close();

					int i2 = table.getSelectedRow();
					setTable(Integer.parseInt(model.getValueAt(i2, 0).toString()), model1);
					getAllInvoice(model);

				} else {
					JOptionPane.showMessageDialog(frame, "Please select row on Invoice Datails table");
				}
			}
		});

		setTitle("ProcurementChk Management");
		setSize(900, 600);
		setLocationRelativeTo(null);
	}

	public void getAllInvoice(DefaultTableModel model) {
		Database db = new Database();
		InvoiceDAO InvGDAO = new InvoiceDAO(db);
		ArrayList<InvoiceModel> InvList = InvGDAO.FindAll();
		db.close();

		int i = 0;
		for (Iterator<InvoiceModel> iterator = InvList.iterator(); iterator.hasNext(); i++) {
			InvoiceModel InvModel = iterator.next();

			model.addRow(new Object[0]);
			model.setValueAt(InvModel.getInvoice_id(), i, 0);
			model.setValueAt(InvModel.getSuppliers_id().getSuppliers_id(), i, 1);
			model.setValueAt(InvModel.getSuppliers_id().getName(), i, 2);
			model.setValueAt(InvModel.getInv_date(), i, 3);
			model.setValueAt(InvModel.getTotal(), i, 4);

			String status = "ยังไม่รับ";
			if (InvModel.getStatus() == 1) {
				status = "รับยังไม่ครบ";
			} else if (InvModel.getStatus() == 2) {
				status = "รับครบแล้ว";
			}
			model.setValueAt(status, i, 5);
			model.setValueAt(InvModel.getTime_reg(), i, 6);

		}
	}

	public void setTable(int id, DefaultTableModel model) {

		for (int i = 0; i < model.getRowCount(); i++) {
			model.removeRow(i);
		}

		Database db = new Database();
		InvoiceDetailsDAO invDDAO = new InvoiceDetailsDAO(db);
		ArrayList<InvoiceDetailsModel> InvDList = invDDAO.FindByInvDID(id);
		db.close();
		int i = 0;
		for (Iterator<InvoiceDetailsModel> iterator = InvDList.iterator(); iterator.hasNext(); i++) {
			InvoiceDetailsModel InvDModel = iterator.next();

			model.addRow(new Object[0]);
			model.setValueAt(InvDModel.getInvoice_deteils_id(), i, 0);
			model.setValueAt(InvDModel.getInvoice_id().getInvoice_id(), i, 1);
			model.setValueAt(InvDModel.getGoods_id().getGoods_id(), i, 2);
			model.setValueAt(InvDModel.getGoods_id().getGoods_name(), i, 3);
			model.setValueAt(InvDModel.getQty(), i, 4);
			model.setValueAt(InvDModel.getAmount(), i, 5);

			String status = "ยังไม่รับ";
			if (InvDModel.getStatus() != 0) {
				status = "รับแล้ว";

			}
			model.setValueAt(status, i, 6);
			model.setValueAt(InvDModel.getTime_reg(), i, 7);

		}

	}

}

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

import org.model.beans.StationeriesModel;
import org.model.beans.SupplierGoodModel;
import org.model.beans.SuppliersModel;
import org.model.dao.StationeriesDAO;
import org.model.dao.SupplierGoodDAO;
import org.model.dao.SuppliersDAO;
import org.model.db.Database;

public class SuppliersGoodsManage extends JDialog {
	JTextField textSuppGID;
	JTextField textSuppID;
	JTextField textSuppName;
	JTextField textGoodsID;
	JTextField textGoodsName;
	JTextField textPrice;
	JTextField textStockQty;
	JTextField textTimereg;

	JComboBox comboBoxGoods;
	JComboBox comboBoxSupp;
	ArrayList<StationeriesModel> stnList;
	ArrayList<SuppliersModel> suppList;

	public SuppliersGoodsManage(JFrame frame) {
		super(frame, true);

		JTable table = new JTable();

		Object[] colums = { "SUPPLIER_GOOD_ID", "SUPPLIERS_ID", "SUPPLIERS_NAME", "GOODS_ID", "GOODS_NAME", "PRICE",
				"STOCK_QTY", "TIME_REG" };
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(colums);
		table.setModel(model);

		table.setBackground(Color.LIGHT_GRAY);
		table.setForeground(Color.BLACK);
		Font font = new Font("", 1, 22);
		table.setRowHeight(30);

		// get customer from db
		getAllSuppliersGoods(model);

		comboBoxGoods = new JComboBox();
		comboBoxSupp = new JComboBox();

		Database db = new Database();
		StationeriesDAO stnDAO = new StationeriesDAO(db);
		stnList = stnDAO.FindAll();
		db.close();
		for (StationeriesModel stationeriesModel : stnList) {
			comboBoxGoods.addItem(new Item(stationeriesModel.getGoods_id(), stationeriesModel.getGoods_name()));
		}

		db = new Database();
		SuppliersDAO suppDAO = new SuppliersDAO(db);
		suppList = suppDAO.FindAll();
		db.close();

		for (SuppliersModel suppliersModel : suppList) {
			comboBoxSupp.addItem(new Item(suppliersModel.getSuppliers_id(), suppliersModel.getName()));
		}

		textSuppGID = new JTextField();
		textSuppID = new JTextField();
		textSuppName = new JTextField();
		textGoodsID = new JTextField();
		textGoodsName = new JTextField();
		textPrice = new JTextField();
		textStockQty = new JTextField();
		textTimereg = new JTextField();

		JButton btnAdd = new JButton("Add");
		JButton btnUpdate = new JButton("Update ");
		JButton btnDelete = new JButton("Delete");

		
		
		//label
				JLabel label1 = new JLabel("รหัส SuppGID ");
				JLabel label2 = new JLabel("ชื่อ ซัพ	");
				JLabel label3 = new JLabel("ที่ชื่อ ซัพ ");
				JLabel label4 = new JLabel("ชื่อสินค้า ");
				JLabel label5 = new JLabel("ชื่อสินค้า ");
				JLabel label6 = new JLabel("ราคา");
				JLabel label7 = new JLabel("จำนวน");
				JLabel label8 = new JLabel("เวลา");
				
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
		
		
		textSuppGID.setBounds(150, 220, 100, 25);		
		comboBoxSupp.setBounds(150, 250, 100, 25);
		textSuppName.setBounds(150, 280, 100, 25);	
		comboBoxGoods.setBounds(150, 310, 100, 25);
		textGoodsName.setBounds(150, 340, 100, 25);
		textPrice.setBounds(150, 370, 100, 25);
		textStockQty.setBounds(150, 400, 100, 25);
		textTimereg.setBounds(150, 430, 100, 25);

		textSuppGID.setEnabled(false);
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
		add(textSuppGID);
		add(textSuppID);
		add(textSuppName);
		add(textGoodsID);
		add(textGoodsName);
		add(textPrice);
		add(textStockQty);
		add(textTimereg);
		add(comboBoxGoods);
		add(comboBoxSupp);
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
				SupplierGoodDAO suppGDAO = new SupplierGoodDAO(db);
				SupplierGoodModel suppGModel = new SupplierGoodModel();

				// int suppID = Integer.parseInt(textSuppID.getText().trim().toString());
				// int goodsId = Integer.parseInt(textGoodsID.getText().trim().toString());
				Item itemsupp = (Item) comboBoxSupp.getSelectedItem();
				Item itemgoods = (Item) comboBoxGoods.getSelectedItem();

				int suppID = itemsupp.getId();
				int goodsId = itemgoods.getId();
				System.out.println("SUP: " + itemsupp.getId() + " : " + itemsupp.getDescription());
				System.out.println("GOOD: " + itemgoods.getId() + " : " + itemgoods.getDescription());

				int price = Integer.parseInt(textPrice.getText().trim().toString());
				int stockQty = Integer.parseInt(textStockQty.getText().trim().toString());

				SuppliersModel suppModel = new SuppliersModel();
				suppModel.setSuppliers_id(suppID);
				StationeriesModel stnModel = new StationeriesModel();
				stnModel.setGoods_id(goodsId);

				suppGModel.setSupplier_id(suppModel);
				suppGModel.setGoods_id(stnModel);
				suppGModel.setPrice(price);
				suppGModel.setStockOty(stockQty);

				int return_id = suppGDAO.Add(suppGModel);
				db.commit();
				db.close();

				db = new Database();

				suppGDAO = new SupplierGoodDAO(db);
				suppGModel = suppGDAO.FindByID(return_id);
				db.close();

				row[0] = suppGModel.getSupplire_good_id();
				row[1] = suppGModel.getSupplier_id().getSuppliers_id();
				row[2] = suppGModel.getSupplier_id().getName();
				row[3] = suppGModel.getGoods_id().getGoods_id();
				row[4] = suppGModel.getGoods_id().getGoods_name();
				row[5] = suppGModel.getPrice();
				row[6] = suppGModel.getStockOty();
				row[7] = suppGModel.getTime_reg();

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
					System.out.println("row-update-suppG-id" + textSuppGID.getText());

					int suppGID = Integer.parseInt(textSuppGID.getText().trim());
					// int suppID = Integer.parseInt(textSuppID.getText().trim().toString());
					Item itemsupp = (Item) comboBoxSupp.getSelectedItem();
					Item itemgoods = (Item) comboBoxGoods.getSelectedItem();

					int suppID = itemsupp.getId();
					int goodsId = itemgoods.getId();
					System.out.println("SUP: " + itemsupp.getId() + " : " + itemsupp.getDescription());
					System.out.println("GOOD: " + itemgoods.getId() + " : " + itemgoods.getDescription());

					// int goodsId = Integer.parseInt(textGoodsID.getText().trim().toString());
					int price = Integer.parseInt(textPrice.getText().trim().toString());
					int stockQty = Integer.parseInt(textStockQty.getText().trim().toString());

					Database db = new Database();
					SupplierGoodDAO suppGDAO = new SupplierGoodDAO(db);
					SupplierGoodModel suppGModel = new SupplierGoodModel();

					SuppliersModel suppModel = new SuppliersModel();
					suppModel.setSuppliers_id(suppID);
					StationeriesModel stnModel = new StationeriesModel();
					stnModel.setGoods_id(goodsId);

					suppGModel.setSupplire_good_id(suppGID);
					suppGModel.setSupplier_id(suppModel);
					suppGModel.setGoods_id(stnModel);
					suppGModel.setPrice(price);
					suppGModel.setStockOty(stockQty);
					suppGDAO.Update(suppGModel);

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
					System.out.println("row-Delete-suppID" + textSuppGID.getText());
					int suppGID = Integer.parseInt(textSuppGID.getText().trim());

					Database db = new Database();
					SupplierGoodDAO suppGDAO = new SupplierGoodDAO(db);
					SupplierGoodModel suppGModel = new SupplierGoodModel();
					suppGModel.setSupplire_good_id(suppGID);
					suppGDAO.Delete(suppGModel);
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

		comboBoxGoods.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Goods selected");
				JComboBox c = (JComboBox) e.getSource();
				Item item = (Item) c.getSelectedItem();
				System.out.println(item.getId() + ":" + item.getDescription());
			}
		});
		comboBoxSupp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("suppliers selected");
				JComboBox c = (JComboBox) e.getSource();
				Item item = (Item) c.getSelectedItem();
				System.out.println(item.getId() + ":" + item.getDescription());
			}
		});

		setTitle("SuppliersGoods Management");
		setSize(900, 600);
		setLocationRelativeTo(null);

	}

	public void getAllSuppliersGoods(DefaultTableModel model) {
		Database db = new Database();
		SupplierGoodDAO suppGDAO = new SupplierGoodDAO(db);
		ArrayList<SupplierGoodModel> suppGList = suppGDAO.FindAll();
		db.close();
		int i = 0;
		for (Iterator<SupplierGoodModel> iterator = suppGList.iterator(); iterator.hasNext(); i++) {
			SupplierGoodModel supGModel = iterator.next();
			// System.out.println(cusModel.getCustomerId());
			model.addRow(new Object[0]);

			model.setValueAt(supGModel.getSupplire_good_id(), i, 0);
			model.setValueAt(supGModel.getSupplier_id().getSuppliers_id(), i, 1);
			model.setValueAt(supGModel.getSupplier_id().getName(), i, 2);
			model.setValueAt(supGModel.getGoods_id().getGoods_id(), i, 3);
			model.setValueAt(supGModel.getGoods_id().getGoods_name(), i, 4);
			model.setValueAt(supGModel.getPrice(), i, 5);
			model.setValueAt(supGModel.getStockOty(), i, 6);
			model.setValueAt(supGModel.getTime_reg(), i, 7);

		}
	}

	public void setTable(int i, DefaultTableModel model) {
		textSuppGID.setText(model.getValueAt(i, 0).toString());
		textSuppID.setText(model.getValueAt(i, 1).toString());
		int count1 = 0;
		for (SuppliersModel supp : suppList) {
			int id = Integer.parseInt(textSuppID.getText());
			if (id == supp.getSuppliers_id()) {
				comboBoxSupp.setSelectedIndex(count1);
				break;
			}
			count1++;
		}

		textSuppName.setText(model.getValueAt(i, 2).toString());
		textGoodsID.setText(model.getValueAt(i, 3).toString());
		count1 = 0;
		for (StationeriesModel stn : stnList) {
			int id = Integer.parseInt(textGoodsID.getText());
			if (id == stn.getGoods_id()) {
				comboBoxGoods.setSelectedIndex(count1);
			}
			count1++;
		}
		textGoodsName.setText(model.getValueAt(i, 4).toString());
		textPrice.setText(model.getValueAt(i, 5).toString());
		textStockQty.setText(model.getValueAt(i, 6).toString());
		textTimereg.setText(model.getValueAt(i, 7).toString());
	}

	public void setTableGet(int i, DefaultTableModel model) {
		model.setValueAt(textSuppGID.getText(), i, 0);
		model.setValueAt(textSuppID.getText(), i, 1);

		Item itemsupp = (Item) comboBoxSupp.getSelectedItem();

		model.setValueAt(itemsupp.getDescription(), i, 2);
		model.setValueAt(textGoodsID.getText(), i, 3);

		Item itemgoods = (Item) comboBoxGoods.getSelectedItem();

		model.setValueAt(itemgoods.getDescription(), i, 4);
		model.setValueAt(textPrice.getText(), i, 5);
		model.setValueAt(textStockQty.getText(), i, 6);
		model.setValueAt(textTimereg.getText(), i, 7);

	}

	public void getText() {

	}

	class Item {

		private int id;
		private String description;

		public Item(int id, String description) {
			this.id = id;
			this.description = description;
		}

		public int getId() {
			return id;
		}

		public String getDescription() {
			return description;
		}

		@Override
		public String toString() {
			return description;
		}

	}

}

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

import app.main.SuppliersGoodsManage.Item;

public class ProcurementManage extends JDialog {
	JTextField textGoodsID;
	JTextField textGoodsName;
	JTextField textStockQty;
	JTextField textAmount;

	JComboBox comboBoxGoods;
	JComboBox comboBoxSupp;
	ArrayList<StationeriesModel> stnList;
	ArrayList<SuppliersModel> suppList;

	public ProcurementManage(JFrame frame) {
		super(frame, true);

		JTable table = new JTable();

		Object[] colums = { "GOODS_ID", "GOODS_NAME", "QTY", "AMOUNT" };
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(colums);
		table.setModel(model);

		table.setBackground(Color.LIGHT_GRAY);
		table.setForeground(Color.BLACK);
		Font font = new Font("", 1, 22);
		table.setRowHeight(30);

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
	
		
		textGoodsID = new JTextField();
		textGoodsName = new JTextField();
		textStockQty = new JTextField();
		textAmount = new JTextField();

		JButton btnAdd = new JButton("Add");
		JButton btnUpdate = new JButton("Update ");
		JButton btnDelete = new JButton("Delete");
		comboBoxGoods.setBounds(20, 280, 100, 25);
		comboBoxSupp.setBounds(20, 250, 100, 25);
		textGoodsName.setBounds(20, 340, 100, 25);
		btnAdd.setBounds(150, 220, 100, 25);
		btnUpdate.setBounds(150, 265, 100, 25);
		btnDelete.setBounds(150, 310, 100, 25);

		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(0, 0, 880, 200);

		setLayout(null);
		add(comboBoxGoods);
		add(comboBoxSupp);
		/// add pane
		add(pane);
		// add text
		add(textGoodsID);
		add(textGoodsName);
		add(textStockQty);
		add(textAmount);

		// add btn
		add(btnAdd);
		add(btnUpdate);
		add(btnDelete);

		Object[] row = new Object[8];
		// add actions
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

		setTitle("Suppliers Management");
		setSize(900, 600);
		setLocationRelativeTo(null);

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

	}
}

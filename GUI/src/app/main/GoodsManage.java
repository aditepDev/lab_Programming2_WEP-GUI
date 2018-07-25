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
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.model.beans.CustomerModel;
import org.model.beans.StationeriesModel;
import org.model.dao.CustomerDAO;
import org.model.dao.StationeriesDAO;
import org.model.db.Database;

public class GoodsManage extends JDialog {
	
	JTextField textGoodID;
	JTextField textGoodName;
	JTextField textDescript;
	JTextField textcolor;
	JTextField texttimereg;
 
	
	public GoodsManage(JFrame frame) {
		super(frame, true);

		JTable table = new JTable();

		Object[] colums = { "GOODS_ID", "GOODS_NAME", "DESCRIPT", "COLOR", "TIME_REG"};
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(colums);
		table.setModel(model);

		table.setBackground(Color.LIGHT_GRAY);
		table.setForeground(Color.BLACK);
		Font font = new Font("", 1, 22);
		table.setRowHeight(30);

		// get customer from db
		getAllgoods(model);

		textGoodID = new JTextField();
		textGoodName = new JTextField();
		textDescript = new JTextField();
		textcolor = new JTextField();
		texttimereg = new JTextField();
		

		JButton btnAdd = new JButton("Add");
		JButton btnUpdate = new JButton("Update ");
		JButton btnDelete = new JButton("Delete");
		
		
		//label
		JLabel label1 = new JLabel("รหัสสินค้า   ");
		JLabel label2 = new JLabel("ชื่อสินค้า ");
		JLabel label3 = new JLabel("รานละเอียด ");
		JLabel label4 = new JLabel("สี  ");
		JLabel label5 = new JLabel("เวลา ");
		
		label1.setBounds(20, 220, 100, 25);
		label2.setBounds(20, 250, 100, 25);
		label3.setBounds(20, 280, 100, 25);
		label4.setBounds(20, 310, 100, 25);
		label5.setBounds(20, 340, 100, 25);
		add(label1);
		add(label2);
		add(label3);
		add(label4);
		add(label5);
		
		textGoodID.setBounds(150, 220, 100, 25);
		textGoodName.setBounds(150, 250, 100, 25);
		textDescript.setBounds(150, 280, 100, 25);
		textcolor.setBounds(150, 310, 100, 25);
		texttimereg.setBounds(150, 340, 100, 25);
	

		textGoodID.setEnabled(false);
		texttimereg.setEnabled(false);

		btnAdd.setBounds(350, 220, 100, 25);
		btnUpdate.setBounds(350, 265, 100, 25);
		btnDelete.setBounds(350, 310, 100, 25);

		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(0, 0, 880, 200);

		setLayout(null);

		/// add pane
		add(pane);
		// add textf
		add(textGoodID);
		add(textGoodName);
		add(textDescript);
		add(textcolor);
		add(texttimereg);
	;

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
				StationeriesDAO stnDAO = new StationeriesDAO(db);
				StationeriesModel stnModel = new StationeriesModel();
				
				
				String stnname = textGoodName.getText();
				String stndes = textDescript.getText();
				String stncolor = textcolor.getText();
		

				stnModel.setGoods_name(stnname);
				stnModel.setDescript(stndes);
				stnModel.setColor(stncolor);
			
				int return_id = stnDAO.Add(stnModel);
				db.commit();
				db.close();
				
				db = new Database();
				
				stnDAO = new StationeriesDAO(db);
				
				stnModel = stnDAO.FindByID(return_id);
				
				db.close();
				
				row[0] = stnModel.getGoods_id();
				row[1] = stnModel.getGoods_name();
				row[2] = stnModel.getDescript();
				row[3] = stnModel.getColor();
				row[4] = stnModel.getTime_reg();
				

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
					System.out.println("row-update-goods-select" + i);
					System.out.println("row-update-goods-id" + textGoodID.getText());
					int goodsID = Integer.parseInt(textGoodID.getText().trim());
					String goodsName = textGoodName.getText();
					String goodsdes = textDescript.getText();
					String goodscolor = textcolor.getText();
				

					Database db = new Database();
					StationeriesDAO stnDAO = new StationeriesDAO(db);
					StationeriesModel stnModel = new StationeriesModel();
					stnModel.setGoods_id(goodsID);
					stnModel.setGoods_name(goodsName);
					stnModel.setDescript(goodsdes);
					stnModel.setColor(goodscolor);
					
					stnDAO.Update(stnModel);

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
					System.out.println("row-Delete stn" + i);
					System.out.println("row-Delete stn" + textGoodID.getText());
					int goodID = Integer.parseInt(textGoodID.getText().trim());

					Database db = new Database();
					StationeriesDAO stnDAO = new StationeriesDAO(db);
					StationeriesModel stnModel = new StationeriesModel();
					stnModel.setGoods_id(goodID);
					stnDAO.Delete(stnModel);
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

		setTitle("Goods Management");
		setSize(900, 600);
		setLocationRelativeTo(null);
	}
	public void getAllgoods(DefaultTableModel model) {
		Database db = new Database();
		StationeriesDAO stnDAO = new StationeriesDAO(db);
		ArrayList<StationeriesModel> stnList = stnDAO.FindAll();
		db.close();
		int i = 0;
		for (Iterator<StationeriesModel> iterator = stnList.iterator(); iterator.hasNext(); i++) {
			StationeriesModel stnModel = iterator.next();
			// System.out.println(cusModel.getCustomerId());
			model.addRow(new Object[0]);

			model.setValueAt(stnModel.getGoods_id(), i, 0);
			model.setValueAt(stnModel.getGoods_name(), i, 1);
			model.setValueAt(stnModel.getDescript(), i, 2);
			model.setValueAt(stnModel.getColor(), i, 3);
			model.setValueAt(stnModel.getTime_reg(), i, 4);
		

		}
	}

	public void setTable(int i, DefaultTableModel model) {
		textGoodID.setText(model.getValueAt(i, 0).toString());
		textGoodName.setText(model.getValueAt(i, 1).toString());
		textDescript.setText(model.getValueAt(i, 2).toString());
		textcolor.setText(model.getValueAt(i, 3).toString());
		texttimereg.setText(model.getValueAt(i, 4).toString());
	

	}

	public void setTableGet(int i, DefaultTableModel model) {
		model.setValueAt(textGoodID.getText(), i, 0);
		model.setValueAt(textGoodName.getText(), i, 1);
		model.setValueAt(textDescript.getText(), i, 2);
		model.setValueAt(textcolor.getText(), i, 3);
		model.setValueAt(texttimereg.getText(), i, 4);
	

	}

	public void getText() {

	}
}

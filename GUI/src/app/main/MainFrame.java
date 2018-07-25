package app.main;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JPanel implements ActionListener {

	CustomerManage cusManage;
	GoodsManage goodsManage;
	SuppliersManage supManage;
	SuppliersGoodsManage suppGManage;
	ProcurementManage procManage;
	Report2D report2D;
	ProcureMentChkManage procManageChk;

	private static final String cusManageString = "จัดการลูกค้า";
	private static final String goodsManageString = "จัดการสินค้า";
	private static final String supManageString = "จัดการซัพพลายเออร์";
	private static final String suppGManageString = "จัดการซัพพลายเออร์สินค้า";
	private static final String procManageString = "การสั่งซื้อสินค้า";
	private static final String procManageChkString = "การตรวจรับสินค้าเข้าร้าน";
	private static final String report2DString = "รายงาน  2D";

	public MainFrame(JFrame frame) {
		super();
		
		cusManage = new CustomerManage(frame);
		goodsManage = new GoodsManage(frame);
		supManage = new SuppliersManage(frame);
		suppGManage = new SuppliersGoodsManage(frame);
		procManage = new ProcurementManage(frame);
		procManageChk = new ProcureMentChkManage(frame);
		report2D = new Report2D(frame);
		
		
		
		
		int panelWidth = 500;
		int panelHeight = 400;
		setLayout(null);

		JLabel mainLabel = new JLabel("Main Menu");
		JButton cusMangeBtn = new JButton(cusManageString);
		JButton goodsManageBtn = new JButton(goodsManageString);
		JButton supManageBtn = new JButton(supManageString);
		JButton suppGManageBtn = new JButton(suppGManageString);
		JButton procManageBtn = new JButton(procManageString);
		JButton procManageChkBtn = new JButton(procManageChkString);
		JButton report2DBtn = new JButton(report2DString);
		
		cusMangeBtn.addActionListener(this);
		goodsManageBtn.addActionListener(this);
		supManageBtn.addActionListener(this);
		suppGManageBtn.addActionListener(this);
		procManageBtn.addActionListener(this);
		procManageChkBtn.addActionListener(this);
		report2DBtn.addActionListener(this);

		add(mainLabel);
		add(cusMangeBtn);
		add(goodsManageBtn);
		add(supManageBtn);
		add(suppGManageBtn);
		add(procManageBtn);
		add(procManageChkBtn);
		add(report2DBtn);

		Dimension size = mainLabel.getPreferredSize();
		mainLabel.setBounds((panelWidth - size.width) / 2, 20, size.width, size.height);
		size = cusMangeBtn.getPreferredSize();
		cusMangeBtn.setBounds((panelWidth - size.width) / 2, 60, size.width, size.height);
		size = goodsManageBtn.getPreferredSize();
		goodsManageBtn.setBounds((panelWidth - size.width) / 2, 100, size.width, size.height);
		size = supManageBtn.getPreferredSize();
		supManageBtn.setBounds((panelWidth - size.width) / 2, 140, size.width, size.height);
		size = suppGManageBtn.getPreferredSize();
		suppGManageBtn.setBounds((panelWidth - size.width) / 2, 180, size.width, size.height);
		size = procManageBtn.getPreferredSize();
		procManageBtn.setBounds((panelWidth - size.width) / 2, 220, size.width, size.height);
		size = procManageChkBtn.getPreferredSize();
		procManageChkBtn.setBounds((panelWidth - size.width) / 2, 260, size.width, size.height);
		size = report2DBtn.getPreferredSize();
		report2DBtn.setBounds((panelWidth - size.width) / 2, 300, size.width, size.height);

		this.setPreferredSize(new Dimension(panelWidth, panelHeight));
	}

	private static void createAndShowGUI() {

		JFrame frame = new JFrame("Mini Supply Chain Project");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new MainFrame(frame));
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		System.out.println("actionCommand:" + actionCommand);
		if (actionCommand.equals(cusManageString)) {
			System.out.println("event-click :" + cusManageString);
			cusManage.setVisible(true);
			
		} else if (actionCommand.equals(goodsManageString)) {
			System.out.println("equals " + goodsManageString);
			goodsManage.setVisible(true);
			
		} else if (actionCommand.equals(supManageString)) {
			System.out.println("event-click :" + supManageString);
			supManage.setVisible(true);
			
		} else if (actionCommand.equals(suppGManageString)) {
			System.out.println("event-click : " + suppGManageString);
			suppGManage.setVisible(true);
			
		} else if (actionCommand.equals(procManageString)) {
			System.out.println("event-click : " + procManageString);
			
			procManage.setVisible(true);
		} else if(actionCommand.equals(procManageChkString)){
			
			System.out.println("event-click : " + procManageChkString);
			procManageChk.setVisible(true);
		} else if (actionCommand.equals(report2DString)) {
			System.out.println("event-click : " + report2DString);
			report2D.setVisible(true);
		}

	}

}

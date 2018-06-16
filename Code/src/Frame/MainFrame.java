package Frame;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import RC4.RC4;

public class MainFrame extends JFrame implements ActionListener{
	private ButtonGroup bg = new ButtonGroup();// 实例化一个按钮组
	private JTextField JteString;
	private JTextField JteMI;
	private JTextField JteMing;
	private JTextArea JteMIW;
	private JPanel jPanel=new JPanel();
	private JPanel jPl = new JPanel();
	private JPanel jpl1=new JPanel();
	private JPanel jpl2=new JPanel();
	private JButton JbuMI=new JButton();
	private JButton JbuMing=new JButton();
	private JButton JbuQing=new JButton();
			
	public void GUI() {
		this.setTitle("密码学");
		this.setSize(425,400);
		this.setLocation(100, 100);
		jPanel.setLayout(new BorderLayout());
		jPl.setLayout(new FlowLayout(FlowLayout.CENTER));
		jpl1.setLayout(new FlowLayout(FlowLayout.CENTER));
		jpl2.setLayout(new FlowLayout(FlowLayout.CENTER));
		//添加Label
		JLabel JlaString =new JLabel("输入加密明文");
		JLabel JlaMI =new JLabel("输入加密密钥");
		JLabel JlaMIW=new JLabel("密文");
		JLabel JlaMing =new JLabel("解密后");
		//输入文本框
		JteString =new JTextField(35);//明文
		JteMI =new JTextField(35);   //密钥
		JteMIW=new JTextArea(4,35);  //密文
		JteMing =new JTextField(35);   //解密
		//按钮
		JButton JbuMI=new JButton("加密");
		JButton JbuMing=new JButton("解密");
		JButton JbuQing=new JButton("清空");
		/************按钮组的建立************/
		JRadioButton jRC4 = new JRadioButton("RC4");
		jRC4.setActionCommand("RC4");
		
		//this.bg.add(jAES);
		this.bg.add(jRC4);
		jPl.add(jRC4);
		//jPl.add(jAES);
		jpl1.add(JlaString);
		jpl1.add(JteString);
		jpl1.add(JlaMI);
		jpl1.add(JteMI);
		jpl1.add(JlaMIW);
		jpl1.add(JteMIW);
		jpl1.add(JlaMing);
		jpl1.add(JteMing);
		jpl2.add(JbuMI);
		jpl2.add(JbuMing);	
		jpl2.add(JbuQing);
		jPanel.add(jPl,BorderLayout.NORTH);
		jPanel.add(jpl1, BorderLayout.CENTER);
		jPanel.add(jpl2, BorderLayout.SOUTH);
		this.add(jPanel);
		this.setVisible(true);
		JbuMI.addActionListener(this);
		JbuMing.addActionListener(this);
		JbuQing.addActionListener(this);
		
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String stringbutton = e.getActionCommand();
		String command = bg.getSelection().getActionCommand();
      
       if (command.equals("RC4")) {
    	    String string = JteString.getText().toString();
    	    String stringMi = JteMI.getText().toString();
			RC4 rc4 = new RC4();
			/*int[] Text = { 0x11, 0x22, 0x33, 0x44, 0x55, 0x66, 0x77, 0x88, 0x99,
					   0x00, 0xAA, 0xBB, 0xCC, 0xDD, 0xEE, 0xFF};*/
			int[] Text = { 0x00, 0x11, 0x66, 0x77, 0x22, 0x88, 0x33, 0x44, 0x99,
					   0x55, 0xAA, 0xBB, 0xCC, 0xDD, 0xEE, 0xFF};
			String aInput =rc4.BytesToString(Text);
			 /*int[] keys = {0x13, 0x57, 0x9B, 0xDF, 0x02, 0x46, 0x8A, 0xCE, 0x12,
		        		0x34, 0x56,0x78, 0x90, 0xAB, 0xCD, 0xEF};*/
			 
			 int[] keys = {0x12, 0x34, 0x5B, 0xDF, 0x56, 0x78, 0x9A, 0xBE, 0x12,
		        		0x34, 0x56,0x78, 0x90, 0xAB, 0xCD, 0xEF};
			String aKey = keys.toString();
			if (stringbutton.equals("加密")) {
				int[] encrypt = rc4.myRC4(Text, keys);
				int[] decrypt = rc4.myRC4(encrypt, keys);

		        JteMIW.setText(rc4.BytesToString(encrypt));
		        JteMIW.setLineWrap(true);
				 
			}
			
			if(stringbutton.equals("解密")){
				int[] encrypt = rc4.myRC4(Text, keys);
				int[] decrypt = rc4.myRC4(encrypt, keys);
				JteMing.setText(rc4.BytesToString(decrypt));
			}
			if(stringbutton.equals("清空")){
				JteMIW.setText(null);
				JteMing.setText(null);
			}
         }
		
	}
	public static void main(String[] args) {
		MainFrame mFrame=new MainFrame();
		mFrame.GUI();
	}
	
	
}

	


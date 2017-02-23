package insurance_package;

import java.awt.Color;

import javax.swing.*;

public class DataPanel extends JPanel{
	Originator ori ;
	CareTaker care ;
	protected JTextField txtownername;
	protected JTextField txtownerfname;
	protected JTextField txtfathername;
	protected JTextField txtmothername;
	protected JTextField txtbirthdate;
	protected JTextField txtbirthplace;
	protected JTextField txtaddress;
	protected JTextField txttel;
	
	public DataPanel(){
		setLayout(null);
		setBounds(50, 100, 620, 690);
		setBackground(new Color(150, 149, 187, 120));
	}
	
	protected void setUser(){
		txtownername.setText(ori.getState().getlName());
		txtownerfname.setText(ori.getState().getfName());
		txtfathername.setText(ori.getState().getfaName());
		txtmothername.setText(ori.getState().getmName());
		txtbirthdate.setText(ori.getState().getBirthdate());
		txtbirthplace.setText(ori.getState().getBirthplace());
		txtaddress.setText(ori.getState().getAddress());
		txttel.setText(ori.getState().getTel());
	}
	public void clearPerson(){
		txtownername.setText("");
		txtownerfname.setText("");
		txtfathername.setText("");
		txtmothername.setText("");
		txtbirthdate.setText("");
		txtbirthplace.setText("");
		txtaddress.setText("");
		txttel.setText("");
	}
}

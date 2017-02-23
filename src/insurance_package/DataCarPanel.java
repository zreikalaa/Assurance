package insurance_package;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DataCarPanel extends DataPanel {

	private JTextField txtappnb;
	private JTextField txtdate;
	private JTextField txtcarnumber;
	private JTextField txtcarmark;
	private JTextField txtmodelname;
	private JTextField txtyear;
	private JButton b;
	private ButtonGroup grp=new ButtonGroup();
	private JRadioButton limit1;
	private JRadioButton limit2;
	private JRadioButton limit3;
	private JRadioButton limit4;
	
	private JPasswordField txtpassword;
	private JTextField txtusername;
	
	
	Home home;
	
	public DataCarPanel(Home home, Originator ori, CareTaker care) {
		this.home = home;
		super.ori = ori;
		super.care = care;
		
		home.setCurrentPerson(care.getSize());
		setLayout(null);
		//setBorder(new TitledBorder("Cars"));

		
		
		JLabel title = new JLabel("Car Insurance",SwingConstants.CENTER);
		title.setFont(new Font(null, Font.CENTER_BASELINE, 24));
		title.setBounds(0, 20, getWidth(), 30);
		add(title);
		
    	JLabel l1=new MyJLabel("Application Number :");
    	l1.setBounds(10, 70, 150, 30);
    	add(l1);
    	txtappnb=new JTextField();
    	txtappnb.setBounds(160, 70, 150, 30);
    	add(txtappnb);
    	
    	JLabel l2=new MyJLabel("Date :");
    	l2.setBounds(10, 120, 150, 30);
    	add(l2);
    	txtdate=new JTextField();
    	DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
    	Date dateobj = new Date();
    	txtdate.setText(df.format(dateobj));
    	txtdate.setEnabled(false);
    	txtdate.setBounds(160, 120, 150, 30);
    	add(txtdate);
    	
    	JLabel l3=new MyJLabel("Owner Name :");
    	add(l3);
    	l3.setBounds(10, 180, 120, 30);
    	txtownername=new JTextField();
    	txtownername.setBounds(130, 180, 150, 30);
    	add(txtownername);
    	
    	JLabel l4=new MyJLabel("Owner First Name :");
    	add(l4);
    	l4.setBounds(300, 180, 140, 30);
    	txtownerfname=new JTextField(); 
    	txtownerfname.setBounds(450, 180, 150, 30);
    	add(txtownerfname);
    	
    	JLabel l5=new MyJLabel("Father Name :");
    	l5.setBounds(10, 230, 120, 30);
    	add(l5);
    	txtfathername=new JTextField();
    	txtfathername.setBounds(130, 230, 150, 30);
    	add(txtfathername);
    	
    	JLabel l6=new MyJLabel("Mother Name :");
    	add(l6);
    	l6.setBounds(300, 230, 140, 30);
    	txtmothername=new JTextField();
    	txtmothername.setBounds(450, 230, 150, 30);
    	add(txtmothername);
    	
    	JLabel l7=new MyJLabel("Birth Date :");
    	add(l7);
    	l7.setBounds(10, 280, 120, 30);
    	txtbirthdate=new JTextField();
    	txtbirthdate.setBounds(130, 280, 150, 30);
    	add(txtbirthdate);
    	
    	JLabel l8=new MyJLabel("Birth Place :");
    	add(l8);
    	l8.setBounds(300, 280, 140, 30);
    	txtbirthplace=new JTextField();
    	txtbirthplace.setBounds(450, 280, 150, 30);
    	add(txtbirthplace);
    	
    	JLabel l9=new MyJLabel("Plate Number :");
    	add(l9);
    	l9.setBounds(10, 330, 135, 30);
    	txtcarnumber=new JTextField();
    	txtcarnumber.setBounds(130, 330, 150, 30);
    	add(txtcarnumber);
    	
    	JLabel l10=new MyJLabel("Car Mark :");
    	add(l10);
    	l10.setBounds(300, 330, 80, 30);
    	txtcarmark=new JTextField();
    	txtcarmark.setBounds(450, 330, 150, 30);
    	add(txtcarmark);
    	
    	JLabel l11=new MyJLabel("Model Name :");
    	add(l11);
    	l11.setBounds(10, 380, 100, 30);
    	txtmodelname=new JTextField();
    	txtmodelname.setBounds(130, 380, 150, 30);
    	add(txtmodelname);
    	
    	JLabel l12=new MyJLabel("Year :");
    	add(l12);
    	l12.setBounds(10, 430, 100, 30);
    	txtyear=new JTextField();
    	txtyear.setBounds(130, 430, 150, 30);
    	add(txtyear);
    	
    	JLabel l13=new MyJLabel("Address:");
    	add(l13);
    	l13.setBounds(10, 480, 100, 30);
    	txtaddress=new JTextField();
    	txtaddress.setBounds(130, 480, 150, 30);
    	add(txtaddress);

    	JLabel l14=new MyJLabel("Tel Number :");
    	add(l14);
    	l14.setBounds(10, 530, 100, 30);
    	txttel=new JTextField();
    	txttel.setBounds(130, 530, 150, 30);
    	add(txttel);
    	
    	JLabel l15=new MyJLabel("Limit Of Covering :");
    	l15.setBounds(10, 580, 140, 30);
    	add(l15);
    	
    	limit1=new JRadioButton("10000$");
    	limit1.setBounds(155, 580, 80, 30);
    	grp.add(limit1);
    	add(limit1);
    	
    	limit2=new JRadioButton("15000$");
    	limit2.setBounds(235, 580, 80, 30);
    	grp.add(limit2);
    	add(limit2);
    	
    	limit3=new JRadioButton("20000$");
    	limit3.setBounds(315, 580, 80, 30);
    	grp.add(limit3);
    	add(limit3);
    	
    	limit4=new JRadioButton("25000$");
    	limit4.setBounds(395, 580, 80, 30);
    	grp.add(limit4);
    	add(limit4);
    	
    	MyJLabel l18=new MyJLabel("Username :");
    	l18.setBounds(400, 390, 100, 30);
    	add(l18);
    	txtusername=new JTextField();
    	txtusername.setBounds(400, 420, 150, 30);
    	add(txtusername);
    	
    	JLabel l19=new MyJLabel("Password :");
    	l19.setBounds(400, 460, 100, 30);
    	add(l19);
    	txtpassword=new JPasswordField();
    	txtpassword.setBounds(400, 490, 150, 30);
    	add(txtpassword);
    	
    	b=new JButton("Add");
    	b.setBounds(500, 545, 80, 70);
    	b.addActionListener(new AddButtonActionListener());
    	add(b);
        	
	}
	private class AddButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			int error=0;
			if(txtappnb.getText().equals("")||txtownername.getText().equals("")||txtownerfname.getText().equals("")||txtfathername.getText().equals("")||txtmothername.getText().equals("")||txtbirthdate.getText().equals("")||txtbirthplace.getText().equals("")||txtcarnumber.getText().equals("")||txtcarmark.getText().equals("")||txtmodelname.getText().equals("")||txtyear.getText().equals("")||txtaddress.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null,"year must complete all field");
				error=1;
			}
			else
			{
				try
				{ 
					int year = Integer.parseInt(txtyear.getText());
					if(year<1900){
						JOptionPane.showMessageDialog(null,"year must be positive");
						error=1;
					}
					
				}
				catch (NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null,"year must be integer");
					error=1;
				}
				
				try
				{
					
					int platenumber=Integer.parseInt(txtcarnumber.getText());
				}
				catch (NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null, "car number must be integer");
					error=1;
				}
				
				try
				{
					
					int tel=Integer.parseInt(txttel.getText());
				}
				catch (NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null, "telephone number must be integer");
					error=1;
				}
				
				try{
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd-m-yyyy");
					Date date2 = null;
					
					//Parsing the String
    				date2 = dateFormat.parse(txtbirthdate.getText());
    				
				} catch(Exception e){
					JOptionPane.showMessageDialog(null, "Birthdate must be date");
					error=1;
				}
				
				
			}
			if(error==0) {
				try {
					
					String url = "jdbc:mysql://localhost:3306/";
					String user = "root";
					String password = "secret";
					String limit;
					
					if(limit1.isSelected())limit="10000$";
					else if(limit2.isSelected())limit="15000$";
					else if(limit3.isSelected())limit="20000$";
					else limit="25000$";
					
					Connection connect = null;
					Statement statement = null;
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					connect = DriverManager.getConnection(url, user, password);
					statement = connect.createStatement();
					statement.execute("USE companytest");
					
					ResultSet resultset=null;
					if(!txtusername.getText().equals("")&&!(new String(txtpassword.getPassword()).equals("")))
					{
						int count=0;
						resultset = statement.executeQuery("select * from user where name='"+txtusername.getText()+"'");
						
						while(resultset.next()) {
							count++;
						}
						
						if(count==0) {
							statement.execute("insert into user(name,password,state) values('"+txtusername.getText()+"','"+new String(txtpassword.getPassword())+"','client')");
							statement.execute("insert into car(appnumber,date,ownername,ownerfirstname,fathername,mothername,birthdate,birthplace,carplatenumber,carmark,modelname,caryear,address,telephone,limitcovering,username)"
									+ "values('"+txtappnb.getText()+"','"+txtdate.getText()+"','"+txtownername.getText()+"','"+txtownerfname.getText()+"','"+txtfathername.getText()+"','"+txtmothername.getText()+"','"+txtbirthdate.getText()+"','"+txtbirthplace.getText()+"','"+txtcarnumber.getText()+"','"+txtcarmark.getText()+"','"+txtmodelname.getText()+"','"+txtyear.getText()+"','"+txtaddress.getText()+"','"+txttel.getText()+"','"+limit+"','"+txtusername.getText()+"')");
							
							ori.setState(new Person(txtownerfname.getText(), txtownername.getText(), txtmothername.getText(), txtfathername.getText(), txtbirthdate.getText(), txtbirthplace.getText(), txtaddress.getText(), txttel.getText()));
							care.add(ori.saveStateTomemento());
							clear();
						}
						else {
							count=0;
							resultset = statement.executeQuery("select * from user where name='"+txtusername.getText()+"' && password='"+new String(txtpassword.getPassword())+"'");
							while(resultset.next()) {
								count++;
							}
							if(count==0){
								JOptionPane.showMessageDialog(null, "invalid pass");
							}
							else {
								statement.execute("insert into car(appnumber,date,ownername,ownerfirstname,fathername,mothername,birthdate,birthplace,carplatenumber,carmark,modelname,caryear,address,telephone,limitcovering,username)"
										+ "values('"+txtappnb.getText()+"','"+txtdate.getText()+"','"+txtownername.getText()+"','"+txtownerfname.getText()+"','"+txtfathername.getText()+"','"+txtmothername.getText()+"','"+txtbirthdate.getText()+"','"+txtbirthplace.getText()+"','"+txtcarnumber.getText()+"','"+txtcarmark.getText()+"','"+txtmodelname.getText()+"','"+txtyear.getText()+"','"+txtaddress.getText()+"','"+txttel.getText()+"','"+limit+"','"+txtusername.getText()+"')");
								ori.setState(new Person(txtownerfname.getText(), txtownername.getText(), txtmothername.getText(), txtfathername.getText(), txtbirthdate.getText(), txtbirthplace.getText(), txtaddress.getText(), txttel.getText()));
								care.add(ori.saveStateTomemento());
								clear();
							}
						}
					}
					else {
					      statement.execute("insert into car(appnumber,date,ownername,ownerfirstname,fathername,mothername,birthdate,birthplace,carplatenumber,carmark,modelname,caryear,address,telephone,limitcovering)"
						+ "values('"+txtappnb.getText()+"','"+txtdate.getText()+"','"+txtownername.getText()+"','"+txtownerfname.getText()+"','"+txtfathername.getText()+"','"+txtmothername.getText()+"','"+txtbirthdate.getText()+"','"+txtbirthplace.getText()+"','"+txtcarnumber.getText()+"','"+txtcarmark.getText()+"','"+txtmodelname.getText()+"','"+txtyear.getText()+"','"+txtaddress.getText()+"','"+txttel.getText()+"','"+limit+"')");
					      
					      ori.setState(new Person(txtownerfname.getText(), txtownername.getText(), txtmothername.getText(), txtfathername.getText(), txtbirthdate.getText(), txtbirthplace.getText(), txtaddress.getText(), txttel.getText()));
							care.add(ori.saveStateTomemento());
							clear();
					}
				}
				catch (Exception e){
					e.printStackTrace();
				}
			}
		}
		
	}
	
	private class MyJLabel extends JLabel {
		public MyJLabel(String s){
			super(s);
			setFont(new Font(null, Font.CENTER_BASELINE, 15));
		}
	}
	
	private void clear(){
		super.clearPerson();
		txtappnb.setText("");
		txtcarnumber.setText("");
		txtcarmark.setText("");
		txtmodelname.setText("");
		txtyear.setText("");
		txtpassword.setText("");
		txtusername.setText("");
	}

}

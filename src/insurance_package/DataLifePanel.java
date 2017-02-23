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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DataLifePanel extends DataPanel{
	private JTextField txtappnb;
	private JTextField txtdate;
	
	private JRadioButton single;
	private JRadioButton married;
	private JRadioButton divorsed;
	private ButtonGroup grp = new ButtonGroup();
	
	private JRadioButton limit1;
	private JRadioButton limit2;
	private JRadioButton limit3;
	private JRadioButton limit4;
	private ButtonGroup grp2=new ButtonGroup();
	
	private JTextField txtnbchildren;
	private JTextField txtjob;
	private JButton b;
	private JTextField txtben1;
	private JTextField txtben2;
	private JTextField txtdisease;
	private JPasswordField txtpassword;
	private JTextField txtusername;
	
	Home home;
	
	public DataLifePanel(Home home, Originator ori, CareTaker care) {
	
		this.home = home;
		super.ori = ori;
		super.care = care;
		home.setCurrentPerson(care.getSize());
		setLayout(null);
	 	JLabel title = new JLabel("Life Insurance",SwingConstants.CENTER);
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
    	
    	JLabel l3=new MyJLabel("Insured name :");
    	add(l3);
    	l3.setBounds(10, 180, 120, 30);
    	txtownername=new JTextField();
    	txtownername.setBounds(130, 180, 150, 30);
    	add(txtownername);
    	
    	JLabel l4=new MyJLabel("First Name :");
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
    	
    	JLabel l9=new MyJLabel("Marital state :");
    	l9.setBounds(10, 330, 100, 30);
    	add(l9);
    	
    	single=new JRadioButton("Single");
    	single.setBounds(120, 330, 80, 30);
    	grp.add(single);
    	add(single);
    	
    	married=new JRadioButton("Married");
    	married.setBounds(200, 330, 80, 30);
    	grp.add(married);
    	add(married);
    	
    	divorsed=new JRadioButton("Divorsed");
    	divorsed.setBounds(280, 330, 80, 30);
    	grp.add(divorsed);
    	add(divorsed);
    	
    	JLabel l10=new MyJLabel("Number Of Children:");
    	l10.setBounds(380, 330, 150, 30);
    	add(l10);
    	txtnbchildren=new JTextField();
    	txtnbchildren.setText("0");
    	txtnbchildren.setBounds(535, 330, 50, 30);
    	add(txtnbchildren);
    	
    	JLabel l11=new MyJLabel("job:");
    	l11.setBounds(10, 380, 120, 30);
    	add(l11);
    	txtjob=new JTextField();
    	txtjob.setBounds(130, 380, 150, 30);
    	add(txtjob);
    	
    	JLabel l12=new MyJLabel("1st Beneficiary :");
    	add(l12);
    	l12.setBounds(10, 430, 120, 30);
    	txtben1=new JTextField();
    	txtben1.setBounds(130, 430, 150, 30);
    	add(txtben1);
    	
    	JLabel l13=new MyJLabel("2sd Beneficiary :");
    	add(l13);
    	l13.setBounds(10, 480, 120, 30);
    	txtben2=new JTextField();
    	txtben2.setBounds(130, 480, 150, 30);
    	add(txtben2);
    	
    	JLabel l14=new MyJLabel("Address:");
    	add(l14);
    	l14.setBounds(10, 530, 100, 30);
    	txtaddress=new JTextField();
    	txtaddress.setBounds(130, 530, 150, 30);
    	add(txtaddress);
    	
    	JLabel l15=new MyJLabel("Tel Number :");
    	add(l15);
    	l15.setBounds(10, 580, 100, 30);
    	txttel=new JTextField();
    	txttel.setBounds(130, 580, 150, 30);
    	add(txttel);
    	
    	JLabel l16=new MyJLabel("Limit Of Covering :");
    	l16.setBounds(10, 620, 140, 30);
    	add(l16);
    	
    	limit1=new JRadioButton("50000$");
    	limit1.setBounds(155, 620, 80, 30);
    	grp2.add(limit1);
    	add(limit1);
    	
    	limit2=new JRadioButton("75000$");
    	limit2.setBounds(235, 620, 80, 30);
    	grp2.add(limit2);
    	add(limit2);
    	
    	limit3=new JRadioButton("100000$");
    	limit3.setBounds(315, 620, 80, 30);
    	grp2.add(limit3);
    	add(limit3);
    	
    	limit4=new JRadioButton("200000$");
    	limit4.setBounds(395, 620, 80, 30);
    	grp2.add(limit4);
    	add(limit4);
    	
    	JLabel l17=new MyJLabel("Disease :");
    	add(l17);
    	l17.setBounds(10, 655, 80, 30);
    	txtdisease=new JTextField();
    	txtdisease.setText("none");
    	txtdisease.setBounds(155, 655, 320, 30);
    	add(txtdisease);
    	
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
    	b.setBounds(500, 610, 80, 70);
    	b.addActionListener(new AddButtonActionListener());
    	add(b);
		 
	}
	
	private class AddButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			int error=0;
			if(txtben1.getText().equals("")||txtben2.getText().equals("")||txtdisease.getText().equals("")||txtappnb.getText().equals("")||txtownername.getText().equals("")||txtownerfname.getText().equals("")||txtfathername.getText().equals("")||txtmothername.getText().equals("")||txtbirthdate.getText().equals("")||txtbirthplace.getText().equals("")||(!single.isSelected()&&!married.isSelected()&&!divorsed.isSelected())||txtnbchildren.getText().equals("")||txtjob.getText().equals("")||txttel.getText().equals("")||txtaddress.getText().equals("")||(!limit1.isSelected()&&!limit2.isSelected()&&!limit3.isSelected()&&!limit4.isSelected()))
			{
				JOptionPane.showMessageDialog(null,"must complete all field and select a state");
				error=1;
			}
			else
			{
				try
				{ 
					int tel = Integer.parseInt(txttel.getText());
					if(tel<0){error=1;JOptionPane.showMessageDialog(null,"tel cant be negative!");}
				}
				catch (NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null,"telephone number must be integer");
					error=1;
				}
				try
				{
					
					int nbchildren=Integer.parseInt(txtnbchildren.getText());
					if(nbchildren<0){error=1;JOptionPane.showMessageDialog(null,"nb children cant be negative!");}
				}
				catch (NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null, "children number must be integer");
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
			if(error==0)
			{
			try{
				String state;
				if(married.isSelected())state="married";
				else if(divorsed.isSelected())state="divorsed";
				else state="single";
				String mylimit;
				if(limit1.isSelected())mylimit="5000$";
				else if(limit2.isSelected())mylimit="7500$";
				else if(limit3.isSelected())mylimit="10000$";
				else mylimit="20000$";
				String url = "jdbc:mysql://localhost:3306/";
				String user = "root";
				String password = "secret";
				Connection connect = null;
				Statement statement = null;
				ResultSet resultset=null;
				Class.forName("com.mysql.jdbc.Driver").newInstance();
			connect = DriverManager.getConnection(url, user, password);
			statement = connect.createStatement();
			statement.execute("USE companytest");
			if(!txtusername.getText().equals("")&&!(new String(txtpassword.getPassword()).equals("")))
				{
					int count=0;
					resultset = statement.executeQuery("select * from user where name='"+txtusername.getText()+"'");
					while(resultset.next())
					{
						count++;
					}
					if(count==0)
					{
						statement.execute("insert into user(name,password,state) values('"+txtusername.getText()+"','"+new String(txtpassword.getPassword())+"','client')");
						 statement.execute("insert into life(application,date,insuredname,firstname,fathername,mothername,birthdate,birthplace,maritalstate,nbchildren,job,address,tel,limitcovering,ben1,ben2,disease,username)"
									+ "values('"+txtappnb.getText()+"','"+txtdate.getText()+"','"+txtownername.getText()+"','"+txtownerfname.getText()+"','"+txtfathername.getText()+"','"+txtmothername.getText()+"','"+txtbirthdate.getText()+"','"+txtbirthplace.getText()+"','"+state+"','"+txtnbchildren.getText()+"','"+txtjob.getText()+"','"+txtaddress.getText()+"','"+txttel.getText()+"','"+mylimit+"','"+txtben1.getText()+"','"+txtben2.getText()+"','"+txtdisease.getText()+"','"+txtusername.getText()+"')");
						
						 ori.setState(new Person(txtownerfname.getText(), txtownername.getText(), txtmothername.getText(), txtfathername.getText(), txtbirthdate.getText(), txtbirthplace.getText(), txtaddress.getText(), txttel.getText()));
						care.add(ori.saveStateTomemento());
						clear();
					}
					else{
						count=0;
						resultset = statement.executeQuery("select * from user where name='"+txtusername.getText()+"' && password='"+new String(txtpassword.getPassword())+"'");
						while(resultset.next())
						{
							count++;
						}
						if(count==0)
						{
							JOptionPane.showMessageDialog(null, "invalid pass");
						}
						else
						{
							statement.execute("insert into life(application,date,insuredname,firstname,fathername,mothername,birthdate,birthplace,maritalstate,nbchildren,job,address,tel,limitcovering,ben1,ben2,disease,username)"
									+ "values('"+txtappnb.getText()+"','"+txtdate.getText()+"','"+txtownername.getText()+"','"+txtownerfname.getText()+"','"+txtfathername.getText()+"','"+txtmothername.getText()+"','"+txtbirthdate.getText()+"','"+txtbirthplace.getText()+"','"+state+"','"+txtnbchildren.getText()+"','"+txtjob.getText()+"','"+txtaddress.getText()+"','"+txttel.getText()+"','"+mylimit+"','"+txtben1.getText()+"','"+txtben2.getText()+"','"+txtdisease.getText()+"','"+txtusername.getText()+"')");
							ori.setState(new Person(txtownerfname.getText(), txtownername.getText(), txtmothername.getText(), txtfathername.getText(), txtbirthdate.getText(), txtbirthplace.getText(), txtaddress.getText(), txttel.getText()));
							care.add(ori.saveStateTomemento());
							clear();
						}
					}
				}
			else{ 
				statement.execute("insert into life(application,date,insuredname,firstname,fathername,mothername,birthdate,birthplace,maritalstate,nbchildren,job,address,tel,limitcovering,ben1,ben2,disease)"
					+ "values('"+txtappnb.getText()+"','"+txtdate.getText()+"','"+txtownername.getText()+"','"+txtownerfname.getText()+"','"+txtfathername.getText()+"','"+txtmothername.getText()+"','"+txtbirthdate.getText()+"','"+txtbirthplace.getText()+"','"+state+"','"+txtnbchildren.getText()+"','"+txtjob.getText()+"','"+txtaddress.getText()+"','"+txttel.getText()+"','"+mylimit+"','"+txtben1.getText()+"','"+txtben2.getText()+"','"+txtdisease.getText()+"')");
				
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
		txtnbchildren.setText("0");
		txtjob.setText("");
		txtben1.setText("");
		txtben2.setText("");
		txtdisease.setText("none");
		txtpassword.setText("");
		txtusername.setText("");
	}
}

package insurance_package;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.*;

public class DisplayInsurance extends JFrame{
	
	LoginJFrame login;
	String username;
	
	JLabel NameJL;
	JLabel fatherNameJL;
	JLabel matherNameJL;
	JLabel birthdateJL;
	JLabel birthplaceJL;
	JLabel addressJL;
	JLabel telJL;
	JLabel carJL = null;
	JLabel healthJL = null;
	JLabel lifeJL = null;
	JLabel plateJL = null;
	JLabel markJL = null;
	JLabel modelJL = null;
	JLabel yearJL = null;
	JLabel limitcarJL = null;
	JLabel maritalJL = null;
	JLabel childrenJL = null;
	JLabel jobJL = null;
	JLabel limithealthJL = null;
	JLabel ben1JL = null;
	JLabel ben2JL = null;
	JLabel limitlifeJL = null;
	JLabel diseaseJL = null;
	
	
	
	public DisplayInsurance(LoginJFrame login,String username){
		this.login = login;
		this.username = username;
		setLayout(null);
		
		this.setLocation(150, 10);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.getContentPane().setBackground(new Color(250,250,250,255)); 
		setSize(800, 1000);
		setVisible(true);
		try{
			String url = "jdbc:mysql://localhost:3306/";
			String user = "root";
			String password = "secret";
			
			Connection connect = null;
			Statement statement = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connect = DriverManager.getConnection(url, user, password);
			statement = connect.createStatement();
			statement.execute("USE companytest");
			ResultSet resultset = null;
			int y = 240;
			resultset = statement.executeQuery("select * from car where username='"+username+"'");
			
			while(resultset.next()){
				NameJL = new MyJLabel(resultset.getString("ownername") + " " + resultset.getString("ownerfirstname"),SwingConstants.CENTER);
				fatherNameJL = new MyJLabel("Father : "+resultset.getString("fathername"));
				matherNameJL = new MyJLabel("Mother : "+resultset.getString("mothername"));
				birthdateJL = new MyJLabel("Birthdate : "+resultset.getString("birthdate"));
				addressJL = new MyJLabel("Address : "+resultset.getString("address"));
				telJL = new MyJLabel("Tel : "+resultset.getString("telephone"));
				
				y+=10;
				carJL = new MyJLabel("CAR INSURANCE");
				carJL.setFont(new Font(null, Font.CENTER_BASELINE, 20));
				carJL.setBounds(10, y, 600, 30);
				y += 40;
				add(carJL);
				plateJL = new MyJLabel("Plate Number : "+resultset.getString("carplatenumber"));
				plateJL.setBounds(10, y, 600, 30);
				y+=40;
				add(plateJL);
				markJL = new MyJLabel("Car Mark : "+resultset.getString("carmark"));
				markJL.setBounds(10, y, 600, 30);
				y += 40;
				add(markJL);
				modelJL = new MyJLabel("Model : "+resultset.getString("modelname"));
				modelJL.setBounds(10, y, 600, 30);
				y += 40;
				add(modelJL);
				yearJL = new MyJLabel("Year : "+resultset.getString("caryear"));
				yearJL.setBounds(10, y, 600, 30);
				y += 40;
				add(yearJL);
				limitcarJL = new MyJLabel("Limit of Covering : "+resultset.getString("limitcovering"));
				limitcarJL.setBounds(10, y, 600, 30);
				y += 40;
				add(limitcarJL);
				
				break;
			}
			
			resultset = statement.executeQuery("select * from health where username='"+username+"'");
			
			while(resultset.next()){
				NameJL = new MyJLabel(resultset.getString("insuredname") + " " + resultset.getString("firstname"),SwingConstants.CENTER);
				fatherNameJL = new MyJLabel("Father : "+resultset.getString("fathername"));
				matherNameJL = new MyJLabel("Mother : "+resultset.getString("mothername"));
				birthdateJL = new MyJLabel("Birthdate : "+resultset.getString("birthdate"));
				addressJL = new MyJLabel("Address : "+resultset.getString("address"));
				telJL = new MyJLabel("Tel : "+resultset.getString("tel"));
				
				y+=10;
				healthJL = new MyJLabel("HEALTH INSURANCE");
				healthJL.setFont(new Font(null, Font.CENTER_BASELINE, 20));
				healthJL.setBounds(10, y, 600, 30);
				y += 40;
				add(healthJL);
				maritalJL = new MyJLabel("Marital State : "+resultset.getString("maritalstate"));
				maritalJL.setBounds(10, y, 600, 30);
				y += 40;
				add(maritalJL);
				childrenJL = new MyJLabel("Number of Children : "+resultset.getString("nbchildren"));
				childrenJL.setBounds(10, y, 600, 30);
				y += 40;
				add(childrenJL);
				jobJL = new MyJLabel("Job : "+resultset.getString("job"));
				jobJL.setBounds(10, y, 600, 30);
				y += 40;
				add(jobJL);
				limithealthJL = new MyJLabel("Limit of Covering : "+resultset.getString("limitcovering"));
				limithealthJL.setBounds(10, y, 600, 30);
				y += 40;
				add(limithealthJL);
				break;
			}
			
			resultset = statement.executeQuery("select * from life where username='"+username+"'");
			
			while(resultset.next()){
				NameJL = new MyJLabel(resultset.getString("insuredname") + " " + resultset.getString("firstname"),SwingConstants.CENTER);
				fatherNameJL = new MyJLabel("Father : "+resultset.getString("fathername"));
				matherNameJL = new MyJLabel("Mother : "+resultset.getString("mothername"));
				birthdateJL = new MyJLabel("Birthdate : "+resultset.getString("birthdate"));
				addressJL = new MyJLabel("Address : "+resultset.getString("address"));
				telJL = new MyJLabel("Tel : "+resultset.getString("tel"));
				
				y+=10;
				lifeJL = new MyJLabel("LIFE INSURANCE");
				lifeJL.setFont(new Font(null, Font.CENTER_BASELINE, 20));
				lifeJL.setBounds(10, y, 600, 30);
				y += 40;
				add(lifeJL);
				if(maritalJL == null){
					maritalJL = new MyJLabel("Marital State : "+resultset.getString("maritalstate"));
					maritalJL.setBounds(10, y, 600, 30);
					y += 40;
					add(maritalJL);
				}
				if(childrenJL == null){
					childrenJL = new MyJLabel("Number of Children : "+resultset.getString("nbchildren"));
					childrenJL.setBounds(10, y, 600, 30);
					y += 40;
					add(childrenJL);
				}
				if(jobJL == null){
					jobJL = new MyJLabel("Job : "+resultset.getString("job"));
					jobJL.setBounds(10, y, 600, 30);
					y += 40;
					add(jobJL);
				}
				
				limitlifeJL = new MyJLabel("Limit of Covering : "+resultset.getString("limitcovering"));
				limitlifeJL.setBounds(10, y, 600, 30);
				y += 40;
				add(limitlifeJL);
				ben1JL = new MyJLabel("1st Beneficiary : "+resultset.getString("ben1"));
				ben1JL.setBounds(10, y, 600, 30);
				y += 40;
				add(ben1JL);
				ben2JL = new MyJLabel("2st Beneficiary : "+resultset.getString("ben2"));
				ben2JL.setBounds(10, y, 600, 30);
				y += 40;
				add(ben2JL);
				diseaseJL = new MyJLabel("Disease : "+resultset.getString("disease"));
				diseaseJL.setBounds(10, y, 600, 30);
				y += 40;
				add(diseaseJL);
				
				break;
			}
			NameJL.setBounds(10, 10, 780, 30);
			NameJL.setFont(new Font(null, Font.CENTER_BASELINE, 30));
			add(NameJL);
			fatherNameJL.setBounds(10, 40, 600, 30);
			add(fatherNameJL);
			matherNameJL.setBounds(10, 80, 600, 30);
			add(matherNameJL);
			birthdateJL.setBounds(10, 120, 600, 30);
			add(birthdateJL);
			addressJL.setBounds(10, 160, 600, 30);
			add(addressJL);
			telJL.setBounds(10, 200, 600, 30);
			add(telJL);
			
			
		}
		catch (Exception ev){
			ev.printStackTrace();
		}
		
		
		this.addWindowListener(new WindowAdapter() {
			  public void windowClosing(WindowEvent e) {
				    int confirmed = JOptionPane.showConfirmDialog(null, 
				        "Are you sure you want to exit the program?", "Exit Program Message Box",
				        JOptionPane.YES_NO_OPTION);

				    if (confirmed == JOptionPane.YES_OPTION) {
				    	login.setVisible(true);
				    	dispose();
				    }
				  }
		});
	}
	private class MyJLabel extends JLabel {
		public MyJLabel(String s){
			super(s);
			setFont(new Font(null, Font.CENTER_BASELINE, 15));
		}
		public MyJLabel(String s,int cst){
			super(s,cst);
			setFont(new Font(null, Font.CENTER_BASELINE, 15));
		}
	}
}

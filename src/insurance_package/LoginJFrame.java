package insurance_package;



import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LoginJFrame extends JFrame{
	
	private JFrame thisFrame;
	private int screenWidth;
	private int screenHeight;
	private int frameWidth;
	private int frameHeight;
	private JLabel loginJL;
	private JLabel usernameJL;
	private JTextField usernameJTF;
	private JLabel passwordJL;
	private JPasswordField passwordJPF;
	private JButton loginJB;
	private Panel1 panel1;
	private float x1,y1,x2,y2,x3,y3,x4,y4,w1,h1,w2,h2,w3,h3,w4,h4;
	private Point point1,point2,point3,point4;
	
	// LoginJFrame constructor
	public LoginJFrame(){
		
		super("Login");
		thisFrame = this;
		
		/***************************************************************/
		/*    get the screen resolution (width x height) in pixels    */
		/**************************************************************/
		
		// the first method (On a multi-monitor configuration)
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		screenWidth = gd.getDisplayMode().getWidth();
		screenHeight = gd.getDisplayMode().getHeight();	
		
	    // the second method(You can get the screen size with the Toolkit.getScreenSize() method)
		/*
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		*/
		
		frameWidth = (int)(screenWidth/3.3);
		frameHeight = screenHeight/2;
		if(frameWidth < 400){
			frameWidth = 580;
		}
		if(frameHeight < 400){
			frameHeight = 540;
		}
		
		this.addWindowListener(new WindowAdapter() {
			  public void windowClosing(WindowEvent e) {
				    int confirmed = JOptionPane.showConfirmDialog(null, 
				        "Are you sure you want to exit the program?", "Exit Program Message Box",
				        JOptionPane.YES_NO_OPTION);

				    if (confirmed == JOptionPane.YES_OPTION) {
				    	dispose();
				    }
				  }
				});
		
		
		this.setLayout(null); // set frame layout
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setSize(frameWidth, frameHeight); // set size
		
		// set background image(with resizable image)
		this.setContentPane(new JLabel(new ImageIcon(getScaledImage(new ImageIcon("images/insurance.jpg").getImage(),this.getWidth(),this.getHeight()))));
		
		this.setLocationRelativeTo(null); // set location 
		//this.setLocation(screenWidth/2-this.getSize().width/2, screenHeight/2-this.getSize().height/2);
		
		this.setResizable(false); // set resizable
		
		// construct panel
		panel1 = new Panel1();
		add(panel1); // add panel to JFrame
		
		
	
		point1 = new Point();
		point2 = new Point();
		point3 = new Point();
		point4 = new Point();
		
		point1.x = 3;
		point1.y = 3;
		point2.x = panel1.getWidth()-3;
		point2.y = 3;
		point3.x = panel1.getWidth()-3;
		point3.y = panel1.getHeight()-3;
		point4.x = 3;
		point4.y = panel1.getHeight()-3;
			
		
		
		// set values of rectangles location
		// rect1 
		x1 = point1.x;
		y1 = point1.y;
		w1 = 0;
		h1 = 6;
		
		// rect2
		x2 = point2.x - 6;
		y2 = point2.y;
		w2 = 6;
		h2 = 0;
		
		// rect3
		x3 = point3.x;
		y3 = point3.y - 6;
		w3 = 0;
		h3 = 6;
		
		// rect4
		x4 = point4.x;
		y4 = point4.y;
		w4 = 6;
		h4 = 0;

		
		// start enumation using thread
		ColorEnimation task = new ColorEnimation();
		ExecutorService threadExecutor = Executors.newCachedThreadPool();
		threadExecutor.execute(task);
		
		// shut down worker threads when their tasks complete
		threadExecutor.shutdown();
	
		
		this.setVisible(true); // display frame
		
	} // end LoginJFrame constructor
		
	
	// 
	public int getFrameWidth(){
		return frameWidth;
	}
		
	//
	public int getFrameHeight(){
		return frameHeight;
	}
	
	
	// a private method for resizable image
	private Image getScaledImage(Image srcImg, int w, int h){
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();

	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();

	    return resizedImg;
	} // end method getScaleImage
	
	
	
	// private panel class
	private class Panel1 extends JPanel{
		
		// Panel1 constructor
		public Panel1(){
			
			setLayout(null); // set panel layout
			int max = Math.max(frameWidth/2, frameHeight/2);
			setBounds((frameWidth/2)-30,(frameHeight/2)-70, max, max); // set size
			setBackground(new Color(150, 149, 187, 200)); // set background color
			
			
			
			// construct label
			loginJL = new JLabel("LOGIN",SwingConstants.CENTER);
			loginJL.setBounds(0, 0, this.getWidth(), 50);
			loginJL.setFont(new Font(null, Font.CENTER_BASELINE, 24));
			add(loginJL);
			
			// construct label
			usernameJL = new JLabel("Username : ");
			usernameJL.setFont(new Font(null, Font.CENTER_BASELINE, 15));
			usernameJL.setBounds(20, 60, this.getWidth(), 30);
			add(usernameJL);
			
			// construct textfield 
			usernameJTF = new JTextField();
			usernameJTF.setBounds(20,90, this.getWidth()-40, 30);
			add(usernameJTF);
			
			// construct label
			passwordJL = new JLabel("Password : ");
			passwordJL.setFont(new Font(null, Font.CENTER_BASELINE, 15));
			passwordJL.setBounds(20, 120, this.getWidth(), 30);
			add(passwordJL);
			
			// construct passwordfield
			passwordJPF = new JPasswordField();
			passwordJPF.setBounds(20,150, this.getWidth()-40, 30);
			add(passwordJPF);
			
			// construct button
			loginJB = new JButton("LOG IN");
			loginJB.setFont(new Font(null, Font.CENTER_BASELINE, 15));
			loginJB.setBounds(20,205, this.getWidth()-40, 35);
			ButtonListener b = new ButtonListener(); // add listener to button
			loginJB.addActionListener(b);
			add(loginJB);
		} // end Panel1 constructor
		
		// paint method
		public void paintComponent(Graphics g){
			
			super.paintComponent(g);
		/*	
			g.setColor(new Color(255,255,0,50));
			g.fillRect((int)x1, (int)y1, (int)w1, (int)h1);
			g.setColor(new Color(255,255,0,100));
			g.fillRect((int)x1, (int)(y1 + 2), (int)w1, (int)(h1 - 4));
			
			
			g.setColor(new Color(255,255,255,50));
			g.fillRect((int)x2, (int)y2, (int)w2, (int)h2);
			g.setColor(new Color(255,255,255,100));
			g.fillRect((int)(x2 + 2), (int)y2, (int)(w2 - 4), (int)h2);
			
			
			g.setColor(new Color(0,0,255,50));
			g.fillRect((int)x3, (int)y3, (int)w3, (int)h3);
			g.setColor(new Color(0,0,255,100));
			g.fillRect((int)x3, (int)(y3 + 2), (int)w3, (int)(h3 - 4));
			
			
			g.setColor(new Color(128,0,255,50));
			g.fillRect((int)x4, (int)y4, (int)w4, (int)h4);
			g.setColor(new Color(128,0,255,100));
			g.fillRect((int)(x4 + 2), (int)y4, (int)(w4 - 4), (int)h4);
		*/	
			
			g.setColor(new Color(255,255,255,50));
			g.fillRect((int)x1, (int)y1, (int)w1, (int)h1);
			g.setColor(new Color(255,255,255,150));
			g.fillRect((int)x1, (int)(y1 + 2), (int)w1, (int)(h1 - 4));
			
			
			g.setColor(new Color(255,255,255,50));
			g.fillRect((int)x2, (int)y2, (int)w2, (int)h2);
			g.setColor(new Color(255,255,255,150));
			g.fillRect((int)(x2 + 2), (int)y2, (int)(w2 - 4), (int)h2);
			
			
			g.setColor(new Color(255,255,255,50));
			g.fillRect((int)x3, (int)y3, (int)w3, (int)h3);
			g.setColor(new Color(255,255,255,150));
			g.fillRect((int)x3, (int)(y3 + 2), (int)w3, (int)(h3 - 4));
			
			
			g.setColor(new Color(255,255,255,50));
			g.fillRect((int)x4, (int)y4, (int)w4, (int)h4);
			g.setColor(new Color(255,255,255,150));
			g.fillRect((int)(x4 + 2), (int)y4, (int)(w4 - 4), (int)h4);
			
		}
		
		
	} // end class Panel1
	
	
	
	// private inner class for event listener
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==loginJB){
				if(!usernameJTF.getText().equals("") && !(new String(passwordJPF.getPassword()).equals(""))){
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
						ResultSet resultset=null;
						
						int count=0;
						resultset = statement.executeQuery("select name,password,state from user where name='"+usernameJTF.getText()+"' && password='"+new String(passwordJPF.getPassword())+"'");
						String s="";
						while(resultset.next()) {
							s = resultset.getString("state");
							count++;
						}
						if(count==0){
							JOptionPane.showMessageDialog(null, "invalid username or password!");
						}
						else {
							if(s.equals("employee")){
								
								usernameJTF.setText("");
								passwordJPF.setText("");
								Home homePage = new Home(thisFrame);
								Point[] points = homePage.getLogoutLabelPosition();
								
								homePage.setVisible(false);
								thisFrame.setVisible(false);
								homePage.setVisible(true);
								thisFrame.setVisible(true);
								
								FrameEnimation task1 = new FrameEnimation(points);
								ExecutorService threadExecutor = Executors.newCachedThreadPool();
								threadExecutor.execute(task1);
								
							}
							else{
								new DisplayInsurance((LoginJFrame)thisFrame,usernameJTF.getText());
								usernameJTF.setText("");
								passwordJPF.setText("");
								thisFrame.setVisible(false);
							}
							
						}
						
						
						
					}
					catch (Exception ev){
						ev.printStackTrace();
					}
					
					
					
				}
				else{
					if(usernameJTF.getText().equals("") && (new String(passwordJPF.getPassword()).equals(""))){
						JOptionPane.showMessageDialog(null, "Enter your username and your password !");
					}
					else if((new String(passwordJPF.getPassword()).equals(""))){
						JOptionPane.showMessageDialog(null, "Enter your  password !");
					}
					else{
						JOptionPane.showMessageDialog(null, "Enter your username !");
					}
					
				}
			}
			else{
				
			}
		} // end method actionPerformed
		
	} // end class ButtonListener
	
	
	
	// thread class for frame enimation
	private class FrameEnimation implements Runnable{
		private Point[] points;
		public FrameEnimation(Point[] points) {
			this.points = points;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			long lastFrame = System.currentTimeMillis();
			int x = thisFrame.getLocation().x;
			int y = thisFrame.getLocation().y;
			int frameWidth1 = frameWidth;
			int frameHeight1 = frameHeight;
			
			while(frameWidth1 > points[1].x || frameHeight1 > points[1].y || x != (points[0].x + 10) || y != (points[0].y + 10)){
				long thisFrameTime = System.currentTimeMillis();
				float timeSinceLastFrame = (float)(thisFrameTime - lastFrame)/1000;
				lastFrame = thisFrameTime;
				//System.out.println(x);
				if(frameWidth1 > points[1].x){
					frameWidth1 -= 20;
				}
				if(frameHeight1 > points[1].y){
					frameHeight1 -= 20;
				}
				if(x != (points[0].x + 10)){
					if(Math.abs(Math.max(x, (points[0].x + 10)) - Math.min(x, (points[0].x + 10))) < 20){
						x = (points[0].x + 10);
					}
					else if(x > (points[0].x + 10)){
						x -= 1500*timeSinceLastFrame;
					}
					else{
						x += 1500*timeSinceLastFrame;
					}	
				}
				if(y != (points[0].y + 10)){
					if(Math.abs(Math.max(y, (points[0].y + 10)) - Math.min(y, (points[0].y + 10))) < 20){
						y = (points[0].y + 10);
					}
					else if(y > (points[0].y + 10)){
						y -= 1500*timeSinceLastFrame;
					}
					else{
						y += 1500*timeSinceLastFrame;
					}
				}
				
				thisFrame.setLocation(x, y);
				thisFrame.setSize(frameWidth1, frameHeight1);
				
				try {
					Thread.sleep(15);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			thisFrame.setVisible(false);
		}
		
	}
	
	// thread class for color enimation
	private class ColorEnimation implements Runnable{
		private int speed = 100;
		Boolean b1=true,b1_1=true,b2=false,b2_2=true,b3=false,b3_3=true,b4=false,b4_4=true;
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			long lastFrame = System.currentTimeMillis();
			while(true){ 
				long thisFrameTime = System.currentTimeMillis();
				float timeSinceLastFrame = (float)(thisFrameTime - lastFrame)/1000;
				lastFrame = thisFrameTime;
				//System.out.println("w1 = "+timeSinceLastFrame);
				
				
				if(b1){
					if(b1_1 && w1 < point2.x - 3){
						w1 += speed*timeSinceLastFrame;
					}
					else{
						b2 = true;
						b1_1 = false;
						x1 += speed*timeSinceLastFrame;
						w1 = point2.x - x1;
					}
					if(x1 > point2.x){
						b1 = false;
						x1 = point1.x;
						y1 = point1.y;
						w1 = 0;
						h1 = 6;
						b1_1 = true;
					}
				}
				if(b2){
					if(b2_2 && h2 < point3.y - 3){
						h2 += speed*timeSinceLastFrame;
					}
					else{
						b3 = true;
						b2_2 = false;
						y2 += speed*timeSinceLastFrame;
						h2 = point3.y - y2;
					}
					if(y2 > point3.y){
						b2 = false;
						x2 = point2.x - 6;
						y2 = point2.y;
						w2 = 6;
						h2 = 0;
						b2_2 = true;
					}
					
				}
				if(b3){
					if(b3_3 && x3 > point4.x){
						x3 -= speed*timeSinceLastFrame;
						w3 = point3.x - x3;
					}
					else{
						b4 = true;
						b3_3 = false;
						w3 -= speed*timeSinceLastFrame;
					}
					if(!b3_3 && w3 < 3){
						b3 = false;
						x3 = point3.x;
						y3 = point3.y - 6;
						w3 = 0;
						h3 = 6;
						b3_3 = true;
					}
					
				}
				if(b4){
					if(b4_4 && y4 > point1.y){
						y4 -= speed*timeSinceLastFrame;
						h4 = point4.y - y4;
					}
					else{
						b1 = true;
						b4_4 = false;
						h4 -= speed*timeSinceLastFrame;
					}
					if(!b4_4 && h4 < 3){
						b4 = false;
						x4 = point4.x;
						y4 = point4.y;
						w4 = 6;
						h4 = 0;
						b4_4 = true;
					}
				}
				

				thisFrame.repaint();
				try {
					Thread.sleep(15);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
} // end class LoginJFrame

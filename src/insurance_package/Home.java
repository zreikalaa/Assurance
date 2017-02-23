package insurance_package;


import java.sql.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.*;
import javax.swing.TransferHandler.TransferSupport;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class Home extends JFrame implements KeyListener{
	
	JPanel centerpanel;
	JPanel westpanel;
	JLabel label1;
	JLabel label2;
	JLabel label3;
	JLabel label4;
	ImageIcon img1,img2,img3,img4;
	private int drawRect = -1;
	private Boolean thread = true;
	Runnable task = null;
	Boolean rectEnimNow = false;
	ExecutorService threadExecutor ;
	private DataPanel currentPanel = null;
	private JFrame thisFrame;
	private LoginJFrame loginFrame;
	Originator ori = new Originator();
	CareTaker care = new CareTaker();
	int currentPerson;
	JLabel imgLabel1,imgLabel2,imgLabel3;
	
	
	public Home(JFrame loginFrame){
		super("Insurance Company");
		this.loginFrame = (LoginJFrame)loginFrame;
		thisFrame = this;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setSize(1210,840);
		setLocationRelativeTo(null);
		//setBackground(new Color(150, 149, 187, 200));
		this.getContentPane().setBackground(new Color(0, 0, 0, 200));
		setLayout(null);
		centerpanel=new Center(this);
		westpanel=new West();
		add(centerpanel,BorderLayout.CENTER);
		add(westpanel,BorderLayout.WEST);
		setFocusable(true);
		setVisible(true);
		addKeyListener(this);
		this.addWindowListener(new WindowAdapter() {
			  public void windowClosing(WindowEvent e) {
				    int confirmed = JOptionPane.showConfirmDialog(null, 
				        "Are you sure you want to exit the program?", "Exit Program Message Box",
				        JOptionPane.YES_NO_OPTION);

				    if (confirmed == JOptionPane.YES_OPTION) {
				    	LoginEnimation task = new LoginEnimation();
                		ExecutorService threadExecutor = Executors.newCachedThreadPool();
                		threadExecutor.execute(task);
				    }
				  }
				});
	}
	
	public Point[] getLogoutLabelPosition(){
		Point[] points = new Point[2];
		points[0] = new Point();
		points[1] = new Point();
		
		points[0] = label4.getLocationOnScreen();
		
		points[1].x = label4.getWidth();
		points[1].y = label4.getHeight();
		
		return points;
	}
	
	private class Center extends JPanel {
		
		private Home h;
		
		int op = 255;
		
		public Center(Home h){
			this.h=h;
			setBounds(200, 0, 1000, 800);
			setLayout(null);
			
			setBackground(Color.WHITE);
			
			imgLabel1 = new JLabel(new ImageIcon(getScaledImage(new ImageIcon("images/img13.png").getImage(),110,200)));
			imgLabel1.setBounds(880, 580, 110, 200);
			add(imgLabel1);
			imgLabel2 = new JLabel(new ImageIcon(getScaledImage(new ImageIcon("images/img11.png").getImage(),120,120)));
			imgLabel2.setBounds(255, 470, 120, 120);
			add(imgLabel2);
			
			imgLabel3 = new JLabel(new ImageIcon(getScaledImage(new ImageIcon("images/lamp.png").getImage(),220,140)));
			imgLabel3.setBounds(400, 80, 220, 140);
			add(imgLabel3);
			
			
			setBorder(BorderFactory.createLineBorder(Color.black));
			//setBorder(new TitledBorder("Drag Image to this panel"));
			MyTransferHandler dnd = new MyTransferHandler();
			setTransferHandler(dnd);
			new MyDropTargetListener(this);
			task = new RectEnimation();
			
		}
		
		private class MyTransferHandler extends TransferHandler{
			@Override
            public boolean canImport(TransferSupport support) {
                if (!support.isDrop()) {
                    return false;
                }
                //only Strings
                if (!support.isDataFlavorSupported(DataFlavor.imageFlavor)) {
                    return false;
                }
                return true;
            }

            @Override
            public boolean importData(TransferSupport support) {
                if (!canImport(support)) {
                    return false;
                }
                
                Transferable tansferable = support.getTransferable();
                Icon ico;
                try {
                    ico = (Icon) tansferable.getTransferData(DataFlavor.imageFlavor);
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
                add(new JLabel(ico));
                
                return true;
            }
            
		}
		
        private class MyDropTargetListener extends DropTargetAdapter {

            private DropTarget dropTarget;
            private JPanel p;

            public MyDropTargetListener(JPanel panel) {
                p = panel;
                dropTarget = new DropTarget(panel, DnDConstants.ACTION_COPY, this, true, null);
                
            }

            @Override
            public void drop(DropTargetDropEvent event) {
                try {
                    DropTarget test = (DropTarget) event.getSource();
                    Component ca = (Component) test.getComponent();
                    Point dropPoint = ca.getMousePosition();
                    Transferable tr = event.getTransferable();

                    if (event.isDataFlavorSupported(DataFlavor.imageFlavor)) {
                        Icon ico = (Icon) tr.getTransferData(DataFlavor.imageFlavor);

                        if (ico != null) {
                        	Boolean exit = false;
                        	if(currentPanel!=null) {
                        		p.remove(currentPanel);
                        	}
                        	if(ico==img1) {
                        		DataCarPanel c = new DataCarPanel((Home)thisFrame, ori, care);
                            	currentPanel=c;
                                p.add(c);
                        	}
                        	else if(ico==img2) {
                        		DataHealthPanel h = new DataHealthPanel((Home)thisFrame, ori, care);
                            	currentPanel=h;
                                p.add(h);
                        	}
                        	else if(ico==img3){
                        		DataLifePanel l = new DataLifePanel((Home)thisFrame, ori, care);
                            	currentPanel=l;
                                p.add(l);
                        	}
                        	else {
                        		exit = true;
                        		LoginEnimation task = new LoginEnimation();
                        		ExecutorService threadExecutor = Executors.newCachedThreadPool();
                        		threadExecutor.execute(task);
                        		
                        		// shut down worker threads when their tasks complete
                        		threadExecutor.shutdown();
                        	}
                        	
                        	op = 0;
                        	
                        	JLabel l = new JLabel(ico);
                        	l.setBounds(p.getWidth()/2 - 50, p.getHeight()/2 - 50, 200, 200);
                            p.add(l);
                            
                            if(!exit){
                            	ImageEnimation task = new ImageEnimation(l,ico,p);
                        		ExecutorService threadExecutor = Executors.newCachedThreadPool();
                        		threadExecutor.execute(task);
                            }
                            
                            
                            thread = false;  
                            drawRect = -1;
                            
                            p.revalidate();
                            p.repaint();
                            event.dropComplete(true);
                            
                        }
                    } else {
                        event.rejectDrop();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    event.rejectDrop();
                }
            }
        }
        
        
        
        private class ImageEnimation implements Runnable {
        	JLabel l;
        	ImageIcon i;
        	JPanel p;
        	
        	public ImageEnimation(JLabel l,Icon i,JPanel p) {
        		this.l = l;
        		this.i = (ImageIcon)i;
        		this.p = p;
        	}
        	
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				currentPanel.setVisible(false);
				imgLabel2.setVisible(false);
				imgLabel3.setVisible(false);
				
				
				int w = l.getWidth();
				int h = l.getHeight();
				int x = l.getLocation().x;
				int y = l.getLocation().y;

				long lastFrame = System.currentTimeMillis();
				
				
				while(w < 620 || h < 670 || x != 50 || y != 100 ){
					//System.out.println("now: x="+x+",y="+y+", w="+w+",h="+h);
					long thisFrameTime = System.currentTimeMillis();
					float timeSinceLastFrame = (float)(thisFrameTime - lastFrame)/1000;
					lastFrame = thisFrameTime;
					//System.out.println(x);
					if( w < 620){
						w += 25;
					}
					if( h < 670){
						h += 25;
					}
					if( x != 50){
						if(Math.abs(Math.max(x, 50) - Math.min(x, 50)) < 20){
							x = 50;
						}
						else if(x > 50){
							x -= 700*timeSinceLastFrame;
						}
						else{
							x += 700*timeSinceLastFrame;
						}	
					}
					if( y != 100){
						if(Math.abs(Math.max(y, 100 ) - Math.min(y, 100 )) < 20){
							y = 100 ;
						}
						else if( y  > 100){
							y -= 700*timeSinceLastFrame;
						}
						else{
							y += 700*timeSinceLastFrame;
						}
					}
					
					ImageIcon img = new ImageIcon(getScaledImage(i.getImage(),w,h));
					l.setIcon(img);					
					l.setBounds(x, y, w, h);
					
					
					try {
						Thread.sleep(15);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
				
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				p.remove(l);
				currentPanel.setVisible(true);
				//imgLabel2.setVisible(true);
				//imgLabel3.setVisible(true);
				p.repaint();
			}
        	
        }
        
        // paint method
     	public void paintComponent(Graphics g){
     			
     		super.paintComponent(g);

     		g.setColor(new Color(255, 255, 200, 255));
     		g.fillRect(300, 240, 400, 320);
     		
     		//g.setFont(new Font("Serif",Font.BOLD,20));
     		//g.drawString("Insurance", 400, 300);
     		
     		g.setColor(new Color(255, 90, 11, op));   		
     		g.setFont(new Font("Serif",Font.BOLD,30));
     		g.drawString("Insurance", 420, 350);
     		g.drawString("Company", 450, 380);
     		
     		g.setColor(new Color(0, 0, 0, 255));
     		g.drawRect(300, 240, 400, 320);
     		g.drawLine(0, 0, 300, 240);
     		g.drawLine(1000, 0, 700, 240);
     		g.drawLine(0, 800, 300,560);
     		g.drawLine(1000, 800, 700, 560);
     		
     		g.setColor(new Color(128, 0, 0, 200));
     		int[] xValues = {0, 1000, 300, 700};
     		int[] yValues = {800, 800, 560, 560};
     		g.fillPolygon(xValues, yValues, 4);
     		
     		 Graphics2D g2d = (Graphics2D) g.create();
     		 g2d.setStroke(new BasicStroke(3));
    
     		for(int i=0, x=0, y=0;x<=300;x+=20,y+=16,i++){
     			if(drawRect == i){
         			g2d.setColor(new Color(255, 0, 0, 255));
     			}
     			else{
         			g2d.setColor(new Color(255, 0, 0, 0));
     			}
     			g2d.drawRect(x, y, 1000 - (2*x), 800 - (2*y));
     		}
     		
     	}
     	
     	
  
	}
	
	private class West extends JPanel {
		
		public West() {
			setLayout(new GridLayout(4,1));
			img1=new ImageIcon(getScaledImage(new ImageIcon("images/car4.jpg").getImage(),200,200));
			img2=new ImageIcon(getScaledImage(new ImageIcon("images/health3.jpg").getImage(),200,200));
			img3=new ImageIcon(getScaledImage(new ImageIcon("images/life5.jpg").getImage(),200,200));
			img4=new ImageIcon(getScaledImage(new ImageIcon("images/exit2.jpg").getImage(),200,200));
			//setSize(200,800);
			setBounds(0, 0, 200, 800);
			new MyDropTargetListener(this);
			label1 = new JLabel(img1);
	        label2 = new JLabel(img2);
	        label3 = new JLabel(img3);
	        label4 = new JLabel(img4);
	        label1.setBorder(BorderFactory.createLineBorder(Color.black));
	        label1.setToolTipText("Car Insurance");
	        label2.setBorder(BorderFactory.createLineBorder(Color.black));
	        label2.setToolTipText("Health Insurance");
	        label3.setBorder(BorderFactory.createLineBorder(Color.black));
	        label3.setToolTipText("Life Insurance");
	        label4.setBorder(BorderFactory.createLineBorder(Color.black));
	        label4.setToolTipText("Exit Program");
	        MyDragGestureListener dlistener = new MyDragGestureListener();
	        DragSource ds1 = new DragSource();
	        ds1.createDefaultDragGestureRecognizer(label1, DnDConstants.ACTION_COPY, dlistener);

	        DragSource ds2 = new DragSource();
	        ds2.createDefaultDragGestureRecognizer(label2, DnDConstants.ACTION_COPY, dlistener);

	        DragSource ds3 = new DragSource();
	        ds3.createDefaultDragGestureRecognizer(label3, DnDConstants.ACTION_COPY, dlistener);
	        
	        DragSource ds4 = new DragSource();
	        ds4.createDefaultDragGestureRecognizer(label4, DnDConstants.ACTION_COPY, dlistener);

	        add(label1);
	        add(label2);
	        add(label3);
	        add(label4);
		}
		
		private class MyDropTargetListener extends DropTargetAdapter {

            private DropTarget dropTarget;
            private JPanel p;

            public MyDropTargetListener(JPanel panel) {
                p = panel;
                dropTarget = new DropTarget(panel, DnDConstants.ACTION_COPY, this, true, null);
                
            }

            @Override
            public void drop(DropTargetDropEvent event) {
                try {
                    DropTarget test = (DropTarget) event.getSource();
                    Component ca = (Component) test.getComponent();
                    Point dropPoint = ca.getMousePosition();
                    Transferable tr = event.getTransferable();

                    if (event.isDataFlavorSupported(DataFlavor.imageFlavor)) {
                        Icon ico = (Icon) tr.getTransferData(DataFlavor.imageFlavor);

                        if (ico != null) {
                        	
                            thread = false;  
                            drawRect = -1;
                            
                            p.revalidate();
                            p.repaint();
                            centerpanel.repaint();
                            event.dropComplete(true);
                        }
                    } else {
                        event.rejectDrop();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    event.rejectDrop();
                }
            }
        }
		
		private class MyDragGestureListener implements DragGestureListener {

		    @Override
		    public void dragGestureRecognized(DragGestureEvent event) {
		        JLabel label = (JLabel) event.getComponent();
		        if(currentPanel != null){
		        	currentPanel.setVisible(false);
		        }
		        
		        if(!rectEnimNow){
		        	task = new RectEnimation();
					threadExecutor = Executors.newCachedThreadPool();
					threadExecutor.execute(task);
					
					// shut down worker threads when their tasks complete
					threadExecutor.shutdown();
		        }
		        
		       
		        final Icon ico = label.getIcon();


		        Transferable transferable = new Transferable() {
		            @Override
		            public DataFlavor[] getTransferDataFlavors() {
		                return new DataFlavor[]{DataFlavor.imageFlavor};
		            }

		            @Override
		            public boolean isDataFlavorSupported(DataFlavor flavor) {
		                if (!isDataFlavorSupported(flavor)) {
		                    return false;
		                }
		                return true;
		            }

		            @Override
		            public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
		                return ico;
		            }
		        };
		        event.startDrag(null, transferable);
		    }
		}
		
		
	}
	
	public Image getScaledImage(Image srcImg, int w, int h){
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();

	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();

	    return resizedImg;
	}
	
	private class RectEnimation implements Runnable {
    	
		@Override
		public void run() {
			// TODO Auto-generated method stub
			drawRect = 0;
			thread = true;
			rectEnimNow = true;
			MyTimer t = new MyTimer();
			imgLabel2.setVisible(true);
			imgLabel3.setVisible(true);
			while(t.getTimer() < 3 && thread){
				repaint();
				try {
					Thread.sleep(50); 
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Thread.currentThread().interrupt();
		              return;
				}
				drawRect = ( drawRect + 1 ) % 16;
			}
			drawRect = -1;
			repaint();
			rectEnimNow = false;
		}
    	
    }
	
	private class LoginEnimation implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			int w = thisFrame.getWidth();
			int h = thisFrame.getHeight();
			
			while(w > 100 || h > 80){
				if(w > 100){
					w -= 5;
				}
				if(h > 80){
					h -= 5;
				}
				
				thisFrame.setSize(w, h);
			}
			
			loginFrame.setSize(loginFrame.getFrameWidth(), loginFrame.getFrameHeight());
			loginFrame.setLocationRelativeTo(null);
			loginFrame.setVisible(true);
			thisFrame.dispose();
		}
    	
    }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(currentPanel != null){
			if ((e.getKeyCode() == KeyEvent.VK_N) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
	            
	            currentPerson ++;
	            if(currentPerson < care.getSize()){
	            	ori.getStateFromMemento(care.get(currentPerson));
	            	currentPanel.setUser();
	            }
	            else {
	            	currentPerson = care.getSize();
	            }
	        }
			
			if ((e.getKeyCode() == KeyEvent.VK_P) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
	            
	            currentPerson --;
	            if(currentPerson >= 0){
	            	ori.getStateFromMemento(care.get(currentPerson));
	            	currentPanel.setUser();
	            }
	            else {
	            	currentPerson = 0;
	            }
	            
	        }
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	
	
	public void setCurrentPerson(int p){
		this.currentPerson = p;
	}
	
	
}

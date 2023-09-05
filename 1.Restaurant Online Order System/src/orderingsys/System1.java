package orderingsys;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;
import java.awt.event.*;
import java.awt.Image;
 
public class System1 implements ActionListener{
    //north
	JMenuBar jm1=new JMenuBar();
    private JLabel jl1;
    
    //south
    private JButton jb1, jb2, jb3, jb4;
    private JPanel jp1;    
    
    //west
    private JTabbedPane jtp2;
    private JPanel jp8;
    private JButton jb6, jb7, jb8, jb9, jb10, jb11;
    
    //east  
    private JPanel jp9;
    private JComboBox<String> jcb11;
    private JLabel jl20, jl21, jl22;
    private JTextField jtf2;
    private JTable jt;
    private JScrollPane jsp;
    
    String[] jg = { "Table1", "Table2", "Table3" };
    private DefaultTableModel model;
    private Vector<Vector<String>> data;
    private Vector<String> names;
    
    //center
    private JTabbedPane jtp;
    private ImageIcon img;
    private JPanel jp2, jp3, jp4, jp5, jp6, jp7;    
    private JLabel jl2, jl3, jl4, jl5, jl6, jl7, jl8, jl9, jl10, jl11, jl12, jl13, jl14, jl15, jl16, jl17, jl18, jl19;
    private JCheckBox jcb1, jcb2, jcb3, jcb4, jcb5, jcb6, jcb7, jcb8, jcb9;

    boolean B = true;
 
    private void scaleImage(JLabel label, int width, int height) {
        ImageIcon icon = (ImageIcon) label.getIcon();
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(scaledImage));
    }
    
    //Main frame
    JFrame jf;
 	public void init(String username) {
	    //north
		jl1 = new JLabel("***** Welcome to XXX *****",JLabel.CENTER);
		jl1.setOpaque(true);//To set the background color you must first set it to opaque
		jl1.setBackground(Color.PINK);
		Font f = new Font("Calibri",Font.PLAIN,45); 
		jl1.setFont(f);
		jl1.setForeground(Color.BLACK);
	    
		JMenu menu1=new JMenu("System settings");	
    	jm1.add(menu1);
	         
    	JMenu menu2=new JMenu("Restaurant name color");	        
    	JMenuItem item1=new JMenuItem("Sign out");	       	             
    	menu1.add(menu2);
    	menu1.addSeparator();
    	menu1.add(item1);
    	
	    //Set listening to log out
        item1.addActionListener(new ActionListener() {	            
            public void actionPerformed( ActionEvent e) {
                int i=JOptionPane.showConfirmDialog(null, "Sign out","Sign out",JOptionPane.YES_NO_OPTION);       
                if(i == JOptionPane.YES_OPTION) {                     	                
                	jf.setVisible(false);
                	new Land().init();
                }
            }
        });
   
	    //Menu bar sets the title color                      
        JMenuItem item2=new JMenuItem("Blue");	                
        JMenuItem item3=new JMenuItem("Red");	                	        
        JMenuItem item4=new JMenuItem("Black");	            
        JMenuItem item5=new JMenuItem("Green");
        menu2.add(item2);
        menu2.add(item3);
        menu2.add(item4);	       
        menu2.add(item5);
        
        item2.addActionListener(new ActionListener() {       	
        	public void actionPerformed( ActionEvent e) {
        		jl1.setForeground(Color.BLUE);
                }           
        });
        item3.addActionListener(new ActionListener() {        	
        	public void actionPerformed( ActionEvent e) {
        		jl1.setForeground(Color.RED);
                }           
        });
        item4.addActionListener(new ActionListener() {        	
        	public void actionPerformed( ActionEvent e) {
        		jl1.setForeground(Color.BLACK);
                }           
        });
        item5.addActionListener(new ActionListener() {       	
        	public void actionPerformed( ActionEvent e) {
        		jl1.setForeground(Color.green);
                }           
        });
        
	    //south
	    jp1 = new JPanel();
	    jb1 = new JButton("Cancel");
	    jb2 = new JButton("Order");
	    jb3 = new JButton("Add");
	    jb4 = new JButton("Checkout");
	    
	    //Add Component
	    jp1.add(jb1);
	    jp1.add(jb2);
	    jp1.add(jb3);
	    jp1.add(jb4);
 
	    //west
	    jtp2 = new JTabbedPane();
	    jp8 = new JPanel();    	    
	    jb6 = new JButton("Recommendation");
	    jb7 = new JButton("Appetizer");	    
	    jb8 = new JButton("Vegetables");	    
	    jb9 = new JButton("Soup");	    
	    jb10 = new JButton("Dessert");	
	    jb11 = new JButton("Beverage");
	  
	    //Add Component	    
	 	jp8.add(jb6);
	    jp8.add(jb7);
	    jp8.add(jb8);
	    jp8.add(jb9);
	    jp8.add(jb10);
	    jp8.add(jb11);	  
	    	    	    
	    //east
	    jp9 = new JPanel();
	    jl20 = new JLabel("Please select a table number：");	    
	    jcb11 = new JComboBox<String>(jg);

	    jl21 = new JLabel("Please enter the number of diners：");
	    jtf2 = new JTextField();
	    jl22 = new JLabel("Ordered menu list：");	
	    
	    model = new DefaultTableModel(); // Create a new data model
	    data = new Vector<Vector<String>>(); // Data row vector set, because the list has more than one row, add data row vectors to it
	    names = new Vector<String>();
	    names.add("dish name");	
	    names.add("price（$）");    
	    model.setDataVector(data,names); // Set the element in the model, it will be automatically displayed in the list
	    jt = new JTable(model); // Create a JTable with the data model
	    jsp = new JScrollPane(jt); // Create a scrollable Panel with a list and add this Panel to the window	   	  
	    
	    //east
	    jp9.add(jl20);
	    jp9.add(jcb11);
	    jp9.add(jl21);
	    jp9.add(jtf2);
	    jp9.add(jl22);
	    jp9.add(jsp);
	    
	    //center
	    jtp = new JTabbedPane();
	    
	    img=new ImageIcon("Soup//Miso Soup.jpg");       
        jl2 = new JLabel(img); 
        scaleImage(jl2, 90, 80);
        img=new ImageIcon("Soup//Pumpkin Soup.jpg");          
        jl3 = new JLabel(img);
        scaleImage(jl3, 90, 80);
        img=new ImageIcon("Soup//Chicken Soup.jpg");          
        jl4 = new JLabel(img);
        scaleImage(jl4, 90, 80);
        img=new ImageIcon("Appetizer//Fish Rolls.jpg");           
        jl5 = new JLabel(img);
        scaleImage(jl5, 90, 80);
        img=new ImageIcon("Appetizer//Pizza.jpg");          
        jl6 = new JLabel(img);
        scaleImage(jl6, 90, 80);
        img=new ImageIcon("Appetizer//Sausage.jpg");          
        jl7 = new JLabel(img);
        scaleImage(jl7, 90, 80);
        img=new ImageIcon("Vegetables//Mushroom.jpg");           
        jl8 = new JLabel(img);
        scaleImage(jl8, 90, 80);
        img=new ImageIcon("Vegetables//Sweet Potatoes.jpg");          
        jl9 = new JLabel(img);
        scaleImage(jl9, 90, 80);
        img=new ImageIcon("Vegetables//Creamed Corn.jpg");          
        jl10 = new JLabel(img);
        scaleImage(jl10, 90, 80);
        
        jl11 = new JLabel("39",JLabel.CENTER);
        jl12 = new JLabel("39",JLabel.CENTER);
        jl13 = new JLabel("39",JLabel.CENTER);
        jl14 = new JLabel("28",JLabel.CENTER);
        jl15 = new JLabel("28",JLabel.CENTER);
        jl16 = new JLabel("28",JLabel.CENTER);
        jl17 = new JLabel("18",JLabel.CENTER);
        jl18 = new JLabel("18",JLabel.CENTER);
        jl19 = new JLabel("18",JLabel.CENTER);
        
        jcb1 = new JCheckBox("Miso Soup");
	    jcb2 = new JCheckBox("Pumpkin Soup");
	    jcb3 = new JCheckBox("Chicken Soup");
	    jcb4 = new JCheckBox("Fish Rolls");
	    jcb5 = new JCheckBox("Pizza");
	    jcb6 = new JCheckBox("Sausage");
	    jcb7 = new JCheckBox("Mushroom");
	    jcb8 = new JCheckBox("Sweet Potatoes");
	    jcb9 = new JCheckBox("Creamed Corn");
	 
	    
	    jp2 = new JPanel();	            
	    jp3 = new JPanel();	   
	    jp4 = new JPanel();	    
	    jp5 = new JPanel();
	    jp6 = new JPanel();
	    jp7 = new JPanel();
 
	    //Add panels to tab panes
	    jtp.add("Recommendation", jp2);
	    jtp.add("Appetizer", jp3);
	    jtp.add("Vegetables", jp4);
	    jtp.add("Soup", jp5);
	    jtp.add("Dessert", jp6);
	    jtp.add("Beverage", jp7);

	    jtp2.add("Menu navigation", jp8);
	   
	    //set layout	   	    
	    jp2.setLayout(new GridLayout(9,3)); 
	    jp3.setLayout(new GridLayout(9,3));
	    jp4.setLayout(new GridLayout(9,3));
	    jp5.setLayout(new GridLayout(9,3));
	    jp6.setLayout(new GridLayout(9,3));
	    jp7.setLayout(new GridLayout(9,3));
	    jp8.setLayout(new GridLayout(15,1));
	    jp9.setLayout(new GridLayout(6,1));	
	    
	    jp9.setPreferredSize(new Dimension(250, 0));   	     
 
	    //Specify the action command 
	    jb1.addActionListener(this);
	    jb1.setActionCommand("Cancel");
	    jb2.addActionListener(this);
	    jb2.setActionCommand("Order");
	    jb3.addActionListener(this);
	    jb3.setActionCommand("Add");
	    jb4.addActionListener(this);
	    jb4.setActionCommand("Checkout");	   
	    jb6.addActionListener(this);
	    jb6.setActionCommand("Recommendation");
	    jb7.addActionListener(this);
	    jb7.setActionCommand("Appetizer");
	    jb8.addActionListener(this);
	    jb8.setActionCommand("Vegetables");
	    jb9.addActionListener(this);
	    jb9.setActionCommand("Soup");
	    jb10.addActionListener(this);
	    jb10.setActionCommand("Dessert");
	    jb11.addActionListener(this);
	    jb11.setActionCommand("Beverage");
	    
	    //center 
	    //image
	    jp2.add(jl2);
	    jp2.add(jl3);
	    jp2.add(jl4);
	    //price
	    jp2.add(jl11);
	    jp2.add(jl12);
	    jp2.add(jl13);
	    //name
	    jp2.add(jcb1);	   
	    jp2.add(jcb2);	    
	    jp2.add(jcb3);
	    
	    jp2.add(jl5);
	    jp2.add(jl6);
	    jp2.add(jl7);
	    jp2.add(jl14);
	    jp2.add(jl15);
	    jp2.add(jl16);
	    jp2.add(jcb4);				
	    jp2.add(jcb5);		
	    jp2.add(jcb6);
	    
	    jp2.add(jl8);
	    jp2.add(jl9);
	    jp2.add(jl10);
	    jp2.add(jl17);
	    jp2.add(jl18);
	    jp2.add(jl19);
	    jp2.add(jcb7);				
	    jp2.add(jcb8);		
	    jp2.add(jcb9);
	     
	    
	    //Center
	    //Appetizer   
	    img=new ImageIcon("Appetizer//Fish Rolls.jpg");      
        jl2 = new JLabel(img);
        scaleImage(jl2, 90, 80);
        img=new ImageIcon("Appetizer//Salad.jpg");          
        jl3 = new JLabel(img);
        scaleImage(jl3, 90, 80);
        img=new ImageIcon("Appetizer//Peanuts.jpg");          
        jl4 = new JLabel(img);
        scaleImage(jl4, 90, 80);
	    img=new ImageIcon("Appetizer//Bread.jpg");           
        jl5 = new JLabel(img);
        scaleImage(jl5, 90, 80);
        img=new ImageIcon("Appetizer//Sausage.jpg");          
        jl6 = new JLabel(img);
        scaleImage(jl6, 90, 80);
        img=new ImageIcon("Appetizer//Taco.jpg");          
        jl7 = new JLabel(img);
        scaleImage(jl7, 90, 80);
        img=new ImageIcon("Appetizer//Pizza.jpg");           
        jl8 = new JLabel(img);
        scaleImage(jl8, 90, 80);
        img=new ImageIcon("Appetizer//Fries.jpg");          
        jl9 = new JLabel(img);
        scaleImage(jl9, 90, 80);
        img=new ImageIcon();          
        jl10 = new JLabel(img);     
        
        jl11 = new JLabel("28",JLabel.CENTER);
        jl12 = new JLabel("28",JLabel.CENTER);
        jl13 = new JLabel("28",JLabel.CENTER);
        jl14 = new JLabel("28",JLabel.CENTER);
        jl15 = new JLabel("28",JLabel.CENTER);
        jl16 = new JLabel("28",JLabel.CENTER);
        jl17 = new JLabel("28",JLabel.CENTER);
        jl18 = new JLabel("28",JLabel.CENTER);
        jl19 = new JLabel("",JLabel.CENTER);
        
        jcb1 = new JCheckBox("Fish Rolls");
	    jcb2 = new JCheckBox("Salad");
	    jcb3 = new JCheckBox("Peanuts");
	    jcb4 = new JCheckBox("Bread");
	    jcb5 = new JCheckBox("Sausage");
	    jcb6 = new JCheckBox("Taco");
	    jcb7 = new JCheckBox("Pizza");
	    jcb8 = new JCheckBox("Fries");	    	    
	    
	    jp3.add(jl2);
	    jp3.add(jl3);
	    jp3.add(jl4);
	    jp3.add(jl11);
	    jp3.add(jl12);
	    jp3.add(jl13);
	    jp3.add(jcb1);				
	    jp3.add(jcb2);		
	    jp3.add(jcb3);
	    jp3.add(jl5);
	    jp3.add(jl6);
	    jp3.add(jl7);
	    jp3.add(jl14);
	    jp3.add(jl15);
	    jp3.add(jl16);
	    jp3.add(jcb4);				
	    jp3.add(jcb5);		
	    jp3.add(jcb6);
	    jp3.add(jl8);	    
	    jp3.add(jl9);
	    jp3.add(jl10);
	    jp3.add(jl17);
	    jp3.add(jl18);
	    jp3.add(jl19);
	    jp3.add(jcb7);				
	    jp3.add(jcb8);
	    
	    //Vegetables
	    img=new ImageIcon("Vegetables//Mushroom.jpg");      
        jl2 = new JLabel(img);
        scaleImage(jl2, 90, 80);
        img=new ImageIcon("Vegetables//Broccoli.jpg");          
        jl3 = new JLabel(img);
        scaleImage(jl3, 90, 80);
        img=new ImageIcon("Vegetables//Sweet Potatoes.jpg");          
        jl4 = new JLabel(img);
        scaleImage(jl4, 90, 80);
	    img=new ImageIcon("Vegetables//Lotus Root.jpg");           
        jl5 = new JLabel(img);
        scaleImage(jl5, 90, 80);
        img=new ImageIcon("Vegetables//Green Beans.jpg");          
        jl6 = new JLabel(img);
        scaleImage(jl6, 90, 80);
        img=new ImageIcon("Vegetables//Creamed Corn.jpg");          
        jl7 = new JLabel(img);
        scaleImage(jl7, 90, 80);
        img=new ImageIcon("Vegetables//Cucumber.jpg");           
        jl8 = new JLabel(img);
        scaleImage(jl8, 90, 80);
        img=new ImageIcon();          
        jl9 = new JLabel(img);
        img=new ImageIcon();          
        jl10 = new JLabel(img);        
        
        jl11 = new JLabel("18",JLabel.CENTER);
        jl12 = new JLabel("18",JLabel.CENTER);
        jl13 = new JLabel("18",JLabel.CENTER);
        jl14 = new JLabel("18",JLabel.CENTER);
        jl15 = new JLabel("18",JLabel.CENTER);
        jl16 = new JLabel("18",JLabel.CENTER);
        jl17 = new JLabel("18",JLabel.CENTER);
        jl18 = new JLabel("",JLabel.CENTER);
        jl19 = new JLabel("",JLabel.CENTER);       
        
        jcb1 = new JCheckBox("Mushroom");
	    jcb2 = new JCheckBox("Broccoli");
	    jcb3 = new JCheckBox("Sweet Potatoes");
	    jcb4 = new JCheckBox("Lotus Root");
	    jcb5 = new JCheckBox("Green Beans");
	    jcb6 = new JCheckBox("Creamed Corn");
	    jcb7 = new JCheckBox("Cucumber");	    	    	    
	    
	    jp4.add(jl2);
	    jp4.add(jl3);
	    jp4.add(jl4);
	    jp4.add(jl11);
	    jp4.add(jl12);
	    jp4.add(jl13);
	    jp4.add(jcb1);				
	    jp4.add(jcb2);		
	    jp4.add(jcb3);
	    jp4.add(jl5);
	    jp4.add(jl6);
	    jp4.add(jl7);
	    jp4.add(jl14);
	    jp4.add(jl15);
	    jp4.add(jl16);
	    jp4.add(jcb4);				
	    jp4.add(jcb5);		
	    jp4.add(jcb6);
	    jp4.add(jl8);	    
	    jp4.add(jl9);
	    jp4.add(jl10);
	    jp4.add(jl17);
	    jp4.add(jl18);
	    jp4.add(jl19);
	    jp4.add(jcb7);		
	    
	    //Soup
	    img=new ImageIcon("Soup//Miso Soup.jpg");      
        jl2 = new JLabel(img);  
        scaleImage(jl2, 90, 80);
        img=new ImageIcon("Soup//Potato Soup.jpg");          
        jl3 = new JLabel(img);
        scaleImage(jl3, 90, 80);
        img=new ImageIcon("Soup//Pumpkin Soup.jpg");          
        jl4 = new JLabel(img);
        scaleImage(jl4, 90, 80);
	    img=new ImageIcon("Soup//Vegetable Soup.jpg");           
        jl5 = new JLabel(img);
        scaleImage(jl5, 90, 80);
        img=new ImageIcon("Soup//Chicken Soup.jpg");          
        jl6 = new JLabel(img);
        scaleImage(jl6, 90, 80);
        img=new ImageIcon("Soup//Tomato Soup.jpg");          
        jl7 = new JLabel(img);
        scaleImage(jl7, 90, 80);
        img=new ImageIcon("Soup//Lentil Soup.jpg");           
        jl8 = new JLabel(img);
        scaleImage(jl8, 90, 80);
        img=new ImageIcon();          
        jl9 = new JLabel(img);
        img=new ImageIcon();          
        jl10 = new JLabel(img);        
        
        jl11 = new JLabel("39",JLabel.CENTER);
        jl12 = new JLabel("39",JLabel.CENTER);
        jl13 = new JLabel("39",JLabel.CENTER);
        jl14 = new JLabel("39",JLabel.CENTER);
        jl15 = new JLabel("39",JLabel.CENTER);
        jl16 = new JLabel("39",JLabel.CENTER);
        jl17 = new JLabel("39",JLabel.CENTER);
        jl18 = new JLabel("",JLabel.CENTER);
        jl19 = new JLabel("",JLabel.CENTER);
        
        jcb1 = new JCheckBox("Miso Soup");
	    jcb2 = new JCheckBox("Potato Soup");
	    jcb3 = new JCheckBox("Pumpkin Soup");
	    jcb4 = new JCheckBox("Vegetable Soup");
	    jcb5 = new JCheckBox("Chicken Soup");
	    jcb6 = new JCheckBox("Tomato Soup");
	    jcb7 = new JCheckBox("Lentil Soup");   	    
	    
	    jp5.add(jl2);
	    jp5.add(jl3);
	    jp5.add(jl4);
	    jp5.add(jl11);
	    jp5.add(jl12);
	    jp5.add(jl13);
	    jp5.add(jcb1);				
	    jp5.add(jcb2);		
	    jp5.add(jcb3);
	    jp5.add(jl5);
	    jp5.add(jl6);
	    jp5.add(jl7);
	    jp5.add(jl14);
	    jp5.add(jl15);
	    jp5.add(jl16);
	    jp5.add(jcb4);				
	    jp5.add(jcb5);		
	    jp5.add(jcb6);
	    jp5.add(jl8);	    
	    jp5.add(jl9);
	    jp5.add(jl10);
	    jp5.add(jl17);
	    jp5.add(jl18);
	    jp5.add(jl19);
	    jp5.add(jcb7);	
	    
	    //Dessert
	    img=new ImageIcon("Dessert//Cookies.jpg");      
        jl2 = new JLabel(img);  
        scaleImage(jl2, 90, 80);
        img=new ImageIcon("Dessert//Chocolate Cake.jpg");          
        jl3 = new JLabel(img);
        scaleImage(jl3, 90, 80);
        img=new ImageIcon("Dessert//Lemon Squares.jpg");          
        jl4 = new JLabel(img);
        scaleImage(jl4, 90, 80);
	    img=new ImageIcon("Dessert//Mousse Bars.jpg");           
        jl5 = new JLabel(img);
        scaleImage(jl5, 90, 80);
        img=new ImageIcon("Dessert//Brownies.jpg");          
        jl6 = new JLabel(img);
        scaleImage(jl6, 90, 80);
        img=new ImageIcon("Dessert//Pudding.jpg");          
        jl7 = new JLabel(img);
        scaleImage(jl7, 90, 80);
        img=new ImageIcon("Dessert//Tart.jpg");           
        jl8 = new JLabel(img);
        scaleImage(jl8, 90, 80);
        img=new ImageIcon();          
        jl9 = new JLabel(img);
        img=new ImageIcon();          
        jl10 = new JLabel(img);        
        
        jl11 = new JLabel("12",JLabel.CENTER);
        jl12 = new JLabel("12",JLabel.CENTER);
        jl13 = new JLabel("12",JLabel.CENTER);
        jl14 = new JLabel("12",JLabel.CENTER);
        jl15 = new JLabel("12",JLabel.CENTER);
        jl16 = new JLabel("12",JLabel.CENTER);
        jl17 = new JLabel("12",JLabel.CENTER);
        jl18 = new JLabel("",JLabel.CENTER);
        jl19 = new JLabel("",JLabel.CENTER);
        
        jcb1 = new JCheckBox("Cookies");
	    jcb2 = new JCheckBox("Chocolate Cake");
	    jcb3 = new JCheckBox("Lemon Squares");
	    jcb4 = new JCheckBox("Mousse Bars");
	    jcb5 = new JCheckBox("Brownies");
	    jcb6 = new JCheckBox("Pudding");
	    jcb7 = new JCheckBox("Tart");    	    
	    
	    jp6.add(jl2);
	    jp6.add(jl3);
	    jp6.add(jl4);
	    jp6.add(jl11);
	    jp6.add(jl12);
	    jp6.add(jl13);
	    jp6.add(jcb1);				
	    jp6.add(jcb2);		
	    jp6.add(jcb3);
	    jp6.add(jl5);
	    jp6.add(jl6);
	    jp6.add(jl7);
	    jp6.add(jl14);
	    jp6.add(jl15);
	    jp6.add(jl16);
	    jp6.add(jcb4);				
	    jp6.add(jcb5);		
	    jp6.add(jcb6);
	    jp6.add(jl8);	    
	    jp6.add(jl9);
	    jp6.add(jl10);
	    jp6.add(jl17);
	    jp6.add(jl18);
	    jp6.add(jl19);
	    jp6.add(jcb7);	
	    
	    //Beverage
	    img=new ImageIcon("Beverage//Sprite.jpg");      
        jl2 = new JLabel(img);     
        scaleImage(jl2, 90, 80);
        img=new ImageIcon("Beverage//Coke.jpg");          
        jl3 = new JLabel(img);
        scaleImage(jl3, 90, 80);
        img=new ImageIcon("Beverage//Pepsi.jpg");          
        jl4 = new JLabel(img);
        scaleImage(jl4, 90, 80);
	    img=new ImageIcon("Beverage//Sweet tea.jpg");           
        jl5 = new JLabel(img);
        scaleImage(jl5, 90, 80);
        img=new ImageIcon("Beverage//Milk tea.jpg");          
        jl6 = new JLabel(img);
        scaleImage(jl6, 90, 80);
        img=new ImageIcon("Beverage//Milkshake.jpg");          
        jl7 = new JLabel(img);
        scaleImage(jl7, 90, 80);
        img=new ImageIcon("Beverage//Juice.jpg");           
        jl8 = new JLabel(img);
        scaleImage(jl8, 90, 80);
        img=new ImageIcon();          
        jl9 = new JLabel(img);
        img=new ImageIcon();          
        jl10 = new JLabel(img);        
        
        jl11 = new JLabel("5",JLabel.CENTER);
        jl12 = new JLabel("5",JLabel.CENTER);
        jl13 = new JLabel("5",JLabel.CENTER);
        jl14 = new JLabel("5",JLabel.CENTER);
        jl15 = new JLabel("5",JLabel.CENTER);
        jl16 = new JLabel("5",JLabel.CENTER);
        jl17 = new JLabel("5",JLabel.CENTER);
        jl18 = new JLabel("",JLabel.CENTER);
        jl19 = new JLabel("",JLabel.CENTER);
        
        jcb1 = new JCheckBox("Sprite");
	    jcb2 = new JCheckBox("Coke");
	    jcb3 = new JCheckBox("Pepsi");
	    jcb4 = new JCheckBox("Sweet tea");
	    jcb5 = new JCheckBox("Milk tea");
	    jcb6 = new JCheckBox("Milkshake");
	    jcb7 = new JCheckBox("Juice");	    	    
	    	    
	    jp7.add(jl2);
	    jp7.add(jl3);
	    jp7.add(jl4);
	    jp7.add(jl11);
	    jp7.add(jl12);
	    jp7.add(jl13);
	    jp7.add(jcb1);				
	    jp7.add(jcb2);		
	    jp7.add(jcb3);
	    jp7.add(jl5);
	    jp7.add(jl6);
	    jp7.add(jl7);
	    jp7.add(jl14);
	    jp7.add(jl15);
	    jp7.add(jl16);
	    jp7.add(jcb4);				
	    jp7.add(jcb5);		
	    jp7.add(jcb6);
	    jp7.add(jl8);	    
	    jp7.add(jl9);
	    jp7.add(jl10);
	    jp7.add(jl17);
	    jp7.add(jl18);
	    jp7.add(jl19);
	    jp7.add(jcb7);				
	    	       	  	  
	    // display component       	    
	    jf = new JFrame("Ordering system");
	    jf.setSize(860, 635);
	    jf.setJMenuBar(jm1);
	    jf.setLayout(new BorderLayout(10,0)); //Component spacing    
	    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	  	
	    jf.setLocationRelativeTo(null);
	    jf.setVisible(true);
	    	  	 	
	    jf.add(jp1,BorderLayout.SOUTH);
	    jf.add(jl1,BorderLayout.NORTH);	    
	    jf.add(jtp,BorderLayout.CENTER);
	    jf.add(jtp2,BorderLayout.WEST);
	    jf.add(jp9,BorderLayout.EAST);   	    
	}
	
	//listener
	public void actionPerformed(ActionEvent e) {	
	//Determine which button was clicked
		switch(e.getActionCommand()) {
		
		case "Cancel":
			ForJCheckBox(jp2);
			ForJCheckBox(jp3);
			ForJCheckBox(jp4);
			ForJCheckBox(jp5);
			ForJCheckBox(jp6);
			ForJCheckBox(jp7);
			break;
			
		case "Order":
			if(B && ForJCheckBoxnum(jp9)) {					    			    
				ForJCheckBoxStr(jp2,data,names,model,jt);
				ForJCheckBoxStr(jp3,data,names,model,jt);
				ForJCheckBoxStr(jp4,data,names,model,jt);
				ForJCheckBoxStr(jp5,data,names,model,jt);
				ForJCheckBoxStr(jp6,data,names,model,jt);
				ForJCheckBoxStr(jp7,data,names,model,jt);					
				jp9.add(jsp);
				B = false;	
			}
			else if(ForJCheckBoxnum(jp9) == false) {
				JOptionPane.showMessageDialog(null, "Please enter the number of diners", "order error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null, "Please click the add button to add order", "order error", JOptionPane.ERROR_MESSAGE);
				ForJCheckBox(jp2);
				ForJCheckBox(jp3);
				ForJCheckBox(jp4);
				ForJCheckBox(jp5);
				ForJCheckBox(jp6);
				ForJCheckBox(jp7);
			}
			break;
			
		case "Add":	
			if(B == false) {			
				ForJCheckBoxStr(jp2,data,names,model,jt);
				ForJCheckBoxStr(jp3,data,names,model,jt);
				ForJCheckBoxStr(jp4,data,names,model,jt);
				ForJCheckBoxStr(jp5,data,names,model,jt);
				ForJCheckBoxStr(jp6,data,names,model,jt);
				ForJCheckBoxStr(jp7,data,names,model,jt);
				jp9.add(jsp);			
			}
			else {
				JOptionPane.showMessageDialog(null, "You have not placed an order yet, please click the order button first", "Order error", JOptionPane.ERROR_MESSAGE);
				ForJCheckBox(jp2);
				ForJCheckBox(jp3);
				ForJCheckBox(jp4);
				ForJCheckBox(jp5);
				ForJCheckBox(jp6);
				ForJCheckBox(jp7);
			}	
			break;
			
		case "Checkout":
			if(jt.getRowCount() != 0) {
				{
					JDialog FRAME = new JDialog();//Constructs a new JFrame as the new window.
					FRAME.setSize(1000, 400);
					FRAME.setLocation(300, 200);
					FRAME.setBounds(new Rectangle((int) jf.getBounds().getX() + 50,(int) jf.getBounds().getY() + 50, (int) jf.getBounds().getWidth(), (int) jf.getBounds().getHeight()));											   
					FRAME.add(jsp,BorderLayout.NORTH);
					JButton button = new JButton("Checkout");
					FRAME.add(button,BorderLayout.WEST);
					button.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							FRAME.dispose();						
							double sum = 0;
							for(int i = 0; i < model.getRowCount(); i++) {
								double price = Double.parseDouble(model.getValueAt(i, 1).toString());
								sum += price;
								}
								JOptionPane.showMessageDialog(null, "Total：$ " + sum, "Checkout", JOptionPane.INFORMATION_MESSAGE);
						}
					});			
					FRAME.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);// Set the mode type.					
					FRAME.setVisible(true);
					B = true;
					((DefaultTableModel)jt.getModel()).getDataVector().clear();// Clear the previous person's menu	
					break;
				} 
			}else {
				JOptionPane.showMessageDialog(null, "You have not placed an order yet, cannot proceed to checkout", "Checkout error", JOptionPane.ERROR_MESSAGE);
				ForJCheckBox(jp2);
				ForJCheckBox(jp3);
				ForJCheckBox(jp4);
				ForJCheckBox(jp5);
				ForJCheckBox(jp6);
				ForJCheckBox(jp7);
			}
		case "Recommendation":
			jtp.setSelectedIndex(0);
			break;
		case "Appetizer":
			jtp.setSelectedIndex(1);
			break;
		case "Vegetables":
			jtp.setSelectedIndex(2);
			break;
		case "Soup":
			jtp.setSelectedIndex(3);
			break;
		case "Dessert":
			jtp.setSelectedIndex(4);
			break;
		case "Beverage":
			jtp.setSelectedIndex(5);
			break;
		}		
	}
 
	//Uncheck the checked
	void ForJCheckBox(JPanel p) {
		int count = p.getComponentCount();
		for (int i = 0; i < count; i++) {
			Component comp = p.getComponent(i);
			if(comp instanceof JCheckBox){
				JCheckBox jcb = (JCheckBox)comp;
				if(jcb.isSelected()) {
					jcb.setSelected(false);				
				}
			}
		}
	}
 
	//Determine whether to enter the number of diners
	boolean ForJCheckBoxnum(JPanel p) {
		int count = p.getComponentCount();
		for(int i=0; i<count; i++) {
			Component comp = p.getComponent(i);
			if(comp instanceof JTextField) {
				JTextField jtf = (JTextField)comp;
				if(jtf.getText().equals(""))return false;
			}
		}return true;
	}
	 
	//Add the ordered dishes and prices to JTable
	void ForJCheckBoxStr(JPanel p,Vector<Vector<String>> data,Vector<String> names,DefaultTableModel model,JTable jt) {	
		int count = p.getComponentCount();
		for(int i=0; i<count; i++) {
			Component comp = p.getComponent(i);
			if(comp instanceof JCheckBox) {
				JCheckBox jcb = (JCheckBox)comp;
				if(jcb.isSelected()) {
					jcb.setSelected(false);	
					Component Comp = p.getComponent(i-3);
					JLabel jl = (JLabel)Comp;			
					Vector Row = new Vector();
					Row.add(jcb.getText());
					Row.add(jl.getText());
					data.add((Vector<String>) Row.clone());
					model = new DefaultTableModel(data, names);				
					jt.setModel(model);
				}
			}
		}
	}
}

import java.awt.EventQueue;

import java.awt.event.*;
import java.io.IOException;
import java.net.URL;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.util.*;

public class HW3GUI implements MouseMotionListener, ActionListener, MouseListener {

	private JFrame frame = new JFrame();
	JLayeredPane lp1 = new JLayeredPane();
	JPanel mainPanel = new JPanel();
	JLabel ChrisSweetLabel = new JLabel("");
	JLabel LJHLabel = new JLabel("");
	JLabel AustinPostLabel = new JLabel("");
	JLabel PattyWiseLabel = new JLabel("");
	JLabel DBurdLabel = new JLabel("");
	JLabel ShaqLabel = new JLabel("");
	JTextArea PeopleInfoText = new JTextArea();
	JLabel CityImage = new JLabel("");
	Point diffDrag;
	ArrayList<JLabel> peopleLabel = new ArrayList<JLabel>();
	ArrayList<Person> people = new ArrayList<Person>();
	
	JLabel PeopleTitle = new JLabel("Personal Information (click on the person to view)");
	JLabel People = new JLabel("________________________________________");
	
	JButton PoliceButton = new JButton("C.P.D. HQ Information");
	JButton SchoolButton = new JButton("School Information");
	
	JPanel BuildingInfoPanel = new JPanel();
	JPanel PeopleInfoPanel = new JPanel();
	
	JLabel BuildingInfoLabel = new JLabel("Building Information");
	JLabel BuildingUnderline = new JLabel("________________");
	
	JLabel BuildingName = new JLabel("Name:");
	JLabel NameBText = new JLabel("");
	
	JLabel BuildlingAddressLabel = new JLabel("Address:");
	JLabel AddressText = new JLabel("");
	
	JLabel PeopleInBuildingLabel = new JLabel("People in Building: (drag people fully onto beige color, then click button)");
	JTextArea PeopleInBuildingText = new JTextArea();

	

	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HW3GUI window = new HW3GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HW3GUI() {
		initialize();
	}
	
	
	
	
	////MouseMotionListener interface functions
	/**
	 * mouseDragged function called when mouse is dragged
	 */
	public void mouseDragged(MouseEvent e) {
        System.out.println("dragging");
        JLabel label = null;
        for (int i = 0; i < people.size(); i++) {
            if (peopleLabel.get(i).getBounds().contains(e.getPoint())) {
                label = peopleLabel.get(i);
            }
        }
        if (label != null) {
            if (diffDrag == null)
                diffDrag = new Point(e.getX() - label.getBounds().x, e.getY() - label.getBounds().y);
            label.setBounds(e.getX() - diffDrag.x, e.getY()-diffDrag.y, label.getBounds().width, label.getBounds().height);
            System.out.printf("moved label to <%d, %d>", e.getX() - diffDrag.x, e.getY()-diffDrag.y);
        }
    }
     
	
	/**
	 * mouseMoved called when mouse is moved, sets diffDrag to null
	 */
    public void mouseMoved(MouseEvent e) {
        diffDrag = null;
    }


    ///ActionListener interface functions
    /**
     * this function is called when either button is pressed,
     * will display the name, address, and names of people in the building once pressed.
     */
    public void actionPerformed(ActionEvent e) {
    	///If-else statements to determine which button is pressed
    	if (e.getSource() == PoliceButton) {
    		CityHall hall = new CityHall();
    		NameBText.setText(hall.getName());
    		AddressText.setText(hall.getAddress());
    		String namesPD = new String();
    		for (int i = 0; i < people.size(); i++) {
    			if (((peopleLabel.get(i).getX() + 38) <= 330) && ((peopleLabel.get(i).getY() + 64) <= 174))
    				namesPD = namesPD + people.get(i).getName() + ", ";
    		}
    		PeopleInBuildingText.setText(namesPD);
    	}
    	
    	else if (e.getSource() == SchoolButton) {
    		School school = new School();
    		NameBText.setText(school.getName());
    		AddressText.setText(school.getAddress());
    		String namesSch = new String();
    		for (int i = 0; i < people.size(); i++) {
    			if ((peopleLabel.get(i).getX() >= 373) && ((peopleLabel.get(i).getY() + 64) <= 174))
    				namesSch = namesSch + people.get(i).getName() + ", ";
    		}
    		PeopleInBuildingText.setText(namesSch);
    	} 	
    }
    	
    
    
    
	
	////MouseListener interface functions
    /**
     * when mousePressed is called, in the people information text box, there will display the information of the selected person.
     */
	 public void mousePressed(MouseEvent e) {
    	 for(int i = 0; i < peopleLabel.size(); i++) {
  	       if((e.getPoint().getX() >= peopleLabel.get(i).getX()) && (e.getPoint().getX() <= (peopleLabel.get(i).getX() + 32)) &&
  	    		   (e.getPoint().getY() >= peopleLabel.get(i).getY()) && (e.getPoint().getY() <= (peopleLabel.get(i).getY() + 64))) {
  	    	   PeopleInfoText.setText(people.get(i).toString());
  	    	   
  	       }
      	 }
	    }

	 /**
	  * I did not change this function
	  */
     public void mouseReleased(MouseEvent e) {
	       System.out.printf("Mouse released; # of clicks: "
	                    + e.getClickCount(), e);
	    }

	 /**
	  * I did not change this function
	  */
     public void mouseEntered(MouseEvent e) {
	       System.out.printf("Mouse entered", e);
	    }

	 /**
	  * I did not change this function
	  */
     public void mouseExited(MouseEvent e) {
	       System.out.printf("Mouse exited", e);
	    }

     /**
      * mouseClicked function will display people information only when the click happens on the peopleLabel area
      */
     public void mouseClicked(MouseEvent e) {
    	// System.out.printf(e.getPoint().getX() + "      " + e.getPoint().getY() + "\n");
    	 for(int i = 0; i < peopleLabel.size(); i++) {
	       if((e.getPoint().getX() >= peopleLabel.get(i).getX()) && (e.getPoint().getX() <= (peopleLabel.get(i).getX() + 32)) &&
	    		   (e.getPoint().getY() >= peopleLabel.get(i).getY()) && (e.getPoint().getY() <= (peopleLabel.get(i).getY() + 64))) {
	    	   PeopleInfoText.setText(people.get(i).toString());
	    	   
	       }
    	 }
	    }

     
     
     
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		
		//Frame set up
		frame.setResizable(false);
		frame.setBounds(100, 100, 715, 660);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//layered Pane set up
		lp1.setBounds(0, 0, 706, 637);
		lp1.addMouseMotionListener(this);
		lp1.addMouseListener(this);
		frame.getContentPane().add(lp1);
	
		
		// Main Panel setup
		mainPanel.setBackground(Color.LIGHT_GRAY);
		mainPanel.setBounds(0, 0, 705, 627);
		lp1.add(mainPanel);
		mainPanel.setLayout(null);
		ChrisSweetLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		// Police officer 1 setup
		ChrisSweetLabel.setBounds(167, 334, 32, 64);
		try {
			URL chris = new URL("https://piskel-imgstore-b.appspot.com/img/d2c67f2e-177f-11e9-a98f-6ba63478843c.gif");
			Image chrisImage = ImageIO.read(chris);
			ChrisSweetLabel.setIcon(new ImageIcon(chrisImage));

		} catch (IOException e) {
			System.out.printf("oops");
		}
		ChrisSweetLabel.setIcon(new ImageIcon("C:\\Users\\csweet20\\Desktop\\Java\\HW3\\src\\police.png"));
		ChrisSweetLabel.setForeground(Color.MAGENTA);
		ChrisSweetLabel.setBackground(Color.YELLOW);
		mainPanel.add(ChrisSweetLabel);
		
		
		//CityImage setup
		CityImage.setVerticalAlignment(SwingConstants.TOP);
		CityImage.setIcon(new ImageIcon("C:\\Users\\csweet20\\Desktop\\Java\\HW3\\src\\City.png"));
		CityImage.setHorizontalAlignment(SwingConstants.CENTER);
		CityImage.setBounds(0, 0, 704, 627);
		
		//Austin Post setup
		AustinPostLabel.setHorizontalAlignment(SwingConstants.CENTER);
		try {
			URL austin = new URL("https://piskel-imgstore-b.appspot.com/img/90f2e651-177d-11e9-8880-6ba63478843c.gif");
			Image austinImage = ImageIO.read(austin);
			AustinPostLabel.setIcon(new ImageIcon(austinImage));

		} catch (IOException e) {
			System.out.printf("oops");
		}
		AustinPostLabel.setBounds(209, 334, 32, 64);
		mainPanel.add(AustinPostLabel);
		
		// Patty Wise setup
		PattyWiseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		try {
			URL patty = new URL("https://piskel-imgstore-b.appspot.com/img/7bafa51c-177f-11e9-9b8e-6ba63478843c.gif");
			Image pattyImage = ImageIO.read(patty);
			PattyWiseLabel.setIcon(new ImageIcon(pattyImage));

		} catch (IOException e) {
			System.out.printf("oops");
		}
		PattyWiseLabel.setBounds(125, 334, 32, 64);
		mainPanel.add(PattyWiseLabel);
		DBurdLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		
		//David Burd setup
		DBurdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		try {
			URL david = new URL("https://piskel-imgstore-b.appspot.com/img/2c8cdd11-177f-11e9-8bb2-6ba63478843c.gif");
			Image davidImage = ImageIO.read(david);
			DBurdLabel.setIcon(new ImageIcon(davidImage));

		} catch (IOException e) {
			System.out.printf("oops");
		}
		DBurdLabel.setBounds(89, 348, 38, 50);
		mainPanel.add(DBurdLabel);
		
		//Shaq setup
		ShaqLabel.setHorizontalAlignment(SwingConstants.CENTER);
		try {
			URL shaq = new URL("https://piskel-imgstore-b.appspot.com/img/d57399c5-177e-11e9-bcc0-6ba63478843c.gif");
			Image shaqImage = ImageIO.read(shaq);
			ShaqLabel.setIcon(new ImageIcon(shaqImage));

		} catch (IOException e) {
			System.out.printf("oops");
		}
		ShaqLabel.setBounds(251, 334, 38, 64);
		mainPanel.add(ShaqLabel);
		
		//Humphrey setup
		LJHLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		LJHLabel.setHorizontalAlignment(SwingConstants.CENTER);
		try {
			URL ljh = new URL("https://piskel-imgstore-b.appspot.com/img/7f2b7ed7-177e-11e9-8676-6ba63478843c.gif");
			Image ljhImage = ImageIO.read(ljh);
			LJHLabel.setIcon(new ImageIcon(ljhImage));

		} catch (IOException e) {
			System.out.printf("oops");
		}
		LJHLabel.setBounds(55, 348, 32, 50);
		mainPanel.add(LJHLabel);
		
		//PoliceButtone setup
		PoliceButton.setBounds(89, 0, 162, 23);
		PoliceButton.addActionListener(this);
		mainPanel.add(PoliceButton);
		
		//SchoolButton setup
		SchoolButton.setBounds(466, 0, 148, 23);
		SchoolButton.addActionListener(this);
		mainPanel.add(SchoolButton);
		
		//PeopleinfoPanel and the text inside setup
		PeopleInfoPanel.setBackground(new Color(0, 128, 0));
		PeopleInfoPanel.setBounds(10, 536, 424, 80);
		PeopleInfoPanel.setOpaque(false);
		mainPanel.add(PeopleInfoPanel);
		PeopleInfoPanel.setLayout(null);
		PeopleInfoText.setBounds(10, 34, 404, 36);
		PeopleInfoPanel.add(PeopleInfoText);
		PeopleInfoText.setLineWrap(true);
		People.setBackground(Color.BLACK);
		People.setHorizontalAlignment(SwingConstants.CENTER);
		People.setBounds(48, 11, 309, 14);
		PeopleInfoPanel.add(People);
		PeopleTitle.setBackground(Color.BLACK);
		PeopleTitle.setBounds(48, 11, 309, 14);
		PeopleInfoPanel.add(PeopleTitle);
		PeopleTitle.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		
		
		
		///////////////////////////////////////////////
		///Building Panel setup
		BuildingInfoPanel.setBounds(10, 409, 424, 127);
		mainPanel.add(BuildingInfoPanel);
		BuildingInfoPanel.setLayout(null);
		BuildingInfoPanel.setOpaque(false);
		BuildingInfoLabel.setBackground(Color.BLACK);
		
		// Building title and underline setup
		BuildingInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		BuildingInfoLabel.setBounds(62, 0, 298, 14);
		BuildingInfoPanel.add(BuildingInfoLabel);
		BuildingUnderline.setBackground(Color.BLACK);
		BuildingUnderline.setHorizontalAlignment(SwingConstants.CENTER);
		BuildingUnderline.setBounds(143, 0, 137, 14);
		BuildingInfoPanel.add(BuildingUnderline);
		BuildingName.setBackground(Color.BLACK);
		
		// Building and space setup
		BuildingName.setBounds(10, 23, 46, 14);
		BuildingInfoPanel.add(BuildingName);
		NameBText.setBackground(Color.BLACK);
		NameBText.setBounds(62, 25, 235, 14);
		BuildingInfoPanel.add(NameBText);
		BuildlingAddressLabel.setBackground(Color.BLACK);
		
		// Address label and space setup
		BuildlingAddressLabel.setBounds(10, 40, 56, 14);
		BuildingInfoPanel.add(BuildlingAddressLabel);
		AddressText.setBackground(Color.BLACK);
		AddressText.setBounds(72, 40, 226, 14);
		BuildingInfoPanel.add(AddressText);
		PeopleInBuildingLabel.setBackground(Color.BLACK);
		
		
		//People in building setup
		PeopleInBuildingLabel.setBounds(10, 56, 404, 14);
		BuildingInfoPanel.add(PeopleInBuildingLabel);
		PeopleInBuildingText.setLineWrap(true);
		PeopleInBuildingText.setBounds(10, 73, 404, 43);
		BuildingInfoPanel.add(PeopleInBuildingText);
		
		
		//// Add cityImage last so that everything else is above it in the GUI
		mainPanel.add(CityImage);
		
		people.add(new Police("Chris Sweet", 50, 1234567, Police.PoliceRole.Chief));
		people.add(new Police("Austin Post", 24, 7654321, Police.PoliceRole.Patrol));
		people.add(new Teacher("Patty Wise", 55, 3452168, "5th", Teacher.Certification.Masters));
		people.add(new Teacher("Shaquille O'Neal", 46, 9876543, "Professor", Teacher.Certification.Phd));
		people.add(new Kid("Lil'Jordan Humphrey", 12, "Reese's"));
		people.add(new Kid("David Burd", 9, "Three Musketeers"));
		
		peopleLabel.add(ChrisSweetLabel);
		peopleLabel.add(AustinPostLabel);
		peopleLabel.add(PattyWiseLabel);
		peopleLabel.add(ShaqLabel);
		peopleLabel.add(LJHLabel);
		peopleLabel.add(DBurdLabel);
		
	}
}

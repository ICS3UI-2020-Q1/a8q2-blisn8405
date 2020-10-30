import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;

  JLabel firstLabel;
  JLabel secondLabel;
  JLabel thirdLabel;

  JTextField firstInput;
  JTextField secondInput;
  JTextField thirdInput;

  JButton addButton;
  JButton subButton;
  JButton mulButton;
  JButton divButton;

  JTextArea outputArea;



  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
 
     //initialize the main JPanel
    mainPanel = new JPanel();
    //disable any layout helpers
    mainPanel.setLayout(null);

    //create the side labels
    firstLabel = new JLabel("First Number");
    secondLabel = new JLabel("Second Number");
    thirdLabel = new JLabel("Result");

     //layout the labels by setting the coordinate and size
    //setBounds(x,y,width,height)
    firstLabel.setBounds(175,175,100,20);
    secondLabel.setBounds(175,205,100,20);
    thirdLabel.setBounds(175,235,100,20);

    //initialize the input text fields
    firstInput = new JTextField();
    secondInput = new JTextField();
    thirdInput = new JTextField();

    //set the location and size
    firstInput.setBounds(300,175,100,20);
    secondInput.setBounds(300,205,100,20);
    thirdInput.setBounds(300,235,100,20); 

     //initialize the buttons
    addButton = new JButton("add");
    subButton = new JButton("sub");
    mulButton = new JButton("mul");
    divButton = new JButton("div");

     //set the size and location of the buttons
    addButton.setBounds(175,300,30,35);
    subButton.setBounds(205, 300, 30, 35);
    mulButton.setBounds(235,300,30,35);
    divButton.setBounds(265, 300, 30, 35);
  
    //add an action listener to the buttons
    addButton.addActionListener(this);
    subButton.addActionListener(this);
    mulButton.addActionListener(this);
    divButton.addActionListener(this);

    //set the action command on the button
    addButton.setActionCommand("add");
    subButton.setActionCommand("sub");
    mulButton.setActionCommand("mul");
    divButton.setActionCommand("div");
   //initialize the text Areas
   outputArea = new JTextArea();

   // add to main panel
   mainPanel.add(outputArea);

   //set size and locaiton of text Areas
   outputArea.setBounds(300,235,100,20);

    //add the buttons to the panel
    mainPanel.add(addButton);
    mainPanel.add(subButton);
    mainPanel.add(mulButton);
    mainPanel.add(divButton);

    //add the text fields to the panel
    mainPanel.add(firstInput);
    mainPanel.add(secondInput);
    mainPanel.add(thirdInput);
    
    //add the labels to the main pane;
    mainPanel.add(firstLabel);
    mainPanel.add(secondLabel);
    mainPanel.add(thirdLabel);

    // add the panel to the window
    frame.add(mainPanel);
  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    // get the text from each text boxes
    String firstLabel = firstInput.getText();
    String secondLabel = secondInput.getText();
    //change the String into an integer
    int firstNum = Integer.parseInt(firstLabel);
    int secondNum = Integer.parseInt(secondLabel);


     // output the answer to the user
    if(command.equals("add")){
      outputArea.setText("" + (firstNum + secondNum));
    }else 
    if(command.equals("sub")){
      outputArea.setText("" + (firstNum - secondNum));
    }else
    if(command.equals("mul")){
      outputArea.setText("" + (firstNum * secondNum));
    }else
    if(command.equals("div")){
      outputArea.setText("" + (firstNum / secondNum));
    }
  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}

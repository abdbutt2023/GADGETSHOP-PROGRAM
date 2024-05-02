import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.KeyEvent;

// main
public class GadgetShop extends JFrame implements ActionListener {
    //arraylist
    private ArrayList<Gadget> gadgets = new ArrayList<>();
    //fields for putting input
    private JTextField modelField,
    priceField, weightField,
    sizeField, creditField,
    memoryField, phoneNumberField,
    durationField,
    downloadSizeField,
    JTextFieldsearchterm,
    displayNumberField;
    //for displaying information        
    private JTextArea displayArea;

    public GadgetShop() {
        setTitle("Gadget Shop");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        
        // for menu bar
        JMenuBar menuBar = new JMenuBar();
        
        // for menu
        JMenu menu = new JMenu("Menu");
        menu.setMnemonic(KeyEvent.VK_F);
        
        //ITEM FOR ABOUT
        JMenuItem aboutMenuItem = new JMenuItem("About");
        aboutMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(GadgetShop.this,"Gadget shop Program\nVersion 0.4\nDEVELOPED BY ABDULLAH\nLondon Metropolitan University\n\nEmail:abd@abd.com"  ,"About",
                                JOptionPane.INFORMATION_MESSAGE);
                                
            }
        });
        // FOR MENU
        menu.add(aboutMenuItem);
        
        menuBar.add(menu);
        
        setJMenuBar(menuBar);

        JPanel inputPanel = new JPanel(new GridLayout(11, 9, 8, 6));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        // create  the pannel to take input for text fields and labels
        inputPanel.add(new JLabel("Model:(Phone or MP3"));
        modelField = new JTextField();
        inputPanel.add(modelField);

        inputPanel.add(new JLabel("Price (£):"));
        priceField = new JTextField();
        inputPanel.add(priceField);

        inputPanel.add(new JLabel("Weight (g):"));
        weightField = new JTextField();
        inputPanel.add(weightField);

        inputPanel.add(new JLabel("Size:"));
        sizeField = new JTextField();
        inputPanel.add(sizeField);

        inputPanel.add(new JLabel(" Credit (Phone):"));
        creditField = new JTextField();
        inputPanel.add(creditField);

        inputPanel.add(new JLabel(" Memory (MP3):"));
        memoryField = new JTextField();
        inputPanel.add(memoryField);

        inputPanel.add(new JLabel("Phone Number:"));
        phoneNumberField = new JTextField();
        inputPanel.add(phoneNumberField);

        inputPanel.add(new JLabel("Duration (minutes):"));
        durationField = new JTextField();
        inputPanel.add(durationField);

        inputPanel.add(new JLabel("Download Size (MB):"));
        downloadSizeField = new JTextField();
        inputPanel.add(downloadSizeField);

        inputPanel.add(new JLabel("Display Number:"));
        displayNumberField = new JTextField();
        inputPanel.add(displayNumberField);
        
        //grid layoyt and button panel

        JPanel buttonPanel = new JPanel(new GridLayout(5, 5, 6, 11));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(11, 6, 6, 6));
        // for adding buttons
        JButton addMobileButton = new JButton("Add Mobile");
        addMobileButton.addActionListener(this);
        buttonPanel.add(addMobileButton);

        JButton addMP3Button = new JButton("Add MP3");
        addMP3Button.addActionListener(this);
        buttonPanel.add(addMP3Button);

        JButton makeCallButton = new JButton("Make A Call");
        makeCallButton.addActionListener(this);
        buttonPanel.add(makeCallButton);

        JButton downloadMusicButton = new JButton("Download Music");
        downloadMusicButton.addActionListener(this);
        buttonPanel.add(downloadMusicButton);

        JButton displayAllButton = new JButton("Display All");
        displayAllButton.addActionListener(this);
        buttonPanel.add(displayAllButton);
        // for creating scroll for text
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        buttonPanel.add(clearButton);
        // dor creating scroll
        JScrollPane scrollPane = new JScrollPane();
        displayArea = new JTextArea(10, 30);
        scrollPane.setViewportView(displayArea);
        // for adding components
        add(inputPanel, BorderLayout.WEST);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.EAST);

        pack();
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    @Override
    // ACTION PERFORMED
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Add Mobile":
                addMobile();
                break;
            case "Add MP3":
                addMP3();
                break;
            case "Make A Call":
                makeCall();
                break;
            case "Download Music":
                downloadMusic();
                break;
            case "Display All":
                displayAll();
                break;
            case "Clear":
                clearFields();
                break;
        }
    }
    //ADD MOBILE metheod
    private void addMobile() {
        try {
            String model = modelField.getText();
            double price = Double.parseDouble(priceField.getText());
            int weight = Integer.parseInt(weightField.getText());
            String size = sizeField.getText();
            int credit = Integer.parseInt(creditField.getText());

            gadgets.add(new Mobile(model, price, weight, size, credit));
            displayArea.append("Mobile added: " + model + "\n");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input METHEOD.");
        }
    }
    //ADD MP3 metheod
    private void addMP3() {
        try {
            String model = modelField.getText();
            double price = Double.parseDouble(priceField.getText());
            int weight = Integer.parseInt(weightField.getText());
            String size = sizeField.getText();
            int memory = Integer.parseInt(memoryField.getText());

            gadgets.add(new MP3(model, price, weight, size, memory));
            displayArea.append("MP3 added: " + model + "\n");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Inavlid input.");
        }
    }
    //FOR MAKE CALL metheod
    private void makeCall() {
        int displayNumber = getDisplayNumber();
        if (displayNumber != -1) {
            String phoneNumber = phoneNumberField.getText();
            String durationStr = durationField.getText();
            if (!phoneNumber.isEmpty() && !durationStr.isEmpty()) {
                try {
                    int duration = Integer.parseInt(durationStr);
                    Gadget selectedGadget = gadgets.get(displayNumber);
                    
                    
                    if (selectedGadget instanceof Mobile) {
                        Mobile mobile = (Mobile) selectedGadget;
                        if (mobile.getCallingCredit() >= duration) {
                            mobile.makeCall(phoneNumber, duration);
                            displayArea.append("Call made for"+ duration + "minutes.\n");
                        } else {
                            JOptionPane.showMessageDialog(this, "CALLING CREDIT IS NOT ENOUGH TO MAKE A CALL.");//IF YOUR CALLING CREDIT IS NO ENOUGH
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Selected gadget is not a mobile phone.");//IF SOME WRONG INPUT IS PRESSED
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Duration must be an Number.");//IF SOME WRONG NUMBER IS INSERTED
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please enter Phone number and duration of call."); // SHOWING MESSGAE
            }
        }
    }
    
    
     // display all metheod
    private void displayAll() {
        displayArea.setText("");
        for (Gadget gadget : gadgets) {
            displayArea.append(gadget.toString() + "\n");
            displayArea.append(gadget.toString() +"\n");
        }
    }
    //for download music metheod
    private void downloadMusic() {
        int displayNumber = getDisplayNumber();
        if (displayNumber != -1) {
            String downloadSizeStr = downloadSizeField.getText();
            if (!downloadSizeStr.isEmpty()) {
                try {
                    int downloadSize = Integer.parseInt(downloadSizeStr);
                    Gadget selectedGadget = gadgets.get(displayNumber);
                    
                    System.out.println("Selected gadget class:"+selectedGadget.getClass().getName());
                    if (selectedGadget instanceof MP3) {
                        ((MP3) selectedGadget).downloadMusic(downloadSize);
                        displayArea.append("Music downloaded.\n");
                    } else {
                        JOptionPane.showMessageDialog(this, "Selected gadget is not an MP3 player.");// for showing message
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Download size must be an Number.");// its must be a number
                }
            } else {
                JOptionPane.showMessageDialog(this, "Enter download size please.");// for entering download size
            }
        }
    }
     // metheod for clearing everything
    private void clearFields() {
        modelField.setText("");
        priceField.setText("");
        weightField.setText("");
        sizeField.setText("");
        creditField.setText("");
        memoryField.setText("");
        phoneNumberField.setText("");
        durationField.setText("");
        downloadSizeField.setText("");
        displayNumberField.setText("");
        displayArea.setText("");
    }
    
   private void allGadgets(){
       
   }


   private int getDisplayNumber() {
        int displayNumber;
        try {
            displayNumber = Integer.parseInt(displayNumberField.getText());
            if (displayNumber < 0 || displayNumber >= gadgets.size()) {
                JOptionPane.showMessageDialog(this, "Display Number is not valid. PLEASE ENTER A VALID NUMBER.");// if display number is not valid
                return -1;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "A NON NEGATIVE NUMBER MUST ME DISPLAY NUMBER.");//a messgae will appear
            return -1;
        }
        return displayNumber;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GadgetShop::new);
    }
}

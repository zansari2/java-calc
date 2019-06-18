import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Creates a GUI that impliments the calculator
 */
public class GUI extends JFrame
{
    // Variables
    /**
     * Calculator 
     */
    Calculator calc = new Calculator();
    /**
     * An experimental grid layout for testing
     */
    private GridLayout experimentLayout = new GridLayout(2,2);
    // Constructors
    /**
     * Creates a GUI with a specified name that isn't resizable
     */
    public GUI(String name) {
        super(name);
        setResizable(false);
    }
    /**
     * The font options for the application
     */
    private static Font font = new Font("Verdana", Font.BOLD, 20);
    // Methods
    /**
     * Adds a pane to the frame
     * @param pane the pane being added to the frame
     */
    public void addComponentsToPane(final Container pane) 
    {
        // Create and configure a panel to append items to
        final JPanel expPanel1 = new JPanel();
        expPanel1.setLayout(experimentLayout);

        // Create menu bar and items
        JMenuBar mb = new JMenuBar();
        JMenu file = new JMenu("File");
        mb.add(file);
        JMenuItem close = new JMenuItem("Close");
        file.add(close);
        close.addActionListener(e -> System.exit(0));

        // Create buttons to add to the panel
        JButton add = new JButton("+");
        JButton sub = new JButton("-");
        JButton mult = new JButton("x");
        JButton div = new JButton("/");
        add.setFont(font);
        sub.setFont(font);
        mult.setFont(font);
        div.setFont(font);

        // Add buttons to the panel
        expPanel1.add(add);
        expPanel1.add(sub);
        expPanel1.add(mult);
        expPanel1.add(div);
        
        // Setup the second panel
        final JPanel expPanel2 = new JPanel();
        expPanel2.setLayout(new GridLayout(2,3));
    
        // Create and configure text fields
        JTextField text1 = new JTextField("0.0");
        JTextField text2 = new JTextField("0.0");
        JTextField text3 = new JTextField("0.0");
        text1.setHorizontalAlignment(JTextField.CENTER);
        text2.setHorizontalAlignment(JTextField.CENTER);
        text3.setHorizontalAlignment(JTextField.CENTER);
        text1.setFont(font);
        text2.setFont(font);
        text3.setFont(font);
        text3.setEditable(false);
        
        // Add display segments to the panel
        JLabel label1 = new JLabel("  Input A  ");
        JLabel label2 = new JLabel("  Input B  ");
        JLabel label3 = new JLabel("  Output C  ");
        label1.setHorizontalAlignment(JTextField.CENTER);
        label2.setHorizontalAlignment(JTextField.CENTER);
        label3.setHorizontalAlignment(JTextField.CENTER);
        label1.setFont(font);
        label2.setFont(font);
        label3.setFont(font);
        expPanel2.add(label1);
        expPanel2.add(label2);
        expPanel2.add(label3);
        expPanel2.add(text1);
        expPanel2.add(text2);
        expPanel2.add(text3);

        // Setup button functionality
        add.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(!text1.getText().isEmpty()&&!text2.getText().isEmpty())
                {
                    calc.setVar1(Double.parseDouble(text1.getText()));
                    calc.setVar2(Double.parseDouble(text2.getText()));
                    text3.setText(Double.toString(calc.sum()));
                }
            }
        });
        sub.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(!text1.getText().isEmpty()&&!text2.getText().isEmpty())
                {
                    calc.setVar1(Double.parseDouble(text1.getText()));
                    calc.setVar2(Double.parseDouble(text2.getText()));
                    text3.setText(Double.toString(calc.diff()));
                }
            }
        });
        mult.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(!text1.getText().isEmpty()&&!text2.getText().isEmpty())
                {
                    calc.setVar1(Double.parseDouble(text1.getText()));
                    calc.setVar2(Double.parseDouble(text2.getText()));
                    text3.setText(Double.toString(calc.prod()));
                }
            }
        });
        div.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(!text1.getText().isEmpty()&&!text2.getText().isEmpty())
                {
                    calc.setVar1(Double.parseDouble(text1.getText()));
                    calc.setVar2(Double.parseDouble(text2.getText()));
                    text3.setText(Double.toString(calc.quot()));
                }
            }
        });

        //Add panel to pane
        pane.add(expPanel2, BorderLayout.CENTER);
        pane.add(expPanel1, BorderLayout.SOUTH);
        pane.add(mb, BorderLayout.NORTH);
    }
    /**
     * Create the GUI and show it.  For thread safety,
     * this method is invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() 
    {
        // Create and set up the window.
        GUI frame = new GUI("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("..\\bin\\icon.png");
        frame.setIconImage(icon.getImage());

        // Set up the content pane.
        frame.addComponentsToPane(frame.getContentPane());

        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    // Main
    public static void main(String[] args) 
    {
        try 
        {
            // Set cross-platform Java L&F (also called "Metal")
            UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
        } 
        catch (UnsupportedLookAndFeelException e) 
        {
            // handle exception
        }
        catch (ClassNotFoundException e) {
            // handle exception
        }
        catch (InstantiationException e) {
            // handle exception
        }
        catch (IllegalAccessException e) {
            // handle exception
        }
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
                createAndShowGUI();
            }
        });
    }
}
   
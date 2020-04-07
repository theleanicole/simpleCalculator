
/**
 * Lea McLemore
 * Calculator Java GUI project
 * 
 */
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

/**
 A simplified calculator. 
 The only operations are addition and subtraction.
*/
public class Calculator extends JFrame 
                        implements ActionListener
{
    public static final int WIDTH = 400;
    public static final int HEIGHT = 200;
    public static final int NUMBER_OF_DIGITS = 30;

    private JTextField fahrenheitTemp; 
    private JTextField celsiusTemp;
    private JTextField operator;
    private JTextField answer;
    private JLabel fahrenheit;
    private JLabel op;
    private JLabel celsius;
    private JLabel ans;
    private double result = 0.00;

    public static void main(String[] args)
    {
        Calculator aCalculator = new Calculator( );
        aCalculator.setSize(1000,150);
        aCalculator.setVisible(true);
                
    }

    public Calculator( )
    {
        setTitle("Simplified Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLayout(new BorderLayout( ));
        
        //Fahrenheit textbox
        JPanel textPanel = new JPanel( );
        fahrenheit = new JLabel("1st Number/Fahrenheit");
        textPanel.add(fahrenheit);
        textPanel.setLayout(new FlowLayout( ));
        fahrenheitTemp = new JTextField("", 10);
        fahrenheitTemp.setBackground(Color.WHITE);
        textPanel.add(fahrenheitTemp);
              
        //Operator textbox
        op = new JLabel("Operator");
        textPanel.add(op);
        operator = new JTextField("", 3);
        operator.setBackground(Color.GRAY);
        operator.setEnabled(false);
        textPanel.add(operator);    
        
               
        //Celsius textbox
        celsius = new JLabel("2nd Number/Celsius");
        textPanel.add(celsius);
        celsiusTemp = new JTextField("", 10);
        celsiusTemp.setBackground(Color.WHITE);
        textPanel.add(celsiusTemp); 
        
        //Answer textbox
        ans = new JLabel("Result");
        textPanel.add(ans);
        answer = new JTextField("", 10);
        answer.setBackground(Color.GRAY);
        answer.setEnabled(false);
        textPanel.add(answer);          
        add(textPanel, BorderLayout.NORTH);
        
        
        
        
        
        //Set background
        JPanel buttonPanel = new JPanel( );
        buttonPanel.setBackground(Color.PINK);
        buttonPanel.setLayout(new FlowLayout( )); 
        
        //Add
        JButton addButton = new JButton("+"); 
        addButton.addActionListener(this);
        buttonPanel.add(addButton); 
        
        //Subtract
        JButton subtractButton = new JButton("-"); 
        subtractButton.addActionListener(this);
        buttonPanel.add(subtractButton); 
        
        //Fahrenheit
        JButton fahrenheitButton = new JButton("Fahrenheit"); 
        fahrenheitButton.addActionListener(this);
        buttonPanel.add(fahrenheitButton);
        
        //Celsius
        JButton celsiusButton = new JButton("Celsius"); 
        celsiusButton.addActionListener(this);
        buttonPanel.add(celsiusButton);
               
        //Reset
        JButton resetButton = new JButton("Reset"); 
        resetButton.addActionListener(this);
        buttonPanel.add(resetButton);
        
        


       add(buttonPanel, BorderLayout.CENTER);
    }


    public void actionPerformed(ActionEvent e)
    {
        try
        {
            assumingCorrectNumberFormats(e);
        }
        catch (NumberFormatException e2)
        {
            fahrenheitTemp.setText("Error: Reenter Number.");
        }
    }


    //Throws NumberFormatException.
    public void assumingCorrectNumberFormats(ActionEvent e)
    {
        String actionCommand = e.getActionCommand( );

        if (actionCommand.equals("+"))
        {
            result = stringToDouble(celsiusTemp.getText( )) + stringToDouble(fahrenheitTemp.getText( ));
            answer.setText(Double.toString(result));
            operator.setText("+");
        }
        else if (actionCommand.equals("-"))
        {
            result = stringToDouble(celsiusTemp.getText( )) - stringToDouble(fahrenheitTemp.getText( ));
            answer.setText(Double.toString(result));
            operator.setText("-");
        }
        else if (actionCommand.equals("Celsius"))
        {
            result = (stringToDouble(fahrenheitTemp.getText( )) - 32) *5/9;
            celsiusTemp.setText(Double.toString(result));
        }
        else if (actionCommand.equals("Fahrenheit"))
        {
            result = (stringToDouble(celsiusTemp.getText( )) *9/5) + 32;
            fahrenheitTemp.setText(Double.toString(result));
        }
        else if (actionCommand.equals("Reset"))
        {
            result = 0.0;
            fahrenheitTemp.setText("0.0");
            celsiusTemp.setText("0.0");
            answer.setText("");
            operator.setText("");
        }
        else
            answer.setText("Unexpected error.");
     }


    //Throws NumberFormatException.
    private static double stringToDouble(String stringObject)
    {
        return Double.parseDouble(stringObject.trim( ));
    }
}

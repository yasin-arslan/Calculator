import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator extends JFrame implements ActionListener {
    /*
    * @For storing operators and operands!
    * */
    String s0,s1,s2;
    static JFrame jFrame;
    static JTextField textField;
    public static void main(String[] args) {
        jFrame = new JFrame();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        Calculator calculator = new Calculator();
        calculator.s0 = calculator.s1 = calculator.s2 = "";
        jFrame.setTitle("Calculator");
        jFrame.setResizable(false);
        textField = new JTextField(16);
        JPanel panel = new JPanel();
        panel.add(textField);
        /*
        * @For loop used here for creation of number buttons.
        * */
        for(int i=0;i<=9;i++){
            JButton jButton = new JButton(String.valueOf(i));
            CalculatorUtility.addToPanel(jButton,panel,calculator);
        }
        List<JButton> operatorList = new ArrayList<>(Arrays.asList(new JButton(".")
                ,new JButton("=")
                ,new JButton("+")
                ,new JButton("-")
                ,new JButton("/")
                ,new JButton("*")
                ,new JButton("C")));
        CalculatorUtility.addOperators(operatorList,panel,calculator);
        panel.setBackground(Color.DARK_GRAY);
        jFrame.add(panel);
        jFrame.setSize(225,225);
        jFrame.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        switch (action.charAt(0)) {
            case 'C' -> {
                s0 = s1 = s2 = "";
                textField.setText(s0 + s1 + s2);
            }
            case '=' -> {
                double total = CalculatorUtility.evaluate(s1, s0, s2);
                textField.setText(Double.toString(total));
                s1 = s2 = "";
            }
            case '.', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> {
                if (!s1.equals("")) {
                    s2 = s2 + action;
                } else {
                    s0 = s0 + action;
                }
                textField.setText(s0 + s1 + s2);
            }
            default -> {
                if (s1.equals("") || s2.equals("")) {
                    s1 = action;
                } else {
                    double tot = CalculatorUtility.evaluate(s1, s0, s2);
                    s0 = Double.toString(tot);
                    s1 = action;
                    s2 = "";
                }
                textField.setText(s0 + s1 + s2);
            }
        }

    }
}

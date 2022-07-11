import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;

public class CalculatorUtility {
    public static void addOperators(List<JButton> operatorList,JPanel jPanel,ActionListener actionListener){
        operatorList.forEach(operator ->{
            jPanel.add(operator);
            operator.addActionListener(actionListener);
        });
    }
    public static void addToPanel(JButton jButton,JPanel jPanel, ActionListener actionListener){
        jButton.addActionListener(actionListener);
        jPanel.add(jButton);
    }
    public static double evaluate(String operator,String firstText,String secondText){
        double total;
        if(firstText.isEmpty() || secondText.isEmpty()){
            return 0f;
        }
        switch(operator.charAt(0)){
            case '+':
                total = (Double.parseDouble(firstText) + Double.parseDouble(secondText));
                return total;
            case '-':
                total = (Double.parseDouble(firstText) - Double.parseDouble(secondText));
                return total;
            case '/':
                total = (Double.parseDouble(firstText) / Double.parseDouble(secondText));
                return total;
            case '*':
                total = (Double.parseDouble(firstText) * Double.parseDouble(secondText));
                return total;
            default:
                return 0f;
        }
    }
}

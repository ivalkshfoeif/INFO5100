import javax.swing.*;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class JavaApp extends JFrame{

    private JTextField totalAssignmentPoints;

    private JTextField earnedPoints;

    private JTextField percentageOfClass;

    private JButton jButton;

    private JTextField weightedScore;

    JavaApp()
    {
        setBackground(Color.white);
        setTitle("lab6");
        setLayout(new GridLayout(3,1,10,5));
        setJPanelOne();
        setButton();
        setJPanelTwo();
        setSize(700,350);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    // set the input panel
    private void setJPanelOne()
    {
        JPanel jp = new JPanel(new GridLayout(4,2,10,5));
        jp.setSize(200, 200);
        jp.setBorder(BorderFactory.createTitledBorder("Input"));
        totalAssignmentPoints = new JTextField(16);
        JLabel label1 = new JLabel("Total Assignment Points");
        label1.setForeground(Color.blue);
        JLabel label2 = new JLabel("Earned Points");
        label2.setForeground(Color.blue);
        label1.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        label2.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        jp.add(label1);
        jp.add(label2);
        totalAssignmentPoints.setForeground(Color.blue);
        jp.add(totalAssignmentPoints);
        earnedPoints = new JTextField(16);
        earnedPoints.setForeground(Color.blue);

        jp.add(earnedPoints);
        JLabel label3 = new JLabel("Percentage of class");
        label3.setForeground(Color.blue);
        label3.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        jp.add(label3);
        JLabel dummy = new JLabel(" ");
        jp.add(dummy);
        percentageOfClass = new JTextField();
        percentageOfClass.setForeground(Color.blue);
        jp.add(percentageOfClass);

        add(jp);
    }
    // set the button panel
    private void setButton(){
        JPanel jp = new JPanel();
        jp.setBorder(BorderFactory.createTitledBorder("Button"));
        jButton = new JButton("Click to calculate Score");
        jButton.setBackground(Color.red);
        jButton.setOpaque(true);
        jButton.setHorizontalAlignment(SwingConstants.CENTER);
        jButton.setPreferredSize(new Dimension(200, 30));
        jButton.setBorderPainted(false);
        jButton.setForeground(Color.blue);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });

        jp.add(jButton);
        add(jp);
    }
    // set the output panel
    private void setJPanelTwo()
    {
        JPanel jp = new JPanel();
        jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
        jp.setBorder(BorderFactory.createTitledBorder("Output"));
        JLabel label4 = new JLabel("Weighted Score");
        label4.setForeground(Color.blue);
        jp.add(label4);
        weightedScore = new JTextField(16);
        weightedScore.setForeground(Color.blue);
        jp.add(weightedScore);
        add(jp);
    }
    // calculate the result
    private void calculate(){
        String tap = totalAssignmentPoints.getText();
        String ep = earnedPoints.getText();
        String poa = percentageOfClass.getText();

        boolean v1 = false, v2 = false, v3 = false;
        if (tap.length() != 0 && isPositiveNumeric(tap)){
            v1 = true;
        }
        if (ep.length() != 0 && isPositiveNumeric(ep)){
            v2 = true;
        }
        if (poa.length() != 0 && isPositiveNumeric(poa)){
            v3 = true;
        }

        if (! (v1 && v2 && v3)){
            weightedScore.setText("N/A");
        }else {
            weightedScore.setText((int) (Double.parseDouble(ep) / Double.parseDouble(tap) * Double.parseDouble(poa)) + "");
        }
    }
    // check input is positive and numeric
    private boolean isPositiveNumeric(String s){
        try {
            if (Double.parseDouble(s) < 0) return false;
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public static void main(String[] args) {
        JavaApp fr = new JavaApp();
    }

}
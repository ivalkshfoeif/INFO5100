package lab7;

import javax.swing.*;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.*;
import java.util.List;


class JavaApp extends JFrame{


    private List<String> fileCache;

    JavaApp()
    {
        fileCache = new ArrayList<>();
        setBackground(Color.white);
        setTitle("lab7");
        setLayout(new GridLayout(1,2,10,5));
        setJPanelOne();
        //setButton();
        setJPanelTwo();
        setSize(700,350);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    // set the left half part
    private void setJPanelOne()
    {
        JPanel jp = new JPanel(new GridLayout(2,1,10,5));
        jp.setSize(100, 200);
        jp.setBorder(BorderFactory.createTitledBorder("Input"));
        JPanel sec1 = setChildJp(jp);
        JLabel jLabel1 = new JLabel("Reading File Name");
        JTextField jTextField1 = new JTextField("Annual.csv");
        JButton jButton1 = new JButton("Click to read from file");
        sec1.add(jLabel1);
        sec1.add(jTextField1);
        sec1.add(jButton1);
        JPanel sec2 =  setChildJp(jp);
        JLabel jLabel2 = new JLabel("First five lines of file");
        sec2.add(jLabel2);
        JTextArea jTextArea1 = new JTextArea();
        jTextArea1.setLineWrap(true);
        jTextArea1.setBounds(40,75,250,200);
        sec2.add(jTextArea1);
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                writeFirstArea(jTextField1, jTextArea1);
            }
        });
        add(jp);
    }
    // create and attach a child jPanel to a parent jPanel
    private JPanel setChildJp(JPanel parent){
        JPanel jp = new JPanel();
        jp.setSize(100, 100);
        //jp.setBorder(BorderFactory.createTitledBorder("I233t"));
        parent.add(jp);
        return jp;
    }
    // set the right half part
    private void setJPanelTwo()
    {
        JPanel jp = new JPanel();
        jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
        jp.setBorder(BorderFactory.createTitledBorder("Output"));
        JPanel sec1 = setChildJp(jp);
        JLabel jLabel1 = new JLabel("File Name to write");
        JTextField jTextField1 = new JTextField(16);
        JButton jButton1 = new JButton("Click to write to file");
        sec1.add(jLabel1);
        sec1.add(jTextField1);
        sec1.add(jButton1);
        JPanel sec2 =  setChildJp(jp);
        JLabel jLabel2 = new JLabel("First five lines of new file");
        sec2.add(jLabel2);
        JTextArea jTextArea1 = new JTextArea();
        jTextArea1.setLineWrap(true);
        jTextArea1.setBounds(40,75,250,200);
        sec2.add(jTextArea1);
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                writeSecondArea(jTextField1, jTextArea1);
            }
        });
        add(jp);
    }
    // action lister method for read button
    private void writeFirstArea(JTextField jTextField1, JTextArea jTextArea1){
        String filename = "src/lab7/" + jTextField1.getText();
        fileCache = FileUtils.readFile(filename);
        int len = Math.min(fileCache.size(), 5);
        String output = "";
        for (int i = 0; i < len; i++){
            output += fileCache.get(i) + "\n";
        }
        if (fileCache.size() > 5){
            output += "...";
        }
        jTextArea1.setText(output);
    }
    // action lister method for write button
    private void writeSecondArea(JTextField jTextField1, JTextArea jTextArea1){
        String filename = "src/lab7/" + jTextField1.getText();
        FileUtils.createFile(filename);
        FileUtils.writeFile(fileCache, filename);
        int len = Math.min(fileCache.size(), 5);
        String output = "";
        for (int i = 0; i < len; i++){
            output += fileCache.get(i) + "\n";
        }
        if (fileCache.size() > 5){
            output += "...";
        }
        jTextArea1.setText(output);
    }


    public static void main(String[] args) {
        JavaApp fr = new JavaApp();
    }

}
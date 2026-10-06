package com.mycompany.cresendotexteditortest;
import javax.swing.*;
import java.awt.*;
/**
 * Author: Sophie, Anton, Franklin, John
 * Last Edited: 10/5/26
 */
public class CresendoTextEditorTest {

    public static void main(String[] args) {
        /*Makes sure all Ui code runs on Swing's event thread. Prevents threading bugs :D */
        SwingUtilities.invokeLater(CresendoTextEditorTest::createAndShowGui);
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("Text Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /* Can change later */
        frame.setSize(900, 700);
        frame.setLocationRelativeTo(null);
        
        JTextArea textPlace = new JTextArea();
        textPlace.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        textPlace.setLineWrap(true);
        /* makes it so it wraps after words not mid word cause thats horrid */
        textPlace.setWrapStyleWord(true);
        textPlace.setMargin(new Insets(8, 8, 8, 8));
        
        JScrollPane scroll = new JScrollPane(textPlace);
        scroll.setBorder(BorderFactory.createEmptyBorder());
        
        JPanel background = new JPanel(new BorderLayout());
        background.setBackground(new Color(10,54,30));
        background.setBorder(BorderFactory.createEmptyBorder(20,25,20,25));
        background.add(scroll, BorderLayout.CENTER);
        frame.setContentPane(background);
        frame.setVisible(true);
        textPlace.requestFocusInWindow();
        
        JPanel editorPanel = new JPanel(new BorderLayout());
        editorPanel.add(createTopBar(), BorderLayout.NORTH);
        editorPanel.add(scroll, BorderLayout.CENTER);

        background.add(editorPanel, BorderLayout.CENTER);
        frame.setContentPane(background);
        frame.setVisible(true);
        textPlace.requestFocusInWindow();
    }
    private static JButton makeJustAButton (String text) {
        JButton justAButton = new JButton(text);
        justAButton.setFont(new Font("Georgia", Font.BOLD, 18));
        justAButton.setBackground(Color.WHITE);
        justAButton.setOpaque(true);
        justAButton.setFocusPainted(false); /*Removes dotted focus box*/
        justAButton.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK), BorderFactory.createEmptyBorder(8, 20, 8, 20)));
        return justAButton;
    }
    
    private static JPanel createTopBar() {
        JPanel bar = new JPanel(new GridBagLayout());
        bar.setBackground(Color.WHITE);
        bar.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        /*Holds intructions of the positions of buttons */
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridy = 0;
        gbc.weighty = 1;


        gbc.weightx = 0;
        bar.add(makeJustAButton("File"), gbc);
        bar.add(makeJustAButton("Edit"), gbc);
        bar.add(makeJustAButton("Templates"), gbc);
        bar.add(makeJustAButton("Format"), gbc);


        JLabel templateLabel = new JLabel("12.0 Times New Roman Color", SwingConstants.CENTER);
        templateLabel.setFont(new Font("Georgia", Font.BOLD, 16));
        gbc.weightx = 1;
        bar.add(templateLabel, gbc);


        gbc.weightx = 0;
        bar.add(makeJustAButton("Pomodoro"), gbc);
        bar.add(makeJustAButton("Music"), gbc);

        return bar;
        
        /* Buttons have NOTHING in them. */
    }
}

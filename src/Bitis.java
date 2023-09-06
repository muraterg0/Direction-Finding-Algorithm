import java.awt.EventQueue;

import javax.management.StringValueExp;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Bitis extends JFrame {

    private JPanel contentPane;
    private JFrame frmProblem;
    private JFrame frm;
    String[] txt=new String[200];
    private JTextField txtUrl;

    /**
     * Launch the application.
     */


    /**
     * Create the frame.
     */
    public Bitis(int sure,int kareSayisi) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Sonuç");
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        JPanel panel = new JPanel();
        panel.setBackground(new Color(192, 192, 192));
        panel.setBounds(0, 0, 434, 261);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Robot başarıyla bitişe ulaşmıştır.\r\n");
        lblNewLabel.setBackground(new Color(0, 64, 128));
        lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 27));
        lblNewLabel.setBounds(20, 11, 383, 61);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Süre(Saniye):");
        lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
        lblNewLabel_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_1.setBounds(30, 83, 111, 49);
        panel.add(lblNewLabel_1);

        JLabel SureLabel = new JLabel(String.valueOf(sure));
        SureLabel.setForeground(new Color(255, 0, 0));
        SureLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
        SureLabel.setBounds(140, 83, 74, 49);
        panel.add(SureLabel);

        JLabel lblNewLabel_3 = new JLabel("Geçilen kare sayısı:");
        lblNewLabel_3.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
        lblNewLabel_3.setForeground(new Color(0, 0, 0));
        lblNewLabel_3.setBounds(30, 116, 158, 29);
        panel.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel(kareSayisi + "\r\n");
        lblNewLabel_4.setForeground(Color.BLUE);
        lblNewLabel_4.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
        lblNewLabel_4.setBounds(187, 112, 36, 35);
        panel.add(lblNewLabel_4);



        JButton devamButonu = new JButton("YENI OYUN");
        devamButonu.setForeground(Color.BLACK);
        devamButonu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    SwDosyaOkuma sw = new SwDosyaOkuma();
                    sw.frmProblem.setVisible(true);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        devamButonu.setFont(new Font("Tw Cen MT", Font.BOLD, 22));
        devamButonu.setBackground(Color.WHITE);
        devamButonu.setBounds(122, 171, 200, 61);
        panel.add(devamButonu);

        JLabel lblNewLabel_2 = new JLabel("Yeni harita ile oyuna başlamak için butona basınız.");
        lblNewLabel_2.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
        lblNewLabel_2.setForeground(new Color(0, 0, 0));
        lblNewLabel_2.setBounds(20, 44, 383, 61);
        panel.add(lblNewLabel_2);
    }

}

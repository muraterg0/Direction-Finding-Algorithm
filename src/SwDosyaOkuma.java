
import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.CardLayout;

import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class SwDosyaOkuma extends JFrame {

    public JFrame frmProblem;
    String[] txt=new String[200];
    private JTextField txtUrl;

    /**
     * Launch the application.
     */
    public static void main(String[] args)   {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SwDosyaOkuma window = new SwDosyaOkuma();
                    window.frmProblem.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    /**
     * Create the application.
     */
    public SwDosyaOkuma() throws IOException {
        frmProblem = new JFrame();
        frmProblem.getContentPane().setForeground(new Color(255, 255, 255));
        frmProblem.setTitle("Problem1");
        frmProblem.setBounds(100, 100, 600, 450);
        frmProblem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btnNewButton = new JButton("DEVAM");
        btnNewButton.setFont(new Font("Tw Cen MT", Font.BOLD, 23));
        btnNewButton.setForeground(Color.BLACK);
        btnNewButton.setBackground(Color.WHITE);
        btnNewButton.setBounds(184, 119, 212, 58);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int j=0;
                    URL url = new URL(txtUrl.getText());
                    Scanner s = new Scanner(url.openConnection().getInputStream());
                    while (s.hasNextLine()) {
                        txt[j]=s.nextLine();
                        j++;
                    }
                } catch (MalformedURLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                SwSekil1 sekil=new SwSekil1(txt);
                frmProblem.setVisible(false);
                sekil.setVisible(true);



            }

        });
        frmProblem.getContentPane().setLayout(null);
        frmProblem.getContentPane().add(btnNewButton);

        txtUrl = new JTextField();
        txtUrl.setForeground(Color.BLACK);
        txtUrl.setFont(new Font("Tw Cen MT", Font.PLAIN, 17));
        txtUrl.setBounds(33, 68, 509, 40);
        txtUrl.setBackground(Color.WHITE);
        frmProblem.getContentPane().add(txtUrl);
        txtUrl.setColumns(10);

        JLabel lblNewLabel = new JLabel("LÜTFEN URL BAĞLANTISINI GİRİNİZ!!");
        lblNewLabel.setFont(new Font("Unispace", Font.PLAIN, 25));
        lblNewLabel.setBounds(44, 11, 498, 46);
        frmProblem.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("________________________________________________\r\n");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblNewLabel_1.setBounds(26, 165, 548, 58);
        frmProblem.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("VEYA AŞAĞIDAN DOSYA SEÇEBİLİRSİNİZ!");
        lblNewLabel_2.setFont(new Font("Unispace", Font.BOLD, 24));
        lblNewLabel_2.setForeground(new Color(0, 0, 0));
        lblNewLabel_2.setBounds(36, 230, 525, 40);
        frmProblem.getContentPane().add(lblNewLabel_2);

        JButton devam2 = new JButton("DOSYA SEÇ");
        devam2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String icerik=new String();
                JFileChooser fileChooser=new JFileChooser();
                int i=fileChooser.showOpenDialog(btnNewButton);
                if(i== JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    int j=0;
                    try(Scanner scanner=new Scanner(new BufferedReader(new FileReader(file)))){

                        while (scanner.hasNextLine()) {
                            icerik=scanner.nextLine();
                            txt[j]=icerik;
                            j++;
                        }

                    }catch (FileNotFoundException ex) {

                    }
                }
                SwSekil1 sekil=new SwSekil1(txt);
                frmProblem.setVisible(false);
                sekil.setVisible(true);
            }
        });
        devam2.setBackground(Color.WHITE);
        devam2.setFont(new Font("Tw Cen MT", Font.BOLD, 23));
        devam2.setForeground(new Color(0, 0, 0));
        devam2.setBounds(184, 293, 212, 58);
        frmProblem.getContentPane().add(devam2);
    }


    /**
     * Initialize the contents of the frame.
     */
    void initialize() throws IOException{
        frmProblem = new JFrame();
        frmProblem.getContentPane().setForeground(new Color(255, 255, 255));
        frmProblem.setTitle("Problem1");
        frmProblem.setBounds(100, 100, 600, 450);
        frmProblem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btnNewButton = new JButton("DEVAM");
        btnNewButton.setFont(new Font("Tw Cen MT", Font.BOLD, 23));
        btnNewButton.setForeground(Color.BLACK);
        btnNewButton.setBackground(Color.WHITE);
        btnNewButton.setBounds(183, 230, 212, 58);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int j=0;
                    URL url = new URL(txtUrl.getText());
                    Scanner s = new Scanner(url.openConnection().getInputStream());
                    while (s.hasNextLine()) {
                        txt[j]=s.nextLine();
                        j++;
                    }
                } catch (MalformedURLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                SwSekil1 sekil=new SwSekil1(txt);
                frmProblem.setVisible(false);
                sekil.setVisible(true);



            }

        });
        frmProblem.getContentPane().setLayout(null);
        frmProblem.getContentPane().add(btnNewButton);

        JButton devam2 = new JButton("DOSYA SEÇ");
        devam2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String icerik=new String();
                JFileChooser fileChooser=new JFileChooser();
                int i=fileChooser.showOpenDialog(btnNewButton);
                if(i== JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    int j=0;
                    try(Scanner scanner=new Scanner(new BufferedReader(new FileReader(file)))){

                        while (scanner.hasNextLine()) {
                            icerik=scanner.nextLine();
                            txt[j]=icerik;
                            j++;
                        }

                    }catch (FileNotFoundException ex) {

                    }
                }
                SwSekil1 sekil=new SwSekil1(txt);
                frmProblem.setVisible(false);
                sekil.setVisible(true);
            }
        });
        devam2.setBackground(Color.WHITE);
        devam2.setFont(new Font("Tw Cen MT", Font.BOLD, 23));
        devam2.setForeground(new Color(0, 0, 0));
        devam2.setBounds(184, 293, 212, 58);
        frmProblem.getContentPane().add(devam2);
        txtUrl = new JTextField();
        txtUrl.setForeground(Color.BLACK);
        txtUrl.setFont(new Font("Tw Cen MT", Font.PLAIN, 17));
        txtUrl.setBounds(33, 156, 509, 40);
        txtUrl.setBackground(Color.WHITE);
        frmProblem.getContentPane().add(txtUrl);
        txtUrl.setColumns(10);

        JLabel lblNewLabel = new JLabel("LÜTFEN URL BAĞLANTISINI GİRİNİZ!!");
        lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));
        lblNewLabel.setBounds(49, 97, 498, 46);
        frmProblem.getContentPane().add(lblNewLabel);

    }
}


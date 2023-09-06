import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SwBoyutGirdisi extends JFrame {

    private JPanel contentPane;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SwBoyutGirdisi frame = new SwBoyutGirdisi();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public SwBoyutGirdisi() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        textField = new JTextField();
        textField.setBounds(89, 108, 250, 35);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel = new JLabel("Labirentin Boyutunu Giriniz!!!");
        lblNewLabel.setFont(new Font("Montserrat ExtraBold", Font.PLAIN, 13));
        lblNewLabel.setBounds(89, 38, 250, 35);
        contentPane.add(lblNewLabel);

        JButton btnNewButton = new JButton("Devam");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String string=textField.getText();
                boolean kontrol=true;
                int boyut=1;
                try {
                    boyut=Integer.parseInt(string);
                } catch (NumberFormatException e2) {
                    kontrol=false;
                    JOptionPane.showMessageDialog(btnNewButton,"Lütfen Tam Sayı Giriniz!!!");
                }
                if(kontrol==true) {
                    SwFrame frame=new SwFrame(boyut);
                    frame.setVisible(true);
                }

            }
        });
        btnNewButton.setBounds(150, 168, 125, 42);
        contentPane.add(btnNewButton);
    }
}

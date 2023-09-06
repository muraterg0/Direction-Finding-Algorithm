import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AnaEkran {

    private JFrame frmProlabProjesi;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AnaEkran window = new AnaEkran();
                    window.frmProlabProjesi.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AnaEkran() {
        initialize();
    }

    private void initialize(){
        frmProlabProjesi = new JFrame();
        frmProlabProjesi.setTitle("ProLab Projesi");
        frmProlabProjesi.setBounds(100, 100, 450, 300);
        frmProlabProjesi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmProlabProjesi.getContentPane().setLayout(null);

        JButton btnNewButton = new JButton("Problem 1");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwDosyaOkuma SwDosyaOkuma= null;
                try {
                    SwDosyaOkuma = new SwDosyaOkuma();
                    SwDosyaOkuma.frmProblem.setVisible(true);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        btnNewButton.setBounds(100, 44, 236, 38);
        frmProlabProjesi.getContentPane().add(btnNewButton);

        JButton btnProblem = new JButton("Problem 2");
        btnProblem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwBoyutGirdisi SwBoyutGirdisi=new SwBoyutGirdisi();
                SwBoyutGirdisi.setVisible(true);
            }
        });
        btnProblem.setBounds(100, 138, 236, 38);
        frmProlabProjesi.getContentPane().add(btnProblem);
    }
}

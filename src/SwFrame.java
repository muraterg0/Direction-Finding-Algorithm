import javax.swing.*;
import java.awt.*;

public class SwFrame extends JFrame {

    public SwFrame(int boyut) {
        SwPanel panel=new SwPanel(boyut);
        this.add(panel);
        this.setTitle("Problem 2");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.repaint();
    }

}

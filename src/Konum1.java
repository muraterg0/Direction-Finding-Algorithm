import javax.swing.*;

public class Konum1 extends JButton {
    public String bilgi; // start veya finish seklinde
    boolean gorunurluk;
    boolean engel;
    boolean ustundenGecilmesi=false;
    int ID;

    public Konum1() {
        gorunurluk = false;
        engel = false;
        ustundenGecilmesi = false;
    }

    public Konum1(String bilgi) {
        this.bilgi = bilgi;
        gorunurluk = false;
        engel = false;
        ustundenGecilmesi = false;
    }


}

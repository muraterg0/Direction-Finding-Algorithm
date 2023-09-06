import java.util.LinkedList;

public class Konum {
    int x;
    int y;
    int xEkseniIndex;
    int yEkseniIndex;
    boolean gorunurluk;
    boolean engel;
    boolean ustundengecilmesi;
    int idnumarasi;


    LinkedList<Konum> komsuKonum=new LinkedList<Konum>();

    public Konum() {
        gorunurluk=false;
        engel=false;
        ustundengecilmesi=false;
    }
}

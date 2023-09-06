
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Random;


public class SwSekil1 extends JFrame  {

    int boyut;
    int bitisSuresi;
    int start=0;
    String[] txt;
    int timerDevam=0;
    Timer t;
    Robot1 robot = new Robot1();
    private final JPanel contentPane;
    final Date createdDate = new java.util.Date();

    /**
     * Create the frame.
     */
    public SwSekil1() {
        setTitle("Problem1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
    }

    public SwSekil1(String[] txt) {
        final int[] secmeSayac = {0,0};
        this.txt = txt;
        setTitle("Problem1");
        final int[] tut = new int[1];
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 800);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(52, 4, 136));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        boyut = txt[0].length();
        contentPane.setLayout(new GridLayout(boyut + 2, boyut + 2, 2, 2));
        setContentPane(contentPane);
        Konum1[] butonDizi = new Konum1[(boyut + 1) * 4];
        Konum1[] konumDizi = new Konum1[boyut  * boyut ];
        int butonSayac = 0;
        int konumSayac = 0;
        for (int i = 0; i < boyut + 2; i++) {

            if (i == 0 || i == boyut + 1) {
                for (int j = 0; j < boyut + 2; j++) {
                    butonDizi[butonSayac] = new Konum1();
                    butonDizi[butonSayac].setBackground(new Color(168, 168, 163, 255));
                    contentPane.add(butonDizi[butonSayac]);
                    butonSayac++;
                }
            } else {
                String str = txt[i - 1];
                char[] ch = new char[boyut];
                for (int j = 0; j < boyut; j++) {
                    ch[j] = str.charAt(j);
                }
                for (int j = 0; j < boyut + 2; j++) {
                    int sayacdeneme = 0;
                    String text;
                    butonDizi[butonSayac] = new Konum1();
                    //konumDizi[konumSayac] = new Konum1();
                    if (j == 0 || j == boyut + 1) {
                        butonDizi[butonSayac].setBackground(new Color(168, 168, 163, 255));
                        contentPane.add(butonDizi[butonSayac]);
                        butonSayac++;
                    } else {
                        konumDizi[konumSayac] = new Konum1();
                        robot.konum = new Konum1();
                        /*if(ch[j-1]=='1' || ch[j-1]=='2' || ch[j-1]=='3')
                            butonDizi[sayac].setBackground(new Color(0,0,0));*/
                        if (ch[j - 1] == '1') {
                            konumDizi[konumSayac].setBackground(new Color(0, 0, 0));
                            konumDizi[konumSayac].ustundenGecilmesi = false;
                            konumDizi[konumSayac].gorunurluk = false;
                            konumDizi[konumSayac].ID = konumSayac;
                            konumDizi[konumSayac].engel = true;
                        } else if (ch[j - 1] == '2') {
                            Random r = new Random();
                            int a = r.nextInt(4);
                            if (a != 1) {
                                konumDizi[konumSayac].setBackground(new Color(0, 0, 0));
                                konumDizi[konumSayac].ustundenGecilmesi = false;
                                konumDizi[konumSayac].gorunurluk = false;
                                konumDizi[konumSayac].ID = konumSayac;
                                konumDizi[konumSayac].engel = true;

                            } else {
                                konumDizi[konumSayac].setBackground(new Color(255, 255, 255));
                                konumDizi[konumSayac].ustundenGecilmesi = false;
                                konumDizi[konumSayac].gorunurluk = false;
                                konumDizi[konumSayac].ID = konumSayac;
                                konumDizi[konumSayac].engel = false;
                            }

                        } else if (ch[j - 1] == '3') {
                            Random r = new Random();
                            int a = r.nextInt(3);
                            if (a != 1) {
                                konumDizi[konumSayac].setBackground(new Color(0, 0, 0));
                                konumDizi[konumSayac].ustundenGecilmesi = false;
                                konumDizi[konumSayac].gorunurluk = false;
                                konumDizi[konumSayac].ID = konumSayac;
                                konumDizi[konumSayac].engel = true;
                            } else {
                                konumDizi[konumSayac].setBackground(new Color(255, 255, 255));
                                konumDizi[konumSayac].ustundenGecilmesi = false;
                                konumDizi[konumSayac].gorunurluk = false;
                                konumDizi[konumSayac].ID = konumSayac;
                                konumDizi[konumSayac].engel = false;
                            }
                        } else  {
                            int finalSayac = konumSayac;
                            konumDizi[konumSayac].setBackground(new Color(255, 255, 255));
                            konumDizi[konumSayac].ustundenGecilmesi = false;
                            konumDizi[konumSayac].gorunurluk = false;
                            konumDizi[konumSayac].ID = konumSayac;
                            konumDizi[konumSayac].engel = false;
                            konumDizi[konumSayac].addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    if (secmeSayac[0] == 0) {
                                        konumDizi[finalSayac].setBackground(new Color(53, 208, 18));
                                        konumDizi[finalSayac].bilgi = "start";
                                        robot.konum.ID=finalSayac;
                                        start=finalSayac;
                                        secmeSayac[0]++;
                                    } else if (secmeSayac[0] == 1) {
                                        konumDizi[finalSayac].setBackground(new Color(208, 18, 18));
                                        konumDizi[finalSayac].bilgi = "finish";
                                        secmeSayac[0]++;
                                        tut[0] =finalSayac;
                                        for (int k = 0; k < konumDizi.length; k++) {
                                            if(k!=tut[0] && k!=robot.konum.ID)
                                                konumDizi[k].setBackground(new Color(92, 96, 87));
                                        }
                                        JOptionPane.showMessageDialog(null,"ROBOTU HAREKET ETTİRMEK İÇİN\n \"B\" TUŞUNA BASINIZ!");
                                        konumDizi[finalSayac].addKeyListener(new KeyListener() {
                                            @Override
                                            public void keyTyped(KeyEvent e) {
                                                switch (e.getKeyChar()) {
                                                    case 'b': {
                                                        t = new Timer(50, new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                int onceki = robot.konum.ID;
                                                                konumDizi[onceki].setText(" ");
                                                                LinkedList<Konum1> komsuListe = new LinkedList<Konum1>();
                                                                LinkedList<Konum1> komsuListe2 = new LinkedList<Konum1>();
                                                                // System.out.println("Robotun ilk konumu:" + robot.konum.ID);
                                                                if (robot.konum.ID == 0) {       //0
                                                                    komsuListe.add(konumDizi[robot.konum.ID + 1]);
                                                                    komsuListe.add(konumDizi[robot.konum.ID + boyut]);
                                                                } else if (robot.konum.ID == boyut - 1) {    //sol üst köşe
                                                                    komsuListe.add(konumDizi[robot.konum.ID - 1]);
                                                                    komsuListe.add(konumDizi[robot.konum.ID + boyut]);
                                                                } else if (robot.konum.ID == boyut * (boyut - 1)) {  // sol alt köşe
                                                                    komsuListe.add(konumDizi[robot.konum.ID + 1]);
                                                                    komsuListe.add(konumDizi[robot.konum.ID - boyut]);
                                                                } else if (robot.konum.ID == (boyut * boyut) - 1) {  //sağ alt köşe
                                                                    komsuListe.add(konumDizi[robot.konum.ID - 1]);
                                                                    komsuListe.add(konumDizi[robot.konum.ID - boyut]);
                                                                } else if (robot.konum.ID != 0 && robot.konum.ID != boyut * (boyut - 1) && robot.konum.ID % boyut == 0) { //sol taraf
                                                                    komsuListe.add(konumDizi[robot.konum.ID + 1]);
                                                                    komsuListe.add(konumDizi[robot.konum.ID - boyut]);
                                                                    komsuListe.add(konumDizi[robot.konum.ID + boyut]);
                                                                } else if (robot.konum.ID != 0 && robot.konum.ID != boyut - 1 && robot.konum.ID > 0 && robot.konum.ID < boyut - 1) { //üst taraf
                                                                    komsuListe.add(konumDizi[robot.konum.ID + 1]);
                                                                    komsuListe.add(konumDizi[robot.konum.ID + boyut]);
                                                                    komsuListe.add(konumDizi[robot.konum.ID - 1]);
                                                                } else if (robot.konum.ID != boyut - 1 && robot.konum.ID != (boyut * boyut) - 1 && (robot.konum.ID + 1) % boyut == 0) { // sağ taraf
                                                                    komsuListe.add(konumDizi[robot.konum.ID - boyut]);
                                                                    komsuListe.add(konumDizi[robot.konum.ID + boyut]);
                                                                    komsuListe.add(konumDizi[robot.konum.ID - 1]);
                                                                }                                                                                                                   // alt taraf
                                                                else if (robot.konum.ID != boyut * (boyut - 1) && robot.konum.ID != (boyut * boyut) - 1 && robot.konum.ID > boyut * (boyut - 1) && robot.konum.ID != (boyut * boyut) - 1) {
                                                                    komsuListe.add(konumDizi[robot.konum.ID - boyut]);
                                                                    komsuListe.add(konumDizi[robot.konum.ID + 1]);
                                                                    komsuListe.add(konumDizi[robot.konum.ID - 1]);
                                                                } else {
                                                                    komsuListe.add(konumDizi[robot.konum.ID - boyut]);
                                                                    komsuListe.add(konumDizi[robot.konum.ID + boyut]);
                                                                    komsuListe.add(konumDizi[robot.konum.ID - 1]);
                                                                    komsuListe.add(konumDizi[robot.konum.ID + 1]);
                                                                }

                                                                for (int i = 0; i < komsuListe.size(); i++) {
                                                                    if (!komsuListe.get(i).engel) {
                                                                        komsuListe2.add(komsuListe.get(i));
                                                                        if(komsuListe.get(i).ustundenGecilmesi==false && (komsuListe.get(i).ID!=start))
                                                                            komsuListe.get(i).setBackground(new Color(255,255,255));
                                                                    }
                                                                    else
                                                                    if(komsuListe.get(i).ID!=start)
                                                                        komsuListe.get(i).setBackground(new Color(0,0,0));
                                                                }

                                                                Random random = new Random();
                                                                int sayac = 0, sayac2 = 0;
                                                                LinkedList<Konum1> yerTut = new LinkedList<Konum1>();
                                                                for (int i = 0; i < komsuListe2.size(); i++) {
                                                                    if (!komsuListe2.get(i).ustundenGecilmesi) {
                                                                        sayac++;
                                                                        break;
                                                                    }
                                                                }
                                                                for (int i = 0; i < komsuListe2.size(); i++) {
                                                                    if (komsuListe2.get(i).ustundenGecilmesi == false) {
                                                                        yerTut.add(komsuListe2.get(i));
                                                                        sayac2++;
                                                                    }
                                                                }
                                                                for (int i = 0; i < komsuListe.size(); i++) {
                                                                    if(komsuListe.get(i).ID==tut[0]){
                                                                        Bitis bitis = new Bitis(bitisSuresi,robot.kareSayisi);
                                                                        bitis.setVisible(true);
                                                                        timerDevam++;
                                                                        timerKontrol(konumDizi,tut[0]);
                                                                        return;
                                                                    }
                                                                }
                                                                if (sayac > 0) {
                                                                    Random r = new Random();
                                                                    int num = r.nextInt(sayac2);
                                                                    switch (num) {
                                                                        case 0: {
                                                                            konumDizi[yerTut.get(0).ID].setBackground(new Color(18,186,208));
                                                                            konumDizi[yerTut.get(0).ID].ustundenGecilmesi = true;
                                                                            konumDizi[yerTut.get(0).ID].setBackground(new Color(18, 186, 208));
                                                                            robot.konum.ID = yerTut.get(0).ID;
                                                                            break;
                                                                        }
                                                                        case 1: {
                                                                            konumDizi[yerTut.get(1).ID].ustundenGecilmesi = true;
                                                                            konumDizi[yerTut.get(1).ID].setBackground(new Color(18,186,208));
                                                                            konumDizi[yerTut.get(1).ID].ustundenGecilmesi = true;
                                                                            robot.konum.ID = yerTut.get(1).ID;
                                                                            break;

                                                                        }
                                                                        case 2: {
                                                                            konumDizi[yerTut.get(2).ID].ustundenGecilmesi = true;
                                                                            konumDizi[yerTut.get(2).ID].setBackground(new Color(18,186,208));
                                                                            konumDizi[yerTut.get(2).ID].ustundenGecilmesi = true;
                                                                            robot.konum.ID = yerTut.get(2).ID;
                                                                            break;

                                                                        }
                                                                        case 3: {
                                                                            konumDizi[yerTut.get(3).ID].ustundenGecilmesi = true;
                                                                            konumDizi[yerTut.get(3).ID].setBackground(new Color(18,186,208));
                                                                            konumDizi[yerTut.get(3).ID].ustundenGecilmesi = true;
                                                                            robot.konum.ID = yerTut.get(3).ID;
                                                                            break;

                                                                        }
                                                                    }
                                                                }
                                                                else {
                                                                    int num = random.nextInt(komsuListe2.size());
                                                                    switch (num) {
                                                                        case 0: {
                                                                            konumDizi[komsuListe2.get(0).ID].setBackground(new Color(18, 186, 208));
                                                                            konumDizi[komsuListe2.get(0).ID].ustundenGecilmesi = true;
                                                                            robot.konum.ID = komsuListe2.get(0).ID;
                                                                            break;
                                                                        }
                                                                        case 1: {
                                                                            konumDizi[komsuListe2.get(1).ID].setBackground(new Color(18, 186, 208));
                                                                            konumDizi[komsuListe2.get(1).ID].ustundenGecilmesi = true;
                                                                            robot.konum.ID = komsuListe2.get(1).ID;
                                                                            break;
                                                                        }
                                                                        case 2: {
                                                                            konumDizi[komsuListe2.get(2).ID].setBackground(new Color(18, 186, 208));
                                                                            konumDizi[komsuListe2.get(2).ID].ustundenGecilmesi = true;
                                                                            robot.konum.ID = komsuListe2.get(2).ID;
                                                                            break;
                                                                        }
                                                                        case 3: {
                                                                            konumDizi[komsuListe2.get(3).ID].setBackground(new Color(18, 186, 208));
                                                                            konumDizi[komsuListe2.get(3).ID].ustundenGecilmesi = true;
                                                                            robot.konum.ID = komsuListe2.get(3).ID;
                                                                            break;
                                                                        }
                                                                    }

                                                                }
                                                                konumDizi[robot.konum.ID].setText("X");
                                                                konumDizi[start].setBackground(new Color(53, 208, 18));
                                                                robot.kareSayisi++;
                                                                setFont(new Font("Tw Cen MT", Font.BOLD, 10));
                                                                sureCalistir();
                                                                System.out.println("Robotun son konumu:" + robot.konum.ID);
                                                            }
                                                        });
                                                        t.start();
                                                        break;
                                                    }

                                                }
                                            }
                                            @Override
                                            public void keyPressed(KeyEvent e) {

                                            }

                                            @Override
                                            public void keyReleased(KeyEvent e) {
                                            }
                                        });
                                    }

                                }

                            });
                        }
                        contentPane.add(konumDizi[konumSayac]);
                        konumSayac++;
                    }

                }
            }
        }
    }
    public void timerKontrol(Konum1[] dizi, int ID) {
        if (timerDevam > 0) {
            t.stop();
            dizi[ID].setBackground(new Color(208,18,18));
            dizi[ID].setText("X");
            setFont(new Font("Tw Cen MT", Font.BOLD, 10));
        }
    }
    public void enKisaYol(Konum1[] konumDizi,int start, int stop){
        LinkedList<Konum1> gecilenYol = new LinkedList<>();
        for (int i = 0; i < konumDizi.length; i++) {
            if(konumDizi[i].ustundenGecilmesi)
                gecilenYol.add(konumDizi[i]);
        }
    }
    public void sure(){
        long startTime = (new Date()).getTime()-this.createdDate.getTime();
        long elapsedTime=0;
        int sure;

        elapsedTime = startTime/1000;
        bitisSuresi=(int)elapsedTime;
        sure=((int)30*(boyut/10)+(int)(boyut/4)*5+10);

    }
    public void sureCalistir(){
        sure();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SwSekil1 frame = new SwSekil1();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}


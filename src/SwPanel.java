import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class SwPanel extends JPanel implements ActionListener {
    Robot robot=new Robot();
    LinkedList<Konum> konumLL=new LinkedList<Konum>();
    LinkedList<Konum> konumLinkedList=new LinkedList<Konum>();
    LinkedList<Konum> adj[];

    boolean visited[];
    Konum oncekiKonum;
    int boyut;
    int baslangicCizgi=90*(boyut/15)+10;;
    int xEkseni;
    int yEkseni;
    boolean running=false;
    Timer timer;
    int bitisSuresi;
    final Date createdDate = new java.util.Date();

    int devamEtme=0;
    int devamEtme2=0;
    int devamEtme3=0;
    public SwPanel(int boyut){
        int tmp=boyut;
        if(tmp<15)
            tmp=15;
        this.setPreferredSize(new Dimension(tmp*40,tmp*30));
        this.setFocusable(true);
        this.boyut=boyut;
        setLayout(null);
        JButton devamButon = new JButton("Devam");
        devamButon.addActionListener(this);
        devamButon.setBounds(10, 10, (int)90*(tmp/15), (int)30*(tmp/10));
        baslangicCizgi=90*(tmp/15)+20;
        add(devamButon);
        for (int i = 0; i < boyut*boyut; i++) {
            Konum konum=new Konum();
            int sayi1;
            String aString;
            Random r = new Random();
            if (i%2==0) {
                sayi1=i*(r.nextInt(10-1) + 1);
                aString=String.valueOf(sayi1);
            }
            else {
                sayi1=i*(r.nextInt(20-11) + 11);
                aString=String.valueOf(sayi1);
            }
            if(boyut>25 || boyut<16) {
                if (aString.hashCode()%20<17) {
                    konum.engel=false;
                    konum.gorunurluk=false;
                    konum.ustundengecilmesi=false;
                    konum.idnumarasi=i;

                }
                else {
                    konum.engel=true;
                    konum.gorunurluk=false;
                    konum.ustundengecilmesi=false;
                    konum.idnumarasi=i;
                }
            }
            else {
                if (aString.hashCode()%20<16) {
                    konum.engel=false;
                    konum.gorunurluk=false;
                    konum.ustundengecilmesi=false;
                    konum.idnumarasi=i;
                }
                else {
                    konum.engel=true;
                    konum.gorunurluk=false;
                    konum.ustundengecilmesi=false;
                    konum.idnumarasi=i;
                }
            }
            if (i==0 || i==(boyut*boyut)-1) {
                konum.engel=false;
                konum.gorunurluk=true;
                konum.ustundengecilmesi=false;
                konum.idnumarasi=i;
            }
            if (i==(boyut*boyut)-1-boyut || i==(boyut*boyut)-2) {
                konum.engel=false;
                konum.gorunurluk=false;
                konum.ustundengecilmesi=false;
                konum.idnumarasi=i;
            }
            konumLinkedList.add(konum);
        }



    }


    public void actionPerformed(ActionEvent e) {
        if(devamEtme==0){
            running=true;
            timer=new Timer(1,this);
            timer.start();
        }
        else if (devamEtme==1) {
            timer.stop();
            running=false;
        }
        repaint();
    }


    public void deneme(Graphics g){
        Konum[][] konumMatrisi=new Konum[boyut][boyut];

        int sayac=0;
        for (int i = 0; i < boyut; i++) {
            for (int j = 0; j < boyut; j++) {
                konumMatrisi[i][j]=konumLL.get(sayac);
                sayac++;
            }
        }

        for (int i = 0; i < boyut; i++) {
            for (int j = 0; j < boyut; j++) {
                if(konumMatrisi[i][j].engel==true){
                    g.setColor(Color.black);
                    g.fillRect(konumMatrisi[i][j].x,konumMatrisi[i][j].y,25,25);
                }

            }
        }
        if(robot.konum.engel)
            robot.konum=oncekiKonum;
        xEkseni=robot.konum.xEkseniIndex;
        yEkseni=robot.konum.yEkseniIndex;
        for (int i = 0; i <konumMatrisi[yEkseni][xEkseni].komsuKonum.size(); i++) {
            konumMatrisi[yEkseni][xEkseni].komsuKonum.get(i).gorunurluk=true;
            konumLL.get(konumMatrisi[yEkseni][xEkseni].komsuKonum.get(i).idnumarasi).gorunurluk=true;
        }
        g.setColor(Color.BLUE);
        g.fillOval(konumMatrisi[yEkseni][xEkseni].x,konumMatrisi[yEkseni][xEkseni].y,25,25);
        g.setColor(Color.red);
        g.fillRect(konumMatrisi[boyut-1][boyut-1].x,konumMatrisi[boyut-1][boyut-1].y,25,25);
        Random r = new Random();
        int sayi1=0;
        boolean devam1=false;
        int gecmesayisi=0;
        devam1=false;
        while (devam1!=true){
            sayi1=r.nextInt(konumMatrisi[yEkseni][xEkseni].komsuKonum.size()) ;
            for (int i = 0; i < konumMatrisi[yEkseni][xEkseni].komsuKonum.size(); i++) {
                if (konumMatrisi[yEkseni][xEkseni].komsuKonum.get(i).ustundengecilmesi==true)
                    gecmesayisi++;
            }
            for (int i = 0; i < konumMatrisi[yEkseni][xEkseni].komsuKonum.size(); i++) {
                if (konumMatrisi[yEkseni][xEkseni].komsuKonum.get(i).xEkseniIndex==boyut-1
                && konumMatrisi[yEkseni][xEkseni].komsuKonum.get(i).yEkseniIndex==boyut-1){
                    sayi1=i;
                    devam1=true;
                    break;
                }
            }
            if(konumMatrisi[yEkseni][xEkseni].komsuKonum.get(sayi1).ustundengecilmesi==false
                    && konumMatrisi[yEkseni][xEkseni].komsuKonum.get(sayi1).engel==false){
                devam1=true;
                break;
            }
            if(gecmesayisi<konumMatrisi[yEkseni][xEkseni].komsuKonum.size()){
                boolean kontrol=false;
                for (int i = 0; i < konumMatrisi[yEkseni][xEkseni].komsuKonum.size(); i++) {
                    if(konumMatrisi[yEkseni][xEkseni].komsuKonum.get(i).ustundengecilmesi==false
                            && konumMatrisi[yEkseni][xEkseni].komsuKonum.get(i).engel==false)
                        kontrol=true;
                }
                if (kontrol){
                    while (konumMatrisi[yEkseni][xEkseni].komsuKonum.get(sayi1).engel!=false
                        && konumMatrisi[yEkseni][xEkseni].komsuKonum.get(sayi1).ustundengecilmesi!=false){
                        sayi1=r.nextInt(konumMatrisi[yEkseni][xEkseni].komsuKonum.size());
                    }
                    devam1=true;
                    break;
                }
                else{
                    while (konumMatrisi[yEkseni][xEkseni].komsuKonum.get(sayi1).engel!=false){
                        sayi1=r.nextInt(konumMatrisi[yEkseni][xEkseni].komsuKonum.size());
                    }
                    devam1=true;
                    break;
                }
            } else if (gecmesayisi==konumMatrisi[yEkseni][xEkseni].komsuKonum.size()) {
                while (konumMatrisi[yEkseni][xEkseni].komsuKonum.get(sayi1).engel!=false){
                    sayi1=r.nextInt(konumMatrisi[yEkseni][xEkseni].komsuKonum.size());
                }
                devam1=true;
            }
        }
        robot.konum.ustundengecilmesi=true;
        konumLL.get(robot.konum.idnumarasi).ustundengecilmesi=true;
        oncekiKonum=konumLL.get(robot.konum.idnumarasi);
        konumLL.get(konumMatrisi[yEkseni][xEkseni].komsuKonum.get(sayi1).idnumarasi).gorunurluk=true;
        robot.konum=konumMatrisi[yEkseni][xEkseni].komsuKonum.get(sayi1);

    }

    public void sure(Graphics g){
        long startTime = (new Date()).getTime()-this.createdDate.getTime();
        long elapsedTime=0;
        int sure;

        elapsedTime = startTime/1000;
        sure=(int)elapsedTime;
        g.setColor(Color.black);
        g.setFont(new Font("Montserrat ExtraBold", Font.BOLD, boyut-3));
        g.drawString("Süre: "+String.valueOf(sure),10,(int)30*(boyut/10)+(int)(boyut/4)*5+10);

        bitisSuresi=sure;
    }
    public void gecilenKareler(Graphics g){
        for (int i = 0; i < boyut*boyut; i++) {
            if(konumLL.get(i).ustundengecilmesi==true){
                g.setColor(Color.cyan);
                g.fillRect(konumLL.get(i).x,konumLL.get(i).y,25,25);
            }
        }
        for (int i = 0; i < boyut*boyut; i++) {
            if(konumLL.get(i).engel==true){
                g.setColor(Color.black);
                g.fillRect(konumLL.get(i).x,konumLL.get(i).y,25,25);
            }
        }
        for (int i = 0; i < boyut*boyut; i++) {
            if(konumLL.get(i).gorunurluk==false){
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(konumLL.get(i).x,konumLL.get(i).y,25,25);
            }
        }
        g.setColor(Color.BLUE);
        g.fillOval(robot.konum.x,robot.konum.y,25,25);

        if(robot.konum.xEkseniIndex==boyut-1 && robot.konum.yEkseniIndex==boyut-1){
            running=false;
            timer.stop();
            devamEtme=1;
        }
    }





    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawLine(baslangicCizgi,0,baslangicCizgi,boyut*30);
        if(running==false && devamEtme==0)
            draw(g);
        if(running==true){
            sure(g);
            deneme(g);
            gecilenKareler(g);
        }
        if (devamEtme==1){
            gecilenKareler(g);
            g.setColor(Color.red);
            g.setFont(new Font("Montserrat ExtraBold", Font.BOLD, boyut-3));
            g.drawString("Süre: "+String.valueOf(bitisSuresi),10,(int)30*(boyut/10)+(boyut/4)*5+10);
            int gecilenkaresayisi=0;
            for (int i = 0; i < boyut*boyut; i++) {
                gecilenkaresayisi++;
            }
            g.setFont(new Font("Montserrat ExtraBold", Font.BOLD, boyut-3));
            g.drawString("Geçilen Kare Sayısı:"+gecilenkaresayisi,konumLL.get(0).x,robot.konum.y+50);

        }



    }
    public void draw(Graphics g){
        //g.drawLine(baslangicCizgi,0,baslangicCizgi,boyut*30);
        int xEkseni=baslangicCizgi+boyut*3;

        for (int i = 0; i < boyut+1; i++) {
            g.drawLine(xEkseni+i*25,0,xEkseni+i*25,boyut*25);
            g.drawLine(xEkseni,i*25,xEkseni+boyut*25,i*25);

        }

        Konum[][] konumDizi=new Konum[boyut][boyut];
        int sayac=0;
        for (int i = 0; i < boyut; i++) {
            for (int j = 0; j < boyut; j++) {
                konumDizi[i][j]=konumLinkedList.get(sayac);
                sayac++;
            }
        }
        for (int i = 0; i < boyut; i++) {
            for (int j = 0; j < boyut; j++) {
                if(konumDizi[i][j].engel==true){
                    g.setColor(Color.black);
                    g.fillRect(xEkseni+j*25,i*25,25,25);
                }
                else{
                    g.setColor(Color.white);
                    g.fillRect(xEkseni+j*25,i*25,25,25);
                }
                konumDizi[i][j].x=xEkseni+j*25;
                konumDizi[i][j].y=i*25;
            }
        }
        g.setColor(Color.BLUE);
        g.fillOval(konumDizi[0][0].x,konumDizi[0][0].y,25,25);
        g.setColor(Color.red);
        g.fillRect(konumDizi[boyut-1][boyut-1].x,konumDizi[boyut-1][boyut-1].y,25,25);

        sayac=0;
        for (int i = 0; i < boyut; i++) {
            for (int j = 0; j < boyut; j++) {
                konumDizi[i][j].idnumarasi=sayac;
                konumDizi[i][j].xEkseniIndex=j;
                konumDizi[i][j].yEkseniIndex=i;
                sayac++;
            }
        }

        for (int i = 0; i < boyut; i++) {
            for (int j = 0; j < boyut; j++) {
                if (i==0 && j==0){
                    konumDizi[i][j].komsuKonum.add(konumDizi[i][j+1]);
                    konumDizi[i][j].komsuKonum.add(konumDizi[i+1][j]);
                } else if (i==0 && (j>0 && j<boyut-1)) {
                    konumDizi[i][j].komsuKonum.add(konumDizi[i][j+1]);
                    konumDizi[i][j].komsuKonum.add(konumDizi[i+1][j]);
                    konumDizi[i][j].komsuKonum.add(konumDizi[i][j-1]);
                } else if (j==0 && (i>0 && i<boyut-1)) {
                    konumDizi[i][j].komsuKonum.add(konumDizi[i][j+1]);
                    konumDizi[i][j].komsuKonum.add(konumDizi[i+1][j]);
                    konumDizi[i][j].komsuKonum.add(konumDizi[i-1][j]);
                } else if (i==boyut-1 && (j>0 && j<boyut-1)) {
                    konumDizi[i][j].komsuKonum.add(konumDizi[i][j+1]);
                    konumDizi[i][j].komsuKonum.add(konumDizi[i-1][j]);
                    konumDizi[i][j].komsuKonum.add(konumDizi[i][j-1]);
                } else if (j==boyut-1 && (i>0 && i<boyut-1)) {
                    konumDizi[i][j].komsuKonum.add(konumDizi[i][j-1]);
                    konumDizi[i][j].komsuKonum.add(konumDizi[i+1][j]);
                    konumDizi[i][j].komsuKonum.add(konumDizi[i-1][j]);
                } else if (i==0 && j==boyut-1) {
                    konumDizi[i][j].komsuKonum.add(konumDizi[i][j-1]);
                    konumDizi[i][j].komsuKonum.add(konumDizi[i+1][j]);
                } else if (j==0 && i==boyut-1) {
                    konumDizi[i][j].komsuKonum.add(konumDizi[i][j+1]);
                    konumDizi[i][j].komsuKonum.add(konumDizi[i-1][j]);
                } else if (i==boyut-1 && j==boyut-1) {
                    konumDizi[i][j].komsuKonum.add(konumDizi[i][j-1]);
                    konumDizi[i][j].komsuKonum.add(konumDizi[i-1][j]);
                } else {
                    konumDizi[i][j].komsuKonum.add(konumDizi[i][j+1]);
                    konumDizi[i][j].komsuKonum.add(konumDizi[i+1][j]);
                    konumDizi[i][j].komsuKonum.add(konumDizi[i][j-1]);
                    konumDizi[i][j].komsuKonum.add(konumDizi[i-1][j]);
                }
                for (int k = 0; k < konumDizi[i][j].komsuKonum.size(); k++) {
                    for (int l = k+1; l < konumDizi[i][j].komsuKonum.size(); l++) {
                        if(konumDizi[i][j].komsuKonum.get(k).equals(konumDizi[i][j].komsuKonum.get(l)))
                            konumDizi[i][j].komsuKonum.remove(l);
                    }
                }
                konumLL.add(konumDizi[i][j]);
            }
        }
        robot.konum=konumDizi[0][0];
        oncekiKonum=konumDizi[0][0];

    }
}

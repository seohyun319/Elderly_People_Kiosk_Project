import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MovieLast extends JFrame implements ActionListener {
    JButton btOk;
//    static JButton back;
    JLabel labelPeople, labelSit, labelPrice, labelMovie, labelMvPhoto, labelTime;
    Color col1 = new Color(232,250,255);
    Color col2 = new Color(170,242,255);
    int numSum = 0;
    int priceSum = 0;
    PlayAudio p;

    public MovieLast(int Old, int Adult, int Teen, ArrayList<String> seatname) {

        this.numSum =Old +Adult +Teen;
        this.priceSum = Old*5000 +Adult*13000 +Teen*10000;
        Display();
    }


    public void Display() {
        setSize(650,830);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("최종화면");
        Container c= getContentPane();
        c.setLayout(new BorderLayout(3,1));

        JPanel panelNorth = new JPanel();
        JPanel panelCenter = new JPanel();
        JPanel panelSouth = new JPanel();
        JPanel panel0 = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();

//        MovieMiddle mm = new MovieMiddle();
//        int numSum = (int)mm.numOld +(int)mm.numAdult + (int)mm.numTeen;
//        int priceSum = (int)mm.numOld*5000 +(int)mm.numAdult*13000 + (int)mm.numTeen*10000;

        labelMvPhoto = new JLabel(Poster.moviePhoto);
        labelMovie = new JLabel("영화 : "+Poster.movieName);
        labelTime = new JLabel("시간 : "+Poster.movieTime);
        labelPeople = new JLabel("인원 : "+numSum+" 명");
        labelSit = new JLabel("좌석 : 1관 "+SelectSeats.seatname);
        labelPrice = new JLabel("가격 : "+priceSum+" 원");
        btOk = new JButton("확인");
        btOk.setPreferredSize(new Dimension(600,80));
        btOk.setBackground(col2);
        btOk.addActionListener(this);
        Font f = new Font("맑은 고딕", Font.CENTER_BASELINE,30);
        labelMovie.setFont(f);
        labelTime.setFont(f);
        labelPrice.setFont(f);
        labelSit.setFont(f);
        labelPeople.setFont(f);
        btOk.setFont(f);

        panel0.add(labelMvPhoto);
        panel1.add(labelMovie);
        panel2.add(labelTime);
        panel3.add(labelPeople);
        panel4.add(labelSit);
        panel5.add(labelPrice);

        MovieMiddle.NorthPanel np = new MovieMiddle.NorthPanel();
        MovieMiddle.back.addActionListener(e->{
            p.Stop();
            new SelectSeats();
            setVisible(false);
        });

        panelNorth.setLayout(new BorderLayout(3,1));
        panelNorth.add(np, BorderLayout.NORTH);
        panelNorth.add(panel0, BorderLayout.CENTER);
        panelNorth.add(panel1, BorderLayout.SOUTH);
        panelCenter.setLayout(new GridLayout(3,1));
        panelCenter.add(panel2, BorderLayout.NORTH);
        panelCenter.add(panel3, BorderLayout.CENTER);
        panelCenter.add(panel4, BorderLayout.SOUTH);
        panelSouth.setLayout(new GridLayout(2,1));
        panelSouth.add(panel5, BorderLayout.NORTH);
        panelSouth.add(btOk,BorderLayout.SOUTH);

        panelNorth.setPreferredSize(new Dimension(500,460));
        panelCenter.setPreferredSize(new Dimension(500,150));
        panelSouth.setPreferredSize(new Dimension(500,140));

        panelNorth.setBackground(col1);
        panel0.setBackground(col1);
        panel1.setBackground(col1);
        panel2.setBackground(col1);
        panel3.setBackground(col1);
        panel4.setBackground(col1);
        panel5.setBackground(col1);
        panelSouth.setBackground(col1);

        c.add(panelNorth, BorderLayout.NORTH);
        c.add(panelCenter, BorderLayout.CENTER);
        c.add(panelSouth, BorderLayout.SOUTH);
        setVisible(true);



        try {
            p= new PlayAudio("2021_Test/Chap1/src/sounds/sound6.wav");
            p.Play();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btOk) {
            p.Stop();
            this.dispose();
        }

    }
}

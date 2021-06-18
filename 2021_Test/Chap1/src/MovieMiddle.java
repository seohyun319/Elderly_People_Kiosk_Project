import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovieMiddle extends JFrame implements ActionListener {
    JButton btOk, btHelp;
    static JButton back;
    JLabel labelMvPhoto, labelSelect, labelA1, labelA2, labelA3, labelANum1, labelANum2, labelANum3;
    String nums[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    //    JButton buttonsOld[]  = new JButton[nums.length];
    JButton buttonsOld[]  = new JButton[nums.length];
    JButton buttonsAdult[]  = new JButton[nums.length];
    JButton buttonsTeen[]  = new JButton[nums.length];
    JPanel panelNorth = new JPanel();
    JPanel panelCenter = new JPanel();
    JPanel panelSouth = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    Container c;
    int[][] pstate = new int[3][9];
    int[] previous = new int[3];
    int[] pselect = new int[3];
    Color col1 = new Color(232,250,255);
    Color col2 = new Color(170,242,255);
    Color col3 = new Color(170,216,255);
//    Color col4 = new Color(107,163,255);
    static int numOld, numAdult, numTeen;
    PlayAudio p;

    public MovieMiddle() {
        setSize(650,830);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("인원선택화면");
        c= getContentPane();
        c.setLayout(new BorderLayout(3,1));
        int[] pstate= {0,0,0};

        labelMvPhoto = new JLabel(Poster.moviePhoto);
        labelSelect = new JLabel("영화 관람 인원수를 선택하세요");
        labelSelect.setHorizontalAlignment(JLabel.CENTER);
        labelA1 = new JLabel("  우대  ");
        labelA2 = new JLabel("  성인  ");
        labelA3 = new JLabel("청소년  ");
        labelANum1 = new JLabel(" 명  ");
        labelANum2 = new JLabel(" 명  ");
        labelANum3 = new JLabel(" 명  ");
        btOk = new JButton("확인");
        btHelp = new JButton("도움말");
        btOk.setPreferredSize(new Dimension(300,80));
        btHelp.setPreferredSize(new Dimension(300,80));
        btOk.setBackground(col2);
        btHelp.setBackground(col2);
        btOk.addActionListener(this);
        btHelp.addActionListener(this);
//        setLayout(new GridLayout(8,1));
//        panel1.setLayout(new GridLayout(1,2));
//        panel2.setLayout(new GridLayout(1,2));
//        panel3.setLayout(new GridLayout(1,2));

        Font f = new Font("맑은 고딕", Font.CENTER_BASELINE,30);
        Font f2 = new Font("고딕", Font.CENTER_BASELINE,28);
        labelA1.setFont(f);
        labelA2.setFont(f);
        labelA3.setFont(f);
        labelANum1.setFont(f); labelANum2.setFont(f); labelANum3.setFont(f);
        labelSelect.setFont(f);
        btOk.setFont(f); btHelp.setFont(f);

        panel1.add(labelA1);
        panel2.add(labelA2);
        panel3.add(labelA3);

        panel1.setLayout(new FlowLayout(FlowLayout.RIGHT,0,1));
        panel1.setVisible(true);
        panel2.setLayout(new FlowLayout(FlowLayout.RIGHT,0,1));
        panel2.setVisible(true);
        panel3.setLayout(new FlowLayout(FlowLayout.RIGHT,0,1));
        panel3.setVisible(true);

        for (int i=0; i<nums.length; i++) {
            buttonsOld[i] = new JButton(nums[i]);
            buttonsOld[i].setFont(f2);
            buttonsOld[i].setBackground(Color.white);
            buttonsOld[i].addActionListener(this);
//            bgOld.add(buttonsOld[i]);
//            buttons[i].setPreferredSize(new Dimension(40,35));
            panel1.add(buttonsOld[i]);
        }
        for (int i=0; i<nums.length; i++) {
            buttonsAdult[i] = new JButton(nums[i]);
            buttonsAdult[i].setFont(f2);
            buttonsAdult[i].setBackground(Color.white);
            buttonsAdult[i].addActionListener(this);
//            buttons[i].setPreferredSize(new Dimension(40,35));
            panel2.add(buttonsAdult[i]);
        }
        for (int i=0; i<nums.length; i++) {
            buttonsTeen[i] = new JButton(nums[i]);
            buttonsTeen[i].setFont(f2);
            buttonsTeen[i].setBackground(Color.white);
            buttonsTeen[i].addActionListener(this);
//            buttons[i].setPreferredSize(new Dimension(40,35));
            panel3.add(buttonsTeen[i]);
        }

        panel1.add(labelANum1);
        panel2.add(labelANum2);
        panel3.add(labelANum3);

        NorthPanel np = new NorthPanel();

        back.addActionListener(this);

        panelNorth.setLayout(new BorderLayout(3,1));
        panelNorth.add(np, BorderLayout.NORTH);
        panelNorth.add(labelMvPhoto, BorderLayout.CENTER);
        panelNorth.add(labelSelect, BorderLayout.SOUTH);
        panelCenter.setLayout(new GridLayout(3,1));
        panelCenter.add(panel1, BorderLayout.NORTH);
        panelCenter.add(panel2, BorderLayout.CENTER);
        panelCenter.add(panel3, BorderLayout.SOUTH);
        panelSouth.add(btOk,BorderLayout.WEST);
        panelSouth.add(btHelp,BorderLayout.EAST);

        panelNorth.setPreferredSize(new Dimension(500,430));
        panelCenter.setPreferredSize(new Dimension(500,200));
        panelSouth.setPreferredSize(new Dimension(500,100));
        panelNorth.setBackground(col1);
        panel1.setBackground(col1);
        panel2.setBackground(col1);
        panel3.setBackground(col1);
        panelSouth.setBackground(col1);


//        c.add(panelNorth);
//        c.add(panelCenter);
//        c.add(panelSouth);
        c.add(panelNorth, BorderLayout.NORTH);
        c.add(panelCenter, BorderLayout.CENTER);
        c.add(panelSouth, BorderLayout.SOUTH);
        setVisible(true);






        try {
            p= new PlayAudio("2021_Test/Chap1/src/sounds/sound4.wav");
            p.Play();
        } catch (Exception ex) {
            ex.printStackTrace();
        }


//        panel3.add(new Button("1"));
//        panel3.add(new Button("2"));
//        panel3.add(new Button("3"));
//        panel3.add(new Button("4"));
//        panel3.add(new Button("5"));
//        panel3.add(new Button("6"));
//        panel3.add(new Button("7"));
//        panel3.add(new Button("8"));
//        panel3.add(new Button("9"));
//        panel3.setSize(650, 200);
    }


//    static class NorthPanel extends JPanel{
//        public NorthPanel() {
//            setLayout(new BorderLayout());
//            back = new JButton("뒤로 가기");
//            JButton next = new JButton("다음으로 가기");
//            back.setFont(new Font("맑은 고딕",0,30));
//            next.setFont(new Font("맑은 고딕",0,30));
//            setBackground(new Color(232,250,255));
//            add(back,BorderLayout.WEST);
//            add(next, BorderLayout.EAST);
//        }
//    }



    static class NorthPanel extends JPanel{
        public NorthPanel() {
            setLayout(new BorderLayout());
            back = new JButton(new ImageIcon("2021_Test/Chap1/src/backimg.png"));
            back.setBorderPainted(false);
            back.setContentAreaFilled(false);
            back.setFocusPainted(false);

            setBackground(new Color(232,250,255));
            add(back,BorderLayout.WEST);
        }
    }

    class dialog2 extends JDialog {
        public dialog2() {
            ImageIcon ai=new ImageIcon("help2.gif");
            JLabel al = new JLabel(ai);
            getContentPane().add(al,BorderLayout.CENTER);
            this.setSize(600,800);
            this.setVisible(true);

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back) {
            p.Stop();
            new Poster();
            setVisible(false);
        }

        if (e.getSource() == btOk) {
            if (pselect[0] == 0 && pselect[1] == 0 && pselect[2] == 0) {
                JOptionPane.showMessageDialog(c, "인원을 선택해주세요.", "인원 미선택", JOptionPane.ERROR_MESSAGE);
            } else {
                p.Stop();
                new SelectSeats(numOld, numAdult, numTeen);
                setVisible(false);
            }
        }

        if (e.getSource() == btHelp) {
            new dialog2();
        }

        for (int i = 0; i < nums.length; i++) {
            if (pselect[0] == 0) {
                if (e.getSource() == buttonsOld[i]) {
                    buttonsOld[i].setBackground(col3);
                    System.out.println("우대 " + e.getActionCommand() + "명");
                    pstate[0][i] = 1;
                    pselect[0] = 1;
                    previous[0] = i;
                    numOld = i+1;
                }
            } else if (pselect[0] == 1) {
                if (e.getSource() == buttonsOld[i] && pstate[0][i] == 0) {

                    buttonsOld[previous[0]].setBackground(Color.white);
                    pstate[0][previous[0]] = 0;
                    buttonsOld[i].setBackground(col3);
                    System.out.println("우대 " + e.getActionCommand() + "명");
                    numOld = i+1;
                    pstate[0][i] = 1;
                    pselect[0] = 1;
                    previous[0] = i;

                } else if (e.getSource() == buttonsOld[i] && pstate[0][i] == 1) {
                    buttonsOld[i].setBackground(Color.white);
                    pstate[0][i] = 0;
                    pselect[0] = 0;
                    numOld = 0;

                }
            }

            if (pselect[1] == 0) {
                if (e.getSource() == buttonsAdult[i]) {
                    buttonsAdult[i].setBackground(col3);
                    System.out.println("성인 " + e.getActionCommand() + "명");
                    pstate[1][i] = 1;
                    pselect[1] = 1;
                    previous[1] = i;
                    numAdult=i+1;
                }
            } else {//pselect[1]
                if (e.getSource() == buttonsAdult[i] && pstate[1][i] == 0) {
                    buttonsAdult[previous[1]].setBackground(Color.white);
                    pstate[1][previous[1]] = 0;
                    buttonsAdult[i].setBackground(col3);
                    System.out.println("성인 " + e.getActionCommand() + "명");
                    numAdult=i+1;
                    pstate[1][i] = 1;
                    pselect[1] = 1;
                    previous[1] = i;
                } else if (e.getSource() == buttonsAdult[i] && pstate[1][i] == 1) {
                    buttonsAdult[i].setBackground(Color.white);
                    pstate[1][i] = 0;
                    pselect[1] = 0;
                    numAdult=0;
                }
            }

            if (pselect[2] == 0) {
                if (e.getSource() == buttonsTeen[i]) {
                    buttonsTeen[i].setBackground(col3);
                    System.out.println("청소년 " + e.getActionCommand() + "명");
                    numTeen=i+1;
                    pstate[2][i] = 1;
                    pselect[2] = 1;
                    previous[2] = i;
                }

            } else {//pselect[2]==1
                if (e.getSource() == buttonsTeen[i] && pstate[2][i] == 0) {
                    buttonsTeen[previous[2]].setBackground(Color.white);
                    pstate[2][previous[2]] = 0;
                    buttonsTeen[i].setBackground(col3);
                    System.out.println("청소년 " + e.getActionCommand() + "명");
                    pstate[2][i] = 1;
                    pselect[2] = 1;
                    previous[2] = i;
                    numTeen=i+1;
                } else if (e.getSource() == buttonsTeen[i] && pstate[2][i] == 1) {
                    buttonsTeen[i].setBackground(Color.white);
                    pstate[2][i] = 0;
                    pselect[2] = 0;
                    numTeen=0;
                }

            }
        }
        System.out.println("우대:" + numOld + ", 성인:" + numAdult + ", 청소년:" + numTeen);

//
//        public void actionPerformed(ActionEvent e) {
//            if (e.getSource() == btOk) {
//                new SelectSeat();
//                setVisible(false);
//            }
//
//            for (int i=0; i<nums.length; i++) {
//                if (e.getSource() == buttonsOld[i] &&pstate[0]==0) {
//                    buttonsOld[i].setBackground(col3);
//                    System.out.println("우대 " + e.getActionCommand() + "명");
//                    pstate[0]=1;
//                    numOld = i+1;
//                }
//                else if (e.getSource() == buttonsOld[i] &&pstate[0]==1) {
//                    buttonsOld[i].setBackground(Color.white);
//                }
//                if (e.getSource() == buttonsAdult[i] &&pstate[1]==0) {
//                    buttonsAdult[i].setBackground(col3);
//                    System.out.println("성인 " + e.getActionCommand() + "명");
//                    pstate[1]=1;
//                    numAdult=i+1;
//                } else if (e.getSource() == buttonsAdult[i]&&pstate[1]==1) {
//                    buttonsAdult[i].setBackground(Color.white);
//                }
//                if (e.getSource() == buttonsTeen[i]&&pstate[2]==0) {
//                    buttonsTeen[i].setBackground(col3);
//                    System.out.println("청소년 " + e.getActionCommand() + "명");
//                    pstate[2]=0;
//                    numTeen=i+1;
//                } else if (e.getSource() == buttonsTeen[i]&&pstate[2]==1) {
//                    buttonsTeen[i].setBackground(Color.white);
//                }
//            }
//
//
//            System.out.println("우대:"+numOld +", 성인:"+numAdult+", 청소년:"+numTeen);
//        }
    }
}
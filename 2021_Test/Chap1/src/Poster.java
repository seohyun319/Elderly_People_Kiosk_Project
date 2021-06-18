import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Poster extends JFrame implements ActionListener {
    JFrame f= new JFrame();
    static public JButton back;
    String pn[]= {"비와 당신의 이야기","크루즈 패밀리 - 뉴 에이지","빅 피쉬","미나리","내일의 기억","미스"};
    public JButton pbtn[]=new JButton[pn.length];
    public JButton sb = new JButton("인원 선택하기");
    public Container ct= getContentPane();
    int selected=0;


    Color col1 = new Color(232,250,255);
    Color col2 = new Color(170,242,255);
    Color col3 = new Color(170,216,255);

    static String movieName =null;
    PlayAudio p;

    static ImageIcon moviePhoto;
    static String movieTime =null;

    public Poster()   {
        super("영화 선택 단계");
        ct.setLayout(new BorderLayout(5,5));
        NorthPanelp np = new NorthPanelp();
        ct.add(np,BorderLayout.NORTH);

        PosterPanel pp = new PosterPanel();
        ct.add(pp,BorderLayout.CENTER);
        panels ps = new panels();
        ct.add(ps,BorderLayout.SOUTH);

        for(int i=0;i<pn.length;i++) {
            pbtn[i].addActionListener(this);
        }
        back.addActionListener(this);

        sb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (selected>0)
                setVisible(false);
            }
        });
        try {
            p= new PlayAudio("2021_Test/Chap1/src/sounds/sound2.wav");
            p.Play();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650,830);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ee) {
        p.Stop();
        if(ee.getSource()==pbtn[0]) {

            new pnum1();
            movieName=pn[0];
            moviePhoto = new ImageIcon("2021_Test/Chap1/src/a.gif");

            System.out.println(pn[0]);}
        if(ee.getSource()==pbtn[1]) {

            new pnum2();
            movieName=pn[1];
            moviePhoto = new ImageIcon("2021_Test/Chap1/src/b.gif");
            System.out.println(pn[1]);}
        if(ee.getSource()==pbtn[2]) {

            new pnum3();
            movieName=pn[2];
            moviePhoto = new ImageIcon("2021_Test/Chap1/src/c.gif");
            System.out.println(pn[2]);}
        if(ee.getSource()==pbtn[3]) {
            new pnum4();
            movieName=pn[3];
            moviePhoto = new ImageIcon("2021_Test/Chap1/src/d.gif");
            System.out.println(pn[3]);}
        if(ee.getSource()==pbtn[4]) {
            new pnum5();
            movieName=pn[4];
            moviePhoto = new ImageIcon("2021_Test/Chap1/src/e.gif");
            System.out.println(pn[4]);}
        if(ee.getSource()==pbtn[5]) {
            new pnum6();
            movieName=pn[5];
            moviePhoto = new ImageIcon("2021_Test/Chap1/src/f.gif");
            System.out.println(pn[5]);}
        if(ee.getSource()==back) {
            new MovieFirst();
            setVisible(false);}




    }
    class panels extends JPanel{
        public panels() {
            Font f = new Font("맑은 고딕",Font.BOLD,25);
            setLayout(new GridLayout(1,3));
            JLabel j4 = new JLabel(" 4위 : 미나리");
            j4.setFont(f);
            add(j4);
            JLabel j5 = new JLabel("5위 : 내일의 기억");
            add(j5);
            JLabel j6 = new JLabel("  6위 : 미스");
            add(j6);
            j5.setFont(f);
            j6.setFont(f);
            setBackground(col1);
        }
    }
    class paneln extends JPanel{
        public paneln() {
            Font f = new Font("맑은 고딕",Font.BOLD,25);
            setLayout(new GridLayout(1,3));
            JLabel j1 = new JLabel("1위 : 비와 당신의 이야기");
            j1.setFont(new Font("맑은 고딕",Font.BOLD,18));
            add(j1);
            JLabel j2 = new JLabel(" 2위 : 크루즈 패밀리");
            add(j2);
            JLabel j3 = new JLabel("  3위 : 빅 피쉬");
            add(j3);
            j2.setFont(new Font("맑은 고딕",Font.BOLD,22));
            j3.setFont(f);
            setBackground(col1);

        }
    }
    class PosterPanel extends JPanel {
        public PosterPanel() {

            setLayout(new GridLayout (2,3,1,1));

            ImageIcon ai=new ImageIcon("2021_Test/Chap1/src/a.gif");
            ImageIcon bi=new ImageIcon("2021_Test/Chap1/src/b.gif");
            ImageIcon ci=new ImageIcon("2021_Test/Chap1/src/c.gif");
            ImageIcon di=new ImageIcon("2021_Test/Chap1/src/d.gif");
            ImageIcon ei=new ImageIcon("2021_Test/Chap1/src/e.gif");
            ImageIcon fi=new ImageIcon("2021_Test/Chap1/src/f.gif");

            pbtn[0]=new JButton(ai);
            pbtn[1]=new JButton(bi);
            pbtn[2]=new JButton(ci);
            pbtn[3]=new JButton(di);
            pbtn[4]=new JButton(ei);
            pbtn[5]=new JButton(fi);

            for(int i=0;i<pn.length;i++)
                add(pbtn[i]);
        }
    }
    class NorthPanelp extends JPanel{
        public NorthPanelp() {
            setLayout(new BorderLayout());
            back = new JButton(new ImageIcon("2021_Test/Chap1/src/backimg.png"));
            back.setBorderPainted(false);
            back.setContentAreaFilled(false);
            back.setFocusPainted(false);

            add(back,BorderLayout.WEST);

            setBackground(col1);
            paneln pn = new paneln();
            add(pn,BorderLayout.SOUTH);
        }
    }
    public void ButtonBounds(JButton a1, JButton a2, JButton a3,JButton a4,JButton a5,JButton a6) {
        a1.setBounds(70,10,130,130);
        a2.setBounds(230,10,130,130);
        a3.setBounds(70,170,130,130);
        a4.setBounds(230,170,130,130);
        a5.setBounds(70,330,130,130);
        a6.setBounds(230,330,130,130);

    };
    public void LabelBounds(JLabel s1, JLabel s2, JLabel s3,JLabel s4,JLabel s5,JLabel s6) {
        s1.setBounds(105,140,100,20);
        s2.setBounds(260,140,100,20);
        s3.setBounds(105,300,100,20);
        s4.setBounds(260,300,100,20);
        s5.setBounds(105,460,100,20);
        s6.setBounds(260,460,100,20);

    };
    class pnum1 extends JDialog implements ActionListener {

        PlayAudio p;
        JButton mvtime[] =new JButton[6];
        JLabel amountseat[] =new JLabel[6];
        public pnum1() {
            JPanel jp = new JPanel();
            jp.setLayout(null);
            jp.setBackground(col1);

            sb.setFont(new Font("맑은 고딕",0,30));
            sb.setBackground(col2);
            ImageIcon ap = new ImageIcon("2021_Test/Chap1/src/a.gif");
            JLabel al = new JLabel(ap);
            getContentPane().add(al,BorderLayout.WEST);
            getContentPane().add(sb,BorderLayout.PAGE_END);
            getContentPane().setBackground(col1);

            sb.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    if(selected==0) {
                        JOptionPane.showMessageDialog(ct, "시간을 선택하지 않았습니다.", "시간 미선택", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        p.Stop();
                        new MovieMiddle();
                        setVisible(false);
                    }
                }
            });

            try {
                p= new PlayAudio("2021_Test/Chap1/src/sounds/sound3.wav");
                p.Play();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            for(int i=0; i<mvtime.length; i++) {

                if(i==0) {
                    mvtime[0]= new JButton("오전 10:20");
                    amountseat[0] =new JLabel("26자리 남음");
                }
                else if(i==1) {
                    mvtime[1]  = new JButton("오전 11:50");
                    amountseat[1] =new JLabel("11자리 남음");
                }
                else if(i==2) {
                    mvtime[2]  =  new JButton("오후 01:40");
                    amountseat[2] = new JLabel("28자리 남음");
                }
                else if(i==3) {
                    mvtime[3]  = new JButton("오후 03:30");
                    amountseat[3] =new JLabel("25자리 남음");
                }
                else if(i==4) {
                    mvtime[4]  = new JButton("오후 05:10");
                    amountseat[4] =new JLabel("14자리 남음");
                }
                else if(i==5) {
                    mvtime[5]  = new JButton("오후 07:30");
                    amountseat[5] =new JLabel("9자리 남음");
                }
                mvtime[i].setBackground(Color.white);
                mvtime[i].setFont(new Font("맑은 고딕",0,20));
                mvtime[i].addActionListener(this);
                jp.add(mvtime[i]);
                jp.add(amountseat[i]);
            }

            ButtonBounds(mvtime[0],mvtime[1],mvtime[2],mvtime[3],mvtime[4],mvtime[5]);
            LabelBounds(amountseat[0],amountseat[1],amountseat[2],amountseat[3],amountseat[4],amountseat[5]);

            add(jp);

            setTitle("영화 관람 시간 선택");
            this.setSize(650,600);
            this.setVisible(true);

        }

        @Override
        public void actionPerformed(ActionEvent e) {

            for(int i=0; i<mvtime.length; i++) {
                if(e.getSource()==mvtime[i]) {
                    movieTime =e.getActionCommand();
                    System.out.println(e.getActionCommand());
                    mvtime[i].setBackground(col3);
                    selected +=1;
                }
                else if (mvtime[i].isRequestFocusEnabled()) {
                    mvtime[i].setBackground(Color.WHITE);
                }


            }

        }}

    class pnum2 extends JDialog implements ActionListener{
        JButton mvtime[] =new JButton[6];
        JLabel amountseat[] =new JLabel[6];
        public pnum2() {
            JPanel jp = new JPanel();
            jp.setLayout(null);
            jp.setBackground(col1);

            sb.setFont(new Font("맑은 고딕",0,30));
            sb.setBackground(col2);
            ImageIcon ap = new ImageIcon("2021_Test/Chap1/src/b.gif");
            JLabel al = new JLabel(ap);
            getContentPane().add(al,BorderLayout.WEST);
            getContentPane().add(sb,BorderLayout.PAGE_END);
            getContentPane().setBackground(col1);

            sb.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    if(selected==0) {
                        JOptionPane.showMessageDialog(ct, "시간을 선택하지 않았습니다.", "시간 미선택", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        p.Stop();
                        new MovieMiddle();
                        setVisible(false);
                    }
                }
            });

            try {
                p= new PlayAudio("2021_Test/Chap1/src/sounds/sound3.wav");
                p.Play();
            } catch (Exception ex) {
                ex.printStackTrace();
            }


            for(int i=0; i<mvtime.length; i++) {

                if(i==0) {
                    mvtime[0]= new JButton("오전 10:10");
                    amountseat[0] =new JLabel("16자리 남음");
                }
                else if(i==1) {
                    mvtime[1]  = new JButton("오전 11:20");
                    amountseat[1] =new JLabel("21자리 남음");
                }
                else if(i==2) {
                    mvtime[2]  =  new JButton("오후 12:40");
                    amountseat[2] = new JLabel("8자리 남음");
                }
                else if(i==3) {
                    mvtime[3]  = new JButton("오후 02:30");
                    amountseat[3] =new JLabel("5자리 남음");
                }
                else if(i==4) {
                    mvtime[4]  = new JButton("오후 04:10");
                    amountseat[4] =new JLabel("14자리 남음");
                }
                else if(i==5) {
                    mvtime[5]  = new JButton("오후 08:30");
                    amountseat[5] =new JLabel("9자리 남음");
                }
                mvtime[i].setBackground(Color.white);
                mvtime[i].setFont(new Font("맑은 고딕",0,20));
                mvtime[i].addActionListener(this);
                jp.add(mvtime[i]);
                jp.add(amountseat[i]);


            }


            ButtonBounds(mvtime[0],mvtime[1],mvtime[2],mvtime[3],mvtime[4],mvtime[5]);
            LabelBounds(amountseat[0],amountseat[1],amountseat[2],amountseat[3],amountseat[4],amountseat[5]);


            add(jp);


            setTitle("영화 관람 시간 선택");
            this.setSize(650,600);
            this.setVisible(true);

        }
        public void actionPerformed(ActionEvent e) {
            for(int i=0; i<mvtime.length; i++) {
                if(e.getSource()==mvtime[i]) {
                    movieTime =e.getActionCommand();
                    System.out.println(e.getActionCommand());
                    mvtime[i].setBackground(col3);
                    selected +=1;
                }
                else if (mvtime[i].isRequestFocusEnabled()) {
                    mvtime[i].setBackground(Color.WHITE);
                }

            }

        }
    }
    class pnum3 extends JDialog implements ActionListener{
        JButton mvtime[] =new JButton[6];
        JLabel amountseat[] =new JLabel[6];
        public pnum3() {
            JPanel jp = new JPanel();
            jp.setLayout(null);
            jp.setBackground(col1);

            sb.setFont(new Font("맑은 고딕",0,30));
            sb.setBackground(col2);
            ImageIcon ap = new ImageIcon("2021_Test/Chap1/src/c.gif");
            JLabel al = new JLabel(ap);
            getContentPane().add(al,BorderLayout.WEST);
            getContentPane().add(sb,BorderLayout.PAGE_END);
            getContentPane().setBackground(col1);

            sb.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    if(selected==0) {
                        JOptionPane.showMessageDialog(ct, "시간을 선택하지 않았습니다.", "시간 미선택", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        p.Stop();
                        new MovieMiddle();
                        setVisible(false);
                    }
                }
            });

            try {
                p= new PlayAudio("2021_Test/Chap1/src/sounds/sound3.wav");
                p.Play();
            } catch (Exception ex) {
                ex.printStackTrace();
            }


            for(int i=0; i<mvtime.length; i++) {

                if(i==0) {
                    mvtime[0]= new JButton("오전 08:20");
                    amountseat[0] =new JLabel("26자리 남음");
                }
                else if(i==1) {
                    mvtime[1]  = new JButton("오전 10:50");
                    amountseat[1] =new JLabel("11자리 남음");
                }
                else if(i==2) {
                    mvtime[2]  =  new JButton("오후 01:40");
                    amountseat[2] = new JLabel("28자리 남음");
                }
                else if(i==3) {
                    mvtime[3]  = new JButton("오후 04:30");
                    amountseat[3] =new JLabel("25자리 남음");
                }
                else if(i==4) {
                    mvtime[4]  = new JButton("오후 06:10");
                    amountseat[4] =new JLabel("14자리 남음");
                }
                else if(i==5) {
                    mvtime[5]  = new JButton("오후 09:30");
                    amountseat[5] =new JLabel("9자리 남음");
                }
                mvtime[i].setBackground(Color.white);
                mvtime[i].setFont(new Font("맑은 고딕",0,20));
                mvtime[i].addActionListener(this);
                jp.add(mvtime[i]);
                jp.add(amountseat[i]);

            }

            ButtonBounds(mvtime[0],mvtime[1],mvtime[2],mvtime[3],mvtime[4],mvtime[5]);
            LabelBounds(amountseat[0],amountseat[1],amountseat[2],amountseat[3],amountseat[4],amountseat[5]);


            add(jp);

            setTitle("영화 관람 시간 선택");
            this.setSize(650,600);
            this.setVisible(true);

        }

        public void actionPerformed(ActionEvent e) {
            for(int i=0; i<mvtime.length; i++) {
                if(e.getSource()==mvtime[i]) {
                    movieTime =e.getActionCommand();
                    System.out.println(e.getActionCommand());
                    mvtime[i].setBackground(col3);
                    selected +=1;
                }
                else if (mvtime[i].isRequestFocusEnabled()) {
                    mvtime[i].setBackground(Color.WHITE);
                }
            }
        }
    }
    class pnum4 extends JDialog implements ActionListener{
        JButton mvtime[] =new JButton[6];
        JLabel amountseat[] =new JLabel[6];
        public pnum4() {
            JPanel jp = new JPanel();
            jp.setLayout(null);
            jp.setBackground(col1);


            sb.setFont(new Font("맑은 고딕",0,30));
            sb.setBackground(col2);
            ImageIcon ap = new ImageIcon("2021_Test/Chap1/src/d.gif");
            JLabel al = new JLabel(ap);
            getContentPane().add(al,BorderLayout.WEST);
            getContentPane().add(sb,BorderLayout.PAGE_END);
            getContentPane().setBackground(col1);

            sb.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    if(selected==0) {
                        JOptionPane.showMessageDialog(ct, "시간을 선택하지 않았습니다.", "시간 미선택", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        p.Stop();
                        new MovieMiddle();
                        setVisible(false);
                    }
                }
            });

            try {
                p= new PlayAudio("2021_Test/Chap1/src/sounds/sound3.wav");
                p.Play();
            } catch (Exception ex) {
                ex.printStackTrace();
            }



            for(int i=0; i<mvtime.length; i++) {

                if(i==0) {
                    mvtime[0]= new JButton("오전 06:20");
                    amountseat[0] =new JLabel("16자리 남음");
                }
                else if(i==1) {
                    mvtime[1]  = new JButton("오전 11:10");
                    amountseat[1] =new JLabel("21자리 남음");
                }
                else if(i==2) {
                    mvtime[2]  =  new JButton("오후 02:40");
                    amountseat[2] = new JLabel("29자리 남음");
                }
                else if(i==3) {
                    mvtime[3]  = new JButton("오후 05:10");
                    amountseat[3] =new JLabel("25자리 남음");
                }
                else if(i==4) {
                    mvtime[4]  = new JButton("오후 08:40");
                    amountseat[4] =new JLabel("14자리 남음");
                }
                else if(i==5) {
                    mvtime[5]  = new JButton("오후 09:50");
                    amountseat[5] =new JLabel("19자리 남음");
                }
                mvtime[i].setBackground(Color.white);
                mvtime[i].setFont(new Font("맑은 고딕",0,20));
                mvtime[i].addActionListener(this);
                jp.add(mvtime[i]);
                jp.add(amountseat[i]);

            }

            ButtonBounds(mvtime[0],mvtime[1],mvtime[2],mvtime[3],mvtime[4],mvtime[5]);
            LabelBounds(amountseat[0],amountseat[1],amountseat[2],amountseat[3],amountseat[4],amountseat[5]);

            add(jp);

            setTitle("영화 관람 시간 선택");
            this.setSize(650,600);
            this.setVisible(true);

        }

        public void actionPerformed(ActionEvent e) {
            for(int i=0; i<mvtime.length; i++) {
                if(e.getSource()==mvtime[i]) {
                    movieTime =e.getActionCommand();
                    System.out.println(e.getActionCommand());
                    mvtime[i].setBackground(col3);
                    selected +=1;
                }
                else if (mvtime[i].isRequestFocusEnabled()) {
                    mvtime[i].setBackground(Color.WHITE);
                }

            }
        }
    }
    class pnum5 extends JDialog implements ActionListener{
        JButton mvtime[] =new JButton[6];
        JLabel amountseat[] =new JLabel[6];
        public pnum5() {
            JPanel jp = new JPanel();
            jp.setLayout(null);
            jp.setBackground(col1);

            sb.setFont(new Font("맑은 고딕",0,30));
            sb.setBackground(col2);
            ImageIcon ap = new ImageIcon("2021_Test/Chap1/src/e.gif");
            JLabel al = new JLabel(ap);
            getContentPane().add(al,BorderLayout.WEST);
            getContentPane().add(sb,BorderLayout.PAGE_END);
            getContentPane().setBackground(col1);

            sb.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    if(selected==0) {
                        JOptionPane.showMessageDialog(ct, "시간을 선택하지 않았습니다.", "시간 미선택", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        p.Stop();
                        new MovieMiddle();
                        setVisible(false);
                    }
                }
            });

            try {
                p= new PlayAudio("2021_Test/Chap1/src/sounds/sound3.wav");
                p.Play();
            } catch (Exception ex) {
                ex.printStackTrace();
            }



            for(int i=0; i<mvtime.length; i++) {

                if(i==0) {
                    mvtime[0]= new JButton("오전 08:20");
                    amountseat[0] =new JLabel("16자리 남음");
                }
                else if(i==1) {
                    mvtime[1]  = new JButton("오전 11:00");
                    amountseat[1] =new JLabel("11자리 남음");
                }
                else if(i==2) {
                    mvtime[2]  =  new JButton("오후 2:10");
                    amountseat[2] = new JLabel("18자리 남음");
                }
                else if(i==3) {
                    mvtime[3]  = new JButton("오후 05:10");
                    amountseat[3] =new JLabel("25자리 남음");
                }
                else if(i==4) {
                    mvtime[4]  = new JButton("오후 08:00");
                    amountseat[4] =new JLabel("14자리 남음");
                }
                else if(i==5) {
                    mvtime[5]  = new JButton("오후 10:30");
                    amountseat[5] =new JLabel("19자리 남음");
                }
                mvtime[i].setBackground(Color.white);
                mvtime[i].setFont(new Font("맑은 고딕",0,20));
                mvtime[i].addActionListener(this);
                jp.add(mvtime[i]);
                jp.add(amountseat[i]);

            }

            ButtonBounds(mvtime[0],mvtime[1],mvtime[2],mvtime[3],mvtime[4],mvtime[5]);
            LabelBounds(amountseat[0],amountseat[1],amountseat[2],amountseat[3],amountseat[4],amountseat[5]);

            add(jp);

            setTitle("영화 관람 시간 선택");
            this.setSize(650,600);
            this.setVisible(true);

        }

        public void actionPerformed(ActionEvent e) {
            for(int i=0; i<mvtime.length; i++) {
                if(e.getSource()==mvtime[i]) {
                    movieTime =e.getActionCommand();
                    System.out.println(e.getActionCommand());
                    mvtime[i].setBackground(col3);
                    selected +=1;
                }
                else if (mvtime[i].isRequestFocusEnabled()) {
                    mvtime[i].setBackground(Color.WHITE);
                }

            }
        }
    }
    class pnum6 extends JDialog implements ActionListener{
        JButton mvtime[] =new JButton[6];
        JLabel amountseat[] =new JLabel[6];
        public pnum6() {
            JPanel jp = new JPanel();
            jp.setLayout(null);
            jp.setBackground(col1);

            sb.setFont(new Font("맑은 고딕",0,30));
            sb.setBackground(col2);
            ImageIcon ap = new ImageIcon("2021_Test/Chap1/src/f.gif");
            JLabel al = new JLabel(ap);
            getContentPane().add(al,BorderLayout.WEST);
            getContentPane().add(sb,BorderLayout.PAGE_END);
            getContentPane().setBackground(col1);

            sb.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    if(selected==0) {
                        JOptionPane.showMessageDialog(ct, "시간을 선택하지 않았습니다.", "시간 미선택", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        p.Stop();
                        new MovieMiddle();
                        setVisible(false);
                    }
                }
            });

            try {
                p= new PlayAudio("2021_Test/Chap1/src/sounds/sound3.wav");
                p.Play();
            } catch (Exception ex) {
                ex.printStackTrace();
            }



            for(int i=0; i<mvtime.length; i++) {

                if(i==0) {
                    mvtime[0]= new JButton("오전 07:10");
                    amountseat[0] =new JLabel("26자리 남음");
                }
                else if(i==1) {
                    mvtime[1]  = new JButton("오전 9:20");
                    amountseat[1] =new JLabel("21자리 남음");
                }
                else if(i==2) {
                    mvtime[2]  =  new JButton("오후 12:00");
                    amountseat[2] = new JLabel("28자리 남음");
                }
                else if(i==3) {
                    mvtime[3]  = new JButton("오후 03:30");
                    amountseat[3] =new JLabel("25자리 남음");
                }
                else if(i==4) {
                    mvtime[4]  = new JButton("오후 05:10");
                    amountseat[4] =new JLabel("14자리 남음");
                }
                else if(i==5) {
                    mvtime[5]  = new JButton("오후 10:30");
                    amountseat[5] =new JLabel("10자리 남음");
                }
                mvtime[i].setBackground(Color.white);
                mvtime[i].setFont(new Font("맑은 고딕",0,20));
                mvtime[i].addActionListener(this);
                jp.add(mvtime[i]);
                jp.add(amountseat[i]);

            }

            ButtonBounds(mvtime[0],mvtime[1],mvtime[2],mvtime[3],mvtime[4],mvtime[5]);
            LabelBounds(amountseat[0],amountseat[1],amountseat[2],amountseat[3],amountseat[4],amountseat[5]);

            add(jp);

            setTitle("영화 관람 시간 선택");
            this.setSize(650,600);
            this.setVisible(true);

        }

        public void actionPerformed(ActionEvent e) {
            for(int i=0; i<mvtime.length; i++) {
                if(e.getSource()==mvtime[i]) {
                    movieTime =e.getActionCommand();
                    System.out.println(e.getActionCommand());
                    mvtime[i].setBackground(col3);
                    selected +=1;
                }
                else if (mvtime[i].isRequestFocusEnabled()) {
                    mvtime[i].setBackground(Color.WHITE);
                }

            }
        }
    }
}
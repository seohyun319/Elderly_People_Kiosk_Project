import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovieFirst extends JFrame implements ActionListener {
    JButton btRsv, btHelp;
    JLabel label;
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    Color col1 = new Color(232,250,255);
    Color col2 = new Color(170,242,255);
    PlayAudio p;

    public MovieFirst() {
        setSize(650,830);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("초기화면");
        Container c= getContentPane();
        c.setLayout(new BorderLayout(3,1));


        Font f = new Font("맑은 고딕", Font.BOLD,30);
        label = new JLabel("노인 전용 영화표 예매기");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(f);
        btRsv = new JButton("예매하기");
        btHelp = new JButton("도움말");
        btRsv.setFont(f);
        btHelp.setFont(f);
        btRsv.setPreferredSize(new Dimension(300,230));
        btHelp.setPreferredSize(new Dimension(300,230));
        btRsv.setBackground(col2);
        btHelp.setBackground(col2);
        btRsv.addActionListener(this);
        btHelp.addActionListener(this);

        panel1.setBackground(col1);
        panel2.setBackground(col1);
        panel1.setPreferredSize(new Dimension(500,300));
        panel2.setPreferredSize(new Dimension(650,530));
        panel1.add(label, BorderLayout.SOUTH);
        panel2.add(btRsv, BorderLayout.WEST);
        panel2.add(btHelp, BorderLayout.EAST);
        c.add(panel1,BorderLayout.CENTER);
        c.add(panel2,BorderLayout.SOUTH);
        setVisible(true);


        try {
            p= new PlayAudio("2021_Test/Chap1/src/sounds/sound1.wav");
            p.Play();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    class dialog extends JDialog {
        public dialog() {
            ImageIcon ai=new ImageIcon("help.gif");
            JLabel al = new JLabel(ai);
            getContentPane().add(al,BorderLayout.CENTER);
            this.setSize(600,800);
            this.setVisible(true);

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btRsv) {
            p.Stop();
            new Poster();
            setVisible(false);
        }
        if (e.getSource() == btHelp) {
            new dialog();
        }

    }


}
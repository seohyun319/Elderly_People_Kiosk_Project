import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.util.ArrayList;
import javax.swing.SwingUtilities;


public class SelectSeats implements ActionListener {
	JLabel screen = new JLabel("스크린");
	JPanel layout = new JPanel();
	JPanel layout2 = new JPanel();

	JLabel blank1,blank2,title;
	Color col1 = new Color(232,250,255);
	Color col2 = new Color(170,242,255);
	Color col3 = new Color(170,216,255);

	PlayAudio p;
	JButton seatbt[] = new JButton[35];
	static ArrayList<String> seatname = new ArrayList();
	JLabel selected=new JLabel("선택한 자리:"), amount;
	JButton next;
	JPanel lay1,lay2 = new JPanel();
	int[] state = new int[35];
	String seatnum[] = {"A1","A2","A3","A4","A5",
			"B1","B2","B3","B4","B5",
			"C1","C2","C3","C4","C5",
			"D1","D2","D3","D4","D5",
			"E1","E2","E3","E4","E5",
			"F1","F2","F3","F4","F5",
			"G1","G2","G3","G4","G5"};
	int person=0,count=0;
	static JFrame f = new JFrame();

	int Old=0,Adult=0,Teen=0;
	int totalprice=0;

	JPanel panelNorth = new JPanel();




	public SelectSeats() {
		Display();
	};

	public SelectSeats(int numold,int numadult,int numteen) {
		this.Old = numold;
		this.Adult =numadult;
		this.Teen =numteen;
		person=numold+numadult+numteen;
		this.totalprice = Old*5000 +Adult*13000 +Teen*10000;
		count=person;
		Display();

	}

	public void Display() {

		Font font = new Font("돋움", Font.BOLD, 20);
		lay2.setBackground(Color.white);
		lay2.setLayout(new GridLayout(7,5,9,9));
		lay1 = new JPanel();

		try {
			p= new PlayAudio("2021_Test/Chap1/src/sounds/sound5.wav");
			p.Play();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		for(int i =0; i<seatnum.length; i++) {
			seatbt[i] = new JButton(seatnum[i]);
			if(i==10 || i==33 ||i==2) {
				state[i]=2;
				seatbt[i].setBackground(Color.gray);
			}
			else{
				seatbt[i].setBackground(Color.black);
				state[i] =0;
			}
			seatbt[i].setFont(font);
			seatbt[i].setForeground(Color.white);
			seatbt[i].addActionListener(this);
			lay2.add(seatbt[i]);



		}
		Font font1 = new Font("돋움", Font.BOLD, 30);

		MovieMiddle.NorthPanel np = new MovieMiddle.NorthPanel();

		MovieMiddle.back.addActionListener(e->{
			p.Stop();
			new MovieMiddle();
			f.setVisible(false);
		});


		amount = new JLabel("결제금액: "+totalprice);
		next = new JButton ("결제하기");

		selected.setFont(font1);
		amount.setFont(font1);
		next.setFont(font1);
		next.setBackground(col2);
		next.setPreferredSize(new Dimension(500,40));


		selected.setHorizontalAlignment(JLabel.CENTER);
		amount.setHorizontalAlignment(JLabel.CENTER);

		lay1.setLayout(new BorderLayout());
		lay1.add(selected, BorderLayout.NORTH);
		lay1.add(amount, BorderLayout.CENTER);
		lay1.add(next,BorderLayout.SOUTH);
		lay1.setBackground(col1);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = f.getContentPane();
		c.setLayout(new BorderLayout(30,10));
		c.setBackground(col1);


		screen.setHorizontalAlignment(JLabel.CENTER);
		screen.setFont(new Font("serif", Font.BOLD, 20));

//      layout.setLayout(new BorderLayout());
		layout.add(screen, BorderLayout.NORTH);
		layout.add(lay2,BorderLayout.CENTER);
		layout.setBackground(Color.white);
		layout.setPreferredSize(new Dimension(600,600));
		lay2.setPreferredSize(new Dimension(500,550));
		layout2.add(lay1);
		layout2.setBackground(col1);

		blank1 =new JLabel(" ");
		blank2 = new JLabel (" ");
		title = new JLabel("자리");
		title.setFont(new Font("돋움",Font.BOLD,30));

		next.addActionListener(this);

		panelNorth.setLayout(new GridLayout(1,3));
		panelNorth.add(np);
		panelNorth.add(title);
		panelNorth.add(blank1);
		panelNorth.setPreferredSize(new Dimension(650,50));
		panelNorth.setBackground(col1);

		c.add(layout,BorderLayout.CENTER);
		c.add(layout2,BorderLayout.SOUTH);
		c.add(panelNorth,BorderLayout.NORTH);
		c.add(blank1,BorderLayout.EAST);
		c.add(blank2, BorderLayout.WEST);

		f.setSize(650,830);
		f.setResizable(false);
		f.setVisible(true);


	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==next) {
			if(count>0) {
				JOptionPane.showMessageDialog(f,"인원수만큼 선택하지 않았습니다.", "오류",JOptionPane.ERROR_MESSAGE);

			}
			else {
				p.Stop();
				new MovieLast(this.Old,this.Adult,this.Teen,seatname);
				f.setVisible(false);
			}
		}
		for(int i =0; i<seatnum.length; i++) {


			if(e.getSource() == seatbt[i] && state[i] == 0) {
				selected.setText("Working . . .");

				Thread worker = new Thread() {
					public void run() {
						try {
							Thread.sleep(500);
						} catch (InterruptedException ex) {
						}

						SwingUtilities.invokeLater(new Runnable() {
							public void run() {

								if(count>=0 ) {
									seatname.add(e.getActionCommand());
									selected.setText("선택한 자리 :"+seatname);

								}
								else if(count<0){
									seatname.remove(e.getActionCommand());
									selected.setText("선택한 자리 : "+seatname);
								}
							}
						});
					}
				};
				worker.start();

				seatbt[i].setBackground(col3);
				state[i] =1;

				count--;
				if(count<0) {
					JOptionPane.showMessageDialog(f, "인원수 초과", "인원초과", JOptionPane.ERROR_MESSAGE);
					seatbt[i].setBackground(Color.black);
					state[i]=0;
					count++;
				}

			}
			else if(e.getSource() == seatbt[i] && state[i] ==1)
			{System.out.println("선택 취소 : "+ e.getActionCommand());
				seatbt[i].setBackground(Color.black);
				state[i]=0;
				seatname.remove(e.getActionCommand());
				selected.setText("Working . . .");

				Thread worker = new Thread() {
					public void run() {
						try {
							Thread.sleep(500);
						} catch (InterruptedException ex) {
						}

						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								seatname.remove(e.getActionCommand());
								selected.setText("선택한 자리 : "+seatname);


							}
						});
					}
				};
				worker.start();

				System.out.println("선택 취소 : "+state[i]);
				count++;
			}
			else if(e.getSource() == seatbt[i] && state[i]==2) {
				JOptionPane.showMessageDialog(f, "선택 불가능한 자리입니다.", "오류", JOptionPane.ERROR_MESSAGE);

			}


		}

	}
}
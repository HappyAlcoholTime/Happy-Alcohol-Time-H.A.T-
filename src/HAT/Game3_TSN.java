package HAT;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game3_TSN extends JPanel {

	private JPanel gamePanel, prePanel; // 메인화면 패널, 이전 화면 패널
	TimerThread count;// 숫자 카운트를 위한 스레드 선언
	JLabel card = new JLabel();// 숫자 카운트를 보여줄 레이블 생성
	JButton start = new JButton("Start");// 시작 버튼 생성
	int n = 1;// 카운트 시작 할 숫자
	boolean singleClick = false;// 클릭 유무
	boolean doubleClick = false;// 더블클릭 유무
	private JLabel lblTitle, lblRule; // 제목과 범위
	private JButton btnBack;// 돌아가기버튼
	private buttonListener btnL; // 버튼 리스너

	public Game3_TSN(JFrame frame, JPanel selGamePanel) {

		prePanel = selGamePanel; // 이전화면 패널변수 초기화

		gamePanel = new JPanel(); // 메인패널 생성
		gamePanel.setBounds(0, 0, 500, 500);
		gamePanel.setLayout(null);// 메인패널의 레이아웃을 지움
		gamePanel.setBackground(Color.white);// 메인패널 뒷배경 설정
		frame.add(gamePanel); // 프레임에 패널 추가

		// 위에 제목
		lblTitle = new JLabel("3 6 9 게임");
		lblTitle.setBounds(50, 50, 400, 50);// 글자 위치 설정
		lblTitle.setFont(new Font("나눔손글씨 펜", Font.BOLD, 60));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER); // 수평 가운데 정렬
		gamePanel.add(lblTitle);

		//게임 규칙 설명
		lblRule = new JLabel("1 부터 100 까지의 숫자 중 3/6/9 가 있는 숫자 클릭 or 더블클릭");
		lblRule.setBounds(50, 250, 400, 80);
		lblRule.setFont(new Font("서울한강 장체B", Font.PLAIN, 16));
		lblRule.setHorizontalAlignment(SwingConstants.CENTER); // 가운데 정렬
		gamePanel.add(lblRule);

		btnL = new buttonListener(); // 버튼리스너 생성
		
		// 돌아가기 버튼 생성
		btnBack = new JButton("돌아가기");
		btnBack.setBounds(400, 470, 100, 30);
		btnBack.setFont(new Font("서울한강 장체B", Font.PLAIN, 14));
		btnBack.addActionListener(btnL); // 이벤트 리스너에 연결
		gamePanel.add(btnBack);// 메인패널에 삽입

		// 숫자 카운트를 보여줄 레이블을 패널에 추가
		card.setOpaque(true);
		card.setBackground(Color.yellow);
		card.setFont(new Font("궁서", Font.PLAIN, 50));
		card.setHorizontalAlignment(JLabel.CENTER);
		card.setText(Integer.toString(n));
		card.setSize(200, 100);
		card.setLocation(150, 140);
		card.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent me) {
			}// mouseClicked()

			public void mousePressed(MouseEvent me) {
				if (me.getClickCount() >= 2) {// 더블 클릭이상 했을 때 더블클릭으로 인식
					doubleClick = true;
					singleClick = false;
				} else if (me.getClickCount() == 1) {// 한번 클릭했을 때
					singleClick = true;
					doubleClick = false;
				} else {// 한번도 클릭을 안 했을 때
					singleClick = false;
					doubleClick = false;
				} // mousePressed()

				// 마우스를 눌렀을 때 레이블 객체의 소스를 얻어와 배경색을 오렌지로 설정
				JLabel card = (JLabel) me.getSource();
				card.setBackground(Color.orange);
			}

			public void mouseReleased(MouseEvent me) {
				// 마우스를 떼었을 때 레이블 객체의 소스를 얻어와 배경색을 노란색으로 설정
				JLabel card = (JLabel) me.getSource();
				card.setBackground(Color.yellow);
			}// mouseReleased()

			public void mouseEntered(MouseEvent me) {
			}// mouseEntered()

			public void mouseExited(MouseEvent me) {
			}// mouseExited()
		});
		gamePanel.add(card);

		// 시작버튼을 패널에 추가
		start.setLocation(175, 350);
		start.setSize(150, 80);
		start.setFont(new Font("서울한강 장체B", Font.PLAIN, 40));
		start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				// 버튼클릭시 초기설정과 스레드 객체 생성과 실행
				n = 1;

				card.setText(Integer.toString(n));
				singleClick = false;
				doubleClick = false;
				count = new TimerThread();
				count.start();

				// 게임 중에는 버튼 클릭을 못하게 함
				JButton b = (JButton) ae.getSource();
				b.setEnabled(false);
			} // actionPerformed()
		});
		gamePanel.add(start);

		frame.pack();
		frame.setVisible(true); // 프레임 보여줌

	} // Game3_TSN(frame,prePanel)

	synchronized void setSingleClicked(boolean b) {// 한번 클릭
		singleClick = b;
	}// setSingleClicked()

	synchronized void setDoubleClicked(boolean b) {// 더블 클릭
		doubleClick = b;
	} // setDoubleClicked()

	class TimerThread extends Thread {
		public void run() {
			while (true) {
				try {
					card.setBackground(Color.yellow);
					sleep(700);// 0.7초마다

					int d1 = n % 10;// 일의 자리
					int d2 = n / 10;// 십의 자리

					if ((d1 == 3 || d1 == 6 || d1 == 9) && (d2 == 3 || d2 == 6 || d2 == 9)) {// 더블클릭을 해야할 상황
						if (doubleClick == true) {// 성공시
							setDoubleClicked(false);
						} else if (singleClick == true || ((doubleClick == false) && (singleClick == false))) {// 더블클릭을
																												// 해야하는데
																												// 못할 시
																												// 실패
							card.setText("실패");
							card.setBackground(Color.red);
							break;
						}
					} else if (d1 == 3 || d1 == 6 || d1 == 9 || d2 == 3 || d2 == 6 || d2 == 9) {// 한번 클릭을 해야할 상황
						if (singleClick == true) {// 성공시
							setSingleClicked(false);
						} else if ((doubleClick == false) && (singleClick == false)) {// 한번 클릭을 해야하는데 못할 시 실패
							card.setText("실패");
							card.setBackground(Color.red);
							break;
						}
					} else {// 아무것도 클릭하지 말아야할 상황
						if (singleClick == true || doubleClick == true) {// 클릭시 실패
							card.setText("실패");
							card.setBackground(Color.red);
							break;
						}
					}

					n++;// 카운트 수 1씩 증가

					if (n == 100) {// 100까지 가면 승리
						card.setText("성공");
						break;
					} else {// 100 아래이면 계속 실행
						card.setText(Integer.toString(n));
					}
				} catch (Exception e) {
					return;
				} // try ... catch
			} // while()
			start.setEnabled(true);// 게임이 끝나면 버튼 활성화
		}// run()
	}// TimerThread class

	private class buttonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			Object b = e.getSource();
			if (b == btnBack) {
				gamePanel.setVisible(false);
				prePanel.setVisible(true);
			} // if

		}// actionPerformed()

	}// buttonListener class

} // Game3_TSN class

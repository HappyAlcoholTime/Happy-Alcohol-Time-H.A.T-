package HAT;

import javax.swing.*;


import java.awt.*;
import java.awt.event.*;

public class Game1_Sadari extends JPanel {

	private JPanel gamePanel, prePanel; // 메인 패널과 이전화면 패널 변수
	private SadariGamePanel sadariPanel; // 게임이 보여지는 패널
	private JLabel lblTitle; // 제목, 결과, 사람 수문자표시
	private JButton btnBack; // 돌아가기 버튼
	private buttonListener btnL; // 버튼 리스너

	public Game1_Sadari(JFrame frame, JPanel selGamePanel) {
		setPreferredSize(new Dimension(500, 500)); // 기본 패널크기 설정
		this.setBackground(Color.white); // 패널 색 설정
		this.setLayout(null); // 레이아웃 설정 없애기

		prePanel = selGamePanel; // 이전화면 패널변수 초기화

		gamePanel = new JPanel(); // 메인패널 생성
		gamePanel.setBounds(0, 0, 500, 500);
		gamePanel.setBackground(Color.white);// 패널 뒷배경 설정
		gamePanel.setLayout(null);// 패널의 레이아웃을 지움
		frame.add(gamePanel);// 프레임에 메인패널 추가

		sadariPanel = new SadariGamePanel(); // 게임이 실행되는 패널 생성
		sadariPanel.setBounds(25, 70, 450, 350); // 패널 위치 설정
		gamePanel.add(sadariPanel); // 메인패널에 사다리게임 실행 패널 삽입

		lblTitle = new JLabel("☆사다리 게임★"); // 사다리게임 글자 생성
		lblTitle.setBounds(50, 20, 400, 40); // 글자 위치 설정
		lblTitle.setFont(new Font("나눔손글씨 펜", Font.BOLD, 50)); // 글자 폰트 설정
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER); // 가운데 정렬
		gamePanel.add(lblTitle); // 메인패널에 삽입

		btnL = new buttonListener(); // 버튼리스너 생성

		btnBack = new JButton("돌아가기"); // 돌아가기 버튼 생성
		btnBack.setBounds(400, 470, 100, 30); // 위치 설정
		btnBack.setFont(new Font("서울한강 장체B", Font.PLAIN, 14)); // 폰트 설정
		btnBack.addActionListener(btnL); // 버튼 리스너에 연결
		gamePanel.add(btnBack); // 메인패널에 삽입

		frame.pack();
		frame.setVisible(true); // 프레임 보여줌
	}// Game1_Sadari(frame, prePanel)

	private class buttonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			Object b = e.getSource();

			if (b == btnBack) {
				gamePanel.setVisible(false);
				prePanel.setVisible(true);
			} // if

		}// actionPerformed()

	}// buttonListener class
} //Game1_Sadari class

package HAT;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Game2_Hunmin extends JPanel {

	private JPanel gamePanel, prePanel; // 전체화면 패널, 이전 화면 패널
	private JLabel lblTitle, lblTitle2, lblChange;
	private JButton btnBack, btnChange, btnTotal1, btnTotal2;
	// btnTotal1, btnTotal2 리스너 안에서는 JLabel을 사용할 수 없으므로 버튼으로 구현
	private buttonListener btnL; // 버튼 리스너
	private ImageIcon imgBack; // 배경이미지

	private char[] han = new char[] { 'ㄱ', 'ㄴ', 'ㄷ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅅ', 'ㅇ', 'ㅈ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ', 'ㄲ', 'ㅃ',
			'ㅆ', 'ㅉ', 'ㄸ' };// 한글 자음을 담아놓는 배열
	int num1, num2;// 랜덤한 수를 저장할 변수, 인덱스 변수로 쓰일 예정
	String total1, total2;// 자음을 저장할 변수

	public Game2_Hunmin(JFrame frame, JPanel selGamePanel) {

		prePanel = selGamePanel; // 이전화면 패널변수 초기화

		imgBack = new ImageIcon("images/배경1.png");

		gamePanel = new JPanel() {
			public void paintComponent(Graphics g) // 배경이미지 삽입
			{
				g.drawImage(imgBack.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}// paintComponent()
		};
		gamePanel.setBounds(0, 0, 500, 500);
		gamePanel.setLayout(null);// 메인패널의 레이아웃을 지움
		gamePanel.setBackground(Color.white);// 메인패널 뒷배경 설정
		frame.add(gamePanel); // 프레임에 패널 추가

		btnL = new buttonListener(); // 버튼리스너 생성

		// 글씨 삽입
		lblTitle = new JLabel("훈민정음 게임");
		lblTitle.setBounds(130, 10, 500, 80);
		lblTitle.setFont(new Font("나눔손글씨 펜", Font.BOLD, 60));
		lblTitle.setForeground(Color.white);
		gamePanel.add(lblTitle);// 삽입

		lblTitle2 = new JLabel("제시어");
		lblTitle2.setBounds(190, 100, 100, 50);
		lblTitle2.setFont(new Font("서울한강 장체B", Font.BOLD, 30));
		lblTitle2.setForeground(Color.white);
		gamePanel.add(lblTitle2);// 삽입

		lblChange = new JLabel("바꾸기");
		lblChange.setFont(new Font("서울한강 장체B", Font.BOLD, 14));
		lblChange.setBounds(400, 300, 50, 15);
		lblChange.setForeground(Color.white);
		gamePanel.add(lblChange);

		btnChange = new JButton(new ImageIcon("images/지우개.png")); // 바꾸기 버튼 생성
		btnChange.setBounds(380, 240, 100, 61); // 위치 설정

		btnChange.setForeground(Color.white);// 버튼 색 설정
		btnChange.setBorderPainted(false);// 버튼 외각선 제거
		btnChange.setOpaque(false);// 투명화
		btnChange.setContentAreaFilled(false);
		btnChange.setFocusPainted(false);
		gamePanel.add(btnChange);// 메인패널에 삽입

		Random generator = new Random();// 랜덤변수생성
		num1 = generator.nextInt(19); // 0~19까지
		num2 = generator.nextInt(19);// 0~19까지
		total1 = Character.toString(han[num1]);// han 배열에 있는 값을 스트링으로 저장
		total2 = Character.toString(han[num2]);// han 배열에 있는 값을 스트링으로 저장

		// 첫번쨰 초성 화면에 출력
		btnTotal1 = new JButton(total1);
		btnTotal1.setBounds(90, 155, 130, 100);
		btnTotal1.setFont(new Font("서울한강 장체B", Font.BOLD, 80));
		btnTotal1.setForeground(Color.white);
		btnTotal1.setBorderPainted(false);// 외각선 제거
		btnTotal1.setOpaque(false);// 투명하게
		btnTotal1.setContentAreaFilled(false);// 채우기 사용하지 않음
		btnTotal1.setFocusPainted(false);// 선택되었을 때 생기는 테두리 사용안함
		gamePanel.add(btnTotal1);

		// 두번쨰 초성 화면에 출력
		btnTotal2 = new JButton(total2);
		btnTotal2.setBounds(230, 155, 130, 100);
		btnTotal2.setFont(new Font("서울한강 장체B", Font.BOLD, 90));
		btnTotal2.setForeground(Color.white);
		btnTotal2.setBorderPainted(false);// 외각선제거
		btnTotal2.setOpaque(false);// 투명하게
		btnTotal2.setContentAreaFilled(false);// 채우기 x
		btnTotal2.setFocusPainted(false);// 선택되었을 때 생기는 테두리 사용안함
		gamePanel.add(btnTotal2);// 버튼추가

		// 돌아가기 버튼구현
		btnBack = new JButton("돌아가기"); // 돌아가기 버튼 생성
		btnBack.setBounds(400, 470, 100, 30); // 버튼 위치 설정
		btnBack.setFont(new Font("서울한강 장체B", Font.PLAIN, 14)); // 폰트 설정
		btnBack.addActionListener(btnL); // 이벤트 리스너에 연결
		gamePanel.add(btnBack); // 메인패널에 삽입

		// 바꾸기 버튼을클릭 하였을 때 발생하는 리스너
		ActionListener listener = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				btnTotal1.setVisible(false);// 이전출력값(버튼을 누르기전) 감추기
				btnTotal2.setVisible(false);// 이전출력값(버튼을 누르기전) 감추기

				// 랜덤한 초성2개를 생성하기 위한 과정
				Random generator = new Random();// 랜덤변수 생성
				num1 = generator.nextInt(19);// 0~19까지 랜덤한 수
				num2 = generator.nextInt(19);// 0~19까지 랜덤한 수
				total1 = Character.toString(han[num1]);// total1변수에 랜덤한 초성 저장
				total2 = Character.toString(han[num2]);// total2변수에 랜덤한 초성 저장

				// 첫번쨰 초성
				btnTotal1 = new JButton(total1);
				btnTotal1.setBounds(90, 155, 130, 100);
				btnTotal1.setFont(new Font("서울한강 장체B", Font.PLAIN, 80));
				btnTotal1.setForeground(Color.white);
				btnTotal1.setBorderPainted(false);// 외각선 제거
				btnTotal1.setOpaque(false);// 투명하게
				btnTotal1.setContentAreaFilled(false);// 채우기 사용하지 않음
				btnTotal1.setFocusPainted(false);// 선택되었을 때 생기는 테두리 사용안함
				gamePanel.add(btnTotal1);

				// 두번째 초성
				btnTotal2 = new JButton(total2);
				btnTotal2.setBounds(230, 155, 130, 100);
				btnTotal2.setFont(new Font("서울한강 장체B", Font.PLAIN, 90));
				btnTotal2.setForeground(Color.white);
				btnTotal2.setBorderPainted(false);// 외각선제거
				btnTotal2.setOpaque(false);// 투명하게
				btnTotal2.setContentAreaFilled(false);// 채우기 x
				btnTotal2.setFocusPainted(false);// 선택되었을 때 생기는 테두리 사용안함
				gamePanel.add(btnTotal2);

				btnTotal1.setVisible(true);// 바꾸기 버튼을 통해 바꾼값 출력
				btnTotal2.setVisible(true);// 바꾸기 버튼을 통해 바꾼값 출력

			} // actionPerformed()
		};
		btnChange.addActionListener(listener);// 바꾸기 버튼에 리스너 추가

		frame.pack();
		frame.setVisible(true); // 프레임 보여줌

	}// Game2_Hunmin(frame)

	// 돌아가기 버튼 구현
	private class buttonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			Object b = e.getSource();

			if (b == btnBack) {
				gamePanel.setVisible(false);
				prePanel.setVisible(true);
			} // if

		}// actionPerformed()

	}// buttonListener class

} // Game2_Humin class
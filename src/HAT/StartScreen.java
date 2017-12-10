package HAT;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StartScreen extends JFrame {

	private JFrame frame; // 프로그램 고정 프레임
	private JPanel startPanel; // 시작 화면 배경 패널
	private JLabel lblTitle; // 프로그램 제목
	private JButton btnAlcohol, btnGame;
	// 폭탄주 선택 화면과 술게임 선택 화면으로 변환하는 버튼

	private ImageIcon imgTitle; // 시작화면 상단 이미지
	private JLabel lblImg; // 이미지 들어갈 라벨

	private buttonListener btnL; // 버튼리스너 선언

	public StartScreen() {

		setTitle("H. A. T"); // 프레임 타이틀 지정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(515, 535));// 창 크기 설정
		setResizable(false); // 창크기고정
		setLayout(null); // 프레임 레이아웃 제거

		frame = this; // 프레임을 넘기기위한 변수 초기화

		startPanel = new JPanel();// 배경패널 생성
		startPanel.setBounds(0, 0, 500, 500); // 배경 패널의 위치, 크기 설정
		startPanel.setBackground(Color.white);// 패널 색상 설정
		startPanel.setLayout(null); // 패널 레이아웃 제거
		frame.add(startPanel); // 프레임에 배경패널 삽입

		imgTitle = new ImageIcon("images/트로피카나.gif"); // 타이틀 이미지 생성
		lblImg = new JLabel(imgTitle); // 이미지 보여줄 라벨 생성
		lblImg.setBounds(50, 50, 400, 200); // 라벨 위치 설정
		startPanel.add(lblImg); // 라벨을 배경패널에 삽입

		lblTitle = new JLabel("Happy Alcohol Time"); // 타이틀 라벨 생성
		lblTitle.setBounds(25, 150, 450, 300);
		lblTitle.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 45)); //라벨 글씨 폰트,크기 설정
		lblTitle.setForeground(Color.black);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER); // 수평 가운데 정렬
		startPanel.add(lblTitle);// 라벨을 배경패널에 삽입

		btnL = new buttonListener(); // 버튼리스너 생성

		btnAlcohol = new JButton(new ImageIcon("images/폭탄주버튼.png")); // 폭탄주 선택 화면으로 이동할 버튼 생성
		btnAlcohol.setBounds(100, 330, 100, 100); // 버튼 위치설정
		btnAlcohol.setBorderPainted(false);// 버튼 외각선제거
		btnAlcohol.setOpaque(false);// 버튼 투명하게
		btnAlcohol.setContentAreaFilled(false);// 버튼 채우기 x
		btnAlcohol.setFocusPainted(false);// 버튼 선택되었을 때 생기는 테두리 사용안함
		btnAlcohol.setEnabled(true); // 버튼 사용여부 설정
		btnAlcohol.addActionListener(btnL); // 버튼에 리스너 연결
		startPanel.add(btnAlcohol); // 버튼을 배경패널에 삽입

		btnGame = new JButton(new ImageIcon("images/술게임버튼.png"));// 술게임 선택 화면으로 이동할 버튼 생성
		btnGame.setBounds(300, 330, 100, 100);
		btnGame.setBorderPainted(false);
		btnGame.setOpaque(false);
		btnGame.setContentAreaFilled(false);
		btnGame.setFocusPainted(false);
		btnGame.setEnabled(true);
		btnGame.addActionListener(btnL);
		startPanel.add(btnGame); // 버튼을 배경패널에 삽입

		pack();
		setLocationRelativeTo(null);// 윈도우창 가운데에 뜨게 함.
		setVisible(true); //프레임 보여줌

	} // StartScreen()

	private class buttonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Object b = e.getSource();
			if (b == btnAlcohol) //폭탄주 선택 버튼 누르면 
			{
				startPanel.setVisible(false); //시작화면 패널 안보이게
				new SelectAlcohol(frame, startPanel); //폭탄주 선택 패널 생성
			} else if (b == btnGame) //술게임 선택 버튼 누르면
			{
				startPanel.setVisible(false); //시작화면 패널 안보이게
				new SelectGame(frame, startPanel); //술게임 선택 패널 생성
			}
		}// actionPerformed class
	}// buttonListener class
} // StartScreen()

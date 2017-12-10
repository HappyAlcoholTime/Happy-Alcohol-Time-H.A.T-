package HAT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bomb4_Sobaek extends JPanel {

	private JPanel bombPanel, prePanel; // 메인 패널과 이전화면 패널 변수

	private JLabel lblTitle, lblExplain; // 술 이름, 술 설명 라벨
	private JButton btnBack; // 돌아가기 버튼
	private buttonListener btnL; //버튼 리스너
	private ImageIcon imgBomb; // 폭탄주 이미지
	private JLabel lblImg; // 이미지 들어갈 라벨

	public Bomb4_Sobaek(JFrame frame, JPanel selAlcoholPanel) {
		
		prePanel = selAlcoholPanel; // 이전화면으로 돌아가기위한 변수 초기화

		bombPanel = new JPanel(); //메인패널 생성
		bombPanel.setBounds(0, 0, 500, 500);
		bombPanel.setLayout(null);// 메인패널의 레이아웃을 지움
		bombPanel.setBackground(Color.white);// 메인패널 뒷배경 설정
		frame.add(bombPanel); // 프레임에 메인패널 추가

		lblTitle = new JLabel("소백산맥"); // 소백산맥 글자 생성
		lblTitle.setBounds(50, 0, 400, 70); // 글자 위치 설정
		lblTitle.setFont(new Font("나눔손글씨 펜", Font.BOLD, 60)); // 글자 폰트 설정
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER); // 가운데 정렬
		bombPanel.add(lblTitle); // 메인패널에 삽입
		
		imgBomb = new ImageIcon("images/소백산맥주.png");
		lblImg = new JLabel(imgBomb);
		lblImg.setBounds(50, 80, 400, 300);
		bombPanel.add(lblImg); //메인패널에 삽입

		lblExplain = new JLabel("소주와 백세주와 산사춘과 맥주를 위 사진과 같이 섞는다."); // 술 제조법 설명 글자 생성
		lblExplain.setBounds(50, 400, 400, 40); // 글자 위치 설정
		lblExplain.setFont(new Font("서울한강 장체B", Font.PLAIN, 18)); // 글자 폰트 설정
		lblExplain.setHorizontalAlignment(SwingConstants.CENTER); // 가운데 정렬
		bombPanel.add(lblExplain); // 메인패널에 삽입
		
		btnL = new buttonListener(); // 버튼리스너 생성

		btnBack = new JButton("돌아가기"); // 돌아가기 버튼 생성
		btnBack.setBounds(400, 470, 100, 30); // 버튼 위치 설정
		btnBack.setFont(new Font("서울한강 장체B", Font.PLAIN, 14)); // 폰트 설정
		btnBack.addActionListener(btnL); //버튼리스너 연결
		bombPanel.add(btnBack); // 메인패널에 삽입
		
		frame.pack();
		frame.setVisible(true); // 프레임 보여줌
		
	}// Bomb4_Sobaek(frame, prePanel)
	
	private class buttonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Object b = e.getSource();
			if (b == btnBack) {
				bombPanel.setVisible(false);
				prePanel.setVisible(true);
			} //if
		}// actionPerformed()
	}// buttonListener class

}// Bomb4_Sobaek class

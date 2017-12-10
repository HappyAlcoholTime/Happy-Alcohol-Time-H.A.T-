package HAT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bomb6_Domino extends JPanel {

	private JPanel bombPanel, prePanel; // 메인화면 패널과 이전화면 패널 변수
	private JLabel lblTitle, lblExplain1, lblExplain2, lblExplain3, lblExplain4; // 사용자가 선택한 폭탄주 이름과 폭탄주 제조법 표시할 라벨
	private ImageIcon imgBomb; // 폭탄주 이미지
	private JLabel lblImg; // 이미지 들어갈 라벨
	private JButton btnBack;// 돌아가기버튼
	private buttonListener btnL; // 버튼 리스너

	public Bomb6_Domino(JFrame frame, JPanel selAlcoholPanel) {
		
		prePanel = selAlcoholPanel; // 이전화면으로 돌아가기위한 변수 초기화

		bombPanel = new JPanel(); //메인패널 생성
		bombPanel.setBounds(0, 0, 500, 500);
		bombPanel.setLayout(null);// 메인패널의 레이아웃을 지움
		bombPanel.setBackground(Color.white);// 메인패널 뒷배경 설정
		frame.add(bombPanel); // 프레임에 패널 추가

		lblTitle = new JLabel("도미노주");
		lblTitle.setBounds(50, 0, 400, 70);
		lblTitle.setFont(new Font("나눔손글씨 펜", Font.BOLD, 60));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER); // 수평 가운데 정렬
		bombPanel.add(lblTitle); // 메인패널에 삽입
		
		imgBomb = new ImageIcon("images/도미노주.png");
		lblImg = new JLabel(imgBomb);
		lblImg.setBounds(50, 80, 400, 300);
		bombPanel.add(lblImg); //메인패널에 삽입
		
		lblExplain1 = new JLabel("맥주잔을 인원수대로 잇대어 놓고 맥주를 따른다.");
		lblExplain1.setBounds(50, 385, 400, 30);
		lblExplain1.setFont(new Font("서울한강 장체B", Font.PLAIN, 16));
		lblExplain1.setForeground(Color.black);
		lblExplain1.setHorizontalAlignment(SwingConstants.CENTER); // 수평 가운데 정렬
		bombPanel.add(lblExplain1);
		
		lblExplain2 = new JLabel("잇대어 놓은 맥주잔과 잔 사이에 양주잔들을 얹은 후 양주를 따른다.");
		lblExplain2.setBounds(0, 405, 500, 30);
		lblExplain2.setFont(new Font("서울한강 장체B", Font.PLAIN, 16));
		lblExplain2.setForeground(Color.black);
		lblExplain2.setHorizontalAlignment(SwingConstants.CENTER); // 수평 가운데 정렬
		bombPanel.add(lblExplain2);

		lblExplain3 = new JLabel("첫 번째 양주잔을 손가락으로 살짝 밀치면 도미노 게임처럼");
		lblExplain3.setBounds(50, 425, 400, 30);
		lblExplain3.setFont(new Font("서울한강 장체B", Font.PLAIN, 16));
		lblExplain3.setForeground(Color.black);
		lblExplain3.setHorizontalAlignment(SwingConstants.CENTER); // 수평 가운데 정렬
		bombPanel.add(lblExplain3);
		
		lblExplain4 = new JLabel("모든 양주잔이 각각 다음 맥주잔에 퐁당퐁당 빠지게 된다.");
		lblExplain4.setBounds(50, 445, 400, 30);
		lblExplain4.setFont(new Font("서울한강 장체B", Font.PLAIN, 16));
		lblExplain4.setForeground(Color.black);
		lblExplain4.setHorizontalAlignment(SwingConstants.CENTER); // 수평 가운데 정렬
		bombPanel.add(lblExplain4);

		btnL = new buttonListener(); // 버튼리스너 생성
		
		btnBack = new JButton("돌아가기"); // 돌아가기 버튼 생성
		btnBack.setBounds(400, 470, 100, 30); // 버튼 위치 설정
		btnBack.setFont(new Font("서울한강 장체B", Font.PLAIN, 14)); // 폰트 설정
		btnBack.setEnabled(true);
		btnBack.addActionListener(btnL); // 버튼 리스너에 연결
		bombPanel.add(btnBack); // 메인패널에 삽입
		
		frame.pack();
		frame.getContentPane().add(bombPanel); // 프레임에 패널 추가(패널 setVisible 느낌)
		frame.setVisible(true); // 프레임 보여줌
	}// Bomb6_Domino(frame, prePanel)
	
	private class buttonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Object b = e.getSource();
			if (b == btnBack) {
				bombPanel.setVisible(false);
				prePanel.setVisible(true);
			} //if
		}// actionPerformed()
	}// buttonListener class
	
}// Bomb6_Domino class

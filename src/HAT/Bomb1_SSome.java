package HAT;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Bomb1_SSome extends JPanel {
	
	private JPanel bombPanel, prePanel; // 현재화면 패널과 이전화면 패널 변수

	private JLabel lblTitle, lblExplain; // 사용자가 선택한 폭탄주 이름과 폭탄주 제조법 표시할 라벨
	private ImageIcon imgBomb; // 폭탄주 이미지
	private JLabel lblImg; // 이미지 들어갈 라벨
	private JButton btnBack; // 돌아가기 버튼
	private buttonListener btnL; //버튼 리스너

	public Bomb1_SSome(JFrame frame, JPanel selAlcoholPanel) {
		
		prePanel = selAlcoholPanel; // 이전화면으로 돌아가기위한 변수 초기화

		bombPanel = new JPanel(); //메인패널 생성
		bombPanel.setBounds(0, 0, 500, 500);
		bombPanel.setBackground(Color.white);// 패널 뒷배경 설정
		bombPanel.setLayout(null);// 패널의 레이아웃을 지움
		frame.add(bombPanel);//프레임에 패널 추가

		lblTitle = new JLabel("쏘메리카노");
		lblTitle.setBounds(50, 0, 400, 70);// 글자 위치 설정
		lblTitle.setFont(new Font("나눔손글씨 펜", Font.BOLD, 60));
		lblTitle.setForeground(Color.black);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER); // 수평 가운데 정렬
		bombPanel.add(lblTitle);

		imgBomb = new ImageIcon("images/쏘메리카노.png");
		lblImg = new JLabel(imgBomb);
		lblImg.setBounds(50, 80, 400, 300);
		bombPanel.add(lblImg); //메인패널에 삽입
		
		lblExplain = new JLabel("맥주잔에 소주1~2잔과 (캔)커피를 섞는다.");
		lblExplain.setBounds(50, 400, 400, 40); // 글자 위치 설정
		lblExplain.setFont(new Font("서울한강 장체B", Font.PLAIN, 18));
		lblExplain.setForeground(Color.black);
		lblExplain.setHorizontalAlignment(SwingConstants.CENTER); // 수평 가운데 정렬
		bombPanel.add(lblExplain);

		btnL = new buttonListener(); // 버튼리스너 생성
		
		btnBack = new JButton("돌아가기"); // 돌아가기 버튼 생성
		btnBack.setBounds(400, 470, 100, 30); // 버튼 위치 설정
		btnBack.setFont(new Font("서울한강 장체B", Font.PLAIN, 14)); // 폰트 설정
		btnBack.addActionListener(btnL); // 버튼 리스너에 연결
		bombPanel.add(btnBack); // 기본패널에 삽입
		
		frame.pack();
		frame.setVisible(true); // 프레임 보여줌

	}//Bomb1_SSome(frame, prePanel)
	
	private class buttonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Object b = e.getSource();
			if (b == btnBack) {
				bombPanel.setVisible(false);
				prePanel.setVisible(true);
			} //if
		}// actionPerformed()
	}// buttonListener class

}//Bomb1_SSome class

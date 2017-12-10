package HAT;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Bomb3_Gojin extends JPanel {

	private JPanel bombPanel, prePanel; // 현재화면 패널과 이전화면 패널 변수

	private JLabel lblTitle, lblExplain1, lblExplain2, lblExplain3; // 사용자가 선택한 폭탄주 이름과 폭탄주 제조법 표시할 라벨
	private ImageIcon imgBomb; // 폭탄주 이미지
	private JLabel lblImg; // 이미지 들어갈 라벨
	private JButton btnBack; // 돌아가기 버튼
	private buttonListener btnL; //버튼 리스너

	public Bomb3_Gojin(JFrame frame, JPanel selAlcoholPanel) {

		prePanel = selAlcoholPanel; // 이전화면으로 돌아가기위한 변수 초기화

		bombPanel = new JPanel();
		bombPanel.setBounds(0, 0, 500, 500);
		bombPanel.setBackground(Color.white);// 패널 뒷배경 설정
		bombPanel.setLayout(null);// 패널의 레이아웃을 지움
		frame.add(bombPanel); // 프레임에 패널 추가

		lblTitle = new JLabel("고진감래");
		lblTitle.setBounds(50, 0, 400, 70);// 글자 위치 설정
		lblTitle.setFont(new Font("나눔손글씨 펜", Font.BOLD, 60));
		lblTitle.setForeground(Color.black);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER); // 수평 가운데 정렬
		bombPanel.add(lblTitle);//메인패널에 삽입
		
		imgBomb = new ImageIcon("images/고진감래주.png");
		lblImg = new JLabel(imgBomb);
		lblImg.setBounds(50, 80, 400, 300);
		bombPanel.add(lblImg); //메인패널에 삽입

		lblExplain1 = new JLabel("콜라를 1/3 정도 넣은 소주잔 1개를 맥주잔에 넣고,");
		lblExplain1.setBounds(50, 390, 400, 40);
		lblExplain1.setFont(new Font("서울한강 장체B", Font.PLAIN, 18));
		lblExplain1.setForeground(Color.black);
		lblExplain1.setHorizontalAlignment(SwingConstants.CENTER); // 수평 가운데 정렬
		bombPanel.add(lblExplain1);
		
		lblExplain2 = new JLabel("다른 소주잔을 위에 포개어 소주를 채워 넣는다.");
		lblExplain2.setBounds(50, 420, 400, 40);
		lblExplain2.setFont(new Font("서울한강 장체B", Font.PLAIN, 18));
		lblExplain2.setForeground(Color.black);
		lblExplain2.setHorizontalAlignment(SwingConstants.CENTER); // 수평 가운데 정렬
		bombPanel.add(lblExplain2);

		lblExplain3 = new JLabel("그 위에 맥주를 조심스럽게 붓는다.");
		lblExplain3.setBounds(50, 450, 400, 40);
		lblExplain3.setFont(new Font("서울한강 장체B", Font.PLAIN, 18));
		lblExplain3.setForeground(Color.black);
		lblExplain3.setHorizontalAlignment(SwingConstants.CENTER); // 수평 가운데 정렬
		bombPanel.add(lblExplain3);

		
		btnL = new buttonListener(); // 버튼리스너 생성

		btnBack = new JButton("돌아가기"); // 돌아가기 버튼 생성
		btnBack.setBounds(400, 470, 100, 30); // 버튼 위치 설정
		btnBack.setFont(new Font("서울한강 장체B", Font.PLAIN, 14)); // 폰트 설정
		btnBack.addActionListener(btnL); // 이벤트 리스너에 연결
		bombPanel.add(btnBack); // 기본패널에 삽입

		frame.pack();
		frame.setVisible(true); // 프레임 보여줌

	}// Bomb3_Gojin(frame, prePanel)

	private class buttonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Object b = e.getSource();
			if (b == btnBack) {
				bombPanel.setVisible(false);
				prePanel.setVisible(true);
			} // if
		}// actionPerformed()
	}// buttonListener class

}// Bomb3_Gojin class

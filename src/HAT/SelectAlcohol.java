package HAT;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SelectAlcohol extends JPanel {

	private JFrame frame; // 고정 프레임 넘기기위한 변수
	private JPanel selAlcoholPanel, prePanel; // 현재화면 배경패널과 이전화면 배경 패널 변수
	private JLabel lblNow; // 현재 화면 안내 라벨
	private JButton btnBomb1, btnBomb2, btnBomb3, btnBomb4, btnBomb5, btnBomb6;
	// 사용자가 원하는 폭탄주 소개 화면으로 이동하고자 할때 누르는 버튼들
	private JButton btnBack; // 돌아가기 버튼
	private buttonListener btnL; // 버튼 리스너

	public SelectAlcohol(JFrame frame, JPanel startPanel) {

		this.frame = frame; // 다음 화면에 넘기기위한 프레임 변수 초기화

		prePanel = startPanel; // 이전화면으로 돌아가기위한 변수 초기화

		selAlcoholPanel = new JPanel(); // 배경패널 생성
		selAlcoholPanel.setBounds(0, 0, 500, 500);
		selAlcoholPanel.setBackground(Color.white);
		selAlcoholPanel.setLayout(null);// 패널의 레이아웃을 지움
		this.frame.add(selAlcoholPanel); // 폭탄주선택 패널을 프레임에 삽입

		lblNow = new JLabel("폭탄주 선택"); // 현재 화면 안내 라벨 생성
		lblNow.setBounds(50, 50, 400, 100);
		lblNow.setFont(new Font("나눔손글씨 펜", Font.BOLD, 60));
		lblNow.setForeground(Color.black);
		lblNow.setHorizontalAlignment(SwingConstants.CENTER); // 수평 가운데 정렬
		selAlcoholPanel.add(lblNow); // 라벨을 배경패널에 삽입

		btnL = new buttonListener(); // 버튼리스너 생성

		btnBomb1 = new JButton("쏘메리카노"); // 폭탄주1 버튼 생성
		btnBomb1.setBounds(80, 190, 140, 40);
		btnBomb1.setFont(new Font("서울한강 장체B", Font.PLAIN, 20)); // 버튼 글씨 폰트,크기 설정
		btnBomb1.setBackground(Color.gray);// 버튼 배경색
		btnBomb1.setForeground(Color.white);// 버튼 전경색
		btnBomb1.setEnabled(true); // 버튼 사용 여부 설정
		btnBomb1.addActionListener(btnL); //버튼리스너 연결
		selAlcoholPanel.add(btnBomb1); // 폭탄주1 버튼을 배경패널에 삽입

		btnBomb2 = new JButton("스크류키스");// 폭탄주2 버튼 생성
		btnBomb2.setBounds(80, 280, 140, 40);
		btnBomb2.setFont(new Font("서울한강 장체B", Font.PLAIN, 20));
		btnBomb2.setBackground(Color.gray);
		btnBomb2.setForeground(Color.white);
		btnBomb2.setEnabled(true);
		btnBomb2.addActionListener(btnL);
		selAlcoholPanel.add(btnBomb2);// 폭탄주2 버튼을 배경패널에 삽입

		btnBomb3 = new JButton("고진감래");// 폭탄주3 버튼 생성
		btnBomb3.setBounds(90, 370, 120, 40);
		btnBomb3.setFont(new Font("서울한강 장체B", Font.PLAIN, 20));
		btnBomb3.setBackground(Color.gray);
		btnBomb3.setForeground(Color.white);
		btnBomb3.setEnabled(true);
		btnBomb3.addActionListener(btnL);
		selAlcoholPanel.add(btnBomb3);// 폭탄주3 버튼을 배경패널에 삽입

		btnBomb4 = new JButton("소백산맥");// 폭탄주4 버튼 생성
		btnBomb4.setBounds(300, 190, 120, 40);
		btnBomb4.setFont(new Font("서울한강 장체B", Font.PLAIN, 20));
		btnBomb4.setBackground(Color.gray);
		btnBomb4.setForeground(Color.white);
		btnBomb4.setEnabled(true);
		btnBomb4.addActionListener(btnL);
		selAlcoholPanel.add(btnBomb4);// 폭탄주4 버튼을 배경패널에 삽입

		btnBomb5 = new JButton("금테주");// 폭탄주5 버튼 생성
		btnBomb5.setBounds(310, 280, 100, 40);
		btnBomb5.setFont(new Font("서울한강 장체B", Font.PLAIN, 20));
		btnBomb5.setBackground(Color.gray);
		btnBomb5.setForeground(Color.white);
		btnBomb5.setEnabled(true);
		btnBomb5.addActionListener(btnL);
		selAlcoholPanel.add(btnBomb5);// 폭탄주5 버튼을 배경패널에 삽입

		btnBomb6 = new JButton("도미노주");// 폭탄주6 버튼 생성
		btnBomb6.setBounds(300, 370, 120, 40);
		btnBomb6.setFont(new Font("서울한강 장체B", Font.PLAIN, 20));
		btnBomb6.setBackground(Color.gray);
		btnBomb6.setForeground(Color.white);
		btnBomb6.setEnabled(true);
		btnBomb6.addActionListener(btnL);
		selAlcoholPanel.add(btnBomb6);// 폭탄주6 버튼을 배경패널에 삽입

		btnBack = new JButton("돌아가기"); // 돌아가기 버튼 생성
		btnBack.setBounds(400, 470, 100, 30); // 버튼 위치 설정
		btnBack.setFont(new Font("서울한강 장체B", Font.PLAIN, 14));
		btnBack.setEnabled(true);
		btnBack.addActionListener(btnL);
		selAlcoholPanel.add(btnBack); // 돌아가는 버튼을 배경패널에 삽입

		this.frame.pack();
		this.frame.setVisible(true); // 프레임 보여줌

	}// SelectAlcohol(frame,prePanel)

	private class buttonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Object b = e.getSource();

			if (b == btnBomb1) // 폭탄주1 버튼 누르면
			{
				selAlcoholPanel.setVisible(false); // 폭탄주 선택 패널 안보이게
				new Bomb1_SSome(frame, selAlcoholPanel); // 폭탄주1 쏘메리카노 패널 생성
			} else if (b == btnBomb2)// 폭탄주2 버튼 누르면
			{
				selAlcoholPanel.setVisible(false);
				new Bomb2_Screw(frame, selAlcoholPanel);
			} else if (b == btnBomb3)// 폭탄주3 버튼 누르면
			{
				selAlcoholPanel.setVisible(false);
				new Bomb3_Gojin(frame, selAlcoholPanel);
			} else if (b == btnBomb4)// 폭탄주4 버튼 누르면
			{
				selAlcoholPanel.setVisible(false);
				new Bomb4_Sobaek(frame, selAlcoholPanel);
			} else if (b == btnBomb5)// 폭탄주5 버튼 누르면
			{
				selAlcoholPanel.setVisible(false);
				new Bomb5_GeumTe(frame, selAlcoholPanel);
			} else if (b == btnBomb6)// 폭탄주6 버튼 누르면
			{
				selAlcoholPanel.setVisible(false); 
				new Bomb6_Domino(frame, selAlcoholPanel);
			} else if (b == btnBack) // 돌아가기 버튼 누르면
			{
				selAlcoholPanel.setVisible(false); // 폭탄주 선택 패널 안보이게
				prePanel.setVisible(true);// 이전패널(여기서는 시작화면패널) 보이게 설정
			} // if ... else if
		}// actionPerformed()
	}// buttonListener class

}// SelectAlcohol class

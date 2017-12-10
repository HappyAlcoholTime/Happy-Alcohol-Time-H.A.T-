package HAT;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SelectGame extends JPanel {

	private JFrame frame;// 고정 프레임 넘기기위한 변수
	private JPanel selGamePanel, prePanel; // 현재화면 패널과 이전화면 배경 패널 변수
	private JLabel lblNow; // 현재 화면 안내 라벨
	private JButton bntSadari, btnHunmin, btnTsn;
	// 사용자가 원하는 게임 실행 화면으로 이동하고자 할때 누르는 버튼들
	private JButton btnBack; // 돌아가기 버튼
	private buttonListener btnL; // 버튼리스너

	public SelectGame(JFrame frame, JPanel startPanel) {

		this.frame = frame;// 다음 화면에 넘기기위한 프레임 변수 초기화

		prePanel = startPanel; // 이전화면으로 돌아가기위한 변수 초기화

		selGamePanel = new JPanel();// 배경패널 생성
		selGamePanel.setBounds(0, 0, 500, 500);
		selGamePanel.setBackground(Color.white);
		selGamePanel.setLayout(null);// 패널의 레이아웃을 지움
		this.frame.add(selGamePanel); // 술게임선택 패널을 프레임에 삽입

		lblNow = new JLabel("술게임");// 현재 화면 안내 라벨 생성
		lblNow.setBounds(50, 50, 400, 100);
		lblNow.setFont(new Font("나눔손글씨 펜", Font.BOLD, 60));
		lblNow.setForeground(Color.black);
		lblNow.setHorizontalAlignment(SwingConstants.CENTER); // 수평 가운데 정렬
		selGamePanel.add(lblNow);// 라벨을 배경패널에 삽입

		btnL = new buttonListener(); // 버튼리스너 생성

		bntSadari = new JButton("사다리게임"); //게임선택1 버튼 생성
		bntSadari.setBounds(180, 190, 140, 40);
		bntSadari.setFont(new Font("서울한강 장체B", Font.PLAIN, 20));
		bntSadari.setBackground(Color.gray);// 버튼 배경색
		bntSadari.setForeground(Color.white);// 버튼 전경색
		bntSadari.setEnabled(true);// 버튼 사용 여부 설정
		bntSadari.addActionListener(btnL);
		selGamePanel.add(bntSadari); // 게임선택1 버튼을 배경패널에 삽입

		btnHunmin = new JButton("훈민정음");//게임선택2 버튼 생성
		btnHunmin.setBounds(190, 280, 120, 40);
		btnHunmin.setFont(new Font("서울한강 장체B", Font.PLAIN, 20));
		btnHunmin.setBackground(Color.gray);
		btnHunmin.setForeground(Color.white);
		btnHunmin.setEnabled(true);
		btnHunmin.addActionListener(btnL);
		selGamePanel.add(btnHunmin);// 게임선택2 버튼을 배경패널에 삽입

		btnTsn = new JButton("3 6 9 게임");
		btnTsn.setBounds(180, 370, 140, 40);
		btnTsn.setFont(new Font("서울한강 장체B", Font.PLAIN, 20));
		btnTsn.setBackground(Color.gray);
		btnTsn.setForeground(Color.white);
		btnTsn.setEnabled(true);
		btnTsn.addActionListener(btnL);
		selGamePanel.add(btnTsn);// 게임선택3 버튼을 배경패널에 삽입

		btnBack = new JButton("돌아가기"); // 돌아가기 버튼 생성
		btnBack.setBounds(400, 470, 100, 30); // 버튼 위치 설정
		btnBack.setFont(new Font("서울한강 장체B", Font.PLAIN, 14)); // 폰트 설정
		btnBack.setEnabled(true);
		btnBack.addActionListener(btnL);
		selGamePanel.add(btnBack);// 돌아가기 버튼을 배경패널에 삽입

		this.frame.pack();
		this.frame.setVisible(true); // 프레임 보여줌

	}// SelectGame(frame, prePanel)

	private class buttonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Object b = e.getSource();

			if (b == bntSadari)
			{
				selGamePanel.setVisible(false);
				new Game1_Sadari(frame, selGamePanel);
			} else if (b == btnHunmin)
			{
				selGamePanel.setVisible(false);
				new Game2_Hunmin(frame, selGamePanel);
			} else if (b == btnTsn)
			{
				selGamePanel.setVisible(false);
				new Game3_TSN(frame, selGamePanel);
			} else if (b == btnBack) // 돌아가기 버튼 누르면
			{
				selGamePanel.setVisible(false); //술게임 선택 패널 안보이게
				prePanel.setVisible(true);// 이전패널(여기서는 시작화면패널) 보이게 설정
			} // if ... else if
		}// actionPerformed()
	}// buttonListener class
}// SelctGame class

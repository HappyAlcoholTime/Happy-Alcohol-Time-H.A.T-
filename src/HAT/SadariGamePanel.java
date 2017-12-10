package HAT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SadariGamePanel extends JPanel {

	private JLabel		 lblPeople, lblQuestion ; // 게임패널 내 게임설명 라벨
	private JTextField	 txtInput;	// 입력창
	
	private resetButtonListener resetButtonL; // 버튼리스너

	public static final int INIT = 1; //사다리 상태 : 처음 그려지고
	public static final int RESULT = 2; // 사다리 상태 : 결과값 보여주기
	
	public static final int paddingX = 50; // 사다리 위치 가로
	public static final int paddingY = 70; // 사다리 위치 세로
	
	public static final int termX = 70; // 사다리 크기설정 가로
	public static final int lengthY = 230; // 사다리 크기 설정 세로
	public static final int lineLength = 5; // 숫자랑 사다리 사이 세로간격
	
	public static final int countBridge = 8; // 사다리 발판 갯수
	
	private int member = 0; // 사다리 탈 인원 설정
	private boolean isStart = false; // 사다리 상태설정
	


public SadariGamePanel() // 생성자
{

	this.setPreferredSize(new Dimension(450,300));
	this.setBackground(Color.pink);
	this.setLayout(null);
	
	//메인 게임패널 사이즈설정 ( 핑크색 부분 )
	
	resetButtonL = new resetButtonListener(); // 리스너 생성

	lblPeople = new JLabel("명(2~6인용)"); // 명 글자 생성
	lblPeople.setBounds(245, 10, 200, 40); // 글자 위치 설정
	lblPeople.setFont(new Font("서울한강 장체B",Font.PLAIN,20)); // 글자 폰트 설정
	lblPeople.setHorizontalAlignment(SwingConstants.CENTER); // 가운데 정렬
	add(lblPeople); // 메인패널에 삽입
	
	lblQuestion = new JLabel("인원 수 설정하기☞"); // 인원수 설정하기 글자 생성
	lblQuestion.setBounds(100, 10, 200, 40); // 글자 위치 설정
	lblQuestion.setFont(new Font("서울한강 장체B",Font.PLAIN,20)); // 글자 폰트 설정
	lblQuestion.setHorizontalAlignment(SwingConstants.LEFT); // 왼쪽 정렬
	add(lblQuestion); // 메인패널에 삽입
	
	txtInput = new JTextField(); // 인원수 입력창 생성
	txtInput.setBounds(240, 10, 50, 40); // 위치 설정
	txtInput.addActionListener(resetButtonL); // 이벤트 리스너에 연결
	add(txtInput); // 메인패널에 삽입
	
	
}


class resetButtonListener implements ActionListener
{
	public void actionPerformed(ActionEvent event)
	{
		member = Integer.parseInt(txtInput.getText()); // 인원 수 입력받기
		txtInput.setText("");//입력값초기화
		if(member>1&&member<7) // 2~6사이일경우
		{
			isStart = true; // 사다리게임시작
			repaint(); // 그리기
		}
		else //인원수 설정 잘못된경우
		{
			JOptionPane.showMessageDialog(txtInput, "2에서 6사이 값을 입력해주세요.");
		} //경고창 안내
		
	}
	
}

public void paintComponent(Graphics g)
{
	super.paintComponent(g);
	
	if(isStart) // 사다리 시작한경우 
	{
		drawSadari(g); // 사다리 그리기
	}
}

private void drawSadari(Graphics g)
{
		g.setColor(Color.BLACK); // 사다리 색 설정
		String[] loto = {"","","","","",""}; // 사다리 결과 
		loto[(int)(Math.random() * member)] = "당첨^^"; // 랜덤으로 한군데 당첨 설정
		
		for(int i=0;i<member;i++) // 멤버 수만큼 사다리의 다리 그리기
		{		

			g.setFont(new Font("서울한강 장체B",Font.BOLD,25));
			g.drawString(""+(i+1), paddingX+i*termX-5, paddingY); // 참여인원 숫자 쓰기
			g.drawLine(paddingX+i*termX, paddingY+lineLength, paddingX+i*termX, paddingY+lineLength+lengthY);
			// 사다리 세로 그리기
			g.drawString(loto[i], paddingX+(i*termX)-35, paddingY+lineLength+lengthY+lineLength*2+20);
			// 사다리 결과 쓰기 (당첨)
		}
		
		for(int i=0;i<countBridge;i++) // 발판 갯수만큼 사다리발판 그리기
		{
			int rdX = (int)(Math.random()*(member-1)); // 가로에 그릴 사다리 위치설정
			int rdY = (int)(Math.random()*(lengthY-lineLength)); //세로에 그릴 사다리 위치 설정
			
			g.drawLine(paddingX+rdX*termX, paddingY+rdY+lineLength+1, paddingX+rdX*termX+termX, paddingY+rdY+lineLength+1);
			//사다리 발판 그리기
		}
	}
}




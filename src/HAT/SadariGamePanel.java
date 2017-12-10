package HAT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SadariGamePanel extends JPanel {

	private JLabel		 lblPeople, lblQuestion ; // �����г� �� ���Ӽ��� ��
	private JTextField	 txtInput;	// �Է�â
	
	private resetButtonListener resetButtonL; // ��ư������

	public static final int INIT = 1; //��ٸ� ���� : ó�� �׷�����
	public static final int RESULT = 2; // ��ٸ� ���� : ����� �����ֱ�
	
	public static final int paddingX = 50; // ��ٸ� ��ġ ����
	public static final int paddingY = 70; // ��ٸ� ��ġ ����
	
	public static final int termX = 70; // ��ٸ� ũ�⼳�� ����
	public static final int lengthY = 230; // ��ٸ� ũ�� ���� ����
	public static final int lineLength = 5; // ���ڶ� ��ٸ� ���� ���ΰ���
	
	public static final int countBridge = 8; // ��ٸ� ���� ����
	
	private int member = 0; // ��ٸ� Ż �ο� ����
	private boolean isStart = false; // ��ٸ� ���¼���
	


public SadariGamePanel() // ������
{

	this.setPreferredSize(new Dimension(450,300));
	this.setBackground(Color.pink);
	this.setLayout(null);
	
	//���� �����г� ������� ( ��ũ�� �κ� )
	
	resetButtonL = new resetButtonListener(); // ������ ����

	lblPeople = new JLabel("��(2~6�ο�)"); // �� ���� ����
	lblPeople.setBounds(245, 10, 200, 40); // ���� ��ġ ����
	lblPeople.setFont(new Font("�����Ѱ� ��üB",Font.PLAIN,20)); // ���� ��Ʈ ����
	lblPeople.setHorizontalAlignment(SwingConstants.CENTER); // ��� ����
	add(lblPeople); // �����гο� ����
	
	lblQuestion = new JLabel("�ο� �� �����ϱ��"); // �ο��� �����ϱ� ���� ����
	lblQuestion.setBounds(100, 10, 200, 40); // ���� ��ġ ����
	lblQuestion.setFont(new Font("�����Ѱ� ��üB",Font.PLAIN,20)); // ���� ��Ʈ ����
	lblQuestion.setHorizontalAlignment(SwingConstants.LEFT); // ���� ����
	add(lblQuestion); // �����гο� ����
	
	txtInput = new JTextField(); // �ο��� �Է�â ����
	txtInput.setBounds(240, 10, 50, 40); // ��ġ ����
	txtInput.addActionListener(resetButtonL); // �̺�Ʈ �����ʿ� ����
	add(txtInput); // �����гο� ����
	
	
}


class resetButtonListener implements ActionListener
{
	public void actionPerformed(ActionEvent event)
	{
		member = Integer.parseInt(txtInput.getText()); // �ο� �� �Է¹ޱ�
		txtInput.setText("");//�Է°��ʱ�ȭ
		if(member>1&&member<7) // 2~6�����ϰ��
		{
			isStart = true; // ��ٸ����ӽ���
			repaint(); // �׸���
		}
		else //�ο��� ���� �߸��Ȱ��
		{
			JOptionPane.showMessageDialog(txtInput, "2���� 6���� ���� �Է����ּ���.");
		} //���â �ȳ�
		
	}
	
}

public void paintComponent(Graphics g)
{
	super.paintComponent(g);
	
	if(isStart) // ��ٸ� �����Ѱ�� 
	{
		drawSadari(g); // ��ٸ� �׸���
	}
}

private void drawSadari(Graphics g)
{
		g.setColor(Color.BLACK); // ��ٸ� �� ����
		String[] loto = {"","","","","",""}; // ��ٸ� ��� 
		loto[(int)(Math.random() * member)] = "��÷^^"; // �������� �ѱ��� ��÷ ����
		
		for(int i=0;i<member;i++) // ��� ����ŭ ��ٸ��� �ٸ� �׸���
		{		

			g.setFont(new Font("�����Ѱ� ��üB",Font.BOLD,25));
			g.drawString(""+(i+1), paddingX+i*termX-5, paddingY); // �����ο� ���� ����
			g.drawLine(paddingX+i*termX, paddingY+lineLength, paddingX+i*termX, paddingY+lineLength+lengthY);
			// ��ٸ� ���� �׸���
			g.drawString(loto[i], paddingX+(i*termX)-35, paddingY+lineLength+lengthY+lineLength*2+20);
			// ��ٸ� ��� ���� (��÷)
		}
		
		for(int i=0;i<countBridge;i++) // ���� ������ŭ ��ٸ����� �׸���
		{
			int rdX = (int)(Math.random()*(member-1)); // ���ο� �׸� ��ٸ� ��ġ����
			int rdY = (int)(Math.random()*(lengthY-lineLength)); //���ο� �׸� ��ٸ� ��ġ ����
			
			g.drawLine(paddingX+rdX*termX, paddingY+rdY+lineLength+1, paddingX+rdX*termX+termX, paddingY+rdY+lineLength+1);
			//��ٸ� ���� �׸���
		}
	}
}




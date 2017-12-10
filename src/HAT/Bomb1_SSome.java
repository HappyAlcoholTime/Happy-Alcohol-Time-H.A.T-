package HAT;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Bomb1_SSome extends JPanel {
	
	private JPanel bombPanel, prePanel; // ����ȭ�� �гΰ� ����ȭ�� �г� ����

	private JLabel lblTitle, lblExplain; // ����ڰ� ������ ��ź�� �̸��� ��ź�� ������ ǥ���� ��
	private ImageIcon imgBomb; // ��ź�� �̹���
	private JLabel lblImg; // �̹��� �� ��
	private JButton btnBack; // ���ư��� ��ư
	private buttonListener btnL; //��ư ������

	public Bomb1_SSome(JFrame frame, JPanel selAlcoholPanel) {
		
		prePanel = selAlcoholPanel; // ����ȭ������ ���ư������� ���� �ʱ�ȭ

		bombPanel = new JPanel(); //�����г� ����
		bombPanel.setBounds(0, 0, 500, 500);
		bombPanel.setBackground(Color.white);// �г� �޹�� ����
		bombPanel.setLayout(null);// �г��� ���̾ƿ��� ����
		frame.add(bombPanel);//�����ӿ� �г� �߰�

		lblTitle = new JLabel("��޸�ī��");
		lblTitle.setBounds(50, 0, 400, 70);// ���� ��ġ ����
		lblTitle.setFont(new Font("�����ձ۾� ��", Font.BOLD, 60));
		lblTitle.setForeground(Color.black);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER); // ���� ��� ����
		bombPanel.add(lblTitle);

		imgBomb = new ImageIcon("images/��޸�ī��.png");
		lblImg = new JLabel(imgBomb);
		lblImg.setBounds(50, 80, 400, 300);
		bombPanel.add(lblImg); //�����гο� ����
		
		lblExplain = new JLabel("�����ܿ� ����1~2�ܰ� (ĵ)Ŀ�Ǹ� ���´�.");
		lblExplain.setBounds(50, 400, 400, 40); // ���� ��ġ ����
		lblExplain.setFont(new Font("�����Ѱ� ��üB", Font.PLAIN, 18));
		lblExplain.setForeground(Color.black);
		lblExplain.setHorizontalAlignment(SwingConstants.CENTER); // ���� ��� ����
		bombPanel.add(lblExplain);

		btnL = new buttonListener(); // ��ư������ ����
		
		btnBack = new JButton("���ư���"); // ���ư��� ��ư ����
		btnBack.setBounds(400, 470, 100, 30); // ��ư ��ġ ����
		btnBack.setFont(new Font("�����Ѱ� ��üB", Font.PLAIN, 14)); // ��Ʈ ����
		btnBack.addActionListener(btnL); // ��ư �����ʿ� ����
		bombPanel.add(btnBack); // �⺻�гο� ����
		
		frame.pack();
		frame.setVisible(true); // ������ ������

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

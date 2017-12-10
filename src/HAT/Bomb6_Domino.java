package HAT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bomb6_Domino extends JPanel {

	private JPanel bombPanel, prePanel; // ����ȭ�� �гΰ� ����ȭ�� �г� ����
	private JLabel lblTitle, lblExplain1, lblExplain2, lblExplain3, lblExplain4; // ����ڰ� ������ ��ź�� �̸��� ��ź�� ������ ǥ���� ��
	private ImageIcon imgBomb; // ��ź�� �̹���
	private JLabel lblImg; // �̹��� �� ��
	private JButton btnBack;// ���ư����ư
	private buttonListener btnL; // ��ư ������

	public Bomb6_Domino(JFrame frame, JPanel selAlcoholPanel) {
		
		prePanel = selAlcoholPanel; // ����ȭ������ ���ư������� ���� �ʱ�ȭ

		bombPanel = new JPanel(); //�����г� ����
		bombPanel.setBounds(0, 0, 500, 500);
		bombPanel.setLayout(null);// �����г��� ���̾ƿ��� ����
		bombPanel.setBackground(Color.white);// �����г� �޹�� ����
		frame.add(bombPanel); // �����ӿ� �г� �߰�

		lblTitle = new JLabel("���̳���");
		lblTitle.setBounds(50, 0, 400, 70);
		lblTitle.setFont(new Font("�����ձ۾� ��", Font.BOLD, 60));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER); // ���� ��� ����
		bombPanel.add(lblTitle); // �����гο� ����
		
		imgBomb = new ImageIcon("images/���̳���.png");
		lblImg = new JLabel(imgBomb);
		lblImg.setBounds(50, 80, 400, 300);
		bombPanel.add(lblImg); //�����гο� ����
		
		lblExplain1 = new JLabel("�������� �ο������ �մ�� ���� ���ָ� ������.");
		lblExplain1.setBounds(50, 385, 400, 30);
		lblExplain1.setFont(new Font("�����Ѱ� ��üB", Font.PLAIN, 16));
		lblExplain1.setForeground(Color.black);
		lblExplain1.setHorizontalAlignment(SwingConstants.CENTER); // ���� ��� ����
		bombPanel.add(lblExplain1);
		
		lblExplain2 = new JLabel("�մ�� ���� �����ܰ� �� ���̿� �����ܵ��� ���� �� ���ָ� ������.");
		lblExplain2.setBounds(0, 405, 500, 30);
		lblExplain2.setFont(new Font("�����Ѱ� ��üB", Font.PLAIN, 16));
		lblExplain2.setForeground(Color.black);
		lblExplain2.setHorizontalAlignment(SwingConstants.CENTER); // ���� ��� ����
		bombPanel.add(lblExplain2);

		lblExplain3 = new JLabel("ù ��° �������� �հ������� ��¦ ��ġ�� ���̳� ����ó��");
		lblExplain3.setBounds(50, 425, 400, 30);
		lblExplain3.setFont(new Font("�����Ѱ� ��üB", Font.PLAIN, 16));
		lblExplain3.setForeground(Color.black);
		lblExplain3.setHorizontalAlignment(SwingConstants.CENTER); // ���� ��� ����
		bombPanel.add(lblExplain3);
		
		lblExplain4 = new JLabel("��� �������� ���� ���� �����ܿ� �������� ������ �ȴ�.");
		lblExplain4.setBounds(50, 445, 400, 30);
		lblExplain4.setFont(new Font("�����Ѱ� ��üB", Font.PLAIN, 16));
		lblExplain4.setForeground(Color.black);
		lblExplain4.setHorizontalAlignment(SwingConstants.CENTER); // ���� ��� ����
		bombPanel.add(lblExplain4);

		btnL = new buttonListener(); // ��ư������ ����
		
		btnBack = new JButton("���ư���"); // ���ư��� ��ư ����
		btnBack.setBounds(400, 470, 100, 30); // ��ư ��ġ ����
		btnBack.setFont(new Font("�����Ѱ� ��üB", Font.PLAIN, 14)); // ��Ʈ ����
		btnBack.setEnabled(true);
		btnBack.addActionListener(btnL); // ��ư �����ʿ� ����
		bombPanel.add(btnBack); // �����гο� ����
		
		frame.pack();
		frame.getContentPane().add(bombPanel); // �����ӿ� �г� �߰�(�г� setVisible ����)
		frame.setVisible(true); // ������ ������
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

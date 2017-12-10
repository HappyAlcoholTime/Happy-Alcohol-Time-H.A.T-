package HAT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bomb4_Sobaek extends JPanel {

	private JPanel bombPanel, prePanel; // ���� �гΰ� ����ȭ�� �г� ����

	private JLabel lblTitle, lblExplain; // �� �̸�, �� ���� ��
	private JButton btnBack; // ���ư��� ��ư
	private buttonListener btnL; //��ư ������
	private ImageIcon imgBomb; // ��ź�� �̹���
	private JLabel lblImg; // �̹��� �� ��

	public Bomb4_Sobaek(JFrame frame, JPanel selAlcoholPanel) {
		
		prePanel = selAlcoholPanel; // ����ȭ������ ���ư������� ���� �ʱ�ȭ

		bombPanel = new JPanel(); //�����г� ����
		bombPanel.setBounds(0, 0, 500, 500);
		bombPanel.setLayout(null);// �����г��� ���̾ƿ��� ����
		bombPanel.setBackground(Color.white);// �����г� �޹�� ����
		frame.add(bombPanel); // �����ӿ� �����г� �߰�

		lblTitle = new JLabel("�ҹ���"); // �ҹ��� ���� ����
		lblTitle.setBounds(50, 0, 400, 70); // ���� ��ġ ����
		lblTitle.setFont(new Font("�����ձ۾� ��", Font.BOLD, 60)); // ���� ��Ʈ ����
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER); // ��� ����
		bombPanel.add(lblTitle); // �����гο� ����
		
		imgBomb = new ImageIcon("images/�ҹ�����.png");
		lblImg = new JLabel(imgBomb);
		lblImg.setBounds(50, 80, 400, 300);
		bombPanel.add(lblImg); //�����гο� ����

		lblExplain = new JLabel("���ֿ� �鼼�ֿ� ������ ���ָ� �� ������ ���� ���´�."); // �� ������ ���� ���� ����
		lblExplain.setBounds(50, 400, 400, 40); // ���� ��ġ ����
		lblExplain.setFont(new Font("�����Ѱ� ��üB", Font.PLAIN, 18)); // ���� ��Ʈ ����
		lblExplain.setHorizontalAlignment(SwingConstants.CENTER); // ��� ����
		bombPanel.add(lblExplain); // �����гο� ����
		
		btnL = new buttonListener(); // ��ư������ ����

		btnBack = new JButton("���ư���"); // ���ư��� ��ư ����
		btnBack.setBounds(400, 470, 100, 30); // ��ư ��ġ ����
		btnBack.setFont(new Font("�����Ѱ� ��üB", Font.PLAIN, 14)); // ��Ʈ ����
		btnBack.addActionListener(btnL); //��ư������ ����
		bombPanel.add(btnBack); // �����гο� ����
		
		frame.pack();
		frame.setVisible(true); // ������ ������
		
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

package HAT;

import javax.swing.*;


import java.awt.*;
import java.awt.event.*;

public class Game1_Sadari extends JPanel {

	private JPanel gamePanel, prePanel; // ���� �гΰ� ����ȭ�� �г� ����
	private SadariGamePanel sadariPanel; // ������ �������� �г�
	private JLabel lblTitle; // ����, ���, ��� ������ǥ��
	private JButton btnBack; // ���ư��� ��ư
	private buttonListener btnL; // ��ư ������

	public Game1_Sadari(JFrame frame, JPanel selGamePanel) {
		setPreferredSize(new Dimension(500, 500)); // �⺻ �г�ũ�� ����
		this.setBackground(Color.white); // �г� �� ����
		this.setLayout(null); // ���̾ƿ� ���� ���ֱ�

		prePanel = selGamePanel; // ����ȭ�� �гκ��� �ʱ�ȭ

		gamePanel = new JPanel(); // �����г� ����
		gamePanel.setBounds(0, 0, 500, 500);
		gamePanel.setBackground(Color.white);// �г� �޹�� ����
		gamePanel.setLayout(null);// �г��� ���̾ƿ��� ����
		frame.add(gamePanel);// �����ӿ� �����г� �߰�

		sadariPanel = new SadariGamePanel(); // ������ ����Ǵ� �г� ����
		sadariPanel.setBounds(25, 70, 450, 350); // �г� ��ġ ����
		gamePanel.add(sadariPanel); // �����гο� ��ٸ����� ���� �г� ����

		lblTitle = new JLabel("�ٻ�ٸ� ���ӡ�"); // ��ٸ����� ���� ����
		lblTitle.setBounds(50, 20, 400, 40); // ���� ��ġ ����
		lblTitle.setFont(new Font("�����ձ۾� ��", Font.BOLD, 50)); // ���� ��Ʈ ����
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER); // ��� ����
		gamePanel.add(lblTitle); // �����гο� ����

		btnL = new buttonListener(); // ��ư������ ����

		btnBack = new JButton("���ư���"); // ���ư��� ��ư ����
		btnBack.setBounds(400, 470, 100, 30); // ��ġ ����
		btnBack.setFont(new Font("�����Ѱ� ��üB", Font.PLAIN, 14)); // ��Ʈ ����
		btnBack.addActionListener(btnL); // ��ư �����ʿ� ����
		gamePanel.add(btnBack); // �����гο� ����

		frame.pack();
		frame.setVisible(true); // ������ ������
	}// Game1_Sadari(frame, prePanel)

	private class buttonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			Object b = e.getSource();

			if (b == btnBack) {
				gamePanel.setVisible(false);
				prePanel.setVisible(true);
			} // if

		}// actionPerformed()

	}// buttonListener class
} //Game1_Sadari class

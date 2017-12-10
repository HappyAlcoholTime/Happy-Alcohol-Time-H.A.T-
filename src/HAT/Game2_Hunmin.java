package HAT;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Game2_Hunmin extends JPanel {

	private JPanel gamePanel, prePanel; // ��üȭ�� �г�, ���� ȭ�� �г�
	private JLabel lblTitle, lblTitle2, lblChange;
	private JButton btnBack, btnChange, btnTotal1, btnTotal2;
	// btnTotal1, btnTotal2 ������ �ȿ����� JLabel�� ����� �� �����Ƿ� ��ư���� ����
	private buttonListener btnL; // ��ư ������
	private ImageIcon imgBack; // ����̹���

	private char[] han = new char[] { '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��',
			'��', '��', '��' };// �ѱ� ������ ��Ƴ��� �迭
	int num1, num2;// ������ ���� ������ ����, �ε��� ������ ���� ����
	String total1, total2;// ������ ������ ����

	public Game2_Hunmin(JFrame frame, JPanel selGamePanel) {

		prePanel = selGamePanel; // ����ȭ�� �гκ��� �ʱ�ȭ

		imgBack = new ImageIcon("images/���1.png");

		gamePanel = new JPanel() {
			public void paintComponent(Graphics g) // ����̹��� ����
			{
				g.drawImage(imgBack.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}// paintComponent()
		};
		gamePanel.setBounds(0, 0, 500, 500);
		gamePanel.setLayout(null);// �����г��� ���̾ƿ��� ����
		gamePanel.setBackground(Color.white);// �����г� �޹�� ����
		frame.add(gamePanel); // �����ӿ� �г� �߰�

		btnL = new buttonListener(); // ��ư������ ����

		// �۾� ����
		lblTitle = new JLabel("�ƹ����� ����");
		lblTitle.setBounds(130, 10, 500, 80);
		lblTitle.setFont(new Font("�����ձ۾� ��", Font.BOLD, 60));
		lblTitle.setForeground(Color.white);
		gamePanel.add(lblTitle);// ����

		lblTitle2 = new JLabel("���þ�");
		lblTitle2.setBounds(190, 100, 100, 50);
		lblTitle2.setFont(new Font("�����Ѱ� ��üB", Font.BOLD, 30));
		lblTitle2.setForeground(Color.white);
		gamePanel.add(lblTitle2);// ����

		lblChange = new JLabel("�ٲٱ�");
		lblChange.setFont(new Font("�����Ѱ� ��üB", Font.BOLD, 14));
		lblChange.setBounds(400, 300, 50, 15);
		lblChange.setForeground(Color.white);
		gamePanel.add(lblChange);

		btnChange = new JButton(new ImageIcon("images/���찳.png")); // �ٲٱ� ��ư ����
		btnChange.setBounds(380, 240, 100, 61); // ��ġ ����

		btnChange.setForeground(Color.white);// ��ư �� ����
		btnChange.setBorderPainted(false);// ��ư �ܰ��� ����
		btnChange.setOpaque(false);// ����ȭ
		btnChange.setContentAreaFilled(false);
		btnChange.setFocusPainted(false);
		gamePanel.add(btnChange);// �����гο� ����

		Random generator = new Random();// ������������
		num1 = generator.nextInt(19); // 0~19����
		num2 = generator.nextInt(19);// 0~19����
		total1 = Character.toString(han[num1]);// han �迭�� �ִ� ���� ��Ʈ������ ����
		total2 = Character.toString(han[num2]);// han �迭�� �ִ� ���� ��Ʈ������ ����

		// ù���� �ʼ� ȭ�鿡 ���
		btnTotal1 = new JButton(total1);
		btnTotal1.setBounds(90, 155, 130, 100);
		btnTotal1.setFont(new Font("�����Ѱ� ��üB", Font.BOLD, 80));
		btnTotal1.setForeground(Color.white);
		btnTotal1.setBorderPainted(false);// �ܰ��� ����
		btnTotal1.setOpaque(false);// �����ϰ�
		btnTotal1.setContentAreaFilled(false);// ä��� ������� ����
		btnTotal1.setFocusPainted(false);// ���õǾ��� �� ����� �׵θ� ������
		gamePanel.add(btnTotal1);

		// �ι��� �ʼ� ȭ�鿡 ���
		btnTotal2 = new JButton(total2);
		btnTotal2.setBounds(230, 155, 130, 100);
		btnTotal2.setFont(new Font("�����Ѱ� ��üB", Font.BOLD, 90));
		btnTotal2.setForeground(Color.white);
		btnTotal2.setBorderPainted(false);// �ܰ�������
		btnTotal2.setOpaque(false);// �����ϰ�
		btnTotal2.setContentAreaFilled(false);// ä��� x
		btnTotal2.setFocusPainted(false);// ���õǾ��� �� ����� �׵θ� ������
		gamePanel.add(btnTotal2);// ��ư�߰�

		// ���ư��� ��ư����
		btnBack = new JButton("���ư���"); // ���ư��� ��ư ����
		btnBack.setBounds(400, 470, 100, 30); // ��ư ��ġ ����
		btnBack.setFont(new Font("�����Ѱ� ��üB", Font.PLAIN, 14)); // ��Ʈ ����
		btnBack.addActionListener(btnL); // �̺�Ʈ �����ʿ� ����
		gamePanel.add(btnBack); // �����гο� ����

		// �ٲٱ� ��ư��Ŭ�� �Ͽ��� �� �߻��ϴ� ������
		ActionListener listener = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				btnTotal1.setVisible(false);// ������°�(��ư�� ��������) ���߱�
				btnTotal2.setVisible(false);// ������°�(��ư�� ��������) ���߱�

				// ������ �ʼ�2���� �����ϱ� ���� ����
				Random generator = new Random();// �������� ����
				num1 = generator.nextInt(19);// 0~19���� ������ ��
				num2 = generator.nextInt(19);// 0~19���� ������ ��
				total1 = Character.toString(han[num1]);// total1������ ������ �ʼ� ����
				total2 = Character.toString(han[num2]);// total2������ ������ �ʼ� ����

				// ù���� �ʼ�
				btnTotal1 = new JButton(total1);
				btnTotal1.setBounds(90, 155, 130, 100);
				btnTotal1.setFont(new Font("�����Ѱ� ��üB", Font.PLAIN, 80));
				btnTotal1.setForeground(Color.white);
				btnTotal1.setBorderPainted(false);// �ܰ��� ����
				btnTotal1.setOpaque(false);// �����ϰ�
				btnTotal1.setContentAreaFilled(false);// ä��� ������� ����
				btnTotal1.setFocusPainted(false);// ���õǾ��� �� ����� �׵θ� ������
				gamePanel.add(btnTotal1);

				// �ι�° �ʼ�
				btnTotal2 = new JButton(total2);
				btnTotal2.setBounds(230, 155, 130, 100);
				btnTotal2.setFont(new Font("�����Ѱ� ��üB", Font.PLAIN, 90));
				btnTotal2.setForeground(Color.white);
				btnTotal2.setBorderPainted(false);// �ܰ�������
				btnTotal2.setOpaque(false);// �����ϰ�
				btnTotal2.setContentAreaFilled(false);// ä��� x
				btnTotal2.setFocusPainted(false);// ���õǾ��� �� ����� �׵θ� ������
				gamePanel.add(btnTotal2);

				btnTotal1.setVisible(true);// �ٲٱ� ��ư�� ���� �ٲ۰� ���
				btnTotal2.setVisible(true);// �ٲٱ� ��ư�� ���� �ٲ۰� ���

			} // actionPerformed()
		};
		btnChange.addActionListener(listener);// �ٲٱ� ��ư�� ������ �߰�

		frame.pack();
		frame.setVisible(true); // ������ ������

	}// Game2_Hunmin(frame)

	// ���ư��� ��ư ����
	private class buttonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			Object b = e.getSource();

			if (b == btnBack) {
				gamePanel.setVisible(false);
				prePanel.setVisible(true);
			} // if

		}// actionPerformed()

	}// buttonListener class

} // Game2_Humin class
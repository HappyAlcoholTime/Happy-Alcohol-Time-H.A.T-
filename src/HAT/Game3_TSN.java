package HAT;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game3_TSN extends JPanel {

	private JPanel gamePanel, prePanel; // ����ȭ�� �г�, ���� ȭ�� �г�
	TimerThread count;// ���� ī��Ʈ�� ���� ������ ����
	JLabel card = new JLabel();// ���� ī��Ʈ�� ������ ���̺� ����
	JButton start = new JButton("Start");// ���� ��ư ����
	int n = 1;// ī��Ʈ ���� �� ����
	boolean singleClick = false;// Ŭ�� ����
	boolean doubleClick = false;// ����Ŭ�� ����
	private JLabel lblTitle, lblRule; // ����� ����
	private JButton btnBack;// ���ư����ư
	private buttonListener btnL; // ��ư ������

	public Game3_TSN(JFrame frame, JPanel selGamePanel) {

		prePanel = selGamePanel; // ����ȭ�� �гκ��� �ʱ�ȭ

		gamePanel = new JPanel(); // �����г� ����
		gamePanel.setBounds(0, 0, 500, 500);
		gamePanel.setLayout(null);// �����г��� ���̾ƿ��� ����
		gamePanel.setBackground(Color.white);// �����г� �޹�� ����
		frame.add(gamePanel); // �����ӿ� �г� �߰�

		// ���� ����
		lblTitle = new JLabel("3 6 9 ����");
		lblTitle.setBounds(50, 50, 400, 50);// ���� ��ġ ����
		lblTitle.setFont(new Font("�����ձ۾� ��", Font.BOLD, 60));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER); // ���� ��� ����
		gamePanel.add(lblTitle);

		//���� ��Ģ ����
		lblRule = new JLabel("1 ���� 100 ������ ���� �� 3/6/9 �� �ִ� ���� Ŭ�� or ����Ŭ��");
		lblRule.setBounds(50, 250, 400, 80);
		lblRule.setFont(new Font("�����Ѱ� ��üB", Font.PLAIN, 16));
		lblRule.setHorizontalAlignment(SwingConstants.CENTER); // ��� ����
		gamePanel.add(lblRule);

		btnL = new buttonListener(); // ��ư������ ����
		
		// ���ư��� ��ư ����
		btnBack = new JButton("���ư���");
		btnBack.setBounds(400, 470, 100, 30);
		btnBack.setFont(new Font("�����Ѱ� ��üB", Font.PLAIN, 14));
		btnBack.addActionListener(btnL); // �̺�Ʈ �����ʿ� ����
		gamePanel.add(btnBack);// �����гο� ����

		// ���� ī��Ʈ�� ������ ���̺��� �гο� �߰�
		card.setOpaque(true);
		card.setBackground(Color.yellow);
		card.setFont(new Font("�ü�", Font.PLAIN, 50));
		card.setHorizontalAlignment(JLabel.CENTER);
		card.setText(Integer.toString(n));
		card.setSize(200, 100);
		card.setLocation(150, 140);
		card.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent me) {
			}// mouseClicked()

			public void mousePressed(MouseEvent me) {
				if (me.getClickCount() >= 2) {// ���� Ŭ���̻� ���� �� ����Ŭ������ �ν�
					doubleClick = true;
					singleClick = false;
				} else if (me.getClickCount() == 1) {// �ѹ� Ŭ������ ��
					singleClick = true;
					doubleClick = false;
				} else {// �ѹ��� Ŭ���� �� ���� ��
					singleClick = false;
					doubleClick = false;
				} // mousePressed()

				// ���콺�� ������ �� ���̺� ��ü�� �ҽ��� ���� ������ �������� ����
				JLabel card = (JLabel) me.getSource();
				card.setBackground(Color.orange);
			}

			public void mouseReleased(MouseEvent me) {
				// ���콺�� ������ �� ���̺� ��ü�� �ҽ��� ���� ������ ��������� ����
				JLabel card = (JLabel) me.getSource();
				card.setBackground(Color.yellow);
			}// mouseReleased()

			public void mouseEntered(MouseEvent me) {
			}// mouseEntered()

			public void mouseExited(MouseEvent me) {
			}// mouseExited()
		});
		gamePanel.add(card);

		// ���۹�ư�� �гο� �߰�
		start.setLocation(175, 350);
		start.setSize(150, 80);
		start.setFont(new Font("�����Ѱ� ��üB", Font.PLAIN, 40));
		start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				// ��ưŬ���� �ʱ⼳���� ������ ��ü ������ ����
				n = 1;

				card.setText(Integer.toString(n));
				singleClick = false;
				doubleClick = false;
				count = new TimerThread();
				count.start();

				// ���� �߿��� ��ư Ŭ���� ���ϰ� ��
				JButton b = (JButton) ae.getSource();
				b.setEnabled(false);
			} // actionPerformed()
		});
		gamePanel.add(start);

		frame.pack();
		frame.setVisible(true); // ������ ������

	} // Game3_TSN(frame,prePanel)

	synchronized void setSingleClicked(boolean b) {// �ѹ� Ŭ��
		singleClick = b;
	}// setSingleClicked()

	synchronized void setDoubleClicked(boolean b) {// ���� Ŭ��
		doubleClick = b;
	} // setDoubleClicked()

	class TimerThread extends Thread {
		public void run() {
			while (true) {
				try {
					card.setBackground(Color.yellow);
					sleep(700);// 0.7�ʸ���

					int d1 = n % 10;// ���� �ڸ�
					int d2 = n / 10;// ���� �ڸ�

					if ((d1 == 3 || d1 == 6 || d1 == 9) && (d2 == 3 || d2 == 6 || d2 == 9)) {// ����Ŭ���� �ؾ��� ��Ȳ
						if (doubleClick == true) {// ������
							setDoubleClicked(false);
						} else if (singleClick == true || ((doubleClick == false) && (singleClick == false))) {// ����Ŭ����
																												// �ؾ��ϴµ�
																												// ���� ��
																												// ����
							card.setText("����");
							card.setBackground(Color.red);
							break;
						}
					} else if (d1 == 3 || d1 == 6 || d1 == 9 || d2 == 3 || d2 == 6 || d2 == 9) {// �ѹ� Ŭ���� �ؾ��� ��Ȳ
						if (singleClick == true) {// ������
							setSingleClicked(false);
						} else if ((doubleClick == false) && (singleClick == false)) {// �ѹ� Ŭ���� �ؾ��ϴµ� ���� �� ����
							card.setText("����");
							card.setBackground(Color.red);
							break;
						}
					} else {// �ƹ��͵� Ŭ������ ���ƾ��� ��Ȳ
						if (singleClick == true || doubleClick == true) {// Ŭ���� ����
							card.setText("����");
							card.setBackground(Color.red);
							break;
						}
					}

					n++;// ī��Ʈ �� 1�� ����

					if (n == 100) {// 100���� ���� �¸�
						card.setText("����");
						break;
					} else {// 100 �Ʒ��̸� ��� ����
						card.setText(Integer.toString(n));
					}
				} catch (Exception e) {
					return;
				} // try ... catch
			} // while()
			start.setEnabled(true);// ������ ������ ��ư Ȱ��ȭ
		}// run()
	}// TimerThread class

	private class buttonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			Object b = e.getSource();
			if (b == btnBack) {
				gamePanel.setVisible(false);
				prePanel.setVisible(true);
			} // if

		}// actionPerformed()

	}// buttonListener class

} // Game3_TSN class

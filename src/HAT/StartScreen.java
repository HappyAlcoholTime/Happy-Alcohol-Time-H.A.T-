package HAT;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StartScreen extends JFrame {

	private JFrame frame; // ���α׷� ���� ������
	private JPanel startPanel; // ���� ȭ�� ��� �г�
	private JLabel lblTitle; // ���α׷� ����
	private JButton btnAlcohol, btnGame;
	// ��ź�� ���� ȭ��� ������ ���� ȭ������ ��ȯ�ϴ� ��ư

	private ImageIcon imgTitle; // ����ȭ�� ��� �̹���
	private JLabel lblImg; // �̹��� �� ��

	private buttonListener btnL; // ��ư������ ����

	public StartScreen() {

		setTitle("H. A. T"); // ������ Ÿ��Ʋ ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(515, 535));// â ũ�� ����
		setResizable(false); // âũ�����
		setLayout(null); // ������ ���̾ƿ� ����

		frame = this; // �������� �ѱ������ ���� �ʱ�ȭ

		startPanel = new JPanel();// ����г� ����
		startPanel.setBounds(0, 0, 500, 500); // ��� �г��� ��ġ, ũ�� ����
		startPanel.setBackground(Color.white);// �г� ���� ����
		startPanel.setLayout(null); // �г� ���̾ƿ� ����
		frame.add(startPanel); // �����ӿ� ����г� ����

		imgTitle = new ImageIcon("images/Ʈ����ī��.gif"); // Ÿ��Ʋ �̹��� ����
		lblImg = new JLabel(imgTitle); // �̹��� ������ �� ����
		lblImg.setBounds(50, 50, 400, 200); // �� ��ġ ����
		startPanel.add(lblImg); // ���� ����гο� ����

		lblTitle = new JLabel("Happy Alcohol Time"); // Ÿ��Ʋ �� ����
		lblTitle.setBounds(25, 150, 450, 300);
		lblTitle.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 45)); //�� �۾� ��Ʈ,ũ�� ����
		lblTitle.setForeground(Color.black);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER); // ���� ��� ����
		startPanel.add(lblTitle);// ���� ����гο� ����

		btnL = new buttonListener(); // ��ư������ ����

		btnAlcohol = new JButton(new ImageIcon("images/��ź�ֹ�ư.png")); // ��ź�� ���� ȭ������ �̵��� ��ư ����
		btnAlcohol.setBounds(100, 330, 100, 100); // ��ư ��ġ����
		btnAlcohol.setBorderPainted(false);// ��ư �ܰ�������
		btnAlcohol.setOpaque(false);// ��ư �����ϰ�
		btnAlcohol.setContentAreaFilled(false);// ��ư ä��� x
		btnAlcohol.setFocusPainted(false);// ��ư ���õǾ��� �� ����� �׵θ� ������
		btnAlcohol.setEnabled(true); // ��ư ��뿩�� ����
		btnAlcohol.addActionListener(btnL); // ��ư�� ������ ����
		startPanel.add(btnAlcohol); // ��ư�� ����гο� ����

		btnGame = new JButton(new ImageIcon("images/�����ӹ�ư.png"));// ������ ���� ȭ������ �̵��� ��ư ����
		btnGame.setBounds(300, 330, 100, 100);
		btnGame.setBorderPainted(false);
		btnGame.setOpaque(false);
		btnGame.setContentAreaFilled(false);
		btnGame.setFocusPainted(false);
		btnGame.setEnabled(true);
		btnGame.addActionListener(btnL);
		startPanel.add(btnGame); // ��ư�� ����гο� ����

		pack();
		setLocationRelativeTo(null);// ������â ����� �߰� ��.
		setVisible(true); //������ ������

	} // StartScreen()

	private class buttonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Object b = e.getSource();
			if (b == btnAlcohol) //��ź�� ���� ��ư ������ 
			{
				startPanel.setVisible(false); //����ȭ�� �г� �Ⱥ��̰�
				new SelectAlcohol(frame, startPanel); //��ź�� ���� �г� ����
			} else if (b == btnGame) //������ ���� ��ư ������
			{
				startPanel.setVisible(false); //����ȭ�� �г� �Ⱥ��̰�
				new SelectGame(frame, startPanel); //������ ���� �г� ����
			}
		}// actionPerformed class
	}// buttonListener class
} // StartScreen()

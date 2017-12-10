package HAT;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SelectGame extends JPanel {

	private JFrame frame;// ���� ������ �ѱ������ ����
	private JPanel selGamePanel, prePanel; // ����ȭ�� �гΰ� ����ȭ�� ��� �г� ����
	private JLabel lblNow; // ���� ȭ�� �ȳ� ��
	private JButton bntSadari, btnHunmin, btnTsn;
	// ����ڰ� ���ϴ� ���� ���� ȭ������ �̵��ϰ��� �Ҷ� ������ ��ư��
	private JButton btnBack; // ���ư��� ��ư
	private buttonListener btnL; // ��ư������

	public SelectGame(JFrame frame, JPanel startPanel) {

		this.frame = frame;// ���� ȭ�鿡 �ѱ������ ������ ���� �ʱ�ȭ

		prePanel = startPanel; // ����ȭ������ ���ư������� ���� �ʱ�ȭ

		selGamePanel = new JPanel();// ����г� ����
		selGamePanel.setBounds(0, 0, 500, 500);
		selGamePanel.setBackground(Color.white);
		selGamePanel.setLayout(null);// �г��� ���̾ƿ��� ����
		this.frame.add(selGamePanel); // �����Ӽ��� �г��� �����ӿ� ����

		lblNow = new JLabel("������");// ���� ȭ�� �ȳ� �� ����
		lblNow.setBounds(50, 50, 400, 100);
		lblNow.setFont(new Font("�����ձ۾� ��", Font.BOLD, 60));
		lblNow.setForeground(Color.black);
		lblNow.setHorizontalAlignment(SwingConstants.CENTER); // ���� ��� ����
		selGamePanel.add(lblNow);// ���� ����гο� ����

		btnL = new buttonListener(); // ��ư������ ����

		bntSadari = new JButton("��ٸ�����"); //���Ӽ���1 ��ư ����
		bntSadari.setBounds(180, 190, 140, 40);
		bntSadari.setFont(new Font("�����Ѱ� ��üB", Font.PLAIN, 20));
		bntSadari.setBackground(Color.gray);// ��ư ����
		bntSadari.setForeground(Color.white);// ��ư �����
		bntSadari.setEnabled(true);// ��ư ��� ���� ����
		bntSadari.addActionListener(btnL);
		selGamePanel.add(bntSadari); // ���Ӽ���1 ��ư�� ����гο� ����

		btnHunmin = new JButton("�ƹ�����");//���Ӽ���2 ��ư ����
		btnHunmin.setBounds(190, 280, 120, 40);
		btnHunmin.setFont(new Font("�����Ѱ� ��üB", Font.PLAIN, 20));
		btnHunmin.setBackground(Color.gray);
		btnHunmin.setForeground(Color.white);
		btnHunmin.setEnabled(true);
		btnHunmin.addActionListener(btnL);
		selGamePanel.add(btnHunmin);// ���Ӽ���2 ��ư�� ����гο� ����

		btnTsn = new JButton("3 6 9 ����");
		btnTsn.setBounds(180, 370, 140, 40);
		btnTsn.setFont(new Font("�����Ѱ� ��üB", Font.PLAIN, 20));
		btnTsn.setBackground(Color.gray);
		btnTsn.setForeground(Color.white);
		btnTsn.setEnabled(true);
		btnTsn.addActionListener(btnL);
		selGamePanel.add(btnTsn);// ���Ӽ���3 ��ư�� ����гο� ����

		btnBack = new JButton("���ư���"); // ���ư��� ��ư ����
		btnBack.setBounds(400, 470, 100, 30); // ��ư ��ġ ����
		btnBack.setFont(new Font("�����Ѱ� ��üB", Font.PLAIN, 14)); // ��Ʈ ����
		btnBack.setEnabled(true);
		btnBack.addActionListener(btnL);
		selGamePanel.add(btnBack);// ���ư��� ��ư�� ����гο� ����

		this.frame.pack();
		this.frame.setVisible(true); // ������ ������

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
			} else if (b == btnBack) // ���ư��� ��ư ������
			{
				selGamePanel.setVisible(false); //������ ���� �г� �Ⱥ��̰�
				prePanel.setVisible(true);// �����г�(���⼭�� ����ȭ���г�) ���̰� ����
			} // if ... else if
		}// actionPerformed()
	}// buttonListener class
}// SelctGame class

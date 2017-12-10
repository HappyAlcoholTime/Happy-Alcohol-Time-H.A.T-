package HAT;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SelectAlcohol extends JPanel {

	private JFrame frame; // ���� ������ �ѱ������ ����
	private JPanel selAlcoholPanel, prePanel; // ����ȭ�� ����гΰ� ����ȭ�� ��� �г� ����
	private JLabel lblNow; // ���� ȭ�� �ȳ� ��
	private JButton btnBomb1, btnBomb2, btnBomb3, btnBomb4, btnBomb5, btnBomb6;
	// ����ڰ� ���ϴ� ��ź�� �Ұ� ȭ������ �̵��ϰ��� �Ҷ� ������ ��ư��
	private JButton btnBack; // ���ư��� ��ư
	private buttonListener btnL; // ��ư ������

	public SelectAlcohol(JFrame frame, JPanel startPanel) {

		this.frame = frame; // ���� ȭ�鿡 �ѱ������ ������ ���� �ʱ�ȭ

		prePanel = startPanel; // ����ȭ������ ���ư������� ���� �ʱ�ȭ

		selAlcoholPanel = new JPanel(); // ����г� ����
		selAlcoholPanel.setBounds(0, 0, 500, 500);
		selAlcoholPanel.setBackground(Color.white);
		selAlcoholPanel.setLayout(null);// �г��� ���̾ƿ��� ����
		this.frame.add(selAlcoholPanel); // ��ź�ּ��� �г��� �����ӿ� ����

		lblNow = new JLabel("��ź�� ����"); // ���� ȭ�� �ȳ� �� ����
		lblNow.setBounds(50, 50, 400, 100);
		lblNow.setFont(new Font("�����ձ۾� ��", Font.BOLD, 60));
		lblNow.setForeground(Color.black);
		lblNow.setHorizontalAlignment(SwingConstants.CENTER); // ���� ��� ����
		selAlcoholPanel.add(lblNow); // ���� ����гο� ����

		btnL = new buttonListener(); // ��ư������ ����

		btnBomb1 = new JButton("��޸�ī��"); // ��ź��1 ��ư ����
		btnBomb1.setBounds(80, 190, 140, 40);
		btnBomb1.setFont(new Font("�����Ѱ� ��üB", Font.PLAIN, 20)); // ��ư �۾� ��Ʈ,ũ�� ����
		btnBomb1.setBackground(Color.gray);// ��ư ����
		btnBomb1.setForeground(Color.white);// ��ư �����
		btnBomb1.setEnabled(true); // ��ư ��� ���� ����
		btnBomb1.addActionListener(btnL); //��ư������ ����
		selAlcoholPanel.add(btnBomb1); // ��ź��1 ��ư�� ����гο� ����

		btnBomb2 = new JButton("��ũ��Ű��");// ��ź��2 ��ư ����
		btnBomb2.setBounds(80, 280, 140, 40);
		btnBomb2.setFont(new Font("�����Ѱ� ��üB", Font.PLAIN, 20));
		btnBomb2.setBackground(Color.gray);
		btnBomb2.setForeground(Color.white);
		btnBomb2.setEnabled(true);
		btnBomb2.addActionListener(btnL);
		selAlcoholPanel.add(btnBomb2);// ��ź��2 ��ư�� ����гο� ����

		btnBomb3 = new JButton("��������");// ��ź��3 ��ư ����
		btnBomb3.setBounds(90, 370, 120, 40);
		btnBomb3.setFont(new Font("�����Ѱ� ��üB", Font.PLAIN, 20));
		btnBomb3.setBackground(Color.gray);
		btnBomb3.setForeground(Color.white);
		btnBomb3.setEnabled(true);
		btnBomb3.addActionListener(btnL);
		selAlcoholPanel.add(btnBomb3);// ��ź��3 ��ư�� ����гο� ����

		btnBomb4 = new JButton("�ҹ���");// ��ź��4 ��ư ����
		btnBomb4.setBounds(300, 190, 120, 40);
		btnBomb4.setFont(new Font("�����Ѱ� ��üB", Font.PLAIN, 20));
		btnBomb4.setBackground(Color.gray);
		btnBomb4.setForeground(Color.white);
		btnBomb4.setEnabled(true);
		btnBomb4.addActionListener(btnL);
		selAlcoholPanel.add(btnBomb4);// ��ź��4 ��ư�� ����гο� ����

		btnBomb5 = new JButton("������");// ��ź��5 ��ư ����
		btnBomb5.setBounds(310, 280, 100, 40);
		btnBomb5.setFont(new Font("�����Ѱ� ��üB", Font.PLAIN, 20));
		btnBomb5.setBackground(Color.gray);
		btnBomb5.setForeground(Color.white);
		btnBomb5.setEnabled(true);
		btnBomb5.addActionListener(btnL);
		selAlcoholPanel.add(btnBomb5);// ��ź��5 ��ư�� ����гο� ����

		btnBomb6 = new JButton("���̳���");// ��ź��6 ��ư ����
		btnBomb6.setBounds(300, 370, 120, 40);
		btnBomb6.setFont(new Font("�����Ѱ� ��üB", Font.PLAIN, 20));
		btnBomb6.setBackground(Color.gray);
		btnBomb6.setForeground(Color.white);
		btnBomb6.setEnabled(true);
		btnBomb6.addActionListener(btnL);
		selAlcoholPanel.add(btnBomb6);// ��ź��6 ��ư�� ����гο� ����

		btnBack = new JButton("���ư���"); // ���ư��� ��ư ����
		btnBack.setBounds(400, 470, 100, 30); // ��ư ��ġ ����
		btnBack.setFont(new Font("�����Ѱ� ��üB", Font.PLAIN, 14));
		btnBack.setEnabled(true);
		btnBack.addActionListener(btnL);
		selAlcoholPanel.add(btnBack); // ���ư��� ��ư�� ����гο� ����

		this.frame.pack();
		this.frame.setVisible(true); // ������ ������

	}// SelectAlcohol(frame,prePanel)

	private class buttonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Object b = e.getSource();

			if (b == btnBomb1) // ��ź��1 ��ư ������
			{
				selAlcoholPanel.setVisible(false); // ��ź�� ���� �г� �Ⱥ��̰�
				new Bomb1_SSome(frame, selAlcoholPanel); // ��ź��1 ��޸�ī�� �г� ����
			} else if (b == btnBomb2)// ��ź��2 ��ư ������
			{
				selAlcoholPanel.setVisible(false);
				new Bomb2_Screw(frame, selAlcoholPanel);
			} else if (b == btnBomb3)// ��ź��3 ��ư ������
			{
				selAlcoholPanel.setVisible(false);
				new Bomb3_Gojin(frame, selAlcoholPanel);
			} else if (b == btnBomb4)// ��ź��4 ��ư ������
			{
				selAlcoholPanel.setVisible(false);
				new Bomb4_Sobaek(frame, selAlcoholPanel);
			} else if (b == btnBomb5)// ��ź��5 ��ư ������
			{
				selAlcoholPanel.setVisible(false);
				new Bomb5_GeumTe(frame, selAlcoholPanel);
			} else if (b == btnBomb6)// ��ź��6 ��ư ������
			{
				selAlcoholPanel.setVisible(false); 
				new Bomb6_Domino(frame, selAlcoholPanel);
			} else if (b == btnBack) // ���ư��� ��ư ������
			{
				selAlcoholPanel.setVisible(false); // ��ź�� ���� �г� �Ⱥ��̰�
				prePanel.setVisible(true);// �����г�(���⼭�� ����ȭ���г�) ���̰� ����
			} // if ... else if
		}// actionPerformed()
	}// buttonListener class

}// SelectAlcohol class

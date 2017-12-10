package HAT;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bomb5_GeumTe extends JPanel {

	private JPanel bombPanel, prePanel; // ����ȭ�� �гΰ� ����ȭ�� �г� ����
	private JLabel lblTitle, lblExplain1, lblExplain2, lblExplain3; // ����ڰ� ������ ��ź�� �̸��� ��ź�� ������ ǥ���� ��
	private ImageIcon imgBomb; // ��ź�� �̹���
	private JLabel lblImg; // �̹��� �� ��
	private JButton btnBack;// ���ư����ư
	private buttonListener btnL; //��ư������

	public Bomb5_GeumTe(JFrame frame, JPanel selAlcoholPanel) {
		
		prePanel = selAlcoholPanel; // ����ȭ������ ���ư������� ���� �ʱ�ȭ

		bombPanel = new JPanel(); //�����г� ����
		bombPanel.setBounds(0, 0, 500, 500);
		bombPanel.setLayout(null);// �����г��� ���̾ƿ��� ����
		bombPanel.setBackground(Color.white);// �����г� �޹�� ����
		frame.add(bombPanel); // �����ӿ� �г� �߰�

		lblTitle = new JLabel("������");
		lblTitle.setBounds(50, 0, 400, 70);// ���� ��ġ ����
		lblTitle.setFont(new Font("�����ձ۾� ��", Font.BOLD, 60));
		lblTitle.setForeground(Color.black);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER); // ���� ��� ����
		bombPanel.add(lblTitle); //�����гο� ����
		
		imgBomb = new ImageIcon("images/������.png");
		lblImg = new JLabel(imgBomb);
		lblImg.setBounds(50, 80, 400, 300);
		bombPanel.add(lblImg); //�����гο� ����
		
		lblExplain1 = new JLabel("�����ܿ� ���ָ� 95% ���� ������.");
		lblExplain1.setBounds(50, 390, 400, 40);
		lblExplain1.setFont(new Font("�����Ѱ� ��üB", Font.PLAIN, 18));
		lblExplain1.setForeground(Color.black);
		lblExplain1.setHorizontalAlignment(SwingConstants.CENTER); // ���� ��� ����
		bombPanel.add(lblExplain1);
		
		lblExplain2 = new JLabel("�� ���� ������ ���� �� �������� ���ָ� õõ�� �״´�.");
		lblExplain2.setBounds(50, 420, 400, 40);
		lblExplain2.setFont(new Font("�����Ѱ� ��üB", Font.PLAIN, 18));
		lblExplain2.setForeground(Color.black);
		lblExplain2.setHorizontalAlignment(SwingConstants.CENTER); // ���� ��� ����
		bombPanel.add(lblExplain2);

		lblExplain3 = new JLabel("Tip) ���� ��� ���ָ� ����ϸ� �����ְ� �ȴ�.   ");
		lblExplain3.setBounds(50, 450, 400, 40);
		lblExplain3.setFont(new Font("�����Ѱ� ��üB", Font.PLAIN, 18));
		lblExplain3.setForeground(Color.black);
		lblExplain3.setHorizontalAlignment(SwingConstants.CENTER); // ���� ��� ����
		bombPanel.add(lblExplain3);

		btnL = new buttonListener(); // ��ư������ ����

		btnBack = new JButton("���ư���"); // ���ư��� ��ư ����
		btnBack.setBounds(400, 470, 100, 30); // ��ư ��ġ ����
		btnBack.setFont(new Font("�����Ѱ� ��üB", Font.PLAIN, 14)); // ��Ʈ ����
		btnBack.setEnabled(true);
		btnBack.addActionListener(btnL); // ��ư �����ʿ� ����
		bombPanel.add(btnBack); // �����гο� ����
		
		frame.pack();
		frame.setVisible(true); // ������ ������

	}//Bomb5_GeumTe(frame, prePanel)
	
	private class buttonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Object b = e.getSource();
			if (b == btnBack) {
				bombPanel.setVisible(false);
				prePanel.setVisible(true);
			} //if
		}// actionPerformed()
	}// buttonListener class
}//Bomb5_GeumTe class
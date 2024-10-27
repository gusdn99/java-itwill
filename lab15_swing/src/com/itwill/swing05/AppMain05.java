package com.itwill.swing05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class AppMain05 {

	private JFrame frame;
	private JTextField textName;
	private JLabel lblPhone;
	private JLabel lblEmail;
	private JTextField textPhone;
	private JTextField textEmail;
	private JButton btnInput;
	private JTextArea textResult;
	private JLabel lblName;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain05 window = new AppMain05();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppMain05() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 703, 519);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblName = new JLabel("이름");
		lblName.setFont(new Font("D2Coding", Font.PLAIN, 22));
		lblName.setBounds(34, 72, 156, 49);
		frame.getContentPane().add(lblName);
		
		textName = new JTextField();
		textName.setFont(new Font("D2Coding", Font.PLAIN, 22));
		textName.setBounds(220, 71, 232, 51);
		frame.getContentPane().add(textName);
		textName.setColumns(10);
		
		lblPhone = new JLabel("전화번호");
		lblPhone.setFont(new Font("D2Coding", Font.PLAIN, 22));
		lblPhone.setBounds(34, 149, 156, 49);
		frame.getContentPane().add(lblPhone);
		
		lblEmail = new JLabel("이메일");
		lblEmail.setFont(new Font("D2Coding", Font.PLAIN, 22));
		lblEmail.setBounds(34, 233, 156, 49);
		frame.getContentPane().add(lblEmail);
		
		textPhone = new JTextField();
		textPhone.setFont(new Font("D2Coding", Font.PLAIN, 22));
		textPhone.setColumns(10);
		textPhone.setBounds(220, 149, 232, 51);
		frame.getContentPane().add(textPhone);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("D2Coding", Font.PLAIN, 22));
		textEmail.setColumns(10);
		textEmail.setBounds(220, 231, 232, 51);
		frame.getContentPane().add(textEmail);
		
		btnInput = new JButton("입력");
		btnInput.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleInputButtonClick();
			}
		});
		btnInput.setFont(new Font("D2Coding", Font.PLAIN, 22));
		btnInput.setBounds(493, 226, 137, 56);
		frame.getContentPane().add(btnInput);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 332, 592, 125);
		frame.getContentPane().add(scrollPane);
		
		textResult = new JTextArea();
		scrollPane.setViewportView(textResult);
		textResult.setFont(new Font("D2Coding", Font.PLAIN, 22));
	}

	protected void handleInputButtonClick() {
		// JTextField(이름, 전화번호, 이메일)에 입력된 문자열을 읽음.
		String name = textName.getText();
		String phone = textPhone.getText();
		String email = textEmail.getText();
		
		String result = String.format("이름: %s	전화번호: %s 이메일: %s\n", name, phone, email);
		
		// 이름, 전화번호, 이메일을 JTextResult에 씀.
//		textResult.setText(result);
		textResult.append(result); // 기존에 작성된 내용 끝에 추가.
		
		// 모든 JTexField의 입력된 내용을 지움.
		textName.setText("");
		textPhone.setText("");
		textEmail.setText("");
			
	}
}

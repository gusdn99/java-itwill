package com.itwill.swing02;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class AppMain02 {

	private JFrame frame;
	private JLabel lblMessage;
	private JTextField textInput;
	private JButton btnInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain02 window = new AppMain02();
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
	public AppMain02() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 575, 336);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null); // Absolute layout
		
		lblMessage = new JLabel("메시지를 입력하세요...");
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setFont(new Font("D2Coding", Font.PLAIN, 26));
		lblMessage.setBounds(28, 10, 482, 66);
		frame.getContentPane().add(lblMessage);
		
		textInput = new JTextField(); // textInput 필드
		textInput.setHorizontalAlignment(SwingConstants.CENTER);
		textInput.setFont(new Font("D2Coding", Font.PLAIN, 26));
		textInput.setBounds(28, 111, 491, 66);
		frame.getContentPane().add(textInput);
		textInput.setColumns(10);
		
		btnInput = new JButton("입력"); // JButton 객체 생성
		
		// 버튼에 ActionListener 이벤트 핸들러(리스너)를 설정(등록)
		btnInput.addActionListener(new ActionListener() {
			@Override // 버튼이 클릭됐을 때 할 일을 작성.
			public void actionPerformed(ActionEvent e) {
				// (지역) 내부 클래스에서는 외부 클래스의 메서드를 사용할 수 있음.
				handleInputButtonClick();
			}
		});
		btnInput.setFont(new Font("D2Coding", Font.PLAIN, 26));
		btnInput.setBounds(190, 205, 145, 66);
		frame.getContentPane().add(btnInput);
	}

	private void handleInputButtonClick() {
		// 1. JTextField에 입력된 문자열을 읽음.
		String msg = textInput.getText();
		
		// 2. (1)에서 읽은 내용을 JLabel에 씀.
		lblMessage.setText(msg);
		
		// 3. JTextField를 비움(JTextField에 입력된 내용을 지움).
		textInput.setText("");
		
	}
}

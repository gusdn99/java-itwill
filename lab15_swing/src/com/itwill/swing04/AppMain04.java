package com.itwill.swing04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class AppMain04 {

	private JFrame frame;
	private JTextField textNum1;
	private JTextField textNum2;
	private JTextArea textResult;
	private JButton btnDivide;
	private JButton btnMultiply;
	private JButton btnMinus;
	private JButton btnPlus;
	private JLabel lblNum2;
	private JLabel lblNum1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain04 window = new AppMain04();
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
	public AppMain04() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 703, 558);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblNum1 = new JLabel("num1");
		lblNum1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNum1.setFont(new Font("D2Coding", Font.PLAIN, 22));
		lblNum1.setBounds(43, 42, 154, 49);
		frame.getContentPane().add(lblNum1);

		textNum1 = new JTextField();
		textNum1.setHorizontalAlignment(SwingConstants.CENTER);
		textNum1.setFont(new Font("D2Coding", Font.PLAIN, 22));
		textNum1.setBounds(314, 42, 249, 49);
		frame.getContentPane().add(textNum1);
		textNum1.setColumns(10);

		lblNum2 = new JLabel("num2");
		lblNum2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNum2.setFont(new Font("D2Coding", Font.PLAIN, 22));
		lblNum2.setBounds(43, 115, 154, 49);
		frame.getContentPane().add(lblNum2);

		textNum2 = new JTextField();
		textNum2.setHorizontalAlignment(SwingConstants.CENTER);
		textNum2.setFont(new Font("D2Coding", Font.PLAIN, 22));
		textNum2.setColumns(10);
		textNum2.setBounds(314, 115, 249, 49);
		frame.getContentPane().add(textNum2);

		btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				System.out.println(this); // this - 생성된 객체의 주소 // 내부(익명) 클래스의 주소
				System.out.println(AppMain04.this); // 외부 클래스의 주소
				handleButtonClick(ev);
//				System.out.println(ev.getSource() == btnPlus);
//				double num1 = 0;
//				double num2 = 0;
//				try {
//					num1 = Double.parseDouble(textNum1.getText());
//					num2 = Double.parseDouble(textNum2.getText());
//				} catch (NumberFormatException ex) {
//					textResult.setText("Num1 또는 Num2에는 숫자를 입력");
//					return;
//				}
//				double result = num1 + num2;
//				String msg = String.format("%f + %f = %f", num1, num2, result);
//				textResult.setText(msg);
			}
		});
		btnPlus.setFont(new Font("D2Coding", Font.PLAIN, 30));
		btnPlus.setBounds(43, 216, 104, 57);
		frame.getContentPane().add(btnPlus);

		btnMinus = new JButton("-");
		btnMinus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				handleButtonClick(ev);
//				double num1 = 0;
//				double num2 = 0;
//				try {
//					num1 = Double.parseDouble(textNum1.getText());
//					num2 = Double.parseDouble(textNum2.getText());
//				} catch (NumberFormatException ex) {
//					textResult.setText("Num1 또는 Num2에는 숫자를 입력");
//					return;
//				}
//				double result = num1 - num2;
//				String msg = String.format("%f - %f = %f", num1, num2, result);
//				textResult.setText(msg);
			}
		});
		btnMinus.setFont(new Font("D2Coding", Font.PLAIN, 30));
		btnMinus.setBounds(178, 216, 104, 57);
		frame.getContentPane().add(btnMinus);

		btnMultiply = new JButton("X");
		btnMultiply.addActionListener((ev) -> handleButtonClick(ev)); // 람다 표현식
//				double num1 = 0;
//				double num2 = 0;
//				try {
//					num1 = Double.parseDouble(textNum1.getText());
//					num2 = Double.parseDouble(textNum2.getText());
//				} catch (NumberFormatException ex) {
//					textResult.setText("Num1 또는 Num2에는 숫자를 입력");
//					return;
//				}
//				double result = num1 * num2;
//				String msg = String.format("%f * %f = %f", num1, num2, result);
//				textResult.setText(msg);
		btnMultiply.setFont(new Font("D2Coding", Font.PLAIN, 22));
		btnMultiply.setBounds(319, 216, 104, 57);
		frame.getContentPane().add(btnMultiply);

		btnDivide = new JButton("/");
		btnDivide.addActionListener(this::handleButtonClick); // 메서드 참조 // this - AppMain04 클래스의 객체(AppMain04 생략 가능)
		// AppMain04.this::handleButtonClick
		// 		=> handlebuttonClick() 메서드가 initialize() 메서드 안에 있고
		//			=> initialize() 메서드는 AppMain04 클래스 안에 있어서
//				double num1 = 0;
//				double num2 = 0;
//				try {
//					num1 = Double.parseDouble(textNum1.getText());
//					num2 = Double.parseDouble(textNum2.getText());
//				} catch (NumberFormatException ex) {
//					textResult.setText("num1 또는 num2에는 숫자를 입력");
//					return;
//				}
//				double result = num1 / num2;
//				String msg = String.format("%f / %f = %f", num1, num2, result);
//				textResult.setText(msg);
		btnDivide.setFont(new Font("D2Coding", Font.PLAIN, 22));
		btnDivide.setBounds(459, 216, 104, 57);
		frame.getContentPane().add(btnDivide);

		textResult = new JTextArea();
		textResult.setFont(new Font("D2Coding", Font.PLAIN, 22));
		textResult.setBounds(43, 304, 520, 160);
		frame.getContentPane().add(textResult);
	}
	
	private void handleButtonClick(ActionEvent ev) {
		// JTextField에 입력된 문자열을 숫자(double)로 변환
		double x = 0;
		double y = 0;
		try {
			x = Double.parseDouble(textNum1.getText());
			y = Double.parseDouble(textNum2.getText());
		} catch (NumberFormatException ex) {
			textResult.setText("num1 또는 num2에는 숫자를 입력...");
			return; // 메서드 종료
		}
		
		double result = 0; // 사칙연산 결과를 저장할 변수
		String operator = ""; // 사칙연산 기호(+, -, *, /)를 저장할 변수
		
		Object source = ev.getSource(); // 이벤트가 발생한 소스(UI 컴포넌트)
		if (source == btnPlus) {
			result = x + y;
			operator = "+";
		} else if (source == btnMinus) {
			result = x - y;
			operator = "-";
		} else if (source == btnMultiply) {
			result = x * y;
			operator = "x";
		} else if (source == btnDivide) {
			result = x / y;
			operator = "/";
		}
		
		// 결과창에 보여줄 문자열
		String msg = String.format("%f %s %f = %f", x, operator, y, result);
		textResult.setText(msg);
	}
	
}

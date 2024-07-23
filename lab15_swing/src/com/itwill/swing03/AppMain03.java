package com.itwill.swing03;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class AppMain03 {

	private static final String[] IMAGES = { "images/image1.jpg", "images/image2.jpg", "images/image3.jpg",
			"images/image4.jpg", "images/image5.jpg", };

	private int curIndex; // 현재 화면에 보여지는 이미지 아이콘의 인덱스

	private JFrame frame;
	private JLabel lblImage;
	private JButton btnPrev;
	private JButton btnNext;
	private JLabel lblName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain03 window = new AppMain03();
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
	public AppMain03() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblImage = new JLabel(new ImageIcon(IMAGES[curIndex]));
		lblImage.setBounds(66, 6, 400, 400);
		frame.getContentPane().add(lblImage);

		btnPrev = new JButton("<");
		btnPrev.addActionListener(new ActionListener() { // 익명 (내부) 클래스
			@Override // 이전 버튼이 클릭됐을 때 할 일
			public void actionPerformed(ActionEvent e) {
				// 이전 이미지 보여주기
				showPrevImage();
//				for (int i = IMAGES.length - 1; i >= 0; i--) {
//					if (curIndex > 0) {
//						curIndex--;
//					} else {
//						curIndex = IMAGES.length - 1;
//					}
//				}

			}
		});
		btnPrev.setFont(new Font("D2Coding", Font.PLAIN, 22));
		btnPrev.setBounds(66, 472, 97, 48);
		frame.getContentPane().add(btnPrev);

		btnNext = new JButton(">");
		
		// 람다 표현식을 사용한 이벤트 리스너 등록
		btnNext.addActionListener((e) -> showNextImage());
		
		btnNext.setFont(new Font("D2Coding", Font.PLAIN, 22));
		btnNext.setBounds(378, 472, 97, 48);
		frame.getContentPane().add(btnNext);
		
		lblName = new JLabel(IMAGES[curIndex]);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("D2Coding", Font.PLAIN, 22));
		lblName.setBounds(149, 416, 268, 46);
		frame.getContentPane().add(lblName);
		
	}
	
	private void showNextImage() {
		if (curIndex < IMAGES.length - 1) { // 현재 인덱스가 배열의 마지막 인덱스보다 작으면(마지막 이미지가 아닌 경우)
			curIndex++;
		} else { // 현재 인덱스가 배열의 마지막 인덱스이면(마지막 이미지인 경우)
			curIndex = 0;
		}
		
		// JLabel의 이미지 아이콘을 이전 이미지 아이콘으로 변경
		lblImage.setIcon(new ImageIcon(IMAGES[curIndex]));
		
		// JLabel의 텍스트를 이미지 경로(이름)로 변경
		lblName.setText(IMAGES[curIndex]);
	}

	private void showPrevImage() {
		if (curIndex > 0) { // 현재 이미지의 인덱스가 0보다 크면
			curIndex--; // 인덱스를 1 감소
		} else { // 현재 이미지 인덱스가 0(첫 번째 이미지인 경우)
			curIndex = IMAGES.length - 1; // 배열의 마지막 인덱스
		}

		// JLabel의 이미지 아이콘을 이전 이미지 아이콘으로 변경
		lblImage.setIcon(new ImageIcon(IMAGES[curIndex]));
		
		// JLabel의 텍스트를 이미지 경로(이름)로 변경
		lblName.setText(IMAGES[curIndex]);
	}

}

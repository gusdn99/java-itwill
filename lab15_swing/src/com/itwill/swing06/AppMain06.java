package com.itwill.swing06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AppMain06 {

	private JFrame frame;
	private JRadioButton rbPrivate;
	private JRadioButton rbPackage;
	private JRadioButton rbProtected;
	private JRadioButton rbPublic;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JCheckBox cbAbstract;
	private JCheckBox cbFinal;
	private JCheckBox cbStatic;
	private JComboBox<String> comboBox;
	private JButton btnInfo;
	private JTextArea textArea;
	
	private JRadioButton selectedRadioButton;
	private ArrayList<JCheckBox> selectedCheckBoxes = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain06 window = new AppMain06();
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
	public AppMain06() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 685, 437);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		rbPrivate = new JRadioButton("private");
		rbPrivate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleRadioButtonClick(e);
			}
		});
		rbPrivate.setSelected(true);
		buttonGroup.add(rbPrivate);
		rbPrivate.setFont(new Font("D2Coding", Font.PLAIN, 22));
		rbPrivate.setBounds(21, 20, 141, 50);
		frame.getContentPane().add(rbPrivate);

		rbPackage = new JRadioButton("package");
		rbPackage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleRadioButtonClick(e);
			}
		});
		buttonGroup.add(rbPackage);
		rbPackage.setFont(new Font("D2Coding", Font.PLAIN, 22));
		rbPackage.setBounds(181, 20, 141, 50);
		frame.getContentPane().add(rbPackage);

		rbProtected = new JRadioButton("protected");
		rbProtected.addActionListener((e) -> handleRadioButtonClick(e)); // 람다식
		buttonGroup.add(rbProtected);
		rbProtected.setFont(new Font("D2Coding", Font.PLAIN, 22));
		rbProtected.setBounds(345, 20, 141, 50);
		frame.getContentPane().add(rbProtected);

		rbPublic = new JRadioButton("public");
		rbPublic.addActionListener(this::handleRadioButtonClick); // 메서드 참조
		// AppMain06.this::handleRadioButtonClick
		buttonGroup.add(rbPublic);
		rbPublic.setFont(new Font("D2Coding", Font.PLAIN, 22));
		rbPublic.setBounds(506, 20, 141, 50);
		frame.getContentPane().add(rbPublic);

		cbAbstract = new JCheckBox("abstract");
		cbAbstract.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleCheckBoxClick(e);
			}
		});
		cbAbstract.setFont(new Font("D2Coding", Font.PLAIN, 22));
		cbAbstract.setBounds(21, 85, 141, 42);
		frame.getContentPane().add(cbAbstract);

		cbFinal = new JCheckBox("final");
		cbFinal.addActionListener((e) -> handleCheckBoxClick(e)); // 람다식
		cbFinal.setFont(new Font("D2Coding", Font.PLAIN, 22));
		cbFinal.setBounds(181, 85, 141, 42);
		frame.getContentPane().add(cbFinal);

		cbStatic = new JCheckBox("static");
		cbStatic.addActionListener(this::handleCheckBoxClick); // 메서드 참조
		cbStatic.setFont(new Font("D2Coding", Font.PLAIN, 22));
		cbStatic.setBounds(345, 85, 141, 42);
		frame.getContentPane().add(cbStatic);

		comboBox = new JComboBox<>(); // new JComboBox<String>(); // emails가 String 타입이라서 <>는 String(생략 가능)
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleComboBoxChange(e);
			}
		});
		comboBox.setFont(new Font("D2Coding", Font.PLAIN, 22));
		// 콤보박스에서 사용할 문자열(아이템)들의 배열:
		final String[] emails = { "naver.com", "gmail.com", "kakao.com", "yahoo.com" }; // String 타입
		
		// 콤보박스모델 객체 생성:
		final DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(emails);
		
		 // 콤보박스에 모델을 설정 -> 콤보박스 아이템 설정:
		comboBox.setModel(model);
		comboBox.setBounds(21, 155, 301, 50);
		frame.getContentPane().add(comboBox);

		btnInfo = new JButton("확인");
		btnInfo.addActionListener((e) -> handleButtonClick());
		btnInfo.setFont(new Font("D2Coding", Font.PLAIN, 22));
		btnInfo.setBounds(345, 155, 141, 50);
		frame.getContentPane().add(btnInfo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 215, 626, 142);
		frame.getContentPane().add(scrollPane);

		textArea = new JTextArea();
		textArea.setFont(new Font("D2Coding", Font.PLAIN, 22));
		scrollPane.setViewportView(textArea);
	}

	private void handleButtonClick() {
		// JTextArea에 출력할 문자열들을 붙여나갈(append) 문자열 버퍼
		StringBuffer buffer = new StringBuffer(); // 문자열을 덧불임

//		// 어떤 라디오버튼이 선택됐는지
		if (rbPrivate.isSelected()) {
			buffer.append(rbPrivate.getText());
		} else if (rbPackage.isSelected()) {
			buffer.append(rbPackage.getText());
		} else if (rbProtected.isSelected()) {
			buffer.append(rbProtected.getText());
		} else {
			buffer.append(rbPublic.getText());
		}
		buffer.append(" 라디오버튼 선택됨.\n");

		// 문자열 버퍼의 내용을 JTextArea에 씀.
		textArea.setText(buffer.toString());

		// 어떤 체크박스(들)가 선택됐는지
		if (cbAbstract.isSelected()) {
			buffer.append(cbAbstract.getText()).append(" ");
		}
		if (cbFinal.isSelected()) {
			buffer.append(cbFinal.getText()).append(" ");
		}
		if (cbStatic.isSelected()) {
			buffer.append(cbStatic.getText()).append(" ");
		}
		buffer.append("체크박스 선택됨.\n");
//		textArea.setText(buffer.toString());

		// 콤보박스에서 선택된 아이템
		Object selectedItem = comboBox.getSelectedItem();
		buffer.append(selectedItem).append(" 콤보박스 아이템 선택됨.\n");

		// 문자열 버퍼의 내용을 JTextArea에 씀.
		textArea.setText(buffer.toString());

	}

	protected void handleComboBoxChange(ActionEvent e) {
		// 이벤트가 발생한 컴포넌트(JComboBox) 찾기
		@SuppressWarnings("unchecked")
		JComboBox<String> combo = (JComboBox<String>) e.getSource();

		// 콤보박스에서 선택된 아이템 찾기
		int curIndex = combo.getSelectedIndex(); // 콤보박스에서 선택된 아이템의 인덱스
		String item = (String) combo.getSelectedItem(); // 콤보박스에서 선택된 아이템

		// JTextArea에 정보 출력
		textArea.setText(curIndex + ": " + item);

//		final String[] emails = { "naver.com", "gmail.com", "kakao.com", "yahoo.com" };
//		final DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(emails);
//		boolean selected = combo.isShowing();
//		textArea.setText(emails[curIndex] + " : " + selected);

	}

	protected void handleCheckBoxClick(ActionEvent e) {
		// 3개의 체크박스들 중에서 누가 클릭됐는지 찾기:
		JCheckBox cb = (JCheckBox) e.getSource();
		String text = cb.getText();
		boolean selected = cb.isSelected();
		textArea.setText(text + " : " + selected);

	}

	private void handleRadioButtonClick(ActionEvent e) {
		// 4개 라디오버튼들 중에서 누가 클릭됐는지 찾기:
		JRadioButton rb = (JRadioButton) e.getSource(); // getSource()는 Object를 리턴하므로 캐스팅. 다형성
		String text = rb.getText(); // 이벤트가 발생한 라디오버튼의 텍스트
		boolean selected = rb.isSelected(); // 이벤트가 발생한 라디오버튼의 선택 여부
		textArea.setText(text + " : " + selected);
	}

}

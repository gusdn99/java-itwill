package com.itwill.ver05.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.ver05.controller.ContactDao;
import com.itwill.ver05.controller.ContactDaoImpl;
import com.itwill.ver05.model.Contact;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ContactUpdateFrame extends JFrame {
	public interface UpdateNotify {
		void notifyContactUpdated(); // (public)
	}

	private UpdateNotify app; // 메인 쓰레드 주소를 저장하기 위한 객체
	// -> 연락처 수정을 성공을 알려줄 객체.

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel contentPanel;
	private JPanel buttonPanel;
	private JButton btnSave;
	private JButton btnCancel;
	private JLabel lblName;
	private JTextField textName;
	private JTextField textPhone;
	private JTextField textEmail;
	private JLabel lblPhone;
	private JLabel lblEmail;

	private Component parentComponent; // UpdateFrame의 부모 컴포넌트를 저장하기 위해서
	private int index; // 업데이트할 연락처의 (리스트) 인덱스를 저장하기 위해서

	private ContactDao dao = ContactDaoImpl.getInstance();

	/**
	 * Launch the application.
	 */
	public static void showContactUpdateFrame(Component parentComponent, int index, UpdateNotify app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactUpdateFrame frame = new ContactUpdateFrame(parentComponent, index, app);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ContactUpdateFrame(Component parentComponent, int index, UpdateNotify app) {
		this.parentComponent = parentComponent;
		this.index = index;
		this.app = app;
		initialize();
		initializeTextFields();
	}

	private void initializeTextFields() {
		// 3개의 텍스트 필드에 해당 인덱스의 연락처 정보를 채움.
		Contact contact = dao.read(index);
		textName.setText(contact.getName());
		textPhone.setText(contact.getPhone());
		textEmail.setText(contact.getEmail());
	}

	public void initialize() {
		setTitle("연락처 업데이트");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		int x = 0;
		int y = 0;
		if (parentComponent != null) {
			// 부모 컴포넌트가 있으면 부모 컴포넌트와 같은 좌표(x, y)에 위치시킴.
			x = parentComponent.getX();
			y = parentComponent.getY();
		}
		setBounds(x, y, 508, 340);

		if (parentComponent == null) {
			// 부모 컴포넌트가 없으면 화면 중앙에 위치시킴.
			setLocationRelativeTo(null);
		}

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		contentPanel = new JPanel();
		contentPane.add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblName = new JLabel("이름");
		lblName.setFont(new Font("D2Coding", Font.PLAIN, 18));
		lblName.setBounds(12, 10, 93, 41);
		contentPanel.add(lblName);

		textName = new JTextField();
		textName.setFont(new Font("D2Coding", Font.PLAIN, 18));
		textName.setBounds(117, 10, 353, 41);
		contentPanel.add(textName);
		textName.setColumns(10);

		textPhone = new JTextField();
		textPhone.setFont(new Font("D2Coding", Font.PLAIN, 18));
		textPhone.setColumns(10);
		textPhone.setBounds(117, 61, 353, 41);
		contentPanel.add(textPhone);

		lblPhone = new JLabel("전화번호");
		lblPhone.setFont(new Font("D2Coding", Font.PLAIN, 18));
		lblPhone.setBounds(12, 61, 93, 41);
		contentPanel.add(lblPhone);

		textEmail = new JTextField();
		textEmail.setFont(new Font("D2Coding", Font.PLAIN, 18));
		textEmail.setColumns(10);
		textEmail.setBounds(117, 112, 353, 41);
		contentPanel.add(textEmail);

		lblEmail = new JLabel("이메일");
		lblEmail.setFont(new Font("D2Coding", Font.PLAIN, 18));
		lblEmail.setBounds(12, 112, 93, 41);
		contentPanel.add(lblEmail);

		buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);

		btnSave = new JButton("저장");
		btnSave.addActionListener((e) -> updateContact()); // 입력한 내용 저장.
		btnSave.setFont(new Font("D2Coding", Font.PLAIN, 18));
		buttonPanel.add(btnSave);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener((e) -> dispose()); // 현재 창만 닫음.
		btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 18));
		buttonPanel.add(btnCancel);

	}

	private void updateContact() {
		// 1. JTextField에서 수정할 이름, 전화번호, 이메일을 읽음.
		String name = textName.getText();
		String phone = textPhone.getText();
		String email = textEmail.getText();

		// 2. Contact 타입 객체 생성
		Contact contact = new Contact(0, name, phone, email);

		// 3. DAO를 사용해서 파일에 수정
		int result = dao.update(index, contact);

		if (result == 1) { // 연락처 수정 성공
			// 메인 쓰레드에게 업데이트 성공을 알려줌.
			app.notifyContactUpdated();
			dispose(); // 현재 창 닫기
		} else { // 연락처 수정 실패
			// 업데이트 실패 메시지 보여주기
		}
		
	}
	
}

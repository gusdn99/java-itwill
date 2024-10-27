package com.itwill.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.itwill.controller.PlayerDao;

import com.itwill.model.Player;
import java.awt.Toolkit;

public class PlayerCreateFrame extends JFrame {

	public interface CreateNotify {
		void notifyCreateSuccess();
	}

	private static final String[] POSITION = { "선택", "가드", "가드-포워드", "포워드", "포워드-센터", "센터" };
	private static final String[] TEAM_CODE = { "선택", "BOS", "CHI", "GSW", "LAL", "MIL" };

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel buttonPanel;
	private JPanel contentPanel;
	private JTextField textName;
	private JButton btnCreate;
	private JButton btnCancel;
	private JLabel lblName;
	private JLabel lblHeight;
	private JTextField textHeight;
	private JLabel lblWeight;
	private JTextField textWeight;
	private JLabel lblUniformNumber;
	private JTextField textUniformNumber;
	private JLabel lblPoints;
	private JTextField textPoints;
	private JLabel lblPosition;
	private JLabel lblTeam;
	private JComboBox<String> positionComboBox;
	private JComboBox<String> teamComboBox;
	private JTextField textPosition;
	private JTextField textTeam;

	private PlayerDao p_dao = PlayerDao.getInstance();

	private Component parent;
	private CreateNotify app;

	private static final int MAX_NAME_LENGTH = 20;

	/**
	 * Launch the application.
	 */
	public static void showCreateFrame(Component parent, CreateNotify app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerCreateFrame frame = new PlayerCreateFrame(parent, app);
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
	public PlayerCreateFrame(Component parent, CreateNotify app) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/itwill/images/nba.jpg")));
		this.parent = parent;
		this.app = app;
		initialize();
	}

	public void initialize() {
		setTitle("선수 등록");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		int x = 0;
		int y = 0;
		if (parent != null) {
			x = parent.getX();
			y = parent.getY();
		}
		setBounds(x, y, 675, 492);

		if (parent == null) {
			setLocationRelativeTo(null);
		}

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		contentPanel = new JPanel();
		contentPane.add(contentPanel);
		contentPanel.setLayout(null);

		lblName = new JLabel("이름");
		lblName.setFont(new Font("D2Coding", Font.PLAIN, 18));
		lblName.setBounds(12, 10, 144, 40);
		contentPanel.add(lblName);

		textName = new JTextField(MAX_NAME_LENGTH);
		textName.setFont(new Font("D2Coding", Font.PLAIN, 18));
		textName.setBounds(188, 10, 451, 40);
		contentPanel.add(textName);
		textName.setColumns(10);

		lblHeight = new JLabel("키(cm)");
		lblHeight.setFont(new Font("D2Coding", Font.PLAIN, 18));
		lblHeight.setBounds(12, 60, 144, 40);
		contentPanel.add(lblHeight);

		textHeight = new JTextField();
		textHeight.setFont(new Font("D2Coding", Font.PLAIN, 18));
		textHeight.setColumns(10);
		textHeight.setBounds(188, 60, 451, 40);
		contentPanel.add(textHeight);

		lblWeight = new JLabel("몸무게(kg)");
		lblWeight.setFont(new Font("D2Coding", Font.PLAIN, 18));
		lblWeight.setBounds(12, 110, 144, 40);
		contentPanel.add(lblWeight);

		textWeight = new JTextField();
		textWeight.setFont(new Font("D2Coding", Font.PLAIN, 18));
		textWeight.setColumns(10);
		textWeight.setBounds(188, 110, 451, 40);
		contentPanel.add(textWeight);

		lblUniformNumber = new JLabel("등 번호");
		lblUniformNumber.setFont(new Font("D2Coding", Font.PLAIN, 18));
		lblUniformNumber.setBounds(12, 160, 144, 40);
		contentPanel.add(lblUniformNumber);

		textUniformNumber = new JTextField();
		textUniformNumber.setFont(new Font("D2Coding", Font.PLAIN, 18));
		textUniformNumber.setColumns(10);
		textUniformNumber.setBounds(188, 160, 451, 40);
		contentPanel.add(textUniformNumber);

		lblPoints = new JLabel("득점");
		lblPoints.setFont(new Font("D2Coding", Font.PLAIN, 18));
		lblPoints.setBounds(12, 210, 144, 40);
		contentPanel.add(lblPoints);

		textPoints = new JTextField();
		textPoints.setFont(new Font("D2Coding", Font.PLAIN, 18));
		textPoints.setColumns(10);
		textPoints.setBounds(188, 210, 451, 40);
		contentPanel.add(textPoints);

		lblPosition = new JLabel("포지션");
		lblPosition.setFont(new Font("D2Coding", Font.PLAIN, 18));
		lblPosition.setBounds(12, 260, 144, 40);
		contentPanel.add(lblPosition);

		lblTeam = new JLabel("팀");
		lblTeam.setFont(new Font("D2Coding", Font.PLAIN, 18));
		lblTeam.setBounds(12, 310, 144, 40);
		contentPanel.add(lblTeam);

		positionComboBox = new JComboBox<>();
		positionComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handlePositionComboBoxClick(e);
			}
		});
		final DefaultComboBoxModel<String> postionComboBoxModel = new DefaultComboBoxModel<String>(POSITION);
		positionComboBox.setModel(postionComboBoxModel);

		positionComboBox.setFont(new Font("D2Coding", Font.PLAIN, 18));
		positionComboBox.setBounds(188, 260, 161, 40);
		contentPanel.add(positionComboBox);

		textPosition = new JTextField();
		textPosition.setEditable(false);
		textPosition.setFont(new Font("D2Coding", Font.PLAIN, 18));
		textPosition.setBounds(361, 260, 278, 40);
		contentPanel.add(textPosition);
		textPosition.setColumns(10);

		teamComboBox = new JComboBox<>();
		teamComboBox.addActionListener((e) -> handleTeamComboBoxClick(e));

		final DefaultComboBoxModel<String> teamComboBoxModel = new DefaultComboBoxModel<String>(TEAM_CODE);
		teamComboBox.setModel(teamComboBoxModel);
		teamComboBox.setFont(new Font("D2Coding", Font.PLAIN, 18));
		teamComboBox.setBounds(188, 310, 161, 40);
		contentPanel.add(teamComboBox);

		textTeam = new JTextField();
		textTeam.setEditable(false);
		textTeam.setFont(new Font("D2Coding", Font.PLAIN, 18));
		textTeam.setColumns(10);
		textTeam.setBounds(361, 310, 278, 40);
		contentPanel.add(textTeam);

		buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);

		btnCreate = new JButton("등록");
		btnCreate.addActionListener((e) -> createPlayer());
		btnCreate.setFont(new Font("D2Coding", Font.PLAIN, 24));
		buttonPanel.add(btnCreate);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener((e) -> dispose());
		btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 24));
		buttonPanel.add(btnCancel);
	}

	protected void handlePositionComboBoxClick(ActionEvent e) {

		String position = (String) positionComboBox.getSelectedItem();
		textPosition.setText(position);

		if (position.equals("선택")) {
			textPosition.setText("");
		}

	}

	protected void handleTeamComboBoxClick(ActionEvent e) {
		String team_code = (String) teamComboBox.getSelectedItem();

		if (team_code.equals("선택")) {
			textTeam.setText("");
		} else if (team_code.equals("BOS")) {
			textTeam.setText("보스턴 셀틱스");
		} else if (team_code.equals("CHI")) {
			textTeam.setText("시카고 불스");
		} else if (team_code.equals("GSW")) {
			textTeam.setText("골든스테이트 워리어스");
		} else if (team_code.equals("LAL")) {
			textTeam.setText("로스앤젤레스 레이커스");
		} else if (team_code.equals("MIL")) {
			textTeam.setText("밀워키 벅스");
		}

	}

	private void createPlayer() {
		// 이름, 키, 몸무게, 득점, 포지션, 팀에 입력된 내용을 Player 객체로 만들어서
		// DAO 메서드를 사용해서 DB 테이블에 insert.
		String name = textName.getText();
		try {
			if (name.isEmpty()) {
				JOptionPane.showMessageDialog(PlayerCreateFrame.this, "이름을 입력하세요!", "경고", JOptionPane.WARNING_MESSAGE);
				return;
			}

			if (!name.matches("^[a-zA-Z\\sㄱ-힣]+$")) {
				JOptionPane.showMessageDialog(PlayerCreateFrame.this, "이름은 문자열로 입력하세요!", "입력 오류",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (name.length() > MAX_NAME_LENGTH) {
				JOptionPane.showMessageDialog(PlayerCreateFrame.this, "이름은 최대 " + MAX_NAME_LENGTH + "자까지 입력할 수 있습니다!",
						"입력 오류", JOptionPane.ERROR_MESSAGE);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(PlayerCreateFrame.this, "이름은 최대 " + MAX_NAME_LENGTH + "자까지 입력할 수 있습니다!",
					"입력 오류", JOptionPane.ERROR_MESSAGE);
			return;
		}

		int height = 0;
		try {
			height = Integer.parseInt(textHeight.getText());
			if (height < 0) {
				JOptionPane.showMessageDialog(PlayerCreateFrame.this, "키는 0이상의 정수로 입력하세요!", "입력 오류",
						JOptionPane.ERROR_MESSAGE);
				return;
			} else if (height >= 1000) {
				JOptionPane.showMessageDialog(PlayerCreateFrame.this, "키는 3자리 정수로 입력하세요!", "입력 오류",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(PlayerCreateFrame.this, "키는 0이상의 3자리 정수로 입력하세요!", "입력 오류",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		int weight = 0;
		try {
			weight = Integer.parseInt(textWeight.getText());
			if (weight < 0) {
				JOptionPane.showMessageDialog(PlayerCreateFrame.this, "몸무게는 0이상의 정수로 입력하세요!", "입력 오류",
						JOptionPane.ERROR_MESSAGE);
				return;
			} else if (weight >= 1000) {
				JOptionPane.showMessageDialog(PlayerCreateFrame.this, "몸무게는 3자리 정수로 입력하세요!", "입력 오류",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(PlayerCreateFrame.this, "몸무게는 0이상의 3자리 정수로 입력하세요!", "입력 오류",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		int uniform_number = 0;
		try {
			uniform_number = Integer.parseInt(textUniformNumber.getText());
			if (uniform_number < 0) {
				JOptionPane.showMessageDialog(PlayerCreateFrame.this, "등 번호는 0이상의 정수로 입력하세요!", "입력 오류",
						JOptionPane.ERROR_MESSAGE);
				return;
			} else if (uniform_number >= 100) {
				JOptionPane.showMessageDialog(PlayerCreateFrame.this, "등 번호는 2자리 정수로 입력하세요!", "입력 오류",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(PlayerCreateFrame.this, "등 번호는 0이상의 2자리 정수로 입력하세요!", "입력 오류",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		int points = 0;
		try {
			points = Integer.parseInt(textPoints.getText());
			if (points < 0) {
				JOptionPane.showMessageDialog(PlayerCreateFrame.this, "득점은 0이상의 정수로 입력하세요!", "입력 오류",
						JOptionPane.ERROR_MESSAGE);
				return;
			} else if (points >= 100) {
				JOptionPane.showMessageDialog(PlayerCreateFrame.this, "득점은 2자리 정수로 입력하세요!", "입력 오류",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(PlayerCreateFrame.this, "득점은 0이상의 2자리 정수로 입력하세요!", "입력 오류",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		String position = (String) positionComboBox.getSelectedItem();
		if (position.isEmpty() || position.equals("선택")) {
			JOptionPane.showMessageDialog(PlayerCreateFrame.this, "포지션을 선택하세요!", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}

		String team_code = (String) teamComboBox.getSelectedItem();
		if (team_code.isEmpty() || team_code.equals("선택")) {
			JOptionPane.showMessageDialog(PlayerCreateFrame.this, "팀을 선택하세요!", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}

		boolean isDuplicate = p_dao.isDuplicateTeamUniformNumber(team_code, uniform_number);
		if (isDuplicate) {
			JOptionPane.showMessageDialog(PlayerCreateFrame.this, "선택하신 팀에 이미 입력하신 등 번호가 있습니다!", "경고",
					JOptionPane.WARNING_MESSAGE);
			return;
		} else {
			Player player = new Player(points, name, height, weight, uniform_number, points, position, team_code);
			int result = p_dao.create(player);
			if (result == 1) {
				app.notifyCreateSuccess();
				dispose();
			} else {
				JOptionPane.showMessageDialog(PlayerCreateFrame.this, "선수 등록 실패");
			}
		}

	}
}

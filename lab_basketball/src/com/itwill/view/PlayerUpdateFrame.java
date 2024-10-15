package com.itwill.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.controller.PlayerDao;
import com.itwill.controller.PlayersTeamJoinDao;
import com.itwill.model.Player;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;

public class PlayerUpdateFrame extends JFrame {

	public interface UpdateNotify {
		public void notifyUpdateSuccess();
	}

	private static final String[] POSITION = { "선택", "가드", "가드-포워드", "포워드", "포워드-센터", "센터" };
	private static final String[] TEAM_CODE = { "선택", "BOS", "CHI", "GSW", "LAL", "MIL" };

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel contentPanel;
	private JPanel buttonPanel;
	private JButton btnUpdate;
	private JButton btnCancel;
	private JLabel lblId;
	private JLabel lblName;
	private JLabel lblHeight;
	private JLabel lblWeight;
	private JLabel lblUniformNumber;
	private JLabel lblPoints;
	private JLabel lblPosition;
	private JLabel lblTeam;
	private JLabel lblRanking;
	private JTextField textId;
	private JTextField textName;
	private JTextField textHeight;
	private JTextField textWeight;
	private JTextField textUniformNumber;
	private JTextField textPoints;
	private JTextField textPosition;
	private JTextField textTeam;
	private JTextField textRanking;
	private JComboBox<String> positionComboBox;
	private JComboBox<String> teamComboBox;

	private PlayerDao p_dao = PlayerDao.getInstance();
	private PlayersTeamJoinDao j_dao = PlayersTeamJoinDao.getInstance();

	private Component parent;
	private int id;
	private UpdateNotify app;
	private JButton btnRanking;

	private static final int MAX_NAME_LENGTH = 20; // 이름의 최대 길이(20글자)

	/**
	 * Launch the application.
	 */
	public static void showPlayerUpdateFrame(Component parent, int id, UpdateNotify app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerUpdateFrame frame = new PlayerUpdateFrame(parent, id, app);
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

	public PlayerUpdateFrame(Component parent, int id, UpdateNotify app) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/itwill/images/nba.jpg")));

		this.parent = parent;
		this.id = id;
		this.app = app;
		initialize();
		initializePlayer();
	}

	public void initialize() {
		setTitle("선수 정보");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		int x = 0;
		int y = 0;
		if (parent != null) {
			x = parent.getX();
			y = parent.getY();
		}
		setBounds(x, y, 663, 553);

		if (parent == null) {
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
		lblName.setBounds(12, 46, 110, 35);
		contentPanel.add(lblName);

		textName = new JTextField(MAX_NAME_LENGTH);
		textName.setFont(new Font("D2Coding", Font.PLAIN, 18));
		textName.setBounds(162, 46, 465, 35);
		contentPanel.add(textName);
		textName.setColumns(10);

		lblHeight = new JLabel("키(cm)");
		lblHeight.setFont(new Font("D2Coding", Font.PLAIN, 18));
		lblHeight.setBounds(12, 91, 110, 35);
		contentPanel.add(lblHeight);

		textHeight = new JTextField();
		textHeight.setEditable(false);
		textHeight.setFont(new Font("D2Coding", Font.PLAIN, 18));
		textHeight.setColumns(10);
		textHeight.setBounds(162, 91, 465, 35);
		contentPanel.add(textHeight);

		lblWeight = new JLabel("몸무게(kg)");
		lblWeight.setFont(new Font("D2Coding", Font.PLAIN, 18));
		lblWeight.setBounds(12, 136, 110, 35);
		contentPanel.add(lblWeight);

		lblUniformNumber = new JLabel("등 번호");
		lblUniformNumber.setFont(new Font("D2Coding", Font.PLAIN, 18));
		lblUniformNumber.setBounds(12, 181, 110, 35);
		contentPanel.add(lblUniformNumber);

		lblPosition = new JLabel("포지션");
		lblPosition.setFont(new Font("D2Coding", Font.PLAIN, 18));
		lblPosition.setBounds(12, 271, 110, 35);
		contentPanel.add(lblPosition);

		lblTeam = new JLabel("팀");
		lblTeam.setFont(new Font("D2Coding", Font.PLAIN, 18));
		lblTeam.setBounds(12, 316, 110, 35);
		contentPanel.add(lblTeam);

		lblPoints = new JLabel("득점");
		lblPoints.setFont(new Font("D2Coding", Font.PLAIN, 18));
		lblPoints.setBounds(12, 226, 110, 35);
		contentPanel.add(lblPoints);

		lblRanking = new JLabel("득점 순위");
		lblRanking.setFont(new Font("D2Coding", Font.PLAIN, 18));
		lblRanking.setBounds(12, 361, 110, 35);
		contentPanel.add(lblRanking);

		textWeight = new JTextField();
		textWeight.setFont(new Font("D2Coding", Font.PLAIN, 18));
		textWeight.setColumns(10);
		textWeight.setBounds(162, 136, 465, 35);
		contentPanel.add(textWeight);

		textUniformNumber = new JTextField();
		textUniformNumber.setFont(new Font("D2Coding", Font.PLAIN, 18));
		textUniformNumber.setColumns(10);
		textUniformNumber.setBounds(162, 181, 465, 35);
		contentPanel.add(textUniformNumber);

		textPoints = new JTextField();
		textPoints.setFont(new Font("D2Coding", Font.PLAIN, 18));
		textPoints.setColumns(10);
		textPoints.setBounds(162, 226, 465, 35);
		contentPanel.add(textPoints);

		textRanking = new JTextField();
		textRanking.setEditable(false);
		textRanking.setFont(new Font("D2Coding", Font.PLAIN, 18));
		textRanking.setColumns(10);
		textRanking.setBounds(162, 361, 160, 35);
		contentPanel.add(textRanking);

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
		positionComboBox.setBounds(162, 271, 160, 35);
		contentPanel.add(positionComboBox);

		textPosition = new JTextField();
		textPosition.setEditable(false);
		textPosition.setFont(new Font("D2Coding", Font.PLAIN, 18));
		textPosition.setBounds(345, 271, 282, 35);
		contentPanel.add(textPosition);
		textPosition.setColumns(10);

		textTeam = new JTextField();
		textTeam.setEditable(false);
		textTeam.setFont(new Font("D2Coding", Font.PLAIN, 18));
		textTeam.setColumns(10);
		textTeam.setBounds(345, 316, 282, 35);
		contentPanel.add(textTeam);

		teamComboBox = new JComboBox<>();
		teamComboBox.addActionListener((e) -> handleTeamComboBoxClick(e));
		final DefaultComboBoxModel<String> teamComboBoxModel = new DefaultComboBoxModel<String>(TEAM_CODE);
		teamComboBox.setModel(teamComboBoxModel);
		teamComboBox.setFont(new Font("D2Coding", Font.PLAIN, 18));
		teamComboBox.setBounds(162, 316, 160, 35);
		contentPanel.add(teamComboBox);

		lblId = new JLabel("번호");
		lblId.setFont(new Font("D2Coding", Font.PLAIN, 18));
		lblId.setBounds(12, 1, 110, 35);
		contentPanel.add(lblId);

		textId = new JTextField();
		textId.setEditable(false);
		textId.setText((String) null);
		textId.setFont(new Font("D2Coding", Font.PLAIN, 18));
		textId.setColumns(10);
		textId.setBounds(162, 1, 465, 35);
		contentPanel.add(textId);

		btnRanking = new JButton("선수별 득점 순위");
		btnRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayersRankingDialog dialog = new PlayersRankingDialog(PlayerUpdateFrame.this);
				dialog.setVisible(true);
			}
		});
		btnRanking.setFont(new Font("D2Coding", Font.PLAIN, 18));
		btnRanking.setBounds(345, 361, 282, 35);
		contentPanel.add(btnRanking);

		buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);

		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener((e) -> updatePlayer());
		btnUpdate.setFont(new Font("D2Coding", Font.PLAIN, 24));
		buttonPanel.add(btnUpdate);

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

		// 선택된 항목에 따라 팀 코드를 텍스트 필드에 표시
		if (team_code.equals("BOS")) {
			textTeam.setText("보스턴 셀틱스");
		} else if (team_code.equals("CHI")) {
			textTeam.setText("시카고 불스");
		} else if (team_code.equals("GSW")) {
			textTeam.setText("골든스테이트 워리어스");
		} else if (team_code.equals("LAL")) {
			textTeam.setText("로스앤젤레스 레이커스");
		} else if (team_code.equals("MIL")) {
			textTeam.setText("밀워키 벅스");
		} else {
			textTeam.setText("");
		}

	}

	private void initializePlayer() {
		Player player = p_dao.read_By_ID(id);

		if (player == null)
			return;

		textId.setText(String.valueOf(player.getId()));
		textName.setText(player.getName());
		textHeight.setText(String.valueOf(player.getHeight()));
		textWeight.setText(String.valueOf(player.getWeight()));
		textUniformNumber.setText(String.valueOf(player.getUniform_number()));
		textPoints.setText(String.valueOf(player.getPoints()));
		textPosition.setText(player.getPosition());

		if (player.getP_team_code().equals("BOS")) {
			textTeam.setText("보스턴 셀틱스");
		} else if (player.getP_team_code().equals("CHI")) {
			textTeam.setText("시카고 불스");
		} else if (player.getP_team_code().equals("GSW")) {
			textTeam.setText("골든스테이트 워리어스");
		} else if (player.getP_team_code().equals("LAL")) {
			textTeam.setText("로스앤젤레스 레이커스");
		} else if (player.getP_team_code().equals("MIL")) {
			textTeam.setText("밀워키 벅스");
		}

		List<Player> players = j_dao.readPlayersRank();

		for (Player p : players) {
			if (p.getId() == id) {
				textRanking.setText(String.valueOf(p.getPlayersRank()));
				break;
			}

		}

	}

	private void updatePlayer() {
		// 이름, 몸무게, 득점, 포지션, 팀에 입력된 내용을 Player 객체로 만들어서
		// DAO 메서드를 사용해서 DB 테이블에 insert.
		String name = textName.getText();
		try {
			if (name.isEmpty()) {
				JOptionPane.showMessageDialog(PlayerUpdateFrame.this, "이름을 입력하세요!", "경고", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			if (!name.matches("^[a-zA-Z\\sㄱ-힣]+$")) { // 이름은 공백, 영어, 한글만 허용하도록 설정
				JOptionPane.showMessageDialog(PlayerUpdateFrame.this, "이름은 문자열로 입력하세요!", "입력 오류",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (name.length() > MAX_NAME_LENGTH) { // 최대 길이를 초과하는지 확인
				JOptionPane.showMessageDialog(PlayerUpdateFrame.this, "이름은 최대 " + MAX_NAME_LENGTH + "자까지 입력할 수 있습니다!",
						"입력 오류", JOptionPane.ERROR_MESSAGE);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(PlayerUpdateFrame.this, "이름은 최대 " + MAX_NAME_LENGTH + "자까지 입력할 수 있습니다!",
					"입력 오류", JOptionPane.ERROR_MESSAGE);
			return;
		}

		int weight = 0;
		try {
			weight = Integer.parseInt(textWeight.getText());
			if (weight < 0) {
				JOptionPane.showMessageDialog(PlayerUpdateFrame.this, "몸무게는 0이상의 정수로 입력하세요!", "입력 오류",
						JOptionPane.ERROR_MESSAGE);
				return;
			} else if (weight >= 1000) {
				JOptionPane.showMessageDialog(PlayerUpdateFrame.this, "몸무게는 3자리 정수로 입력하세요!", "입력 오류",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(PlayerUpdateFrame.this, "몸무게는 0이상의 3자리 정수로 입력하세요!", "입력 오류",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		int uniform_number = 0;
		try {
			uniform_number = Integer.parseInt(textUniformNumber.getText());
			if (uniform_number < 0) {
				JOptionPane.showMessageDialog(PlayerUpdateFrame.this, "등 번호는 0이상의 정수로 입력하세요!", "입력 오류",
						JOptionPane.ERROR_MESSAGE);
				return;
			} else if (uniform_number >= 100) {
				JOptionPane.showMessageDialog(PlayerUpdateFrame.this, "등 번호는 2자리 정수로 입력하세요!", "입력 오류",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(PlayerUpdateFrame.this, "등 번호는 0이상의 2자리 정수로 입력하세요!", "입력 오류",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		int points = 0;
		try {
			points = Integer.parseInt(textPoints.getText());
			if (points < 0) {
				JOptionPane.showMessageDialog(PlayerUpdateFrame.this, "득점은 0이상의 정수로 입력하세요!", "입력 오류",
						JOptionPane.ERROR_MESSAGE);
				return;
			} else if (points >= 100) {
				JOptionPane.showMessageDialog(PlayerUpdateFrame.this, "득점은 2자리 정수로 입력하세요!", "입력 오류",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(PlayerUpdateFrame.this, "득점은 0이상의 2자리 정수로 입력하세요!", "입력 오류",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		String position = (String) positionComboBox.getSelectedItem();
		if (position.isEmpty() || position.equals("선택")) {
			JOptionPane.showMessageDialog(PlayerUpdateFrame.this, "포지션을 선택하세요!", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}

		String team_code = (String) teamComboBox.getSelectedItem();
		if (team_code.isEmpty() || team_code.equals("선택")) {
			JOptionPane.showMessageDialog(PlayerUpdateFrame.this, "팀을 선택하세요!", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}

		boolean isDuplicate = p_dao.isDuplicateTeamUniformNumber(team_code, uniform_number);
		if (isDuplicate) {
			JOptionPane.showMessageDialog(PlayerUpdateFrame.this, "선택하신 팀에 이미 입력하신 등 번호가 있습니다!", "경고",
					JOptionPane.WARNING_MESSAGE);
			return;
		} else {
			Player player = new Player(id, name, 0, weight, uniform_number, points, position, team_code);
			int result = p_dao.update(player);
			if (result == 1) {
				app.notifyUpdateSuccess();
				dispose();
			} else {
				JOptionPane.showMessageDialog(PlayerUpdateFrame.this, "선수 정보 수정 실패");
			}
		}

	}
}

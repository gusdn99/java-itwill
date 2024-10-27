package com.itwill.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.model.Player;
import com.itwill.controller.PlayersTeamJoinDao;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.util.Collections;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.awt.Toolkit;

public class TeamSearchFrame extends JFrame {

	private static final String[] COLUMN_NAMES = { "팀 코드", "팀 이름", "이름", "등 번호", "득점", "포지션" };
	private static final String[] TEAM_CODE = { "선택", "BOS", "CHI", "GSW", "LAL", "MIL" };
	private static final String[] IMAGES = { "/com/itwill/images/boston celtics.jpg",
			"/com/itwill/images/chicago bulls.jpg", "/com/itwill/images/goldenstate warriors.jpg",
			"/com/itwill/images/losangeles lakers.jpg", "/com/itwill/images/milwaukee bucks.jpg" };

	private int curIndex;

	private URL[] imageUrls = new URL[IMAGES.length];

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel headerPanel;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblTeamImage;
	private ImageIcon[] images;
	private JComboBox<String> teamComboBox;
	private JTextField textTeamPoints;
	private JLabel lblTeamPoints;
	private JButton btnSearch;
	private JTextField textTeam;
	private DefaultTableModel tableModel;
	private Component frame;

	private PlayersTeamJoinDao j_dao = PlayersTeamJoinDao.getInstance();

	private Component parent;
	private JButton btnCancel;
	private JTextField textTeamRanking;
	private JTextField textCoach;
	private JLabel lblCoach;
	private JLabel lblTeamRanking;
	private JButton btnRanking;

	/**
	 * Launch the application.
	 */
	public static void showTeamSearchFrame(Component parent) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeamSearchFrame frame = new TeamSearchFrame(parent);
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

	public TeamSearchFrame(Component parent) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/itwill/images/nba.jpg")));

		images = new ImageIcon[IMAGES.length];
		for (int i = 0; i < IMAGES.length; i++) {
			imageUrls[i] = getClass().getResource(IMAGES[i]);
			images[i] = new ImageIcon(imageUrls[i]);
		}

		this.parent = parent;
		initialize();
	}

	public void initialize() {
		setTitle("팀 정보");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		int x = 0;
		int y = 0;
		if (parent != null) {
			x = parent.getX(); // 부모 컴포넌트의 x 좌표
			y = parent.getY(); // 부모 컴포넌트의 y 좌표
		}
		setBounds(x, y, 804, 573);

		if (parent == null) {
			setLocationRelativeTo(null); // 화면 중앙에 JFrame을 띄움.
		}

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		headerPanel = new JPanel();
		headerPanel.setBounds(5, 5, 758, 100);
		contentPane.add(headerPanel);
		headerPanel.setLayout(null);

		teamComboBox = new JComboBox<>(IMAGES);
		teamComboBox.addActionListener((e) -> handleTeamComboBoxClick(e));
		final DefaultComboBoxModel<String> teamComboBoxModel = new DefaultComboBoxModel<String>(TEAM_CODE);
		teamComboBox.setModel(teamComboBoxModel);
		teamComboBox.setBounds(12, 10, 89, 35);
		teamComboBox.setFont(new Font("D2Coding", Font.PLAIN, 18));
		headerPanel.add(teamComboBox);

		lblTeamPoints = new JLabel("팀 득점");
		lblTeamPoints.setFont(new Font("D2Coding", Font.PLAIN, 18));
		lblTeamPoints.setBounds(341, 10, 89, 35);
		headerPanel.add(lblTeamPoints);

		textTeamPoints = new JTextField();
		textTeamPoints.setEditable(false);
		textTeamPoints.setFont(new Font("D2Coding", Font.PLAIN, 16));
		textTeamPoints.setBounds(438, 10, 89, 35);
		headerPanel.add(textTeamPoints);
		textTeamPoints.setColumns(10);

		btnSearch = new JButton("검색");
		btnSearch.addActionListener((e) -> showTeamInfo());
		btnSearch.setFont(new Font("D2Coding", Font.PLAIN, 18));
		btnSearch.setBounds(549, 10, 89, 35);
		headerPanel.add(btnSearch);

		textTeam = new JTextField();
		textTeam.setEditable(false);
		textTeam.setFont(new Font("D2Coding", Font.PLAIN, 16));
		textTeam.setBounds(113, 10, 216, 35);
		headerPanel.add(textTeam);
		textTeam.setColumns(10);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener((e) -> dispose());
		btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 18));
		btnCancel.setBounds(656, 10, 89, 35);
		headerPanel.add(btnCancel);

		textTeamRanking = new JTextField();
		textTeamRanking.setFont(new Font("D2Coding", Font.PLAIN, 16));
		textTeamRanking.setEditable(false);
		textTeamRanking.setColumns(10);
		textTeamRanking.setBounds(438, 53, 89, 35);
		headerPanel.add(textTeamRanking);

		lblTeamRanking = new JLabel("팀 순위");
		lblTeamRanking.setFont(new Font("D2Coding", Font.PLAIN, 18));
		lblTeamRanking.setBounds(341, 53, 89, 35);
		headerPanel.add(lblTeamRanking);

		lblCoach = new JLabel("팀 감독");
		lblCoach.setFont(new Font("D2Coding", Font.PLAIN, 18));
		lblCoach.setBounds(12, 53, 89, 35);
		headerPanel.add(lblCoach);

		textCoach = new JTextField();
		textCoach.setFont(new Font("D2Coding", Font.PLAIN, 16));
		textCoach.setEditable(false);
		textCoach.setColumns(10);
		textCoach.setBounds(113, 53, 216, 35);
		headerPanel.add(textCoach);

		btnRanking = new JButton("팀별 득점 순위");
		btnRanking.addActionListener((e) -> TeamRankingDialog.showTeamRankingDialog(TeamSearchFrame.this));
		btnRanking.setFont(new Font("D2Coding", Font.PLAIN, 18));
		btnRanking.setBounds(549, 53, 196, 35);
		headerPanel.add(btnRanking);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 244, 758, 270);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					table.clearSelection();
				}
			}
		});
		table.setDefaultEditor(Object.class, null);
		tableModel = new DefaultTableModel(null, COLUMN_NAMES);
		table.setModel(tableModel);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setFont(new Font("D2Coding", Font.PLAIN, 20));
		table.setFont(new Font("D2Coding", Font.PLAIN, 16));
		table.setRowHeight(28);
		scrollPane.setViewportView(table);

		lblTeamImage = new JLabel(new ImageIcon(IMAGES[curIndex]));
		lblTeamImage.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					ImageIcon icon = (ImageIcon) lblTeamImage.getIcon();
					Image image = icon.getImage();
					Image zoomedImage = image.getScaledInstance(image.getWidth(null) * 2, image.getHeight(null) * 2,
							Image.SCALE_DEFAULT);

					JLabel zoomedLabel = new JLabel(new ImageIcon(zoomedImage));

					JOptionPane.showMessageDialog(frame, zoomedLabel, "팀 로고", JOptionPane.PLAIN_MESSAGE);
				}

			}
		});
		lblTeamImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeamImage.setBounds(295, 115, 208, 119);
		lblTeamImage.setFont(new Font("D2Coding", Font.PLAIN, 24));
		contentPane.add(lblTeamImage);
	}

	protected void handleTeamComboBoxClick(ActionEvent e) {
		showTeamImage();

		textTeamPoints.setText("");
		textTeamRanking.setText("");
		textCoach.setText("");
		tableModel = new DefaultTableModel(null, COLUMN_NAMES);
		table.setModel(tableModel);

		// 콤보박스에서 선택된 항목을 가져옴.
		String team_code = (String) teamComboBox.getSelectedItem();

		// 선택된 항목에 따라 팀 코드를 텍스트 필드에 표시함.
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

	private void showTeamImage() {

		int imageIndex = teamComboBox.getSelectedIndex();
		if (imageIndex > 0 && imageIndex <= images.length) {
			lblTeamImage.setIcon(images[imageIndex - 1]); // 선택된 이미지로 변경 (-1을 해서 "선택" 항목 제외
		} else {
			lblTeamImage.setIcon(null); // 선택된 항목이 없는 경우 이미지를 null로 설정합니다
		}

	}

	private void showTeamInfo() {
		int teamIndex = teamComboBox.getSelectedIndex(); // 콤보박스에서 선택된 아이템의 인덱스

		String team_code = (String) teamComboBox.getSelectedItem();

		String teamText = textTeam.getText(); // 검색어

		// 검색어가 비어 있는 경우 검색을 수행하지 않고 테이블을 초기화
		if (team_code.equals("선택") || teamText.isEmpty()) {
			JOptionPane.showMessageDialog(TeamSearchFrame.this, "팀을 선택하세요!", "경고", JOptionPane.WARNING_MESSAGE);
			textTeamPoints.setText("");
			textTeamRanking.setText("");
			textCoach.setText("");
			resetTable(Collections.emptyList());
			return;
		} else {
			// DAO 메서드를 호출해서 검색 결과를 가져옴.
			List<Player> players = j_dao.read_By_Team_Code(teamIndex, team_code);
			resetTable(players); // 테이블 리셋.
		}

		List<Player> players = j_dao.readTeamRank();
		for (Player p : players) {
			if (p.getP_team_code().equals(team_code)) {
				textTeamPoints.setText(String.valueOf(p.getPointsSum()));
				textTeamRanking.setText(String.valueOf(p.getTeamRank()));
				textCoach.setText(p.getCoach());
				break;
			}

		}

	}

	private void resetTable(List<Player> players) {
		tableModel = new DefaultTableModel(null, COLUMN_NAMES);
		// 리스트의 선수단을 테이블에 행으로 추가.
		for (Player p : players) {
			Object[] row = { p.getP_team_code(), p.getTeam_name(), p.getName(), p.getUniform_number(), p.getPoints(),
					p.getPosition() };
			System.out.println(row);
			tableModel.addRow(row);
		}
		table.setModel(tableModel);

	}
}

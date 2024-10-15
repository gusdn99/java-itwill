package com.itwill.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import com.itwill.controller.PlayerDao;
import com.itwill.model.Player;
import com.itwill.view.PlayerCreateFrame.CreateNotify;
import com.itwill.view.PlayerUpdateFrame.UpdateNotify;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PlayerMain implements CreateNotify, UpdateNotify {

	private static final String[] COLUMN_NAMES = { "번호", "이름", "키(cm)", "몸무게(kg)", "등 번호", "득점", "포지션", "팀" };

	// 첫 번째 콤보박스
	private static final String[] LIST = { "선택", "전체", "포지션", "팀" };
	
	// 첫 번째 콤보박스에서 "선택" 눌렀을 때 나오는 두 번째 콤보박스
	private static final String[] LIST_BY_CHOICE = { "선택" };
	
	// 첫 번째 콤보박스에서 "전체" 눌렀을 때 나오는 두 번째 콤보박스
	private static final String[] LIST_BY_ALL = { "선택", "번호 내림차순", "득점 내림차순" };
	
	// 첫 번째 콤보박스에서 "포지션" 눌렀을 때 나오는 두 번째 콤보박스
	private static final String[] LIST_BY_POSITION = { "선택", "가드", "가드-포워드", "포워드", "포워드-센터", "센터" };
	
	// 첫 번째 콤보박스에서 "팀" 눌렀을 때 나오는 두 번째 콤보박스
	private static final String[] LIST_BY_TEAM = { "선택", "BOS", "CHI", "GSW", "LAL", "MIL" };

	private PlayerDao p_dao = PlayerDao.getInstance();

	private JFrame frame;
	private JPanel buttonPanel;
	private JButton btnCreate;
	private JTable table;
	private JButton btnPlayerUpdate;
	private JButton btnTeamInfo;
	private JButton btnDelete;
	private JScrollPane scrollPane;
	private DefaultTableModel tableModel;
	private JButton btnExit;
	private JComboBox<String> comboBoxList;
	private JComboBox<String> comboBoxChoices;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerMain window = new PlayerMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws SQLException
	 */
	public PlayerMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setFont(new Font("D2Coding", Font.PLAIN, 16));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/itwill/images/nba.jpg")));
		frame.getContentPane().setFont(new Font("D2Coding", Font.PLAIN, 16));
		frame.setBounds(100, 100, 909, 611);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("농구 선수단 프로그램");
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		buttonPanel = new JPanel();
		frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);

		comboBoxList = new JComboBox<>();
		comboBoxList.addActionListener((e) -> handleListClick());
		final DefaultComboBoxModel<String> comboBoxListModel = new DefaultComboBoxModel<String>(LIST);
		comboBoxList.setModel(comboBoxListModel);
		comboBoxList.setFont(new Font("D2Coding", Font.PLAIN, 16));
		buttonPanel.add(comboBoxList);

		comboBoxChoices = new JComboBox<>();
		comboBoxChoices.addActionListener((e) -> handleChoicesClick());
		final DefaultComboBoxModel<String> comboBoxChoicesModel = new DefaultComboBoxModel<String>(LIST_BY_CHOICE);
		comboBoxChoices.setModel(comboBoxChoicesModel);
		comboBoxChoices.setFont(new Font("D2Coding", Font.PLAIN, 16));
		buttonPanel.add(comboBoxChoices);

		btnCreate = new JButton("선수 등록");
		btnCreate.addActionListener((e) -> PlayerCreateFrame.showCreateFrame(frame, PlayerMain.this));
		btnCreate.setFont(new Font("D2Coding", Font.PLAIN, 18));
		buttonPanel.add(btnCreate);

		btnPlayerUpdate = new JButton("선수 정보");
		btnPlayerUpdate.addActionListener((e) -> updatePlayer());
		btnPlayerUpdate.setFont(new Font("D2Coding", Font.PLAIN, 18));
		buttonPanel.add(btnPlayerUpdate);

		btnTeamInfo = new JButton("팀 정보");
		btnTeamInfo.addActionListener((e) -> TeamSearchFrame.showTeamSearchFrame(frame));
		btnTeamInfo.setFont(new Font("D2Coding", Font.PLAIN, 18));
		buttonPanel.add(btnTeamInfo);

		btnDelete = new JButton("선수 삭제");
		btnDelete.addActionListener((e) -> deletePlayer());
		btnDelete.setFont(new Font("D2Coding", Font.PLAIN, 18));
		buttonPanel.add(btnDelete);

		btnExit = new JButton("종료");
		btnExit.addActionListener((e) -> exitProgram());
		btnExit.setFont(new Font("D2Coding", Font.PLAIN, 18));
		buttonPanel.add(btnExit);

		scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

		// JPopupMenu 생성
		JPopupMenu popupMenu = new JPopupMenu();

		JMenuItem updateMenuItem = new JMenuItem("수정");
		updateMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatePlayer();
			}
		});
		popupMenu.add(updateMenuItem);

		JMenuItem deleteMenuItem = new JMenuItem("삭제");
		deleteMenuItem.addActionListener((e) -> deletePlayer());
		popupMenu.add(deleteMenuItem);

		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e)) {
					int row = table.rowAtPoint(e.getPoint());
					if (row >= 0) {
						// 선택된 행 설정
						table.setRowSelectionInterval(row, row);
					}

					if (e.getClickCount() == 1) {
						// 오른쪽 버튼 클릭 시 팝업 메뉴 표시
						popupMenu.show(table, e.getX(), e.getY());
					}
				} else if (e.getClickCount() == 2) {
					table.clearSelection();
				}
			}
		});
		table.setDefaultEditor(Object.class, null);
		tableModel = new DefaultTableModel(null, COLUMN_NAMES);
		table.setModel(tableModel);
		table.setModel(tableModel);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setFont(new Font("D2Coding", Font.PLAIN, 20));
		table.setFont(new Font("D2Coding", Font.PLAIN, 16));
		table.setRowHeight(28);
		scrollPane.setViewportView(table);
	}

	private void handleChoicesClick() {

		String list = (String) comboBoxList.getSelectedItem();
		if (list.equals("선택")) {
			String choices = (String) comboBoxChoices.getSelectedItem();

			if (choices.equals("선택")) {
				tableModel = new DefaultTableModel(null, COLUMN_NAMES);
				table.setModel(tableModel);
			}

		} else if (list.equals("전체")) {
			String all = (String) comboBoxChoices.getSelectedItem();
			if (all.equals("선택")) {
				tableModel = new DefaultTableModel(null, COLUMN_NAMES);
				table.setModel(tableModel);
			} else if (all.equals("번호 내림차순")) {
				List<Player> players = p_dao.readByIdDesc();
				resetTable(players);
			} else {
				List<Player> players = p_dao.readByPointsDesc();
				resetTable(players);
			}

		} else if (list.equals("포지션")) {
			String positionList = (String) comboBoxChoices.getSelectedItem();
			List<Player> players = p_dao.searchByPosition(positionList);
			resetTable(players);
		} else {
			String teamList = (String) comboBoxChoices.getSelectedItem();
			List<Player> players = p_dao.searchByTeam(teamList);
			resetTable(players);
		}

	}

	private void handleListClick() {

		String list = (String) comboBoxList.getSelectedItem();
		String[] choices;

		if (list.equals("선택")) {
			tableModel = new DefaultTableModel(null, COLUMN_NAMES);
			table.setModel(tableModel);
			choices = LIST_BY_CHOICE;
		} else if (list.equals("전체")) {
			tableModel = new DefaultTableModel(null, COLUMN_NAMES);
			table.setModel(tableModel);
			choices = LIST_BY_ALL;
		} else if (list.equals("포지션")) {
			tableModel = new DefaultTableModel(null, COLUMN_NAMES);
			table.setModel(tableModel);
			choices = LIST_BY_POSITION;
		} else if (list.equals("팀")) {
			tableModel = new DefaultTableModel(null, COLUMN_NAMES);
			table.setModel(tableModel);
			choices = LIST_BY_TEAM;
		} else {
			choices = LIST_BY_CHOICE; // 기본값 설정
		}

		// 두 번째 콤보박스의 리스트 설정
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(choices);
		comboBoxChoices.setModel(model);

	}

	private void initializeTable() {
		// DAO를 사용해서 DB 테이블에서 검색.
		List<Player> players = p_dao.readByIdDesc();
		resetTable(players); // 테이블 리셋

	}

	private void resetTable(List<Player> players) {
		tableModel = new DefaultTableModel(null, COLUMN_NAMES);
		// 리스트의 선수단 정보들을 테이블에 행으로 추가.
		for (Player p : players) {
			Object[] row = { p.getId(), p.getName(), p.getHeight(), p.getWeight(), p.getUniform_number(), p.getPoints(),
					p.getPosition(), p.getP_team_code() };
			tableModel.addRow(row);
		}
		table.setModel(tableModel);

	}

	private void updatePlayer() {
		// 테이블에서 선택된 행의 인덱스 찾음.
		int index = table.getSelectedRow();
		if (index == -1) { // 선택된 행이 없는 경우
			JOptionPane.showMessageDialog(frame, "먼저 테이블에서 수정할 행을 선택하세요...", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}

		// 업데이트 프레임(JFrame)을 실행
		Integer id = (Integer) tableModel.getValueAt(index, 0);
		PlayerUpdateFrame.showPlayerUpdateFrame(frame, id, PlayerMain.this);
	}

	private void deletePlayer() {
		int index = table.getSelectedRow(); // 테이블에서 선택된 행의 인덱스
		if (index == -1) { // JTable에서 선택된 행이 없을 때
			JOptionPane.showMessageDialog(frame, "삭제할 행을 먼저 선택하세요.", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}

		int confirm = JOptionPane.showConfirmDialog(frame, "정말 삭제할까요?", "삭제 확인", JOptionPane.YES_NO_OPTION);
		if (confirm == JOptionPane.YES_OPTION) {
			// 선택된 행에서 고유키 번호(id)를 읽음.
			Integer id = (Integer) tableModel.getValueAt(index, 0);
			// DAO의 delete 메서드 호출.
			int result = p_dao.delete(id);
			if (result == 1) {
				initializeTable(); // 테이블을 새로고침.
				JOptionPane.showMessageDialog(frame, "삭제 성공!");
			} else {
				JOptionPane.showMessageDialog(frame, "삭제 실패!");
			}
		}
	}
	
	private void exitProgram() {
		int confirm = JOptionPane.showConfirmDialog(frame, "프로그램을 종료할까요?", "종료 확인", JOptionPane.YES_NO_OPTION);
		if (confirm == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
		
	}

	@Override
	public void notifyCreateSuccess() {
		// 테이블에 insert 성공했을 때 PlayerCreateFrame에서 호출하는 메서드.
		initializeTable();
		JOptionPane.showMessageDialog(frame, "선수 등록 성공");

	}

	@Override
	public void notifyUpdateSuccess() {
		// 테이블에 update 성공했을 때 PlayerUpdateFrame에서 호출하는 메서드.
		initializeTable();
		JOptionPane.showMessageDialog(frame, "선수 정보 수정 성공");

	}
}

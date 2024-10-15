package com.itwill.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itwill.controller.PlayersTeamJoinDao;
import com.itwill.model.Player;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.util.List;

public class PlayersRankingDialog extends JDialog {


	private static final String[] COLUMN_NAMES = {"번호", "이름", "팀 이름", "득점", "순위" };

	private PlayersTeamJoinDao j_dao = PlayersTeamJoinDao.getInstance();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Component parent;

	private DefaultTableModel tableModel;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JTable table;
	private JButton btnOk;

	/**
	 * Launch the application.
	 */
	public static void showPlayersRankingFrame(Component parent) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayersRankingDialog playersRankingFrame = new PlayersRankingDialog(parent);
					playersRankingFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public PlayersRankingDialog(Component parent) {
		super();
		this.parent = parent;
		initialize();
		List<Player> players = j_dao.readPlayersRank();

		// 데이터 테이블에 표시
		displayPlayers(players);
	}

	public void initialize() {
		setTitle("선수별 득점 순위");
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/itwill/images/nba.jpg")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		int x = 0;
		int y = 0;
		if (parent != null) {
			x = parent.getX();
			y = parent.getY();
		}
		setBounds(x, y, 731, 459);

		if (parent == null) {
			setLocationRelativeTo(null);
		}

		contentPane = new JPanel();
		contentPane.setFont(new Font("D2Coding", Font.PLAIN, 18));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					table.clearSelection();
				}
			}
		});
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setDefaultEditor(Object.class, null);
		tableModel = new DefaultTableModel(null, COLUMN_NAMES);
		table.setModel(tableModel);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setFont(new Font("D2Coding", Font.PLAIN, 20));
		table.setFont(new Font("D2Coding", Font.PLAIN, 16));
		table.setRowHeight(35);
		scrollPane.setViewportView(table);

		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);

		btnOk = new JButton("OK");
		btnOk.addActionListener((e) -> dispose());
		btnOk.setFont(new Font("D2Coding", Font.PLAIN, 20));
		panel.add(btnOk);
		tableModel = new DefaultTableModel(null, COLUMN_NAMES);

	}
	
	private void displayPlayers(List<Player> players) {
		tableModel = new DefaultTableModel(null, COLUMN_NAMES);
		 for (Player p : players) {
	            Object[] row = { p.getId(), p.getName(), p.getTeam_name(), p.getPoints(), p.getPlayersRank() };
			tableModel.addRow(row);
		}
		table.setModel(tableModel);

    }

}

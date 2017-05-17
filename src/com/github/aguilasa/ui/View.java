package com.github.aguilasa.ui;

import static com.github.aguilasa.ui.Consts.MULTIPLIER;
import static com.github.aguilasa.ui.Consts.TOP_BORDER;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.github.aguilasa.EntryPoints;

public class View extends JFrame {

	private JPanel contentPane;
	private ViewPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View(300, 450, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @param entryPoints
	 */
	public View(int w, int h, EntryPoints entryPoints) {
		int width = w * MULTIPLIER + MULTIPLIER * 3 + TOP_BORDER;
		int height = h * MULTIPLIER + MULTIPLIER * 3 + TOP_BORDER;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, width + TOP_BORDER * 4, height + TOP_BORDER * 6);
		// setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new ViewPanel(entryPoints, width, height);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(TOP_BORDER, TOP_BORDER, width, height);
		contentPane.add(panel);
		panel.setLayout(null);
	}
}

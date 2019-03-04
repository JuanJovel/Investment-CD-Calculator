package com.gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class APYCalculatorDriver extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					APYCalculatorDriver frame = new APYCalculatorDriver("Better Investment Calculator");
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
	public APYCalculatorDriver(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(675, 502);
		contentPane = new APYCalculator();
		setContentPane(contentPane);
	}
}

package com.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.APYCalculator.Calculator;

public class APYCalculator extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtApy;
	private JTextField time1;
	private JTextField apy2;
	private JTextField time2;
	private JTextField principal1;
	private JTextField principal2;
	private JComboBox<String> compounding1;
	private JComboBox<String> compounding2;
	private JComboBox<String> PF1;
	private JComboBox<String> PF2;
	private JLabel F1, F2;
	private JLabel F1Logo, F2Logo;
	private final double WFR = 2.30;
	private final double WFT = 3.25;
	private final double BAR = 0.07;
	private final double BAT = 1;
	private final double CAR = 2.70;
	private final double CAT = 5;

	/**
	 * Create the panel.
	 */
	public APYCalculator() {
		setLayout(null);

		JLabel lblFinancialInstitution = new JLabel("FINANCIAL INSTITUTION 1");
		lblFinancialInstitution.setBounds(52, 34, 167, 16);
		add(lblFinancialInstitution);

		JLabel lblFinancialInstitution_1 = new JLabel("FINANCIAL INSTITUTION 2");
		lblFinancialInstitution_1.setBounds(484, 34, 167, 16);
		add(lblFinancialInstitution_1);

		JLabel lblPopularInstitutions = new JLabel("Popular Institutions");
		lblPopularInstitutions.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblPopularInstitutions.setBounds(52, 62, 149, 16);
		add(lblPopularInstitutions);

		JLabel label = new JLabel("Popular Institutions");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		label.setBounds(484, 62, 149, 16);
		add(label);

		F1Logo = new JLabel("");
		F1Logo.setBounds(82, 118, 100, 100);
		add(F1Logo);

		F2Logo = new JLabel("");
		F2Logo.setBounds(515, 118, 100, 100);
		add(F2Logo);

		apy2 = new JTextField();
		apy2.setBounds(515, 303, 120, 25);
		add(apy2);
		apy2.setColumns(10);

		txtApy = new JTextField();
		txtApy.setBounds(100, 303, 105, 25);
		add(txtApy);
		txtApy.setColumns(10);

		JLabel lblApy = new JLabel("APY:");
		lblApy.setBounds(66, 308, 34, 16);
		add(lblApy);

		JLabel label_1 = new JLabel("%");
		label_1.setBounds(204, 308, 15, 16);
		add(label_1);

		JLabel lblTime = new JLabel("Time:");
		lblTime.setBounds(60, 341, 40, 16);
		add(lblTime);

		time1 = new JTextField();
		time1.setBounds(100, 336, 82, 26);
		add(time1);
		time1.setColumns(10);

		time2 = new JTextField();
		time2.setBounds(515, 336, 100, 26);
		add(time2);
		time2.setColumns(10);

		JLabel lblYears = new JLabel("years");
		lblYears.setBounds(186, 341, 33, 16);
		add(lblYears);

		JLabel lblCompounds = new JLabel("Compounds:");
		lblCompounds.setBounds(18, 381, 82, 16);
		add(lblCompounds);

		compounding1 = new JComboBox<String>();
		compounding1.setBounds(100, 377, 119, 27);
		compounding1.addItem("Monthly");
		compounding1.addItem("Daily");
		compounding1.addItem("Quarterly");
		compounding1.addItem("Yearly");
		add(compounding1);

		compounding2 = new JComboBox<String>();
		compounding2.setBounds(515, 377, 136, 27);
		compounding2.addItem("Monthly");
		compounding2.addItem("Daily");
		compounding2.addItem("Quarterly");
		compounding2.addItem("Yearly");
		add(compounding2);

		PF1 = new JComboBox<String>();
		PF1.setBounds(52, 79, 167, 27);
		PF1.addItemListener(new JListener1());
		PF1.addItem("User Input");
		PF1.addItem("Wells Fargo");
		PF1.addItem("Bank of America");
		PF1.addItem("Capital One");
		add(PF1);

		PF2 = new JComboBox<String>();
		PF2.setBounds(484, 79, 167, 27);
		PF2.addItemListener(new JListener2());
		PF2.addItem("User Input");
		PF2.addItem("Wells Fargo");
		PF2.addItem("Bank of America");
		PF2.addItem("Capital One");
		add(PF2);

		JLabel lblApy_1 = new JLabel("APY:");
		lblApy_1.setBounds(484, 308, 33, 16);
		add(lblApy_1);

		JLabel label_2 = new JLabel("%");
		label_2.setBounds(636, 308, 15, 16);
		add(label_2);

		JLabel lblTime_1 = new JLabel("Time:");
		lblTime_1.setBounds(477, 341, 40, 16);
		add(lblTime_1);

		JLabel lblYears_1 = new JLabel("years");
		lblYears_1.setBounds(618, 341, 33, 16);
		add(lblYears_1);

		JLabel lblCompounds_1 = new JLabel("Compounds:");
		lblCompounds_1.setBounds(435, 381, 82, 16);
		add(lblCompounds_1);

		JButton mainButton = new JButton("Click here to get more bang for your buck");
		mainButton.setBounds(186, 416, 331, 29);
		mainButton.addActionListener(new myActionListener());
		add(mainButton);

		// Author Credit
		JLabel lblByJuan = new JLabel("By Juan Jovel, 2019");
		lblByJuan.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblByJuan.setBounds(0, 461, 127, 16);
		add(lblByJuan);

		JLabel lblPrincipal = new JLabel("Principal:");
		lblPrincipal.setBounds(39, 276, 61, 16);
		add(lblPrincipal);

		principal1 = new JTextField();
		principal1.setBounds(100, 270, 119, 29);
		add(principal1);
		principal1.setColumns(10);

		principal2 = new JTextField();
		principal2.setBounds(515, 270, 118, 29);
		add(principal2);
		principal2.setColumns(10);

		JLabel lblPrincipal_1 = new JLabel("Principal:");
		lblPrincipal_1.setBounds(456, 276, 61, 16);
		add(lblPrincipal_1);

		F1 = new JLabel("null");
		F1.setVisible(false);
		F1.setHorizontalAlignment(SwingConstants.CENTER);
		F1.setBounds(52, 230, 167, 16);
		add(F1);

		F2 = new JLabel("null");
		F2.setVisible(false);
		F2.setHorizontalAlignment(SwingConstants.CENTER);
		F2.setBounds(484, 230, 167, 16);
		add(F2);

	}

	// Button ActionListener
	private class myActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// Financial Institution (or User Input) 1 variable initialization
			double r1 = Double.parseDouble(txtApy.getText());
			double p1 = Double.parseDouble(principal1.getText());
			double t1 = Double.parseDouble(time1.getText());

			/*
			 * Computation The computation is handled by the Calculator class
			 * 
			 * @see classes.com.APYCalculator
			 */
			Calculator calculator1 = null;
			String c = (String) compounding1.getSelectedItem();
			if (c.equals("Daily")) {
				calculator1 = new Calculator(r1, p1, t1);
			} else if (c.equals("Quarterly")) {
				calculator1 = new Calculator(r1, p1, 4, t1);
			} else if (c.equals("Monthly")) {
				calculator1 = new Calculator(r1, p1, 12, t1);
			} else if (c.equals("Yearly")) {
				calculator1 = new Calculator(r1, p1, 1, t1);
			}

			// Financial Institution (or User Input) 2 variable initialization
			double r2 = Double.parseDouble(apy2.getText());
			double p2 = Double.parseDouble(principal2.getText());
			double t2 = Double.parseDouble(time2.getText());

			/*
			 * Computation The computation is handled by the Calculator class
			 * 
			 * @see classes.com.APYCalculator
			 */
			Calculator calculator2 = null;
			String c2 = (String) compounding2.getSelectedItem();
			if (c2.equals("Daily")) {
				calculator2 = new Calculator(r2, p2, t2);
			} else if (c2.equals("Quarterly")) {
				calculator2 = new Calculator(r2, p2, 4, t2);
			} else if (c2.equals("Monthly")) {
				calculator2 = new Calculator(r2, p2, 12, t2);
			} else if (c2.equals("Yearly")) {
				calculator2 = new Calculator(r2, p2, 1, t2);
			}

			// Money Formatter
			NumberFormat format = NumberFormat.getCurrencyInstance();

			// Comparing
			// If F.I 2 yields more interest than F.I 1
			if (calculator2.computeYield() > calculator1.computeYield()) {
				F2.setOpaque(true);
				F2.setForeground(new Color(0, 92, 0));
				F2.setText("+" + format.format(calculator2.computeYield()));
				F1.setOpaque(true);
				F1.setForeground(new Color(94, 0, 0));
				F1.setText("+" + format.format(calculator1.computeYield()));
				F1.setVisible(true);
				F2.setVisible(true);

			}

			// If F.I 1 yields more interest than F.I 2
			else if (calculator1.computeYield() > calculator2.computeYield()) {
				F1.setOpaque(true);
				F1.setForeground(new Color(0, 92, 0));
				F1.setText("+" + format.format(calculator1.computeYield()));
				F2.setOpaque(true);
				F2.setForeground(new Color(94, 0, 0));
				F2.setText("+" + format.format(calculator2.computeYield()));
				F1.setVisible(true);
				F2.setVisible(true);
			}

			// If the two CD's yield the same quantity
			else if (calculator1.computeYield() == calculator2.computeYield()) {
				F1.setText("+" + format.format(calculator1.computeYield()));
				F2.setText("+" + format.format(calculator2.computeYield()));
			}
		}

	}

	// JComboBox Listener (LOGO 1)
	private class JListener1 implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			// Declares logos as BufferedImages
			BufferedImage WFLogoRaw = null, COBLogoRaw = null, BABLogoRaw = null;

			// Initializes logos and handles exceptions
			try {
				WFLogoRaw = ImageIO.read(new File("WFB.jpg"));
				COBLogoRaw = ImageIO.read(new File("C1B.png"));
				BABLogoRaw = ImageIO.read(new File("BAB.png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			// Detecting whether a change has been in the selection
			if (e.getStateChange() == ItemEvent.SELECTED) {
				String selection = (String) e.getItem();
				Image resizedLogo = null;
				ImageIcon logo = null;

				// Selection controller
				switch (selection) {

				// Wells Fargo
				case "Wells Fargo":

					// Scales and sets insititution's logo
					F1Logo.setBounds(82, 118, 100, 100);
					resizedLogo = WFLogoRaw.getScaledInstance(F1Logo.getWidth(), F1Logo.getHeight(),
							Image.SCALE_SMOOTH);
					logo = new ImageIcon(resizedLogo);
					F1Logo.setIcon(logo);

					// Applies rates and time period of the institution and disables fields
					txtApy.setText("" + WFR);
					txtApy.setEnabled(false);
					time1.setText("" + WFT);
					time1.setEnabled(false);
					compounding1.selectWithKeyChar('d');
					compounding1.setEnabled(false);
					break;

				// Capital One
				case "Capital One":

					// Scales and sets logo
					F1Logo.setBounds(F1Logo.getX() - 20, F1Logo.getY(), F1Logo.getWidth() + 40, F1Logo.getHeight());
					resizedLogo = COBLogoRaw.getScaledInstance(F1Logo.getWidth(), F1Logo.getHeight(),
							Image.SCALE_SMOOTH);
					logo = new ImageIcon(resizedLogo);
					F1Logo.setIcon(logo);

					// Applies rates and time period of the institution and disables fields
					txtApy.setText("" + CAR);
					txtApy.setEnabled(false);
					time1.setText("" + CAT);
					time1.setEnabled(false);
					compounding1.selectWithKeyChar('d');
					compounding1.setEnabled(false);
					break;

				// Bank of America
				case "Bank of America":
					F1Logo.setBounds(82, 118, 100, 100);
					resizedLogo = BABLogoRaw.getScaledInstance(F1Logo.getWidth(), F1Logo.getHeight(),
							Image.SCALE_SMOOTH);
					logo = new ImageIcon(resizedLogo);
					F1Logo.setIcon(logo);

					// Applies rates and time period of the institution and disables fields
					txtApy.setText("" + BAR);
					txtApy.setEnabled(false);
					time1.setText("" + BAT);
					time1.setEnabled(false);
					compounding1.selectWithKeyChar('d');
					compounding1.setEnabled(false);
					break;

				// User input
				case "User Input":
					// Sets institution logo to blank
					F1Logo.setIcon(null);

					// Blanks and enables all fields
					txtApy.setText(null);
					txtApy.setEnabled(true);
					time1.setText(null);
					time1.setEnabled(true);
					compounding1.setEnabled(true);
					break;
				}

			}

		}

	}

	// JComboBox Listener (LOGO 2)
	private class JListener2 implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			// Declares logos as BufferedImages
			BufferedImage WFLogoRaw = null, COBLogoRaw = null, BABLogoRaw = null;

			// Initializes logos and handles exceptions
			try {
				WFLogoRaw = ImageIO.read(new File("WFB.jpg"));
				COBLogoRaw = ImageIO.read(new File("C1B.png"));
				BABLogoRaw = ImageIO.read(new File("BAB.png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			// Checks for change in selection
			if (e.getStateChange() == ItemEvent.SELECTED) {
				String selection = (String) e.getItem();
				Image resizedLogo = null;
				ImageIcon logo = null;

				// Selection controller
				switch (selection) {

				// Wells Fargo
				case "Wells Fargo":
					F2Logo.setBounds(515, 118, 100, 100);
					resizedLogo = WFLogoRaw.getScaledInstance(F2Logo.getWidth(), F2Logo.getHeight(),
							Image.SCALE_SMOOTH);
					logo = new ImageIcon(resizedLogo);
					F2Logo.setIcon(logo);

					// Applies rates and time period of the institution and disables fields
					apy2.setText("" + WFR);
					apy2.setEnabled(false);
					time2.setText("" + WFT);
					time2.setEnabled(false);
					compounding2.selectWithKeyChar('d');
					compounding2.setEnabled(false);
					break;

				// Capital One
				case "Capital One":
					// Scales and sets institution's logo
					F2Logo.setBounds(F2Logo.getX() - 20, F2Logo.getY(), F2Logo.getWidth() + 40, F2Logo.getHeight());
					resizedLogo = COBLogoRaw.getScaledInstance(F2Logo.getWidth(), F2Logo.getHeight(),
							Image.SCALE_SMOOTH);
					logo = new ImageIcon(resizedLogo);
					F2Logo.setIcon(logo);

					// Applies rates and time period of the institution and disables fields
					apy2.setText("" + CAR);
					apy2.setEnabled(false);
					time2.setText("" + CAT);
					time2.setEnabled(false);
					compounding2.selectWithKeyChar('d');
					compounding2.setEnabled(false);
					break;

				// Bank of America
				case "Bank of America":
					// Scales and sets institution's logo
					F2Logo.setBounds(515, 118, 100, 100);
					resizedLogo = BABLogoRaw.getScaledInstance(F2Logo.getWidth(), F2Logo.getHeight(),
							Image.SCALE_SMOOTH);
					logo = new ImageIcon(resizedLogo);
					F2Logo.setIcon(logo);

					// Applies rates and time period of the institution and disables fields
					apy2.setText("" + BAR);
					apy2.setEnabled(false);
					time2.setText("" + BAT);
					time2.setEnabled(false);
					compounding2.selectWithKeyChar('d');
					compounding2.setEnabled(false);
					break;

				// User Input
				case "User Input":
					// Set insitution's logo to blank
					F2Logo.setIcon(null);

					// Blanks and enables all fields
					apy2.setText(null);
					apy2.setEnabled(true);
					time2.setText(null);
					time2.setEnabled(true);
					compounding2.setEnabled(true);
					break;
				}

			}

		}

	}
}

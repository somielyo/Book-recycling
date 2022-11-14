package ihm;

import donneur.Donner;
import porteur.Porteur;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Utilisateur extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8122690898756459137L;

	private JButton porteur;
	private JButton donneur;
	private JLabel label;
	private Donner premierdonneur;
	private Porteur premierporteur;

	public Utilisateur() {
		super("Recyclerie de bouquins");
		this.instanciate();
		this.setSize(900, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.placeComponents();
	}
	private void placeComponents() {
		JPanel mainPanel = this.getPanel();
		this.setContentPane(mainPanel);
	}
	private JPanel getPanel() {
		JPanel monPanel = new JPanel();

		GridBagLayout layout = new GridBagLayout();
		monPanel.setLayout(layout);
		GridBagConstraints gbc = new GridBagConstraints();

		// Put constraints on different buttons
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 2;
		monPanel.add(this.label, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		monPanel.add(this.donneur, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		monPanel.add(this.porteur, gbc);

		this.add(monPanel);
		this.donneur.addActionListener(this);
		this.porteur.addActionListener(this);
		return monPanel;
	}
	private void instanciate() {
		this.label = new JLabel("Vous êtes sur l'application Recyclerie du Bouquins, veuillez choisir : vous êtes donneur ou porteur?");
		this.porteur = new JButton("Porteur");
		this.donneur = new JButton("Donneur");
		this.premierdonneur = new Donner();
		this.premierporteur = new Porteur();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.donneur) {
			System.out.println("Vous êtes un donneur!");
			this.setVisible(false);
			this.premierdonneur.setVisible(true);
		}
		else if (e.getSource() == this.porteur) {
			System.out.println("Vous êtes un porteur!");
			this.setVisible(false);
			this.premierdonneur.setVisible(false);
			this.premierporteur.setVisible(true);
		}
	}
}

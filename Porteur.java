package porteur;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Porteur extends JFrame implements ActionListener{


	/**
	 * 
	 */
	private static final long serialVersionUID = 4697316374774303487L;

	private JButton btnAfficher;

	private JLabel asideTitle;
	//private JPanel affichagePanel;

	private JPanel ImagePanel;



	public Porteur(){
		super("Porteur");
		this.instanciate();
		this.placeComponents();
		this.setSize(500, 500);
		//this.setExtendedState(MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	private void instanciate(){
		this.btnAfficher = new JButton("Afficher les Livres");
		this.asideTitle = new JLabel("Bienvenue pour afficher les livres disponibles veuillez cliquez sur le bouton, Merci!");
		this.ImagePanel = new JPanel();
		this.setLayout(new BorderLayout());
	}
	private void placeComponents(){

		this.add(this.asideTitle, BorderLayout.NORTH);
		this.add(this.btnAfficher, BorderLayout.EAST);
		this.btnAfficher.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.btnAfficher) {
			System.out.println("bouton bien appelé ");
			ReadFile Rf = new ReadFile();
			this.add(Rf.ImageAfficheur(this.ImagePanel));
		}

	}
}

package donneur;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Donner extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5884147538894867036L;


	private JLabel zoneTF;
	private JTextField tf;
	private JButton sauvgarde;
	private JButton uploadImage;

	private JLabel label;


	public Donner(){
		super("Donneur");
		this.instanciate();
		this.place();
		this.setSize(900, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//this.setVisible(true);
	}
	private void instanciate(){
		this.zoneTF = new JLabel("Entrez le nom du Livre:");
		this.tf = new JTextField(30);
		this.sauvgarde = new JButton("Sauvegarder");
		this.uploadImage = new JButton("Insérez l'image de la page de garde");
		this.label = new JLabel();
	}
	private void place() {
		JPanel donneurPanel = this.getPanel();
		this.setContentPane(donneurPanel);
	}
	private JPanel getPanel() {
		JPanel RangeTout = new JPanel();

		JPanel donneurPanel = new JPanel();
		donneurPanel.setLayout(new GridLayout(0,1));


		JPanel buttonlayout = new JPanel();
		buttonlayout.setLayout (new GridLayout(0, 1));

		JPanel labLayout = new JPanel();
		labLayout.add(this.label);

		donneurPanel.add(this.zoneTF);
		donneurPanel.add(this.tf);
		donneurPanel.add(Box.createVerticalGlue());
		buttonlayout.add(this.uploadImage);
		buttonlayout.add(Box.createVerticalGlue());
		buttonlayout.add(this.sauvgarde);
		buttonlayout.add(Box.createVerticalGlue());
		donneurPanel.add(buttonlayout);
		donneurPanel.add(labLayout);

		RangeTout.add(donneurPanel);

		this.add(RangeTout);
		this.sauvgarde.addActionListener(this);
		this.uploadImage.addActionListener(this);

		return RangeTout;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Sauvegarde Sv = new Sauvegarde();

			// TODO Auto-generated method stub
			if (e.getSource() == this.uploadImage) {

				Sv.uploadImage();

			}if (e.getSource() == this.sauvgarde) {
				Sv.sauvegardeNomLivre(this.tf);
				ThreadRemerciement TR = new ThreadRemerciement(this.label);
				TR.start();
			}} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

	}

}

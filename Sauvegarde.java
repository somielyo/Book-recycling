package donneur;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;

public class Sauvegarde {
	private JFileChooser chooser = new JFileChooser();
	private	JInternalFrame jInternalFrame1;
	private PrintWriter pwImage;
	private PrintWriter pwNom;

	public Sauvegarde() throws IOException {
		this.chooser = new JFileChooser();
		this.jInternalFrame1 = new JInternalFrame();
		this.pwImage = new PrintWriter(new FileWriter("src/ImageSauvegarde.txt", true));
		this.pwNom = new PrintWriter(new FileWriter("src/NomSauvegarde.txt", true));
		//this.fichierSauvegarde = new BufferedWriter(new FileWriter("fichierSauvegarde.txt"));
	}
	public void uploadImage() {

		chooser.showOpenDialog(null);
		File f = chooser.getSelectedFile();
		String filename = f.getPath();
		jInternalFrame1.getDesktopIcon();
		System.out.println(filename);
		this.pwImage.write(filename+"\n");
		//this.pw.newLine();
		this.pwImage.close();
	}
	public void sauvegardeNomLivre(JTextField tf) {

		this.pwNom.write(tf.getText()+"\n");
		this.pwNom.close();
	}

}

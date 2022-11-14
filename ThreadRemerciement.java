package donneur;

import javax.swing.JLabel;

public class ThreadRemerciement extends Thread {

	private JLabel label;

	public ThreadRemerciement(JLabel label) {
		this.label = label;
	}

	public void run() {
		String[] tab = {"Enregistrement en cours",".",".","."};
		for (int i=0; i<4; i++) {
			try {
				System.out.print(tab[i]);
				this.label.setText(this.label.getText()+" "+tab[i]);
				sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		this.label.setText("Merci pour votre don !");
	}



}

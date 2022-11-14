package porteur;

import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ReadFile extends Thread{

	private ArrayList<String> images;

	public ReadFile(){
		this.images = new ArrayList<String> ();
	}

	public  ArrayList<String> AfficherLivres(){

		try  
		{  
			File Imagefile = new File("src/ImageSauvegarde.txt");
			FileReader fr1 = new FileReader(Imagefile);
			BufferedReader br=new BufferedReader(fr1);

			String line;
			while((line=br.readLine())!=null)  
			{  
				System.out.println(line);
				this.images.add(line);
			}	
			br.close();
			fr1.close();
		}
		catch(IOException e)  
		{  
			e.printStackTrace(); 
			System.out.println("erreur ");
		}

		return this.images;
	}
	public JPanel ImageAfficheur(JPanel panel){
		ArrayList<String> img = AfficherLivres();
		panel = new JPanel();


		JLabel label = new JLabel();
		try {
			for(int i = 0 ; i < img.size(); i++) {
				ImageIcon Image = new ImageIcon(img.get(i).toString());
				label = new JLabel(Image);
				panel.setLayout(new GridLayout(i,i+1));
				panel.add(label);
				sleep(200);
			} 

		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return panel;
	}

}
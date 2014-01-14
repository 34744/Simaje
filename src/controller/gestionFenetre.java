package controller;

import view.Parametres;
import view.accueil;

public class gestionFenetre {

	public static void eraseContainerPaneMainJFrame(){
		view.mainJFrame.eraseContainerPanel();
		}
	
	
	public static void application (){
		view.Application appli = new view.Application();
		view.mainJFrame.setContainerPanel(appli);
		
	}
	
	public static void configurationModif (boolean modification){
		view.Parametres config = new view.Parametres(false);
		view.mainJFrame.setContainerPanel(config);
		
	}
	
	public static void configurationAjout (boolean modification){
		view.Parametres config = new view.Parametres(true);
		view.mainJFrame.setContainerPanel(config);
		
	}
	
	public static void configurationUtilisateur (boolean actifUtilisateur){
		view.Parametres config = new view.Parametres(true);
		view.mainJFrame.setContainerPanel(config);
		
	}
	
	
	public static void accueil (){
		view.accueil acc = new view.accueil();
		view.mainJFrame.setContainerPanel(acc);
		
	}
	
	
}

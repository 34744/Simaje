package model;

import java.sql.SQLException;
import java.sql.Statement;

import controller.ControllerDB;

import javax.swing.JOptionPane;

public class majData {
 
	public static void MajApplication (application application){
		try{
			Statement stat = controller.ControllerDB.connectionDB().createStatement();
									 
			String instructionSQL="UPDATE application SET nomApplication='"
			+application.getNomApplication()+"', visibiliteApplication='"
			+application.getVisibiliteApplication()+ "' WHERE idApplication='" 
			+ application.getIdApplication()+"' ";
			int nbIns = stat.executeUpdate(instructionSQL);
			
		}catch (SQLException aDO){
			JOptionPane.showMessageDialog(null, aDO, "Erreur Type", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void MajUtilisateur(utilisateur utilisateur){
		try{
			Statement stat = controller.ControllerDB.connectionDB().createStatement();
									 
			String instructionSQL="UPDATE utilisateur SET nomUtilisateur='"
			+utilisateur.getNomUtilisateur()+"', prenomUtilisateur='"
			+utilisateur.getPrenomUtilisateur()+"', numUlis='"
			+utilisateur.getNumUlis()+"', mailUtilisateur='"
			+utilisateur.getMailUtilisateur()+"', utilisateurActif='"
			+utilisateur.getActifUtilisateur()+"', directionUtilisateur='"
			+utilisateur.getUtilisateurDirection()
			+ "' WHERE numUlis='" 
			+ utilisateur.getNumUlis()+"' ";
			int nbIns = stat.executeUpdate(instructionSQL);
			
		}catch (SQLException aDO){
			JOptionPane.showMessageDialog(null, aDO, "Erreur Type", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void MajCompoCellule(compoCellule cellule) {
        try {
                Statement stat = controller.ControllerDB.connectionDB()
                                .createStatement();
                String instructionSQL="UPDATE compocellule SET dateDebutCellule='"
            			+cellule.getDateFinCellule()+"', dateFinCellule='"
            			+cellule.getDateFinCellule()
            			+ "' WHERE idCellule='" 
            			+ cellule.getFkCellule()+"' AND idUtilisateur='"
            			+cellule.getFkUtilisateur() +"' ";
                
                int nbIns = stat.executeUpdate(instructionSQL);
               

        } catch (SQLException aDO) {
                JOptionPane.showMessageDialog(null, aDO, "Erreur Type",
                                JOptionPane.ERROR_MESSAGE);
        }
	}
	
	public static void MajDirectionGenerale (directionGenerale directionGenerale){
		try{
			Statement stat = controller.ControllerDB.connectionDB().createStatement();
									 
			String instructionSQL="UPDATE directiongeneral SET nomDG='"
			+directionGenerale.getNomDirectionGenerale()+"', visibiliteDG='"
			+directionGenerale.getVisibiliteDg()+ "' WHERE idDG='" 
			+ directionGenerale.getIdDirectionGenerale()+"' ";
			int nbIns = stat.executeUpdate(instructionSQL);
			
		}catch (SQLException aDO){
			JOptionPane.showMessageDialog(null, aDO, "Erreur Type", JOptionPane.ERROR_MESSAGE);
		}
	}
}

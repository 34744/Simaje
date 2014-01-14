package controller;

import java.sql.Connection;
import java.util.StringTokenizer;
import java.util.Vector;

import view.Application;
import model.application;
import model.applicationArbre;
import model.cellule;
import model.compoCellule;
import model.compoCelluleArbre;
import model.direction;
import model.directionArbre;
import model.directionGenerale;
import model.directionGeneraleArbre;
import model.getData;
import model.majData;
import model.utilisateur;
import model.utilisateurArbre;

	public class ControllerDB {
		public static Connection connectionDB() {
			return model.AccesDB.GetInstance();
			}
		
		public static void fermetureDB(){
			model.AccesDB.closeDB();
			}
		
		public static utilisateur getUser(String nom) {
			return getData.getUser(nom);        }
		
		public static Vector<application> getApplication(){
			return model.getData.getApplication();
		}
		
		public static Vector<applicationArbre> getApplicationArbre(){
			return model.getData.getApplicationArbre();
		}
		
		public static applicationArbre getApplicationArbre(String application){
			return model.getData.getApplicationArbre(application);
		}
		
		public static void ModifApplication(application application){
			majData.MajApplication(application);
		}
		
		public static Vector<utilisateur> getUtilisateur(){
			return model.getData.getUtilisateur();
		}
		
		public static Vector<utilisateurArbre> getUtilisateurArbre(){
			return model.getData.getUtilisateurArbre();
		}
		
		public static utilisateurArbre getUtilisateurArbre(String numUlis){
			return model.getData.getUtilisateurArbre(numUlis);
		}
		
		public static Vector<utilisateurArbre> getUtilisateurActifArbre(){
			return model.getData.getUtilisateurActifArbre();
		}
		
		public static Vector<direction> getDirectionUtilisateur(){
			return model.getData.getDirection();

		}
		
		public static Vector<directionArbre> getDirectionUtilisateurArbre(){
			return model.getData.getDirectionArbre();
		}
		
		public static Vector<directionGenerale> getDirectionGenerale(){
			return model.getData.getDirectionGenerale();

		}
		
		public static Vector<directionGeneraleArbre> getDirectionGeneraleArbre(){
			return model.getData.getDirectionGeneraleArbre();
		}
		
		public static void ModifDg(directionGenerale directionGenerale){
			majData.MajDirectionGenerale(directionGenerale);
		}
		
		public static Vector<compoCellule> getCompoCellule(){
			return model.getData.getCompoCellule();

		}
		
		public static Vector<cellule> getCellule(){
			return model.getData.getCellule();

		}
		
		public static Vector<cellule> getCellule(String nomCellule){
			return model.getData.getCellule(nomCellule);

		}
		
		public static cellule getCelluleSele(String nomCellule){
			return model.getData.getCelluleSelect(nomCellule);
		}
		
		public static Vector<cellule> getCelluleNonUtilisee(int idUtilisateur){
			return model.getData.getCelluleNonActive(idUtilisateur);

		}
		
		
		public static compoCelluleArbre getCompoCelluleArbre(String numUlis){
			return model.getData.getCompoCelluleArbre(numUlis);
		}
		
		public static Vector<compoCelluleArbre> getCompoCelluleArbre(){
			return model.getData.getCompoCelluleArbre();

		}

		public static Vector<compoCelluleArbre> getCompoCelluleVecteurArbre(String numUlis) {
			return model.getData.getCompoCelluleVecteurArbre(numUlis);
		}

		public static directionGeneraleArbre getDirectionGeneraleArbre(String directionGenerale) {
			return model.getData.getDirectionGeneraleArbre(directionGenerale);
		}
	}
	


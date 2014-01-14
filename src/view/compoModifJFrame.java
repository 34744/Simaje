package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.cellule;
import model.utilisateur;
import model.utilisateurArbre;

import com.toedter.calendar.JDateChooser;

import controller.ControllerDB;

public class compoModifJFrame extends JFrame implements ActionListener {


	private JFrame frame = new JFrame();
	private JPanel contentPane;
	private JComboBox comboBoxCellule;
	private JTextField textField;
	private JButton btnValider = new JButton("Valider");
	private JDateChooser calendrierDebut= new JDateChooser();
	private JDateChooser calendrierFin= new JDateChooser();
	private utilisateur user=new utilisateur();
	private model.compoCellule compoCellule = new model.compoCellule();
	private String numUlis;
	private JTable table;
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public compoModifJFrame(String numUlis, String nomCellule, Date dateDebut, Date dateFin) {
		System.out.println(dateDebut);
		this.numUlis=numUlis;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 413, 122);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		comboBoxCellule = new JComboBox();
		comboBoxCellule.setBounds(10, 11, 130, 20);
		contentPane.add(comboBoxCellule);
		
		Vector<model.cellule> vectCellule = new Vector<model.cellule>();
		vectCellule = controller.ControllerDB.getCellule();
		//vectCellule = controller.ControllerDB.getCellule();
		comboBoxCellule.addItem(nomCellule);
		
		btnValider.setBounds(160, 54, 89, 23);
		contentPane.add(btnValider);
		
		calendrierDebut.setBounds(150, 11, 110, 20);
		calendrierDebut.setDateFormatString("dd/MM/yyyy");

		/*
		String s = dateDebut;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date d = null;
		try {
			d = sdf.parse(s);
			System.out.println("d"+d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
		
		calendrierDebut.setDate(dateDebut);
		getContentPane().add(calendrierDebut);
		System.out.println(dateDebut);
		calendrierFin.setBounds(280, 11, 110, 20);
		calendrierFin.setDateFormatString("dd/MM/yyyy");
		calendrierFin.setDate(dateFin);
		getContentPane().add(calendrierFin);

		
		MyButtonListener list = new MyButtonListener();
		btnValider.addActionListener(list);
		
	}
	
	private void conversion(){
		
	}
	
	private class MyButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object source = e.getSource();
			
			if(source == btnValider){
				String nomCellule = comboBoxCellule.getSelectedItem().toString();
				cellule celluleArbre = ControllerDB.getCelluleSele(nomCellule);
				utilisateurArbre utilisateurArbre=ControllerDB.getUtilisateurArbre(numUlis);
				int idCellule= celluleArbre.getIdCellule();
				int idUtilisateur=utilisateurArbre.getIdUtilisateur();
				Date debut=calendrierDebut.getDate();
				String dateDebut = dateFormat.format(debut);
				
				Date fin=calendrierFin.getDate();
				String dateFin = dateFormat.format(fin);
				
				compoCellule.setFkCellule(idCellule);
				compoCellule.setFkUtilisateur(idUtilisateur);
				compoCellule.setDateDebutCellule(dateDebut);
				if(calendrierFin.getDate()!=null){
				compoCellule.setDateFinCellule(dateFin);
				}
				else{
					compoCellule.setDateFinCellule("");
				}
				model.majData.MajCompoCellule(compoCellule);
				System.out.println(compoCellule.getFkCellule());
				System.out.println(compoCellule.getFkUtilisateur());
				System.out.println(compoCellule.getDateDebutCellule());
				System.out.println(compoCellule.getDateFinCellule());
				/*table.removeAll();
				table.repaint();
				table.requestFocus();*/
				hide();
				
				
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

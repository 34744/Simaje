package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import controller.ControllerDB;
import model.application;
import model.applicationArbre;
import model.applicationModelTableau;
import model.compoCelluleModelTableau;
import model.direction;
import model.utilisateur;
import model.utilisateurArbre;
import model.utilisateurModelTableau;

import javax.swing.border.LineBorder;
import javax.swing.plaf.PanelUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.SystemColor;

import javax.swing.JSeparator;
import javax.swing.JTextField;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.swing.JCheckBox;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.JScrollPane;

import sun.swing.MenuItemLayoutHelper.ColumnAlignment;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseMotionAdapter;

class ComposantOnglet extends JPanel implements ActionListener {
	  private JTabbedPane pane;
	 
	  public ComposantOnglet(String titre, JTabbedPane pane) {
	    this.pane = pane;
	    setOpaque(false);
	    JLabel label = new JLabel(titre);
	    add(label);
	    JButton button = new JButton("Fermer");
	    button.setPreferredSize(new Dimension(50,30));
	    button.addActionListener(this);
	   // add(button);
	  }
	 
	  public void actionPerformed(ActionEvent e) {
	    int i = pane.indexOfTabComponent(this);
	    if (i != -1)
	      pane.remove(i);
	  }
	}


public class Parametres extends JPanel {
	compoCelluleJFrame fenetreAjout;
	/* 
	 * ---------------------------------------------------------------------------------------------------
	 * 									VARIABLES FENETRE
	 * ---------------------------------------------------------------------------------------------------
	 * 
	 */
	
	
	
	/* 
	 * ---------------------------------------------------------------------------------------------------
	 * 									VARIABLES NAVIGATION
	 * ---------------------------------------------------------------------------------------------------
	 * 
	 */
	private JButton btnHome = new JButton("Accueil");
	private JButton btnRapports = new JButton("Rapports");
	private JButton btnSoftware = new JButton("Application");
	private JButton btnConfig = new JButton("Configuration");
	private JButton btnUpdate = new JButton("Mise \u00E0 jour");
	
	/* 
	 * ---------------------------------------------------------------------------------------------------
	 * 									VARIABLES JTTABBEDPANE
	 * ---------------------------------------------------------------------------------------------------
	 * 
	 */
	JTabbedPane pane = new JTabbedPane(JTabbedPane.LEFT);
	private int ongletSelectionne=0;
	
	/* 
	 * ---------------------------------------------------------------------------------------------------
	 * 									VARIABLES APPLICATION
	 * ---------------------------------------------------------------------------------------------------
	 * 
	 */
	JPanel ongletAppli = new JPanel();
	JLabel lblErreur = new JLabel("Veuillez compl\u00E9ter le champ manquant ou corriger le contenu!");
	private JButton btnNewAppli = new JButton("Ajouter");
	private JButton btnAjouterAppli = new JButton("Valider");
	private JTable tableAppli;
	private Vector<model.applicationArbre> vectAppli = new Vector<model.applicationArbre>();
	private applicationModelTableau modelAppli;
	public application appli = new application();
	private final JButton btnModifier = new JButton("Valider");
	private JTextField textFieldModifAppli;
	private JTextField textFieldAjoutAppli;
	private JCheckBox chckbxArchiverModif = new JCheckBox("");
	private JCheckBox chckbxArchiverAjt = new JCheckBox("");
	public JPanel panelAjouter = new JPanel();
	private final JButton btnAffModifierAppli = new JButton("Modifier");
	private int idAppliSelec;
	/* 
	 * ---------------------------------------------------------------------------------------------------
	 * 									VARIABLES UTILISATEUR
	 * ---------------------------------------------------------------------------------------------------
	 * 
	 */
	public boolean directionRempli=false;
	JPanel ongletUtilisateur = new JPanel();
	private JTable tableUtilisateur;
	private Vector<model.utilisateurArbre> vectUtilisateur = new Vector<model.utilisateurArbre>();
	private utilisateurArbre utilisateurActif = new utilisateurArbre();
	private utilisateurModelTableau modelUtilisateur;
	public utilisateur user = new utilisateur();
	public String utilisateurSelectionne;
	private final JLabel lblActifModif = new JLabel("Archiv\u00E9e");
	private final JLabel lblActifAjt = new JLabel("Archiv\u00E9e");
	private JTextField textFieldNomUtilisateur;
	private JTextField textFieldPrenomUtilisateur;
	private JTextField textFieldUlisUtilisateur;
	private JTextField textFieldAdresseMail;
	private JComboBox<String> comboBoxDirectionUtilisateur = new JComboBox<String>();
	private JCheckBox chckbxUtilisateurActif = new JCheckBox("Actif uniquement");
	private JCheckBox chckbxActifUtilisateur = new JCheckBox("Actif");
	private JTextField textFieldDgUtilisateur;
	private JTextField textFieldDirectionUtilisateur;
	private JButton btnModifierUtilisateur = new JButton("Valider");
	private String directionUtilisateurSelectionne;
	private model.directionArbre directionArbre= new model.directionArbre();
	private JButton btnAjouterUtilisateur = new JButton("User (+)");
	private JButton btnValiderAjoutUtilisateur = new JButton("Valider");
	tableUtilisateurRenderer rendererTableUtilisateur = new tableUtilisateurRenderer();
	/* 
	 * ---------------------------------------------------------------------------------------------------
	 * 									VARIABLES DIRECTION
	 * ---------------------------------------------------------------------------------------------------
	 * 
	 */
	private Vector<direction> vectDirection = new Vector<model.direction>();
	/* 
	 * ---------------------------------------------------------------------------------------------------
	 * 									VARIABLES DIRECTION GENERALE
	 * 
	 * ---------------------------------------------------------------------------------------------------
	 * 
	 */
	panelParametreDg ongletDg = new panelParametreDg();
	/* 
	 * ---------------------------------------------------------------------------------------------------
	 * 									VARIABLES CELLULE
	 * ---------------------------------------------------------------------------------------------------
	 * 
	 */
	public JPanel panelUtilisateurCellule = new JPanel();
	private JTable tableCompoCellule;
	private Vector<model.compoCelluleArbre> vectCompoCellule = new Vector<model.compoCelluleArbre>();
	private compoCelluleModelTableau compoCelluleModelTableau;
	public 	model.compoCellule compoCellule = new model.compoCellule();
	private model.compoCelluleArbre compoCelluleArbre = new model.compoCelluleArbre();
	model.compoCelluleArbre compoCelluleArbreAjout = new model.compoCelluleArbre();
	private JButton btnUtilisateurModifiable = new JButton("Modifier");
	private JButton btnCelluleAjouter = new JButton("");
	private JButton btnCelluleSupprimer = new JButton("-");
	tableCompoCelluleRenderer rendererTableCompoCellule = new tableCompoCelluleRenderer();
	JComboBox comboCellule = new JComboBox();
	private boolean frameAjoutFenetre = false;
	public boolean isFrameAjoutFenetre() {
		return frameAjoutFenetre;
	}
	public void setFrameAjoutFenetre(boolean frameAjoutFenetre) {
		this.frameAjoutFenetre = frameAjoutFenetre;
	}

	private JPanel panelModifierUtilisateur = new JPanel();
	
	/**
	 * Create the panel.
	 */
	public Parametres(boolean ajout) {
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(java.awt.event.MouseEvent arg0) {
				/*if(fenetreAjout.isShowing() &&frameAjoutFenetre ==true){
	            	 
	             }
	             else{
	            	 tableCompoCellule.removeAll();
		             tableCompoCellule.repaint(); 
	             }	*/
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(java.awt.event.MouseEvent arg0) {
			}
		});
		
		/* 
		 * ---------------------------------------------------------------------------------------------------
		 * 									DEBUT INITIALISATION FENETRE
		 * ---------------------------------------------------------------------------------------------------
		 * 
		 */
		
		setBackground(new Color(176, 196, 222));
		setLayout(null);
		
		/* 
		 * ---------------------------------------------------------------------------------------------------
		 * 									DEBUT INITIALISATION BARRE NAVIGATION
		 * ---------------------------------------------------------------------------------------------------
		 * 
		 */
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setFont(new Font("Tahoma", Font.BOLD, 14));
		toolBar.setForeground(Color.WHITE);
		toolBar.setBackground(new Color(211, 211, 211));
		toolBar.setBounds(22, 0, 778, 49);
		add(toolBar);
		

		btnHome.setIcon(new ImageIcon(Application.class.getResource("/icones/home41.png")));
		btnHome.setSelectedIcon(new ImageIcon(Application.class.getResource("/icones/home41.png")));
		toolBar.add(btnHome);
		btnSoftware.setSelectedIcon(new ImageIcon(Application.class.getResource("/icones/Application41.png")));
		

		btnSoftware.setIcon(new ImageIcon(Application.class.getResource("/icones/Application41.png")));
		toolBar.add(btnSoftware);
		btnUpdate.setSelectedIcon(new ImageIcon(Application.class.getResource("/icones/update41.png")));
		

		btnUpdate.setIcon(new ImageIcon(Application.class.getResource("/icones/update41.png")));
		toolBar.add(btnUpdate);
		btnRapports.setSelectedIcon(new ImageIcon(Application.class.getResource("/icones/rapports41.png")));
		

		btnRapports.setIcon(new ImageIcon(Application.class.getResource("/icones/rapports41.png")));
		toolBar.add(btnRapports);
		btnConfig.setSelectedIcon(new ImageIcon(Application.class.getResource("/icones/configuration41.png")));
		

		btnConfig.setIcon(new ImageIcon(Application.class.getResource("/icones/configuration41.png")));
		toolBar.add(btnConfig);
		
		JToggleButton tglbtnModifier = new JToggleButton("Modifier");
		tglbtnModifier.setIcon(new ImageIcon(Application.class.getResource("/icones/modifiable41.png")));
		
		tglbtnModifier.setToolTipText("Modifier");
		
		if(tglbtnModifier.isSelected()==false)
		{
		tglbtnModifier.setIcon(new ImageIcon(Application.class.getResource("/icones/modifiable41.png")));
		System.out.println("test");
		}
		
		else
		{
			tglbtnModifier.setIcon(new ImageIcon(Application.class.getResource("/icones/modifiableG41.png")));
			
		}
		toolBar.add(tglbtnModifier);

		/* 
		 * ---------------------------------------------------------------------------------------------------
		 * 									DEBUT INITIALISATION PANEL
		 * ---------------------------------------------------------------------------------------------------
		 * 
		 */		

		pane.setBounds(22, 102, 746, 380);
		add(pane);
		
		
		/* 
		 * ---------------------------------------------------------------------------------------------------
		 * 									DEBUT PANEL APPLICATION
		 * ---------------------------------------------------------------------------------------------------
		 * 
		 */
		

		

		ongletAppli.setLayout(null);
		
		vectAppli = controller.ControllerDB.getApplicationArbre();
		modelAppli = new applicationModelTableau(vectAppli);
		tableAppli = new JTable(modelAppli);
		tableAppli.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Object source = arg0.getSource();
				if(tableAppli.getSelectedRow()!=-1){
					remplirApplication(tableAppli.getValueAt(tableAppli.getSelectedRow(),0).toString());
					tableCompoCellule.removeAll();
					tableCompoCellule.repaint();
					
				}
			}
		});
		tableAppli.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableAppli.setColumnSelectionAllowed(true);
		tableAppli.setToolTipText("S\u00E9lectionnez l'application d\u00E9sir\u00E9e");
		tableAppli.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
		tableAppli.setForeground(Color.WHITE);
		tableAppli.setFont(new Font("Tahoma", Font.BOLD, 14));
		tableAppli.setBackground(new Color(211, 211, 211));
		tableAppli.setBounds(10, 40, 130, 200);
		tableAppli.setAutoCreateRowSorter(true);
		tableAppli.getRowSorter().toggleSortOrder(0);
		tableAppli.setAutoCreateRowSorter(false);
		
		ongletAppli.setPreferredSize(new Dimension(300, 80));
		JScrollPane scrollPaneAppli = new JScrollPane(tableAppli);
		scrollPaneAppli.setVisible(true);
		scrollPaneAppli.setBounds(10, 40, 156, 219);
		ongletAppli.add(scrollPaneAppli);
		
		pane.addTab("Applications", ongletAppli);
		JPanel panelModifier = new JPanel();
		panelModifier.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelModifier.setBounds(302, 83, 200, 128);
		ongletAppli.add(panelModifier);
		panelModifier.setLayout(null);
		
		JLabel lblModifier = new JLabel("Modifier");
		lblModifier.setBounds(72, 11, 55, 17);
		lblModifier.setForeground(SystemColor.inactiveCaption);
		lblModifier.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		panelModifier.add(lblModifier);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(SystemColor.text);
		separator.setForeground(SystemColor.menu);
		separator.setBounds(40, 25, 118, 8);
		panelModifier.add(separator);
		
		textFieldModifAppli = new JTextField();
		textFieldModifAppli.setBounds(10, 63, 118, 20);
		panelModifier.add(textFieldModifAppli);
		textFieldModifAppli.setColumns(10);
		btnModifier.setBounds(56, 94, 89, 23);
		panelModifier.add(btnModifier);
		
		JLabel lblNomApplicationModif = new JLabel("Nom de l'application");
		lblNomApplicationModif.setForeground(SystemColor.inactiveCaption);
		lblNomApplicationModif.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNomApplicationModif.setBounds(10, 44, 118, 14);
		panelModifier.add(lblNomApplicationModif);
		
		chckbxArchiverModif.setBounds(152, 60, 23, 23);
		panelModifier.add(chckbxArchiverModif);
		lblActifModif.setForeground(SystemColor.inactiveCaption);
		lblActifModif.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblActifModif.setBounds(137, 44, 53, 14);
		
		panelModifier.add(lblActifModif);
		
		
		panelAjouter.setLayout(null);
		panelAjouter.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelAjouter.setBounds(302, 83, 200, 128);
		ongletAppli.add(panelAjouter);
		
		JLabel lblAjouter = new JLabel("Ajouter");
		lblAjouter.setForeground(SystemColor.inactiveCaption);
		lblAjouter.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblAjouter.setBounds(75, 11, 55, 17);
		panelAjouter.add(lblAjouter);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBackground(Color.WHITE);
		separator_1.setBounds(43, 28, 118, 8);
		panelAjouter.add(separator_1);
		
		textFieldAjoutAppli = new JTextField();
		textFieldAjoutAppli.setBounds(10, 63, 118, 20);
		
		panelAjouter.add(textFieldAjoutAppli);
		textFieldAjoutAppli.setColumns(10);
		
		
		btnAjouterAppli.setBounds(58, 94, 89, 23);
		panelAjouter.add(btnAjouterAppli);
		
		chckbxArchiverAjt.setBounds(156, 63, 23, 23);
		panelAjouter.add(chckbxArchiverAjt);
		
		JLabel lblNomApplicationAjt = new JLabel("Nom de l'application");
		lblNomApplicationAjt.setForeground(SystemColor.inactiveCaption);
		lblNomApplicationAjt.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNomApplicationAjt.setBounds(10, 47, 118, 14);
		panelAjouter.add(lblNomApplicationAjt);
		lblActifAjt.setForeground(SystemColor.inactiveCaption);
		lblActifAjt.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblActifAjt.setBounds(138, 47, 53, 14);
		
		panelAjouter.add(lblActifAjt);
		
		
		btnNewAppli.setBounds(31, 274, 89, 23);
		ongletAppli.add(btnNewAppli);
		btnAffModifierAppli.setBounds(31, 274, 89, 23);
		
		ongletAppli.add(btnAffModifierAppli);
		
		if(ajout == false){
			panelAjouter.setVisible(false);
			panelModifier.setVisible(true);
			btnAffModifierAppli.setVisible(false);
			btnNewAppli.setVisible(true);
		}
		else
		{
			panelAjouter.setVisible(true);
			panelModifier.setVisible(false);
			btnAffModifierAppli.setVisible(true);
			btnNewAppli.setVisible(false);
		}
		
		/* 
		 * ---------------------------------------------------------------------------------------------------
		 * 									DEBUT PANEL UTILISATEUR
		 * ---------------------------------------------------------------------------------------------------
		 * 
		 */
		ongletUtilisateur.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
			}
		});
		ongletUtilisateur.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
			
			}
		});
		

		ongletUtilisateur.setLayout(null);

		vectUtilisateur = controller.ControllerDB.getUtilisateurArbre();
		modelUtilisateur = new utilisateurModelTableau(vectUtilisateur);
		tableUtilisateur = new JTable(modelUtilisateur);
		tableUtilisateur.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Object source = arg0.getSource();
				if(tableUtilisateur.getSelectedRow()!=-1){
					utilisateurSelectionne=tableUtilisateur.getValueAt(tableUtilisateur.getSelectedRow(), 2).toString();
					remplirUtilisateur(tableUtilisateur.getValueAt(tableUtilisateur.getSelectedRow(),0).toString());
					remplirCompoCellule(textFieldUlisUtilisateur.getText());
					btnModifierUtilisateur.setVisible(false);
					btnValiderAjoutUtilisateur.setVisible(true);
				}
			}
		});
		tableUtilisateur.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableUtilisateur.setColumnSelectionAllowed(true);
		tableUtilisateur.setToolTipText("S\u00E9lectionnez l'utilisateur d\u00E9sir\u00E9");
		tableUtilisateur.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
		tableUtilisateur.setForeground(Color.WHITE);
		tableUtilisateur.setFont(new Font("Tahoma", Font.BOLD, 13));
		tableUtilisateur.setBackground(new Color(211, 211, 211));
		tableUtilisateur.setBounds(7, 40, 95, 128);
		tableUtilisateur.getColumnModel().getColumn(0).setPreferredWidth(75);
		tableUtilisateur.getColumnModel().getColumn(1).setPreferredWidth(60);
		tableUtilisateur.getColumnModel().getColumn(2).setPreferredWidth(25);
		tableUtilisateur.getColumnModel().getColumn(3).setPreferredWidth(190);
		tableUtilisateur.setAutoCreateRowSorter(true);
		tableUtilisateur.getRowSorter().toggleSortOrder(0);
		tableUtilisateur.setAutoCreateRowSorter(false);
		tableUtilisateur.setDefaultRenderer(Object.class, new tableUtilisateurRenderer());
		JScrollPane scrollPaneUtilisateur = new JScrollPane(tableUtilisateur);
		scrollPaneUtilisateur.setVisible(true);
		scrollPaneUtilisateur.setBounds(10, 11, 600, 105);
		
		ongletUtilisateur.setPreferredSize(new Dimension(300, 80));
		ongletUtilisateur.add(scrollPaneUtilisateur);
		pane.addTab("Utilisateurs", ongletUtilisateur);
		
		
		panelModifierUtilisateur.setBorder(new LineBorder(SystemColor.inactiveCaption));
		panelModifierUtilisateur.setBounds(10, 139, 625, 182);
		ongletUtilisateur.add(panelModifierUtilisateur);
		panelModifierUtilisateur.setLayout(null);
		
		textFieldPrenomUtilisateur = new JTextField();
		textFieldPrenomUtilisateur.setText("Pr\u00E9nom");
		textFieldPrenomUtilisateur.setBounds(338, 20, 173, 20);
		textFieldPrenomUtilisateur.setColumns(10);
		textFieldPrenomUtilisateur.addFocusListener(new FocusAdapter(){
			public void focusGained(FocusEvent e){
				if(btnValiderAjoutUtilisateur.isVisible()==true && comboBoxDirectionUtilisateur.getSelectedIndex()==0){
					textFieldPrenomUtilisateur.setText("");
				}
			}
		});
		panelModifierUtilisateur.add(textFieldPrenomUtilisateur);
		
		
		textFieldNomUtilisateur = new JTextField();
		textFieldNomUtilisateur.setText("Nom");
		textFieldNomUtilisateur.setBounds(146, 20, 173, 20);
		panelModifierUtilisateur.add(textFieldNomUtilisateur);
		textFieldNomUtilisateur.setColumns(10);
		textFieldNomUtilisateur.addFocusListener(new FocusAdapter(){
			public void focusGained(FocusEvent e){
				if(btnValiderAjoutUtilisateur.isVisible()==true && comboBoxDirectionUtilisateur.getSelectedIndex()==0){
					textFieldNomUtilisateur.setText("");
				}
			}
		});
		textFieldUlisUtilisateur = new JTextField();
		textFieldUlisUtilisateur.setText("n\u00B0Ulis");
		textFieldUlisUtilisateur.setColumns(10);
		textFieldUlisUtilisateur.setBounds(10, 20, 70, 20);
		panelModifierUtilisateur.add(textFieldUlisUtilisateur);
		
		textFieldAdresseMail = new JTextField();
		textFieldAdresseMail.setText("Adresse Mail");
		textFieldAdresseMail.setBounds(338, 51, 277, 20);
		panelModifierUtilisateur.add(textFieldAdresseMail);
		textFieldAdresseMail.setColumns(10);
		textFieldAdresseMail.addFocusListener(new FocusAdapter(){
			public void focusGained(FocusEvent e){
				if(btnValiderAjoutUtilisateur.isVisible()==true){
					textFieldAdresseMail.setText("");
				}
			}
		});

		chckbxActifUtilisateur.setBounds(518, 19, 97, 23);
		panelModifierUtilisateur.add(chckbxActifUtilisateur);
		
		textFieldDgUtilisateur = new JTextField();
		textFieldDgUtilisateur.setText("Direction g\u00E9n\u00E9rale");
		textFieldDgUtilisateur.setBounds(10, 51, 126, 20);
		panelModifierUtilisateur.add(textFieldDgUtilisateur);
		textFieldDgUtilisateur.setColumns(10);
		textFieldDgUtilisateur.setEnabled(false);		
		
		comboBoxDirectionUtilisateur.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBoxDirectionUtilisateur.setBounds(146, 51, 173, 20);
		panelModifierUtilisateur.add(comboBoxDirectionUtilisateur);
		textFieldDirectionUtilisateur=new JTextField();
		textFieldDirectionUtilisateur.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldDirectionUtilisateur.setEnabled(false);
		textFieldDirectionUtilisateur.setColumns(10);
		textFieldDirectionUtilisateur.setBounds(146, 51, 156, 20);
		
		panelModifierUtilisateur.add(textFieldDirectionUtilisateur);
		panelUtilisateurCellule.setBounds(10, 82, 501, 84);
		panelModifierUtilisateur.add(panelUtilisateurCellule);
		
		
		panelUtilisateurCellule.setBorder(new LineBorder(SystemColor.inactiveCaption));
		panelUtilisateurCellule.setLayout(null);
		JScrollPane scrollPaneCompoCellule = new JScrollPane(tableCompoCellule);
		scrollPaneCompoCellule.setBounds(0, 0, 501, 84);
		panelUtilisateurCellule.add(scrollPaneCompoCellule);
		
		tableCompoCellule = new JTable(compoCelluleModelTableau);
		tableCompoCellule.setDefaultRenderer(Object.class, new tableCompoCelluleRenderer());
		//scrollPaneCompoCellule.setColumnHeaderView(tableCompoCellule);
		tableCompoCellule.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Object source = arg0.getSource();
				if(tableCompoCellule.getSelectedRow()!=-1){
					
					remplirCompoCellule(tableCompoCellule.getValueAt(tableCompoCellule.getSelectedRow(),0).toString());
					
				}
			}
		});
		tableCompoCellule.setBounds(0, 0, 499, 84);
		tableCompoCellule.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableCompoCellule.setColumnSelectionAllowed(true);
		tableCompoCellule.setToolTipText("S\u00E9lectionnez la cellule d\u00E9sir\u00E9");
		tableCompoCellule.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
		tableCompoCellule.setForeground(Color.WHITE);
		tableCompoCellule.setFont(new Font("Tahoma", Font.BOLD, 13));
		tableCompoCellule.setBackground(new Color(211, 211, 211));
		tableCompoCellule.setAutoCreateRowSorter(true);
		tableCompoCellule.setAutoCreateRowSorter(false);
		tableCompoCellule.setDefaultRenderer(Object.class, new tableCompoCelluleRenderer());
		scrollPaneCompoCellule.setVisible(true);
		scrollPaneCompoCellule.add(tableCompoCellule);
		btnCelluleAjouter.setIcon(new ImageIcon(Parametres.class.getResource("/icones/ins\u00E9rer40.png")));
		btnCelluleAjouter.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCelluleAjouter.setBounds(518, 82, 22, 23);
		panelModifierUtilisateur.add(btnCelluleAjouter);
		btnCelluleSupprimer.setIcon(new ImageIcon(Parametres.class.getResource("/icones/modifiable41.png")));
		
		
		btnCelluleSupprimer.setBounds(518, 111, 22, 23);
		panelModifierUtilisateur.add(btnCelluleSupprimer);
		btnCelluleAjouter.setVisible(true);
		
		maDirection itemListener = new maDirection();
		comboBoxDirectionUtilisateur.addItemListener(itemListener);	
		
		
		btnUtilisateurModifiable.setBounds(303, 332, 89, 23);
		btnUtilisateurModifiable.setVisible(true);
		ongletUtilisateur.add(btnUtilisateurModifiable);
		
		JCheckBox chckbxActiveOnly = new JCheckBox("Cellules Actives Uniquement");
		chckbxActiveOnly.setBounds(573, 328, 89, 23);
		chckbxActiveOnly.setVisible(false);
		ongletUtilisateur.add(chckbxActiveOnly);
		

		btnModifierUtilisateur.setBounds(478, 332, 89, 23);
		btnModifierUtilisateur.setVisible(false);
		ongletUtilisateur.add(btnModifierUtilisateur);
		

		chckbxUtilisateurActif.setBounds(493, 117, 142, 23);
		chckbxUtilisateurActif.setVisible(false);
		ongletUtilisateur.add(chckbxUtilisateurActif);
		
		btnAjouterUtilisateur.setBounds(132, 332, 89, 23);
		ongletUtilisateur.add(btnAjouterUtilisateur);
		btnAjouterUtilisateur.setIcon(null);
		

		btnValiderAjoutUtilisateur.setBounds(478, 332, 89, 23);
		ongletUtilisateur.add(btnValiderAjoutUtilisateur);
		lblErreur.setBounds(123, 496, 416, 14);
		add(lblErreur);
		lblErreur.setVisible(false);
		

		lblErreur.setForeground(Color.RED);
		
		btnValiderAjoutUtilisateur.setVisible(true);
		
		/* 
		 * ---------------------------------------------------------------------------------------------------
		 * 									DEBUT PANEL COMPOCELLULE DANS UTILISATEUR
		 * ---------------------------------------------------------------------------------------------------
		 * 
		 */
		
		vectCompoCellule = controller.ControllerDB.getCompoCelluleVecteurArbre(textFieldUlisUtilisateur.getText());
		compoCelluleModelTableau = new compoCelluleModelTableau(vectCompoCellule);
		JComboBox comboCompoCellule = new JComboBox();
		Vector<model.compoCelluleArbre> vectCellule = new Vector<model.compoCelluleArbre>();
		vectCellule = controller.ControllerDB.getCompoCelluleArbre();
		
		/* 
		 * ---------------------------------------------------------------------------------------------------
		 * 									DEBUT PANEL DIRECTION GENERALE
		 * ---------------------------------------------------------------------------------------------------
		 * 
		 */
		//panelParametreDg ongletDg = new panelParametreDg();
		ongletDg.setVisible(true);
		ongletDg.setBackground(Color.black);
		pane.addTab("Direction g�n�rale", ongletDg);
		
		
		/* 
		 * ---------------------------------------------------------------------------------------------------
		 * 									DEBUT LISTENER BOUTON
		 * ---------------------------------------------------------------------------------------------------
		 * 
		 */
		
		MyButtonListener list= new MyButtonListener();
		btnConfig.addActionListener(list);
		btnSoftware.addActionListener(list);
		btnUpdate.addActionListener(list);
		btnRapports.addActionListener(list);
		btnHome.addActionListener(list);
		btnNewAppli.addActionListener(list);
		btnAjouterAppli.addActionListener(list);
		btnAffModifierAppli.addActionListener(list);
		btnModifier.addActionListener(list);
		chckbxUtilisateurActif.addActionListener(list);
		tglbtnModifier.addActionListener(list);
		comboBoxDirectionUtilisateur.addActionListener(list);
		btnModifierUtilisateur.addActionListener(list);
		btnAjouterUtilisateur.addActionListener(list);
		btnValiderAjoutUtilisateur.addActionListener(list);
		btnUtilisateurModifiable.addActionListener(list);
		btnCelluleAjouter.addActionListener(list);
		btnCelluleSupprimer.addActionListener(list);
		remplirDirection();
	
	}
	private void remplirDirection(){
		comboBoxDirectionUtilisateur.removeAllItems();
		vectDirection = ControllerDB.getDirectionUtilisateur();
		comboBoxDirectionUtilisateur.addItem("--S�lectionnez Direction--");
		for(int i=0; i<this.vectDirection.size();i++){
			comboBoxDirectionUtilisateur.addItem(vectDirection.elementAt(i).getNomDirection());
		}
		
	}
	private class maDirection implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			//remplirDirection();
		}

		
	}
	
	private class MyButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			Object source = e.getSource();
			/* 
			 * ---------------------------------------------------------------------------------------------------
			 * 									DEBUT BOUTON NAVIGATION
			 * ---------------------------------------------------------------------------------------------------
			 * 
			 */
			if(source == btnHome){
				controller.gestionFenetre.eraseContainerPaneMainJFrame();
				controller.gestionFenetre.accueil();
			}
			
			if(source == btnSoftware){
				controller.gestionFenetre.eraseContainerPaneMainJFrame();
				controller.gestionFenetre.application();
			}
			
			/* 
			 * ---------------------------------------------------------------------------------------------------
			 * 									DEBUT BOUTON APPLI
			 * ---------------------------------------------------------------------------------------------------
			 * 
			 */
			if(source == btnNewAppli){
				
				controller.gestionFenetre.eraseContainerPaneMainJFrame();
				controller.gestionFenetre.configurationAjout(true);
				
			}
			
			if(source == btnAffModifierAppli){
				
				controller.gestionFenetre.eraseContainerPaneMainJFrame();
				controller.gestionFenetre.configurationModif(false);
				
			}
			
			if(source == btnModifier){
				
				if(textFieldModifAppli.getText()!= null && textFieldModifAppli.getText().length()>0 ){
					appli.setNomApplication(textFieldModifAppli.getText());
					appli.setIdApplication(idAppliSelec);
					
					if(chckbxArchiverModif.isSelected()){
						appli.setVisibiliteApplication("Archiv�e");
					}
					else
					{
						appli.setVisibiliteApplication("");
					}					
					controller.ControllerDB.ModifApplication(appli);
					controller.gestionFenetre.eraseContainerPaneMainJFrame();
					controller.gestionFenetre.configurationModif(false);	
				}
				else
				{
	
					lblErreur.setVisible(true);
					textFieldModifAppli.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
					textFieldModifAppli.requestFocus();
				}
			}
			
			if(source == btnAjouterAppli){
				if(textFieldAjoutAppli.getText()!= null && textFieldAjoutAppli.getText().length()>0 ){
					appli.setNomApplication(textFieldAjoutAppli.getText());
					appli.setIdApplication(idAppliSelec);
					
					if(chckbxArchiverAjt.isSelected()){
						appli.setVisibiliteApplication("Archiv�e");
					}
					else
					{
						appli.setVisibiliteApplication("");
					}					
					controller.addData.addApplication(appli);
					controller.gestionFenetre.eraseContainerPaneMainJFrame();
					controller.gestionFenetre.configurationModif(true);	
				}
				else
				{
	
					lblErreur.setVisible(true);
					textFieldAjoutAppli.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
					textFieldAjoutAppli.requestFocus();
			
				}
				
			}
			/* 
			 * ---------------------------------------------------------------------------------------------------
			 * 									DEBUT BOUTON UTILISATEUR
			 * ---------------------------------------------------------------------------------------------------
			 * 
			 */
			if(source==chckbxUtilisateurActif){
				
				if(chckbxUtilisateurActif.isSelected()){
					vectUtilisateur=controller.ControllerDB.getUtilisateurActifArbre();	
					
					}
					else
					{
					vectUtilisateur = controller.ControllerDB.getUtilisateurArbre();
					
					}
				

			}
			
			if(source==comboBoxDirectionUtilisateur){
			
				textFieldDirectionUtilisateur.setText(comboBoxDirectionUtilisateur.getSelectedItem().toString());
				textFieldDgUtilisateur.setText("");
			}
			
			if(source==btnModifierUtilisateur){
				if(textFieldDirectionUtilisateur.getText()!=""){
					comboBoxDirectionUtilisateur.setSelectedItem(textFieldDirectionUtilisateur.getText());
				}
				directionUtilisateurSelectionne=comboBoxDirectionUtilisateur.getSelectedItem().toString();
				
				user.setUtilisateurDirection(model.getData.getDirectionArbre(directionUtilisateurSelectionne).getIdDirection());
				user.setMailUtilisateur(textFieldAdresseMail.getText());
				user.setIdUtilisateur(utilisateurActif.getIdUtilisateur());
				if(chckbxActifUtilisateur.isSelected()){
					user.setActifUtilisateur("");
				}
				else
				{
					user.setActifUtilisateur("Inactif");
				}
				
				if(textFieldUlisUtilisateur.getText()!= null && textFieldUlisUtilisateur.getText().length()>0 ){
					user.setNumUlis(textFieldUlisUtilisateur.getText());
					
					if(textFieldNomUtilisateur.getText()!= null && textFieldNomUtilisateur.getText().length()>0 ){
						user.setNomUtilisateur(textFieldNomUtilisateur.getText());
						
						if(textFieldPrenomUtilisateur.getText()!= null && textFieldPrenomUtilisateur.getText().length()>0 ){
							user.setPrenomUtilisateur(textFieldPrenomUtilisateur.getText());
							
							if(textFieldAdresseMail.getText()!= null && textFieldAdresseMail.getText().length()>0 ){
								user.setMailUtilisateur(textFieldAdresseMail.getText());
								model.majData.MajUtilisateur(user);
								controller.gestionFenetre.eraseContainerPaneMainJFrame();
								controller.gestionFenetre.configurationModif(true);	
								
								tableUtilisateur.removeAll();
								tableUtilisateur.repaint();
								
							}
							else{
								lblErreur.setVisible(true);
								textFieldAdresseMail.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
							}
							
						}
						else{
							lblErreur.setVisible(true);
							textFieldPrenomUtilisateur.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
						}
					}
					else{
						lblErreur.setVisible(true);
						textFieldNomUtilisateur.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
					}
				}
				else{
					lblErreur.setVisible(true);
					textFieldUlisUtilisateur.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
				}
				
				
				
				
			}
			if(source==btnAjouterUtilisateur){
				textFieldNomUtilisateur.setText("Nom");
				textFieldUlisUtilisateur.requestFocus();
				textFieldPrenomUtilisateur.setText("Prenom");
				textFieldUlisUtilisateur.setText("");
				textFieldAdresseMail.setText("Adresse Mail");
				textFieldDgUtilisateur.setText("Direction g�n�rale");
				chckbxActifUtilisateur.setSelected(true);
				btnValiderAjoutUtilisateur.setVisible(true);
				btnModifierUtilisateur.setVisible(false);
				comboBoxDirectionUtilisateur.setEnabled(true);
				textFieldNomUtilisateur.setEditable(true);
				textFieldPrenomUtilisateur.setEditable(true);
				textFieldUlisUtilisateur.setEditable(true);
				textFieldAdresseMail.setEditable(true);
				textFieldDgUtilisateur.setEditable(true);
				textFieldDirectionUtilisateur.setEditable(true);
				chckbxActifUtilisateur.setEnabled(true);
				tableCompoCellule.setVisible(false);
			}
			if(source == btnValiderAjoutUtilisateur){
				if(chckbxActifUtilisateur.isSelected()){
					user.setActifUtilisateur("");
				}
				else
				{
					user.setActifUtilisateur("Inactif");
				}
				if(textFieldUlisUtilisateur.getText()!= null && textFieldUlisUtilisateur.getText().length()>0 && textFieldUlisUtilisateur.getText().length()<=6){
					user.setNumUlis(textFieldUlisUtilisateur.getText());
					textFieldUlisUtilisateur.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
					
					if(textFieldNomUtilisateur.getText()!= null && textFieldNomUtilisateur.getText().length()>0 ){
						user.setNomUtilisateur(textFieldNomUtilisateur.getText());
						textFieldNomUtilisateur.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
						
						if(textFieldPrenomUtilisateur.getText()!= null && textFieldPrenomUtilisateur.getText().length()>0 ){
							user.setPrenomUtilisateur(textFieldPrenomUtilisateur.getText());
							textFieldPrenomUtilisateur.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
							
							if(comboBoxDirectionUtilisateur.getSelectedItem()!="--S�lectionnez Direction--"){
								comboBoxDirectionUtilisateur.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
								directionUtilisateurSelectionne=comboBoxDirectionUtilisateur.getSelectedItem().toString();
								user.setUtilisateurDirection(model.getData.getDirectionArbre(directionUtilisateurSelectionne).getIdDirection());
								
								if(textFieldAdresseMail.getText()!= null && textFieldAdresseMail.getText().length()>0 ){
								user.setMailUtilisateur(textFieldAdresseMail.getText());
								
								controller.addData.addUtilisateur(user);
								/*controller.gestionFenetre.eraseContainerPaneMainJFrame();
								controller.gestionFenetre.configurationModif(true);	
								pane.setSelectedIndex(1);*/
								tableUtilisateur.removeAll();
								tableUtilisateur.repaint();
								}
								else
								{
									lblErreur.setVisible(true);
									comboBoxDirectionUtilisateur.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
								}
									
							}
							else{
								lblErreur.setVisible(true);
								textFieldAdresseMail.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
							}
							
						}
						else{
							lblErreur.setVisible(true);
							textFieldPrenomUtilisateur.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
						}
					}
					else{
						lblErreur.setVisible(true);
						textFieldNomUtilisateur.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
					}
				}
				else{
					lblErreur.setVisible(true);
					textFieldUlisUtilisateur.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
				}

				
			}
			/* 
			 * ---------------------------------------------------------------------------------------------------
			 * 									DEBUT BOUTON COMPO CELLULE
			 * ---------------------------------------------------------------------------------------------------
			 * 
			 */
			
			if(source==btnUtilisateurModifiable){
				btnUtilisateurModifiable.setVisible(false);
				comboBoxDirectionUtilisateur.setVisible(true);
				comboBoxDirectionUtilisateur.setEnabled(true);
				comboBoxDirectionUtilisateur.setSelectedItem(textFieldDirectionUtilisateur.getText());
				textFieldNomUtilisateur.setEditable(true);
				textFieldPrenomUtilisateur.setEditable(true);
				textFieldUlisUtilisateur.setEditable(true);
				textFieldAdresseMail.setEditable(true);
				textFieldDgUtilisateur.setEditable(true);
				
				chckbxActifUtilisateur.setEnabled(true);
				btnModifierUtilisateur.setVisible(true);
				btnValiderAjoutUtilisateur.setVisible(false);
				remplirCompoCellule(textFieldUlisUtilisateur.getText());
				textFieldDirectionUtilisateur.setEditable(true);
				textFieldDirectionUtilisateur.setEnabled(true);
				textFieldDirectionUtilisateur.setVisible(true);
				

				
			}
			
			if(source ==btnCelluleAjouter){ 
	             compoCelluleJFrame fenetreAjout = new compoCelluleJFrame(textFieldUlisUtilisateur.getText(),tableCompoCellule);
	             Parametres.this.fenetreAjout=fenetreAjout;
	             fenetreAjout.show();
	             frameAjoutFenetre=true;
	             if(fenetreAjout.isShowing() &&frameAjoutFenetre ==true){
	            	 
	             }
	             else{
	            	 tableCompoCellule.removeAll();
		             tableCompoCellule.repaint(); 
	             }
	             
	             
			}
			
			if(source == btnCelluleSupprimer){
				String nomCellule= tableCompoCellule.getValueAt(tableCompoCellule.getSelectedRow(), 0).toString();
				String debut= tableCompoCellule.getValueAt(tableCompoCellule.getSelectedRow(), 1).toString();
				String fin= tableCompoCellule.getValueAt(tableCompoCellule.getSelectedRow(), 2).toString();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date dateDebut = null;
				try {
					dateDebut = sdf.parse(debut);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	
				Date dateFin=null;
				
				try {
					dateFin=sdf.parse(fin);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
						
				System.out.println("dateDebut"+dateDebut);
				
				compoModifJFrame fenetreModif = new compoModifJFrame(textFieldUlisUtilisateur.getText(), nomCellule,dateDebut,dateFin);
				fenetreModif.show();
			}
			
		}
	}
private void remplirApplication(String application){
		
		applicationArbre applicationArbre = ControllerDB.getApplicationArbre(application);
		textFieldModifAppli.setText(applicationArbre.getNomApplication());
		
		if(applicationArbre.getVisibiliteApplication().equals("Archiv�e")){
			chckbxArchiverModif.setSelected(true);
			
		}
		else
		{

			chckbxArchiverModif.setSelected(false);
			
		}
		
		idAppliSelec=applicationArbre.getIdApplication();
		
	}

private void remplirUtilisateur(String numUtilisateur){
	numUtilisateur=utilisateurSelectionne;
	utilisateurArbre utilisateurArbre = ControllerDB.getUtilisateurArbre(numUtilisateur);
	textFieldNomUtilisateur.setText(utilisateurArbre.getNomUtilisateur());
	textFieldPrenomUtilisateur.setText(utilisateurArbre.getPrenomUtilisateur());
	textFieldUlisUtilisateur.setText(utilisateurArbre.getNumUlis());
	textFieldAdresseMail.setText(utilisateurArbre.getMailUtilisateur());
	textFieldDgUtilisateur.setText(utilisateurArbre.getUtilisateurDG());
	if(utilisateurArbre.getUtilisateurActif().equals("Inactif")){
		chckbxActifUtilisateur.setSelected(false);
	}
	else{
		chckbxActifUtilisateur.setSelected(true);
	}

	textFieldDirectionUtilisateur.setText(utilisateurArbre.getUtilisateurDirection());
	
	textFieldNomUtilisateur.setEditable(false);
	textFieldPrenomUtilisateur.setEditable(false);
	textFieldUlisUtilisateur.setEditable(false);
	textFieldAdresseMail.setEditable(false);
	textFieldDgUtilisateur.setEditable(false);
	textFieldDirectionUtilisateur.setEditable(false);
	chckbxActifUtilisateur.setEnabled(false);
	comboBoxDirectionUtilisateur.setEnabled(false);
 }
private void remplirCompoCellule(String numUtilisateur){
	numUtilisateur=textFieldUlisUtilisateur.getText();
	model.compoCelluleArbre compoCelluleArbre = ControllerDB.getCompoCelluleArbre(numUtilisateur);
	vectCompoCellule = controller.ControllerDB.getCompoCelluleVecteurArbre(numUtilisateur);
	panelUtilisateurCellule.removeAll();

	compoCelluleModelTableau = new compoCelluleModelTableau(vectCompoCellule);
	tableCompoCellule = new JTable(compoCelluleModelTableau);
	tableCompoCellule.setDefaultRenderer(Object.class, new tableCompoCelluleRenderer());
	tableCompoCellule.setBounds(0, 0, 499, 82);
	tableCompoCellule.getColumnModel().getColumn(0).setPreferredWidth(55);
	tableCompoCellule.getColumnModel().getColumn(1).setPreferredWidth(55);
	tableCompoCellule.getColumnModel().getColumn(2).setPreferredWidth(55);
	tableCompoCellule.setAutoCreateRowSorter(true);
	tableCompoCellule.getRowSorter().toggleSortOrder(0);
	JScrollPane scrollPaneCompoCellule = new JScrollPane(tableCompoCellule);
	scrollPaneCompoCellule.setBounds(0, 0, 501, 84);
	scrollPaneCompoCellule.setVisible(true);
	
	panelUtilisateurCellule.setLayout(null);
	panelUtilisateurCellule.add(scrollPaneCompoCellule);
	panelUtilisateurCellule.repaint();

}
private void addLigneCompoCellule(String numUtilisateur){
	numUtilisateur=textFieldUlisUtilisateur.getText();
	model.compoCelluleArbre compoCelluleArbre = ControllerDB.getCompoCelluleArbre(numUtilisateur);
	Vector<model.compoCelluleArbre> vectCellule = new Vector<model.compoCelluleArbre>();
	vectCellule = controller.ControllerDB.getCompoCelluleArbre();
	vectCompoCellule = controller.ControllerDB.getCompoCelluleVecteurArbre(numUtilisateur);
	vectCompoCellule.add(compoCelluleArbre);
	panelUtilisateurCellule.removeAll();
	panelUtilisateurCellule.repaint();
	compoCelluleModelTableau = new compoCelluleModelTableau(vectCompoCellule);
	tableCompoCellule = new JTable(compoCelluleModelTableau);
	tableCompoCellule.setDefaultRenderer(Object.class, new tableCompoCelluleRenderer());
	tableCompoCellule.setBounds(0, 0, 499, 82);
	tableCompoCellule.getColumnModel().getColumn(0).setPreferredWidth(55);
	tableCompoCellule.getColumnModel().getColumn(1).setPreferredWidth(55);
	tableCompoCellule.getColumnModel().getColumn(2).setPreferredWidth(55);
	tableCompoCellule.setAutoCreateRowSorter(true);
	tableCompoCellule.getRowSorter().toggleSortOrder(0);
	comboCellule.addItem("--S�lectionnez Direction--");
	for(int i=0; i<vectCellule.size();i++){
		comboCellule.addItem(vectCellule.elementAt(i).getNomCellule());
	}
	tableCompoCellule.getColumn("Cellule").setCellEditor(new DefaultCellEditor(comboCellule));
	DefaultTableCellRenderer dcr = new DefaultTableCellRenderer();
	tableCompoCellule.getColumn("Cellule").setCellRenderer(dcr);
	JScrollPane scrollPaneCompoCellule = new JScrollPane(tableCompoCellule);
	scrollPaneCompoCellule.setBounds(0, 0, 501, 84);
	scrollPaneCompoCellule.setVisible(true);
	
	panelUtilisateurCellule.setLayout(null);
	panelUtilisateurCellule.add(scrollPaneCompoCellule);
	

}

public void getVectDirection(){
	comboBoxDirectionUtilisateur.removeAllItems();
	vectDirection=controller.ControllerDB.getDirectionUtilisateur();
	for (int i=0; i<this.vectDirection.size();i++){
		comboBoxDirectionUtilisateur.addItem(vectDirection.elementAt(i).getNomDirection());
		}

	}

public void refreshCompoCelluleTable() {

	panelUtilisateurCellule.removeAll();
	panelUtilisateurCellule.repaint();
	}
}


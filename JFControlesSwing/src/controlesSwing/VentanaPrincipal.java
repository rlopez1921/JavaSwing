package controlesSwing;

import java.awt.EventQueue;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;

public class VentanaPrincipal {

	private JFrame frame;
	private JTextField jtf_nombreCompleto;
	private JPasswordField jpf_contrasena;
	private JTextField jtf_nombreCompletoResp;
	private JTextField jtf_sexoResp;
	private JTextField jtf_lenguajesResp;
	private JTextField jtf_paisResp;
	private JTextField jtf_contrasenaResp;
	private final ButtonGroup buttonGroupSexo = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 423);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbl_nombreCompleto = new JLabel("Nombre Completo:");
		lbl_nombreCompleto.setBounds(10, 11, 105, 14);
		frame.getContentPane().add(lbl_nombreCompleto);
		
		JLabel lbl_sexo = new JLabel("Sexo:");
		lbl_sexo.setBounds(10, 43, 95, 14);
		frame.getContentPane().add(lbl_sexo);
		
		JLabel lbl_lenguajesFav = new JLabel("Lenguajes Fav.");
		lbl_lenguajesFav.setBounds(10, 78, 95, 14);
		frame.getContentPane().add(lbl_lenguajesFav);
		
		JLabel lbl_pais = new JLabel("Pa\u00EDs:");
		lbl_pais.setBounds(10, 114, 95, 14);
		frame.getContentPane().add(lbl_pais);
		
		JLabel lbl_contrasena = new JLabel("Contrase\u00F1a:");
		lbl_contrasena.setBounds(10, 146, 95, 14);
		frame.getContentPane().add(lbl_contrasena);
		
		jtf_nombreCompleto = new JTextField();
		jtf_nombreCompleto.setBounds(113, 8, 311, 20);
		frame.getContentPane().add(jtf_nombreCompleto);
		jtf_nombreCompleto.setColumns(10);
		
		JRadioButton jrb_sexoMasculino = new JRadioButton("Masculino");
		buttonGroupSexo.add(jrb_sexoMasculino);
		jrb_sexoMasculino.setSelected(true);
		jrb_sexoMasculino.setBounds(111, 34, 88, 23);
		frame.getContentPane().add(jrb_sexoMasculino);
		
		JRadioButton jrb_sexoFemenino = new JRadioButton("Femenino");
		buttonGroupSexo.add(jrb_sexoFemenino);
		jrb_sexoFemenino.setBounds(205, 34, 81, 23);
		frame.getContentPane().add(jrb_sexoFemenino);
		
		JCheckBox jcb_cSharp = new JCheckBox("C#");
		jcb_cSharp.setBounds(111, 69, 49, 23);
		frame.getContentPane().add(jcb_cSharp);
		
		JCheckBox jcb_java = new JCheckBox("Java");
		jcb_java.setBounds(172, 69, 61, 23);
		frame.getContentPane().add(jcb_java);
		
		JCheckBox jcb_ruby = new JCheckBox("Ruby");
		jcb_ruby.setBounds(235, 69, 61, 23);
		frame.getContentPane().add(jcb_ruby);
		
		JComboBox jcomb_pais = new JComboBox();
		jcomb_pais.setModel(new DefaultComboBoxModel(new String[] {"M\u00E9xico", "Colombia", "Brasil", "Per\u00FA", "Chile", "Argentina", "Bolivia", "Paraguay"}));
		jcomb_pais.setBounds(113, 111, 311, 20);
		frame.getContentPane().add(jcomb_pais);
		
		jpf_contrasena = new JPasswordField();
		jpf_contrasena.setBounds(113, 143, 311, 20);
		frame.getContentPane().add(jpf_contrasena);
		
		JButton btn_obtenerDatos = new JButton("Obtener Datos");
		btn_obtenerDatos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jtf_nombreCompletoResp.setText(jtf_nombreCompleto.getText());
				
				//obtenemos los elementos de jradiobuton
				Enumeration<AbstractButton> seleccionSexo = buttonGroupSexo.getElements();
				
				//leemos los jradiobuton
				while (seleccionSexo.hasMoreElements()) {
					//leemos los elementos seleccionados
					AbstractButton selecionados = (AbstractButton) seleccionSexo.nextElement();
					
					//si un elemento es selecionado
					if(selecionados.isSelected()){
						jtf_sexoResp.setText(selecionados.getText());
						break;
					}
				}
				
				String lenguajesSeleccionados= "";
				
				lenguajesSeleccionados+=(jcb_cSharp.isSelected() ? jcb_cSharp.getText() : "");
				lenguajesSeleccionados+=(jcb_java.isSelected() ? " "+jcb_java.getText() : "");
				lenguajesSeleccionados+=(jcb_ruby.isSelected() ? " "+jcb_ruby.getText() : "");
				
				jtf_lenguajesResp.setText(lenguajesSeleccionados);
				
				jtf_paisResp.setText(jcomb_pais.getSelectedItem().toString());
				
				jtf_contrasenaResp.setText(jpf_contrasena.getText());
			}	
		});
		btn_obtenerDatos.setBounds(306, 174, 118, 23);
		frame.getContentPane().add(btn_obtenerDatos);
		
		JLabel jlb_nombreCompletoResp = new JLabel("Nombre Completo:");
		jlb_nombreCompletoResp.setBounds(10, 216, 105, 14);
		frame.getContentPane().add(jlb_nombreCompletoResp);
		
		JLabel jlb_sexoResp = new JLabel("Sexo:");
		jlb_sexoResp.setBounds(10, 248, 95, 14);
		frame.getContentPane().add(jlb_sexoResp);
		
		JLabel jlb_lenguajesResp = new JLabel("Lenguajes Fav.");
		jlb_lenguajesResp.setBounds(10, 283, 95, 14);
		frame.getContentPane().add(jlb_lenguajesResp);
		
		JLabel lbl_paisResp = new JLabel("Pa\u00EDs:");
		lbl_paisResp.setBounds(10, 319, 95, 14);
		frame.getContentPane().add(lbl_paisResp);
		
		JLabel jlb_contrasenaResp = new JLabel("Contrase\u00F1a:");
		jlb_contrasenaResp.setBounds(10, 351, 95, 14);
		frame.getContentPane().add(jlb_contrasenaResp);
		
		jtf_nombreCompletoResp = new JTextField();
		jtf_nombreCompletoResp.setEditable(false);
		jtf_nombreCompletoResp.setBounds(113, 213, 311, 20);
		frame.getContentPane().add(jtf_nombreCompletoResp);
		jtf_nombreCompletoResp.setColumns(10);
		
		jtf_sexoResp = new JTextField();
		jtf_sexoResp.setEditable(false);
		jtf_sexoResp.setBounds(113, 245, 311, 20);
		frame.getContentPane().add(jtf_sexoResp);
		jtf_sexoResp.setColumns(10);
		
		jtf_lenguajesResp = new JTextField();
		jtf_lenguajesResp.setEditable(false);
		jtf_lenguajesResp.setBounds(113, 280, 311, 20);
		frame.getContentPane().add(jtf_lenguajesResp);
		jtf_lenguajesResp.setColumns(10);
		
		jtf_paisResp = new JTextField();
		jtf_paisResp.setEditable(false);
		jtf_paisResp.setBounds(113, 316, 311, 20);
		frame.getContentPane().add(jtf_paisResp);
		jtf_paisResp.setColumns(10);
		
		jtf_contrasenaResp = new JTextField();
		jtf_contrasenaResp.setEditable(false);
		jtf_contrasenaResp.setBounds(113, 348, 311, 20);
		frame.getContentPane().add(jtf_contrasenaResp);
		jtf_contrasenaResp.setColumns(10);
	}
}

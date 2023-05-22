package practicandoANdo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JPasswordField;

public class frmMenuPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContraseña;
	String[] aUsuario = {
			"Angelo","Pedro","Oscar","Jorge"
	};
	
	String[] aContraseña = {
			"gatoconbotas","panconarroz","cualquiercosa","jarma"
	};
	int c =0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMenuPrincipal frame = new frmMenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmMenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.LIGHT_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("NUEVO PERU BANK");
		
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Segoe UI Historic", Font.BOLD, 16));
		txtUsuario.setBackground(SystemColor.activeCaptionBorder);
		txtUsuario.setForeground(Color.BLACK);
		txtUsuario.setBounds(274, 103, 232, 42);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(10, 10, 765, 446);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario :");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 23));
		lblNewLabel.setBounds(128, 83, 135, 65);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña :");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(87, 205, 168, 51);
		panel.add(lblNewLabel_1);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setFont(new Font("Segoe UI", Font.BOLD, 16));
		txtContraseña.setBounds(265, 216, 232, 42);
		panel.add(txtContraseña);
		txtContraseña.setBackground(SystemColor.activeCaptionBorder);
		txtContraseña.setForeground(Color.BLACK);
		txtContraseña.setColumns(10);
		
		JButton btnLogin = new JButton("ENTRAR");
		btnLogin.setBounds(298, 323, 179, 53);
		panel.add(btnLogin);
		btnLogin.setFont(new Font("Verdana", Font.PLAIN, 22));
		btnLogin.setBackground(Color.YELLOW);
		
		JLabel lblNewLabel_2 = new JLabel("NUEVO PERU BANK");
		lblNewLabel_2.setForeground(new Color(255, 255, 0));
		lblNewLabel_2.setFont(new Font("Constantia", Font.BOLD, 26));
		lblNewLabel_2.setBounds(263, 10, 373, 63);
		panel.add(lblNewLabel_2);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = getUsuario();
				String contraseña = getContraseña();
				String encontrado = "false";
				
				// Empezamos empleando un if para controlar el nùmero
				// de intentos en nuestro programa, en este caso 
				// si el c llega a 3 el programa genera un exit
				if (c!=3) {
					do {
						for (int i=0 ; i<aUsuario.length; i++) { //un bucle for para recorrer todos los usuarios y contraseñas
							if (aUsuario[i].equals(usuario)&& aContraseña[i].equals(contraseña)) 
							{encontrado ="true"; //Si encuentra coincidencia en usuario y contraseña devuelve true para encontrado
							}
							}
							if (encontrado.equals("true")) { //otro If si es que encontrado = true, arroja "Bienvenido"
								JOptionPane.showMessageDialog(null,"Bienvenido "+ usuario.toUpperCase()); 
								frmMenuPrincipal2 frmVista=new frmMenuPrincipal2(); //Te bota al menu principal
								frmVista.setVisible(true);	// Activa el formulario vista
								this.setVisible(false);//Desactiva el formulario actual
								dispose();// Cierra el formulario actual (frmMenuPrincipal)
								break; // cierra el buclie do-while
							}
					
							else {
								c++;
								if (c!=3) {
									JOptionPane.showMessageDialog(null,"Le queda "+ (3-c)+" intentos");
									break;
								}
								
								else { JOptionPane.showMessageDialog(null, "Tarjeta Bloqueada, consulte con Atención al cliente"); 
								System.exit(0);
									break;									
								}
								
								}
					   } while (c<=2);
						}
			}
			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
			String getUsuario() {
				return txtUsuario.getText();
			}
			String getContraseña() {
				char[] password = txtContraseña.getPassword();
				return new String(password);
			}	
		});
	}
}

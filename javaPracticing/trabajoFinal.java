package practicandoANdo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class trabajoFinal extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtContraseña;
	String[] aUsuario = {
			"Angelo","Pedro","Oscar","Jorge"
	};
	
	String[] aContraseña = {
			"123","456","678","789"
	};
	int c =1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					trabajoFinal frame = new trabajoFinal();
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
	public trabajoFinal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 903, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String usuario = getUsuario();
				String contraseña = getContraseña();
				String encontrado = "false";
				
				if (c!=4) {
					do {
						for (int i=0 ; i<aUsuario.lenght; i++) {
							if (aUsuario[i].equals(usuario)&& aContraseña[i].equals(contraseña))
							{encontrado ="true";
						}
					}
					if (encontrado.equals("true")) {
						JOptionPane.showMessageDialog(null,"Bienvenido al sistema");
						frmMenuPrincipal frmVista=new frmMenuPrincipal();
						frmVista.setVisible(true);
						this.setVisible(false);
						break;
					}
					
					else {
						JOptionPane.showMessageDialog(null,"le queda"+ (3-c )+"intentos");
						c++;
						break;
					}
					} while (c<=3);
				}else {
					JOptionPane.showMessageDialog(null,"Ya no tiene mas intentos");
					System.exit(0);
				}
			}
			String getUsuario() {
				return txtUsuario.getText();
			}
			String getContraseña() {
				return txtContraseña.getText();
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 27));
		btnLogin.setBounds(248, 359, 401, 81);
		contentPane.add(btnLogin);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(248, 82, 391, 81);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContraseña = new JTextField();
		txtContraseña.setBounds(248, 204, 401, 81);
		contentPane.add(txtContraseña);
		txtContraseña.setColumns(10);
	}
}

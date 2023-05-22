package practicandoANdo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class frmMenuPrincipal2 extends JFrame {

	private JPanel contentPane;
	private JTextField txtBienvenidoQueOperaciones;
	double saldo = 1223.00;
	double cantidad;
	DefaultListModel moR = new DefaultListModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMenuPrincipal2 frame = new frmMenuPrincipal2();
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
	public frmMenuPrincipal2() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 836, 513);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		Label lblMonto = new Label("");
		lblMonto.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		lblMonto.setBounds(610, 18, 164, 41);
		contentPane.add(lblMonto);
		lblMonto.setText("1223.00");
		
		JList lstR = new JList();
		lstR.setFont(new Font("Verdana", Font.BOLD, 14));
		lstR.setBounds(445, 143, 337, 144);
		contentPane.add(lstR);
		lstR.setModel(moR);
		
		lstR.setModel(moR);
		lblMonto.setText(""+saldo);

		
		txtBienvenidoQueOperaciones = new JTextField();
		txtBienvenidoQueOperaciones.setEditable(false);
		txtBienvenidoQueOperaciones.setBackground(Color.YELLOW);
		txtBienvenidoQueOperaciones.setFont(new Font("Verdana", Font.BOLD, 25));
		txtBienvenidoQueOperaciones.setText("OPERACIONES ");
		txtBienvenidoQueOperaciones.setBounds(63, 18, 224, 41);
		contentPane.add(txtBienvenidoQueOperaciones);
		txtBienvenidoQueOperaciones.setColumns(10);
		
		
		
		
		JButton btnAñadir = new JButton("DEPOSITO");
		btnAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cantidad = Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese cantidad: "));
				saldo += cantidad;
				lblMonto.setText(String.valueOf(saldo));
		
			}
		});
		btnAñadir.setFont(new Font("Verdana", Font.BOLD, 16));
		btnAñadir.setBounds(93, 78, 164, 34);
		contentPane.add(btnAñadir);
		
		
		JButton btnQuitar = new JButton("RETIRO");
		btnQuitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cantidad = Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese cantidad: "));
				saldo -=cantidad;
				lblMonto.setText(String.valueOf(saldo));
			}
		});
		btnQuitar.setFont(new Font("Verdana", Font.BOLD, 16));
		btnQuitar.setBounds(93, 148, 165, 34);
		contentPane.add(btnQuitar);
		
		JButton btnConsultar = new JButton("CONSULTAR SALDO");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moR.clear();
				moR.addElement("Ultimos movimientos");
				moR.addElement("Cantidad:                              "+String.format("%.2f",cantidad));
				moR.addElement("Cantidad actual:                    " +String.format("%.2f",saldo));
			}
		});
		btnConsultar.setFont(new Font("Verdana", Font.BOLD, 15));
		btnConsultar.setBounds(63, 219, 240, 34);
		contentPane.add(btnConsultar);
		
		JButton btnCerrar = new JButton("SALIR AL MENU");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMenuPrincipal frmVista = new frmMenuPrincipal();
				frmVista.setVisible(true);
				frmMenuPrincipal2.this.setVisible(false);
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
		btnCerrar.setFont(new Font("Verdana", Font.BOLD, 16));
		btnCerrar.setBounds(544, 350, 230, 34);
		contentPane.add(btnCerrar);
		
		JLabel lblNewLabel = new JLabel("SALDO DISPONIBLE: ");
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(414, 25, 190, 34);
		contentPane.add(lblNewLabel);
		
		JButton btnFinalizar = new JButton("FINALIZAR OPERACION\r\n");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				dispose();
			}
		});
		btnFinalizar.setFont(new Font("Verdana", Font.BOLD, 16));
		btnFinalizar.setBounds(488, 405, 286, 34);
		contentPane.add(btnFinalizar);
		
		
		
		
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		
	}
}

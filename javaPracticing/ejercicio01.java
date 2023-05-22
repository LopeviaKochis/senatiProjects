package practicandoANdo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ejercicio01 extends JFrame {

	private JPanel contentPane;
	private JTextField txtCantidad;
	private JTextField txtPrecio;
	private JTable tProductos;
	int f;
	DefaultListModel moR = new DefaultListModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ejercicio01 frame = new ejercicio01();
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
	public ejercicio01() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 940, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 916, 55);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CONTROL DE VENTA DE BILLETERAS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(0, 10, 826, 45);
		panel.add(lblNewLabel);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBorder(new TitledBorder(null, "PRECIO", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtPrecio.setBounds(368, 67, 148, 42);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JComboBox cboMarca = new JComboBox();
		cboMarca.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				//asignamos el precio de la marca:
				
				String marca = cboMarca.getSelectedItem().toString();
				double precio =0;
				switch(marca){
					case "Crepier":precio=150;break;
					case "Renzo Costa":precio=100;break;
					case "Caterpillar": precio=80;break;
					case "LaCoste": precio=120;
					}
				txtPrecio.setText(""+precio);
				
			}
		});
		cboMarca.setBorder(new TitledBorder(null, "MARCA", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		cboMarca.setBounds(15, 70, 160, 42);
		contentPane.add(cboMarca);
		cboMarca.addItem("Crepier");
		cboMarca.addItem("Renzo Costa");
		cboMarca.addItem("Caterpillar");
		cboMarca.addItem("LaCoste");
		
		
		txtCantidad = new JTextField();
		txtCantidad.setBorder(new TitledBorder(null, "Unidades", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtCantidad.setBounds(198, 67, 160, 42);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		
		
		
		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String marca = cboMarca.getSelectedItem().toString();
				int cantidad = Integer.parseInt(txtCantidad.getText());
				
				//ASIGNAR PRECIO POR MARCA
				double precio =0;
				switch(marca){
					case "Crepier":precio=150;break;
					case "Renzo Costa":precio=100;break;
					case "Caterpillar": precio=80;break;
					case "LaCoste": precio=120;
				}
				
				double importe = precio*cantidad;
				
				//ENVIAR INFORMACION A LA TABLA
				tProductos.setValueAt(f+1, f, 0);
				tProductos.setValueAt(marca, f, 1);
				tProductos.setValueAt(cantidad, f, 2);
				tProductos.setValueAt(precio, f, 3);
				tProductos.setValueAt(importe, f, 4);
				f++;
				
			}
		});
		btnAgregar.setBounds(657, 69, 154, 47);
		contentPane.add(btnAgregar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 132, 894, 126);
		contentPane.add(scrollPane);
		
		tProductos = new JTable();
		tProductos.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"N\u00BA", "PRODUCTO", "CANTIDAD", "PRECIO", "IMPORTE"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(tProductos);
		
		JButton btnEstadisticas = new JButton("ESTADISTICAS");
		btnEstadisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tCrepier=0,tCosta=0,tLacoste=0,tCaterpillar=0;
				int iCrepier=0,iCosta=0,iLacoste=0,iCaterpillar=0;
				for(int i=0;i<f;i++) {
					switch(tProductos.getValueAt(i, 1).toString()) {
					case "Crepier":
						tCrepier+=Integer.parseInt(tProductos.getValueAt(i,2).toString());;
						iCrepier+=Double.parseDouble(tProductos.getValueAt(i,4).toString());
						break;
					case "Renzo Costa":
						tCosta+=Integer.parseInt(tProductos.getValueAt(i,2).toString());
						iCosta+=Double.parseDouble(tProductos.getValueAt(i,4).toString());
						break;
					case "LaCoste":
						tLacoste+=Integer.parseInt(tProductos.getValueAt(i,2).toString());
						iLacoste+=Double.parseDouble(tProductos.getValueAt(i,4).toString());
						break;
					case "Caterpillar":tCaterpillar+=Integer.parseInt(tProductos.getValueAt(i,2).toString());
						iCaterpillar+=Double.parseDouble(tProductos.getValueAt(i,4).toString());
						break;
				
			}
					moR.clear();
					moR.addElement("TOTAL DE CREPIER: "+ tCrepier);
					moR.addElement("TOTAL DE RENZO COSTA: "+ tCosta);
					moR.addElement("TOTAL DE CATERPILLAR: "+ tCaterpillar);
					moR.addElement("TOTAL DE LACOSTE: "+ tLacoste);
					moR.addElement("TOTAL DE CREPIER: s/"+ iCrepier);
					moR.addElement("TOTAL DE RENZO COSTA: s/"+ iCosta);
					moR.addElement("TOTAL DE CATERPILLAR: s/"+ iCaterpillar);
					moR.addElement("TOTAL DE LACOSTE: s/"+ iLacoste);
				}
			}
		});
		btnEstadisticas.setBounds(24, 268, 892, 47);
		contentPane.add(btnEstadisticas);
		
		JList lstEstadisticas = new JList();
		lstEstadisticas.setBorder(new TitledBorder(null, "ESTADISTICAS", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lstEstadisticas.setBounds(34, 325, 887, 159);
		contentPane.add(lstEstadisticas);
		lstEstadisticas.setModel(moR);
	}
}

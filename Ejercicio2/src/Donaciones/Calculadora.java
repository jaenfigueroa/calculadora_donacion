package Donaciones;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Calculadora extends JFrame implements MouseListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JTextArea textArea;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora frame = new Calculadora();
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
	public Calculadora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Donación S/.");
		lblNewLabel.setBounds(23, 30, 139, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(142, 36, 76, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setBounds(23, 76, 503, 185);
		contentPane.add(textArea);
		
		btnNewButton = new JButton("Calcular");
		btnNewButton.addMouseListener(this);
		btnNewButton.setBounds(228, 35, 85, 21);
		contentPane.add(btnNewButton);
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == btnNewButton) {
			mouseClickedBtnNewButton(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedBtnNewButton(MouseEvent e) {
		// Declaración de variables
		double montoDonacion, areaProduccion, areaContabilidad, areaMarketing, areaSoporte, areaRecursosHumanos;
		
		// Leer valores
		montoDonacion = Double.parseDouble(textField.getText());
		
		// Calcular
		areaProduccion = 0.25 * montoDonacion;
		areaSoporte = 0.20 * montoDonacion;
		areaMarketing = 0.15 * (areaProduccion + areaSoporte);
		areaContabilidad = 0.40 * (areaMarketing + areaSoporte);
		areaRecursosHumanos = montoDonacion - (areaProduccion + areaContabilidad + areaMarketing + areaSoporte);
	    
		// Imprimir resultados
	    textArea.setText("Area de Producción:\t " + areaProduccion + " S/. \n");
		textArea.append("Area de Contabilidad:\t " + areaContabilidad + " S/.  \n");
		textArea.append("Area de Marketing:\t " + areaMarketing + " S/.  \n");
		textArea.append("Area de Soporte:\t " + areaSoporte + " S/.  \n");
		textArea.append("Area de Recursos humanos:\t " + areaRecursosHumanos + " S/.  \n");
	}
}

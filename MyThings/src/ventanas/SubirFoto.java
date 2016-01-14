package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;

public class SubirFoto extends JFrame {

	private JPanel contentPane;
	public JFileChooser fileChooser;
	/**
	 * Create the frame.
	 */
	public SubirFoto() {
		setTitle("SUBIR FOTO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		fileChooser = new JFileChooser();
		fileChooser.setBounds(0, 0, 459, 317);
		contentPane.add(fileChooser);
	}
}

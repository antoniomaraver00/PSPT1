package es.studium.PSP_T1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;

public class PSP_T1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldCMD;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PSP_T1 frame = new PSP_T1();
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
	public PSP_T1() {
		setTitle("Pr\u00E1ctica PSP Tema 1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 796, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldCMD = new JTextField();
		textFieldCMD.setBounds(12, 13, 116, 22);
		contentPane.add(textFieldCMD);
		textFieldCMD.setColumns(10);
		
		JButton btnEjecutar = new JButton("Ejecutar");
		btnEjecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String cmd = textFieldCMD.getText();
					Process process = Runtime.getRuntime().exec("cmd /c " +cmd);
					//Obtenemos el resultado del cmd 
				    InputStreamReader entrada = new InputStreamReader(process.getInputStream());
				    BufferedReader br = new BufferedReader(entrada);
				    String salida = null;
		            System.out.println("Comando ejecutado Correctamente");
				        //Leemos el contenido
		            	while ((salida=br.readLine()) != null){
		            		textArea.append(salida+"\n");
		                	
		                }
		           
				    } 
				catch (IOException ioe) {
					System.out.println (ioe);
				}
			}
			
		});
		btnEjecutar.setBounds(140, 12, 97, 25);
		contentPane.add(btnEjecutar);
		
		textArea = new JTextArea();
		textArea.setBounds(12, 61, 218, 209);
		textArea.setEditable(false);
		contentPane.add(textArea);
		
		JButton btnBlocDeNotas = new JButton("Bloc de Notas");
		btnBlocDeNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Runtime runtime = Runtime.getRuntime();
				try
				{
					Process process = Runtime.getRuntime().exec("notepad.exe");
					//Bloqueamos el botón
					btnBlocDeNotas.setEnabled(false);
					System.out.println("El Bloc de Notas está abierto");
										
				}
				catch (IOException ex)
				{
					System.out.println("Error");
				}
			}
		});
		btnBlocDeNotas.setBounds(290, 12, 126, 25);
		contentPane.add(btnBlocDeNotas);
		
		JButton btnPaint = new JButton("Paint");
		btnPaint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Runtime runtime = Runtime.getRuntime();
				try
				{
					Process process = Runtime.getRuntime().exec("MSpaint.exe");
					//Bloqueamos el botón
					btnPaint.setEnabled(false);
					System.out.println("Paint está abierto");
										
				}
				catch (IOException ex)
				{
					System.out.println("Error");
				}
			}
			
		});
		btnPaint.setBounds(438, 12, 97, 25);
		contentPane.add(btnPaint);
		
		JButton btnGestin = new JButton("Gesti\u00F3n");
		btnGestin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Runtime runtime = Runtime.getRuntime();
				try
				{
					Process proc = Runtime.getRuntime().exec("java -jar /Logiin.jar");
					//Bloqueamos el botón
					btnGestin.setEnabled(false);
					System.out.println("El Programa de Gestión está abierto");
										
				}
				catch (IOException ex)
				{
					System.out.println("Error");
				}
			}
			
		});
		btnGestin.setBounds(547, 12, 97, 25);
		contentPane.add(btnGestin);
		
		JButton btnNewButton = new JButton("Juego");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Runtime runtime = Runtime.getRuntime();
				try
				{
					Process proc = Runtime.getRuntime().exec("java -jar /Logiin.jar");
					//Bloqueamos el botón
					btnGestin.setEnabled(false);
					System.out.println("El Programa del Juego está abierto");
										
				}
				catch (IOException ex)
				{
					System.out.println("Error");
				}
			}
		});
		btnNewButton.setBounds(656, 12, 97, 25);
		contentPane.add(btnNewButton);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(290, 61, 476, 165);
		contentPane.add(textArea_1);
		
		JButton btnTerminar = new JButton("Terminar");
		btnTerminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(WIDTH);
			}
		});
		btnTerminar.setBounds(485, 239, 97, 25);
		contentPane.add(btnTerminar);
	}
}

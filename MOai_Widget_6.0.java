import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class FileExplorer {

	public static void main(String[] args) throws IOException {
		boolean a = false;
        JFrame medidas = new JFrame();
        
        
		FileDialog fileDialogo = new FileDialog(medidas, "Test", FileDialog.LOAD);
		fileDialogo.setVisible(true);
        File archivo = new File(fileDialogo.getFile());
        
        JFrame v = new JFrame("Ejemplo de JLayeredPane");
        v.setVisible(true);
        v.setSize(400,400);
        v.setVisible(false);
        
      //  v.setVisible(true);
        /*
        SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new JFrame("frame1").setVisible(true);
				
			}
        	
        });*/


        //ruta absoluta jar
        String absoluteRuta = archivo.getAbsolutePath();
        absoluteRuta = absoluteRuta.replace('\\','/');
        System.out.println(absoluteRuta);
        
        //ruta relativa jar
        String relativeRuta = archivo.getPath();
        relativeRuta= relativeRuta.replace('\\','/');
        System.out.println(relativeRuta);
        
        //Composicion Ruta real
        System.out.println("Real Route" + fileDialogo.getDirectory());
        String realRoute = fileDialogo.getDirectory();
        
        //Conversion Ruta real
        String mainFileRoute = realRoute + relativeRuta;
        System.out.println(mainFileRoute);
		mainFileRoute = mainFileRoute.replace('\\','/');
		System.out.println(mainFileRoute);
		
		
		
		//PArametros Configurables
		
		
		
		int maximunWidth = 200;
		
		
		//DIMENSIONES DE PANTALLA
				//Pantalla como objeto de la clase dimension
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				//Parametros de ancho y alto de pantalla
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		
		boolean autoScale = true;
		
		
		
		CreateWindow(mainFileRoute, relativeRuta, maximunWidth, autoScale);
		

		
        if(a) {
			JTextField caja1  = new JTextField(mainFileRoute);
			medidas.setLayout(null);
			caja1.setBounds(10, 50, 150, 20);
			medidas.add(caja1);
			
			JTextField caja2 = new JTextField("File Name " + relativeRuta);
			caja2.setBounds(10, 75, 150, 20);
			medidas.add(caja2);
			
			JButton boton1 = new JButton("Aceptar");
			boton1.setBounds(10, 10, 150, 20);
			medidas.add(boton1);
			medidas.setSize(200,200);
			medidas.setVisible(true);
			//medidas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			boton1.addActionListener(new ActionListener() {
				
	
			
				private int part1;
				private int part2;
	
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					ArrayList<String> objetosLista = new ArrayList();
					
					objetosLista.add(caja1.getText());
					String medidas = caja1.getText();
					/*
					String[] parts = medidas.split("/");
					
					String aS = parts[1];
					String bS = parts[2];
					*/
					System.out.println(caja1.getText());
					
	
					
	
				}
				
			});
	
	        }
		}

	private static void CreateWindow(String mainFileRoute, String relativeRuta, int maximunWidth, boolean autoScale) {
		
		JFrame v = new JFrame("Ejemplo de JLayeredPane");
		
		
		JLayeredPane layered = new JLayeredPane();
		
		JLabel fondo = new JLabel();
		ImageIcon imagen = new ImageIcon(mainFileRoute);
		
		fondo.setIcon(imagen);
		
		System.out.println(imagen.getIconHeight() +" "+imagen.getIconWidth());
		System.out.println(imagen.getIconHeight()==imagen.getIconWidth());
		
	//500 230
		
		if (autoScale) {
			
			if(imagen.getIconWidth()>500) {

				//int cutHeight = autoScale(imagen.getIconWidth(),imagen.getIconHeight());
				System.out.println("AutoScaled Mode NON DISPONIBLE");
			}
		}

		fondo.setSize(imagen.getIconWidth(), imagen.getIconHeight());
		
		
		JLabel primerPlano = new JLabel("Primer plano");
		primerPlano.setSize(10, 10);
		
		layered.add(fondo, new Integer(1));
		layered.add(primerPlano, new Integer(2));
		
		//tamaño de ventana
		//
		//v.setLocation(10, 10);

		JButton close = new JButton("X");
		close.setBounds((imagen.getIconWidth()-15), 3, 20, 20);
		
		close.setBackground(Color.red);
		close.setOpaque(false);
		close.setBackground(new Color(0,0,0,0));
		close.setBorderPainted(false);
		v.add(close);
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}

		});

		JButton Menu = new JButton();
		Menu.setBounds(3, 3, 25, 25);
		Menu.setOpaque(false);
		Menu.setBackground(new Color(0,0,0,0));
		Menu.setBorderPainted(false);
		v.add(Menu);
		Menu.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						JFrame Menu = new JFrame("Config");
						//Menu.setUndecorated(true);//Decoraciones Deshabilitadas
						//Menu.setOpacity(50);
						//Menu.setBackground(new Color(0,0,0,0));
						Menu.setUndecorated(false);
						
						/*
						JCheckBox ck1 = new JCheckBox();
						ck1.setBounds(10, 190, 80, 25);
						Menu.add(ck1);
						*/
						
						JLabel etq1 = new JLabel("Posición X");
						etq1.setBounds(90, 25, 100, 25);
						Menu.add(etq1);
						
						JTextField caja1 = new JTextField("" + 10);
						caja1.setBounds(10, 25, 80, 25);
						Menu.add(caja1);
						
						JLabel etq2 = new JLabel("Posición Y");
						etq2.setBounds(90, 50, 100, 25);
						Menu.add(etq2);
						
						JTextField caja2 = new JTextField("" + 10);
						caja2.setBounds(10, 50, 80, 25);
						Menu.add(caja2);
						
						
						JLabel etq3 = new JLabel("Tamaño X");
						etq3.setBounds(90, 75, 100, 25);
						Menu.add(etq3);
						
						
						JTextField caja3 = new JTextField("" + imagen.getIconWidth());
						caja3.setBounds(10, 75, 80, 25);
						Menu.add(caja3);
						
						JLabel etq4 = new JLabel("Tamaño Y");
						etq4.setBounds(90, 100, 100, 25);
						Menu.add(etq4);
						
						JTextField caja4 = new JTextField("" + imagen.getIconHeight());
						caja4.setBounds(10, 100, 80, 25);
						Menu.add(caja4);
						
						JLabel etqMode = new JLabel("Modo Normal/OnTop/OnBack");
						etqMode.setBounds(90, 125, 200, 25);
						Menu.add(etqMode);
						
						JTextField cajaMode = new JTextField("");
						cajaMode.setBounds(10, 125, 80, 25);
						Menu.add(cajaMode);
						
						JButton bMode = new JButton("modo");
						bMode.setBounds(10, 160, 80, 25);
						Menu.add(bMode);
						
						bMode.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent arg0) {
								String command = cajaMode.getText();
								if(command.equalsIgnoreCase("NORMAL")) {
									v.setAlwaysOnTop(false);
									//v.setJMenuBar(null);
								} else if(command.equalsIgnoreCase("ONTOP")) {
									v.setAlwaysOnTop(true);
								} else if(command.equalsIgnoreCase("ONBACK")){									
									v.setFocusableWindowState(false);
									v.toBack();
								} else {
									JOptionPane.showMessageDialog(null, "Comando Nó VAlido");
								}
								
							}
						});
						
						/*
						JCheckBox autoGrip = new JCheckBox();
						autoGrip.setBounds(10,125,25, 25);
						Menu.add(autoGrip);
						autoGrip.setSelected(false);
						boolean selected = autoGrip.isSelected();
						*/
						
						JLabel etq5 = new JLabel("AutoGrip [R/L] + [U/C/D]");
						etq5.setBounds(90, 125, 200, 25);
						//Menu.add(etq5);
						
						
						JTextField caja5 = new JTextField("/R/U");
						caja5.setBounds(10, 150, 80, 25);
						//Menu.add(caja5);
						
						
						Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
						//Parametros de ancho y alto de pantalla
						int screenHeight = screenSize.height;
						int screenWidth = screenSize.width;
						
						
						
						int x = 18;
						int y = 18;
						
						JButton b1 = new JButton();
						b1.setBounds(150, 150, x, y);
						b1.setBackground(Color.blue);
						Menu.add(b1);
						b1.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								v.setBounds(3, (3), imagen.getIconWidth() ,imagen.getIconHeight());
							}

						});
						JButton b2 = new JButton();
						b2.setBounds(170, 150, x, y);
						b2.setBackground(Color.blue);
						Menu.add(b2);
						b2.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								v.setBounds(((screenWidth - imagen.getIconWidth())/2), (3), imagen.getIconWidth() ,imagen.getIconHeight());
							}

						});
						JButton b3 = new JButton();
						b3.setBounds(190, 150, x, y);
						b3.setBackground(Color.blue);
						Menu.add(b3);
						b3.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								v.setBounds(((screenWidth - imagen.getIconWidth())- 3), (3), imagen.getIconWidth() ,imagen.getIconHeight());
							}

						});

						

						JButton b4 = new JButton();
						b4.setBounds(150, 170, x, y);
						b4.setBackground(Color.blue);
						Menu.add(b4);
						b4.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								v.setBounds( 3, ((screenHeight - imagen.getIconHeight()))/2, imagen.getIconWidth() ,imagen.getIconHeight());
							}

						});
						JButton c = new JButton();
						c.setBounds(170, 170, x, y);
						c.setBackground(Color.blue);
						Menu.add(c);
						c.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								v.setBounds(((screenWidth - imagen.getIconWidth())/2), ((screenHeight - imagen.getIconHeight()))/2, imagen.getIconWidth() ,imagen.getIconHeight());
							}

						});
						JButton b5 = new JButton();
						b5.setBounds(190, 170, x, y);
						b5.setBackground(Color.blue);
						Menu.add(b5);
						b5.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								//v.setBounds(((screenWidth - imagen.getIconWidth()) - 3)/2, ((screenHeight - imagen.getIconHeight()) - 3)/2, imagen.getIconWidth() ,imagen.getIconHeight());
								v.setBounds(((screenWidth - imagen.getIconWidth()) - 3), ((screenHeight - imagen.getIconHeight()))/2, imagen.getIconWidth() ,imagen.getIconHeight());
							}

						});
						JButton b6 = new JButton();
						b6.setBounds(150, 190, x, y);
						b6.setBackground(Color.blue);
						Menu.add(b6);
						b6.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								v.setBounds(3, (screenHeight - imagen.getIconHeight() - 3), imagen.getIconWidth() ,imagen.getIconHeight());
								
							}

						});
						JButton b7 = new JButton();
						b7.setBounds(170, 190, x, y);
						b7.setBackground(Color.blue);
						Menu.add(b7);
						b7.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								v.setBounds(((screenWidth - imagen.getIconWidth()))/2, ((screenHeight - imagen.getIconHeight()) - 3), imagen.getIconWidth() ,imagen.getIconHeight());
							}

						});
						JButton b8 = new JButton();
						b8.setBounds(190, 190, x, y);
						b8.setBackground(Color.blue);
						Menu.add(b8);
						b8.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								v.setBounds(((screenWidth - imagen.getIconWidth())- 3), ((screenHeight - imagen.getIconHeight()) - 3), imagen.getIconWidth() ,imagen.getIconHeight());
								
							}

						});

						JButton show = new JButton("AutoGrip");
						show.setBounds(105, 220, 150, 25);
						Menu.add(show);
						
						JButton apply = new JButton("Aplicar");
						apply.setBounds(10, 220, 80, 25);
						Menu.add(apply);
						
						
						
						apply.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								//Parametros Posicion
								String XposS = caja1.getText();
								int Xpos = Integer.parseInt(XposS);
								
								String YposS = caja2.getText();
								int Ypos = Integer.parseInt(YposS);
								
								String XsizeS = caja3.getText();
								int Xsize = Integer.parseInt(XsizeS);
								
								String YsizeS = caja4.getText();
								int Ysize = Integer.parseInt(YsizeS);
								
								System.out.println(Xpos +" "+ Ypos);
								
								
								
								
								//sedCommands(Xpos, Ypos);
								
								//v.setLocation(Xpos,Ypos);
								
								v.setBounds(Xpos, Ypos, Xsize, Ysize);

							}


						});
						
						show.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								
								System.out.println(caja5.getText());
								
								String grid = caja5.getText();

								String[] parts = grid.split("/");
								
								String gridWide = parts[1];
								String gridHeight = parts[2];
								
								System.out.println(gridWide + " " + gridHeight);
								
								int gridPID;
								
								if(gridWide.equalsIgnoreCase("R")) {
									System.out.println("alinear derecha");
									if (gridHeight.equalsIgnoreCase("U")) {
										System.out.print(" arriba");
										gridPID = 11;
									} else if (gridHeight.equalsIgnoreCase("C")) {
										System.out.print(" centro");
										gridPID=12;
									} else if (gridHeight.equalsIgnoreCase("D")) {
										System.out.print(" abajo");
										gridPID = 13;
									} else {
										System.out.print(" sin alineado vertical");
										gridPID = 10;
									}
									
								}else if (gridWide.equalsIgnoreCase("L")) {
									System.out.println("alinear izquierda");
									if (gridHeight.equalsIgnoreCase("U")) {
										System.out.print(" arriba");
										gridPID = 21;
									} else if (gridHeight.equalsIgnoreCase("C")) {
										System.out.print(" centro");
										gridPID = 22;
									} else if (gridHeight.equalsIgnoreCase("D")) {
										System.out.print(" abajo");
										gridPID = 23;
									} else {
										System.out.print(" sin alineado vertical");
										gridPID = 20;
									}
								}else {
									System.out.println("No alinear y mantener posicion");
									if (gridHeight.equalsIgnoreCase("U")) {
										System.out.print(" arriba");
										gridPID = 01;
									} else if (gridHeight.equalsIgnoreCase("C")) {
										System.out.print(" centro");
										gridPID = 02;
									} else if (gridHeight.equalsIgnoreCase("D")) {
										System.out.print(" abajo");
										gridPID = 03;
									} else {
										System.out.print(" sin alineado vertical");
										gridPID = 00;
									}
								}
								//Pantalla como objeto de la clase dimension
								Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
										//Parametros de ancho y alto de pantalla
								int screenHeight = screenSize.height;
								int screenWidth = screenSize.width;
								switch(gridPID) {
								/*
								 * ((screenHeight - imagen.getIconWidth()) - 3)
								 * ((screenWidth - imagen.getIconWidth())- 3)
								 * 
								 * */
								 
								case 11:
									v.setBounds(((screenWidth - imagen.getIconWidth())- 3), (3), imagen.getIconWidth() ,imagen.getIconHeight());
									break;
								case 12:
									v.setBounds(((screenWidth - imagen.getIconWidth())- 3), ((screenHeight - imagen.getIconWidth()) - 3)/2, imagen.getIconWidth() ,imagen.getIconHeight());
									break;
								case 13:
									v.setBounds(((screenWidth - imagen.getIconWidth())- 3), ((screenHeight - imagen.getIconWidth()) - 3), imagen.getIconWidth() ,imagen.getIconHeight());
									break;
								case 21:
									v.setBounds(3, (3), imagen.getIconWidth() ,imagen.getIconHeight());
									break;
								case 22:
									v.setBounds(3, ((screenHeight - imagen.getIconWidth()) - 3)/2, imagen.getIconWidth() ,imagen.getIconHeight());
									break;
								case 23:
									v.setBounds(3, ((screenHeight - imagen.getIconWidth()) - 3), imagen.getIconWidth() ,imagen.getIconHeight());
									break;
									
										
								}
								
							}


						});

						
						
						
						
						Menu.setLayout(null);
						Menu.setVisible(true);
						//Menu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
						Menu.setBounds(10,10,300,300);
					}
				});
				
		
		v.setBounds((10), (10), imagen.getIconWidth() ,imagen.getIconHeight());

		// Se visualiza todo.

		v.getContentPane().add(layered);
		//v.setSize(imagen.getIconWidth(), imagen.getIconHeight());
		v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		v.setResizable(false);
		v.setUndecorated(true);
		v.setVisible(true);
		v.setLayout(null);
		
	}
	/*
	private static int autoScale(int iconWidth, int iconHeight) {
		int cutHeight = iconWidth - 
		return 0;
	}
	*/


}

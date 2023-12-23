package org.example.Vista;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.example.Controlador.AdminController;
import org.example.Modelo.Admin;
import org.example.Modelo.Ball;
import org.example.Modelo.Reserva;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;

public class frmAdmin extends JFrame {
    private int xMouse, yMouse;
    Ball balonF = new Ball();
    Ball balonV = new Ball();
    Ball balonB = new Ball();

    // Constructor
    public frmAdmin() {
        // Principales cosas que hay que hacer para que la interfaz sea modificada
        setTitle("Reserva de canchas UTP");// nombre
        setSize(1200, 600);// dimensiones
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // cuando el usuario cierra la ventana principal, la aplicación
                                                        // se detendrá y finalizará.
        setLocationRelativeTo(null); // Centrar la ventana
        setLayout(new BorderLayout());// se utiliza comúnmente para organizar componentes en cinco áreas distintas de
                                      // un contenedor
        setResizable(false); // No permite que se redimensione la ventana
        setUndecorated(true); // Quita la barra de estado para maximizar, minimizar y cerrar
        setIconImage(Toolkit.getDefaultToolkit().getImage(
                "..\\TrabajoFinal\\Programa_ReservaDeCanchas\\src\\main\\java\\org\\example\\Resources\\fuvhibol.png"));// icono
                                                                                                                        // de
                                                                                                                        // programa
        // Estamos dentro de la interfaz hay que poner nuestro "lienzo"
        JPanel formPanel = new JPanel(null);// creando el JPanel
        formPanel.setBackground(new Color(255, 255, 255));// Agregando un color de fondo
        // -----------------MODIFICAMOS LOS COMPONENTES---------------------

        // JLabel para cerrar ventana
        JLabel x = new JLabel("X");
        x.setForeground(new Color(0, 0, 0));
        x.setFont(new Font("Arial", Font.BOLD, 14));
        x.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        x.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0); // Cierra la aplicación cuando se hace clic en "X"
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                x.setForeground(new Color(21, 204, 175));// cambia el color de primer plano al entrar
            }

            @Override
            public void mouseExited(MouseEvent e) {
                x.setForeground(new Color(0, 0, 0));// Restaura el color de primer plano al salir
            }
        });
        // Borde movible de la ventana black
        JPanel header1 = new JPanel();
        header1.setPreferredSize(new Dimension(0, 30)); // Las dimensiones del JPanel
        header1.setBackground(new Color(0, 0, 0));
        header1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                xMouse = e.getXOnScreen() - getX();
                yMouse = e.getYOnScreen() - getY();
            }
        });

        header1.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) { // permite responder a eventos de arrastre del mouse, lo que
                                                     // significa que se ejecutará cuando el usuario arrastre el cursor
                                                     // del mouse mientras el botón del mouse esté presionado
                int newX = e.getXOnScreen() - xMouse;
                int newY = e.getYOnScreen() - yMouse;

                setLocation(newX, newY);
            }
        });
        // Borde movible de la ventana white
        JPanel header2 = new JPanel();
        header2.setPreferredSize(new Dimension(30, 30)); // Las dimensiones del JPanel
        header2.setBackground(new Color(255, 255, 255));
        header2.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                xMouse = e.getXOnScreen() - getX();
                yMouse = e.getYOnScreen() - getY();
            }
        });

        header2.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) { // permite responder a eventos de arrastre del mouse, lo que
                                                     // significa que se ejecutará cuando el usuario arrastre el cursor
                                                     // del mouse mientras el botón del mouse esté presionado
                int newX = e.getXOnScreen() - xMouse;
                int newY = e.getYOnScreen() - yMouse;

                setLocation(newX, newY);
            }
        });
        // Body
        // Fonts que utilizare
        Font titulos = new Font("Brush Script MT", Font.ITALIC, 30);
        Font texto = new Font("Inter", Font.BOLD, 15);
        Font numeros = new Font("Inter", Font.BOLD, 30);

        // La Parte Izquierda de la Interfaz
        // JPanel black
        JPanel Pblack = new JPanel();
        Pblack.setBackground(new Color(0, 0, 0));

        JLabel jlbBienvenidaI = new JLabel("Horarios Ocupados");
        jlbBienvenidaI.setForeground(Color.white);
        jlbBienvenidaI.setFont(titulos);

        // mostrar tabla
        JTable jtxtTabla = new JTable();
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Codigo");
        model.addColumn("Nombres");
        model.addColumn("Deporte");
        model.addColumn("Hora Reservada");
        model.addColumn("Hora de Reserva");
        model.addColumn("Facultad");

        AdminController.getInstance().mostrarTabla(model);

        jtxtTabla.setModel(model);
        JScrollPane scrollPane = new JScrollPane(jtxtTabla);
        jtxtTabla.setDefaultEditor(Reserva.class, null);

        // Icono de la U (UTP, no universitario)
        JLabel imagenLogo = new JLabel();
        ImageIcon imagenIconoLogo = new ImageIcon(
                "..\\TrabajoFinal\\Programa_ReservaDeCanchas\\src\\main\\java\\org\\example\\Resources\\Logo_utp.png");
        imagenLogo.setIcon(imagenIconoLogo);

        // La Parte Derecha De la Interfaz
        // Jlabel de bienvenida
        JLabel jlbienvenidaD = new JLabel("! Bienvenido Administrador, ");
        jlbienvenidaD.setForeground(Color.RED);
        jlbienvenidaD.setFont(titulos);
        JLabel jlbienvenidaNombre = new JLabel(Admin.getInstancia().getNombre());
        jlbienvenidaNombre.setForeground(Color.BLACK);
        jlbienvenidaNombre.setFont(titulos);
        JLabel jlbienvenidaFinD = new JLabel(" !");
        jlbienvenidaFinD.setForeground(Color.RED);
        jlbienvenidaFinD.setFont(titulos);

        // Hora de Inicio
        JLabel jlbHoraDrestringir = new JLabel("Restringir Hora");
        jlbHoraDrestringir.setForeground(Color.black);
        jlbHoraDrestringir.setFont(texto);
        // Usamos Jlist para que elijan la hora de la cual quieren
        // Lista para la hora de inicio
        JComboBox<String> listhora = new JComboBox<>();
        // Añadimos la lista de horas
        for (int i = 1; i <= 12; i++) {
            listhora.addItem(String.format("%02d", i));
        }

        JComboBox<String> listturno = new JComboBox<>();
        // Añadimos turnos
        listturno.addItem("am");
        listturno.addItem("pm");
        JComboBox<String> listMinutos = new JComboBox<>();
        // Añadimos Minutos
        for (int i = 0; i <= 45; i += 15) {
            listMinutos.addItem(String.format("%02d", i));
        }
        // Lista para la hora de fin
        JComboBox<String> listhoraF = new JComboBox<>();
        // Añadimos la lista de horas
        for (int i = 1; i <= 12; i++) {
            listhoraF.addItem(String.format("%02d", i));
        }
        JComboBox<String> listturnoF = new JComboBox<>();
        // Añadimos turnos
        listturnoF.addItem("am");
        listturnoF.addItem("pm");

        JComboBox<String> listMinutosF = new JComboBox<>();
        // Añadimos Minutos
        for (int i = 0; i <= 45; i += 15) {
            listMinutosF.addItem(String.format("%02d", i));
        }
        Border black = new LineBorder(new Color(0, 0, 0), 1, false);

        // Boton para Restringir hora
        JButton btnRestringirHora = new JButton("Restringir");
        btnRestringirHora.setBorder(black);
        btnRestringirHora.setBackground(new Color(255, 0, 0));
        btnRestringirHora.setForeground(new Color(255, 255, 255));
        btnRestringirHora.setFont(new Font("Roboto", Font.BOLD, 10));
        btnRestringirHora.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRestringirHora.setFont(texto);
        btnRestringirHora.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnRestringirHora.setForeground(new Color(0, 0, 0));
                btnRestringirHora.setBackground(new Color(255, 255, 255));// cambia el color de primer plano al entrar
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnRestringirHora.setForeground(new Color(255, 255, 255));
                btnRestringirHora.setBackground(new Color(255, 0, 0));// Restaura el color de primer plano al salir
            }
        });

        // La parte de Eliminar Hora
        // boton de Eliminar Hora
        JButton btnElminarHora = new JButton("Eliminar");
        btnElminarHora.setBorder(black);
        btnElminarHora.setBackground(new Color(255, 0, 0));
        btnElminarHora.setForeground(new Color(255, 255, 255));
        btnElminarHora.setFont(new Font("Roboto", Font.BOLD, 14));
        btnElminarHora.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        btnElminarHora.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnElminarHora.setForeground(new Color(0, 0, 0));
                btnElminarHora.setBackground(new Color(255, 255, 255));// cambia el color de primer plano al entrar
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnElminarHora.setForeground(new Color(255, 255, 255));
                btnElminarHora.setBackground(new Color(255, 0, 0));// Restaura el color de primer plano al salir
            }
        });

        UIManager.put("ToolTip.foreground", Color.BLACK);
        UIManager.put("ToolTip.background", Color.white);
        btnElminarHora.setToolTipText("Selecciona una fila para eliminar una reserva ✔");

        // Parte de agregar Balones
        JLabel iconFutbol = new JLabel();
        ImageIcon imagenIconoFutbol = new ImageIcon(
                "..\\TrabajoFinal\\Programa_ReservaDeCanchas\\src\\main\\java\\org\\example\\Vista\\Resources\\iconoFutbol.png");
        iconFutbol.setIcon(imagenIconoFutbol);

        JLabel iconVoley = new JLabel();
        ImageIcon imagenIconoVoley = new ImageIcon(
                "..\\TrabajoFinal\\Programa_ReservaDeCanchas\\src\\main\\java\\org\\example\\Vista\\Resources\\iconoVoley.png");
        iconVoley.setIcon(imagenIconoVoley);

        JLabel iconBasquet = new JLabel();
        ImageIcon imagenIconoBasquet = new ImageIcon(
                "..\\TrabajoFinal\\Programa_ReservaDeCanchas\\src\\main\\java\\org\\example\\Vista\\Resources\\iconoBasquet.png");
        iconBasquet.setIcon(imagenIconoBasquet);

        JLabel lblAgregarBalls = new JLabel("Agregar Balones");
        lblAgregarBalls.setForeground(Color.black);
        lblAgregarBalls.setFont(texto);

        JTextField jtxtbasquet = new JTextField();
        JTextField jtxtFutbol = new JTextField();
        JTextField jtxtVoley = new JTextField();

        jtxtbasquet.setHorizontalAlignment(SwingConstants.CENTER);
        jtxtFutbol.setHorizontalAlignment(SwingConstants.CENTER);
        jtxtVoley.setHorizontalAlignment(SwingConstants.CENTER);

        JButton btnAgregarBalones = new JButton("Agregar");
        btnAgregarBalones.setBorder(black);
        btnAgregarBalones.setBackground(new Color(255, 0, 0));
        btnAgregarBalones.setForeground(new Color(255, 255, 255));
        btnAgregarBalones.setFont(new Font("Roboto", Font.BOLD, 14));
        btnAgregarBalones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnAgregarBalones.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnAgregarBalones.setForeground(new Color(0, 0, 0));
                btnAgregarBalones.setBackground(new Color(255, 255, 255));// cambia el color de primer plano al entrar
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnAgregarBalones.setForeground(new Color(255, 255, 255));
                btnAgregarBalones.setBackground(new Color(255, 0, 0));// Restaura el color de primer plano al salir
            }
        });

        // Parte de Balones disponibles
        // usamos los iconos ya creados
        JLabel jlbBalonesDispo = new JLabel("Balones Disponibles");
        jlbBalonesDispo.setFont(texto);
        jlbBalonesDispo.setForeground(Color.black);

        JLabel iconFutbolDispo = new JLabel();
        ImageIcon imagenIconoFutbolDispo = new ImageIcon(
                "..\\TrabajoFinal\\Programa_ReservaDeCanchas\\src\\main\\java\\org\\example\\Vista\\Resources\\iconoFutbol.png");
        iconFutbolDispo.setIcon(imagenIconoFutbolDispo);

        JLabel iconVoleyDispo = new JLabel();
        ImageIcon imagenIconoVoleyDispo = new ImageIcon(
                "..\\TrabajoFinal\\Programa_ReservaDeCanchas\\src\\main\\java\\org\\example\\Vista\\Resources\\iconoVoley.png");
        iconVoleyDispo.setIcon(imagenIconoVoleyDispo);

        JLabel iconBasquetDispo = new JLabel();
        ImageIcon imagenIconoBasquetDispo = new ImageIcon(
                "..\\TrabajoFinal\\Programa_ReservaDeCanchas\\src\\main\\java\\org\\example\\Vista\\Resources\\iconoBasquet.png");
        iconBasquetDispo.setIcon(imagenIconoBasquetDispo);

        balonB.setCantidad(0);
        balonF.setCantidad(0);
        balonV.setCantidad(0);

        JLabel jlbBalonesDispoV = new JLabel(String.valueOf((balonV.getCantidad())));
        jlbBalonesDispoV.setForeground(Color.black);
        jlbBalonesDispoV.setFont(numeros);

        JLabel jlbBalonesDispoB = new JLabel(String.valueOf((balonB.getCantidad())));
        jlbBalonesDispoB.setForeground(Color.black);
        jlbBalonesDispoB.setFont(numeros);
        JLabel jlbBalonesDispoF = new JLabel(String.valueOf(balonF.getCantidad()));
        jlbBalonesDispoF.setForeground(Color.black);
        jlbBalonesDispoF.setFont(numeros);

        // Modificamos las posiciones de los componentes
        x.setBounds(1183, 0, 30, 30);
        header1.setBounds(0, 0, 600, 30);
        Pblack.setBounds(0, 0, 600, 600);
        imagenLogo.setBounds(200, 300, 400, 450);
        jlbBienvenidaI.setBounds(200, 0, 280, 30);

        scrollPane.setBackground(Color.white);
        scrollPane.setBounds(20, 35, 560, 450);
        scrollPane.setFocusable(false);

        jlbienvenidaD.setBounds(705, 0, 300, 30);
        jlbienvenidaNombre.setBounds(990, 0, 140, 30);
        jlbienvenidaFinD.setBounds(1040, 0, 140, 30);

/*        jlbHoraDrestringir.setBounds(850, 40, 280, 30);
        listhora.setBounds(650, 90, 50, 30);
        listMinutos.setBounds(730, 90, 50, 30);
        listturno.setBounds(810, 90, 50, 30);

        listhoraF.setBounds(940, 90, 50, 30);
        listMinutosF.setBounds(1020, 90, 50, 30);
        listturnoF.setBounds(1100, 90, 50, 30);

        btnRestringirHora.setBounds(850, 150, 100, 30);
  */

        btnElminarHora.setBounds(850, 380, 100, 30);

        lblAgregarBalls.setBounds(850, 100, 280, 30);

        jtxtFutbol.setBounds(680, 150, 40, 40);
        jtxtbasquet.setBounds(830, 150, 40, 40);
        jtxtVoley.setBounds(990, 150, 40, 40);

        iconFutbol.setBounds(750, 150, 40, 40);
        iconBasquet.setBounds(910, 150, 40, 40);
        iconVoley.setBounds(1070, 150, 40, 40);

        jlbBalonesDispo.setBounds(850, 220, 280, 30);

        jlbBalonesDispoV.setBounds(1080, 280, 50, 50);
        jlbBalonesDispoF.setBounds(780, 280, 50, 50);
        jlbBalonesDispoB.setBounds(930, 280, 50, 50);

        iconFutbolDispo.setBounds(700, 280, 40, 40);
        iconBasquetDispo.setBounds(850, 280, 40, 40);
        iconVoleyDispo.setBounds(1010, 280, 40, 40);

        // Agregamos los componentes al formPanel
        formPanel.add(scrollPane);
        formPanel.add(imagenLogo);
        formPanel.add(jlbBienvenidaI);
        formPanel.add(Pblack);
        formPanel.add(jlbienvenidaD);
        formPanel.add(jlbienvenidaNombre);
        formPanel.add(jlbienvenidaFinD);

        formPanel.add(btnElminarHora);

        formPanel.add(lblAgregarBalls);
        formPanel.add(jtxtbasquet);
        formPanel.add(jtxtVoley);
        formPanel.add(jtxtFutbol);

        formPanel.add(iconFutbol);
        formPanel.add(iconVoley);
        formPanel.add(iconBasquet);

        formPanel.add(btnAgregarBalones);
        formPanel.add(jlbBalonesDispo);

        formPanel.add(iconBasquetDispo);
        formPanel.add(iconFutbolDispo);
        formPanel.add(iconVoleyDispo);

        formPanel.add(jlbBalonesDispoF);
        formPanel.add(jlbBalonesDispoB);
        formPanel.add(jlbBalonesDispoV);

        add(x, BorderLayout.NORTH);
        add(header1, BorderLayout.NORTH);
        add(header2, BorderLayout.NORTH); // Agregamos el JPanel header para que sea movible
        add(formPanel, BorderLayout.CENTER);



        btnElminarHora.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminController.getInstance().eliminarReserva(model, jtxtTabla);
            }

        });

        eventosBalon(jtxtFutbol, jlbBalonesDispoF, balonF);
        eventosBalon(jtxtVoley, jlbBalonesDispoV, balonV);
        eventosBalon(jtxtbasquet, jlbBalonesDispoB, balonB);

    }

    // Funcion para eventos para cada tipo de balon
    public void eventosBalon(JTextField balon, JLabel jlbBalonesDispo, Ball balonT) {
        balon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    String input = balon.getText();
                    if (input.equalsIgnoreCase("reset")) {
                        balonT.setCantidad(0);
                        jlbBalonesDispo.setText(String.valueOf(balonT.getCantidad()));
                    } else {
                        try {
                            int valor = Integer.parseInt(input);
                            balonT.setCantidad(balonT.getCantidad() + valor);
                            jlbBalonesDispo.setText(String.valueOf(balonT.getCantidad()));
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Ingresa datos apropiados (números)", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    balon.setText("");
                }
            }
        });

    }
}

package org.example.Vista;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.example.AccesoDatos.DAOReserva;
import org.example.Controlador.UserController;
import org.example.Modelo.Reserva;
import org.example.Modelo.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmUser extends JFrame {
    private int xMouse, yMouse;

    // Constructor
    public frmUser() throws HeadlessException {
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
                "C:\\Users\\Santiago\\Desktop\\Ciclo 5\\POO\\TrabajoFinal\\Programa_ReservaDeCanchas\\src\\main\\java\\org\\example\\Resources\\fuvhibol.png"));// icono
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
        model.addColumn("Deporte");
        model.addColumn("Fecha");

        UserController.getInstance().mostrarTabla(model);
        jtxtTabla.setModel(model);
        JScrollPane scrollPane = new JScrollPane(jtxtTabla);
        jtxtTabla.setDefaultEditor(Object.class, null);

        // Icono de la U (UTP, no universitario)
        JLabel imagenLogo = new JLabel();
        ImageIcon imagenIconoLogo = new ImageIcon(
                "C:\\Users\\Santiago\\Desktop\\Ciclo 5\\POO\\TrabajoFinal\\Programa_ReservaDeCanchas\\src\\main\\java\\org\\example\\Resources\\Logo_utp.png");
        imagenLogo.setIcon(imagenIconoLogo);

        // La Parte Derecha De la Interfaz
        // Jlabel de bienvenida
        JLabel jlbienvenidaD = new JLabel("!  Bienvenido de vuelta, ");
        jlbienvenidaD.setForeground(Color.RED);
        jlbienvenidaD.setFont(titulos);

        JLabel jlbienvenidaNombre = new JLabel(User.getInstancia().getNombre());
        jlbienvenidaNombre.setForeground(Color.BLACK);
        jlbienvenidaNombre.setFont(titulos);

        JLabel jlbienvenidaFinD = new JLabel(" !");
        jlbienvenidaFinD.setForeground(Color.RED);
        jlbienvenidaFinD.setFont(titulos);

        // Hora de Inicio
        JLabel jlbHoraDInicio = new JLabel("Hora de Inicio");
        jlbHoraDInicio.setForeground(Color.black);
        jlbHoraDInicio.setFont(texto);
        // Usamos JComboBox para que elijan la hora de la cual quieren
        JComboBox<Integer> listhora = new JComboBox<>();
        // Añadimos la lista de horas
        for (int i = 1; i <= 12; i++) {
            listhora.addItem(i);
        }

        JComboBox<String> listturno = new JComboBox<>();
        // Añadimos turnos
        listturno.addItem("am");
        listturno.addItem("pm");

        JComboBox<Integer> listMinutos = new JComboBox<>();
        // Añadimos Minutos
        for (int i = 0; i <= 45; i += 15) {
            listMinutos.addItem(i);
        }
        // La parte de Duracion de reserva
        JLabel jlbDuracionDreserva = new JLabel("Duracion de Reserva");
        jlbDuracionDreserva.setFont(texto);
        jlbDuracionDreserva.setForeground(Color.black);
        JLabel jlbDuracionDreservaHoras = new JLabel("Horas");
        jlbDuracionDreservaHoras.setFont(texto);
        jlbDuracionDreservaHoras.setForeground(Color.black);

        JComboBox<Integer> listDuracionReserva = new JComboBox<>();
        // Añadimos las horas de la duracion de reserva
        for (int i = 1; i <= 2; i++) {
            listDuracionReserva.addItem(i);
        }
        // Que deporte se realizara
        JLabel jlbDeporte = new JLabel("Deporte a realizar");
        jlbDeporte.setFont(texto);
        jlbDeporte.setForeground(Color.black);
        // Usamos Jlist para que elijan la hora de la cual quieren
        JComboBox<String> listDeporte = new JComboBox<>();
        // Añadimos la lista de horas
        listDeporte.addItem("Futbol");
        listDeporte.addItem("Basquet");
        listDeporte.addItem("Voley");

        // boton de reservar
        Border black = new LineBorder(new Color(0, 0, 0), 1, false);
        JButton btnReservar = new JButton("RESERVAR");
        btnReservar.setBorder(black);
        btnReservar.setBackground(new Color(255, 0, 0));
        btnReservar.setForeground(new Color(255, 255, 255));
        btnReservar.setFont(new Font("Roboto", Font.BOLD, 14));
        btnReservar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnReservar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnReservar.setForeground(new Color(0, 0, 0));
                btnReservar.setBackground(new Color(255, 255, 255));// cambia el color de primer plano al entrar
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnReservar.setForeground(new Color(255, 255, 255));
                btnReservar.setBackground(new Color(255, 0, 0));// Restaura el color de primer plano al salir
            }
        });

        // Modificamos las posiciones de los componentes
        x.setBounds(1183, 0, 30, 30);
        header1.setBounds(0, 0, 600, 30);
        Pblack.setBounds(0, 0, 600, 600);
        imagenLogo.setBounds(200, 300, 400, 450);
        jlbBienvenidaI.setBounds(200, 0, 280, 30);

        scrollPane.setBackground(Color.white);
        scrollPane.setBounds(20, 35, 560, 450);
        scrollPane.setFocusable(false);

        jlbienvenidaD.setBounds(760, 0, 280, 30);
        jlbienvenidaNombre.setBounds(1000, 0, 140, 30);
        jlbienvenidaFinD.setBounds(1080, 0, 140, 30);

        jlbHoraDInicio.setBounds(850, 80, 280, 30);

        listhora.setBounds(810, 150, 50, 30);
        listMinutos.setBounds(880, 150, 50, 30);
        listturno.setBounds(960, 150, 50, 30);

        jlbDuracionDreserva.setBounds(830, 230, 280, 30);

        listDuracionReserva.setBounds(880, 300, 50, 30);
        jlbDuracionDreservaHoras.setBounds(950, 300, 80, 30);

        jlbDeporte.setBounds(850, 370, 280, 30);
        listDeporte.setBounds(880, 440, 80, 30);

        btnReservar.setBounds(850, 510, 140, 50);
        // Agregamos los componentes al formPanel
        formPanel.add(scrollPane);

        formPanel.add(imagenLogo);
        formPanel.add(jlbBienvenidaI);
        formPanel.add(btnReservar);
        formPanel.add(Pblack);
        formPanel.add(jlbienvenidaD);
        formPanel.add(jlbienvenidaNombre);
        formPanel.add(jlbienvenidaFinD);
        formPanel.add(jlbHoraDInicio);
        formPanel.add(listhora);
        formPanel.add(listMinutos);
        formPanel.add(listturno);
        formPanel.add(jlbDuracionDreserva);
        formPanel.add(listDuracionReserva);
        formPanel.add(jlbDuracionDreservaHoras);
        formPanel.add(jlbDeporte);
        formPanel.add(listDeporte);
        formPanel.add(btnReservar);

        // TODO
        add(x, BorderLayout.NORTH);
        add(header1, BorderLayout.NORTH);
        add(header2, BorderLayout.NORTH); // Agregamos el JPanel header para que sea movible
        add(formPanel, BorderLayout.CENTER);
        btnReservar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String deporte = (String) listDeporte.getSelectedItem();
                int hora = (int) listhora.getSelectedItem();
                int minutos = (int) listMinutos.getSelectedItem();
                String turno = (String) listturno.getSelectedItem();
                int duracion = (int) listDuracionReserva.getSelectedItem();
                if (UserController.getInstance().guardarReserva(deporte,hora ,minutos,turno,duracion,model)){
                    JOptionPane.showMessageDialog(null, "Reserva hecha con exito " + User.getInstancia().getNombre(), "Felicitaciones", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Hay un error en tu reserva, intentalo denuevo ", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }





        });
    }

}

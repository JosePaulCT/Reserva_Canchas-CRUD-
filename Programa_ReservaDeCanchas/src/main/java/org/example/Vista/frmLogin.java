package org.example.Vista;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import org.example.Controlador.AdminController;
import org.example.Controlador.UserController;
import org.example.Modelo.Admin;
import org.example.Modelo.User;

import java.awt.*;
import java.awt.event.*;

public class frmLogin extends JFrame {

    // los text field para ingresar datos
    private JTextField usernameField;
    private JPasswordField passwordField;
    private int xMouse, yMouse;

    public frmLogin() {

        setTitle("Login");// nombre
        setSize(800, 500);// dimensiones
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // uando el usuario cierra la ventana principal, la aplicación
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

        // Añadimos algunas cosas al JPanel
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
                x.setForeground(new Color(128, 128, 128));// cambia el color de primer plano al entrar
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

        // JPanel black
        JPanel Pblack = new JPanel();
        Pblack.setBackground(new Color(0, 0, 0));
        // JLabel imagen Fondo
        JLabel imagenFondo = new JLabel();
        ImageIcon imagenIcon = new ImageIcon(
                "C:\\Users\\Santiago\\Desktop\\Ciclo 5\\POO\\TrabajoFinal\\Programa_ReservaDeCanchas\\src\\main\\java\\org\\example\\Resources\\FondoDPantalla.png");
        imagenFondo.setIcon(imagenIcon);
        // JLabel Imagen LOGO
        JLabel imagenLogo = new JLabel();
        ImageIcon imagenIconoLogo = new ImageIcon(
                "C:\\Users\\Santiago\\Desktop\\Ciclo 5\\POO\\TrabajoFinal\\Programa_ReservaDeCanchas\\src\\main\\java\\org\\example\\Resources\\Logo_utp.png");
        imagenLogo.setIcon(imagenIconoLogo);
        // JLabel Imagen USUARIO
        JLabel imagenUser = new JLabel();
        ImageIcon imagenIconoUser = new ImageIcon(
                "C:\\Users\\Santiago\\Desktop\\Ciclo 5\\POO\\TrabajoFinal\\Programa_ReservaDeCanchas\\src\\main\\java\\org\\example\\Resources\\User.png");
        imagenUser.setIcon(imagenIconoUser);
        // JText TITULO
        JLabel lblTitulo1 = new JLabel("RESERVA DE");
        lblTitulo1.setForeground(new Color(255, 255, 255));
        lblTitulo1.setFont(new Font("Inter", Font.BOLD, 30));

        JLabel lblTitulo2 = new JLabel("CAMPOS");
        lblTitulo2.setForeground(new Color(255, 255, 255));
        lblTitulo2.setFont(new Font("Inter", Font.BOLD, 30));

        JLabel lblTitulo3 = new JLabel("DEPORTIVOS");
        lblTitulo3.setForeground(new Color(255, 255, 255));
        lblTitulo3.setFont(new Font("Inter", Font.BOLD, 30));
        // JLabel INGRESE TEXTO
        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setForeground(new Color(0, 0, 0));
        lblCodigo.setFont(new Font("Roboto", Font.BOLD, 14));

        JLabel lblContraseña = new JLabel("Contraseña:");
        lblContraseña.setForeground(new Color(0, 0, 0));
        lblContraseña.setFont(new Font("Roboto", Font.BOLD, 14));
        // CONDICIONES DE BORDEADO
        Border lineBorder = new LineBorder(new Color(0, 0, 0), 1); // Cambia el color y el grosor del borde
        Border topTransparentBorder = BorderFactory.createEmptyBorder(-1, -1, 4, -1); // Ajusta el espacio superior,
                                                                                      // Borde personalizado para hacer
                                                                                      // transparente la parte superior
        Border compoundBorder = BorderFactory.createCompoundBorder(topTransparentBorder, lineBorder);// Combina los
                                                                                                     // bordes para
                                                                                                     // crear el efecto
                                                                                                     // deseado
        // JTextLabel codigo, contraseña
        usernameField = new JTextField();
        usernameField.setOpaque(false);
        usernameField.setBorder(compoundBorder);
        usernameField.setFont(new Font("Inter", Font.PLAIN, 13));

        passwordField = new JPasswordField();
        passwordField.setOpaque(false);
        passwordField.setBorder(compoundBorder);
        passwordField.setFont(new Font("Inter", Font.PLAIN, 13));
        // Borde negro
        Border black = new LineBorder(new Color(0, 0, 0), 1, false); // El tercer parámetro es para redondear
        // BTN INGRESAR
        JButton loginButton = new JButton("INGRESAR");
        loginButton.setBorder(black);
        loginButton.setBackground(new Color(0, 0, 0));
        loginButton.setForeground(new Color(255, 255, 255));
        loginButton.setFont(new Font("Roboto", Font.BOLD, 14));
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                loginButton.setForeground(new Color(0, 0, 0));
                loginButton.setBackground(new Color(255, 255, 255));// cambia el color de primer plano al entrar
            }

            @Override
            public void mouseExited(MouseEvent e) {
                loginButton.setForeground(new Color(255, 255, 255));
                loginButton.setBackground(new Color(0, 0, 0));// Restaura el color de primer plano al salir
            }
        });

        // MODIFICAMOS LAS POSICIONES DE LOS COMPONENTES
        x.setBounds(770, 10, 17, 17);
        header1.setBounds(0, 0, 400, 30);
        Pblack.setBounds(0, 0, 400, 800);
        imagenFondo.setBounds(365, 28, 400, 450);
        imagenLogo.setBounds(100, 300, 200, 100);
        imagenUser.setBounds(550, 20, 80, 80);
        lblTitulo1.setBounds(80, 140, 250, 30);
        lblTitulo2.setBounds(80, 180, 150, 30);
        lblTitulo3.setBounds(80, 220, 220, 30);
        lblCodigo.setBounds(420, 160, 200, 17);
        usernameField.setBounds(550, 187, 150, 30);
        lblContraseña.setBounds(420, 240, 100, 17);
        passwordField.setBounds(550, 268, 150, 30);
        loginButton.setBounds(540, 330, 100, 30);

        // AGREGAMOS LOS COMPONENTES AL formPanel
        formPanel.add(imagenLogo);
        formPanel.add(imagenUser);
        formPanel.add(lblTitulo1);
        formPanel.add(lblTitulo2);
        formPanel.add(lblTitulo3);
        formPanel.add(lblCodigo);
        formPanel.add(usernameField);
        formPanel.add(lblContraseña);
        formPanel.add(passwordField);
        formPanel.add(loginButton);
        formPanel.add(Pblack);

        add(x, BorderLayout.NORTH);
        add(header1, BorderLayout.NORTH); // Agregamos el JPanel header para que sea movible
        add(header2, BorderLayout.NORTH); // Agregamos el JPanel header para que sea movible
        add(imagenFondo, BorderLayout.CENTER);
        add(usernameField, BorderLayout.CENTER);
        add(passwordField, BorderLayout.CENTER);
        add(formPanel, BorderLayout.CENTER);

        passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    loginButton.doClick(); // Simula el clic en el botón cuando se presiona Enter
                }
            }
        });

        loginButton.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {
                if (AdminController.getInstance().buscar(usernameField.getText(), passwordField.getText())) {
                    dispose();
                    frmAdmin adminForm = new frmAdmin();
                    adminForm.setVisible(true);
                    System.out.println("Hola administrador : " + Admin.getInstancia().getNombre());
                } else {
                    if (UserController.getInstance().buscar(usernameField.getText(), passwordField.getText())) {
                        dispose();
                        frmUser userForm = new frmUser();
                        userForm.setVisible(true);
                        System.out.println("Hola usuario  : " + User.getInstancia().getNombre());
                    } else {
                        JOptionPane.showMessageDialog(null, "Credenciales incorrectas", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

        });

    }

}

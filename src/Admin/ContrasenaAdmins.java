package Admin;

import Interfaz.MiImagen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContrasenaAdmins extends JFrame {
    private JPanel panelContainer, panelDatos, panel1, panel2, panelBotones, imagen;
    private JButton ingresar, regresar;
    private JLabel usuario, contrasena;
    private JTextField usuarioEntrada;
    private JPasswordField contrasenaEntrada;
    private MiImagen miImagen;
    private final String contraseñaCorrecta = "admin";

    public ContrasenaAdmins() {
        MiImagen miImagen = new MiImagen();
        this.miImagen = miImagen;
        initFrame();
        configFrame();
        initControl();
        setControl();
        configPanel();
        acciones();
    }

    private void initFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(miImagen, BorderLayout.CENTER);
        setSize(400, 600);
        setVisible(true);
    }

    private void configFrame() {
        setTitle("Inicio");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(400, 500);
    }

    private void initControl() {
        panelContainer = new JPanel();
        panelBotones = new JPanel();
        imagen = new JPanel();
        panelDatos = new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();

        ingresar = new JButton();
        regresar = new JButton();

        usuario = new JLabel();
        contrasena = new JLabel();

        usuarioEntrada = new JTextField();
        contrasenaEntrada = new JPasswordField();
    }

    private void setControl() {
        ingresar.setText("Ingresar");
        regresar.setText("Regresar");
        usuario.setText("Usuario");
        contrasena.setText("Contraseña");
    }

    private void configPanel() {
        panel1.setLayout(new GridLayout(2, 1));
        panel1.add(usuario);
        panel1.add(contrasena);

        panel2.setLayout(new GridLayout(2, 1));
        panel2.add(usuarioEntrada);
        panel2.add(contrasenaEntrada);

        panelDatos.setLayout(new GridLayout(1, 2));
        panelDatos.add(panel1);
        panelDatos.add(panel2);

        panelBotones.setLayout(new FlowLayout());
        panelBotones.add(ingresar);
        panelBotones.add(regresar);

        imagen.setLayout(new GridLayout(1, 1));
        imagen.setPreferredSize(new Dimension(250, 250));
        imagen.add(miImagen);

        panelContainer.setLayout(new BoxLayout(panelContainer, BoxLayout.Y_AXIS));
        panelContainer.add(imagen);
        panelContainer.add(panelDatos);
        panelContainer.add(panelBotones);

        add(panelContainer);
    }

    private void acciones() {
        ingresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String contraseñaIngresada = new String(contrasenaEntrada.getPassword());
                if (contraseñaIngresada.equals(contraseñaCorrecta)) {
                    RegistrarProducto registrarProducto = new RegistrarProducto();
                    registrarProducto.setVisible(true);
                    ContrasenaAdmins.this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta. Inténtalo nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazLogin interfazLogin = new InterfazLogin();
                interfazLogin.setVisible(true);
                ContrasenaAdmins.this.setVisible(false);
            }
        });
    }
}


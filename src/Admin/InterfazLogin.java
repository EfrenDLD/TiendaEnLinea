package Admin;

import Operaciones.ContrasenaRepartidor;
import Mains.InterfazMain;
import Interfaz.MiImagen;

import javax.swing.*;
import java.awt.*;

public class InterfazLogin extends JFrame {
    private JPanel panelButton, panelContainer, panelTitulo1, imagen;
    private JButton botonAdmin, botonRepartidor,botonRegresar;
    private JLabel titulo1;
    private MiImagen miImagen;

    public InterfazLogin() {
        MiImagen miImagen = new MiImagen();
        this.miImagen = miImagen;
        initFrame();
        initControl();
        configFrame();
        setControl();
        configPanel();
        movimientos();
        add(panelContainer);
    }

    private void initFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(miImagen, BorderLayout.CENTER);
        setSize(460, 600);
        setVisible(true);
    }

    private void configFrame() {
        setTitle("Menu de Opciones");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(500, 500);
    }

    private void initControl() {
        panelButton = new JPanel();
        panelContainer = new JPanel();
        panelTitulo1 = new JPanel();
        imagen = new JPanel();

        titulo1 = new JLabel();
        botonAdmin = new JButton();
        botonRepartidor = new JButton();
        botonRegresar = new JButton();
    }

    private void setControl() {
        titulo1.setText("Registro");
        botonAdmin.setText("Administrador");
        botonRepartidor.setText("Repartidor");
        botonRegresar.setText("Regresar");
    }

    private void configPanel() {
        panelTitulo1.setLayout(new BoxLayout(panelTitulo1, BoxLayout.Y_AXIS));
        panelTitulo1.add(titulo1);

        imagen.setLayout(new GridLayout(1, 1));
        imagen.setPreferredSize(new Dimension(250, 250));
        imagen.add(miImagen);

        panelButton.setLayout(new GridLayout(3, 1));
        panelButton.setPreferredSize(new Dimension(100, 100));
        panelButton.add(botonAdmin);
        panelButton.add(botonRepartidor);
        panelButton.add(botonRegresar);

        panelContainer.setLayout(new BoxLayout(panelContainer, BoxLayout.Y_AXIS));
        panelContainer.add(panelTitulo1);
        panelContainer.add(imagen);
        panelContainer.add(panelButton);
        add(panelContainer);
    }

    private void movimientos() {
        botonAdmin.addActionListener(e -> {
            ContrasenaAdmins contrasenaAdmins = new ContrasenaAdmins();
            contrasenaAdmins.setVisible(true);
            this.setVisible(false);
        });
        botonRepartidor.addActionListener(e -> {
            ContrasenaRepartidor contrasenaRepartidor = new ContrasenaRepartidor();
            contrasenaRepartidor.setVisible(true);
            this.setVisible(false);
        });
        botonRegresar.addActionListener(e -> {
            InterfazMain interfazMain = new InterfazMain();
            interfazMain.setVisible(true);
            this.setVisible(false);
        });
    }
}


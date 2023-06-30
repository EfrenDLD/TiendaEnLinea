package Mains;

import Admin.InterfazLogin;
import Interfaz.CarritoCompras;
import Interfaz.MiImagen;
import Operaciones.ListarProducto;

import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;

public class InterfazMain extends JFrame{
    private JPanel panelContainer,panelBotones,imagen;
    private JButton botonLogin,botonCarrito,botonAgregar;
    private MiImagen miImagen;

    public InterfazMain(){
        MiImagen miImagen = new MiImagen();
        this.miImagen = miImagen;
        initFrame();
        configFrame();
        initControl();
        setControl();
        configPanel();
        movimientos();
    }

    private void initFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(miImagen, BorderLayout.CENTER);
        setSize(400,600);
        setVisible(true);

    }
    private void configFrame(){
        setTitle("Inicio");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(500, 500);
    }

    private void initControl(){
        panelContainer = new JPanel();
        panelBotones = new JPanel();
        imagen = new JPanel();

        botonCarrito = new JButton();
        botonAgregar = new JButton();
        botonLogin = new JButton();
    }

    private void setControl(){
        botonCarrito.setText("Ver carrito");
        botonAgregar.setText("Lista producto");
        botonLogin.setText("Login");
    }

    private void configPanel(){
        panelBotones.setLayout(new GridLayout(3,1));
        panelBotones.setPreferredSize(new Dimension(100, 100));
        panelBotones.add(botonCarrito);
        panelBotones.add(botonAgregar);
        panelBotones.add(botonLogin);

        imagen.setLayout(new GridLayout(1,1));
        imagen.setPreferredSize(new Dimension(250,250));
        imagen.add(miImagen);

        panelContainer.setLayout(new BoxLayout(panelContainer, BoxLayout.Y_AXIS));
        panelContainer.add(imagen);
        panelContainer.add(panelBotones);
        add(panelContainer);
    }

    private void movimientos() {
            botonLogin.addActionListener(e -> {
                InterfazLogin interfazLogin = new InterfazLogin();
                interfazLogin.setVisible(true);
                this.setVisible(false);
            });

            botonCarrito.addActionListener(e -> {
                CarritoCompras carritoCompras = new CarritoCompras();
                carritoCompras.setVisible(true);
                this.setVisible(false);
            });

        botonAgregar.addActionListener(e -> {
            ListarProducto listarProductos = new ListarProducto();
            listarProductos.setVisible(true);
            this.setVisible(false);

        });
    }
}
package Operaciones;
import Admin.InterfazLogin;
import Interfaz.CarritoCompras;
import Pojo.Usuario;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FormularioPago extends JFrame {
    private JPanel panelContainer, panelDatos, panel1, panel2, panelBotones;
    private JButton agregar, regresar;
    private JLabel vacio1, titulo, nombre, apellidoPaterno, apellidoMaterno, edad, direccion, telefono, ine;
    private JTextField nombreEntrada, apellidoPaternoEntrada, apellidoMaternoEntrada, edadEntrada, direccionEntrada, telefonoEntrada, ineEntrada;

    public static ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    public FormularioPago() {
        configFrame();
        initControl();
        setControl();
        configPanel();
        movimientos();
        acciones();
    }

    private void configFrame() {
        setTitle("Formulario de Pago");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(600, 400);
    }

    private void initControl() {
        panelContainer = new JPanel();
        panelBotones = new JPanel();
        panelDatos = new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();

        vacio1 = new JLabel(" ");
        titulo = new JLabel();
        nombre = new JLabel();
        apellidoPaterno = new JLabel();
        apellidoMaterno = new JLabel();
        edad = new JLabel();
        direccion = new JLabel();
        telefono = new JLabel();
        ine = new JLabel();

        nombreEntrada = new JTextField();
        apellidoPaternoEntrada = new JTextField();
        apellidoMaternoEntrada = new JTextField();
        edadEntrada = new JTextField();
        direccionEntrada = new JTextField();
        telefonoEntrada = new JTextField();
        ineEntrada = new JTextField();

        agregar = new JButton();
        regresar = new JButton();
    }

    private void setControl() {
        titulo.setText("FORMULARIO DE PAGO");

        nombre.setText("Nombre");
        apellidoPaterno.setText("Apellido Paterno");
        apellidoMaterno.setText("Apellido Materno");
        edad.setText("Edad");
        direccion.setText("Dirección");
        telefono.setText("Teléfono");
        ine.setText("INE");

        agregar.setText("Agregar usuario");
        regresar.setText("Regresar");
    }

    private void configPanel() {
        panel1.setLayout(new GridLayout(7, 1));
        panel1.add(nombre);
        panel1.add(apellidoPaterno);
        panel1.add(apellidoMaterno);
        panel1.add(edad);
        panel1.add(direccion);
        panel1.add(telefono);
        panel1.add(ine);

        panel2.setLayout(new GridLayout(7, 1));
        panel2.add(nombreEntrada);
        panel2.add(apellidoPaternoEntrada);
        panel2.add(apellidoMaternoEntrada);
        panel2.add(edadEntrada);
        panel2.add(direccionEntrada);
        panel2.add(telefonoEntrada);
        panel2.add(ineEntrada);

        panelDatos.setLayout(new GridLayout(1, 3));
        panelDatos.add(panel1);
        panelDatos.add(vacio1);
        panelDatos.add(panel2);

        panelBotones.setLayout(new FlowLayout());
        panelBotones.add(agregar);
        panelBotones.add(regresar);

        panelContainer.setLayout(new BoxLayout(panelContainer, BoxLayout.Y_AXIS));
        panelContainer.add(titulo);
        panelContainer.add(vacio1);
        panelContainer.add(panelDatos);
        panelContainer.add(panelBotones);

        add(panelContainer);
    }
    private void movimientos() {
        regresar.addActionListener(e -> {
            InterfazLogin interfazLogin = new InterfazLogin();
            interfazLogin.setVisible(true);
            this.setVisible(false);
        });
        agregar.addActionListener(e -> {
            String nombre = nombreEntrada.getText();
            String apellidoPaterno = apellidoPaternoEntrada.getText();
            String apellidoMaterno = apellidoMaternoEntrada.getText();
            String edad = edadEntrada.getText();
            String direccion = direccionEntrada.getText();
            String telefono = telefonoEntrada.getText();
            String ine = ineEntrada.getText();

            Usuario usuario = new Usuario(nombre, apellidoPaterno, apellidoMaterno, edad, direccion, telefono, ine);
            listaUsuarios.add(usuario);

            JOptionPane.showMessageDialog(null, "Usuario confirmado", "Información", JOptionPane.INFORMATION_MESSAGE);

            // Clear input fields
            nombreEntrada.setText("");
            apellidoPaternoEntrada.setText("");
            apellidoMaternoEntrada.setText("");
            edadEntrada.setText("");
            direccionEntrada.setText("");
            telefonoEntrada.setText("");
            ineEntrada.setText("");
        });
    }
    private void acciones() {
        agregar.addActionListener(e -> {
            RealizarPago realizarPago = new RealizarPago();
            realizarPago.setVisible(true);
            this.setVisible(false);
        });

        regresar.addActionListener(e -> {
            CarritoCompras carritoCompras = new CarritoCompras();
            carritoCompras.setVisible(true);
            this.setVisible(false);
        });
    }
}

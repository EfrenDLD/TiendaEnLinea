package Admin;

import Pojo.Producto;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RegistrarProducto extends JFrame {
    private JPanel panelContainer, panelDatos, panel1, panel2, panelBotones;
    private JButton agregar, regresar;
    private JLabel vacio1, titulo, nombre, cantidad, precio, departamento, descripcion;
    private JTextField nombreEntrada, cantidadEntrada, precioEntrada, descripcionEntrada;
    private JComboBox<String> departamentoComboBox;

    public static ArrayList<Producto> listaProductos = new ArrayList<>();
    public static final String[] listaDepartamentos = {"Abarrotes", "Lácteos", "Artículos de limpieza", "Embutidos", "Línea blanca"};

    public RegistrarProducto() {
        configFrame();
        initControl();
        setControl();
        configPanel();
        movimientos();
    }

    private void configFrame() {
        setTitle("Registro de producto");
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
        cantidad = new JLabel();
        precio = new JLabel();
        departamento = new JLabel();
        descripcion = new JLabel();

        nombreEntrada = new JTextField();
        cantidadEntrada = new JTextField();
        precioEntrada = new JTextField();
        descripcionEntrada = new JTextField();

        agregar = new JButton();
        regresar = new JButton();
        departamentoComboBox = new JComboBox<>(listaDepartamentos);
    }

    private void setControl() {
        titulo.setText("REGISTRAR NUEVO PRODUCTO");

        nombre.setText("Nombre del producto");
        cantidad.setText("Cantidad del producto");
        precio.setText("Precio del producto");
        departamento.setText("Departamento");
        descripcion.setText("Descripción");

        agregar.setText("Agregar producto");
        regresar.setText("Regresar");
    }

    private void configPanel() {
        panel1.setLayout(new GridLayout(6, 1));
        panel1.add(nombre);
        panel1.add(cantidad);
        panel1.add(precio);
        panel1.add(departamento);
        panel1.add(descripcion);

        panel2.setLayout(new GridLayout(6, 1));
        panel2.add(nombreEntrada);
        panel2.add(cantidadEntrada);
        panel2.add(precioEntrada);
        panel2.add(departamentoComboBox);
        panel2.add(descripcionEntrada);

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
            String cantidad = cantidadEntrada.getText();
            String precio = precioEntrada.getText();
            String departamento = (String) departamentoComboBox.getSelectedItem();
            String descripcion = descripcionEntrada.getText();

            // Validar que la cantidad y el precio sean enteros
            if (!isInteger(cantidad) || !isInteger(precio)) {
                JOptionPane.showMessageDialog(null, "La cantidad y el precio deben ser valores enteros", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Producto producto = new Producto(nombre, cantidad, precio, departamento, descripcion);
            listaProductos.add(producto);
            JOptionPane.showMessageDialog(null, "Producto agregado correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
            nombreEntrada.setText("");
            cantidadEntrada.setText("");
            precioEntrada.setText("");
            descripcionEntrada.setText("");
        });
    }

    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}


package Operaciones;

import Admin.RegistrarProducto;
import Interfaz.CarritoCompras;
import Mains.InterfazMain;
import Pojo.Producto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListarProducto extends JFrame {
    private JPanel panelContainer, panelLista, panelBotones;
    private JList<String> listaProductos;
    private JButton agregarCarrito, botonRegresar, mostrarCarrito;
    private CarritoCompras carrito;

    public ListarProducto() {
        configFrame();
        initControl();
        setControl();
        configPanel();
        movimientos();
        carrito = new CarritoCompras(); // Instancia de CarritoCompras
    }

    private void configFrame() {
        setTitle("Lista de Productos");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(600, 300);
    }

    private void initControl() {
        panelContainer = new JPanel();
        panelLista = new JPanel();
        panelBotones = new JPanel();

        listaProductos = new JList<>();
        agregarCarrito = new JButton("Agregar al carrito");
        botonRegresar = new JButton("Regresar");
        mostrarCarrito = new JButton("ver carrito");
    }

    private void setControl() {
        DefaultListModel<String> model = new DefaultListModel<>();
        for (Producto producto : RegistrarProducto.listaProductos) {
            model.addElement(producto.getNombre());
        }
        listaProductos.setModel(model);
    }

    private void configPanel() {
        panelLista.setLayout(new BorderLayout());
        panelLista.add(new JScrollPane(listaProductos), BorderLayout.CENTER);

        panelBotones.setLayout(new FlowLayout());
        panelBotones.add(agregarCarrito);
        panelBotones.add(botonRegresar);
        panelBotones.add(mostrarCarrito);

        panelContainer.setLayout(new BorderLayout());
        panelContainer.add(panelLista, BorderLayout.CENTER);
        panelContainer.add(panelBotones, BorderLayout.SOUTH);

        add(panelContainer);
    }

    private void movimientos() {
        agregarCarrito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = listaProductos.getSelectedIndex();
                if (selectedIndex != -1) {
                    Producto selectedProduct = RegistrarProducto.listaProductos.get(selectedIndex);
                    double price = Double.parseDouble(selectedProduct.getPrecio());
                    carrito.agregarProducto(selectedProduct);  // Utiliza la instancia de CarritoCompras
                    JOptionPane.showMessageDialog(null, "Producto agregado al carrito: " + selectedProduct.getNombre() +
                            "\nPrecio: $" + price, "Detalle de la compra", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un producto de la lista", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton verDetalles = new JButton("Ver detalles");
        verDetalles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = listaProductos.getSelectedIndex();
                if (selectedIndex != -1) {
                    Producto selectedProduct = RegistrarProducto.listaProductos.get(selectedIndex);
                    String details = "Detalles del producto:\n" +
                            "Nombre: " + selectedProduct.getNombre() + "\n" +
                            "Precio: $" + selectedProduct.getPrecio() + "\n" +
                            "Departamento: " + selectedProduct.getDepartamento() + "\n" +
                            "Descripción: " + selectedProduct.getDescripcion();
                    JOptionPane.showMessageDialog(null, details, "Detalles del producto", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un producto de la lista", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panelBotones.add(verDetalles);
        mostrarCarrito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carrito.setVisible(true);  // Utiliza la instancia de CarritoCompras
                setVisible(false);
            }
        });

        botonRegresar.addActionListener(e -> {
            InterfazMain interfazMain = new InterfazMain();
            interfazMain.setVisible(true);
            setVisible(false);
        });
    }

    public static void main(String[] args) {
        ListarProducto listarProducto = new ListarProducto();
        listarProducto.setVisible(true);
    }
}



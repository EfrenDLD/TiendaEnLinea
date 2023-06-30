package Interfaz;

import Mains.InterfazMain;
import Operaciones.FormularioPago;
import Pojo.Producto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CarritoCompras extends JFrame {
    private JPanel panelContainer, panelLista, panelBotones;
    private JList<String> listaProductos;
    private JButton eliminarPedido, pagar, regresar;
    private List<Producto> productosComprados;

    public CarritoCompras() {
        productosComprados = new ArrayList<>();
        configFrame();
        initControl();
        setControl();
        configPanel();
        movimientos();
    }

    private void configFrame() {
        setTitle("Carrito de Compras");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(400, 300);
    }

    private void initControl() {
        panelContainer = new JPanel();
        panelLista = new JPanel();
        panelBotones = new JPanel();

        listaProductos = new JList<>();
        eliminarPedido = new JButton();
        pagar = new JButton();
        regresar = new JButton();
        JLabel labelTotal = new JLabel("Total a pagar: $0.00");

    }

    private void setControl() {
        eliminarPedido.setText("Eliminar Pedido");
        pagar.setText("Paga");
        regresar.setText("Regresar");

        DefaultListModel<String> model = new DefaultListModel<>();
        for (Producto producto : productosComprados) {
            model.addElement(producto.getNombre());
        }
        listaProductos.setModel(model);
    }

    private void configPanel() {
        panelLista.setLayout(new BorderLayout());
        panelLista.add(new JScrollPane(listaProductos), BorderLayout.CENTER);

        panelBotones.setLayout(new FlowLayout());
        panelBotones.add(eliminarPedido);
        panelBotones.add(pagar);
        panelBotones.add(regresar);

        panelContainer.setLayout(new BorderLayout());
        panelContainer.add(panelLista, BorderLayout.CENTER);
        panelContainer.add(panelBotones, BorderLayout.SOUTH);

        add(panelContainer);
    }

    private void movimientos() {
        eliminarPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = listaProductos.getSelectedIndex();
                if (selectedIndex != -1) {
                    Producto selectedProduct = productosComprados.get(selectedIndex);
                    productosComprados.remove(selectedIndex);
                    JOptionPane.showMessageDialog(null, "Pedido eliminado: " + selectedProduct.getNombre(), "Eliminar Pedido", JOptionPane.INFORMATION_MESSAGE);
                    refreshList();
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un producto de la lista", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        pagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double total = 0;
                for (Producto producto : productosComprados) {
                    total += Double.parseDouble(producto.getPrecio());
                }
                FormularioPago formularioPago = new FormularioPago();
                formularioPago.setVisible(true);
                setVisible(false);
            }
        });

        regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazMain interfazMain = new InterfazMain();
                interfazMain.setVisible(true);
                setVisible(false);
            }
        });
    }
    private void refreshList() {
        DefaultListModel<String> model = (DefaultListModel<String>) listaProductos.getModel();
        model.clear();
        for (Producto producto : productosComprados) {
            model.addElement(producto.getNombre());
        }
    }
    public void agregarProducto(Producto producto) {
        productosComprados.add(producto);
        refreshList();
    }
}




package Operaciones;

import Interfaz.CarritoCompras;
import Mains.InterfazMain;
import Pojo.Producto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RealizarPago extends JFrame {
    private JPanel panelContainer, panelFormulario, panelBotones;
    private JLabel labelTotal, labelNumeroTarjeta, labelFechaVencimiento, labelCodigoSeguridad;
    private JTextField campoNumeroTarjeta, campoFechaVencimiento, campoCodigoSeguridad;
    private JButton confirmarPago, cancelarPago;
    private List<Producto> productosComprados;
    private double total;

    public RealizarPago() {
        configFrame();
        initControl();
        setControl();
        configPanel();
        movimientos();
        acciones();
    }

    public void setProductosComprados(List<Producto> productosComprados) {
        this.productosComprados = productosComprados;
        actualizarTotal();
    }

    public void setTotal(double total) {
        this.total = total;
        actualizarTotal();
    }

    private void actualizarTotal() {
        labelTotal.setText("Total a pagar: $" + total);
    }

    private void configFrame() {
        setTitle("Realizar Pago");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(500, 200);
    }

    private void initControl() {
        panelContainer = new JPanel();
        panelFormulario = new JPanel();
        panelBotones = new JPanel();

        labelTotal = new JLabel();
        labelNumeroTarjeta = new JLabel();
        labelFechaVencimiento = new JLabel();
        labelCodigoSeguridad = new JLabel();

        campoNumeroTarjeta = new JTextField(20);
        campoFechaVencimiento = new JTextField(6);
        campoCodigoSeguridad = new JTextField(3);

        confirmarPago = new JButton();
        cancelarPago = new JButton();
    }

    private void setControl() {
        labelNumeroTarjeta.setText("Número de tarjeta:");
        labelFechaVencimiento.setText("Fecha de vencimiento:");
        labelCodigoSeguridad.setText("Código de seguridad:");

        confirmarPago.setText("Confirmar Pago");
        cancelarPago.setText("Cancelar");
    }

    private void configPanel() {
        panelFormulario.setLayout(new GridLayout(3, 2));
        panelFormulario.add(labelNumeroTarjeta);
        panelFormulario.add(campoNumeroTarjeta);
        panelFormulario.add(labelFechaVencimiento);
        panelFormulario.add(campoFechaVencimiento);
        panelFormulario.add(labelCodigoSeguridad);
        panelFormulario.add(campoCodigoSeguridad);

        panelBotones.setLayout(new FlowLayout());
        panelBotones.add(confirmarPago);
        panelBotones.add(cancelarPago);

        panelContainer.setLayout(new BorderLayout());
        panelContainer.add(labelTotal, BorderLayout.NORTH);
        panelContainer.add(panelFormulario, BorderLayout.CENTER);
        panelContainer.add(panelBotones, BorderLayout.SOUTH);

        add(panelContainer);
    }

    private void movimientos() {
        confirmarPago.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeroTarjeta = campoNumeroTarjeta.getText();
                String fechaVencimiento = campoFechaVencimiento.getText();
                String codigoSeguridad = campoCodigoSeguridad.getText();

                // Validaciones de la tarjeta
                if (numeroTarjeta.isEmpty() || fechaVencimiento.isEmpty() || codigoSeguridad.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (numeroTarjeta.length() != 2 || !numeroTarjeta.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "Número de tarjeta inválido", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (codigoSeguridad.length() != 2 || !codigoSeguridad.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "Código de seguridad inválido", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Pago realizado con éxito", "Pago", JOptionPane.INFORMATION_MESSAGE);
                    restarTotal();
                    CarritoCompras carritoCompras = new CarritoCompras();
                    carritoCompras.setVisible(true);
                    setVisible(false);
                }
            }
        });

        cancelarPago.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazMain interfazMain = new InterfazMain();
                interfazMain.setVisible(true);
                setVisible(false);
            }
        });
    }
    private void restarTotal() {
        for (Producto producto : productosComprados) {
            double precio = Double.parseDouble(producto.getPrecio());
            total -= precio;
        }
    }
    private void acciones() {
        confirmarPago.addActionListener(e -> {
            CarritoCompras carritoCompras = new CarritoCompras();
            carritoCompras.setVisible(true);
            this.setVisible(false);
        });
    }
}



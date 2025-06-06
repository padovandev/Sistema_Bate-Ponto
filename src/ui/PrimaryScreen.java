package ui;

import dao.PointRecordDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrimaryScreen extends JFrame {
    private JTextField campoUsuarioId;
    private JButton botaoEntrada;
    private JButton botaoSaida;
    private JLabel statusLabel;

    public PrimaryScreen() {
        setTitle("Sistema de Bate-Ponto");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel labelUsuarioId = new JLabel("ID do Usuário:");
        labelUsuarioId.setBounds(20, 20, 100, 25);
        add(labelUsuarioId);

        campoUsuarioId = new JTextField();
        campoUsuarioId.setBounds(130, 20, 200, 25);
        add(campoUsuarioId);

        botaoEntrada = new JButton("Registrar Entrada");
        botaoEntrada.setBounds(20, 60, 150, 30);
        add(botaoEntrada);

        botaoSaida = new JButton("Registrar Saída");
        botaoSaida.setBounds(180, 60, 150, 30);
        add(botaoSaida);

        statusLabel = new JLabel("");
        statusLabel.setBounds(20, 110, 350, 25);
        add(statusLabel);

        PointRecordDAO dao = new PointRecordDAO();

        botaoEntrada.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int usuarioId = Integer.parseInt(campoUsuarioId.getText());
                    dao.registerEntry(usuarioId);
                    statusLabel.setText("Entrada registrada com sucesso.");
                } catch (Exception ex) {
                    statusLabel.setText("Erro ao registrar entrada: " + ex.getMessage());
                }
            }
        });

        botaoSaida.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int usuarioId = Integer.parseInt(campoUsuarioId.getText());
                    dao.registerExit(usuarioId);
                    statusLabel.setText("Saída registrada com sucesso.");
                } catch (Exception ex) {
                    statusLabel.setText("Erro ao registrar saída: " + ex.getMessage());
                }
            }
        });

        setVisible(true);
    }
}
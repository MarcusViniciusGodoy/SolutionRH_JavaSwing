package gui;

import javax.swing.*;

public class TelaResultado extends JFrame {
    private JLabel lblNome, lblAcrescimo, lblFinal;

    public TelaResultado(String nome, double acrescimo, double salarioFinal) {
        setTitle("Resultado");
        setSize(300, 200);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);

        lblNome = new JLabel("Nome:            " + nome);
        lblNome.setBounds(20, 20, 250, 25);
        add(lblNome);

        lblAcrescimo = new JLabel("Acréscimo de salário:   R$ " + String.format("%.2f", acrescimo));
        lblAcrescimo.setBounds(20, 60, 250, 25);
        add(lblAcrescimo);

        lblFinal = new JLabel("Salário final:                 R$ " + String.format("%.2f", salarioFinal));
        lblFinal.setBounds(20, 100, 250, 25);
        add(lblFinal);

        setVisible(true);
    }
}


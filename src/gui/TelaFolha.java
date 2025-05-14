package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import model.Folha;

public class TelaFolha extends JFrame implements ActionListener {
    private Dimension dFrame, dLabel, dTextField, dButton;
    private Label lblMatricula, lblNome, lblSalario, lblTipoContrato, lblGrupo;
    private TextField txtMatricula, txtNome, txtSalario;
    private CheckboxGroup grupoContrato, grupoTrabalho;
    private Checkbox cbHorista, cbMensalista, cbCritico, cbEspecial;
    private Button cmdCalcular;

    public TelaFolha() {
        dFrame = new Dimension(500, 250);
        dLabel = new Dimension(150, 20);
        dTextField = new Dimension(150, 20);
        dButton = new Dimension(150, 25);

        setSize(dFrame);
        setTitle("Folha de pagamento");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        lblMatricula = new Label("Matrícula do funcionário:");
        lblMatricula.setSize(dLabel);
        lblMatricula.setLocation(20, 30);
        add(lblMatricula);

        txtMatricula = new TextField();
        txtMatricula.setSize(dTextField);
        txtMatricula.setLocation(200, 30);
        add(txtMatricula);

        lblNome = new Label("Nome completo:");
        lblNome.setSize(dLabel);
        lblNome.setLocation(20, 60);
        add(lblNome);

        txtNome = new TextField();
        txtNome.setSize(dTextField);
        txtNome.setLocation(200, 60);
        add(txtNome);

        lblTipoContrato = new Label("Tipo de contrato:");
        lblTipoContrato.setSize(dLabel);
        lblTipoContrato.setLocation(20, 90);
        add(lblTipoContrato);

        grupoContrato = new CheckboxGroup();
        cbHorista = new Checkbox("Horista", false, grupoContrato);
        cbHorista.setBounds(200, 90, 60, 20);
        add(cbHorista);

        cbMensalista = new Checkbox("Mensalista", true, grupoContrato);
        cbMensalista.setBounds(310, 90, 80, 20);
        add(cbMensalista);

        lblSalario = new Label("Salário R$:");
        lblSalario.setSize(dLabel);
        lblSalario.setLocation(20, 120);
        add(lblSalario);

        txtSalario = new TextField();
        txtSalario.setSize(dTextField);
        txtSalario.setLocation(200, 120);
        add(txtSalario);

        lblGrupo = new Label("Grupo de trabalho:");
        lblGrupo.setSize(dLabel);
        lblGrupo.setLocation(20, 150);
        add(lblGrupo);

        grupoTrabalho = new CheckboxGroup();
        cbCritico = new Checkbox("Grupo Crítico", false, grupoTrabalho);
        cbCritico.setBounds(200, 150, 100, 20);
        add(cbCritico);

        cbEspecial = new Checkbox("Grupo Especial", false, grupoTrabalho);
        cbEspecial.setBounds(310, 150, 120, 20);
        add(cbEspecial);

        cmdCalcular = new Button("Calcular");
        cmdCalcular.setSize(dButton);
        cmdCalcular.setLocation(200, 180);
        cmdCalcular.addActionListener(this);
        add(cmdCalcular);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cmdCalcular) {
            String matricula = txtMatricula.getText().trim();
            String nome = txtNome.getText().trim();
            double salario = 0;

            try {
                salario = Double.parseDouble(txtSalario.getText().trim());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Digite um salário válido!");
                return;
            }

            String grupo = cbCritico.getState() ? "Crítico" : cbEspecial.getState() ? "Especial" : "";

            if (grupo.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Selecione um grupo de trabalho!");
                return;
            }

            Folha folha = new Folha(matricula, nome, salario, grupo);
            new TelaResultado(folha.getNome(), folha.getAcrescimo(), folha.getSalarioFinal());
        }
    }
}

package model;

public class Folha {

    private String matricula;
    private String nome;
    private double salarioBase;
    private String grupoTrabalho;
    private double acrescimo;
    private double salarioFinal;

    public Folha(String matricula, String nome, double salarioBase, String grupoTrabalho) {
        this.matricula = matricula;
        this.nome = nome;
        this.salarioBase = salarioBase;
        this.grupoTrabalho = grupoTrabalho;
        calcularAcrescimo();
    }

    private void calcularAcrescimo() {
        if ("Crítico".equals(grupoTrabalho)) {
            acrescimo = salarioBase * 0.10;
        } else if ("Especial".equals(grupoTrabalho)) {
            acrescimo = salarioBase * 0.13;
        } else {
            acrescimo = 0;
        }
        salarioFinal = salarioBase + acrescimo;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public double getAcrescimo() {
        return acrescimo;
    }

    public double getSalarioFinal() {
        return salarioFinal;
    }
}

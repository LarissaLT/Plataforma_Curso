package com.gerenciamento.curso.model;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;

@Embeddable
public class Nota {
    @JsonView({MostreQuemTemATag.TagCadastrarAv1.class, MostreQuemTemATag.TagBuscarNotaFinal.class})
    private double av1;
    @JsonView({MostreQuemTemATag.TagCadastrarAv2.class, MostreQuemTemATag.TagBuscarNotaFinal.class})
    private double av2;
    @JsonView(MostreQuemTemATag.TagBuscarNotaFinal.class)
    private double notaFinal;


    public double getAv1() {
        return av1;
    }

    public void setAv1(double av1) {
        this.av1 = av1;
    }

    public double getAv2() {
        return av2;
    }

    public void setAv2(double av2) {
        this.av2 = av2;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }
}

package task05.src.Model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Jogador extends Pessoa {
    private int tentativasRestantes;

    Scanner sc = new Scanner(System.in);


    public Jogador(String nome) {
        super(nome);
        this.tentativasRestantes = 6;
    }


    public int getTentativasRestantes() {
        return tentativasRestantes;
    }

    public void setTentativasRestantes(int tentativasRestantes) {
        this.tentativasRestantes = tentativasRestantes;
    }

}
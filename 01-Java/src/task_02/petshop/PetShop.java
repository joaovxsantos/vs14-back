package task_02.petshop;

public class PetShop {

    String[] nomesPets = new String [100];
    int quantidadePets = 0;


    String [] racasPets = new String[100];


    public void cadastrarPet (String nome, String tipo) {
        nomesPets[quantidadePets] = nome;
        racasPets[quantidadePets] = tipo;
        quantidadePets++;
        System.out.println("\nPet cadastrado com sucesso!");
    }

    public void exibirPet () {
        for(int i = 0; i < quantidadePets; i++) {
            System.out.println("Pet " + (i + 1) + " - " + nomesPets[i] + " / " + racasPets[i]);
        }
    }

    public void buscarPet(String nome) {
        boolean achouPet = false;


        for(int i = 0; i < quantidadePets; i++) {
            if (nomesPets[i].equals(nome)) {
                System.out.println("Pet " + " - " + nomesPets[i] + " - " + racasPets[i]);
                achouPet = true;
            }
        }

        if(!achouPet) {
            System.out.println("Pet não encontrado");
        }
    }
}

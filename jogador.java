package NavalBatalha;

import java.util.ArrayList;
import java.util.Scanner;

public class jogador {


    int jogadorScore;
    int idade;
    String nome = "", segundoNome = "", sobreNome = "";
    boolean spaceUsed;
    boolean validAT;
    boolean validDotCom;
    boolean validDotBR;
    int spaceAt;
    String email;
    int variosJogadores;
    Double Score;


    public jogador(String nome, int idade, String email) {

        aberturajogo();
        numeroDeJogadores();
        addArrayList();

        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }

    public void aberturajogo(){
        System.out.println("-------------------------------------------------");
        System.out.println("-----------------Batalha Naval-------------------");
        System.out.println("-------------------------------------------------");
    }

    public void addArrayList() {
        int i=0;
        while(i < variosJogadores) {
            System.out.println("digite jogador " + (i+1) + " detalhes");
            nome();
            idade();
            email();

            ArrayList<jogador> VariosJogadores = new ArrayList<jogador>();
            i++;
        }
    }

    public void nome() {
        boolean valido = false;

        do {
            Scanner nomeCompleto = new Scanner(System.in);
            System.out.println("Qual seu nome Completo?");
            nome = nomeCompleto.nextLine();
            nome = nome.trim();
            spaceUsed = nome.contains(" ");

            if (spaceUsed) {
                valido = true;
                spaceAt = nome.indexOf(' ');
                segundoNome = nome.substring(0,spaceAt);
                sobreNome = nome.substring(spaceAt+1,nome.length());


            }else {
                valido = false;

                System.out.println("Favor,Digite seu nome completo.");
            }

        }while(!valido);

    }

    public int idade() {
        boolean valido = false;

        do {
            Scanner idadeInput = new Scanner(System.in);
            System.out.println("Qual sua Idade?");
            idade = idadeInput.nextInt();
            if(idade >= 12 && idade <= 100) {
                valido = true;
            }
            else {
                valido = false;
                System.out.println("Desculpe, voce precisa ter entre 12 e 100 para jogar.");
            }
        }
        while(valido == false);

        return idade;
    }


    public String email() {
        boolean valido = false;

        do {
            Scanner emailInput = new Scanner(System.in);
            System.out.println("Qual seu Email email?");
            email = emailInput.nextLine();

            validAT = email.contains("@");
            validDotCom = email.contains(".com");
            validDotBR = email.contains(".br");

            if(validAT && (validDotCom || validDotBR)) {
                valido = true;
            }
            else {
                valido = false;
                System.out.println("Favor, digite seu Email.");
            }
        }
        while(valido == false);
        return email;
    }

    public int jogadorScore() {

        Score = Tiro() - Erro();
        return jogadorScore;
    }

    public int Tiro() {
        int tiros = 0;
        int Tiro = 0;
        tiros++;
        return Tiro;
    }
    public double Erro() {
        int Erros = 0;
        int Erro = 0;
        Erros++;
        return Erro;
    }



    public void numeroDeJogadores(){
        System.out.println("\n" + "Quantos jogadores vao jogar? (Min.1 - Max.4)");
        Scanner jogadores = new Scanner(System.in);
        variosJogadores = jogadores.nextInt();
        if(variosJogadores <= 1 && variosJogadores >= 4) {

            System.out.println("Favor, Digite numero Valido.");
            numeroDeJogadores();
        }
    }
}
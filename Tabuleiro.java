package NavalBatalha;

import java.io.BufferedReader;
import java.util.Random;
import java.util.Scanner;

public class Tabuleiro {

    int largura, altura;
    int quantidadeBarcos;
    int tiro;
    int[] barco = new int[400];

    public Tabuleiro(int coluna, int linha) {
        this.largura = coluna;
        this.altura = linha;

        AreaJogo();
        mostraTabuleiro();
        barcos();
        jogada();
        verificaAcerto();
    }

    public void AreaJogo() {

        boolean valido = false;

        try {
            do {
                System.out.println("Digite o numero de linhas entre 3 e 20");
                Scanner coluna = new Scanner(System.in);
                largura = coluna.nextInt();
                if (largura >= 3 && largura <= 20) {
                    valido = true;
                } else {
                    valido = false;
                    System.out.println("\n" + "Por favor insira um numero valido: min.3, max.20");
                }
            }
            while (valido == false);

            do {
                System.out.println("\n" + "Enter o numero de colunas entre 3 e 20");
                Scanner linha = new Scanner(System.in);
                altura = linha.nextInt();
                if (altura >= 3 && altura <= 20) {
                    valido = true;
                } else {
                    valido = false;
                    System.out.println("Por favor insira um numero valido: min.3, max.20");
                }
            }
            while (valido == false);
        } catch (Exception e) {
            System.out.println("Numero Invalido " + e);
        }
    }

    public void mostraTabuleiro() {
        int m = 0;
        System.out.println("\n" + "Esses números representam as posicoes no quadro: " + "\n");

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {
                System.out.print(m + "\t");
                barco[m]=m;
                m++;
            }
            System.out.println();
        }

    }


    public void barcos(){
        int posicaoBarcoSorteado;
        quantidadeBarcos = (altura*largura)/3;
        Random sorteio = new Random();
        for (int c = 0; c < quantidadeBarcos; c++) {
            //System.out.println(c);
            posicaoBarcoSorteado = (sorteio.nextInt((altura*largura)));
            barco[posicaoBarcoSorteado]= 500;
           // System.out.println(posicaoBarcoSorteado);
        }
    }
    public void mostraTabuleiroAlterado() {
        int m = 0;
        System.out.println("\n" + "Esses numeros representam as posicoes no quadro: ");
        System.out.println("A = Acerto || E = Errro"+"\n");

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {
                if(barco[m]==500){
                    System.out.print(m + "\t");
                    m++;
                }else if(barco[m]== -1) {
                    System.out.print("A" + "\t");
                    m++;
                }else if(barco[m]== -2) {
                    System.out.print("E" + "\t");
                    m++;
                }else{
                    System.out.print(barco[m] + "\t");
                    m++;
                }

            }
            System.out.println();
        }

    }

    public void jogada(){
        System.out.println("digite uma posicao do tabuleiro");
        Scanner posicaoTabuleiro = new Scanner(System.in);
        tiro = posicaoTabuleiro.nextInt();
        if((barco[tiro] == -1)|| (barco[tiro] == -2)){
            System.out.println("Posicao ja foi jogada");
            jogada();
        }
        verificaAcerto();

    }

    public void verificaAcerto(){
            if(barco[tiro] == 500){
                System.out.println("Legal, Voce Acertou");
                barco[tiro] = -1;
                quantidadeBarcos--;
            }else{
                System.out.println("Desculpe, voce Errou");
                barco[tiro] = -2;
            }
        verificaQuantidadeRestandeBaarcos();
    }
    public void verificaQuantidadeRestandeBaarcos(){
        if(quantidadeBarcos>0){
            mostraTabuleiroAlterado();
            jogada();
        }
        if(quantidadeBarcos==0){
            mostraTabuleiroAlterado();
            System.out.println("jogo Finalizado");

        }
    }


}



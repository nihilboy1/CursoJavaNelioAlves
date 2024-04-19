package application;

import entities.Account;
import entities.BusinessAccount;

public class Program{
    public static void main(String[] args){
        Account account1 = new Account(1001, "Sam", 1.500);
        BusinessAccount businessAccount1 = new BusinessAccount(1001, "Sam", 1.500, 10000);
        // UPCASTING - Instanciando os dados de uma SUBCLASSE numa variavel do tipo da SUPERCLASSE
        Account account2 = businessAccount1;
        // não dá erro, pois a SUBCLASSE -É- a SUPERCLASSE com mais responsabilidades
        Account account3 = new BusinessAccount(1002, "Samu", 1.600, 20000);
        // e até instanciar diretamente eu também posso,
        // pois a superclasse comporta os atributos da subclasse sem problemas.

        /*
        pensa se você tiver uns 20 tipos de animais (gato, cachorro, vaca, porco, elefante, galinha, etc.) e quiser imprimir na tela o atributo "nome" de cada um deles.
        Você pode fazer uma lista de animais e colocar ela em um laço de repetição, mas para isso precisaria utilizar o Upcasting
        porque se você criar uma lista do tipo Porco você só vai poder colocar objetos do tipo Porco nela.
        Agora com o Upcasting basta você criar uma lista do tipo Animal que ela vai poder conter gato, cachorro, vaca, etc.
        */

        // -----------------------

        // DOWNCASTING - Instanciando os dados de uma SUPERCLASSE numa variavel que referencia uma SUBCLASSE
        BusinessAccount account4 = (BusinessAccount) account2;
        account4.loan(100.00);
        // aqui eu tenho que fazer o cast a partir de uma SUPERCLASSE que ja tenha sido alvo de um UPCASTING de uma
        // subclasse do tipo desejado, se não, da exceção
        // Um jeito mais seguro de fazer o DOWNCASTING é testando se a variavel à ser 'castada' é uma instancia da
        // classe alvo
        if(account2 instanceof BusinessAccount){
            BusinessAccount account5 = (BusinessAccount) account2;
        }
    }
}
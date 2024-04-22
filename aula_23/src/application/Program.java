package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program{
    public static void main(String[] args){
        Account acc1 = new Account(1100, "Alex", 1000.00);
        acc1.withdraw(200);
        System.out.println(acc1.getBalance());

        SavingsAccount acc2 = new SavingsAccount(1110, "Alexander", 1000.00, 0.01);
        acc2.withdraw(200);
        System.out.println(acc2.getBalance());

        BusinessAccount acc3 = new BusinessAccount(1101, "Alexis", 1000.00, 5000);
        acc3.withdraw(200);
        System.out.println(acc3.getBalance());
    }

    public void upAndDowncasting(){
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

    public void aboutFinal(){
        /*
        No Java, a palavra-chave `final` é usada para indicar que um elemento do código não pode ser modificado depois de ser definido. Ela pode ser aplicada a variáveis, métodos e classes, e cada uso tem um significado específico.

        ### Variáveis `final`:
        Quando uma variável é declarada como `final`, seu valor não pode ser alterado após ser inicializado. Isso significa que, uma vez que você atribuiu um valor a uma variável `final`, ela sempre manterá esse valor:
        ```java
        final int x = 10;  // 'x' é uma variável final.
        x = 20; // Isso causará um erro de compilação, pois 'x' já foi inicializado.
        ```
        Isso é útil para criar constantes no seu código, permitindo que valores que não devem ser alterados sejam claramente marcados.

        ### Métodos `final`:
        Um método declarado como `final` não pode ser sobrescrito por subclasses. Isso pode ser útil para garantir que o comportamento de um método específico permaneça consistente em toda a hierarquia de classes:
        ```java
        class Animal {
        final void emitirSom() {
        System.out.println("Som de animal");
        }
        }
        class Cachorro extends Animal {
        // Não é possível sobrescrever o método emitirSom() aqui, pois é final na classe Animal.
        }
        ```

        ### Classes `final`:
        Quando uma classe é declarada como `final`, ela não pode ser estendida por nenhuma outra classe. Isso é útil para garantir que a implementação da classe permaneça inalterada e também pode ser usado por razões de segurança ou design:
        ```java
        final class Pessoa {
        // Não pode ser estendida por outras classes.
        }
        // Isso causará um erro de compilação, pois a classe Pessoa é final.
        // class Estudante extends Pessoa { }
        ```
        O uso de `final` pode ajudar a manter um código mais seguro e previsível, uma vez que impede alterações não intencionais nos elementos que você quer manter imutáveis. No entanto, é importante usá-lo com moderação e apenas quando necessário para evitar restrições desnecessárias no design do seu código.
        */

    }
}
package application;

public class Program{
    public static void main(String[] args){
        // as variaveis abaixo são do tipo REFERENCIA na STACK, com valor interno NULL
        String a, b;
        /* a variavel "a" agora recebe a localização do objeto resultante da instanciação da classe
        String que está na HEAP */
        b = new String("VAALOR");
        a = new String("VALOR");
        // a variavel "b" agora também recebe o mesmo "ponteiro/localizção" que a, apontando para o mesmo local da
        // HEAP. E agora, o objeto b, será limpado do heap pelo garbage collector, pois nenhuma variavel mais aponta
        // para ele
        b = a;
        System.out.println(b);

        /* --------------- */

        // variavel do tipo VALOR. "x" está diretamente guardando o valor atribuido a ele numa caixa da STACK
        int x = 1;
        // aqui "z", que também é uma caixa na STACK está recebendo uma cópia do valor que "x" está guardando
        int z = x;
    }
}
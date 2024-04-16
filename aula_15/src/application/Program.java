package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program{
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // a List é uma interface. Não da pra ser instanciada. Preciso instanciar uma classe que implementa ela.
        List<String> list = new ArrayList<>();

        // adicionando 2 valores ao final da lista
        list.add("Alex");
        list.add("Anna");

        // mostrar o length da lista
        System.out.println(list.size());

        // for each
        for(String item : list){
            System.out.println(list);
        }

        // zerando a lista
        list.remove("Alex");
        list.remove(0);

        // adicionando mais valores
        list.add("Mario");
        list.add("George");
        for(String item : list){
            System.out.println(list);
        }

        // remoção condicional. remove da lista se a condição for TRUE
        list.removeIf(x -> x.charAt(x.length() -1) == 'o');
        for(String item : list){
            System.out.println(list);
        }
        list.add("Julio");
        list.add("Marcio");
        list.add("Klark");
        list.add("Jake");
        list.add("Bob");

        // pegando o index
        System.out.println(list.indexOf("Julia"));

        // filtro. passa para a listaFiltrada se a condição for TRUE
        List<String> filteredList =
                list.stream().filter(item -> item.charAt(item.length() -1 ) != 'o' ).toList();
        sc.close();
        for(String item: filteredList){
            System.out.println(item);
        }


        // primeira aparição de uma determinada condição
        String name = filteredList.stream().filter(item -> item.charAt(0) == 'K').findFirst().orElse(null);
        System.out.println(name);
    }
}
package application;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Scanner;

public class Program{
    public static void main(String[] args){

    }

    public static void valueToDate(){
        DateTimeFormatter customFormat1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter customFormat2 = DateTimeFormatter.ofPattern("dd/MM/yyyy;HH:mm");

        // data local, sem fuso nem horas
        LocalDate now1 = LocalDate.now();
        // data e hora locais, sem fuso
        LocalDateTime now2 = LocalDateTime.now();
        // data e hora globais, com fuso de londres
        Instant now3 = Instant.now();

        LocalDate dateTime1 = LocalDate.parse("2022-07-20");
        LocalDateTime dateTime2 = LocalDateTime.parse("2022-07-20T22:30:26");
        Instant dateTime3 = Instant.parse("2022-07-20T22:30:26Z");
        Instant dateTime4 = Instant.parse("2022-07-20T22:30:26-03:00");
        LocalDate dateTime5 = LocalDate.parse("20/07/2022", customFormat1);
        LocalDateTime dateTime6 = LocalDateTime.parse("20/07/2022;01:30", customFormat2);
        LocalDate  dateTime7 = LocalDate.of(2024,7,18);
        LocalDateTime dateTime8 = LocalDateTime.of(2024,7,18, 22, 20);

        System.out.println(now1);
        System.out.println(now2);
        System.out.println(now3);
        System.out.println(dateTime1);
        System.out.println(dateTime2);
        System.out.println(dateTime3);
        System.out.println(dateTime4);
        System.out.println(dateTime5);
        System.out.println(dateTime6);
        System.out.println(dateTime7);
        System.out.println(dateTime8);
    }

     public static void dateToValue(){
         LocalDate dateTime1 = LocalDate.parse("2022-07-20");
         Instant dateTime2 = Instant.parse("2022-07-20T02:30:26Z");


         DateTimeFormatter customFormat1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
         DateTimeFormatter customFormat2 = DateTimeFormatter.ofPattern("dd/MM/yyyy | HH:mm")
                 .withZone(ZoneId.systemDefault());

         System.out.println(dateTime1.format(customFormat1));
         System.out.println(customFormat2.format(dateTime2));


     }

     public static  void dateToDate(){
         LocalDate dateTime1 = LocalDate.parse("2022-07-20");
         Instant dateTime2 = Instant.parse("2022-07-20T02:30:26Z");

         LocalDate dateFromInstantBR = LocalDate.ofInstant(dateTime2, ZoneId.systemDefault());
         LocalDate dateFromInstantPT = LocalDate.ofInstant(dateTime2, ZoneId.of("Portugal"));
         LocalDateTime dateTimeFromInstantPT = LocalDateTime.ofInstant(dateTime2, ZoneId.of("Portugal"));



         System.out.println(dateFromInstantBR);
         System.out.println(dateFromInstantPT);
         System.out.println(dateTimeFromInstantPT);
         System.out.println(dateTime1.getDayOfMonth());


     }

     public static void calcDate(){
         LocalDate dateTime1 = LocalDate.parse("2022-07-20");
         LocalDateTime dateTime2 = LocalDateTime.parse("2022-07-20T22:30:26");
         Instant dateTime3 = Instant.parse("2022-07-20T22:30:26Z");


         LocalDate pastWeekDateTime1 = dateTime1.minusWeeks(1);
         LocalDate nextWeekDateTime1 = dateTime1.plusWeeks(1);
         LocalDateTime nextHourDateTime2 = dateTime2.plusHours(1);
         Instant pastHourDateTime3 = dateTime3.minus(7, ChronoUnit.HOURS);

         Duration result = Duration.between(nextHourDateTime2, dateTime2);

         System.out.println(pastWeekDateTime1);
         System.out.println(nextWeekDateTime1);
         System.out.println(nextHourDateTime2);
         System.out.println(pastHourDateTime3);
         System.out.println(result);

     }
}
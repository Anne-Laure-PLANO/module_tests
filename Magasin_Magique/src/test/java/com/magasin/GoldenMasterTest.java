package com.magasin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GoldenMasterTest {

    private Item[] items;


    // création d'une liste d'ensemble de cas possibles à tester
    @BeforeEach
    void setUp() {
        items = new Item[]{
                (new Item("Comté", 10, 10)),
                (new Item("Normal", 30, 50)),
                (new Item("Kryptonite", 100, 80)),
                (new Item("Pass VIP Concert", 20, 25)),
                (new Item("Pouvoirs magiques", 50, 50)),

                //La date de péremption est passée, le produit se dégrade 2fois plus vite
                (new Item("Comté", -1,3)),
                (new Item("Normal",-1,22)),
                (new Item("Kryptonite",-1,80)),
                (new Item("Pass VIP Concert",0,12)),
                (new Item("Pouvoirs magiques",-1,22)),

                //la qualité du produit ne peux ne pas être en négative
                (new Item("Comté",1,0)),
                (new Item("Normal",30,0)),
                (new Item("Kryptonite",100,0)),
                (new Item("Pass VIP Concert",4,0)),
                (new Item("Pouvoirs magiques",25,0)),

                //le produit comté augmente sa qualité plus le temps passe
                (new Item("Comté",30,50)),


                (new Item("Pouvoirs magiques", 50, 50)),


                //la qualité d'un produit n'est jamais plus grande que 50
                new Item("Comté", 20, 50),
                new Item("Pass VIP Concert", 15, 50),
                new Item("Pass VIP Concert", 10, 50),
                new Item("Pass VIP Concert", 5, 50),

                // la kryptonite ne perd jamais en qualité
                new Item("Kryptonite", 0, 80),

                // le pass VIP augmente en qualité : +2 quand sellin <10 ; +3 quand sellin <5 ; 0 quand sellin =0
                new Item("Pass VIP Concert", 11, 25),
                new Item("Pass VIP Concert", 10, 25),
                new Item("Pass VIP Concert", 6, 25),
                new Item("Pass VIP Concert", 5, 25),
                new Item("Pass VIP Concert", 1, 25),
                new Item("Pass VIP Concert", 0, 25),

                // pouvoir magiques : qualité se dégrade 2 fois plus vite
                new Item("Pouvoirs magiques", 10, 25),
                new Item("Pouvoirs magiques", 1, 25),
                new Item("Pouvoirs magiques", 0, 25),


        };
    }


    @Test
    void goldenMaster() throws IOException {
        Magasin market = new Magasin(items);
        market.updateQuality();

        StringBuilder output = new StringBuilder();
        for (Item item : items) {
            System.out.println(item.toString());
            output.append(item.toString()).append("\n");
        }
        saveOutput(output.toString());
    }

    private static void saveOutput(String output) throws IOException {
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

        String filePath = "src/test/resources/golden_master_" + timestamp + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(output);
            writer.newLine();
        }
    }


}

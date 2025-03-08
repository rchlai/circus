package circus;

import java.util.ArrayList;
import java.util.Arrays;

import circus.animal.Animal;
import circus.animal.Duck;
import circus.animal.Parrot;
import circus.stuff.Cage;
import circus.stuff.Cannon;
import circus.stuff.Equipment;
import circus.stuff.Ladder;

public class Circus {
    private static Animal[] animals = {
            new Duck(),
            new Parrot()
    };

    private static Equipment[] equipments = {
            new Ladder(50),
            new Cannon(5),
            new Cannon(100)
    };

    private static void makeAnimalsTalk() {
        for (Animal a : animals) {
            System.out.println(a);
            System.out.println(a.speak());
        }
   }

    private static int calculateValue(Asset[] equipments) {
        int total = 0;
        for (Asset asset : equipments) {
            if (asset.getValue() <= 5) {
                System.out.println("Ignoring low value item: " + asset.getValue());
                continue;
            }
            total += asset.getValue();
            System.out.println("Adding item value: " + asset.getValue());
        }
        return total;
    }

    public static void main(String[] args) {
        makeAnimalsTalk();
        System.out.println("Total value of equipments " + calculateValue(equipments));

        ArrayList<Animal> animalArrayList = new ArrayList<>(Arrays.asList(animals));

        Parrot perry = new Parrot();
        animalArrayList.add(perry);
        Duck andy = new Duck();
        animalArrayList.add(andy);

        // substitutability allows to add specific animals to array list
        printAnimals(animalArrayList);

        System.out.println("Size of array list: " + animalArrayList.size());
        System.out.println("Perry is in position: " + animalArrayList.indexOf(perry));

        animalArrayList.sort(Animal.animalComparator);
        printAnimals(animalArrayList);

        Cage<Duck> duckCage = new Cage<>();
        Duck duck = new Duck();
        duckCage.lockUp(duck);
        Cage<Parrot> parrotCage = new Cage<>();
        Parrot parrot = new Parrot();
        parrotCage.lockUp(parrot);

        ArrayList<Cage> cages = new ArrayList<>();
        cages.add(duckCage);
        cages.add(parrotCage);
        for (Cage c: cages) {
            c.release();
        }
    }

    private static void printAnimals(ArrayList<Animal> animalArrayList) {
        for (Animal a: animalArrayList) {
            System.out.println(a);
        }
    }
}

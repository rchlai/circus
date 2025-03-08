package circus.animal;

import java.util.Comparator;

import circus.Asset;

public abstract class Animal implements Asset {
    public String name;

    public abstract String speak();

    public static Comparator<Animal> animalComparator = new Comparator<Animal>() {
        @Override
        public int compare(Animal a1, Animal a2) {
            return a1.name.compareToIgnoreCase(a2.name);
        }
    };
}

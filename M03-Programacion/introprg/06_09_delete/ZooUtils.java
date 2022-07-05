import java.util.List;
public class ZooUtils {
    public static void mostraCategories(List<Categoria> categories) {
        if (categories.isEmpty()) {
            System.out.println("Cap categoria");
        }
        else {
            System.out.println("Nombre de categories: " + categories.size());
            for (Categoria categoria : categories) {
                System.out.println("\t"+categoria);
            }
        }
    }
    public static void mostraAnimals(List<Animal> animals) {
        if (animals.isEmpty()) {
            System.out.println("Cap animal");
        }
        else {
            System.out.println("Nombre d'animals: " + animals.size());
            for (Animal animal : animals) {
                System.out.println("\t"+animal);
            }
        }
    }
}

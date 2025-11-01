import java.util.Scanner;

/**
 * Programme qui calcule la somme de plusieurs valeurs saisies par l'utilisateur
 */
public class CalculSomme {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Programme de Calcul de Somme ===");
        System.out.print("Combien de valeurs voulez-vous saisir ? ");
        
        int nombreValeurs = scanner.nextInt();
        
        if (nombreValeurs <= 0) {
            System.out.println("Le nombre de valeurs doit être positif.");
            scanner.close();
            return;
        }
        
        double somme = 0;
        
        System.out.println("\nVeuillez saisir les " + nombreValeurs + " valeurs :");
        
        for (int i = 1; i <= nombreValeurs; i++) {
            System.out.print("Valeur " + i + " : ");
            double valeur = scanner.nextDouble();
            somme += valeur;
        }
        
        System.out.println("\n=== Résultat ===");
        System.out.println("La somme des " + nombreValeurs + " valeurs est : " + somme);
        
        scanner.close();
    }
}

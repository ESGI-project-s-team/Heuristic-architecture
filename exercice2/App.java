public class App {

    // calcule le prix payé par l'utilisateur dans le restaurant, en fonction de type de
    // repas qu'il prend (assiette ou sandwich), de la taille de la boisson (petit, moyen, grand), du dessert et
    // de son type (normal ou special) et si il prend un café ou pas (yes ou no).
    // les prix sont fixes pour chaque type de chose mais des réductions peuvent s'appliquer
    // si cela rentre dans une formule!
    public int Compute(String type, String name, String beverage, String size, String dessert, String dsize, String coffee) {
        // prix total à payer pour le client
        int total = 0;
        // le type ne peut être vide car le client doit déclarer au moins un repas
        if (type == null || name == null || type.isEmpty() || name.isEmpty()) return -1;
        // si le client prends un plat en assiette
        if (type.equals("assiette")) {
            total += 15;
            // ainsi qu'une boisson de taille:
            if (size == "petit") {
                total += 2;
                // dans ce cas, on applique la formule standard
                if (dsize.equals("normal")) {
                    // pas de formule
                    // on ajoute le prix du dessert normal
                    total += 2;
                } else {
                    // sinon on rajoute le prix du dessert special
                    total += 4;
                }
                // si on prends moyen
            } else if (size=="moyen") {
                total += 3;
                // dans ce cas, on applique la formule standard
                if (dsize.equals("normal")) {
                    // j'affiche la formule appliquée
                    System.out.print("Prix Formule Standard appliquée ");
                    // le prix de la formule est donc 18
                    total = 18;
                } else {
                    // sinon on rajoute le prix du dessert special
                    total += 4;
                }
            } else if (size=="grand") {
                total += 4;
                // dans ce cas, on applique la formule standard
                if (dsize.equals("normal")) {
                    // pas de formule
                    // on ajoute le prix du dessert normal
                    total += 2;
                } else {
                    // dans ce cas on a la fomule max
                    System.out.print("Prix Formule Max appliquée ");
                    total = 21;
                }
            }
        }
        // mode sandwich
        else {
            total += 10;
            // ainsi qu'une boisson de taille:
            if (size == "petit") {
                total += 2;
                // dans ce cas, on applique la formule standard
                if (dsize.equals("normal")) {
                    // pas de formule
                    // on ajoute le prix du dessert normal
                    total += 2;
                } else {
                    // sinon on rajoute le prix du dessert special
                    total += 4;
                }
                // si on prends moyen
            } else if (size=="moyen") {
                total += 3;
                // dans ce cas, on applique la formule standard
                if (dsize.equals("normal")) {
                    // j'affiche la formule appliquée
                    System.out.print("Prix Formule Standard appliquée ");
                    // le prix de la formule est donc 13
                    total = 13;
                } else {
                    // sinon on rajoute le prix du dessert special
                    total += 4;
                }
            } else if (size=="grand") {
                total += 4;
                // dans ce cas, on applique la formule standard
                if (dsize.equals("normal")) {
                    // pas de formule
                    // on ajoute le prix du dessert normal
                    total += 2;
                } else {
                    // dans ce cas on a la fomule max
                    System.out.print("Prix Formule Max appliquée ");
                    total = 16;
                }
            }
        }
        if (type.equals("assiette") && size.equals("moyen") && dsize.equals("normal") && coffee.equals("yes")) {
            System.out.print(" avec café offert!");
        } else {
            // Assume coffee costs 1 unit, adding to the total only if coffee is not included
            if (!coffee.equals("yes")) {
                total += 1;
            }
        }
        return total;
    }
}
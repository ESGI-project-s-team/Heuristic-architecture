public class App {

    // Constants for pricing
    private static final int ASSIETTE_PRICE = 15;
    private static final int SANDWICH_PRICE = 10;
    private static final int SMALL_DRINK_PRICE = 2;
    private static final int MEDIUM_DRINK_PRICE = 3;
    private static final int LARGE_DRINK_PRICE = 4;
    private static final int NORMAL_DESSERT_PRICE = 2;
    private static final int SPECIAL_DESSERT_PRICE = 4;
    private static final int COFFEE_PRICE = 1;
    private static final int STANDARD_FORMULA_PRICE_ASSIETTE = 18;
    private static final int MAX_FORMULA_PRICE_ASSIETTE = 21;
    private static final int STANDARD_FORMULA_PRICE_SANDWICH = 13;
    private static final int MAX_FORMULA_PRICE_SANDWICH = 16;

    enum MealType {
        ASSIETTE, SANDWICH
    }

    enum DrinkSize {
        PETIT, MOYEN, GRAND
    }

    enum DessertType {
        NORMAL, SPECIAL
    }

    public int compute(String type, String name, String size, String dessert, String coffee) {
        if (type == null || name == null || type.isEmpty() || name.isEmpty()) {
            return -1;
        }

        MealType mealType;
        DrinkSize drinkSize;
        DessertType dessertType;

        try {
            mealType = MealType.valueOf(type.toUpperCase());
            drinkSize = DrinkSize.valueOf(size.toUpperCase());
            dessertType = DessertType.valueOf(dessert.toUpperCase());
        } catch (IllegalArgumentException e) {
            return -1;
        }

        int total = calculateBasePrice(mealType);
        total += calculateDrinkPrice(drinkSize);
        total = applyFormula(total, mealType, drinkSize, dessertType);

        if (!"yes".equalsIgnoreCase(coffee)) {
            total += COFFEE_PRICE;
        } else if (mealType == MealType.ASSIETTE && drinkSize == DrinkSize.MOYEN && dessertType == DessertType.NORMAL) {
            System.out.print(" avec café offert!");
        }

        return total;
    }

    private int calculateBasePrice(MealType type) {
        switch (type) {
            case ASSIETTE:
                return ASSIETTE_PRICE;
            case SANDWICH:
                return SANDWICH_PRICE;
            default:
                return 0;
        }
    }

    private int calculateDrinkPrice(DrinkSize size) {
        switch (size) {
            case PETIT:
                return SMALL_DRINK_PRICE;
            case MOYEN:
                return MEDIUM_DRINK_PRICE;
            case GRAND:
                return LARGE_DRINK_PRICE;
            default:
                return 0;
        }
    }

    private int applyFormula(int total, MealType mealType, DrinkSize drinkSize, DessertType dessertType) {
        switch (mealType) {
            case ASSIETTE:
                return applyAssietteFormula(total, drinkSize, dessertType);
            case SANDWICH:
                return applySandwichFormula(total, drinkSize, dessertType);
            default:
                return total;
        }
    }

    private int applyAssietteFormula(int total, DrinkSize drinkSize, DessertType dessertType) {
        switch (drinkSize) {
            case MOYEN:
                if (dessertType == DessertType.NORMAL) {
                    System.out.print("Prix Formule Standard appliquée ");
                    return STANDARD_FORMULA_PRICE_ASSIETTE;
                }
                break;
            case GRAND:
                if (dessertType == DessertType.SPECIAL) {
                    System.out.print("Prix Formule Max appliquée ");
                    return MAX_FORMULA_PRICE_ASSIETTE;
                }
                break;
            default:
                break;
        }
        return addDessertPrice(total, dessertType);
    }

    private int applySandwichFormula(int total, DrinkSize drinkSize, DessertType dessertType) {
        switch (drinkSize) {
            case MOYEN:
                if (dessertType == DessertType.NORMAL) {
                    System.out.print("Prix Formule Standard appliquée ");
                    return STANDARD_FORMULA_PRICE_SANDWICH;
                }
                break;
            case GRAND:
                if (dessertType == DessertType.SPECIAL) {
                    System.out.print("Prix Formule Max appliquée ");
                    return MAX_FORMULA_PRICE_SANDWICH;
                }
                break;
            default:
                break;
        }
        return addDessertPrice(total, dessertType);
    }

    private int addDessertPrice(int total, DessertType dessertType) {
        switch (dessertType) {
            case NORMAL:
                return total + NORMAL_DESSERT_PRICE;
            case SPECIAL:
                return total + SPECIAL_DESSERT_PRICE;
            default:
                return total;
        }
    }
}
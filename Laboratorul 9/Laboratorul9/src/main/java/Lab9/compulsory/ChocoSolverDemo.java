package Lab9.compulsory;

public class ChocoSolverDemo {
    public static void main(String[] args) {
        Model model = new Model("Choco Solver");

        // Variables and their domains: x, y
        int x = model.intVar("x", 1, 6); //takes value in [1,6]
        int y = model.intVar("y", 1, 6);
        // Constraints: x + y = 7
        model.arithm(x, "+", y, "=", 7).post();
        // Computes all solutions
        int count = 1;
        while (model.getSolver().solve()) {
            System.out.println("Solution " + count++ + ": " + x + ", " + y);
        }
    }
}

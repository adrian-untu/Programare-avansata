package Lab9.compulsory;

import com.sun.tools.javac.comp.InferenceContext;
import org.eclipse.persistence.internal.libraries.antlr.runtime.tree.TreeVisitorAction;

import java.util.Random;

public class Model {
    String name;
    public Model(String name) {
        this.name = name;
    }

    public int intVar(String variable, int i, int i1) {
        Random rand = null;
        int k = rand.nextInt((i1 - i) + 1) + i;
        System.out.println(variable + " is " + k);
        return k;
    }

    public TreeVisitorAction arithm(int x, String s, int y, String s1, int i) {
        return null;
    }

    public InferenceContext getSolver() {
        solve();
        return null;
    }

    private void solve() {
    }
}

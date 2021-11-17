import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String expressionText = in.nextLine();
       // System.out.println(num + " = " + Calc.getResult(num));

        System.out.println(Calc.getResult(expressionText));
    }
}

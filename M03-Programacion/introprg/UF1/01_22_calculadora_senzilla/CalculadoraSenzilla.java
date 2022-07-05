/*
 * Aquest programa demana dos operands i un operador binari (+, -, * o /)
 * i mostra el resultat del càlcul corresponent
 */
public class CalculadoraSenzilla {
    public static void main(String[] args) {
        System.out.println("Operand1?");
        double operand1 = Double.parseDouble(Entrada.readLine());
        System.out.println("Operador?");
        char operador = Entrada.readLine().charAt(0);
        System.out.println("Operand2?");
        double operand2 = Double.parseDouble(Entrada.readLine());

        switch(operador) {
            case '+':
                double resultatsuma = operand1 + operand2;
                System.out.println("" + operand1 + " + " + operand2 + " = " + resultatsuma);   
            break;
            case '-':
                double resultatresta = operand1 - operand2;
                System.out.println("" + operand1 + " - " + operand2 + " = " + resultatresta);
            break;
            case '*':
                double resultatmult = operand1 * operand2;
                System.out.println("" + operand1 + " * " + operand2 + " = " + resultatmult);
            break;
            case '/':
                if (operand1 == 0 || operand2 == 0) {
                    System.out.println("No es pot dividir entre 0");
                }
                else {
                    double resultatdiv = operand1 / operand2;
                    System.out.println("" + operand1 + " / " + operand2 + " = " + resultatdiv);
                }
            break;
            default:
                System.out.println("L'operador " + operador + " no està disponible");
        } /* █████ */
    }
}

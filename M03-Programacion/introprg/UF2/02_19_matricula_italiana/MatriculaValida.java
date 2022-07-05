//programa de la UF1 que ens diu si la matricula que hem introduit es valida o no a Italia.
//Ara amb moduls
public class MatriculaValida {

    public static boolean esLletraValidaPerMatriculaItaliana(char resposta) {
        switch (resposta) {
            case 'Ç':
            case 'À':
            case 'Ñ':
            case 'ß':
            case 'I':
            case 'O':
            case 'Q':
            case 'U':
            case '=':
            case '+':
            case ' ':
            case 'È':
            case 'É':
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            return false;
            default:
                if (Character.isLowerCase(resposta)) {
                    return false;
                }
                else {
                    return true;
                }
        }
    }

    
    public static void main(String[] args) {
        System.out.println("Introduïu una matrícula");
        String matricula = Entrada.readLine();
        
        if (matricula.length()!=7){
            System.out.println("No és una matrícula italiana vàlida");
        }
        else{
            char digit1 = matricula.charAt(0);
            char digit2 = matricula.charAt(1);
            char digit3 = matricula.charAt(2);
            char digit4 = matricula.charAt(3);
            char digit5 = matricula.charAt(4);
            char digit6 = matricula.charAt(5);
            char digit7 = matricula.charAt(6);
            if (Character.isLetter(digit1) && Character.isLetter(digit2) && Character.isDigit(digit3) && Character.isDigit(digit4) && Character.isDigit(digit5) && Character.isLetter(digit6) && Character.isLetter(digit6) ) {
                /*Si entrem a aquest if els 2 primers son lletres, els 3 seguents numeros i els 2 ultims lletres*/
                if (esLletraValidaPerMatriculaItaliana(digit1) && 
                    esLletraValidaPerMatriculaItaliana(digit2) && 
                    esLletraValidaPerMatriculaItaliana(digit6) && 
                    esLletraValidaPerMatriculaItaliana(digit7)) {
                    System.out.println("És una matrícula italiana vàlida");
                }
                else {
                    System.out.println("No és una matrícula italiana vàlida");
                }
            }
            else {
                System.out.println("No és una matrícula italiana vàlida");
            }
        }
    }
}
/*
* Programa que ens demanarà introduir una matricula per consola i si contè 
* caràcters prohibits i/o minúscules, ens dirà que es invàlida.
*/
public class MatriculaValida {
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
                if (Character.isLowerCase(digit1) == false && Character.isLowerCase(digit2) == false && Character.isLowerCase(digit6) == false && Character.isLowerCase(digit7) == false && !(digit1=='Ç' || digit1=='À' || digit1=='Ñ' || digit1=='ß' || digit1=='I' || digit1=='O' || digit1=='Q' || digit1=='U' || digit2=='Ç' || digit2=='À' || digit2=='Ñ' || digit2=='ß' || digit2=='I' || digit2=='O' || digit2=='Q' || digit2=='U' || digit6=='Ç' || digit6=='À' || digit6=='Ñ' || digit6=='ß' || digit6=='I' || digit6=='O' || digit6=='Q' || digit6=='U' || digit7=='Ç' || digit7=='À' || digit7=='Ñ' || digit7=='ß' || digit7=='I' || digit7=='O' || digit7=='Q' || digit7=='U')) { //Si cap de les 4 lletres es minuscula ni algun dels caracters prohibits, entra al if
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

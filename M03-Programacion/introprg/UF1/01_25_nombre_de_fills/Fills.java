/*
 * Programa que pregunta quans fills tenim i ens diu un comentari al respecte. 
 */
public class Fills {
    public static void main(String[] args) {
    
        /*Declara la variable*/
        System.out.println("Quants fills tens?");
        int fills = Integer.parseInt(Entrada.readLine());
        /*Evalua totes les opcions de l'enunciat i entra a la condició que cumpleixi*/
        if ( fills < 0 ) {
            System.out.println("No pots tenir menys de 0 fills!");
        }
        else if ( fills == 0 ) {
            System.out.println("Tot el que t'has estalviat en bolquers!");
        }
        else if ( fills == 1 ) {
            System.out.println("Compte de no mimar-lo massa!");
        }
        else if ( fills > 1 && fills < 5 ) {
            System.out.println("No t'avorreixes a casa, eh?");
        }else if ( fills > 4 ) {
            System.out.println("Tu sí fas país!");
        }
    }
}

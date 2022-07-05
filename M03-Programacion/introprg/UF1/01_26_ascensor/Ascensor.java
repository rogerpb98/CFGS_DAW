/*
 * Programa que demanará a quin pis et troves i quants pots pujar/baixar i actuar de manera corresponent
 */

public class Ascensor {
    public static void main(String[] args) {
    
        System.out.println("pis?");
        String pis = Entrada.readLine();
        System.out.println("botó?");
        String boto = Entrada.readLine();
        
        /* si volem pujar dos entrem en aquest if*/
        if (boto.equals("pujar dos")) {
            if (pis.equals("planta baixa")) {
                System.out.println("segon pis");
            }
            else {
                System.out.println("error");
            }
        }
        
        /* si volem pujar un entrem en aquest if */
        else if (boto.equals("pujar un")) {
            if (pis.equals("planta baixa")) {
                System.out.println("primer pis");
            }
            else if (pis.equals("primer pis")) {
                System.out.println("segon pis");
            }
            else {
                System.out.println("error");
            }
        }
        
        /* si volem baixar un entrem en aquest if */
        else if (boto.equals("baixar un")) {
            if (pis.equals("primer pis")) {
                System.out.println("planta baixa");
            }
            else if (pis.equals("segon pis")) {
                System.out.println("primer pis");
            }
            else {
                System.out.println("error");
            }
        }
        
        /* si volem baixar dos entrem en aquest if*/
        else if (boto.equals("baixar dos")) {
            if (pis.equals("segon pis")) {
                System.out.println("planta baixa");
            }
            else {
                System.out.println("error");
            }
        }

        /* qualsevol altre cas es error*/
        else{
            System.out.println("error");
        }
    }
}

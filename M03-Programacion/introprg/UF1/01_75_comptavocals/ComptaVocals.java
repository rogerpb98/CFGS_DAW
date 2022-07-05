public class ComptaVocals {
    public static void main(String[] args) {

        System.out.println("Text?");
        String nombre = Entrada.readLine();

        int contador=0;
        for (int inici=0; inici<=nombre.length()-1; inici ++) {
            if (Character.isLetter(nombre.charAt(inici)) && nombre.charAt(inici)=='a' || nombre.charAt(inici)=='e' || nombre.charAt(inici)=='i' || nombre.charAt(inici)=='o' || nombre.charAt(inici)=='u' || nombre.charAt(inici)=='A' || nombre.charAt(inici)=='E' || nombre.charAt(inici)=='I' || nombre.charAt(inici)=='O' || nombre.charAt(inici)=='U' || nombre.charAt(inici)=='à' || nombre.charAt(inici)=='é' || nombre.charAt(inici)=='è' || nombre.charAt(inici)=='í' || nombre.charAt(inici)=='ï' || nombre.charAt(inici)=='ó' || nombre.charAt(inici)=='ò' || nombre.charAt(inici)=='ú' || nombre.charAt(inici)=='ü'|| nombre.charAt(inici)=='À' || nombre.charAt(inici)=='É' || nombre.charAt(inici)=='È' || nombre.charAt(inici)=='Í' || nombre.charAt(inici)=='Ï' || nombre.charAt(inici)=='Ó' || nombre.charAt(inici)=='Ò' || nombre.charAt(inici)=='Ú' || nombre.charAt(inici)=='Ü' ) {
                contador++;
            }
        }
        System.out.println(contador);
    }
}
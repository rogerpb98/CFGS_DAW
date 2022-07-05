public class UtilString {
    
    //Funcio que retorna si un caràcter es vocal o no (accent català)
    public static boolean esVocal(char lletra) {
        switch (lletra) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'à':
            case 'è':
            case 'é':
            case 'í':
            case 'ï':
            case 'ò':
            case 'ó':
            case 'ú':
            case 'ü':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
            case 'À':
            case 'È':
            case 'É':
            case 'Í':
            case 'Ï':
            case 'Ò':
            case 'Ó':
            case 'Ú':
            case 'Ü':
                return true;
            default:
                return false;
        }
    }
}

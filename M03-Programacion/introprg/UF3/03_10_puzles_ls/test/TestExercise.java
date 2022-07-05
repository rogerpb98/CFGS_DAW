/*
    Unit testing methods for exercise 03_10_puzles_ls
*/

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class TestExercise {

    @ParameterizedTest
    @CsvSource(value={
        "'',false",
        "' ',false",
        "'nom amb espais', false",
        "'!', false",
        "'/', false",
        "n,true",
        "_,true",
        "1,true",
        "nom_Perfectament_valid_123, true"
    })
    @DisplayName("test esNomPuzleValid()")
    public void esNomPuzleValid(String text, boolean expected) {
        assertEquals(expected, Puzle.esNomPuzleValid(text));
    }

    @ParameterizedTest
    @CsvSource(value={
        "'',false",
        "puzle_.txt,false",
        "puzle_.csv, false",
        "test_.txt, false",
        "puzlemolon.txt, false",
        "puzle_amb noms espaiats.txt, false",
        "puzle_nom_Perfectament_valid_123.txt, true"
    })
    @DisplayName("test esNomFitxerDePuzleValid()")
    public void esNomFitxerDePuzleValid(String text, boolean expected) {
        assertEquals(expected, Puzle.esNomFitxerDePuzleValid(text));
    }

    @ParameterizedTest
    @CsvSource(value={
        "puzle_.txt, ''",
        "puzle_amb noms espaiats.txt, 'amb noms espaiats'",
        "puzle_nom_Perfectament_valid_123.txt, nom_Perfectament_valid_123"
    })
    @DisplayName("test extreuNomPuzleDeNomFitxer()")
    public void extreuNomPuzleDeNomFitxer(String text, String expected) {
        assertEquals(expected, Puzle.extreuNomPuzleDeNomFitxer(text));
    }

    @Test
    @DisplayName("Test hi és mòdul mostraLlista()")
    public void prgtestX1mostraLlista() {
        Class classe = Puzle.class;
        String modulObjectiu = "mostraLlista";
        Method[] methods = classe.getDeclaredMethods();
        boolean foundTarget = false;
        for (Method method: methods) {
            if (modulObjectiu.equals(method.getName())) {
                foundTarget=true;
                Type[] types = method.getGenericParameterTypes();
                assertEquals(
                        0, 
                        types.length, 
                        "Revisa els paràmetres requerits pel mòdul " + modulObjectiu + "()"
                );
                assertEquals(
                        "void",
                        method.getGenericReturnType().getTypeName(),
                        "S'esperava " + modulObjectiu + "() d'un tipus diferent"
                );
            }
        }
        assertTrue(foundTarget, "No es troba el mòdul " + modulObjectiu + "(). Revisa enunciat.");
    }
    @Test
    @DisplayName("Test hi és mòdul esNomPuzleValid()")
    public void prgtestX2esNomPuzleValid() {
        Class classe = Puzle.class;
        String modulObjectiu = "esNomPuzleValid";
        Method[] methods = classe.getDeclaredMethods();
        boolean foundTarget = false;
        for (Method method: methods) {
            if (modulObjectiu.equals(method.getName())) {
                foundTarget=true;
                Type[] types = method.getGenericParameterTypes();
                assertEquals(
                        1, 
                        types.length, 
                        "Revisa els paràmetres requerits pel mòdul " + modulObjectiu + "()"
                );
                assertEquals(
                    "java.lang.String",
                    types[0].getTypeName(),
                    "Revisa els paràmetres requerits pel mòdul " + modulObjectiu + "()"
                );
                assertEquals(
                        "boolean",
                        method.getGenericReturnType().getTypeName(),
                        "S'esperava " + modulObjectiu + "() d'un tipus diferent"
                );
            }
        }
        assertTrue(foundTarget, "No es troba el mòdul " + modulObjectiu + "(). Revisa enunciat.");
    }
    @Test
    @DisplayName("Test hi és mòdul esNomFitxerDePuzleValid()")
    public void prgtestX3esNomFitxerDePuzleValid() {
        Class classe = Puzle.class;
        String modulObjectiu = "esNomFitxerDePuzleValid";
        Method[] methods = classe.getDeclaredMethods();
        boolean foundTarget = false;
        for (Method method: methods) {
            if (modulObjectiu.equals(method.getName())) {
                foundTarget=true;
                Type[] types = method.getGenericParameterTypes();
                assertEquals(
                        1, 
                        types.length, 
                        "Revisa els paràmetres requerits pel mòdul " + modulObjectiu + "()"
                );
                assertEquals(
                    "java.lang.String",
                    types[0].getTypeName(),
                    "Revisa els paràmetres requerits pel mòdul " + modulObjectiu + "()"
                );
                assertEquals(
                        "boolean",
                        method.getGenericReturnType().getTypeName(),
                        "S'esperava " + modulObjectiu + "() d'un tipus diferent"
                );
            }
        }
        assertTrue(foundTarget, "No es troba el mòdul " + modulObjectiu + "(). Revisa enunciat.");
    }
    @Test
    @DisplayName("Test hi és mòdul esNomFitxerDePuzleValid()")
    public void prgtestX4esNomFitxerDePuzleValid() {
        Class classe = Puzle.class;
        String modulObjectiu = "esNomFitxerDePuzleValid";
        Method[] methods = classe.getDeclaredMethods();
        boolean foundTarget = false;
        for (Method method: methods) {
            if (modulObjectiu.equals(method.getName())) {
                foundTarget=true;
                Type[] types = method.getGenericParameterTypes();
                assertEquals(
                        1, 
                        types.length, 
                        "Revisa els paràmetres requerits pel mòdul " + modulObjectiu + "()"
                );
                assertEquals(
                    "java.lang.String",
                    types[0].getTypeName(),
                    "Revisa els paràmetres requerits pel mòdul " + modulObjectiu + "()"
                );
                assertEquals(
                        "boolean",
                        method.getGenericReturnType().getTypeName(),
                        "S'esperava " + modulObjectiu + "() d'un tipus diferent"
                );
            }
        }
        assertTrue(foundTarget, "No es troba el mòdul " + modulObjectiu + "(). Revisa enunciat.");
    }
    @Test
    @DisplayName("Test hi és mòdul extreuNomPuzleDeNomFitxer()")
    public void prgtestX5extreuNomPuzleDeNomFitxer() {
        Class classe = Puzle.class;
        String modulObjectiu = "extreuNomPuzleDeNomFitxer";
        Method[] methods = classe.getDeclaredMethods();
        boolean foundTarget = false;
        for (Method method: methods) {
            if (modulObjectiu.equals(method.getName())) {
                foundTarget=true;
                Type[] types = method.getGenericParameterTypes();
                assertEquals(
                        1, 
                        types.length, 
                        "Revisa els paràmetres requerits pel mòdul " + modulObjectiu + "()"
                );
                assertEquals(
                    "java.lang.String",
                    types[0].getTypeName(),
                    "Revisa els paràmetres requerits pel mòdul " + modulObjectiu + "()"
                );
                assertEquals(
                        "java.lang.String",
                        method.getGenericReturnType().getTypeName(),
                        "S'esperava " + modulObjectiu + "() d'un tipus diferent"
                );
            }
        }
        assertTrue(foundTarget, "No es troba el mòdul " + modulObjectiu + "(). Revisa enunciat.");
    }
}
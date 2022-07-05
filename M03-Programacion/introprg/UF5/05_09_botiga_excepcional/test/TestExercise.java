import java.lang.reflect.Type;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class TestExercise {

    @Nested
    @DisplayName("Tests de Vi")
    class SobreVi {

        @Test
        @DisplayName("test vi.aArrayString() genera adequadament")
        public void viAArrayString() {
            Vi vi = new Vi("ROURABLA20200232", "Roura blanc", "blanc", 606, "2020", 32, "Alella", "P21E45N55E");
            String[] esperat = {"ROURABLA20200232", "Roura blanc", "blanc", "606", "2020", "32", "Alella", "P21E45N55E"};
            String[] obtingut = vi.aArrayString();
            assertArrayEquals(esperat, obtingut, "revisa la conversió de Vi a String[]");
        }

        @Test
        @DisplayName("test vi.deArrayString() quan hi ha tots els valors")
        public void viDeArrayString() {
            String[] entrada = {"ROURABLA20200232", "Roura blanc", "blanc", "606", "2020", "32", "Alella", "P21E45N55E"};
            Vi vi = Vi.deArrayString(entrada);
            assertAll(
                    () -> assertEquals("ROURABLA20200232", vi.getRef()),
                    () -> assertEquals("Roura blanc", vi.getNom()),
                    () -> assertEquals("blanc", vi.getTipus()),
                    () -> assertEquals(606, vi.getPreu()),
                    () -> assertEquals("2020", vi.getCollita()),
                    () -> assertEquals(32, vi.getEstoc()),
                    () -> assertEquals("Alella", vi.getOrigen()),
                    () -> assertEquals("P21E45N55E", vi.getLloc())
                );
        }

        @ParameterizedTest
        @CsvSource(value={
            "'','Vi.deArrayString() ha de retornar null quan rep una línia sense prou elements per construir un vi'",
            "'ROURABLA20200232;Roura blanc;blanc;606;2020;32;AlellaP21E45N55E','Vi.deArrayString() ha de retornar null quan rep una línia sense prou elements per construir un vi'",
            "'ROURABLA20200232;Roura blanc;blanc;606;2020;32;Alella;P21E45N55E;extra','Vi.deArrayString() ha de retornar null quan rep una línia sense prou elements per construir un vi'",
            "'ROURABLA20200232;Roura blanc;blanc;-606;2020;32;Alella;P21E45N55E','Vi.deArrayString() ha de retornar null quan rep una línia amb preu negatiu'",
            "'ROURABLA20200232;Roura blanc;blanc;606;2020;-32;Alella;P21E45N55E','Vi.deArrayString() ha de retornar null quan rep una línia amb estoc negatiu'",
            "'ROURABLA20200232;Roura blanc;blanc;;2020;32;Alella;P21E45N55E','Vi.deArrayString() ha de retornar null quan rep una línia amb preu buit'",
            "'ROURABLA20200232;Roura blanc;blanc;606;2020;;Alella;P21E45N55E','Vi.deArrayString() ha de retornar null quan rep una línia amb estoc buit'",
            "'ROURABLA20200232;Roura blanc;blanc;gratis;2020;32;Alella;P21E45N55E','Vi.deArrayString() ha de retornar null quan rep una línia amb preu no vàlid'",
            "'ROURABLA20200232;Roura blanc;blanc;606;2020;cap;Alella;P21E45N55E','Vi.deArrayString() ha de retornar null quan rep una línia amb estoc no vàlid'",
            "';Roura blanc;blanc;606;2020;32;Alella;P21E45N55E','Vi.deArrayString() ha de retornar null quan rep una línia amb ref buit'",
            "'ROURABLA20200232;;blanc;606;2020;32;Alella;P21E45N55E','Vi.deArrayString() ha de retornar null quan rep una línia amb nom buit'",
            "'ROURABLA20200232;Roura blanc;;606;2020;32;Alella;P21E45N55E','Vi.deArrayString() ha de retornar null quan rep una línia amb tipus buit'",
            "'ROURABLA20200232;Roura blanc;blanc;606;;32;Alella;P21E45N55E','Vi.deArrayString() ha de retornar null quan rep una línia amb collita buit'",
            "'ROURABLA20200232;Roura blanc;blanc;606;2020;32;;P21E45N55E','Vi.deArrayString() ha de retornar null quan rep una línia amb origen buit'",
            "'ROURABLA20200232;Roura blanc;blanc;606;2020;32;Alella;','Vi.deArrayString() ha de retornar null quan rep una línia amb lloc buit'"
        })
        @DisplayName("test Vi.deArrayString() quan se li passa una línia no vàlida")
        public void viDeArrayStringFaltenValors(String linia, String missatge) {
            assertNull(Vi.deArrayString(linia.split(";")), missatge);
        }

        @Test
        @DisplayName("test Vi.deArrayString() normalitza valors")
        public void viDeArrayStringNormalitzaNom() {
            String[] entrada = {"    ROURABLA20200232    ", "    Roura     blanc    ",
                                "    blanc    ", "    606    ", "    2020    ", "     32    ",
                                "    Alella    ", "    P21E45N55E    "};
            Vi vi = Vi.deArrayString(entrada);
            assertAll(
                    () -> assertNotNull(vi, "Problemes amb la construcció d'un vi des d'un array de String amb valors no normalitzats"),
                    () -> assertEquals("ROURABLA20200232", vi.getRef(), "Cal normalitzar els valors rebuts per deArrayString()"),
                    () -> assertEquals("Roura blanc", vi.getNom(), "Cal normalitzar els valors rebuts per deArrayString()"),
                    () -> assertEquals("blanc", vi.getTipus(), "Cal normalitzar els valors rebuts per deArrayString()"),
                    () -> assertEquals(606, vi.getPreu(), "Cal normalitzar els valors rebuts per deArrayString()"),
                    () -> assertEquals("2020", vi.getCollita(), "Cal normalitzar els valors rebuts per deArrayString()"),
                    () -> assertEquals(32, vi.getEstoc(), "Cal normalitzar els valors rebuts per deArrayString()"),
                    () -> assertEquals("Alella", vi.getOrigen(), "Cal normalitzar els valors rebuts per deArrayString()"),
                    () -> assertEquals("P21E45N55E", vi.getLloc(), "Cal normalitzar els valors rebuts per deArrayString()")
                    );
        }

        @Test
        @DisplayName("test Vi.esValid() retorna true quan és vàlid")
        public void viEsValidQuanEsConstrueixValid() {
            assertTrue(new Vi("LLUMALBA20200001", "Llum Alba Blanc", "blanc", 1750, "2020", 12, "Priorat", "P02E03N55D").esValid(),
                    "Vi.esValid() ha de retornar true quan el vi construït és vàlid");
        }

        @ParameterizedTest
        @CsvSource(value={
            "'', 'Roura blanc', 'blanc', 1234, 2018, 24, Alella, P21E45N55E, 'El vi no ha de ser vàlid si la referència és buida'",
            "LLUMALBA20200001, '', 'blanc', 1234, 2018, 24, Alella, P21E45N55E, 'El vi no ha de ser vàlid si el nom és buit'",
            "LLUMALBA20200001, 'Roura blanc', '', 1234, 2018, 24, Alella, P21E45N55E, 'El vi no ha de ser vàlid si el tipus és buit'",
            "LLUMALBA20200001, 'Roura blanc', 'blanc', -12, 2018, 24, Alella, P21E45N55E, 'El vi no ha de ser vàlid si el preu és negatiu'",
            "LLUMALBA20200001, 'Roura blanc', 'blanc', 1234, '', 24, Alella, P21E45N55E, 'El vi no ha de ser vàlid si la collita és buida'",
            "LLUMALBA20200001, 'Roura blanc', 'blanc', 1234, 2018, -24, Alella, P21E45N55E, 'El vi no ha de ser vàlid si l'estoc és negatiu'",
            "LLUMALBA20200001, 'Roura blanc', 'blanc', 1234, 2018, 24, '', P21E45N55E, 'El vi no ha de ser vàlid si origen és buit'"

        })
        @DisplayName("test Vi.esValid() retorna false quan algun dels atributs amb els que es construeix no és vàlid")
        public void viNoValidQuanEsConstrueixAmbAtributNoValid(String ref,
                                                               String nom, String tipus, int preu, String collita,
                                                               int estoc, String origen, String lloc, String missatge) {
            assertFalse(new Vi(ref, nom, tipus, preu, collita, estoc, origen, lloc).esValid(), missatge);
        }


        @ParameterizedTest
        @CsvSource(value={
            "'','','la cadena buida ha de normalitzar a cadena buida'",
            "'   ','','la cadena amb només espais ha de normalitzar a cadena buida'",
            "text,text,'la cadena és un mot sense espais ha de normalitzar retornant el que rep'",
            "'   text',text,'la cadena és un mot amb espais inicials ha de normalitzar retornant eliminant espais'",
            "'text   ',text,'la cadena és un mot amb espais finals ha de normalitzar eliminant espais'",
            "'   text   ',text,'la cadena és un mot amb espais inicials i finals ha de normalitzar eliminant espais'",
            "'un dos tres','un dos tres','la cadena són mots sense espais sobrers ha de normalitzar retornant el que rep'",
            "'un     dos tres','un dos tres','la cadena són mots amb espais sobrers ha de normalitzar eliminant espais sobrers'",
            "'   un     dos    tres   ','un dos tres','la cadena són mots amb espais sobrers ha de normalitzar eliminant espais sobrers'",
        })
        @DisplayName("test Vi.normalitzaString() retorna un String normalitzat")
        public void normalitzaStringRetornaStringNormalitzat(String entrada, String esperat, String msg) {
            final String missatge = "Vi.normalitzaString() quan " + msg;
            String trobat = Vi.normalitzaString(entrada);
            assertEquals(esperat, trobat, missatge);
        }

        @Test
        @DisplayName("test Vi.normalitzaString() retorna cadena buida quan rep null")
        public void normalitzaStringNullABuida() {
            String resultat = Vi.normalitzaString(null);
            assertAll(
                    () -> assertNotNull(resultat, "normalitzaString() ha de convertir null a cadena buida"),
                    () -> assertTrue(resultat.isEmpty(), "normalitzaString() ha de convertir null a cadena buida")
                    );
        }


    }

    @Nested
    @DisplayName("Tests de Botiga")
    class SobreBotiga {

        @Test
        @DisplayName("test botiga pot ser recorreguda quan és buida")
        public void recorregutBuit() {
            Botiga botiga = new Botiga();
            botiga.iniciaRecorregut();
            Vi primer = botiga.getSeguent();
            assertNull(primer, "una botiga buida ha de retornar null al primer vi del recorregut");
        }

        @Test
        @DisplayName("test botiga pot ser recorreguda quan hi ha elements")
        public void recorregutComplet() throws BotigaPlenaException {
            Vi[] vins = {
                new Vi("LLUMALBA20200001", "Llum Alba Blanc", "blanc", 1750, "2020", 12, "Priorat", "P02E03N55D"),
                new Vi("CARPATHI20180021", "Carpathia Negre", "negre", 3450, "2018", 6, "Montsant", "P23E01N43D"),
                new Vi("MATISNEG20190011", "Matís Negre", "negre", 1325, "2019", 12, "Pla del Bages", "P20E01N12E")
            };

            Botiga botiga = new Botiga();
            for (Vi vi: vins) botiga.afegeix(vi);

            botiga.iniciaRecorregut();
            Vi[] trobats = {
                botiga.getSeguent(),
                botiga.getSeguent(),
                botiga.getSeguent(),
                botiga.getSeguent(),
            };
            assertAll(
                    () -> assertEquals(vins[0], trobats[0], "la botiga ha de tornar el primer vi després d'iniciar recorregut"),
                    () -> assertEquals(vins[1], trobats[1], "la botiga ha de retornar el segon vi després del primer"),
                    () -> assertEquals(vins[2], trobats[2], "la botiga ha de retornar el següent vi en el recorregut"),
                    () -> assertNull(trobats[3], "la botiga ha de retornar null en demanar el següent del darrer")
                    );
        }

        @Test
        @DisplayName("test el recorregut de botiga pot ser reinicialitzat en meitat d'un recorregut")
        public void recorregutAmbReinici() throws BotigaPlenaException {
            Vi[] vins = {
                new Vi("LLUMALBA20200001", "Llum Alba Blanc", "blanc", 1750, "2020", 12, "Priorat", "P02E03N55D"),
                new Vi("CARPATHI20180021", "Carpathia Negre", "negre", 3450, "2018", 6, "Montsant", "P23E01N43D"),
                new Vi("MATISNEG20190011", "Matís Negre", "negre", 1325, "2019", 12, "Pla del Bages", "P20E01N12E")
            };
            Botiga botiga = new Botiga();
            for (Vi vi: vins) botiga.afegeix(vi);

            botiga.iniciaRecorregut();
            Vi trobatPrimerPrimeraVolta = botiga.getSeguent();
            Vi trobatSegonPrimeraVolta = botiga.getSeguent();
            botiga.iniciaRecorregut();
            Vi trobatPrimerSegonaVolta = botiga.getSeguent();
            assertAll(
                    () -> assertEquals(vins[0], trobatPrimerPrimeraVolta, "la botiga ha de tornar el primer vi després d'iniciar recorregut"),
                    () -> assertEquals(vins[1], trobatSegonPrimeraVolta, "la botiga ha de retornar el segon vi després del primer"),
                    () -> assertEquals(vins[0], trobatPrimerSegonaVolta, "la botiga ha de retornar el primer vi en tornar a iniciar en mig d'un recorregut")
                    );
        }

        @Test
        @DisplayName("test el recorregut de botiga un cop arribat al final sempre torna null")
        public void recorregutSempreNullUnCopArribatAlFinal() throws BotigaPlenaException {
            Vi[] vins = {
                new Vi("CARPATHI20180021", "Carpathia Negre", "negre", 3450, "2018", 6, "Montsant", "P23E01N43D"),
                new Vi("MATISNEG20190011", "Matís Negre", "negre", 1325, "2019", 12, "Pla del Bages", "P20E01N12E")
            };
            Botiga botiga = new Botiga();
            for (Vi vi: vins) botiga.afegeix(vi);

            botiga.iniciaRecorregut();
            Vi[] trobats = {
                botiga.getSeguent(),
                botiga.getSeguent(),
                botiga.getSeguent(),
                botiga.getSeguent(),
                botiga.getSeguent(),
            };
            assertAll(
                    () -> assertEquals(vins[0], trobats[0], "la botiga ha de tornar el primer vi després d'iniciar recorregut"),
                    () -> assertEquals(vins[1], trobats[1], "la botiga ha de retornar el segon vi després del primer"),
                    () -> assertNull(trobats[2], "la botiga ha de retornar null en demanar el següent del darrer"),
                    () -> assertNull(trobats[3], "la botiga ha de retornar null un cop acabat el recorregut"),
                    () -> assertNull(trobats[4], "la botiga ha de retornar null un cop acabat el recorregut")
                    );
        }

        @Test
        @DisplayName("test el recorregut de botiga salta espais eliminats")
        public void recorregutAmbViEliminat() throws BotigaPlenaException {
            Vi[] vins = {
                new Vi("LLUMALBA20200001", "Llum Alba Blanc", "blanc", 1750, "2020", 0, "Priorat", "P02E03N55D"),
                new Vi("CARPATHI20180021", "Carpathia Negre", "negre", 3450, "2018", 0, "Montsant", "P23E01N43D"),
                new Vi("MATISNEG20190011", "Matís Negre", "negre", 1325, "2019", 0, "Pla del Bages", "P20E01N12E")
            };
            Botiga botiga = new Botiga();
            for (Vi vi: vins) botiga.afegeix(vi);
            botiga.elimina(vins[1]);

            botiga.iniciaRecorregut();
            Vi trobatPrimer = botiga.getSeguent();
            Vi trobatSegon = botiga.getSeguent();
            assertAll(
                    () -> assertEquals(vins[0], trobatPrimer, "la botiga ha de tornar el primer vi després d'iniciar recorregut"),
                    () -> assertEquals(vins[2], trobatSegon, "la botiga ha de saltar les posicions eliminades")
                    );
        }

        @Test
        @DisplayName("test el recorregut de botiga controla la mida de l'array de vins")
        public void recorregutForaDeRang() throws BotigaPlenaException {
            Vi[] vins = {
                new Vi("CARPATHI20180021", "Carpathia Negre", "negre", 3450, "2018", 0, "Montsant", "P23E01N43D"),
                new Vi("MATISNEG20190011", "Matís Negre", "negre", 1325, "2019", 0, "Pla del Bages", "P20E01N12E")
            };
            Botiga botiga = new Botiga(2);
            for (Vi vi: vins) botiga.afegeix(vi);
            botiga.elimina(vins[1]);

            botiga.iniciaRecorregut();
            botiga.getSeguent();    // ignora primer
            botiga.getSeguent();    // ignora segon
            Vi primerForaDeRang  = botiga.getSeguent();
            Vi segonForaDeRang  = botiga.getSeguent();
            assertAll(
                    () -> assertNull(primerForaDeRang, "el recorregut ha de controlar quan arriba al final de l'array"),
                    () -> assertNull(segonForaDeRang, "el recorregut ha de controlar quan arriba al final de l'array")
                    );
        }

        @Test
        @DisplayName("test la botiga no afegeix vins no valids")
        public void noAfegeixVinsNoValids() throws BotigaPlenaException {
            Vi viNoValid = new Vi(null, null, null, -1, null, -1, null, null);
            Botiga botiga = new Botiga();
            Vi resultat = botiga.afegeix(viNoValid);
            assertNull(resultat, "La botiga no ha de afegir vins no vàlids");
        }

        @ParameterizedTest
        @CsvSource(value={
            "ROURABLA20200232,'Roura blanc', blanc, 606, 2020, 32, Alella, P21E45N55E, 3, 'coincideixen tots els valors'",
            "LLUMALBA20200001,'Llum Alba Blanc', blanc, 1750, 2020, 12, Priorat, P02E03N55D, 0, 'coincideixen tots els valors'",
            "MATISNEG20190011, 'Matís Negre', negre, 1325, 2019, 12, Pla del Bages, P20E01N12E, 2, 'coincideixen tots els valors'",
            "LLUMALBA20200001,'', '', -1, '', -1, '', '', 0, 'cercant per ref'",
            "'','Carpathia Negre', '', -1, '', -1, '', '', 1, 'cercant per nom'",
            "'','', negre, -1, '', -1, '', '', 1, 'cercant per tipus'",
            "'','', '', 1325, '', -1, '', '', 2, 'cercant per preu exacte'",
            "'','', '', 1324, '', -1, '', '', 3, 'cercant per preu màxim'",
            "'','', '', -1, 2019, -1, '', '', 2, 'cercant per collita'",
            "'','', '', -1, '', 32, '', '', 3, 'cercant per estoc exacte'",
            "'','', '', -1, '', 31, '', '', 3, 'cercant per estoc màxim'",
            "'','', '', -1, '', -1, 'Pla del Bages', '', 2, 'cercant per origen'",
            "'','', '', -1, '', -1, '', P20E01N12E, 2, 'cercant per lloc'",
            "'','', negre, -1, 2019, -1, '', '', 2, 'cercant per tipus i collita'",

            "LlUmAlBa20200001,'', '', -1, '', -1, '', '', 0, 'cercant amb diferents majúscules/minúscules'",
            "'','carPatHia negre', '', -1, '', -1, '', '', 1, 'cercant amb diferents majúscules/minúscules'",
            "'','', negRe, -1, '', -1, '', '', 1, 'cercant amb diferents majúscules/minúscules'",
            "'','', '', -1, 2019, -1, '', '', 2, 'cercant amb diferents majúscules/minúscules'",
            "'','', '', -1, '', -1, 'pla Del bages', '', 2, 'cercant amb diferents majúscules/minúscules'",
            "'','', '', -1, '', -1, '', P20e01n12E, 2, 'cercant amb diferents majúscules/minúscules'",

        })
        @DisplayName("test Vi.cerca() troba vi existent per cada propietat")
        public void cercaTrobaViExistentDesDePlantilla(String ref,
                                                       String nom, String tipus, int preu, String collita,
                                                       int estoc, String origen, String lloc,
                                                       int indexEsperat, String msg) throws BotigaPlenaException {
            final String missatge = "Botiga.cerca() ha de trobar un vi existent quan " + msg;
            Vi[] vins = {
                new Vi("LLUMALBA20200001", "Llum Alba Blanc", "blanc", 1750, "2020", 12, "Priorat", "P02E03N55D"),
                new Vi("CARPATHI20180021", "Carpathia Negre", "negre", 3450, "2018", 6, "Montsant", "P23E01N43D"),
                new Vi("MATISNEG20190011", "Matís Negre", "negre", 1325, "2019", 12, "Pla del Bages", "P20E01N12E"),
                new Vi("ROURABLA20200232", "Roura blanc", "blanc", 606, "2020", 32, "Alella", "P21E45N55E")
            };
            Botiga botiga = new Botiga();
            for (Vi vi: vins) botiga.afegeix(vi);

            Vi esperat = vins[indexEsperat];
            Vi plantilla = new Vi(ref, nom, tipus, preu, collita, estoc, origen, lloc);
            Vi trobat = botiga.cerca(plantilla);
            assertAll(
                    () -> assertNotNull(trobat, "Botiga.cerca() no està trobant un vi que hi és"),
                    () -> assertEquals(esperat.getRef(), trobat.getRef(), missatge),
                    () -> assertEquals(esperat.getNom(), trobat.getNom(), missatge),
                    () -> assertEquals(esperat.getTipus(), trobat.getTipus(), missatge),
                    () -> assertEquals(esperat.getPreu(), trobat.getPreu(), missatge),
                    () -> assertEquals(esperat.getCollita(), trobat.getCollita(), missatge),
                    () -> assertEquals(esperat.getEstoc(), trobat.getEstoc(), missatge),
                    () -> assertEquals(esperat.getOrigen(), trobat.getOrigen(), missatge),
                    () -> assertEquals(esperat.getLloc(), trobat.getLloc(), missatge)
                    );
        }

        @Test
        @DisplayName("test constructor de botiga llença excepció quan la mida inicial és massa petita")
        public void constructorBotigaExcepcio() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                new Botiga(0);
            }, "Revisa què fa el constructor de Botiga quan la mida és massa petita");
            assertEquals("No es pot crear una botiga amb menys d'un vi", exception.getMessage(),
                    "revisa el missatge de l'excepció del constructor específic de Botiga");
        }

        @Test
        @DisplayName("test Botiga.elimina() llença excepció quan rep null")
        public void eliminaViAmbNull() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                new Botiga().elimina(null);
            }, "Revisa què fa Botiga.elimina() quan rep null");
            assertEquals("El paràmetre vi no ha de rebre null", exception.getMessage(),
                    "revisa el missatge de l'excepció de Botiga.elimina()");
        }

        @Test
        @DisplayName("test Botiga.elimina() llença excepció quan rep instància desconeguda")
        public void eliminaViDesconegut() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                new Botiga().elimina(
                        new Vi("ROURABLA20200232", "Roura blanc", 
                               "blanc", 606, "2020", 0, "Alella", "P21E45N55E"));
            }, "Revisa què fa Botiga.elimina() quan rep instància desconeguda");
            assertEquals("La instància a eliminar ha d'estar present", exception.getMessage(),
                    "revisa el missatge de l'excepció de Botiga.elimina()");
        }

        @Test
        @DisplayName("test Botiga.cerca() llença excepció quan rep instància desconeguda")
        public void cercaViAmbNull() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                new Botiga().cerca(null);
            }, "Revisa què fa Botiga.cerca() quan rep null");
            assertEquals("El paràmetre plantilla no ha de rebre null", exception.getMessage(),
                    "revisa el missatge de l'excepció de Botiga.cerca()");
        }

        @Test
        @DisplayName("test Botiga.afegeix() llença excepció quan plena")
        public void afegeixABotigaPlena() throws BotigaPlenaException {
            Botiga botiga = new Botiga(1);
            Vi vi1 = new Vi("LLUMALBA20200001", "Llum Alba Blanc", "blanc", 1750, "2020", 12, "Priorat", "P02E03N55D");
            Vi vi2 = new Vi("CARPATHI20180021", "Carpathia Negre", "negre", 3450, "2018", 6, "Montsant", "P23E01N43D");
            botiga.afegeix(vi1);
            Exception exception = assertThrows(BotigaPlenaException.class, () -> {
                botiga.afegeix(vi2);
            }, "Revisa què fa Botiga.afegeix() quan està plena");
            assertEquals("Botiga plena", exception.getMessage(),
                    "revisa el missatge de l'excepció de Botiga.afegeix()");
        }


    }

    @Nested
    @DisplayName("Tests de BotigaPlenaException")
    class SobreBotigaPlenaException {

        @Test
        @DisplayName("test BotigaPlenaException constructor per defecte")
        public void constructorPerDefecte() {
            assertEquals("Botiga plena", new BotigaPlenaException().getMessage(),
                    "Revisa el missatge de l'excepció quan s'inicialitza amb el constructor per defecte");
        }

        @Test
        @DisplayName("test BotigaPlenaException constructor específic")
        public void constructorEspecific() {
            assertEquals("Botiga ben farcideta", new BotigaPlenaException("Botiga ben farcideta").getMessage(),
                    "Revisa el missatge de l'excepció quan s'inicialitza amb el constructor específic");
        }

        @Test
        @DisplayName("test BotigaPlenaException és subclasse de Exception")
        public void subclassException() {
            assertEquals("java.lang.Exception", BotigaPlenaException.class.getSuperclass().getName(),
                    "Revisa quina classe estén BotigaPlenaException");
        }

    }



}
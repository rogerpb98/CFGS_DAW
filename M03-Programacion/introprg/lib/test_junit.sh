#! /bin/bash
# Aquest programa realitza els tests de JUnit d'un exercici
# Considera:
#   $1 el nom del programa que conté el main(): ignorat aquí
#   $2 la carpeta amb els tests
#   #3 isredirected: el guió té redirigida la sortida

if [ -z "$1" ] || [ -z "$2" ];
then
    echo "Ús: $0 NomDelProgramaATestejar NomDeLaCarpetaAmbElsTests"
    exit 1
fi
test_folder="$2"
test_program=TestExercise
isredirected="$3"

if [ ! -f "$test_folder/$test_program.java" ];
then
    echo "El contingut de $test_folder no és l'esperat."
    exit 1
fi
tmpfile=$(mktemp)
cd "$test_folder" || exit 1
prgpath=$CLASSPATH:..
javac -cp $prgpath -d . "$test_program.java" &>"$tmpfile"
exitcode=$?
if [ $exitcode -ne 0 ];
then
    echo "Error compilant el test"
    echo "-----------------------"
    echo
    cat $tmpfile
else
    # Executa els tests
    junitoptions="--disable-banner --fail-if-no-tests"
    if [ $isredirected -eq 1 ];
    then
        junitoptions="$junitoptions --disable-ansi-colors"
    fi
    java -cp $prgpath org.junit.platform.console.ConsoleLauncher -c $test_program $junitoptions &>"$tmpfile"
    exitcode=$?
    if [ $exitcode -ne 0 ];
    then
        echo "Error executant la prova"
        echo "------------------------"
        echo
        cat $tmpfile
    elif [[ "$(grep '^Failures (' $tmpfile)" != "" ]]; then
        echo "No passa un o més tests"
        echo "-----------------------"
        echo
        cat $tmpfile
        exitcode=1
    fi
fi
rm -f "$tmpfile"
rm -f *.class
exit $exitcode

#! /bin/bash
# Aquest programa realitza els tests d'E/S d'un exercici
# Considera com a entrada els arguments de linia de comanda

# $1 contains the name of the program under test
# $2 contains the folder with the tests

script_base=$(dirname "$0")

# Check that $1 contains the name of the program under test
if [ -z "$1" ] || [ -z "$2" ];
then
    echo "Ús: $0 NomDelProgramaATestejar NomDeLaCarpetaAmbElsTests"
    exit 1
fi
exercise_base=$(dirname "$1")
program=$(basename "$1")
test_folder="$2"

diffoptions=${INTROPRG_DIFFOPTIONS:-"-EZbB"}
tmpfile=$(mktemp)
errors=0
for filein in "$test_folder"/testfile*.txt;
do
    filename=$(basename -- "$filein")
    filenumber=${filename##testfile}
    testnumber=${filenumber%.*}
    fileout=$test_folder/expected$filenumber
    cd "$exercise_base" > /dev/null
    java $INTROPRG_JAVAPOLICYFILE "$program" $(cat "$filein") &> "$tmpfile"
    cd - > /dev/null
    diff $diffoptions "$tmpfile" "$fileout" &> /dev/null
    if [ "$?" -ne "0" ];
    then
        errors=1
        echo "Test nr. $testnumber: Error"
        echo
        echo "Entrada"
        echo "-------"
        cat "$filein"
        echo; echo
        echo "Sortida esperada"
        echo "----------------"
        cat "$fileout"
        echo; echo
        echo "Sortida trobada"
        echo "---------------"
        cat "$tmpfile"
        echo; echo
        echo "Diferència"
        echo "----------"
        diff $diffoptions "$fileout" "$tmpfile"
        echo
        break
    fi
done
rm -f "$tmpfile"
if [ "$errors" -ne "0" ];
then
    exit 1
fi

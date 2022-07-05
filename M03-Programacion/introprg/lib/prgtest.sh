#!/bin/bash
# Aquest guió realitza els tests d'un exercici programat en Java

# El programa està preparat per executar les proves a la subcarpeta test/

# La subcarpeta test/ correspon a tests definits pel docent i no haurien
# de ser modificats pels estudiants doncs poden ser reescrits en qualsevol
# moment

# Es recomana molt no modificar aquest programa doncs pot ser sobreescrit
# en qualsevol moment pel docent. Si et cal cap canvi, consulta-ho abans.

script_base=$(dirname "$0")

# Check pwd is in a exercise folder
exercise_base=$PWD

test_subfolder="test"

test_folder="$exercise_base/$test_subfolder"
if [ ! -d "$test_folder" ];
then
    echo
    echo "Problema"
    echo "========"
    echo
    echo "La carpeta actual no sembla correspondre a un exercici amb correcció automàtica"
    echo
    exit 1
fi

# Check whether cwd is an actual exercise folder
if [ ! -d "$test_subfolder" ];
then
    echo
    echo "Problema"
    echo "========"
    echo
    echo "La carpeta actual no sembla correspondre a un exercici de introprg amb suport de prova automàtica."
    echo
    exit 1
fi

# Check test configuration
if [ ! -f "$test_folder/programname" ];
then
    echo
    echo "Problema"
    echo "========"
    echo
    echo "Problemes amb el test $test_folder. Si l'has modificat, considera recuperar l'original"
    echo
    exit 1
fi

# Check target program exists
programname=$(cat "$test_folder"/programname)
if [ ! -f "$programname" ];
then
    echo
    echo "Problema"
    echo "========"
    echo
    echo "No es troba el programa $programname"
    echo "Assegura't que has posat el nom correcte al teu programa"
    echo
    exit 1
fi

# Check every java file in this folder is already commited
if [ -z "$INTROPRG_JAVAPOLICYFILE" ];
then
    if git status | grep '\.java' | grep -v '\/'  &> /dev/null;
    then
        echo
        echo "Problema"
        echo "========"
        echo
        echo "Cal fer commit dels canvis al codi a aquesta carpeta abans de continuar"
        echo
        exit 1
    fi
fi

programa=${programname%%.*}
if [ ! -f "$programa.class" ];
then
    echo
    echo "Problema"
    echo "========"
    echo
    echo "Comprova si has compilat $programa.java"
    echo
    exit 1
fi

if [ "$programa.java" -nt "$programa.class" ];
then
    echo
    echo "Problema"
    echo "========"
    echo
    echo "Comprova si has recompilat $programa.java després de modificar-lo"
    echo
    exit 1
fi

if ! ls $test_folder/test_* &> /dev/null;
then
    echo
    echo "Problema"
    echo "========"
    echo
    echo "Aquesta carpeta no sembla contenir tests"
    echo
    exit 1
fi

# Check for redirection
if [ -t 1 ];
then
    isredirected=0
else
    isredirected=1
fi

# Do the testing
error=0
for test in $test_folder/test_*;
do
    test_mark=$(basename "$test")
    test_script="$script_base/${test_mark%%.*}.sh"
    title="Testing ${test_mark#*_}"
    echo
    echo $title
    echo $title | tr [:print:] '='
    echo
    bash "$test_script" "$exercise_base/$programa" "$test_folder" $isredirected
    if [ $? -ne 0 ];
    then
        error=1
        break
    else
        echo "Fet"
    fi
done

if [ $error -eq 0 ];
then
    echo
    echo "El programa $programname ha passat totes les proves"
else
    exit 1
fi

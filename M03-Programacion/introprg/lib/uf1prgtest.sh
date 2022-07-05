#!/bin/bash
# Aquest programa realitza els tests d'un exercici programat en Java

# Es tracta de la versió utilitzada durant la UF1 i es manté només com a
# referència pels estudiants que feien servir la funcionalitat de tests
# addicionals dins de la carpeta mytests/
# El més probable és que puguis ignorar aquest guió i fer servir només
# la versió actual de prgtest

# El programa està preparat per executar les proves en les subcarpetes
# test/ i mytests/

# La subcarpeta test/ correspon a tests definits pel docent i no haurien
# de ser modificats pels estudiants doncs poden ser reescrits en qualsevol
# moment

# La subcarpeta mytests/ correspon a tests dels estudiants i no seran
# considerades per les proves automàtiques.

# Es recomana molt no modificar aquest programa doncs pot ser sobreescrit
# en qualsevol moment pel docent.

script_base=$(dirname "$0")

# Check pwd is in a exercise folder
exercise_base=$PWD

if [ -z "$INTROPRG_JAVAPOLICYFILE" ];
then
    test_folders="test mytests"
else
    test_folders="test"
fi

has_test=0
for test_subfolder in $test_folders;
do
    test_folder="$exercise_base/$test_subfolder"
    if [ ! -d "$test_folder" ];
    then
        continue
    fi
    has_test=1

    # Check test configuration
    if [ ! -f "$test_folder/programname" ];
    then
        echo
        echo "Error"
        echo "====="
        echo "Problemes amb el test $test_folder. Si l'has modificat, considera recuperar l'original"
        exit 1
    fi

    programname=$(cat "$test_folder"/programname)
    if [ ! -f "$programname" ];
    then
        echo
        echo "Error"
        echo "====="
        echo "No es troba el programa $programname"
        echo "Assegura't que has posat el nom correcte al teu programa"
        echo
        exit 1
    fi

    programa=${programname%%.*}
    if [ ! -f "$programa.class" ];
    then
        echo "Comprova si has compilat $programa.java"
        exit 1
    fi

    if [ "$programa.java" -nt "$programa.class" ];
    then
        echo "Comprova si has recompilat $programa.java després de modificar-lo"
        exit 1
    fi

    error=0
    for test in "$test_folder"/test_*;
    do
        test_mark=$(basename "$test")
        test_script="$script_base/${test_mark%%.*}.sh"
        echo
        echo "Testing $test_subfolder"
        echo "======================="
        echo
        bash "$test_script" "$exercise_base/$programa" "$test_folder"
        if [ $? -ne 0 ];
        then
            error=1
            break
        fi
    done

    if [ $error -eq 0 ];
    then
        echo "El programa $programname ha passat totes les proves de $test_subfolder"
    else
        exit 1
    fi
done

if [ "$has_test" -ne "1" ];
then
    echo "Aquesta carpeta no sembla contenir tests"
    exit 1
fi

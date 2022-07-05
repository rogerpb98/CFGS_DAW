#! /bin/bash
# Aquest programa realitza els tests d'E/S d'un exercici
# 
# Pot exercitar els tests amb tres tipus d'entrades combinables entre si
# - per línia de comandes
# - redireccionant l'entrada estàndard
# - amb la presència d'un o més fitxers d'entrada
#
# Funcionament:
# -------------
# Crea un directori temporal on copia els fitxers de l'exercici
# Afegeix, si escau, els fitxers d'entrada
# Executa el programa objectiu, tot passant-li els arguments i
# redireccionant l'entrada convenientment.
# Compara la sortida estàndard amb l'esperada i l'existència i continguts
# dels fitxers de sortida amb els esperats.
# En cas de detecció de diferència, mostra:
# - entrada (els tres diferents tipus)
# - sortida esperada (sortida estàndard o nom del fitxer de sortida +
# contingut)
# - sortida trobada
# - diferència

# Addicionalment accepta l'execució del script test/pretest abans dels
# test si aquest existeix


# $1 name of the program under test
# $2 folder with the tests


# Check this script parameters
if [ -z "$1" ] || [ -z "$2" ];
then
    echo "Ús: $(basename $0) «programa a provar» «carpeta amb els tests»"
    exit 1
fi


# name parameters
program=$(basename "$1")
test_folder="$2"

# Check there are tests
testfiles="$test_folder/testfile*.txt"
if ! compgen -G $testfiles > /dev/null;
then
    echo "Error: no es troben proves a aquesta carpeta"
    exit 1
fi

# run pre-tests if any
pretest="$test_folder/pretest"
if [ -f $pretest ];
then
    bash "$pretest"
fi

# script options
diffoptions=${INTROPRG_DIFFOPTIONS:-"-EZbB"}

# temporary destinations
tmpfolder=$(mktemp -d -t ies_$program"_XXXXXXXXXXX")
tmpfile="$tmpfolder/__result"
tmpdiff="$tmpfolder/__difference"


# Show file contents
function show_contents() {
    echo
    echo -e "\\e[7m$(cat $1)\\e[0m"
    echo
}


# copy file-ins $1 onto destfolder $2
function cp_filein() {
    filesin=$1
    destfolder=$2
    if compgen -G "$filesin"* > /dev/null; then
        for filein in "$filesin"*;
        do
            fileinname=$(basename -- "$filein")
            fileindest=${fileinname#*_}
            cp "$filein" "$destfolder/$fileindest"
        done
    fi
}


# remove given input files from current folder
function rm_filein() {
    filesin=$1
    destfolder=$2
    if compgen -G "$filesin"* > /dev/null; then
        for filein in "$filesin"*;
        do
            fileinname=$(basename -- "$filein")
            rm -f "${fileinname#*_}"
        done
    fi
}


# remopve preexisting output files from current folder
function rm_fileout() {
    outputprefix=$1
    if compgen -G "$outputprefix"* > /dev/null; then
        for fileout in "$outputprefix"*;
        do
            fileoutname=$(basename -- "$fileout")
            rm -f "${fileoutname#*_}"
        done
    fi
}


# Display the stdout difference
function display_stdout_difference() {
    expected=$1
    studentresult=$2
    difference=$3

    echo
    echo "Sortida estàndard esperada"
    echo "--------------------------"
    echo
    echo "S'esperava el següent per sortida estàndard:"
    show_contents "$expected"

    echo "Sortida estàndard trobada"
    echo "-------------------------"
    echo
    echo "S'ha trobat el següent per sortida estàndard:"
    show_contents "$studentresult"

    echo
    echo "Diferència"
    echo "----------"
    echo
    echo "La diferència entre l'esperat i el trobat és:"
    show_contents "$difference"
}


# Display the output file difference
function display_output_difference() {
    studentresult=$1
    expected=$2
    difference=$3
    echo
    echo "Fitxer de sortida esperat"
    echo "-------------------------"
    if [ -f "$studentresult"  ];
    then
        echo
        echo "Respecte el fitxer $studentresult"
        echo
        echo "Contingut esperat"
        echo "-----------------"
        show_contents "$expected"

        echo "Contingut trobat"
        echo "----------------"
        show_contents "$studentresult"

        echo "Diferència"
        echo "----------"
        show_contents "$difference"
    else
        echo
        echo "S'esperava trobar el fitxer $studentresult"
    fi
}

# Display current text context
function display_test_context() {
    testid=$1
    testioin=$2
    params=$3
    filesinprefix=4

    echo
    echo "S'ha trobat un error en executar la prova nr. $testid"
    echo
    echo "Execució del programa"
    echo "---------------------"
    echo
    echo "L'execució ha estat la següent:"
    echo
    echo $ java $program $params
    echo
    if [ -s "$testioin" ]; 
    then
        echo "Entrada estàndard"
        echo "-----------------"
        echo
        echo "Se li ha passat el següent contingut per entrada estàndard:"
        show_contents "$testioin"
    fi
    if compgen -G "$filesin"* > /dev/null;
    then
        echo "Fitxers d'entrada"
        echo "-----------------"
        echo
        echo "El programa $program s'ha trobat els següents fitxers:"

        for filein in "$filesin"*;
        do
            fileinname=$(basename -- "$filein")
            fileindest=${fileinname#*_}
            echo
            echo "$ cat $fileindest"
            show_contents "$filein"
        done
    fi
}


# let's go on to business

# copy all the files in current folder to temp folder and cd
cp -r ./* "$tmpfolder" > /dev/null
cd "$tmpfolder" > /dev/null

exit_code=0
for testin in "$test_folder"/testfile*.txt;
do
    if [ "$exit_code" -ne "0" ];
    then
        break
    fi

    # define this test context
    testioin=$(basename -- "$testin")
    filenumber=${testioin##testfile}
    testnumber=${filenumber%.*}
    testioout="$test_folder/expected$filenumber"
    filesinprefix=filein$testnumber"_"
    filesoutprefix=fileout$testnumber"_"
    fileargin="$test_folder/argsin$testnumber.txt"


    # remove preexisting output files if any
    rm_fileout "$test_folder/$filesoutprefix"


    # copy input test files if any
    cp_filein "$test_folder/$filesinprefix" "$tmpfolder"


    # get command line arguments if any
    if [ -f "$fileargin" ];
    then
        params=$(head -n 1 "$fileargin")
    fi

    # run the program under test
    java $INTROPRG_JAVAPOLICYFILE "$program" < "$testin" $params &> "$tmpfile"
    exit_code=$?
    if [ $exit_code -ne 0 ];
    then
        display_test_context $testnumber "$testin" "$params" "$filesinprefix"
        echo
        echo "El resultat de l'execució ha estat:"
        show_contents "$tmpfile"
        break
    fi

    # Check expected std output if any
    if [ -f "$testioout" ];
    then
        diff $diffoptions "$testioout" "$tmpfile" &> "$tmpdiff"
        exit_code=$?

        # Display the difference
        if [ $exit_code -ne 0 ];
        then
            display_test_context $testnumber "$testin" "$params" "$filesinprefix"
            display_stdout_difference "$testioout" "$tmpfile" "$tmpdiff"
        fi
    fi

    # check expected fileout contents if any
    if [ $exit_code -eq 0 ];
    then
        if compgen -G "$test_folder/$filesoutprefix*" > /dev/null;
        then
            for fileout in "$test_folder/$filesoutprefix"*;
            do
                fileoutname=$(basename -- "$fileout")
                fileoutdest=${fileoutname#*_}
                diff $diffoptions $fileout $fileoutdest &> $tmpdiff
                exit_code=$?
                if [ $exit_code -ne 0 ];
                then
                    display_test_context $testnumber $testioin "$params" "$filesinprefix"
                    display_output_difference "$fileoutdest" "$fileout" "$tmpdiff"
                    break;
                fi
            done
        fi
    fi

    # remove input test files if any
    rm_filein "$test_folder/$filesinprefix"

done


# get rid of temporary folder
rm -rf "$tmpfolder"
cd - > /dev/null
exit $exit_code

#! /bin/bash

# Aquest script t'ajudarà a configurar el teu sistema per a poder
# realitzar les proves dels teus programes a un entorn GNU/Linux tipus
# Debian/Ubuntu estàndard

error_introprgdir=0
error_repository_folder=0
error_introprgdir_is_repo=0
error_java=0

function show_ok() {
    echo -e "\\e[1;37;42mCORRECTE\\e[0m: $1"
}

function show_error() {
    echo -e "\\e[1;37;41mERROR\\e[0m: $1"
}

function show_warning() {
    echo -e "\\e[1;37;43mAVíS\\e[0m: $1"
}

function check_var_introprgdir() {
    if [ -z "$INTROPRGDIR" ];
    then
        error_introprgdir=1
        show_error "Variable INTROPRGDIR no definida"
    else
        show_ok "Variable INTROPRGDIR definida"
    fi
}

function check_config_file() {
    if [ -f "$INTROPRGDIR/.introprg" ];
    then
        show_ok "Trobat fitxer de configuració $INTROPRGDIR/.introprg"
    else
        show_warning "No s'ha trobat el fitxer de configuració $INTROPRGDIR/.introprg"
    fi
}

function check_repository_folder() {
    if [ ! -d "$INTROPRGDIR" ];
    then
        error_repository_folder=1
        show_error "No es troba la carpeta $INTROPRGDIR"
    else
        show_ok "Trobada la carpeta $INTROPRGDIR"
    fi
}

function check_sourced_config() {
    if grep -e 'source .*/.introprg' $HOME/.bashrc &> /dev/null;
    then
        show_ok ".bashrc carrega .introprg"
    else
        show_warning ".bashrc no carrega .introprg"
    fi
}

function check_introprgdir_is_repo() {
    if [ $error_repository_folder -eq 1 ];
    then
        error_introprgdir_is_repo=1
        show_warning "No es pot comprovar el repositori introprg/"
    else
        cd "$INTROPRGDIR"
        if git status &> /dev/null;
        then
            show_ok "$INTROPRGDIR és un repositori git"
        else
            error_introprgdir_is_repo=1
            show_error "$INTROPRGDIR no és un repositori git"
        fi
    fi
}

function check_java() {
    # Comprova que jdk estigui instal·lat amb una versió 11+
    if javac -version &> /dev/null;
    then
        if javacversion=$(javac -version);
        then
            v=$(echo "$javacversion" | cut -f 1 -d.)
            if [[ "$v" < "11" ]];
            then
                error_java=1
                show_error "La versió de Java (jdk) hauria de ser 11 o superior (s'ha trobat la $v)"
            else
                show_ok "La versió de Java trobada ($v) és correcta"
            fi
        else
            error_java=1
            show_error "Java (jdk) no està instal·lat correctament"
        fi
    else
        error_java=1
        show_error "No es troba javac"
    fi
}

function recomanaClonar() {
    echo
    echo "Sembla que no has realitzat la clonació del teu repositori remot"
    echo "Revisa els apunts per trobar en quin punt t'has quedat:"
    echo "    https://moiatjda.github.io/jda.dev.m03/holagit.html"
    echo
    echo "Si ja has fet la clonació en un directori diferent de ~/introprg/"
    echo "et caldrà configurar adequadament la variable d'entorn INTROPRGDIR"
    echo
}

function recomanaDefinirINTROPRGDIR() {
    echo
    echo "Sembla que no has definit correctament la variable d'entorn INTROPRGDIR"
    echo "Revisa els apunts per trobar si no has configurat correctament l'entorn:"
    echo "    https://moiatjda.github.io/jda.dev.m03/holagit.html#configuracio-de-l-entorn"
    echo
    echo "Si ja has fet la clonació en un directori diferent de ~/introprg/"
    echo "et caldrà configurar adequadament la variable d'entorn INTROPRGDIR"
    echo
}

function recomanaInstallarOpenJDK() {
    echo
    echo "Sembla que no tens installat correctament el compilador de Java"
    echo "Revisa els apunts per trobar si no l'has instal·lat correctament:"
    echo "    https://moiatjda.github.io/jda.dev.m03/requeriments_llenguatge.html"
    echo
}


check_var_introprgdir
if [ $error_introprgdir -eq 1 ];
then
    INTROPRGDIR=${INTROPRGDIR:-$HOME/introprg}
    check_repository_folder
    if [ $error_repository_folder -eq 1 ];
    then
        recomanaClonar
        exit 1
    else
        recomanaDefinirINTROPRGDIR
        exit 1
    fi
else
    check_config_file
    check_introprgdir_is_repo
    check_sourced_config
    check_java
    if [ $error_java -eq 1 ];
    then
        recomanaInstallarOpenJDK
    fi
fi


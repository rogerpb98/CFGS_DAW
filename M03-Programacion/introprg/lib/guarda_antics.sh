#! /bin/bash
echo "Aquest guió guarda les carpetes d'exercicis antics"

blocks="00 01 02"
base=$(dirname $(dirname $(realpath $0)))
cd "$base" &> /dev/null

gitcommand="env LANG=en_EN.utf8 git"

tmpfile=$(mktemp)
$gitcommand status &> $tmpfile


function error() {
    echo
    echo "ERROR: $1"
    echo
    rm -f $tmpfile
    exit 1
}

if grep 'Changes not staged for commit' $tmpfile &> /dev/null; then
    error "Fes commit abans d'executar aquest guió"
fi

if grep 'Changes to be committed' $tmpfile &> /dev/null; then
    error "Fes commit abans d'executar aquest guió"
fi

changes=0
for block in $blocks; do
    seed="${block}_??_"
    if compgen -G "$seed"*> /dev/null;
    then
        dest="arxiu/exercicis_$block"
        mkdir -p "$dest"
        for folder in $(compgen -G "$seed"*); do
            git mv $folder $dest/
            changes=1
        done
    fi
done

if [ $changes -eq 1 ]; then
    $gitcommand commit -m "arxivats exercicis antics" > /dev/null
    echo "Fet"
else
    echo "Res a fer"
fi

rm -f $tmpfile

#!/bin/bash
cd pruebasMias
listado=$(ls)
cd ..
for i in $listado; do
lista=$(echo $listado | grep txt)
sal=$(echo $i | sed -r 's#vgp([0-9]{1,2})\.txt#vgp\1.sal#g')
err=$(echo $i | sed -r 's#vgp([0-9]{1,2})\.txt#vgp\1.err#g')
java plp1 pruebasMias/$i 2> pruebasMias/$err >pruebasMias/$sal
done;

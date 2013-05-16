#! /bin/bash

mkdir "pruebas/pruebasFinales"
contador=0
for i in $(ls pruebas|grep -e .*\.fnt$);do
	nombre="vgp"$contador".fnt"
	cp "pruebas/"$i "pruebas/pruebasFinales/"$nombre;
	echo "pruebas/"$i "pruebas/pruebasFinales/"$nombre
	contador=$(($contador+1));
done

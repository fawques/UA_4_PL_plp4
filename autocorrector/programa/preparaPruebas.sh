#! /bin/bash

for i in $(ls |grep -e .*\.sal.tmp$);do
	nombre=$(echo $i|grep -e .*\.sal -o)
	cp $i "../plp4-pre-prueba/"$nombre;
	echo $i $nombre
done

for i in $(ls |grep -e .*\.err.tmp$);do
	nombre=$(echo $i|grep -e .*\.err -o)
	cp $i "../plp4-pre-prueba/"$nombre;
	echo $i $nombre
done
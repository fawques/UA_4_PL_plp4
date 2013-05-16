#!/bin/bash

# Directorio ramz:
casa=$PWD

. ./exportvars.sh
# Nombre de la práctica:
nom=plp$numero
nomentrega=$nom$entrega
dirprogramas=$casa/${nom}-pre-prueba

# Programa que elimina el proceso:
timer=$casa/timer

# Programa que quita los comentarios:
comentarios=$casa/quita-comentarios

# Cambia la localizacion:
export LANG=es_ES.utf8

# Directorio actual:
carpeta=$1

# Fichero de resultados:
res=$carpeta/$reslocal

# Tamaño máximo en caracteres de la salida de una práctica:
tope=1000000

# Temporal para lo anterior:
tmpsize=maximunsize.tmp

# JVM 1.7:
java=java

# Compilador de Java 1.7:
javac=javac

# Mono:
ensamb=ilasm
maqvirt=mono

#Variable total
totalFicheros=0
# Librerias de ANTLR para Java:
export ANTLR_CLASSPATH=./lib/antlr-3.5-complete.jar

# Identifica el lenguaje objetivo (por ahora solo Java):

if test -e $carpeta/$nom.java
then
   TARGET=java
fi

# Ficheros que guardan los errores y aciertos:

cuentaok=$carpeta/aciertos.txt
cuentanook=$carpeta/fallos.txt

# Funcion para correccion:

bucle_correccion ()
{
if test ! -e $carpeta/$nom.g
then 
  echo -n "No existe el fichero $nom.g de ANTLR"
  echo -n > $res
  exit 0
fi

rm -f $carpeta/${nom}Parser.$TARGET $carpeta/${nom}Lexer.$TARGET

# Procesa la especificación con ANTLR:

# Elimina comentarios (si tienen acentos ANTLR puede fallar):
#$comentarios <$carpeta/$nom.g >$tmpsize
#mv $tmpsize $carpeta/$nom.g

$java -jar $ANTLR_CLASSPATH  $carpeta/$nom.g

if test $? -ne 0
then
  echo "ANTLR no funciona correctamente: (retorno: "$? >> $cuentanook
  echo "ANTLR no funciona correctamente: (retorno: "$?
  return
fi

if test ! -e $carpeta/${nom}Parser.$TARGET
then
  echo "Error en ANTLR: no se ha generado el Parser" >> $cuentanook
  echo "Error en ANTLR: no se ha generado el Parser"
  return
elif test ! -e $carpeta/${nom}Lexer.$TARGET
then
  echo "Error en ANTLR: no se ha generado el Lexer" >> $cuentanook
  echo "Error en ANTLR: no se ha generado el Lexer"
  return
fi

if test $TARGET = "java"
then
  rm -f $carpeta/*.class

  # Compila todas las clases:
  if test $TARGET = "java"
  then
    $javac -classpath $ANTLR_CLASSPATH:$carpeta $carpeta/*.java
  fi

  if test $? -ne 0
  then
    echo -n "No compila" >> $cuentanook
    echo "No compila"
  else
    for j in $1/*.fnt
      do
      n=$(basename $j .fnt)
      totalFicheros=$(echo "$totalFicheros+1" | bc -l)

      # En primer lugar se detecta si la práctica emite muchos
      # caracteres (signo de error):

      if test $TARGET = "java"
      then
        $timer 10 $java -classpath $ANTLR_CLASSPATH:$carpeta $nom $j 2>&1 | head -c $tope >$tmpsize
      fi

      salida=$(wc -c $tmpsize | awk '{print $1}')
      rm $tmpsize
      if [ "$salida" = "$tope" ] ; 
        then 
          echo "$n: #error: demasiada salida#"; echo -n "$n " >> $cuentanook
        else  

          if test $TARGET = "java"
          then
            $timer 10 $java -classpath $ANTLR_CLASSPATH:$carpeta $nom $j > $carpeta/$n.il.tmp 2> $carpeta/$n.err.tmp
          fi

 # Practica que genera codigo CIL
          if [ -s $carpeta/$n.il.tmp ]
            then
              $timer 10 $ensamb -output:$carpeta/$n.tmp.exe $carpeta/$n.il.tmp >/dev/null 2>&1
              $timer 10 $maqvirt $carpeta/$n.tmp.exe <$1/$n.ent > $carpeta/$n.sal.tmp
            else
              rm -f $carpeta/$n.sal.tmp
              touch $carpeta/$n.sal.tmp
          fi

          diff -b -B --brief $1/$n.sal $carpeta/$n.sal.tmp >/dev/null
          if [ $? -eq 0 ]
            then
              diff -b -B --brief $1/$n.err $carpeta/$n.err.tmp >/dev/null
              if [ $? -eq 0 ]
                then
                  echo "$n: ok"; echo -n "$n " >> $cuentaok   
                  ok=$(echo "$ok+1" | bc -l)
                else 
                  echo "$n: #error en stderr#"; echo -n "$n " >> $cuentanook   
              fi  
            else 
              echo "$n: #error en stdout#"; echo -n "$n " >> $cuentanook   
          fi
      fi
    done
  fi
else
  echo "No existen los ficheros con el código fuente"
  echo -n > $res
  exit 0
fi
}   

# Correccion:

echo -n > $cuentaok
echo -n > $cuentanook
ok=0
echo "Probando:"
bucle_correccion $dirprogramas
echo "Aciertos: $ok/$totalFicheros"
okprimerapasada=$ok
cuentafallos=$(echo "$cuentatotal-$okprimerapasada" | bc -l)


exit 0


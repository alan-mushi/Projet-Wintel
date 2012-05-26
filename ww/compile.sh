#!/bin/sh
# Script permettant de compiler le projet d'AP4 Wintel et de l'exécuter tout de suite

javac -encoding UTF8 -d ../class ../src/ihm/*.java ../src/datas/*.java ../src/control/*.java
echo -n "Exécuter Wintel ? (o/n : defaut) : "
read ok

if [ "$ok" = "o" ] || [ "$ok" = "O" ]; then
	if [ $CLASSPATH != "../class" ] ; then
		export CLASSPATH=../class
	fi
	java ihm.Wintel
fi


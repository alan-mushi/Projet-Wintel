#!/bin/bash

pushd .
machine=`uname -n`

if [ $machine = "bt" ] || [ $machine = "thibault-laptop" ]; then
	cd ~/IUT/AP4/Projet-Wintel/
	
elif [ $machine = "SKYNET" ] ; then
	cd ~/Desktop/Projet-Wintel/
	
else
	echo Votre path ici
	exit
fi

javadoc -docencoding utf8 -private -d doc/ src/datas/* src/ihm/* src/control/*

popd

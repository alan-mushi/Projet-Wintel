#!/bin/bash

pushd .
machine=`uname -n`

if [ $machine = "bt" ] || [ $machine = "thibault-laptop" ]; then
	cd ~/IUT/AP4/Projet-Wintel/
else
	echo Votre path ici
fi

javadoc -docencoding utf8 -private -d doc/ src/datas/* src/ihm/*

popd

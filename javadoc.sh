#!/bin/bash

pushd .
cd ~/IUT/AP4/Projet-Wintel/

javadoc -docencoding utf8 -private -d doc/ src/datas/* src/ihm/*

popd

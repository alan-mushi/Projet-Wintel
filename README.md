# Projet Wintel

## Description

Cette application est apparentée à un annuaire électronique. Elle permet de gérer ses contacts et de les contacter.
Annuaire doté d'une interface graphique pour la gestion des contacts.<br />
Une liste des contacts pré-établie est fournie : `ww/table.bin`.

## Stade de développement

* Javadoc à achever
* Trouver une solution pour le champ d'adresse du contact

## Toute la javadoc est à générer sur sa propre machine !

Depuis le dossier racine du projet.<br />
Commande javadoc : `javadoc -docencoding utf8 -private -d doc/ src/datas/* src/ihm/*`<br />
Le fichier `javadoc.sh` contient la commande et plus...
Le fichier `ww/compile.sh` permet de compiler avec le bon encodage puis donne le choix d'exécuter ou non Wintel.

## Travail additionnel

* Ecrire la réaction au clic sur le bouton « Composer ». <b>En cours</b>
* Lors de la fermeture de Wintel, détecter une modification de l’annuaire sans sauvegarde et proposer la sauvegarde avant la fermeture définitive.
* Permettre une recherche dans la JList par entrée de texte dans un JTextField (nom du correspondant).
* Rajouter le champ « adresse » pour un contact téléphonique. <b>En cours</b>
* Proposer un codage conforme au modèle MVC vu en cours. <b>Fait</b>

## Auteurs

* CLAUDIC Guillaume - zipang29
* GUITTET Thibault - alan-mushi

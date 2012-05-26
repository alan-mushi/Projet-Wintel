# Projet Wintel

## Description

Annuaire doté d'une interface graphique pour la gestion des contacts.<br />
Une liste des contacts pré-établie est fournie : `ww/table.bin`.

## Stade de développement

* Javadoc à achever
* Trouver une solution pour le champ d'adresse du contact

## Toute la javadoc est à générer sur sa propre machine !

Depuis le dossier racine du projet.<br />
Commande javadoc : `javadoc -docencoding utf8 -private -d doc/ src/datas/* src/ihm/*`<br />
Le fichier `javadoc.sh` contient la commande et plus...

## Travail additionnel

* Ecrire la réaction au clic sur le bouton « Composer ».
* Lors de la fermeture de Wintel, détecter une modification de l’annuaire sans sauvegarde et proposer la
sauvegarde avant la fermeture définitive.
* Permettre une recherche dans la JList par entrée de texte dans un JTextField (nom du correspondant).
* Rajouter le champ « adresse » pour un contact téléphonique. <b>En cours.</b>
* Proposer un codage conforme au modèle MVC vu en cours. <b>En cours de vérification.</b>

## Auteurs

* CLAUDIC Guillaume - zipang29
* GUITTET Thibault - alan-mushi

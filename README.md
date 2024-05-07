# Java-CrazyCircus

Projet Java, 1ère année BUT Informatique

Le but de l’application est de recréer le jeu de plateau Crazy Circus où trois animaux
: un éléphant, un ours et un lion sont empilés sur un podium.
Les joueurs peuvent tirer une carte montrant une séquence d’empilement d’animaux
parmi 24. Le but du jeu est que le joueur donne une chaîne de commandes qui
déplace les animaux d’une situation initiale à une situation montrée sur une carte
tirée.
Lorsqu'une carte objectif est tirée, elle est défaussée et ne réapparaîtra pas dans la
pioche.
Le jeu se termine lorsque les 24 cartes ont été tirées et résolues.
Les joueurs jouent un par un, et peuvent choisir parmi 5 commandes distinctes :
- KI - L'animal se trouvant en haut de la pile du podium bleu saute pour
rejoindre le sommet de la pile du podium rouge.
- LO - L'animal se trouvant en haut de la pile du podium rouge saute pour
rejoindre le sommet de la pile du podium bleu.
- SO – Les deux animaux se trouvant au sommet des piles des deux podiums
échangent leur place.
- NI – L’animal se trouvant en bas de la pile du podium bleu monte et se place
en haut de la pile de ce même podium.
- MA – L’animal se trouvant en bas de la pile du podium rouge monte et se
place en haut de la pile de ce même podium.
Le premier joueur ayant trouvé une bonne séquence de commandes remporte le
tour. Si un joueur donne une mauvaise séquence, il ne peut plus en proposer d’autre
pour le reste de ce tour. La situation atteinte après un tour est la situation de départ
du tour qui suit. Si, durant un tour, il n’y a plus qu’un joueur à ne pas avoir proposer
de séquence, ce dernier remporte le tour. La carte objectif trouvée devient la
situation de départ du tour suivant.
Le joueur ayant remporté le plus de tours gagne la partie.

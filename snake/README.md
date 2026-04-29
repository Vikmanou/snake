# Snake

## Description

Jeu Snake. Le joueur controle un serpent qui mange des fruits pour grandir et accumuler des points. Les fruits achetes dans la boutique apparaissent aleatoirement dans la partie et donnent des bonus de taille differents. Le score final est converti en monnaie et le meilleur score est sauvegarde.

## Fonctionnalites depuis TP2

* Integration du meilleur score avec persistance
* Ajout de l'argent a l'utilisateur a la fin de chaque partie

## Contournements Ntro

* **`GestionnaireTouches`** Ntro ne supporte pas la detection de combinaisons de touches ni l'etat asynchrone du clavier. Classe personnalisee qui maintient une liste ordonnee des touches actives et notifie un capteur a chaque changement, permettant au joueur de changer de direction instantanement.

* **`MathUtils`** Avec une fonction pour calculer la distance entre deux points.

* **Historique de positions** Ntro ne conserve que la position courante de l'objet et non l'historique. J'ai cree un historique de positions pour le serpent.

* **Alignement sur la grille** Ntro deplace les objets en continu. Lors d'un changement de direction, la position est arrondie a la case la plus proche. Ensuite, les positions dans l'historique sont supprimees pour eviter les bugs visuels.

* **`Serpent2d.collideAvecCorps`** Ntro n'a pas de systeme de collision. Ni une systeme specifiquement pour mon implementation du corps du serpemtn. Je fait une detection manuelle par accumulation de distance avec l'historique de positions du serpent. J'ai aussi integre une zone d'exclusion de la tete pour eviter les faux positifs.

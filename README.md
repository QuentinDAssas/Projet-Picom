# Projet-Picom
Formation POEI Open-Orsys, Projet Picom

Lien Trello : https://trello.com/b/ct21FHPv/suivi-de-projet-picom
Lien Balsamiq : https://balsamiq.cloud/s2qax9v/p5hawsj/r5FD8

Description du projet :

On considère un système publicitaire réparti sur tous les arrêts d’un réseau de transport en
commun.
Ce système sera nommé « Picom » pour Pi communication car il repose sur l’utilisation de
Raspberry Pi.
Sur chaque arrêt du réseau de transport sont installés :
- un écran 43 pouces
- un Raspberry Pi 4 modèle B sur lequel Raspberry Pi OS est installé
- une clé 4G qui se connecte à un réseau 4G. On supposera que cette clé donne une adresse IP
statique à chaque Raspberry Pi
- un coffret sécurisé et hermétique dans lequel les équipements ci-dessus sont placés
Entre 6h et 20h, le Raspberry Pi de chaque arrêt du réseau de transport affiche des annonces
publicitaires.
On découpe cet interval de temps en tranches horaires : 6h, 7h, 8h, 9h, etc.
La durée d’affichage d’une annonce publicitaire est de 15 secondes.
Le réseau de transport est découpé en zones. Un arrêt se trouve dans une et une seule zone. Une
zone compte au minimum 4 arrêts et au maximum 20 arrêts.
Pour chaque zone un tarif de diffusion des annonces publicitaires est défini. Ce tarif de diffusion
évolue en fonction de la tranche horaire.
NB : les tranches horaires sont les mêmes pour toutes les zones.
Par exemple : l’affichage d’une annonce publicitaire dans la zone hyper-centre pour la tranche
horaire 12h revient à 25 euros.
Il est garanti au client que pendant une même tranche horaire et dans une zone considérée,
l’annonce sera diffusée 40 fois.
L’objectif de ce projet est de mettre en œuvre l’application destinée aux clients et aux
administrateurs.
L’objectif de ce projet n’est pas d’écrire l’application IoT destinée aux Raspberries.

Besoins fonctionnels :

Pour les clients, il est nécessaire de pouvoir :
 s’inscrire en précisant son nom, son prénom, un email, un mot de passe contenant au
minimum 8 caractères et son numéro de téléphone (l’inscription est gratuite) (feature 1)
 s’authentifier (feature 2)
 voir toutes ses annonces publicitaires (feature 3)
 ajouter une annonce publicitaire (feature 4). Pour ce faire, l’application propose dans cet
ordre :
◦ de rédiger son annonce dans un éditeur HTML intégré à l’application
◦ de choisir la ou les zones sur lesquelles il/elle souhaite que son annonce soit diffusée
◦ de choisir la ou les tranches horaires de diffusion
◦ de choisir la date à laquelle la diffusion doit commencer et le nombre de jours de
diffusion
◦ de payer en ligne l’annonce en précisant son numéro de carte de crédit, la date
d’expiration (mois et année) de la carte ainsi que son CVV. Cette phase de paiement ne
fera pas réellement appel à un serveur de paiement en ligne.
 voir les diffusions de ses annonces (feature 5)
 se déconnecter (feature 6)
Pour les administrateurs, il est nécessaire de pouvoir :
 s’authentifier (feature 2)
 gérer les tarifs de diffusion (visualisation des tarifs, ajout d’un tarif) (feature 7)
 se déconnecter (feature 6)
L’application ajoutera chaque minute des diffusions en base (en utilisant le scheduling de Spring)
(feature 8).
Architecture Logicielle et choix technologiques :
Le front-end utilisera le framework Angular.
Le back-end utilisera Spring et son modèle en quatre couches:
- la couche contrôleur est assurée par des contrôleurs Rest de Spring
- la couche service contient des services Spring
- la couche DAO contient des interfaces qui héritent de l’interface JpaRepository
- la couche persistance est assurée par une base de données PostgreSQL nommée picom.
Le back-end utilisera Spring Boot 2.7.2 et sera configuré avec des fichiers .properties, l’annotation
@Profile et/ou des fichiers YAML.
Dans la mesure du possible, les versions des composants logiciel seront LTS.

Travail d’équipe et gestion du projet :
Vous devez utiliser Git tout au long du développement du projet.
Il est recommandé d’utiliser un tableau kanban (par exemple avec les colonnes “To do”, “In
progress”, “Done”) sur Github (disponible sur l’onglet Projects).
Un développeur doit se charger entièrement d’une feature à l’exception des features 4 et 8 qui
seront développées à deux.
L’utilisation de SonarLint est cruciale tout au long du projet.

Les classes métier de votre projet Maven doivent être identiques à celles présentées dans le diagramme de classe métier.

Travail demandé :
1. Créer le projet à l’aide de Spring Initializr : https://start.spring.io
2. Créer une base de données PostgreSQL nommée picom
3. Importer le projet Maven dans Eclipse/IntelliJ et ajouter les classes métier présentées sur le
diagramme ci-dessus. Annoter les classes métier avec les annotations de JPA, du framework
Hibernate et celles de l’API Bean validation.
4. Ajouter le projet sur Github
5. Écrire les interfaces de la couche DAO
6. Écrire les interfaces et les classes de la couche service
7. Écrire les contrôleurs Spring pour votre application Web
8. Écrire les classes de tests. Les tests seront exécutés dans une base H2 en mémoire
9. Écrire une classe AjoutDonneesInitiales dont la méthode run() ajoute les objets suivants :
- 5 zones
- 20 arrêts
- 14 tranches horaires
- 1 client (avec l’email client1@orsys.fr et le mot de passe 12345678)
- 1 administrateur (avec l’email admin1@orsys.fr et le mot de passe 12345678)
10. Écrire le front en utilisant le framework Angular
Question bonus : modifier l’application pour qu’elle soit multilingue.
# Picom-back
# Picom-back

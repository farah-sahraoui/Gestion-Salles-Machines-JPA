# Projet Hibernate JPA - Gestion des Salles et Machines

Ce projet consiste en une application Java utilisant Hibernate pour la persistance des données,
mettant en œuvre une relation bidirectionnelle entre les entités Salle et Machine. L'application permet
d'effectuer des opérations CRUD complètes et d'exécuter des requêtes nommées pour la recherche de machines
par période d'achat, avec une couche service et des tests unitaires JUnit pour valider l'ensemble des fonctionnalités.


## Technologies utilisées:

Java 17

Hibernate ORM 5.6.9

MySQL 8

JUnit 4

Maven

## Fonctionnalités implémentées:

Entités JPA : Salle et Machine avec relations bidirectionnelles

CRUD complet : Create, Read, Update, Delete pour les deux entités

Requêtes nommées : Recherche de machines par période de date

Tests unitaires : Validation des services avec JUnit

Architecture en couches : DAO, Service, Util

## Résultats d'exécution:

### Capture 1 - Affichage des salles et machines:


![WhatsApp Image 2026-03-09 at 15 13 43](https://github.com/user-attachments/assets/8ed23031-fa40-4956-af81-1aa8e25e8abb)


Cette capture montre l'affichage des salles avec leurs machines associées après insertion en base de données.
On peut voir la salle AMPHI-200 avec ses machines IMPR-HP-456 et la salle LAB0-305 avec ses machines SCAN-789.



### Capture 2 - Requête findBetweenDate :

![WhatsApp Image 2026-03-09 at 15 12 45](https://github.com/user-attachments/assets/ab5de230-d6c7-48f2-9b1d-d07c0e5ce66b)

![WhatsApp Image 2026-03-09 at 15 15 10](https://github.com/user-attachments/assets/dea6071d-aa46-495a-8d10-2573758481b6)



Cette capture présente le début de l'exécution de la requête nommée findBetweenDate qui recherche les machines achetées entre
le 1er janvier 2010 et la date actuelle. On voit la requête SQL générée par Hibernate pour cette recherche.



## Conclusion:
Ce TP a permis de mettre en œuvre une application Java avec Hibernate pour la gestion d'une relation entre deux entités.
Les objectifs ont été atteints avec succès : création des entités JPA avec leurs annotations, implémentation des services CRUD, 
exécution de requêtes nommées, et validation par des tests unitaires. L'application démontre la puissance d'Hibernate pour la persistance 
des données et la gestion des relations objet-relationnel.




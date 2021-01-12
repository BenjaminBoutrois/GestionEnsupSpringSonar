# gestionWebService V2

Webservice Restful contenant le dao du projet GestionEnsup

## Prérequis

- JDK 8
- Maven 3.6.3
- Apache Tomcat 9 configuré sur le port 8080
- L'identifiant de la base de données doit être "root" et le mot de passe doit être "" (vide).

## Installation

1. Cloner le dépôt
2. A la racine du projet, ouvrir un invite de commande et taper l'instruction `mvn clean package` pour compiler le projet
3. Une fois compilé, copier le fichier `gestionWebServiceV2\web\target\web.war` dans le dossier **webapps** du serveur Tomcat
4. Lancer le serveur Tomcat pour déployer le projet sur le serveur
5. Au niveau du serveur de base de données, importer le fichier **jpagestionensup.sql**
6. Ouvrir un navigateur et entrer `http://127.0.0.1:8080/web` dans la barre d'URL pour accéder à l'application

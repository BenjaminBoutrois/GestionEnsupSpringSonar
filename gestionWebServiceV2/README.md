# gestionWebService V2

Webservice Restful contenant le dao du projet GestionEnsup

## Prérequis

- JDK 11
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

## Partie test

Nous avons utilisé la technologie JUnit et Mockito pour faire les tests de la couche WebService du projet GestionWebServiceV2.

**Junit:** Est un framework open source permettant des réaliser des tests sur du code Java. Le principe est de s'assurer que le code / fonction a le bon comportement même après une modification.

**Mockito:** S'utilise conjointement à JUnit. C'est un framework Java permettant de mocker / espionner des objets, simuler ainsi que vérifier des comportements ou encore simplifier l'écriture de tests unitaires. 

Chaque classe est composée de la même manière. 
1. Initialisons un mock (dans notre cas l'interface de la couche dao relative à la classe de la couche service testée) grâce à l'annotation @Mock
2. Injection du mock dans la classe service grâce à l'annotation @InjectMocks
3. Création d'une méthode d'initialisation du mock éxecutée avant toutes les méthodes de tests grâce à l'annotation @Before
4. Création de la couverture de test

**Méthodes de création de la couverture de test:**
1. Ecriture des différents scénarios de test
2. Création / écriture des méthodes de test
3. Création des méthodes de la classe ciblés par les test (dans notre cas la couche service était déjà faite)
4. Lancement des tests

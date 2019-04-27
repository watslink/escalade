	
		
		----------------------------------------------------------
		|                            Escalade OC 				 |
		----------------------------------------------------------

	+++++++ LANCEMENT DE L'APPLICATION ++++++++++

    Le projet packagé en .war est à déployé sur un serveur Tomcat 9:
    
    1- Packager le projet maven via votre IDE 
    2- Placer le fichier war dans le dossier tomcat/webapps/
    3- Lancer tomcat
    4- Entrer l'adresse dans votre navigateur
    5- Si vous utilisez les données de démos vous pouvez vous connecter pour n'importe quel pseudo 
    (ex: melissa.hamon) de la BDD démo avec le mot de passe : motdepasse, sinon crée un nouvel utilisateur en vous 
    inscrivant.
    
    Il est possible de déployé directement le war sur tomcat via votre IDE (configuration différentes selon IDE)
	
	+++++++ CONFIGURATION IDE ++++++++++
    
   	Le programme utiliste java 8
   	Projet Maven pour la gestion des dépendences 
	 
	   
    +++++++ CONFIGURATION  BASE DE DONNEES ++++++++++
    
    Base de donnée PostGreSQL 9
    
    Après création de votre base de donnée lancé les scripts dans l'ordre suivant:
    -creation BDD PostGreSQL.sql
    -donées démo BDD.sql
    
    Ces fichiers sont présent dans le dossier DB Scripts
	
	+++++++ CONNECTION BASE DE DONNEES ++++++++++
    	
    	Pour établir la connection à votre base de données,
    	le fichier database.porpeties présent dans le module escalade-consumer est à compléter:
    	driverClassName=
        url=
        user=
        password=


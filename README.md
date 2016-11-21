# Synopsis
Cette application permet de louer des sapins en ligne. Elle est divisée en 4 pages qui permettent de choisir le sapin désiré et de choisir les modalités de livraisons. 

# Outils utilisés
Cette application a été entièrement développée à l'aide de Java Server Faces(JSF). Nous avons utilisé l'outil de management de projet Maven pour la structure du projet.
L'application est divisée en 4 pages :
* Choix du sapin et des modalités de livraisons
* Saisie des informations personnels du clients
* Résumé de la commande
* Remerciement et nouvelle commande si l'utilisateur le souhaite

Différents aspects techniques de JSF ont été utilisés, notamment les beans avec différents Scoped (SessionScoped, RequestScoped). 
Le SessionScoped bean (OrderBean) nous a permis de persister une commande de sapin à la fin du processus de commande.
Nous avons également utilisé différents converter pour faire le lien entre nos données texte (String) et nos objets métiers.
Pour remplir au mieux l'aspect métier, nous avons également ajouté des validations lors des saisies utilisateurs, en effet il n'est par exemple pas possible de rentrer un nom de famille avec des chiffres :

`<f:validateRegex pattern="^\D*$"/>
`
Nous avons décidé, car cela avait plus de sens pour nous au niveau métier, de réafficher la page de saisie des informations personnels de l'utilisateur lorsque le même client voulait refaire une commande en lui permettant de modifier les valeurs saisies auparavant. 
En effet, il se peut que le même client souhaite commander un nouveau sapin mais ne souhaite pas se le faire livrer à l'adresse précèdemment indiquée.

# Contributeurs
Cette application a été réalisé par :
* Benjamin Boldt (https://github.com/bpeab)
* Dimitri Mella (https://github.com/Dim8672)

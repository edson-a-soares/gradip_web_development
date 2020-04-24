## JEE Webapp

There is no **src/main/webapp** folder because it will be automatic generated with the frontend application bundled, 
minified, and uglified before the backend Java application **package** phase and deleted on the **clean** phase. 
Database will be available after Docker containers initialization. You just need to create the Tables and that's easy with migrations.

To make the application available just do as follows:

1. [x] Application compilation, building, and packaging:  
	- ```mvn install```
2. [x] Infrastructure (tomcat & postgres)
	- ```docker-compose up database webapp -d```
	2. Data Scheme (tables):  
		- ```mvn initialize sql:execute@create-changelog-table -Ddatabase.tasks.skip=false```
        - ```mvn initialize dbdeploy:update```
		- ```mvn initialize sql:execute@load-sample-data -Ddatabase.tasks.skip=false```  
3. [Open the application on your browser.](http://localhost:8080/gradip-jee-webapp)

****
#### Data Access

If you want to follow straight on **Postgres**, you can use **PgAdmin**.  

 - ```docker-compose up pgamin -d```

###### PgAdmin  
 - [PgAdmin4 Address](http://localhost:5050)   
 - **username**: pgadmin4@pgadmin.org  
 - **password**: admin  

###### Database Info
 - **Port**: 5432  
 - **Host**: database  
 - **Password**: postgres  
 - **Username**: database_manager  
 - **Database**: books_management  

****
#### Maven Goals

Maven goals (specific tasks) for applying data migrations:

 - ```mvn initialize dbdeploy:update```

Other Maven goals for database tasks:

  :	```mvn initialize [specific goal] -Ddatabase.tasks.skip=false```

 - ```sql:execute@drop-tables```
 - ```sql:execute@truncate-tables```
 - ```sql:execute@load-sample-data```
 - ```sql:execute@create-changelog-table```

Other Maven goals for frontend tasks:

- ```mvn frontend:install-node-and-npm@nodejs-and-npm```
- ```mvn frontend:npm@install-dependencies```
- ```mvn frontend:gulp@execute-build```

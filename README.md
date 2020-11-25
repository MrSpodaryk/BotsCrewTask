# BotsCrewTask
# Description

That project is console programs which use Spring and Hibernate for communicate with database. 

Also it has MVC patern structure. 


# Usage

1. Download project from git hub

```git clone https://github.com/MrSpodaryk/BotsCrewTask.git```

2. In application.yaml(src/main/resources) change ```<user>``` and ```<password>``` to your own mysql username and password.

3. Run mysql server : ```mysql.server start``` in your terminal/console

4. Then you have two options:
1) Run BotsCrewDB.sql script and after that insert.sql script. 
2) In application.yml(src/main/resources) set the ```ddl-auto: create```, start program (paragraph 5) and after that run insert.sql script. 
To save data set ```ddl-auto: update``` before you will start a program in the next time.

5. Open and run BotsCrewTaskApplication.java file.

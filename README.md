# LM-DS

**First Window :**
```
cd C:\'Program Files'\MongoDB\server\7.0\bin 
.\mongod
```

**Login to admin**
```
mongosh --host localhost -u myUserAdmin -p password --authenticationDatabase admin test <br />
```

**Change db**
```
use admin 
```

**Show logged in user**
```
db.runCommand({connectionStatus : 1}) 
```


**Enter databse - no login**
```
mongosh --port 27017 
```

**Mongo admin user**
```
user: myUserAdmin 
password: password 
```


**MongoDB Notes:**

> Springboot is currently using the 'test' collection automatically


-------------------------------------------SECURITY LOGIN-----------------------------------

**Create Roles for Application**
```
db.roles.insertMany([
   { name: "ROLE_USER" },
   { name: "ROLE_MODERATOR" },
   { name: "ROLE_ADMIN" },
])
```

**csrf tokens**
> https://www.baeldung.com/spring-security-csrf


**Mock bank API**
https://docs.yapily.com/pages/getting-started/get-started/
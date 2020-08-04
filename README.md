# RIT_back-end
Application consist of 7 microservices and Docker-compose file for running all applications easily on your computer.
------------------------------------------------------------------------
					HOW TO RUN APPLICATION
------------------------------------------------------------------------
You can run services manually on your computer or by docker-comose file.
1)Run on your computer:
run naming server,zuul-api gateway and all microservices and can check it -  localhost:8765/serviceName/api
2)Run by docker-compose:
You must have docker desktop running on your computer.
docker-compose up -d    -run all containers
docker ps  -for looking runned containers
docker down - stop all running containers
------------------------------------------------------------------------
					DATABASE INFORMATION-MYSQL
------------------------------------------------------------------------
1)Run on your computer:

username= root
password=123456
host=localhost
port=3306

2)Run on docker

username= root
password=root123
host=localhost
port=23306
------------------------------------------------------------------------
For getting security token use api below:
POST method

localhost:18765/login

BODY:
	1)for ROLE_ADMIN
{
    "username":"suzy",
    "password":"123"
}
***************************************
2)for ROLE_DIRECTOR
{
    "username":"ruqiyya",
    "password":"12345"
}

3)for ROLE_EMPLOYEE

{
    "username":"nurlan",
    "password":"1234"
}
-------------------------------------------------------------------------
								PERMISSIONS 
-------------------------------------------------------------------------

We have dynamic permission for roles.When you send request in header part add
 Key:Action   Value: permission from below(ex confirmLoaner)

1, 'getForLoaner', 'ROLE_ADMIN'
2, 'getAll', 'ROLE_ADMIN'
3, 'getActiveLoaners', 'ROLE_DIRECTOR'
5, 'confirmLoaner', 'ROLE_DIRECTOR'
6, 'sendConfirmedData', 'ROLE_DIRECTOR'
7, 'getAllData', 'ROLE_DIRECTOR'
8, 'getAllData', 'ROLE_EMPLOYEE'
9, 'getAll', 'ROLE_EMPLOYEE'
10, 'sendConfirmedData', 'ROLE_EMPLOYEE'
11, 'getActiveLoaners', 'ROLE_EMPLOYEE'
12, 'createLoaner', 'ROLE_EMPLOYEE'
13, 'getForLoaner', 'ROLE_EMPLOYEE'
-------------------------------------------------------------------------
						REQUESTED REST API's
-------------------------------------------------------------------------
The bank employee enters the amount and payment term into the system and obtains the list.

POST method:localhost:4848/getAllData
Body:
{
    
    "amount":5000,
    "monthlyTerm":10
}

the bank employee sends the information to his / her management for approval.
POST method: localhost:3838/createLoaner
Body
{
    
    "amount":5000,
    "idCustomer":1
}

 Management sees and approves the list of clients sent for approval.
 GET mthod: localhost:3838/confirmLoaner/1


Sending information via SMS or mail after the manager confirms the information.

POST method: localhost:3838/sendConfirmedData
Body:
{
    "users":[
        {
        "id":1,
        "isAccept":0
    },

 {
        "id":1,
        "isAccept":0
    },
     {
        "id":1,
        "isAccept":0
    },
       { "id":2,
        "isAccept":0
    },

       { "id":3,
        "isAccept":0
    }
],

    
    "message":"Salam hormetli Mushteri",
    "sendWay":1


}


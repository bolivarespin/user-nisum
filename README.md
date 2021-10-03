# user-nisum

Api REST para crear usuarios utilizando un objeto JSON como entrada de datos, con la siguiente estructura de campo:

{
"name": "Juan Rodriguez",
"email": "juan@rodriguez.ar",
"password": "Hunter22",
"phones": [
        {
        "number": "1234567",
        "citycode": "1",
        "countrycode": "57"
        }
    ]
}

Se encuentra desarrollada con Spring boot con H2.

Los endpoints son los siguientes:

POST: /users
GET : /users
GET : /users/{id}


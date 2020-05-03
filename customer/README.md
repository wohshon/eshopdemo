### Run demo

mvn -Ddb_password=xxxx -Ddb_user=xxxx -Djpa_mode=create clean spring-boot:run

`curl -X POST -d@test.json -H "Content-type:application/json" localhost:8080/register`

```
{
 "id": 12345,
 "name": "test",
 "email": "acme@gmail.com",
 "phone": "+6512345678"
}


```

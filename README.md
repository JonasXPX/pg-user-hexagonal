## PG user Application Hexagonal Architecture
Hexagonal project example

<img src="https://i.imgur.com/D3JoUhg.png"/>

#### Running the application with Docker
Clone repository ``git clone https://github.com/JonasXPX/pg-user-hexagonal.git ``

Deploy with
`` docker-compose up ``

#### Test the application

Register a user
````shell
curl --request POST \
  --url http://localhost:8080/pg-user \
  --header 'Content-Type: application/json' \
  --data '{
	"id": null,
	"name": "test"
}'
````

List the users
````shell
curl --request GET \
  --url http://localhost:8080/pg-user
````

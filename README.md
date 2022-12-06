# Code Challenge

## Tech stack:
- kotlin
- Spring boot
- H2 in memory data base
- Junit library for unit testing

## How to test

### Register a new Film
In order to create a film call the ``POST`` endpoint with following payload
``http://localhost:8090/filmService/registerNewFilm``
payload:
```
{
	"title":"test2",
	"vote":"10",
	"release":"2022-09-23",
	"stars":"3"
}
```


### get created film
In order to get a film call the ``GET`` endpoint with following payload
``http://localhost:8090/filmService/find/test/title``


#### Note
I assumed that title plays unique key in film entity

### Update
In order to get a film call the ``PUT`` endpoint with following payload
``http://localhost:8090/filmService/updateFilm``
```
{
	"title":"test2",
	"vote":"15",
	"release":"2022-09-23",
	"stars":"3"
}
```

### delete created film
In order to delete a film call the ``DELETE`` endpoint with following payload
``http://localhost:8090/filmService/deleteFilm/test/title``

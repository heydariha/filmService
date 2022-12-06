package com.hadi.kotlin.domain

fun assembleFilm(filmDto: FilmDto): Film = Film(
  id = 0,
  title = filmDto.title,
  vote = filmDto.vote,
  release = filmDto.release,
  stars = filmDto.stars
)

fun assembleFilmDto(film: Film): FilmDto = FilmDto(
    title = film.title,
    vote = film.vote,
    release = film.release,
    stars = film.stars
)

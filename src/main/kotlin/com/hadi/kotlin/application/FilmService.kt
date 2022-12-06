package com.hadi.kotlin.application

import com.hadi.kotlin.domain.FilmDto

interface FilmService {
  fun registerNewFilm(filmDto: FilmDto): FilmDto
  fun listFilms(): List<FilmDto>
  fun findFilm(filmDto: String): FilmDto
  fun updateFilm(filmDto: FilmDto): FilmDto
  fun deleteFilm(filmDto: String): FilmDto
}

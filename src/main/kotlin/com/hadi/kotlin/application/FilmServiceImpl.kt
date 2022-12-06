package com.hadi.kotlin.application

import com.hadi.kotlin.config.DuplicateException
import com.hadi.kotlin.config.NotFoundException
import com.hadi.kotlin.domain.*
import com.hadi.kotlin.infrastructure.FilmRepository
import org.springframework.stereotype.Component

@Component
class FilmServiceImpl(val filmRepository: FilmRepository) :
  FilmService {

  override fun listFilms(): List<FilmDto> {
    return filmRepository.findAll().map {
      assembleFilmDto(it)
    }
  }

  override fun registerNewFilm(filmDto: FilmDto): FilmDto {
    try {
      val newfilm = filmRepository.save(assembleFilm(filmDto))
      return assembleFilmDto(newfilm)
    }catch (e: Exception) {
      throw DuplicateException(
        message = "Film title is duplicated",
        detailMessage = "Film with title : ${filmDto.title} is already exists"
      )
    }

  }

  override fun findFilm(title: String): FilmDto {
    return try {
      assembleFilmDto(filmRepository.findByTitle(title))
    } catch (e: Exception) {
      throw NotFoundException(
        message = "Film not found",
        detailMessage = "Film with title : $title not found"
      )
    }
  }

  override fun updateFilm(filmDto: FilmDto): FilmDto {
    val film = filmRepository.findByTitle(filmDto.title)
    film.release = filmDto.release
    film.vote = filmDto.vote
    film.stars = filmDto.stars
    val updatedFilm = filmRepository.save(film)
    return assembleFilmDto(updatedFilm)
  }

  override fun deleteFilm(filmTitle: String): FilmDto {
    val film = filmRepository.findByTitle(filmTitle)
    filmRepository.delete(film)
    return assembleFilmDto(film)
  }

}

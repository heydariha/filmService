package com.hadi.kotlin.controller

import com.hadi.kotlin.application.FilmService
import com.hadi.kotlin.domain.FilmDto
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.web.bind.annotation.*
import java.time.LocalDate
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/filmService")
class ChallengeCodeWsV1Impl(val filmService: FilmService) {

  @PostMapping("/registerNewFilm")
  fun registerFilm(@RequestBody @Valid filmDto: FilmDto): FilmDto {
    return filmService.registerNewFilm(filmDto)
  }

  @GetMapping("/listAllFilms")
  fun listFilms(): List<FilmDto> {
    return filmService.listFilms()
  }

  @GetMapping("/find/{filmTitle}/title")
  fun findFilm(@PathVariable filmTitle: String): FilmDto {
    return filmService.findFilm(filmTitle)
  }

  @PutMapping("/updateFilm")
  fun updateFilm(@RequestBody @Valid filmDto: FilmDto): FilmDto {
    return filmService.updateFilm(filmDto)
  }

  @DeleteMapping("/deleteFilm/{filmTitle}/title")
  fun deleteFilm(@PathVariable filmTitle: String): FilmDto {
    return filmService.deleteFilm(filmTitle)
  }
}

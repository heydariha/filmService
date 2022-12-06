package com.hadi.kotlin.application

import com.hadi.kotlin.infrastructure.FilmRepository
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class FilmServiceImplTest {

  @Autowired
  lateinit var filmService: FilmService

  @Autowired
  lateinit var filmRepository: FilmRepository


  @Test
  fun `create film test should create two new policies`() {
    //GIVEN
    val film = filmDtoTemplate()
    filmService.registerNewFilm(film)

    //WHEN
    val savedFilm = filmRepository.findByTitle(film.title)

    //THEN
    assertTrue(film.equals(savedFilm))
  }

  @Test
  fun `update film test should create two new policies`() {
    //GIVEN
    val film = filmDtoTemplate()
    filmService.registerNewFilm(film)
    filmService.updateFilm(filmDtoTemplate(vote = 15))

    //WHEN
    val savedFilm = filmRepository.findByTitle(film.title)

    //THEN
    assertTrue(savedFilm.vote == 15)
  }



}

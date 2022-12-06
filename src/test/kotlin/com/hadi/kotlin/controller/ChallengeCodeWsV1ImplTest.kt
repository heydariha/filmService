package com.hadi.kotlin.application

import com.hadi.kotlin.domain.FilmDto
import com.hadi.kotlin.infrastructure.FilmRepository
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class ChallengeCodeWsV1ImplTest {

  @Autowired
  lateinit var filmService: FilmService

  @Autowired
  lateinit var filmRepository: FilmRepository

  @Autowired
  lateinit var restTemplate: TestRestTemplate

  val basePath = "/filmService"

  @Test
  fun `register a new film test should create two a new record in DB`() {
    //GIVEN
    val filmDtoTemplate = filmDtoTemplate()

    //WHEN
    val baseFilm = restTemplate.postForEntity("$basePath/registerNewFilm", filmDtoTemplate, FilmDto::class.java)

    //THEN
    assertTrue(filmDtoTemplate.title.equals(baseFilm.body?.title))
  }

  @Test
  fun `find a film test should return all film records in DB`() {
    //GIVEN
    val filmDtoTemplate = filmDtoTemplate(title = "test2")
    restTemplate.postForEntity("$basePath/registerNewFilm", filmDtoTemplate, FilmDto::class.java)

    //WHEN
    val baseFilm = restTemplate.getForEntity("$basePath/find/${filmDtoTemplate.title}/title", FilmDto::class.java)

    //THEN
    assertTrue(filmDtoTemplate.title.equals(baseFilm.body?.title))
  }

  @Test
  fun `find all films test should return all film records in DB`() {
    //GIVEN
    restTemplate.postForEntity("$basePath/registerNewFilm", filmDtoTemplate(title = "test3"), FilmDto::class.java)
    restTemplate.postForEntity("$basePath/registerNewFilm", filmDtoTemplate(title = "test4"), FilmDto::class.java)

    //WHEN
    val returnedFilms = restTemplate.getForEntity("$basePath/listAllFilms", List::class.java)

    //THEN
    assertTrue(returnedFilms.statusCode.is2xxSuccessful)
    assertTrue(returnedFilms.body!!.size >= 2)
  }

}

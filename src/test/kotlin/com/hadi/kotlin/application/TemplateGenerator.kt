package com.hadi.kotlin.application

import com.hadi.kotlin.domain.FilmDto
import java.time.LocalDate


fun filmDtoTemplate(title : String = "test", vote : Int = 10): FilmDto = FilmDto(
  title = title,
  vote = vote,
  release = LocalDate.now(),
  stars = 3
)


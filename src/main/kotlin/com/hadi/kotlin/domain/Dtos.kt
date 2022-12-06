package com.hadi.kotlin.domain

import com.fasterxml.jackson.annotation.JsonFormat
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*
import javax.validation.constraints.NotNull

data class FilmDto (
  @NotNull val title: String,
  @NotNull var vote: Int,
  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  @NotNull var release : LocalDate,
  @NotNull var stars: Int,
)

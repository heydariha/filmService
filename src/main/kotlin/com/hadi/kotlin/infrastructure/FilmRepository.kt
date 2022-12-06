package com.hadi.kotlin.infrastructure

import com.hadi.kotlin.domain.Film
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDate
import java.util.*

interface FilmRepository : JpaRepository<Film, Long> {
    fun findByTitle(title: String): Film
}

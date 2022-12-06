package com.hadi.kotlin.domain

import java.time.LocalDate
import javax.persistence.*

@Entity
data class Film(
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long,
  @Column(unique = true) var title: String,
  var vote: Int,
  var release: LocalDate,
  var stars: Int
)


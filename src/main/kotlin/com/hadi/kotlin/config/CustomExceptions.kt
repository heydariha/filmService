package com.hadi.kotlin.config

class NotFoundException(
    override val message: String,
    val detailMessage: String?
) : RuntimeException()

class DuplicateException(
  override val message: String,
  val detailMessage: String?
) : RuntimeException()

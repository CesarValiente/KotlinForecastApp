package com.cesarvaliente.kotlinforecastapp.domain.commands

interface Command<out T> {
    fun execute(): T
}
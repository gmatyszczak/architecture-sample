package pl.gmat.architecture.core

sealed class Action {
    object Init : Action()

    abstract class Feature: Action()
}
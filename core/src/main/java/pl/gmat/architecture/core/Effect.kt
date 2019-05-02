package pl.gmat.architecture.core

abstract class Effect {

    private var hasBeenHandled = false

    fun handleIfNotHandled(function: () -> Unit) {
        if (!hasBeenHandled) {
            hasBeenHandled = true
            function()
        }
    }
}
package com.udacity.gamedev.gigagal

import com.badlogic.gdx.Game

class GigalGalGame: Game() {
    override fun create() = setScreen(GameplayScreen())
}

package com.udacity.gamedev.ninepatch

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.NinePatch
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.viewport.FitViewport

class NinePatchDemo : ApplicationAdapter() {
	companion object {

		private val WORLD_SIZE = 100f
		private val EDGE = 8
		private val TEST_SIZE_1 = 20f
		private val TEST_SIZE_2 = 40f
	}

    lateinit var batch: SpriteBatch
    lateinit var viewport: FitViewport

    // TODO: Add a Texture for the raw platform image
    lateinit var platformTexture: Texture

    // TODO: Add a NinePatch
    lateinit var platformNinePatch: NinePatch

    override fun create() {
        batch = SpriteBatch()
        viewport = FitViewport(WORLD_SIZE, WORLD_SIZE)

        // TODO: Load the platform texture (Look for the file in android/assets)
		platformTexture = Texture("platform.png")

        // TODO: Initialize the NinePatch using the texture and the EDGE constant
		platformNinePatch = NinePatch(platformTexture, EDGE, EDGE, EDGE, EDGE)

    }

    override fun resize(width: Int, height: Int) {
        viewport.update(width, height, true)
    }

    override fun render() {
        viewport.apply()

        Gdx.gl.glClearColor(1f, 1f, 1f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        batch.projectionMatrix = viewport.camera.combined
        batch.begin()

		// TODO: Draw the platform texture at TEST_SIZE_1
		batch.draw(platformTexture,
				WORLD_SIZE * 1 / 4 - TEST_SIZE_1 / 2, WORLD_SIZE * 1 / 4 - TEST_SIZE_1 / 2,
				TEST_SIZE_1, TEST_SIZE_1)

		// TODO: Draw the platform texture at TEST_SIZE_2
		batch.draw(platformTexture,
				WORLD_SIZE * 3 / 4 - TEST_SIZE_2 / 2, WORLD_SIZE * 1 / 4 - TEST_SIZE_2 / 2,
				TEST_SIZE_2, TEST_SIZE_2)

		// TODO: Draw the nine patch at TEST_SIZE_1
		platformNinePatch.draw(batch,
				WORLD_SIZE * 1 / 4 - TEST_SIZE_1 / 2, WORLD_SIZE * 3 / 4 - TEST_SIZE_1 / 2,
				TEST_SIZE_1, TEST_SIZE_1)

		// TODO: Draw the nine patch at TEST_SIZE_2
		platformNinePatch.draw(batch,
				WORLD_SIZE * 3 / 4 - TEST_SIZE_2 / 2, WORLD_SIZE * 3 / 4 - TEST_SIZE_2 / 2,
				TEST_SIZE_2, TEST_SIZE_2)


		batch.end()
    }

    override fun dispose() {
        batch.dispose()
        // TODO: Dispose of the texture


    }


}
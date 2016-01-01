package com.udacity.gamedev.textureatlas

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.assets.AssetDescriptor
import com.badlogic.gdx.assets.AssetErrorListener
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.graphics.g2d.TextureRegion

class TextureAtlasExercise : ApplicationAdapter(), AssetErrorListener {
    companion object {
        private val TAG = TextureAtlasExercise::class.java.name

        private val ATLAS = "images/gigagal.pack.atlas"
        private val STANDING_RIGHT = "standing-right"
    }

    // TODO: Add an AssetManager
    private lateinit var assetManager: AssetManager


    private lateinit var batch: SpriteBatch

    // TODO: Add an AtlasRegion to hold the standing right sprite
    var standingRight: TextureAtlas.AtlasRegion? = null


    override fun create() {
        batch = SpriteBatch()


        // TODO: Initialize your AssetManager
        assetManager = AssetManager()
        // TODO: Set this as the AssetManager's error listener
        assetManager.setErrorListener(this)

        // TODO: tell the AssetManager to load the TextureAtlas with name ATLAS
        assetManager.load(ATLAS, TextureAtlas::class.java)

        // TODO: Call finishLoading() on your AssetManager
        assetManager.finishLoading()

        // TODO: Get the TextureAtlas from the asset manager
        val atlas = assetManager.get<TextureAtlas>(ATLAS)


        // TODO: Populate your AtlasRegion using findRegion() on your Atlas
        standingRight = atlas.findRegion(STANDING_RIGHT)

    }

    override fun render() {
        Gdx.gl.glClearColor(1f, 1f, 1f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        batch.begin()


        // TODO: Draw the standing right AtlasRegion
        // Hint, you need to use the somewhat horrific version of draw with signature:
        // draw (Texture texture, float x, float y, float originX, float originY, float width, float height, float scaleX,
        // float scaleY, float rotation, int srcX, int srcY, int srcWidth, int srcHeight, boolean flipX, boolean flipY)
        batch.draw(
                standingRight!!.texture,
                0f,
                0f,
                0f,
                0f,
                standingRight!!.regionWidth.toFloat(),
                standingRight!!.regionHeight.toFloat(),
                1f,
                1f,
                0f,
                standingRight!!.regionX,
                standingRight!!.regionY,
                standingRight!!.regionWidth,
                standingRight!!.regionHeight,
                false,
                false)

        batch.end()
    }

    override fun error(asset: AssetDescriptor<Any>, throwable: Throwable) {
        Gdx.app.error(TAG, "Couldn't load asset: " + asset.fileName, throwable)
    }

    override fun dispose() {
        batch.dispose()
        // TODO: Dispose of the AssetManager
        assetManager.dispose()
    }


}

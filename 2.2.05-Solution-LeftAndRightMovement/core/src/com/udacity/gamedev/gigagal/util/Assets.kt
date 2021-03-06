package com.udacity.gamedev.gigagal.util

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.utils.Disposable

object Assets : Disposable {
    var TAG = Assets::class.java.toString()

    lateinit var gigaGalAssets:GigaGalAssets
    lateinit private var assetManager:AssetManager

    fun init() {
        this.assetManager = AssetManager()
        with(assetManager) {
            setErrorListener { asset, throwable -> Gdx.app.error(TAG, "Couldn't load asset: " + asset.fileName, throwable) }
            load(Constants.TEXTURE_ATLAS, TextureAtlas::class.java)
            finishLoading()
        }
        val atlas = assetManager.get<TextureAtlas>(Constants.TEXTURE_ATLAS)
        gigaGalAssets = GigaGalAssets(atlas)
    }

    override fun dispose() {
        assetManager.dispose()
    }

    class GigaGalAssets(atlas: TextureAtlas) {

        // TODO: Add a AtlasRegion to hold the standing-right sprite
        val standingRight: TextureRegion

        init {
            // TODO: Use atlas.findRegion() to initialize the standing right AtlasRegion
            standingRight = atlas.findRegion(Constants.STANDING_RIGHT)
        }
    }
}

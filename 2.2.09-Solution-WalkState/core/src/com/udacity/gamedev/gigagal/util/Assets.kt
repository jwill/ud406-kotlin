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

        val standingRight: TextureRegion
        val standingLeft: TextureRegion
        val jumpingRight: TextureRegion
        val jumpingLeft: TextureRegion

        // TODO: Add AtlasRegions (or TextureRegions) for walkingRight and walkingLeft sprites
        val walkingRight: TextureRegion
        val walkingLeft: TextureRegion

        init {
            standingRight = atlas.findRegion(Constants.STANDING_RIGHT)
            standingLeft = atlas.findRegion(Constants.STANDING_LEFT)
            jumpingRight = atlas.findRegion(Constants.JUMPING_RIGHT)
            jumpingLeft = atlas.findRegion(Constants.JUMPING_LEFT)

            // TODO: Find walkingRight and walkingLeft regions
            walkingRight = atlas.findRegion(Constants.WALKING_RIGHT)
            walkingLeft = atlas.findRegion(Constants.WALKING_LEFT)
        }
    }
}

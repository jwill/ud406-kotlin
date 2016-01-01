package com.udacity.gamedev.gigagal.util

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.assets.AssetDescriptor
import com.badlogic.gdx.assets.AssetErrorListener
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.utils.Disposable
import com.udacity.gamedev.gigagal.entities.GigaGal

/**
 * TODO: Check out how the Assets singleton works
 *
 * This utility class holds onto all the assets used in GigaGal. It's a singleton, so the
 * constructor is private, and a single instance is created when the class is loaded. That way all
 * the entities that make up GigaGal can access their sprites in the same place, and no work loading
 * up textures is repeated.
 *
 * Each entity gets its own inner class to hold its assets. Below you'll complete the GigaGalAssets
 * class by finding up the standing-right AtlasRegion within the TextureAtlas loaded in init() .
 */

object Assets : Disposable {
    var TAG = Assets::class.java.toString()

    var gigaGalAssets:GigaGalAssets
    private var assetManager:AssetManager

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

        init {
            // TODO: Use atlas.findRegion() to initialize the standing right AtlasRegion
        }
    }
}

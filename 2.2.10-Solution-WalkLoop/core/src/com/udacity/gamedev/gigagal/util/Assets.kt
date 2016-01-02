package com.udacity.gamedev.gigagal.util

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.g2d.Animation
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.utils.Disposable
import com.badlogic.gdx.utils.Array

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
        val walkingRight: TextureRegion
        val walkingLeft: TextureRegion

        // TODO: Add animations for walking left and walking right
        val walkingLeftAnimation:Animation
        val walkingRightAnimation:Animation

        init {
            standingRight = atlas.findRegion(Constants.STANDING_RIGHT)
            standingLeft = atlas.findRegion(Constants.STANDING_LEFT)
            jumpingRight = atlas.findRegion(Constants.JUMPING_RIGHT)
            jumpingLeft = atlas.findRegion(Constants.JUMPING_LEFT)

            walkingRight = atlas.findRegion(Constants.WALKING_RIGHT_2)
            walkingLeft = atlas.findRegion(Constants.WALKING_LEFT_2)

            // TODO: Create the walking left animation
            // TODO: Add the proper frames to the animation
            walkingLeftAnimation = Animation(Constants.WALK_LOOP_DURATION,
                            atlas.findRegion(Constants.WALKING_LEFT_2),
                            atlas.findRegion(Constants.WALKING_LEFT_1),
                            atlas.findRegion(Constants.WALKING_LEFT_2),
                            atlas.findRegion(Constants.WALKING_LEFT_3) )
            walkingLeftAnimation.playMode = Animation.PlayMode.LOOP

            // TODO: Do the same with the walking right frames
            walkingRightAnimation = Animation(Constants.WALK_LOOP_DURATION,
                    atlas.findRegion(Constants.WALKING_RIGHT_2),
                    atlas.findRegion(Constants.WALKING_RIGHT_1),
                    atlas.findRegion(Constants.WALKING_RIGHT_2),
                    atlas.findRegion(Constants.WALKING_RIGHT_3) )
            walkingLeftAnimation.playMode = Animation.PlayMode.LOOP
        }
    }
}
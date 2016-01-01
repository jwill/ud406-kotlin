package com.udacity.gamedev.animations

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Animation
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.utils.Array
import com.badlogic.gdx.utils.DelayedRemovalArray
import com.badlogic.gdx.utils.TimeUtils
import com.badlogic.gdx.utils.viewport.ExtendViewport

class Animations : ApplicationAdapter() {
	companion object {
		private val EXPLOSION_SPAWN_RATE = 20f
		private val EXPLOSION_FRAME_DURATION = 0.1f

		private val WALK_LOOP_FRAME_DURATION = 0.1f
	}

    lateinit var batch: SpriteBatch
    lateinit var viewport: ExtendViewport

    lateinit var walkLoop: Animation
    var startTime: Long = 0

    lateinit var explosion: Animation
	lateinit var explosions: DelayedRemovalArray<OneShotAnimation>

    override fun create() {
        batch = SpriteBatch()
        viewport = ExtendViewport(100f, 100f)

        // TODO: Set startTime using TimeUtils.nanoTime()
		startTime = TimeUtils.nanoTime()


        val walkLoopTextures = Array<TextureRegion>()

        // TODO: Add walk-1-right.png to walkLoopTextures
		walkLoopTextures.add(TextureRegion(Texture("walk-1-right.png")))


        // TODO: Add walk-2-right.png to walkLoopTextures
		walkLoopTextures.add(TextureRegion(Texture("walk-2-right.png")))

        // TODO: Add walk-3-right.png to walkLoopTextures
		walkLoopTextures.add(TextureRegion(Texture("walk-3-right.png")))

        // TODO: Initialize walkLoop with a new animation in LOOP_PINGPONG mode
        // Use WALK_LOOP_FRAME_DURATION
		walkLoop = Animation(WALK_LOOP_FRAME_DURATION, walkLoopTextures, PlayMode.LOOP_PINGPONG)

        val explosionTextures = Array<TextureRegion>()
        explosionTextures.add(TextureRegion(Texture("explosion-large.png")))
        explosionTextures.add(TextureRegion(Texture("explosion-medium.png")))
        explosionTextures.add(TextureRegion(Texture("explosion-small.png")))
        explosion = Animation(EXPLOSION_FRAME_DURATION, explosionTextures, PlayMode.NORMAL)
        explosions = DelayedRemovalArray<OneShotAnimation>()

    }

    override fun resize(width: Int, height: Int) {
        viewport.update(width, height, true)
    }

    override fun render() {
        updateExplosions()
        viewport.apply()
        Gdx.gl.glClearColor(1f, 1f, 1f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        batch.projectionMatrix = viewport.camera.combined
        batch.begin()

        // TODO: Compute the elapsed time in seconds since startTime
        val elapsedTime = MathUtils.nanoToSec * (TimeUtils.nanoTime() - startTime)

        // TODO: User getKeyFrame() to get the right frame from the walk loop
        val walkLoopTexture = walkLoop.getKeyFrame(elapsedTime)

        drawRegionCentered(
                batch,
                walkLoopTexture,
                viewport.worldWidth / 2,
                viewport.worldHeight / 2)

        for (explosion in explosions) {
            drawRegionCentered(batch, explosion.frame, explosion.position.x, explosion.position.y)
        }

        batch.end()
    }

    private fun drawRegionCentered(batch: SpriteBatch, region: TextureRegion, x: Float, y: Float) {
        batch.draw(
                region.texture,
                x - region.regionWidth / 2,
                y - region.regionHeight / 2,
                0f,
                0f,
                region.regionWidth.toFloat(),
                region.regionHeight.toFloat(),
                1f,
                1f,
                0f,
                region.regionX,
                region.regionY,
                region.regionWidth,
                region.regionHeight,
                false,
                false)
    }

    private fun updateExplosions() {

        // Remove explosions that are done
        explosions.begin()
        for (i in 0..explosions.size - 1) {
            if (explosions.get(i).isAnimationFinished) {
                explosions.removeIndex(i)
            }
        }
        explosions.end()

        // Randomly spawn a new explosion
        if (MathUtils.random() < Gdx.graphics.deltaTime * EXPLOSION_SPAWN_RATE) {
            val position = Vector2(
                    MathUtils.random(viewport.worldWidth),
                    MathUtils.random(viewport.worldWidth))
            explosions.add(OneShotAnimation(explosion, position, TimeUtils.nanoTime()))
        }
    }


	inner class OneShotAnimation(private val animation: Animation, val position: Vector2, private val startTimeNanos: Long) {

        private fun elapsedTime(): Float {
            return MathUtils.nanoToSec * (TimeUtils.nanoTime() - startTimeNanos)
        }

        val frame: TextureRegion
            get() = animation.getKeyFrame(elapsedTime())

        val isAnimationFinished: Boolean
            get() = animation.isAnimationFinished(elapsedTime())


    }


}

package com.udacity.gamedev.fileloading

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import org.apache.commons.codec.binary.Base64

import java.security.Key

import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec


class FileLoading : ApplicationAdapter() {

    lateinit var batch: SpriteBatch
    lateinit var img: Texture

    override fun create() {
        batch = SpriteBatch()
        img = Texture("badlogic.jpg")


        Gdx.app.log(TAG, "How does GigaGal tie her shoelaces when her arms are cannons?")

        // TODO: Go find the text file in the android/assets directory
        // TODO: Get a FileHandle using Gdx.files.internal()
        val file = Gdx.files.internal("punchline.txt")


        // TODO: Read the file using FileHandle.readString()
        val fileContents = file.readString()


        // TODO: Decrypt the punchline
        val decryptedString = decrypt(fileContents)


        // TODO: Log the rest of the joke
        Gdx.app.log(TAG, decryptedString)

    }

    override fun render() {
        Gdx.gl.glClearColor(1f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        batch.begin()
        batch.draw(img, 0f, 0f)
        batch.end()
    }

    companion object {

        val TAG = FileLoading::class.java.name

        private val key = SecretKeySpec("secretKey1234567".toByteArray(), "AES")

        fun encrypt(message: String): String {
            try {
                val cipher = Cipher.getInstance("AES")
                cipher.init(Cipher.ENCRYPT_MODE, key)
                val encryptedBytes = cipher.doFinal(message.toByteArray())
                return Base64.encodeBase64String(encryptedBytes)
            } catch (e: Exception) {
                Gdx.app.error(TAG, "Couldn't encrypt message: " + message, e)
            }

            return "Failed"
        }

        fun decrypt(encrypted: String): String {
            try {
                val cipher = Cipher.getInstance("AES")
                cipher.init(Cipher.DECRYPT_MODE, key)
                val encryptedBytes = Base64.decodeBase64(encrypted)
                return String(cipher.doFinal(encryptedBytes))
            } catch (e: Exception) {
                Gdx.app.error(TAG, "Couldn't decrypt message: " + encrypted, e)
            }

            return "Failed"
        }
    }

}

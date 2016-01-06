package com.udacity.gamedev.gigagal.util

import com.badlogic.gdx.Gdx
import com.udacity.gamedev.gigagal.Level
import com.udacity.gamedev.gigagal.entities.Platform
import org.json.simple.JSONArray
import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser
import java.io.File
import java.io.FileReader


// This should be static
object LevelLoader {
    val TAG = LevelLoader::class.java.toString()

    val platformBaseHeight = 50f
    val platformBaseWidth = 50f

    fun load(path:String) : Level {
        var level = Level()
        var file = Gdx.files.internal(path).file()

        var parser = JSONParser()
        var jsonObject = parser.parse(FileReader(file)) as JSONObject

        // Get the objects in the level

        var objectsArray = (jsonObject.get("composite") as JSONObject).get("sImages") as JSONArray

        for (item in objectsArray) {
            var o = item as JSONObject
            Gdx.app.log(TAG, o.toString())
            if (o.get("imageName")!!.equals("platform")) {

                level.platforms.add(loadPlatform(o))
            }
        }


        return level
    }

    fun loadPlatform(o: JSONObject) : Platform{
        Gdx.app.log(TAG, "Found a platform")
        var left:Number = 0.00
        var top:Number = 0.00
        var scaleX:Number = 1.00
        var scaleY:Number = 1.00

        if (o.get("x") != null)
            left = o.get("x") as Number

        if (o.get("y") != null)
            top = o.get("y") as Number

        if (o.get("scaleX") != null)
            scaleX = o.get("scaleX") as Number

        if (o.get("scaleY") != null)
            scaleY = o.get("scaleY") as Number


        val platform = Platform(left.toFloat() * 50f, top.toFloat() * 50f, platformBaseWidth * scaleX.toFloat(), platformBaseHeight * scaleY.toFloat())
        Gdx.app.log(TAG, platform.toString())
        return platform
    }


}

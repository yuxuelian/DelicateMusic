package com.kaibo.music.player.player.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.kaibo.music.player.IMusicPlayer
import com.kaibo.music.player.player.service.Constants
import com.orhanobut.logger.Logger

/**
 * @author kaibo
 * @date 2019/4/3 12:16
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：
 */

class PlayerCommandReceiver(private val iMusicPlayer: IMusicPlayer) : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Logger.d("PlayerCommandReceiver ----")
        handleCommandIntent(intent)
    }

    private fun handleCommandIntent(intent: Intent) {
        when (intent.action) {
            Constants.ACTION_NEXT -> {
                iMusicPlayer.next()
            }
            Constants.ACTION_PREV -> {
                iMusicPlayer.prev()
            }
            Constants.ACTION_CLOSE -> {
                // 点击了通知栏的关闭按钮
                iMusicPlayer.exit()
            }
            Constants.ACTION_LYRIC -> {
                // 点击了歌词按钮
                iMusicPlayer.showDesktopLyric()
            }
            Constants.ACTION_REPEAT -> {
                iMusicPlayer.updatePlayMode()
            }
            Constants.ACTION_PLAY_PAUSE -> {
                iMusicPlayer.togglePlayer()
            }
            Constants.ACTION_PLAY -> {
                iMusicPlayer.play()
            }
            Constants.ACTION_PAUSE -> {
                iMusicPlayer.pause()
            }
            Constants.ACTION_STOP -> {
                iMusicPlayer.stop()
            }
        }
    }
}
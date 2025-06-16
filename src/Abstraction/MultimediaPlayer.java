package Abstraction;

/*

Imagine one of your friends has designed a multimedia player application
that can play various types of media such as audio and video files.
Each type of media has specific functionalities, specified by the client company.
They want to ensure that the application can support different media formats
and be easily extendable for future enhancements.

To achieve this, he decided to use Java abstraction.
Then,he created concrete classes for different types of media, such as AudioPlayer and VideoPlayer,
Each of them extending the MediaPlayable abstract class.

 */

// the MediaPlayable abstract class

abstract class MediaPlayable {
    abstract void play();
    abstract void pause();
    abstract void stop();
    abstract void skip();

    // this class cannot be modified, only company has this access
}

// Your friends class starts from here
// Concrete class for AudioPlayer extending MediaPlayable
class AudioPlayer extends MediaPlayable {
    @Override
    public void play() {
        System.out.println("Audio playback started.");
    }

    @Override
    public void pause() {
        System.out.println("Audio playback paused.");
    }

    @Override
    public void stop() {
        System.out.println("Audio playback stopped.");
    }

    @Override
    public void skip() {
        System.out.println("Skipping forward in audio.");
    }

}

// Concrete class for VideoPlayer extending MediaPlayable
class VideoPlayer extends MediaPlayable{
    @Override
    public void play() {
        System.out.println("Video playback started.");
    }

    @Override
    public void pause() {
        System.out.println("Video playback paused.");
    }

    @Override
    public void stop() {
        System.out.println("Video playback stopped.");
    }

    @Override
    public void skip() {
        System.out.println("Skipping forward in video.");
    }
}


class AdvancePlayer extends MediaPlayable {

    @Override
    void play() {

    }

    @Override
    void pause() {

    }

    @Override
    void stop() {

    }

    @Override
    void skip() {

    }

}

public class MultimediaPlayer {

    public static void main(String[] args) {

        // Creating instances of AudioPlayer and VideoPlayer
        AudioPlayer audioPlayer = new AudioPlayer();
        VideoPlayer videoPlayer = new VideoPlayer();

        // Using methods from MediaPlayable abstract class
        audioPlayer.play();
        audioPlayer.pause();
        audioPlayer.stop();
        audioPlayer.skip();

        videoPlayer.play();
        videoPlayer.pause();
        videoPlayer.stop();
        videoPlayer.skip();

        /*
        However,he encountered a new requirement:
        the application should also support streaming media from online sources.

        And all the upcoming advance players will also have this streaming support.
        Modifications cannot be done in MediaPlayable class


         */

//        audioPlayer.startStreaming();
//        audioPlayer.stopStreaming();
//
//        videoPlayer.startStreaming();
//        videoPlayer.stopStreaming();
    }
}

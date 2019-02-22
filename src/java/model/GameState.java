package model;
/**
 * @author Adi
 */
public enum GameState {
    PLAYING, DRAW, CROSS_WON, NOUGHT_WON;
    
    public boolean isPlaying() {
        return this == PLAYING;
    }
}
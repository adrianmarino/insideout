package ar.com.movie.insideout.emotion;

import ar.com.movie.insideout.Memory;
import ar.com.movie.insideout.Riley;

public class SadEmotion extends Emotion {
  @Override
  public void settleTo(Riley riley, Memory memory) {
    riley.setHappinessLevel(riley.getHappinessLevel() * 0.9);
    riley.addThoughtCentral(memory);
  }
}

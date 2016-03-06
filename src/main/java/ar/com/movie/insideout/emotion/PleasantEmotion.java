package ar.com.movie.insideout.emotion;

import ar.com.movie.insideout.Memory;
import ar.com.movie.insideout.Riley;

public class PleasantEmotion extends Emotion {
  @Override
  public void settleTo(Riley riley, Memory memory) {
    riley.setHappinessLevel(800D);
    riley.addThoughtCentral(memory);
  }
}

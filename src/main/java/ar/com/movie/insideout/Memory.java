package ar.com.movie.insideout;

import ar.com.movie.insideout.emotion.Emotion;

import java.time.LocalDate;

public class Memory {

  public void settleTo(Riley riley) {
    emotion.settleTo(riley, this);
  }

  public boolean isComplex() {
    return description.length() > 10;
  }

  private final String description;

  private final LocalDate date;

  private final Emotion emotion;

  public Memory(String description, LocalDate date, Emotion emotion) {
    this.description = description;
    this.date = date;
    this.emotion = emotion;
  }

  public String getDescription() {
    return description;
  }

  public LocalDate getDate() {
    return date;
  }

  public Emotion getEmotion() {
    return emotion;
  }

}

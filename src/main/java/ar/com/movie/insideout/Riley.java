package ar.com.movie.insideout;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.Math.max;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class Riley {

  public void settle(Memory memory) {
    memory.settleTo(this);
  }

  public void liveEvent(Memory memory) {
    dailyMemories.add(memory);
  }

  public void liveEvent(List<Memory> memories) {
    dailyMemories.addAll(memories);
  }


  public List<Memory> lastDailyMemories() {
    return dailyMemories.stream().skip(max(0, dailyMemories.size() - LAST_MEMORIES)).collect(toList());
  }

  public void addThoughtCentral(Memory memory) {
    this.thoughtCentrals.add(memory);
  }

  public static final int LAST_MEMORIES = 5;

  private Double happinessLevel;

  private Set<Memory> thoughtCentrals;

  private List<Memory> dailyMemories;

  public Riley() {
    happinessLevel = 1000D;
    dailyMemories = new ArrayList<>();
    thoughtCentrals = new HashSet<>();
  }

  public Double getHappinessLevel() {
    return happinessLevel;
  }

  public void setHappinessLevel(Double happinessLevel) {
    this.happinessLevel = happinessLevel;
  }

  public Set<Memory> getThoughtCentrals() {
    return thoughtCentrals;
  }

  public Set<Memory> getComplexThoughtCentrals() {
    return thoughtCentrals.stream().filter(memory -> memory.isComplex()).collect(toSet());
  }
}

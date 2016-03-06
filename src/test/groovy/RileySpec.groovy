import ar.com.movie.insideout.Memory
import ar.com.movie.insideout.Riley
import ar.com.movie.insideout.emotion.*
import spock.lang.Specification

import java.time.LocalDate

import static java.time.Month.SEPTEMBER

public class RileySpec extends Specification {

  def riley = new Riley()

  def "live an event"() {
    given: "a memory"
      def memory = memory(new PleasantEmotion())
    when: "life an event"
      riley.liveEvent(memory)
    then: "riley keep the memory"
      riley.lastDailyMemories().first() == memory
  }

  def "settle a thought central memory"() {
    when:
      riley.settle(memory)
    then:
      riley.happinessLevel == happinessLevel
      riley.thoughtCentrals.first().emotion == emotion
    where:
      emotion                   | happinessLevel
      new PleasantEmotion()     | 800
      new SadEmotion()          | 900
      memory = memory(emotion)
  }

  def "settle a non thought central memory"() {
    when:
      riley.settle(memory(emotion))
    then:
      riley.happinessLevel == happinessLevel
      riley.thoughtCentrals.isEmpty()
    where:
      emotion                   | happinessLevel
      new RageEmotion()         | 1000
      new FearEmotion()         | 1000
      new DispleasureEmotion()  | 1000
  }

  def "get last five memories"() {
    given: "a riley with size memories"
      def memories = []
      6.times { memories << memory(new PleasantEmotion()) }
      riley.liveEvent(memories)
    when: "get last five memories"
      def lastMemories = riley.lastDailyMemories()
    then: "there are 5 last memories"
      lastMemories.size() == 5
    and: "doesn't contains first memory"
      !lastMemories.contains(memories.first())
  }

  def "get thought centrals"() {
    given: "riley with a thought central"
      def memory = memory(new PleasantEmotion())
      riley.settle(memory)
    expect: "riley contain a thought central"
      riley.thoughtCentrals.contains(memory)
  }

  def "get complex thought centrals"() {
    given: "riley with a simple thought central"
      riley.settle(memory(new PleasantEmotion()))
    and: "a complex thought central"
      def memory = memory("complex thought central", new PleasantEmotion())
      riley.settle(memory)
    expect: "get one complex thought central"
      riley.complexThoughtCentrals.size() == 1
      riley.complexThoughtCentrals.contains(memory)
  }

  def memory(Emotion emotion) {
    memory("desc", emotion)
  }

  def memory(String desc, Emotion emotion) {
    new Memory(desc, LocalDate.of(2015, SEPTEMBER, 22), emotion)
  }
}

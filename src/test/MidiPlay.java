package test;

import javax.sound.midi.*;
import java.io.File;
import java.io.IOException;

public class MidiPlay {
    public static void main(String[] args) {
        System.out.println("Midi Player");
        MidiPlay player = new MidiPlay();
        if (args.length == 1) player.play(args[0]);
    }

    public void play(String file) {
        try {
            Sequencer player = MidiSystem.getSequencer();
            player.open();
            Sequence seq = MidiSystem.getSequence(new File(file));
            player.setSequence(seq);
            player.start();
        } catch (MidiUnavailableException | InvalidMidiDataException | IOException e) {
            e.printStackTrace();
        }
    }
}

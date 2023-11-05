package test;

import javax.sound.midi.*;

public class MiniMusicPlayer1 {
    public static void main(String[] args) {
        try {
            Sequencer player = MidiSystem.getSequencer();
            player.open();

            player.addMetaEventListener(new MetaEventListener() {
                @Override
                public void meta(MetaMessage meta) {
                    if(meta.getType() == 47) {
                        player.stop();
                        System.exit(0);
                    }
                }
            });

            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            for (int i = 5; i < 61; i = i + 4) {
                track.add(makeEvent(144, 1,i + 30,127,i));
                track.add(makeEvent(128,1,i + 30,127,i + 2));
            }
            
            player.setSequence(seq);
            player.setTempoInBPM(200);
            player.start();

        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick){
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (Exception e){e.printStackTrace();}
        return event;
    }
}

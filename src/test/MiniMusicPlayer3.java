package test;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;

public class MiniMusicPlayer3 {
    static JFrame f = new JFrame("First clip");
    static MyDrawPanel ml;

    public static void main(String[] args) {
        MiniMusicPlayer3 mini = new MiniMusicPlayer3();
        mini.go();
    }

    private void setUpGui(){
        ml = new MyDrawPanel();
        f.setContentPane(ml);
        f.setBounds(30,30,300,300);
        f.setVisible(true);
    }

    private void go() {
        setUpGui();
        try {
            Sequencer player = MidiSystem.getSequencer();
            player.open();
            player.addControllerEventListener(ml, new int[] {127});

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
                track.add(makeEvent(176,1,127, 0,i + 1));
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

    private static class MyDrawPanel extends JPanel implements ControllerEventListener {
        boolean msg = false;

        @Override
        public void controlChange(ShortMessage event) {
            msg = true;
            repaint();
        }

        @Override
        public void paintComponent(Graphics g) {
            //super.paintComponent(g);
            if (msg){
                Graphics2D g2 = (Graphics2D) g;
                int r = (int) (Math.random() * 250);
                int gr = (int) (Math.random() * 250);
                int b = (int) (Math.random() * 250);
                g.setColor(new Color(r, gr, b));
                int ht = (int)(Math.random() * 180 + 10);
                int wt = (int)(Math.random() * 180 + 10);
                int x = (int)(Math.random() * 40 + 10);
                int y = (int)(Math.random() * 40 + 10);
                g.fillRect(x, y, wt, ht);
                msg = false;
            }
        }
    }
}

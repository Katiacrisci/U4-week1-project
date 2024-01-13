import java.util.Collections;

public class RegistrazioneAudio extends Multimedia implements Playable, HasVolume {
    private int volume;
    private int durata;



    public RegistrazioneAudio(String title, int volume, int durata) {
        super(title);
        if (volume > 0) {
            this.volume = volume;
        }
        if (durata > 0) {
            this.durata = durata;
        }
    }

    public void play() {
        for (int i = 0; i < this.durata; i++) {
            System.out.println(this.title + String.join("", Collections.nCopies(this.volume, "!")));
        }
    }

    public int getVolume() {
        return volume;
    }

    public void alzaVolume() {
        this.volume++;
    }

    public void abbassaVolume() {
        this.volume--;

    }

}

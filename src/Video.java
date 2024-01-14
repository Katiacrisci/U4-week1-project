import java.util.Collections;

public class Video extends Multimedia implements Playable, HasVolume {
    private int volume;
    private int luminosita;
    private int durata;


    public Video(String title, int volume, int luminosita, int durata) {
        super(title);
        if (volume > 0) {
            this.volume = volume;
        }
        if (luminosita > 0) {
            this.luminosita = luminosita;
        }
        if (durata > 0) {
            this.durata = durata;
        }
    }


    @Override
    public void play() {
        for (int i = 0; i < this.durata; i++) {
            System.out.println(this.title + String.join("", Collections.nCopies(this.volume, "!")) + String.join("", Collections.nCopies(this.luminosita, "*")));
        }

    }

    @Override
    public void alzaVolume() {
        this.volume++;

    }

    @Override
    public void abbassaVolume() {
        this.volume--;

    }

    public void alzaLuminosita() {
        this.luminosita++;
    }

    public void abbassaLuminosita() {
        this.luminosita--;
    }


    @Override
    public void esegui() {
        this.play();
    }
}

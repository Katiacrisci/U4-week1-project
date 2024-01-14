import java.util.Collections;

public class Immagine extends Multimedia{
    private int luminosita;

    public Immagine(String title, int luminosita) {
        super(title);
        if (luminosita > 0) {
            this.luminosita = luminosita;
        }

    }

    public void show() {
        System.out.println(this.title + String.join("", Collections.nCopies(this.luminosita, "*")));
    }

    @Override
    public void esegui() {
        this.show();
    }
}

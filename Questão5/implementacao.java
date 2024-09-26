package Questão5;

class Amplificador {
    public void turnOn() {
        System.out.println("O amplificador está ligado");
    }
    public void setVolume(int volume) {
        System.out.println("Volume do amplificador definido para " + volume);
    }
}

class DvdPlayer {
    public void playMovie(String movie) {
        System.out.println("Reproduzindo filme: " + movie);
    }
}

class Lights {
    public void dim(int level) {
        System.out.println("As luzes diminuíram para " + level + "%");
    }
}

// Classe facade
class HomeTheaterFacade {
    private Amplificador amp;
    private DvdPlayer dvd;
    private Lights lights;

    public HomeTheaterFacade(Amplificador amp, DvdPlayer dvd, Lights lights) {
        this.amp = amp;
        this.dvd = dvd;
        this.lights = lights;
    }

    public void watchMovie(String movie) {
        System.out.println("Prepare-se para assistir a um filme");
        lights.dim(10);
        amp.turnOn();
        amp.setVolume(5);
        dvd.playMovie(movie);
    }
}


public class Client {
    public static void main(String[] args) {
       
        Amplificador amp = new Amplificador();
        DvdPlayer dvd = new DvdPlayer();
        Lights lights = new Lights();
        
        
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, dvd, lights);//criando o facate
        
       
        homeTheater.watchMovie("Matrix");
    }
}
import java.util.Scanner;

// Clase base del personaje
class Personaje {

    String nombre;
    int fuerza;
    int vida_hp;
    int energy;
    int defensa;
    int max_Energy;
    int max_hp;

    // Definir constructor
    public Personaje(String nombre, int fuerza, int vida_hp, int energy, int max_Energy, int max_hp, int defensa) {

        this.nombre = nombre;
        this.fuerza = fuerza;
        this.vida_hp = vida_hp;
        this.energy = energy;
        this.defensa = defensa;
        this.max_Energy = max_Energy;
        this.max_hp = max_hp;

    }

}

class SuperHero extends Personaje {
    // definir el constructor
    public SuperHero(String nombre, int fuerza, int vida_hp, int energy, int max_Energy, int max_hp, int defensa){

        super(nombre, fuerza, vida_hp, energy, max_Energy, max_hp, defensa);

    }
    public void Bono(int bono){
        if(bono == 1){
            this.fuerza += 5;
        }
        if(bono == 2){
            
            this.max_hp =+ 10;
            this.vida_hp = 150;

        }
    }
    public void Info(){

        System.out.println(nombre + " :" + vida_hp + " hp   energy: " + energy + " defensa: " + defensa );

    }
}

class Villano extends Personaje {
    // definir el constructor
    public Villano(String nombre, int fuerza, int vida_hp, int energy, int max_Energy, int max_hp, int defensa){

        super(nombre, fuerza, vida_hp, energy, max_Energy, max_hp, defensa);

    }

}
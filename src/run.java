import java.util.Random;
import java.util.Scanner;

public class run {

    public static boolean enfrentamiento(SuperHero s, boolean victory, int progreso){
        
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        Random randomNumbers = new Random();

        int accion_special = 0;

        Villano [] villain;
        villain = new Villano[3];
        villain[0] = new Villano("Eclipse", 10, 100, 0, 60, 100, 0);
        villain[1] = new Villano("Midnight Shadow", 15, 120, 0, 60, 100, 0);
        villain[2] = new Villano("Daybreaker", 20, 150, 0, 60, 100, 0);

 
        while (villain[progreso].vida_hp > 0 && s.vida_hp > 0){
            int accion = 0;
            System.out.println("villano: " + villain[progreso].vida_hp + " hp");
            s.Info();
            System.out.println("");
            System.out.println("elija una accion");
            System.out.println("_____________________________");
            System.out.println("1. atacar          2. Defender");
            System.out.println("3. Especiales   4. Info");

            while(accion < 1  || accion > 3){
       
                System.out.println("turno del heroe");
                accion = scanner.nextInt();

                if(accion < 1  || accion > 4){
                    System.out.println("el numero de la accion no existe");
                }

                if(accion == 4){
                    System.out.println("informacion");
                    System.out.println("hero:");
                    s.Info();
                    System.out.println("villano:");
                    System.out.println(villain[progreso].vida_hp + " hp   energy: " + villain[progreso].energy + " defensa: " + s.defensa);
                    accion = 0;
                }

                if(accion == 3){

                    accion_special = 0;
                    System.out.println("");
                    System.out.println("elija una accion");
                    System.out.println("_____________________________");
                    System.out.println("1. ataque especial(60e)   2. Curar(40e)");
                    System.out.println("3. volver");

                    while(accion_special < 1  || accion_special > 3){

                        accion_special = scanner.nextInt();

                        if(accion_special < 1  || accion_special > 3){
                            System.out.println("el numero de la accion no existe");
                        }
                        if(accion_special == 1 && s.energy < 60){
                            accion_special = 0;
                            System.out.println("energia insuficiente");
                        }
                        if (accion_special == 2 && s.energy < 40) {
                            accion_special = 0;
                            System.out.println("energia insuficiente");
                        }
                        if (accion_special == 3) {

                            accion = 0;
                            
                        }
                    }
                }

            }
            if(accion == 1){
                villain[progreso].vida_hp -= (s.fuerza - villain[progreso].defensa);
                s.energy += 10;
            }
            if(accion == 2){
                if(s.defensa < 10){
                    s.defensa += 5;
                }
                s.energy += 30;
            }
            if(accion == 3){
                if(accion_special == 1){
                    villain[progreso].vida_hp -= ((s.fuerza - villain[progreso].defensa) + 20);
                    s.energy -= 60;
                }
                if (accion_special == 2) {
                    if(s.vida_hp < (s.max_hp - 10)){
                        s.vida_hp += 10;
                    }else{
                        s.vida_hp = s.max_hp;
                    }
                    s.energy -= 40;
                }
            }

            if(villain[progreso].vida_hp > 0 && s.vida_hp > 0){
                System.out.println("turno del villano");

                int villainAction = (randomNumbers.nextInt(2) + 1);

                if (villainAction == 1){
                    System.out.println("el villano ataca");
                    s.vida_hp -= (villain[progreso].fuerza - s.defensa);
                    villain[progreso].energy += 10;
                }
                if(villainAction == 2){

                    System.out.println("el villano se defiende");
                    if(villain[progreso].defensa < 10){
                        villain[progreso].defensa += 5;
                    }
                    villain[progreso].energy += 30;

                }
                if(villain[progreso].energy >= 60){
                    System.out.println("el villano hace trampa y ataca de nuevo");
                    villain[progreso].energy -= 60;
                    s.vida_hp -= (villain[progreso].fuerza - s.defensa);

                }
                System.out.println("");
            }
        }

        if(villain[progreso].vida_hp <= 0){
            victory = true;
        }

        if(villain[progreso].vida_hp > 0){
            victory = false;
        }
        
        return victory;
    }
    public static void main(String[] args) throws Exception {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        int barra_de_progreso = 0;
        int selectBono = 0;

        System.out.println("la ciudad se encuentra en peligro");
        System.out.println("un supervillano y sus minions estan atacando el centro de la ciudad");

        SuperHero superhero = new SuperHero("PlaceHolder", 20, 150, 0, 60, 150, 0);

        boolean Win_Loose_First_Battle = enfrentamiento(superhero, false, barra_de_progreso);
        if(Win_Loose_First_Battle == true){
            System.out.println("you win");
            barra_de_progreso =+ 1;
        }else{
            System.out.println("you loose");
            System.out.println("un minion del supervillano te a derrotado");
        }
        if(Win_Loose_First_Battle == true){

            System.out.println("estadisticas actuales: ");
            superhero.Info();
            System.out.println("elije un potenciador por tu victoria");
            System.out.println("1. para + 5 en fuerza");
            System.out.println("2. para + 30 en vida");

            while(selectBono < 1  || selectBono > 2 ){
                selectBono = scanner.nextInt();
            }
            selectBono = 0;

            superhero.Bono(selectBono);
            superhero.Info();

        }

    }
}
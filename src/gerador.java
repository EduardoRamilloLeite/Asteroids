import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

public class gerador {
    public int Tempo_GeradorMeteoro = 0;
    public ArrayList<meteoro> vetor_meteoro = new ArrayList<meteoro>();

    public void update() throws InterruptedException{

        Tempo_GeradorMeteoro++;

        if(Tempo_GeradorMeteoro % 30 == 0){
            meteoro objmeteoro = new meteoro (0, new Random().nextInt(480 - 40), 40, 40);
            vetor_meteoro.add(objmeteoro);
        }

        for(int i = 0; i < vetor_meteoro.size(); i++){
            meteoro current = vetor_meteoro.get(i);
            vetor_meteoro.get(i).update();

            if(current.x > jogo.Largura){
                vetor_meteoro.remove(current);
                jogo.Contador_Tempo--;
            }

            jogo.Mutex.acquire();

            if(jogo.MouseClicado){
                if(jogo.mouse_x >= current.x && jogo.mouse_x < current.x + current.width){
                    if(jogo.mouse_y >= current.y && jogo.mouse_y < current.y + current.height){
                        vetor_meteoro.remove(current);
                        jogo.pontuacao++;
                        jogo.MouseClicado = false;


                    }
                }
            }

            jogo.Mutex.release();
        }
    }
}

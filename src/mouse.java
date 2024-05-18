import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class mouse implements MouseListener{

    @Override
    public void mousePressed(MouseEvent e){
        try{
            jogo.Mutex.acquire();
        } catch (InterruptedException e1){
            e1.printStackTrace();
        }

        jogo.MouseClicado = true;
        jogo.mouse_x = e.getX();
        jogo.mouse_y = e.getY();

        jogo.Mutex.release();
    }

    @Override
    public void mouseClicked(MouseEvent e){

    }

    @Override
    public void mouseReleased(MouseEvent e){

    }

    @Override
    public void mouseEntered(MouseEvent e){

    }

    @Override
    public void mouseExited(MouseEvent e){

    }
}
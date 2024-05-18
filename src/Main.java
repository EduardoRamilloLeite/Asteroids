import javax.swing.JFrame;


public class Main extends JFrame {

    public static void Main(String[] args){
            jogo game = new jogo();
            JFrame janelaprincipal = new JFrame("Explosão");

            janelaprincipal.add(game);
            janelaprincipal.pack();
            janelaprincipal.setLocationRelativeTo(null);
            janelaprincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            janelaprincipal.setResizable(false);
            janelaprincipal.setVisible(true);

            new Thread(game).start();
        }
    }

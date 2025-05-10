package domingos.jv.sistema_blocos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class DiagramaCorposLivres extends JPanel {
    private boolean mostrarDiagrama = false;
    private double aceleracao;
    private String cordaCortada;

    // Irá mostrar o diagrama de corpos livres no painel
    public void mostrarDiagrama(boolean isMostrar) {
        this.mostrarDiagrama = isMostrar;
        repaint();
    }
    
    // Irá pegar as massas
    public void setDados(double aceleracao, String cordaCortada) {
        this.aceleracao = aceleracao;
        this.cordaCortada = cordaCortada;
    }
    
    
    @Override
    protected void paintComponent(Graphics g) {
        // Configuração para o paintComponent
        super.paintComponent(g); // limpa painel
        if(!mostrarDiagrama) return;
        
        Graphics2D g2 = (Graphics2D) g;
        
        // Desenha os blocos e suas forças
        // Bloco A: x - 50, y - 74
        desenharBlocoForcas(g2, 50, "A", Color.GREEN, cordaCortada);
        // Bloco B: x - 185, y - 74
        desenharBlocoForcas(g2, 185, "B", Color.BLUE, cordaCortada);
        // Bloco C: x - 320, y - 74
        desenharBlocoForcas(g2, 320, "C", Color.YELLOW, cordaCortada);
    }
    
    private void desenharBlocoForcas(Graphics2D g2, int x, String label, Color cor, String cordaCortada) {
        // Desenha o bloco
        g2.setColor(cor);
        g2.fillRect(x, 74, 50, 50);
        
        // Desenha o contorno do bloco
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(1));
        g2.drawRect(x, 74, 50, 50);
        
        // Adiciona o nome do bloco
        if(cor.equals(Color.BLUE)) g2.setColor(Color.WHITE);
        g2.setFont(new Font("Arial", Font.BOLD, 14));
        g2.drawString(label, x+21, 104);
        
        g2.setFont(new Font("Arial", Font.PLAIN, 12));
        
        // Chama o metodo de desenhar setas
        if(label == "B") {
            // Força Normal
            desenharSeta(g2, x+25, x+25, 74, 44, Color.CYAN);
            g2.drawString("N", x+40, 50);
            
            // Força Peso
            desenharSeta(g2, x+25, x+25, 124, 164, Color.ORANGE);
            g2.drawString("P", x+40, 150);
            
            // Tração da Esquerda
            if(cordaCortada != "Esquerda") {
                desenharSeta(g2, x, x-40, 99, 99, Color.DARK_GRAY);
                g2.drawString("Te", x-25, 90);
            }
            
            // Tração da Direita
            if(cordaCortada != "Direita") {
                desenharSeta(g2, x+50, x+90, 99, 99, Color.GRAY);
                g2.drawString("Td", x+60, 90);
            }
            
            // Aceleração
            int aceX1 = 0, aceX2 = 0;
            if(aceleracao > 0) {
                aceX1 = x-20;
                aceX2 = x+70;
                //desenharSeta(g2, x-20, x+70, 30, 30, Color.MAGENTA);
            } else if(aceleracao < 0) {
                aceX1 = x+70;
                aceX2 = x-20;
                //desenharSeta(g2, x+70, x-20, 30, 30, Color.MAGENTA);
            }
            
            if(aceleracao != 0) {
                desenharSeta(g2, aceX1, aceX2, 30, 30, Color.MAGENTA);
                g2.drawString("a", x+25, 25);
            }
            
        } else {
            // Analisa o sinal da aceleração
            int aceY1, aceY2;
            if(aceleracao < 0) {
                aceY1 = 64;
                aceY2 = 114;
            } else {
                aceY1 = 114;
                aceY2 = 64;
            }

            // Identifica qual tração é
            String labelTracao;
            Color corT;
            if(label == "A") {
                labelTracao = "Te";
                corT = Color.DARK_GRAY;

                // Desenha aceleracao
                if(aceleracao != 0 && cordaCortada != "Esquerda") {
                    desenharSeta(g2, x/2, x/2, aceY1, aceY2, Color.MAGENTA);
                    g2.drawString("a", x/2-15, 99);
                } else if(aceleracao != 0 && cordaCortada == "Esquerda") {
                    desenharSeta(g2, x/2, x/2, 64, 114, Color.MAGENTA);
                    g2.drawString("a", x/2-15, 99);
                }

                // Tração
                if(cordaCortada != "Esquerda") {
                    desenharSeta(g2, x+25, x+25, 74, 44, corT);
                    g2.drawString(labelTracao, x+40, 50);
                }

            } else {
                labelTracao = "Td";
                corT = Color.GRAY;

                // Desenha aceleracao
                if(aceleracao != 0 && cordaCortada != "Direita") {
                    desenharSeta(g2, x+75, x+75, aceY2, aceY1, Color.MAGENTA);
                    g2.drawString("a", x+85, 99);
                } else if(aceleracao != 0 && cordaCortada == "Direita") {
                    desenharSeta(g2, x+75, x+75, 64, 114, Color.MAGENTA);
                    g2.drawString("a", x+85, 99);
                }

                // Tração
                if(cordaCortada != "Direita") {
                    desenharSeta(g2, x+25, x+25, 74, 44, corT);
                    g2.drawString(labelTracao, x+40, 50);
                }
            }
            
            // Força Peso
            desenharSeta(g2, x+25, x+25, 124, 164, Color.ORANGE);
            g2.drawString("P", x+40, 150);
        }
        
        
    }
    
    // Metodo para desenhar a seta
    private void desenharSeta(Graphics2D g2, int x1, int x2, int y1, int y2, Color cor) {
        // Desenha o corpo da seta
        g2.setColor(cor);
        g2.setStroke(new BasicStroke(2));
        g2.drawLine(x1, y1, x2, y2);
        
        // Desenha a cabeça da seta
        int dx = x2 - x1;
        int dy = y2 - y1;
        double angle = Math.atan2(dy, dx);
        
        int larguraCabeca = 7;
        
        int xArrow1 = (int) (x2 - larguraCabeca * Math.cos(angle - Math.PI / 6));
        int yArrow1 = (int) (y2 - larguraCabeca * Math.sin(angle - Math.PI / 6));

        int xArrow2 = (int) (x2 - larguraCabeca * Math.cos(angle + Math.PI / 6));
        int yArrow2 = (int) (y2 - larguraCabeca * Math.sin(angle + Math.PI / 6));
        
        g2.drawLine(x2, y2, xArrow1, yArrow1);
        g2.drawLine(x2, y2, xArrow2, yArrow2);
    }
}

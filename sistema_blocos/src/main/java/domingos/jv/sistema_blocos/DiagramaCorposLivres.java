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

    // Irá mostrar o diagrama de corpos livres no painel
    public void mostrarDiagrama(boolean isMostrar) {
        this.mostrarDiagrama = isMostrar;
        repaint();
    }
    
    // Irá pegar as massas
    public void setDados(double aceleracao) {
        this.aceleracao = aceleracao;
    }
    
    
    @Override
    protected void paintComponent(Graphics g) {
        // Configuração para o paintComponent
        super.paintComponent(g);
        if(!mostrarDiagrama) return;
        
        Graphics2D g2 = (Graphics2D) g;
        
        // Desenha os blocos e suas forças
        // Bloco A: x - 50, y - 74
        desenharBlocoForcas(g2, 50, "A", Color.GREEN);
        // Bloco B: x - 185, y - 74
        desenharBlocoForcas(g2, 185, "B", Color.BLUE);
        // Bloco C: x - 320, y - 74
        desenharBlocoForcas(g2, 320, "C", Color.YELLOW);
    }
    
    private void desenharBlocoForcas(Graphics2D g2, int x, String label, Color cor) {
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
            desenharSeta(g2, x, x-40, 99, 99, Color.DARK_GRAY);
            g2.drawString("Te", x-25, 90);
            
            // Tração da Direita
            desenharSeta(g2, x+50, x+90, 99, 99, Color.GRAY);
            g2.drawString("Td", x+60, 90);
            
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
                if(aceleracao != 0) {
                    desenharSeta(g2, x/2, x/2, aceY1, aceY2, Color.MAGENTA);
                    g2.drawString("a", x/2-15, 99);
                }
                
            } else {
                labelTracao = "Td";
                corT = Color.GRAY;
                
                // Desenha aceleracao
                if(aceleracao != 0) {
                    desenharSeta(g2, x+75, x+75, aceY2, aceY1, Color.MAGENTA);
                    g2.drawString("a", x+85, 99);
                }
            }

            // Tração
            desenharSeta(g2, x+25, x+25, 74, 44, corT);
            g2.drawString(labelTracao, x+40, 50);
            
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
        double d = Math.sqrt(dx * dx + dy * dy);
        double xm = x2 - dx * 10 / d;
        double ym = y2 - dy * 10 / d;
        
        int[] xPoints = {x2, (int)(xm + dy * 0.3), (int)(xm - dy * 0.3)};
        int[] yPoints = {y2, (int)(ym - dx * 0.3), (int)(ym - dx * 0.3)};
        g2.fillPolygon(xPoints, yPoints, 3);
    }
}

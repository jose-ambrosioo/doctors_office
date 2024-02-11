////package sistemamedico.visao;
//
//import java.awt.event.*;
//import java.awt.*;
//import javax.swing.*;
//
//
//
//// Class Principal
//public class TelaDeApresentacao extends JWindow 
//{
//    
//    private int duracaoDaTela;
//    
//	// Construtor da Class
//    public TelaDeApresentacao(int d) 
//	{
//        duracaoDaTela = d;
//        
//    }    
//
//	// Método que mostra a tela de apresentação
//	// No centro da tela durante a quantidade de tempo passada no construtor
//    public void exibeApresentacao() 
//	{        
//        JPanel c = (JPanel)getContentPane();
//        c.setBackground(Color.white);
//        
//        // Configurando a posição e o tamanho da janela
//        int width = 480;
//        int height = 400;
//		
//        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
//        
//		int x = (tela.width-width)/2;
//        int y = (tela.height-height)/2;
//        
//		setBounds(x,y,width,height);
//        
//        // Construção da tela de apresentação
//        JLabel label = new JLabel(new ImageIcon("\\imagens\\SistemaSplash.PNG"), JLabel.CENTER);
//        c.add(label, BorderLayout.CENTER);
//        
//        setVisible(true); // Define a visibilidade da janela
//        
//        // Espera até que os recursos estejam carregados
//        try 
//		{ 
//			Thread.sleep(duracaoDaTela); 
//		} 
//		catch (Exception e) {}        
//        
//		setVisible(false);        
//    }
//    
//	// Método que chama a tela de apresentação
//    public void exibirEFecharApresentacao() 
//	{        
//        exibeApresentacao();
//		new TermosUso().setVisible(true);
//        dispose();        
//    }
//    
//	// Método Main (Principal)
//    public static void main(String[]args) 
//	{      
//		
//		// Criação um objecto do tipo da Class Principal
//        TelaDeApresentacao tela = new TelaDeApresentacao(10000);
//		
//		// Chamada do método que chama a apresentação
//        tela.exibirEFecharApresentacao();    
//    }
//}
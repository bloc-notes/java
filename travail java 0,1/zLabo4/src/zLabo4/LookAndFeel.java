package zLabo4;

import javax.swing.UIManager;

public class LookAndFeel {

    public static void main(String[] args) {
    	UIManager.LookAndFeelInfo aspects[]= UIManager.getInstalledLookAndFeels();
        try {
        	System.out.println(aspects.length);
            for (int i= 0; i<aspects.length;i++){
            	System.out.println(aspects[i].getClassName()); 
            }
            }catch (Exception e){
            	System.out.println(" look and feel invalide");
        }
    }
}
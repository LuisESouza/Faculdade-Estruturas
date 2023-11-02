package estruturaarvore;
import java.io.*;

public class Input {
    private static BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));

    public static String readString() {
        String line = "0";
        try{
            line = inReader.readLine();
        }
        catch(IOException e){
            System.err.println("Erro ao obter entrada. Erro: " + e.getMessage());
        }
        return line;
    }
    
    public static String readString(String mensagem) {
        System.out.print(mensagem);
        return readString();
    }

    public static int readInt(){
        return Integer.parseInt(readString());
    }
    
    public static int readInt(String mensagem) {
        System.out.print(mensagem);
        return readInt();
    }

    public static double readDouble(){
        return Double.parseDouble(readString());
    }
    
    public static double readDouble(String mensagem){
        System.out.print(mensagem);
        return readDouble();
    }
    
	public static boolean readBoolean(){
        return Boolean.valueOf(readString()).booleanValue();
    }
    
    public static boolean readBoolean(String mensagem) {
        System.out.print(mensagem);
        return readBoolean();
    }
	
	public static char readChar(){
        return readString().charAt(0);
    }
    
    public static char readChar(String mensagem) {
        System.out.print(mensagem);
        return readChar();
    }	
} 
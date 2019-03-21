import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LectureDirecte {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		try {
			RandomAccessFile fa = new RandomAccessFile("etudiant.dat", "r");
			Etudiant e = new Etudiant();
			System.out.println("Lecture du 3ième étudiant");
			e.lireDirectEtudiant(fa, 3);
			System.out.println(e);
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}

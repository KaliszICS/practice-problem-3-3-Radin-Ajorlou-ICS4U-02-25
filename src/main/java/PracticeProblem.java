import java.util.ArrayList;

public class PracticeProblem {

	public static void main(String args[]) {

		String str = "bob";

		System.out.println(permsUnique(str));

	}


	public static ArrayList<String> perms(String str){
		ArrayList<String> perms = new ArrayList<>();
		permsHelp("", str, perms);
		return perms;
	}



	public static ArrayList<String> permsUnique(String str){
		ArrayList<String> permsUnique = new ArrayList<>();
		permsHelp("", str, permsUnique);
		int length = permsUnique.size();
		for (int i = 0; i < permsUnique.size(); i++){
			String a = permsUnique.get(i);
			for (int j = i + 1; j < permsUnique.size(); j++){
				String b = permsUnique.get(j);
				System.out.println(a + " " + b);
				if (a.equals(b)){
					permsUnique.remove(a);
					i--;
				}
			}
		}

		return permsUnique;
	}



	public static void permsHelp(String usedLetters, String unusedLetters, ArrayList<String> permutations){

		int length = unusedLetters.length();
		if (length == 0){
			permutations.add(usedLetters); //base case
			return;
		}
		for (int i = 0; i < length; i++){
			String newUsed = usedLetters + unusedLetters.charAt(i);
			permsHelp(newUsed, (unusedLetters.substring(0, i) + unusedLetters.substring(i + 1)), permutations);
		}
	}







}

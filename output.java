import java.util.Scanner;

public class Main {
public static void main(String[] args) {
int a;
int b;
int c;
int d;
String nome;
int idade;
double velocidade;
int gols;
String nomeTime;
String brasil;
gols=1;
brasil="Brasil";
nomeTime=brasil;
if (gols<2) {
System.out.println("1 < 2");
System.out.println("true");
}
else {
System.out.println("1 < 2");
System.out.println("false");
}
while(gols<2) {
gols=3;
}
do {
gols=5;
} while(gols<10);
Scanner scanner = new Scanner(System.in);
gols=scanner.nextInt();
nome=scanner.nextLine();
velocidade=scanner.nextDouble();

}
}

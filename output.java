import java.util.Scanner;

public class Main {
public static void main(String[] args) {
double perimetro;
double l1;
double l2;
double l3;
int idade;
int contador;
int i;
String nome;
System.out.println("Calculando o perimetro do triangulo");
System.out.println("lado a");
Scanner scanner = new Scanner(System.in);
l1=scanner.nextDouble();scanner.nextLine(); 
System.out.println("lado b");
l2=scanner.nextDouble();scanner.nextLine(); 
System.out.println("lado c");
l3=scanner.nextDouble();scanner.nextLine(); 
perimetro=l1+l2+l3;
System.out.println("Perimetro tem tamanho");
System.out.println(perimetro);
System.out.println("qual sua idade");
idade=scanner.nextInt();scanner.nextLine(); 
if (idade<18) {
System.out.println("nao pode tirar CNH");
}
else {
System.out.println("pode tirar CNH");
}
System.out.println("Qual seu nome?");
nome=scanner.nextLine(); 
System.out.println("seu nome eh");
System.out.println(nome);
System.out.println("ate que numero deseja realizar contagem?");
contador=scanner.nextInt();scanner.nextLine(); 
i=1;
while(i<contador) {
System.out.println(i);
System.out.println("\n");
i=i+1;
}

}
}

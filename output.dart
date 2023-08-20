import 'dart:io';

void main(){
double perimetro;
double l1;
double l2;
double l3;
int idade;
int contador;
int i;
String nome;
print("Calculando o perimetro do triangulo");
print("lado a");
l1=double.parse(stdin.readLineSync()!);
print("lado b");
l2=double.parse(stdin.readLineSync()!);
print("lado c");
l3=double.parse(stdin.readLineSync()!);
perimetro=l1+l2+l3;
print("Perimetro tem tamanho");
print(perimetro);
print("qual sua idade");
idade=int.parse(stdin.readLineSync()!);
if (idade<18) {
print("nao pode tirar CNH");
}
else {
print("pode tirar CNH");
}
print("Qual seu nome?");
nome=stdin.readLineSync()!;
print("seu nome eh");
print(nome);
print("ate que numero deseja realizar contagem?");
contador=int.parse(stdin.readLineSync()!);
i=1;
while(i<contador) {
print(i);
print("\n");
i=i+1;
}
}


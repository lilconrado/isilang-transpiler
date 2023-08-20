function ask() {
  const readline = require("readline").createInterface({
    input: process.stdin,
    output: process.stdout
  })

  return  new Promise(resolve => readline.question('', ans => {
  readline.close();
  resolve(ans);
}));
}

async function main(){
let perimetro:number;
let l1:number;
let l2:number;
let l3:number;
let idade:number;
let contador:number;
let i:number;
let nome:string;
console.log("Calculando o perimetro do triangulo");
console.log("lado a");
l1=Number.parseFloat(await ask());
console.log("lado b");
l2=Number.parseFloat(await ask());
console.log("lado c");
l3=Number.parseFloat(await ask());
perimetro=l1+l2+l3;
console.log("Perimetro tem tamanho");
console.log(perimetro);
console.log("qual sua idade");
idade=Number.parseInt(await ask());
if (idade<18) {
console.log("nao pode tirar CNH");
}
else {
console.log("pode tirar CNH");
}
console.log("Qual seu nome?");
nome=await ask();
console.log("seu nome eh");
console.log(nome);
console.log("ate que numero deseja realizar contagem?");
contador=Number.parseInt(await ask());
i=1;
while(i<contador) {
console.log(i);
console.log("\n");
i=i+1;
}
}
main();


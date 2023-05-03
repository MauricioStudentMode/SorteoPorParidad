//Mauricio Di Donato Sánchez 1152186
#include <bits/stdc++.h>
      
#define fastIO ios::sync_with_stdio(0), cin.tie(0), cout.tie(0)

using namespace std;

    /*Este algoritmo recibe un vector nums y ordena todos sus elementos de modo que
      los elementos pares se encuentren en posiciones pares y los impares en posiciones impares
      Se añadio un metodo para imprimir los outputs para luego guadarlos en un archivo .txt usando git-bash
    */

    void imprimirVector(vector<int> nums){
        for(int i = 0; i < nums.size(); i++){
            cout<< nums[i] << " ";
        }
        cout << endl;
    }

    /*Para realizar el algoritmo, se penso usar una cola y dos pilas. Una cola "Par" y otra "Impar"
      esto, para poder almacenar y separar las posiciones vacias del arreglo. Se utiliza una pila que guarda
      todos los elementos "nomadas" o que esta fuera de lugar para luego, en segundo ciclo for, organizar estos
      en las posiciones vacias correspondientes.

      Se añadio un ciclo for el principio para en vez de recibir un arreglo, este se lea de un archivo de entrada.
    */

    void solve(int n) {
        vector<int> nums(n);
        for(int i = 0; i < n; i++){
            cin >> nums[i];
        }
        stack<int> nomadas;
        queue<int> pairs, impairs;
        for(int i = 0; i < nums.size(); i++){
            if((i%2==0 && nums[i]%2!=0) || (i%2!=0 && nums[i]%2==0)){
                nomadas.push(nums[i]);
                if(i%2==0){
                    pairs.push(i);
                }
                else{
                    impairs.push(i);
                }
            }
        }

        while(!nomadas.empty() && !pairs.empty() && !impairs.empty()){
            int dato = nomadas.top();
            nomadas.pop();
            if(dato%2==0){
                nums[pairs.front()] = dato;
                pairs.pop();
            }
            else{
                nums[impairs.front()] = dato;
                impairs.pop();
            }

        }
        imprimirVector(nums);
    }

    int main() {
    fastIO;
    int n;
    while(cin>> n){
        solve(n);
    }
    return 0;
}

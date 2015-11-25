//
//  main.cpp
//  Proyecto_Integrador_1.1
//
//  Created by Alex Elizondo on 11/17/15.
//  Copyright © 2015 Alex Elizondo. All rights reserved.
//


#include <iostream>
#include <iomanip>

using namespace std;


const int MAXRENG = 4;
int iMat [MAXRENG][MAXRENG] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,}};
int iArrNo[16] = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
int iReng = 0, iCol = 0, iNum, iRand, iTam=16;
char cResp;

void siguienteDato()
{
    if (iReng < 3){
        iReng++;
    }else{
        iReng = 0;
        iCol++;
    }
}

void Matriz ()
{
    int dato = iArrNo[iRand];
    iMat[iCol][iReng]= dato;
    siguienteDato();
    for(int i=0; i<(iTam-iRand);i++)
    {
        if((iRand+1)<=iTam)
        {
            iArrNo[iRand+i]=iArrNo[iRand+i+1];
        }else{
            iArrNo[iRand+i] = -1;
        }
    }
    iTam--;
}


void muestraMatriz()
{
    for (int x = 0;x<MAXRENG;x++)
    {
        for (int y=0;y<MAXRENG;y++)
        {
            cout << iMat[x][y] << '\t';
        }
        cout << endl;
    }
}

void Cambio()
{
    if(
}

int main(int argc, const char * argv[]) {
    // insert code here...
        cout << "Bienvenido al juego"<<endl;
        srand(time(NULL));
        for (int x = 0;x<MAXRENG;x++)
        {
            for (int y=0;y<MAXRENG;y++)
            {
                if (iTam > 1)
                    iRand=rand()%(iTam-1);
                else
                    iRand = 0;
                Matriz();
            }
        }
    do{
        muestraMatriz();
        cout << "Ingresa el numero que deseas que se mueva al lugar del 0"<<endl;
        cin>>iNum;
        cout << "Deseas seguir jugando (s/n)"<<endl;
        cin >> cResp;
    }while(tolower(cResp) == 's');
           return 0;
}
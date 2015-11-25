//
//  main.cpp
//  Proyecto_Integrador
//
//  Created by Alex Elizondo on 11/23/15.
//  Copyright © 2015 Alex Elizondo. All rights reserved.
//
//  Alejandro Elizondo A01193334
//  Alberto Drucker A01193336

#include <iostream>
#include <time.h>
#include <cstdlib>
#include <stdio.h>

using namespace std;

const int MAXRENG = 4;
int iMat [MAXRENG][MAXRENG] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};
int iArrNo[16] = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
int iMatF [MAXRENG][MAXRENG] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};
int iReng = 0, iCol = 0, iNum, iRand, iTam=16, iCol0, iReng0, iRengNum, iColNum, iGanar=0, iMov=0;
char cResp, cGanar='n';

void Ganar()
{
    for (int x = 0;x<4;x++)
    {
        for (int y=0;y<4;y++)
        {
            if(iMat[x][y]==iMatF[x][y])
                iGanar++;
        }
    }
    if (iGanar==16)
        cGanar='s';
}
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
    cout<<"+----+----+----+----+"<<endl;
    for (int x = 0;x<MAXRENG;x++)
    {   cout <<'|';
        for (int y=0;y<MAXRENG;y++)
        {
            cout << iMat[x][y];
            if(iMat[x][y]>9)
                cout<< "  ";
            else
                cout<< "   ";

            cout <<'|';
        }
        cout << endl;
        cout<<"+----+----+----+----+"<<endl;
    }
}
void Cambio()
{
    if(iReng0==0)
    {
        if(iCol0==0)
        {
            if(iMat[1][0] == iNum)
            {
                iMat[0][0]=iNum;
                iMat[1][0]=0;
            }
            else if(iMat[0][1]==iNum)
            {
                iMat[0][0]=iNum;
                iMat[0][1]=0;
            }
        }
        else if(iCol0==3)
        {
            if(iMat[1][3] == iNum)
            {
                iMat[0][3]=iNum;
                iMat[1][3]=0;
            }
            else if(iMat[0][2]==iNum)
            {
                iMat[0][3]=iNum;
                iMat[0][2]=0;
            }
        }
        else
        {
            if(iMat[iReng0][iCol0+1] == iNum)
            {
                iMat[iReng0][iCol0]=iNum;
                iMat[iReng0][iCol0+1]=0;
            }
            else if(iMat[iReng0+1][iCol0]==iNum)
            {
                iMat[iReng0][iCol0]=iNum;
                iMat[iReng0+1][iCol0]=0;
            }
            else if(iMat[iReng0][iCol0-1]==iNum)
            {
                iMat[iReng0][iCol0]=iNum;
                iMat[iReng0][iCol0-1]=0;
            }
        }
    }
    else if (iReng0==3)
    {
        if(iCol0==0)
        {
            if(iMat[2][0] == iNum)
            {
                iMat[3][0]=iNum;
                iMat[2][0]=0;
            }
            else if(iMat[3][1]==iNum)
            {
                iMat[3][0]=iNum;
                iMat[3][1]=0;
            }
        }
        else if(iCol0==3)
        {
            if(iMat[2][3] == iNum)
            {
                iMat[3][3]=iNum;
                iMat[2][3]=0;
            }
            else if(iMat[3][2]==iNum)
            {
                iMat[3][3]=iNum;
                iMat[3][2]=0;
            }
        }
        else
        {
            if(iMat[iReng0][iCol0+1] == iNum)
            {
                iMat[iReng0][iCol0]=iNum;
                iMat[iReng0][iCol0+1]=0;
            }
            else if(iMat[iReng0-1][iCol0]==iNum)
            {
                iMat[iReng0][iCol0]=iNum;
                iMat[iReng0-1][iCol0]=0;
            }
            else if(iMat[iReng0][iCol0-1]==iNum)
            {
                iMat[iReng0][iCol0]=iNum;
                iMat[iReng0][iCol0-1]=0;
            }
        }
    }
    else
    {
        if(iCol0==0)
        {
            if(iMat[iReng0][iCol0+1] == iNum)
            {
                iMat[iReng0][iCol0]=iNum;
                iMat[iReng0][iCol0+1]=0;
            }
            else if(iMat[iReng0+1][iCol0] == iNum)
            {
                iMat[iReng0][iCol0]=iNum;
                iMat[iReng0+1][iCol0]=0;
            }
            else if(iMat[iReng0-1][iCol0] == iNum)
            {
                iMat[iReng0][iCol0]=iNum;
                iMat[iReng0-1][iCol0]=0;
            }
        }
        else if(iCol0==3)
        {
            if(iMat[iReng0][iCol0-1] == iNum)
            {
                iMat[iReng0][iCol0]=iNum;
                iMat[iReng0][iCol0-1]=0;
            }
            else if(iMat[iReng0+1][iCol0] == iNum)
            {
                iMat[iReng0][iCol0]=iNum;
                iMat[iReng0+1][iCol0]=0;
            }
            else if(iMat[iReng0-1][iCol0] == iNum)
            {
                iMat[iReng0][iCol0]=iNum;
                iMat[iReng0-1][iCol0]=0;
            }
        }
        else
        {
            if(iMat[iReng0][iCol0-1] == iNum)
            {
                iMat[iReng0][iCol0]=iNum;
                iMat[iReng0][iCol0-1]=0;
            }
            else if(iMat[iReng0][iCol0+1] == iNum)
            {
                iMat[iReng0][iCol0]=iNum;
                iMat[iReng0][iCol0+1]=0;
            }

            else if(iMat[iReng0+1][iCol0] == iNum)
            {
                iMat[iReng0][iCol0]=iNum;
                iMat[iReng0+1][iCol0]=0;
            }
            else if (iMat[iReng0-1][iCol0]== iNum)
            {
                iMat[iReng0][iCol0]=iNum;
                iMat[iReng0-1][iCol0]=0;
            }
        }
    }
}
int main(int argc, const char * argv[]) {
    // insert code here...
    char cGenera;
    int iCero=0;
    time_t start,end;
    time (&start);
    cout << "Bienvenido al juego"<<endl<<endl;
    cout << "Para ganar ordena los numeros del 1 al 15 de arriba hacia abajo. La ultima casilla de la tabla debe de contener el 0"<<endl<<endl;
    srand(time(NULL));
    cout<<"Quieres alimentar tu los numeros o quieres que se generen aleatoriamente?(escrime 'a' para alimentar o 'r' para que se generen aleatoriamente."<<endl;
    cin>>cGenera;
    if(cGenera=='r')
    {
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
    }
    else
    {
        cout<<"Recuerda que debes de poner un 0 en alguna de las posiciones y debes de ingresar numeros del 1 al 15 sin repetir para que el juego funcione."<<endl<<endl;
        do
        {
            for (int i=0; i<MAXRENG;i++)
            {
                for (int j=0; j< MAXRENG;j++)
                {
                    do
                    {
                        cout << "Teclea el valor de iMatValores["<<i+1<< ","<<j+1<<"]"<<endl;
                        cin >> iMat[i][j];
                        if(iMat[i][j]==0)
                            iCero=1;
                    }while(iMat[i][j] <0 || iMat[i][j]>15);
                }
            }
        }while(iCero !=1);
    }
    muestraMatriz();
    do{
        for (int x = 0;x<MAXRENG;x++)
        {
            for (int y=0;y<MAXRENG;y++)
            {
                if (iMat[x][y]==0)
                {
                    iReng0=x;
                    iCol0=y;
                }
            }
        }
        do
        {
            cout << "Ingresa el numero que deseas que se mueva al lugar del 0"<<endl;
            cin>>iNum;
        }while(iNum<1 || iNum>15);
        for (int x = 0;x<MAXRENG;x++)
        {
            for (int y=0;y<MAXRENG;y++)
            {
                if (iMat[x][y]==iNum)
                {
                    iRengNum=x;
                    iColNum=y;
                }
            }
        }
        Cambio();
        muestraMatriz();
        iMov++;
        Ganar();
        if(cGanar=='s')
        {
            cout<<"Felicidades!Ganaste!"<<endl;
            cout<< "Hiciste "<<iMov<<" movimientos en este juego."<<endl;
            time (&end);
            double dif = difftime (end,start);
            printf ("Jugaste por %.0lf segundos.", dif );
            return 0;
        }
        do
        {
            cout << "Deseas seguir jugando (s/n)"<<endl;
            cin >> cResp;
            if(tolower(cResp) == 'n')
            {
                cout<< "Hiciste "<<iMov<<" moviemientos en este juego."<<endl;
                time (&end);
                double dif = difftime (end,start);
                printf ("Jugaste por %.0lf segundos.", dif );
                return 0;
            }
        }while(tolower(cResp) != 's');
    }while(tolower(cResp) == 's');
    return 0;
}

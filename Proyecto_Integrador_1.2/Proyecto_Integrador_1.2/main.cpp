//
//  main.cpp
//  Proyecto_Integrador_1.2
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
int iReng = 0, iCol = 0, iNum, iRand, iTam=16, iCol0, iReng0, iRengNum, iColNum;
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
    cout<<"•---•---•---•---•"<<endl;
    for (int x = 0;x<MAXRENG;x++)
    {   cout <<'|';
        for (int y=0;y<MAXRENG;y++)
        {
            cout << iMat[x][y] << '\t';
            cout <<'|';
        }
        cout << endl;
        cout<<"•---•---•---•---•"<<endl;
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
            else if (iMat[iReng0-1][iCol0])
            {
                iMat[iReng0][iCol0]=iNum;
                iMat[iReng0-1][iCol0]=0;
            }

        }

    }
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
               cout << "Deseas seguir jugando (s/n)"<<endl;
               cin >> cResp;
           }while(tolower(cResp) == 's');
           return 0;
       }
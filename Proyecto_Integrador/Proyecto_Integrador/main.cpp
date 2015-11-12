//
//  main.cpp
//  Proyecto_Integrador
//
//  Created by Alex Elizondo on 11/12/15.
//  Copyright © 2015 Alex Elizondo. All rights reserved.
//


#include <iostream>
#include <iomanip>

using namespace std;

const int MAXRENG = 4;

void Cambio(int iArr[MAXRENG][MAXRENG], int iNum)
{
    
}


int main(int argc, const char * argv[]) {
    // insert code here...
    int iArr [MAXRENG][MAXRENG] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,}};
    int iReng = 4, iCol = 4, iNum;
    char cResp;
    cout << "Bienvenido al juego"<<endl;
    do{
        for (int x = 0;x<iReng;x++)
        {
            for (int y=0;y<iCol;y++)
            {
                cout<< iArr[x][y]<<"\t";
            }
            cout<<endl;
        }
        cout << "Ingresa el numero que deseas que se mueva al lugar del 0"<<endl;
        cin>>iNum;
        Cambio(iArr, iNum);
        cout << "Deseas seguir jugando (s/n)"<<endl;
        cin >> cResp;
    }while(tolower(cResp == 's'));
        return 0;
}

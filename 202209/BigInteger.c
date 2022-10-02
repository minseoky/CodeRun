#define _CRT_SECURE_NO_WARNINGS
#define MAX 100
#include <stdio.h>
#include <string.h>


int temp;
char* op_sum(char* numstr1rev, char* numstr2rev) {//-48
    char result[MAX + 2];
    temp = 0;
    int upper = 0;
    for (int i = 0; i < MAX+2; i++) {
        temp = (int)numstr1rev[i]-48 + (int)numstr2rev[i]-48 + upper; //-48 <- 아스키코드변환시 오차
        upper = 0;
        if (temp >= 10) {
            temp -= 10;
            upper++;
        }
        
        result[i] = (char)temp+48;
        if (result[i] < '0' || result[i] >'9') { //범위이탈시 '0'으로 지정
            result[i] = '0';
        }
    }
    
    temp = MAX+1;
    while (result[temp] == '0') { //0이 아닌값이 나올때까지 주소값 --
        temp--;
    }
    //for (int i = temp; i >= 0; i--) {
    //    printf("%c", result[i]);
    //}
    return result;
}

char* op_sub(char* numstr1rev, char* numstr2rev) {//-48
    char result[MAX + 2];
    temp = 0;
    int upper = 0;
    for (int i = 0; i < MAX + 2; i++) {
        temp = (int)numstr1rev[i] - 48 - (int)numstr2rev[i] + 48 - upper; //-48 <- 아스키코드변환시 오차
        upper = 0;
        if (temp < 0) {
            temp += 10;
            upper++;
        }

        result[i] = (char)temp + 48;
        if (result[i] < '0' || result[i] >'9') { //범위이탈시 '0'으로 지정
            result[i] = '0';
        }
    }

    temp = MAX + 1;
    while (result[temp] == '0') { //0이 아닌값이 나올때까지 주소값 --
        temp--;
    }
    //for (int i = temp; i >= 0; i--) {
    //    printf("%c", result[i]);
    //}
    return result;
}
char* op_pow(char* numstr1rev, char* numstr2rev) {//-48
    int result[MAX * 2 + 4]; //구현에 어려움이있어 정수형으로 처리



}

int main()
{
    char num1[MAX+1];
    char num2[MAX+1];
    char op;
    char numstr1[MAX+1];
    char numstr2[MAX+1];
    char* numstr1rev;
    char* numstr2rev;


    while (1) {
        printf("정수를 입력하세요:");
        scanf_s("%s", num1, sizeof(num1));
        sprintf_s(numstr1, sizeof(numstr1), "%0100s", num1); //%0100s MAX 101기준 100칸짜리, 비어있는칸 0으로 채움


        printf("연산자를 입력하세요(+, -):");
        scanf_s(" %c", &op);


        printf("정수를 입력하세요:");
        scanf_s(" %s", num2, sizeof(num2));
        sprintf_s(numstr2, sizeof(numstr2), "%0100s", num2); //%0100s MAX 101기준 100칸짜리, 비어있는칸 0으로 채움
        /*
        for (int i = 0; i < MAX; i++) {
            printf("%c", numstr1[i]);
        }
        printf("\n");
        printf("%c", op);
        printf("\n");

        for (int i = 0; i < MAX; i++) {
            printf("%c", numstr2[i]);
        }
        */

        printf("\n");
        printf("%s", num1);
        printf("\n");
        printf("%c", op);
        printf("\n");
        printf("%s", num2);
        printf("\n");
        printf("=");
        printf("\n");

        //문자열 뒤집기
        numstr1rev = _strrev(numstr1);
        numstr2rev = _strrev(numstr2);
        if (op == '+') {
            op_sum(numstr1rev, numstr2rev); //temp값 초기화, *temp값 넣는 이유 = 0제거출력
            for (int i = temp; i >= 0; i--) {
                printf("%c", op_sum(numstr1rev, numstr2rev)[i]);
            }
        }
        else if (op == '-') {
            op_sub(numstr1rev, numstr2rev); //temp값 초기화, *temp값 넣는 이유 = 0제거출력
            for (int i = temp; i >= 0; i--) {
                printf("%c", op_sub(numstr1rev, numstr2rev)[i]);
            }
        }
        else {
            printf("올바른 연산자를 입력해주세요");
        }
        printf("\n");
    }
    return 0;
}
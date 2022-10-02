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
        temp = (int)numstr1rev[i]-48 + (int)numstr2rev[i]-48 + upper; //-48 <- �ƽ�Ű�ڵ庯ȯ�� ����
        upper = 0;
        if (temp >= 10) {
            temp -= 10;
            upper++;
        }
        
        result[i] = (char)temp+48;
        if (result[i] < '0' || result[i] >'9') { //������Ż�� '0'���� ����
            result[i] = '0';
        }
    }
    
    temp = MAX+1;
    while (result[temp] == '0') { //0�� �ƴѰ��� ���ö����� �ּҰ� --
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
        temp = (int)numstr1rev[i] - 48 - (int)numstr2rev[i] + 48 - upper; //-48 <- �ƽ�Ű�ڵ庯ȯ�� ����
        upper = 0;
        if (temp < 0) {
            temp += 10;
            upper++;
        }

        result[i] = (char)temp + 48;
        if (result[i] < '0' || result[i] >'9') { //������Ż�� '0'���� ����
            result[i] = '0';
        }
    }

    temp = MAX + 1;
    while (result[temp] == '0') { //0�� �ƴѰ��� ���ö����� �ּҰ� --
        temp--;
    }
    //for (int i = temp; i >= 0; i--) {
    //    printf("%c", result[i]);
    //}
    return result;
}
char* op_pow(char* numstr1rev, char* numstr2rev) {//-48
    int result[MAX * 2 + 4]; //������ ��������־� ���������� ó��



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
        printf("������ �Է��ϼ���:");
        scanf_s("%s", num1, sizeof(num1));
        sprintf_s(numstr1, sizeof(numstr1), "%0100s", num1); //%0100s MAX 101���� 100ĭ¥��, ����ִ�ĭ 0���� ä��


        printf("�����ڸ� �Է��ϼ���(+, -):");
        scanf_s(" %c", &op);


        printf("������ �Է��ϼ���:");
        scanf_s(" %s", num2, sizeof(num2));
        sprintf_s(numstr2, sizeof(numstr2), "%0100s", num2); //%0100s MAX 101���� 100ĭ¥��, ����ִ�ĭ 0���� ä��
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

        //���ڿ� ������
        numstr1rev = _strrev(numstr1);
        numstr2rev = _strrev(numstr2);
        if (op == '+') {
            op_sum(numstr1rev, numstr2rev); //temp�� �ʱ�ȭ, *temp�� �ִ� ���� = 0�������
            for (int i = temp; i >= 0; i--) {
                printf("%c", op_sum(numstr1rev, numstr2rev)[i]);
            }
        }
        else if (op == '-') {
            op_sub(numstr1rev, numstr2rev); //temp�� �ʱ�ȭ, *temp�� �ִ� ���� = 0�������
            for (int i = temp; i >= 0; i--) {
                printf("%c", op_sub(numstr1rev, numstr2rev)[i]);
            }
        }
        else {
            printf("�ùٸ� �����ڸ� �Է����ּ���");
        }
        printf("\n");
    }
    return 0;
}
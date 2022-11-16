#array is in a0

#size is in a1

#int i,j,key
addi sp, sp, 10000 

 addi a0, x0, 0

 addi t0, x0, 1
 sw t0, 0(a0) 
 addi t0, x0, 5
 sw t0, 4(a0)
 addi t0, x0, 3
 sw t0, 8(a0)
 addi t0, x0, 4
 sw t0, 12(a0)
 addi t0, x0, 10
 sw t0, 16(a0)
 addi t0, x0, 22
 sw t0, 20(a0)
 addi t0, x0, 2
 sw t0, 24(a0)
 addi t0, x0, 3
 sw t0, 28(a0)
 addi t0, x0, 44
 sw t0, 32(a0)

addi a1, x0, 9   # size of 'arr'
sort:
    addi  sp, sp, -40 #5칸 할당(8byte)
    sw   ra, 32(sp)  #리턴어드레스 save
    sw   s6, 24(sp)  #for a0
    sw   s5, 16(sp)  #for a1
    sw   s4, 8(sp)   #outerloop문을 위한 i
    sw   s3, 0(sp)   #innerloop문을 위한 j
    add   s5, zero, a0
    add   s6, zero, a1
    addi   s4, zero, 0       #i(s3) = 0


outer:
    bge  s4, s6, outerexit
    addi s3, s4, -1  #innerloop를 위한 j초기값 할당(j=i-1)
    slli t0, s4, 3
    lw   s2, 0(t0)   #key = list[i] (persist)

inner:
    blt  s3, zero, innerexit   #j<0이면 innerexit으로
    slli t1, s3, 3             #t1 = j*8
    add  t1, s6, t1            #t1 = arr + j*8
    lw   t2, 0(t1)             #t2 = arr[j]
    lw   t3, 8(t1)             #t3 = arr[j+1]
    ble  t2, s2, innerexit     #arr[j] <= key면 innerexit으로
    sw   t3, 0(t1)             #swap
    sw   t2, 8(t1)             #swap


    addi s4, s4, -1  #j = j - 1
    jal inner          #loop


innerexit:

    addi s3, s3, 1   #i++=
    slli t0, s4, 3
    lw   s2, 0(t0)   #key = list[i] (i+1값으로 초기화)
    jal outer          #jump to outer


outerexit:
    lw   s3, 0(sp)   #restore all elements
    lw   s4, 8(sp)
    lw   s5, 16(sp)
    lw   s6, 24(sp)
    lw   ra, 32(sp)
    addi sp, sp, 40  #adjust stack
    ret
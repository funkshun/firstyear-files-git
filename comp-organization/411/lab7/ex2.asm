.data 0x0
.align 2
newline: .asciiz "\n"
buffer: .space 20
.text 0x3000
.globl main
main:
    ori $sp, $0, 0x2ffc
    addi $fp, $sp, -4
    li $s1, 1
read:    
    la $a0, buffer
    li $a1, 20
    li $v0, 8
    
    syscall
    
    jal a_to_i
    
    la $a0, ($v0)
    la $s1, ($a0)
    jal factorial

    la $a0, ($v0)
    li $v0, 1
    syscall
    beq $s1, $0, end
    la $a0, newline
    li $v0, 4
    syscall
    j read
return:
    j end

a_to_i:
    addi $sp, $sp, -8
    sw $ra, 4($sp)
    sw $fp, 0($sp)
    addi $fp, $sp, 4

    la $t0, ($a0)
    
    and $t1, $0, $0
    and $v0, $0, $0
    and $t3, $0, $0
    andi $t4, $0, 10

atoi_loop:
    lb $t2, 0($t0)
    addu $t0, $t0, 1
    beq $t2, 10, rtn_atoi
    mul $v0, $v0, 10
    sub $t2, $t2, '0'
    add $v0, $v0, $t2
  
    j atoi_loop
    
rtn_atoi:
    addi $sp, $fp, 4
    lw $ra, 0($fp)
    lw $fp, -4($fp)
    jr $ra

factorial:
    addi $sp, $sp, -8
    sw $ra, 4($sp)
    sw $fp, 0($sp)
    addi $fp, $sp, 4

    la $t2, ($a0)
    li $t0, 1
fact_loop:
    beq $t2, 0, rtn_fact
    mul $t0, $t0, $t2
    subi $t2, $t2, 1
    j fact_loop
rtn_fact:
    la $v0, ($t0) 
    addi $sp, $fp, 4
    lw $ra, 0($fp)
    lw $fp, -4($fp)
    jr $ra

    

end: 
    li $v0, 10
    syscall

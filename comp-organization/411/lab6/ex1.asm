.data 0x0
magic: .asciiz "P2"
.align 2
buffer: .space 100
newline: .asciiz "\n"
.text 0x3000
main: 
	li $v0, 8   #read in magic number
	la $a0, buffer
	li $a1, 100
	move $s0, $a0
	syscall
	li $v0, 5   #read in width
	syscall
	or $s7, $0, $v0
	li $v0, 5   #read in height
	syscall
	or $s6, $0, $v0
	li $v0, 5   #read in max
	syscall
	or $s5, $0, $v0
	and $t9, $0, $0
	mult $s7, $s6 #find total pixels and store
	mflo $t8
	li $v0, 4
	la $a0, magic
	syscall   #print magic number
	li $v0, 4
    la $a0, newline
    syscall   #newline
	li $v0, 1
	or $a0, $s7, $0
	syscall #print width
	li $v0, 4
    la $a0, newline
    syscall #newline
	li $v0, 1
    or $a0, $s6, $0
	syscall #print height
	li $v0, 4
    la $a0, newline
    syscall #newline
	li $v0, 1
    ori $a0, $0, 255
	syscall #print max
loop:
	beq $t8, $t9, exit
	li $v0, 4
    la $a0, newline
    syscall #newline
	li $v0, 5
	syscall
	or $t1, $v0, $0
	li $v0, 5
	syscall
	or $t2, $v0, $0
	li $v0, 5
	syscall
	or $t3, $v0, $0
	jal average
	li $v0, 1
	or $a0, $t0, $0
	syscall
	#li $v0, 4
    #la $a0, newline
    #syscall
	addi $t9, $t9, 1
	j loop
average:
	li $t4, 30
	mult $t1, $t4
	mflo $t1
	li $t4, 59
	mult $t2, $t4
	mflo $t2
	li $t4, 11
	mult $t3, $t4
	mflo $t3
	add $t0, $t1, $t2
	add $t0, $t0, $t3
	li $t4, 255
	mult $t0, $t4
	mflo $t0
	li $t4, 100
	mult $s5, $t4
	mflo $t4
	div $t0, $t4
	mflo $t0
	jr $ra
	
exit:
	li $v0, 10
	li $a0, 0
	syscall

.data 0x0
magic: .asciiz "P2"
.align 2
buffer: .space 100
newline: .asciiz "\n"
Invalid: .asciiz "Invalid"
.text 0x3000
main: 
	#read in values constants
    #x1
    li $v0, 5   
	syscall
	or $s0, $0, $v0
    #x2
	li $v0, 5   
	syscall
	or $s1, $0, $v0
    #y1
	li $v0, 5   
	syscall
	or $s2, $0, $v0
    #y2
	li $v0, 5   
	syscall
	or $s3, $0, $v0
	#width
	li $v0, 5   
	syscall
	or $s4, $0, $v0
	#heigh
    li $v0, 5   
	syscall
	or $s5, $0, $v0
	#print file header
    #print magic number
    li $v0, 4
	la $a0, magic
	syscall
	#newline
    li $v0, 4
    la $a0, newline
    syscall
    #calculate and print width
	sub $t9, $s1, $s0
    addi $t9, $t9, 1
    li $v0, 1
	or $a0, $t9, $0
	syscall 
	#newline
    li $v0, 4
    la $a0, newline
    syscall
    #calculate and print height
	sub $t9, $s3, $s2
    addi $t9, $t9, 1
    li $v0, 1
    or $a0, $t9, $0
	syscall
    #newline
	li $v0, 4
    la $a0, newline
    syscall
	#print max
    li $v0, 1
    ori $a0, $0, 255
	syscall #print max
	li $v0, 4
    la $a0, newline
    syscall
    #find number of pixels
    mult $s4, $s5
    mflo $s7
    #initialize counters
    or $t1, $0, $0
    or $t2, $0, $0
    ori $t8, $0, 1
loopInner:
	beq $t2, $s4, loopOuter
#    li $v0, 4
#    la $a0, newline
#    syscall 
	
    li $v0, 5
	syscall
	or $t0, $v0, $0
    bgt $t2, $s1, invalid
    blt $t2, $s0, invalid
    bgt $t1, $s3, invalid
    blt $t1, $s2, invalid
    li $v0, 1
    or $a0, $t0, $0
    syscall
    li $v0, 4
    la $a0, newline
    syscall 
    addi $t2, $t2, 1
    j loopInner
invalid: 
    addi $t2, $t2, 1
    j loopInner
    

loopOuter:
    beq $t1, $s5, exit
    and $t2, $0, $0
    addi $t1, $t1, 1
    j loopInner

exit:
	li $v0, 10
	li $a0, 0
	syscall

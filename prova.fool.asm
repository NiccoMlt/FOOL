push 0
push 5
push 4
mult
push 3
div
push function0
lfp
push 8
push -2
lfp
add
lw
lfp
push -3
lfp
add
lw
js
push 1
beq label4
push 10
b label5
label4: 
push 0
label5: 
print
halt

function0:
cfp
lra
push 2
lfp
add
lw
push 2
push -2
lfp
add
lw
push -2
lfp
lw
add
lw
bleq label2
push 0
b label3
label2: 
push 1
label3: 
push 1
add
beq label0
push 0
b label1
label0: 
push 1
label1: 
srv
pop
sra
pop
pop
pop
sfp
lrv
lra
js

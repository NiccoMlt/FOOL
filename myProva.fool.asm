push 0
push 1
push function0
push -2
lfp
add
lw
print
halt

function0:
cfp
lra
push 2
lfp
add
lw
push 1
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
push 0
add
bleq label0
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

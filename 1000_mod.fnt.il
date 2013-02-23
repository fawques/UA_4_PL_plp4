.assembly extern mscorlib {}
.assembly '1000_mod.fnt' {}
.class 'Single' extends [mscorlib]System.Object 
{
.method static public void main () cil managed 
{
.locals()
.entrypoint
.maxstack 1000
ldc.i4 3
ldc.i4 2
add
ldc.i4 5
sub
ldc.i4 0
cgt
call void [mscorlib]System.Console::WriteLine(bool)

ldc.i4 3
ldc.i4 2
mul
ldc.i4 5
add
ldc.i4 6
ceq
ldc.i4 1
xor
call void [mscorlib]System.Console::WriteLine(bool)

ldc.i4 3
ldc.i4 2
mul
ldc.i4 3
ldc.i4 5
mul
add
ldc.i4 3
sub
ldc.i4 0
cgt
ldc.i4 3
ldc.i4 2
add
ldc.i4 5
sub
ldc.i4 0
cgt
add
ldc.i4 0
ceq
ldc.i4 1
xor
call void [mscorlib]System.Console::WriteLine(bool)


 ret
}
}
